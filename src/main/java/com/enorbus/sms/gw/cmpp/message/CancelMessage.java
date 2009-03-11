package com.enorbus.sms.gw.cmpp.message;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * CMPP_CANCEL������Ŀ����SPͨ���˲������Խ��Ѿ��ύ��ISMG�Ķ���ɾ����
 * ISMG����CMPP_CANCEL_RESP��Ӧɾ�������Ľ����
 *
 * @author Long Zhi
 * @version $Id: CancelMessage.java 1998 2009-02-05 06:00:03Z shishuo.wang $
 */
public class CancelMessage extends AbstractMessage {
    /**
     * ��Ϣ��ʶ��SP��Ҫɾ������Ϣ��ʶ����
     * 8	Unsigned Integer
     */
    private String msgIdStr;
    
    public String getMsgIdStr() {
        return msgIdStr;
    }

    public void setMsgIdStr(String msgIdStr) {
        this.msgIdStr = msgIdStr;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
