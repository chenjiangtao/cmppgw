package com.enorbus.sms.gw.cmpp.processor;

import org.apache.mina.core.session.IoSession;
import com.enorbus.sms.gw.cmpp.util.Counter;
import com.enorbus.sms.gw.cmpp.message.QueryRespMessage;
import com.enorbus.sms.gw.cmpp.message.CancelRespMessage;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Long Zhi
 * @version $Id: Processor.java 2205 2009-03-03 10:00:41Z zhi.long $
 */
public interface Processor {
    /**
     * ��¼CMPP����
     * @param session
     */
    void doLogin(IoSession session);
    
    /**
     * ��Ӧ��¼Ӧ��
     */
    void onLoginResp(IoSession session, Object message);

    /**
     * ע����¼
     * @param session
     */
    void doLogout(IoSession session);

    /**
     * ע����¼��������session��
     */
    boolean doLogout();

    /**
     * ��Ӧע����Ϣ
     * @param session
     * @param message
     */    
    void onLogout(IoSession session, Object message);
    
    /**
     * ��Ӧע����¼Ӧ��
     */
    void onLogoutResp(IoSession session, Object message);

    /**
     * ��Ӧdeliver��Ϣ
     */
    void onDeliver(IoSession session, Object message);

    /**
     * ��Ӧ״̬������Ϣ
     */
    void onStatusReport(IoSession session, Object message);

    /**
     * ��Ӧ�·�Ӧ��
     */
    void onSubmitResp(IoSession session, Object message);
    
    /**
     * ��ISMG��ѯĳʱ���ҵ��ͳ����������԰�������ҵ������ѯ
     */
    QueryRespMessage doQuery(String time, String queryCode);
    
    /**
     * �����ѯӦ��
     */
    void onQueryResp(IoSession session, Object message);
    
    /**
     * ɾ���Ѿ��ύ��ISMG�Ķ���
     */
    CancelRespMessage doCancel(String msgId);

    /**
     * �����ѯӦ��
     */
    void onCancelResp(IoSession session, Object message);

    /**
     * ά������
     */
    void doKeepAlive(IoSession session);

    /**
     * ά������Ӧ��
     * @param session
     */
    void onKeepAlive(IoSession session, Object message);

    /**
     * ����ά������Ӧ��
     */
    void onKeepAliveResp(IoSession session, Object message);

    /**
     * ����Session
     * @param session
     */
    void onSessionClosed(IoSession session);

    /**
     * ȡ��Session������
     * @return session������
     */
    Counter getSessionCounter();

    /**
     * ע��Session
     * @param session ��ע��sessionʵ��
     */
    void registerSession(IoSession session);

    /**
     * ע��Session
     * @param session ��ע��sessionʵ��
     */
    void unregisterSession(IoSession session);
}
