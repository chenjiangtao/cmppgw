package com.enorbus.sms.gw.cmpp.message;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * ��Ϣͷ
 *
 * @author Long Zhi
 * @version $Id: MessageHeader.java 1984 2009-01-22 06:01:35Z zhi.long $
 */
public class MessageHeader {
    /**
     * ��Ϣ�ܳ���(����Ϣͷ����Ϣ��)
     * 4	Unsigned Integer
     */
    private int totalLength;

    /**
     * �������Ӧ����
     * 4	Unsigned Integer
     */
    private int commandId;

    /**
     * ��Ϣ��ˮ��,˳���ۼ�,����Ϊ1,ѭ��ʹ�ã�һ�������Ӧ����Ϣ����ˮ�ű�����ͬ��
     * 4	Unsigned Integer
     */
    private int sequenceId;

    public int getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(int totalLength) {
        this.totalLength = totalLength;
    }

    public int getCommandId() {
        return commandId;
    }

    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
        return new ToStringBuilder(this)
                .append("totalLength", this.totalLength)
                .append("commandId", Integer.toHexString(this.commandId))
                .append("sequenceId", this.sequenceId).toString();
    }
}
