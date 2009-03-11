package com.enorbus.sms.gw.cmpp.message;

import java.sql.Timestamp;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * CMPP_SUBMIT������Ŀ����SP����ISMG����Ӧ�ò����Ӻ���ISMG�ύ���š�
 * ISMG��CMPP_SUBMIT_RESP��Ϣ��Ӧ��
 *
 * @author Long Zhi
 * @version $Id: SubmitMessage.java 2129 2009-02-18 09:29:28Z jinxue.liu $
 */
public class SubmitMessage extends AbstractMessage {
    /**
     * ��Ϣ��ʶ
     * 8	Unsigned Integer
     */
    private long msgId;
    
    

    /**
     * ��ͬMsg_Id����Ϣ����������1��ʼ��
     * 1	Unsigned Integer
     */
    private int pkTotal;

    /**
     * ��ͬMsg_Id����Ϣ��ţ���1��ʼ
     * 1	Unsigned Integer
     */
    private int pkNumber;

    /**
     * �Ƿ�Ҫ�󷵻�״̬ȷ�ϱ��棺0������Ҫ��1����Ҫ
     * 1	Unsigned Integer
     */
    private int registeredDelivery;

    /**
     * ��Ϣ����
     * 1	Unsigned Integer
     */
    private int msgLevel;

    /**
     * ҵ���ʶ�������֡���ĸ�ͷ��ŵ���ϡ�
     * 10	Octet String
     */
    private String serviceId;

    /**
     * �Ʒ��û������ֶΣ�
     * 0����Ŀ���ն�MSISDN�Ʒѣ�
     * 1����Դ�ն�MSISDN�Ʒѣ�
     * 2����SP�Ʒѣ�
     * 3����ʾ���ֶ���Ч����˭�ƷѲμ�Fee_terminal_Id�ֶΡ�
     * 1	Unsigned Integer
     */
    private int feeUserType;

    /**
     * ���Ʒ��û��ĺ��룬��Fee_UserTypeΪ3ʱ��ֵ��Ч����Fee_UserTypeΪ0��1��2ʱ��ֵ�����塣
     * 32	Octet String
     */
    private String feeTerminalId;

    /**
     * ���Ʒ��û��ĺ������ͣ�0����ʵ���룻1��α�롣
     * 1	Unsigned Integer
     */
    private int feeTerminalType;

    /**
     * GSMЭ�����͡���ϸ�ǽ�����ο�GSM03.40�е�9.2.3.9��
     * 1	Unsigned Integer
     */
    private int tpPid;

    /**
     * GSMЭ�����͡���ϸ�ǽ�����ο�GSM03.40�е�9.2.3.23,��ʹ��1λ���Ҷ��롣
     * 1	Unsigned Integer
     */
    private int tpUdhi;

    /**
     * ��Ϣ��ʽ��0��ASCII����3������д��������4����������Ϣ��8��UCS2���룻15����GB���֡�����������
     * 1	Unsigned Integer
     */
    private int msgFmt;

    /**
     * ��Ϣ������Դ(SP_Id)
     * 6	Octet String
     */
    private String msgSrc;

    /**
     * �ʷ����
     * 01���ԡ��Ʒ��û����롱��ѣ�
     * 02���ԡ��Ʒ��û����롱��������Ϣ�ѣ�
     * 03���ԡ��Ʒ��û����롱��������ȡ��Ϣ�ѡ�
     * 2	Octet String
     */
    private String feeType;

    /**
     * �ʷѣ��Է�Ϊ��λ����
     * 6	Octet String
     */
    private String feeCode;

    /**
     * �����Ч�ڣ���ʽ��ѭSMPP3.3Э�顣
     * 17	Octet String
     */
    private String validTime;

    /**
     * ��ʱ����ʱ�䣬��ʽ��ѭSMPP3.3Э�顣
     * 17	Octet String
     */
    private String atTime;
    
    

    /**
     * Դ���롣SP�ķ�������ǰ׺Ϊ�������ĳ�����,
     * ���ؽ��ú����������SMPPЭ��Submit_SM��Ϣ��Ӧ��source_addr�ֶΣ�
     * �ú����������û��ֻ�����ʾΪ����Ϣ�����к��롣
     * 21	Octet String
     */
    private String srcId;

