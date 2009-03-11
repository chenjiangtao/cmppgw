package com.enorbus.sms.gw.cmpp.processor;

import com.enorbus.sms.gw.cmpp.Constants;
import com.enorbus.sms.gw.cmpp.handler.*;
import com.enorbus.sms.gw.cmpp.message.ConnectRespMessage;
import com.enorbus.sms.gw.cmpp.message.TerminateMessage;
import com.enorbus.sms.gw.cmpp.support.Config;
import com.enorbus.sms.gw.cmpp.util.Counter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Long Zhi
 * @version $Id: AbstractPocessor.java 2205 2009-03-03 10:00:41Z zhi.long $
 */
public abstract class AbstractPocessor implements Processor {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected final Set<IoSession> sessions = Collections.synchronizedSet(new HashSet<IoSession>());
    
    /** ��ЧSession������������ע����¼ */
    private Counter sessionCounter;

    protected AbstractPocessor() {
        this.sessionCounter = new Counter();
    }

    public Counter getSessionCounter() {
        return sessionCounter;
    }

    public void doLogin(IoSession session) {
        ConnectRequest connectReq = new ConnectRequest(session, getLoginMode());
        session.setAttribute(Constants.CONNECT_REQ_ATTR_KEY, connectReq);
        connectReq.start();        
    }

    public void onLoginResp(IoSession session, Object message) {
        ConnectRequest connectReq = (ConnectRequest) session.getAttribute(Constants.CONNECT_REQ_ATTR_KEY);

        // ���Ӧ�����Ƿ���ȷ
        ConnectRespMessage rm = (ConnectRespMessage) message;
        byte[] st = new byte[]{(byte)(rm.getStatus()&0x000000FF)};
        byte[] as = (byte[]) session.getAttribute(Constants.AUTHSOURCE_ATTR_KEY);
        session.removeAttribute(Constants.AUTHSOURCE_ATTR_KEY);
        byte[] sharedSecret = Config.getInstance().getSharedSecret().getBytes();

        byte[] ai = new byte[st.length + as.length + sharedSecret.length];
        System.arraycopy(st, 0, ai, 0, st.length);
        System.arraycopy(as, 0, ai, st.length, as.length);
        System.arraycopy(sharedSecret, 0, ai, st.length+as.length, sharedSecret.length);

        if (rm.getStatus()==0){// Arrays.equals(rm.getAuthenticatorIsmg(), MiscUtils.md5(ai))) {
            logger.info("Login successfully.");
            sessionCounter.increase();
            // ֻ����֤�ɹ���֪ͨ��¼�ɹ��������������CONNECT��Ϣ
            connectReq.respReceived();

            session.removeAttribute(Constants.CONNECT_REQ_ATTR_KEY);

            // ��Session��������ע���session
            registerSession(session);
            
            onLoginSuccessfully();
        } else {
            logger.error("Login failed.");
        }
    }

    /**
     * ��¼�ɹ������ӷ������Ա����������⴦��
     */
    protected abstract void onLoginSuccessfully(); 

    public void doLogout(IoSession session) {
        TerminateRequest termReq = new TerminateRequest(session);
        termReq.start();
    }

    public boolean doLogout() {
        for (IoSession session : sessions) {
            doLogout(session);
        }

        // �ȴ���ֹ����Ӧ��
        boolean result = false;
        try {
            result = sessionCounter.await(5000);
        } catch (InterruptedException ignored) {}

        return result;
    }

    public void onLogout(IoSession session, Object message) {
        unregisterSession(session);
        this.sessionCounter.decrease();
        TerminateResponse termResponse = new TerminateResponse(session, ((TerminateMessage) message).getHeader().getSequenceId());
        termResponse.start();
    }

    public void onLogoutResp(IoSession session, Object message) {
        // ��ʶ��session�Ѿ���ISMGע��
        session.setAttribute(Constants.TERMINATE_REQ_ATTR_KEY, true);
        unregisterSession(session);
        this.sessionCounter.decrease();
    }

    /**
     * ��ȡ��¼ģʽ����������versionΪ1��ʾMO�������ӣ�0��ʾMT��������
     * ���������޵�¼ģʽ��ֱ�Ӱ���Э��ʹ�ð汾��
     * @return ��¼ģʽ
     */
    protected abstract byte getLoginMode();

    public void onSessionClosed(IoSession session) {
        unregisterSession(session);
        this.sessionCounter.decrease();
    }
    
    public void registerSession(IoSession session) {
        sessions.add(session);
    }

    public void unregisterSession(IoSession session) {
        sessions.remove(session);
    }
}
