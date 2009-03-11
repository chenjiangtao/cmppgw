package com.enorbus.sms.gw.cmpp.message;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * CMPP_DELIVER����Ӧ��Ϣ
 *
 * @author Long Zhi
 * @version $Id: DeliverRespMessage.java 1994 2009-02-04 06:19:09Z shishuo.wang $
 */
public class DeliverRespMessage extends AbstractMessage {
    /**
     * ��Ϣ��ʶ��CMPP_DELIVER�е�Msg_Id�ֶΣ���
     * 8	Unsigned Integer
     */
    private byte[] msgId;

    /**
     * �����
     * 0����ȷ��
     * 1����Ϣ�ṹ��
     * 2�������ִ�
     * 3����Ϣ����ظ���
     * 4����Ϣ���ȴ�
     * 5���ʷѴ�
     * 6�����������Ϣ����
     * 7��ҵ������
     * 8: �������ƴ�
     * 9~ ����������
     * 4	Unsigned Integer
     */
    private int result;

    public byte[] getMsgId() {
        return msgId;
    }

    public void setMsgId(byte[] msgId) {
        this.msgId = msgId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