    /**
     * ������Ϣ���û�����(С��100���û�)��
     * 1	Unsigned Integer
     */
    private int destUsrTl;

    /**
     * ���ն��ŵ�MSISDN���롣
     * 32*DestUsr_tl	Octet String
     */
    private String destTerminalId;

    /**
     * ���ն��ŵ��û��ĺ������ͣ�0����ʵ���룻1��α�롣
     * 1	Unsigned Integer
     */
    private int destTerminalType;

    /**
     * ��Ϣ����(Msg_FmtֵΪ0ʱ��<160���ֽڣ�����<=140���ֽ�)��ȡֵ���ڻ����0��
     * 1	Unsigned Integer
     */
    private int msgLength;

    /**
     * ��Ϣ���ݡ�
     * Msg_length	Octet String
     */
    private byte [] msgContent;



	/**
     * �㲥ҵ��ʹ�õ�LinkID���ǵ㲥��ҵ���MT���̲�ʹ�ø��ֶΡ�
     * 20	Octet String
     */
    
    private String linkId;
    /**
     * MtLog
     * 
     */
    	
  
	
	public byte[] getMsgContent() {
		return msgContent;
	}
	
	public void setMsgContent(byte[] msgContent) {
		this.msgContent = msgContent;
	}
	
	public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public int getPkTotal() {
        return pkTotal;
    }

    public void setPkTotal(int pkTotal) {
        this.pkTotal = pkTotal;
    }

    public int getPkNumber() {
        return pkNumber;
    }

    public void setPkNumber(int pkNumber) {
        this.pkNumber = pkNumber;
    }

    public int getRegisteredDelivery() {
        return registeredDelivery;
    }

    public void setRegisteredDelivery(int registeredDelivery) {
        this.registeredDelivery = registeredDelivery;
    }

    public int getMsgLevel() {
        return msgLevel;
    }

    public void setMsgLevel(int msgLevel) {
        this.msgLevel = msgLevel;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public int getFeeUserType() {
        return feeUserType;
    }

    public void setFeeUserType(int feeUserType) {
        this.feeUserType = feeUserType;
    }

    public String getFeeTerminalId() {
        return feeTerminalId;
    }

    public void setFeeTerminalId(String feeTerminalId) {
        this.feeTerminalId = feeTerminalId;
    }

    public int getFeeTerminalType() {
        return feeTerminalType;
    }

    public void setFeeTerminalType(int feeTerminalType) {
        this.feeTerminalType = feeTerminalType;
    }

    public int getTpPid() {
        return tpPid;
    }

    public void setTpPid(int tpPid) {
        this.tpPid = tpPid;
    }

    public int getTpUdhi() {
        return tpUdhi;
    }

    public void setTpUdhi(int tpUdhi) {
        this.tpUdhi = tpUdhi;
    }

    public int getMsgFmt() {
        return msgFmt;
    }

    public void setMsgFmt(int msgFmt) {
        this.msgFmt = msgFmt;
    }

    public String getMsgSrc() {
        return msgSrc;
    }

    public void setMsgSrc(String msgSrc) {
        this.msgSrc = msgSrc;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getAtTime() {
        return atTime;
    }

    public void setAtTime(String atTime) {
        this.atTime = atTime;
    }

    public String getSrcId() {
        return srcId;
    }

    public void setSrcId(String srcId) {
        this.srcId = srcId;
    }

    public int getDestUsrTl() {
        return destUsrTl;
    }

    public void setDestUsrTl(int destUsrTl) {
        this.destUsrTl = destUsrTl;
    }

    public String getDestTerminalId() {
        return destTerminalId;
    }

    public void setDestTerminalId(String destTerminalId) {
        this.destTerminalId = destTerminalId;
    }

    public int getDestTerminalType() {
        return destTerminalType;
    }

    public void setDestTerminalType(int destTerminalType) {
        this.destTerminalType = destTerminalType;
    }

    public int getMsgLength() {
        return msgLength;
    }

    public void setMsgLength(int msgLength) {
        this.msgLength = msgLength;
    }

    

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
