package com.enorbus.sms.gw.cmpp.codec;

import com.enorbus.sms.gw.cmpp.Constants;
import com.enorbus.sms.gw.cmpp.util.MessageUtil;
import com.enorbus.sms.gw.cmpp.util.MiscUtils;
import com.enorbus.sms.gw.cmpp.message.ConnectMessage;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import java.nio.charset.CharsetEncoder;
import java.nio.charset.Charset;
import java.nio.charset.CharacterCodingException;

/**
 * ����������Ϣ������
 *
 * @author Long Zhi
 * @version $Id: ConnectMessageEncoder.java 2205 2009-03-03 10:00:41Z zhi.long $
 */
public class ConnectMessageEncoder<T extends ConnectMessage> extends AbstractMessageEncoder<T> {
    public ConnectMessageEncoder() {
        super(Constants.CMD_CMPP_CONNECT);
    }

    protected void encodeBody(IoSession session, T message, IoBuffer out) {
        // ȷ��SourceAddrֻռ6���ֽ�
//        byte[] bytesOfSourceAddr = new byte[6];
//        MessageUtil.putString(bytesOfSourceAddr, 0, message.getSourceAddr());
//        out.put(bytesOfSourceAddr);
        try {
            out.putString(message.getSourceAddr(), 6, MiscUtils.toEncoder());
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        out.put(message.getAuthenticatorSource()); // ��Ҫȷ��AuthenticatorSourceֻռ16���ֽ�
        out.put(message.getVersion());
        out.putInt(message.getTimeStamp());
    }
}
