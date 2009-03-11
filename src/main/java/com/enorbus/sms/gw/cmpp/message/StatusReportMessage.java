package com.enorbus.sms.gw.cmpp.message;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author shiwang
 * @version $Id: StatusReportMessage.java 1994 2009-02-04 06:19:09Z shishuo.wang $
 *
 */
public class StatusReportMessage extends AbstractMessage {

	/**
	 * ��Ϣ��ʶ��SP�ύ���ţ�CMPP_SUBMIT������ʱ����SP������ISMG������Msg_Id��
	 * 8	Unsigned Integer
	 */
	private byte[] msgId;
	
	// ����DELIVER_RESP��Ϣ��msgId
	private byte[] deliverMsgId;
	
	// ���ڱ�����log�е�msgId�ַ���
	private String msgIdStr;
	
	/**
	 * ���Ͷ��ŵ�Ӧ���������������һ��SP���ݸ��ֶ�ȷ��CMPP_SUBMIT��Ϣ�Ĵ���״̬��
	 * 7   Octet String
	 */
	private String stat;
	
	/**
	 * YYMMDDHHMM��YYΪ��ĺ���λ00-99��MM��01-12��DD��01-31��HH��00-23��MM��00-59����
	 * 10   Octet String
	 */
	private String submitTime;
	
	/**
	 * YYMMDDHHMM��YYΪ��ĺ���λ00-99��MM��01-12��DD��01-31��HH��00-23��MM��00-59����
	 * 10   Octet String
	 */
	private String doneTime;
	
	/**
	 * Ŀ���ն�MSISDN����(SP����CMPP_SUBMIT��Ϣ��Ŀ���ն�)��
	 * 32   Octet String
	 */
	private String destTerminalId;
	
	/**
	 * ȡ��SMSC����״̬�������Ϣ���е���Ϣ��ʶ��
	 * 4   Unsigned Integer
	 */
	private int smscSequence;

	public byte[] getDeliverMsgId() {
		return deliverMsgId;
	}

	public void setDeliverMsgId(byte[] deliverMsgId) {
		this.deliverMsgId = deliverMsgId;
	}

	public byte[] getMsgId() {
		return msgId;
	}

	public void setMsgId(byte[] msgId) {
		this.msgId = msgId;
	}

	public String getMsgIdStr() {
		return msgIdStr;
	}

	public void setMsgIdStr(String msgIdStr) {
		this.msgIdStr = msgIdStr;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String getDoneTime() {
		return doneTime;
	}

	public void setDoneTime(String doneTime) {
		this.doneTime = doneTime;
	}

	public String getDestTerminalId() {
		return destTerminalId;
	}

	public void setDestTerminalId(String destTerminalId) {
		this.destTerminalId = destTerminalId;
	}

	public int getSmscSequence() {
		return smscSequence;
	}

	public void setSmscSequence(int smscSequence) {
		this.smscSequence = smscSequence;
	}

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
