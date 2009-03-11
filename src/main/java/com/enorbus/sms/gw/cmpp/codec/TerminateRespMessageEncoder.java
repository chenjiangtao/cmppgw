package com.enorbus.sms.gw.cmpp.codec;

import com.enorbus.sms.gw.cmpp.message.TerminateRespMessage;
import com.enorbus.sms.gw.cmpp.Constants;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.buffer.IoBuffer;

/**
 * ��ֹ������Ӧ��Ϣ������
 *
 * @author Long Zhi
 * @version $Id: TerminateRespMessageEncoder.java 1983 2009-01-22 03:56:46Z zhi.long $
 */
public class TerminateRespMessageEncoder<T extends TerminateRespMessage> extends AbstractMessageEncoder<T> {
    public TerminateRespMessageEncoder() {
        super(Constants.CMD_CMPP_TERMINATE_RESP);
    }

    protected void encodeBody(IoSession session, T message, IoBuffer out) {
        // ����Ϣ��        
    }
}
