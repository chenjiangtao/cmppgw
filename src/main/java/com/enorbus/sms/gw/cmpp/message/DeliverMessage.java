package com.enorbus.sms.gw.cmpp.message;

import java.sql.Timestamp;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * CMPP_DELIVER������Ŀ����ISMG�ѴӶ������Ļ�����ISMGת�����Ķ����ͽ�SP��
 * SP��CMPP_DELIVER_RESP��Ϣ��Ӧ��
 *
 * @author Long Zhi
 * @version $Id: DeliverMessage.java 1994 2009-02-04 06:19:09Z shishuo.wang $
 */
public class DeliverMessage extends AbstractMessage {
	
	/**
	 * �������
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
	 */
	private int errorCode = 0;
	
    public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
     * ��Ϣ��ʶ��
     * �����㷨���£�
     * ����64λ��8�ֽڣ���������
     * ��1��	ʱ�䣨��ʽΪMMDDHHMMSS��������ʱ���룩��bit64~bit39������
     * bit64~bit61���·ݵĶ����Ʊ�ʾ��
     * bit60~bit56���յĶ����Ʊ�ʾ��
     * bit55~bit51��Сʱ�Ķ����Ʊ�ʾ��
     * bit50~bit45���ֵĶ����Ʊ�ʾ��
     * bit44~bit39����Ķ����Ʊ�ʾ��
     * ��2��	�������ش��룺bit38~bit17���Ѷ������صĴ���ת��Ϊ������д�����ֶ��У�
     * ��3��	���кţ�bit16~bit1��˳�����ӣ�����Ϊ1��ѭ��ʹ�á�
     * �������粻�����������㣬�Ҷ��롣
     * 8	Unsigned Integer
     */
    private byte[] msgId;
    
    // ���ڱ�����log�е�msgId�ַ���
    private String msgIdStr;

    public String getMsgIdStr() {
		return msgIdStr;
	}

	public void setMsgIdStr(String msgIdStr) {
		this.msgIdStr = msgIdStr;
	}

	/**
     * Ŀ�ĺ��롣
     * SP�ķ�����룬������ǰ׺Ϊ�������ĳ����룻�ú������ֻ��û�����Ϣ�ı��к��롣
     * 21	Octet String
     */
    private String destId;

    /**
     * ҵ���ʶ�������֡���ĸ�ͷ��ŵ���ϡ�
     * 10	Octet String
     */
    private String serviceId;

    /**
     * GSMЭ�����͡���ϸ������ο�GSM03.40�е�9.2.3.9��
     * 1	Unsigned Integer
     */
    private int tpPid;

    /**
     * GSMЭ�����͡���ϸ������ο�GSM03.40�е�9.2.3.23����ʹ��1λ���Ҷ��롣
     * 1	Unsigned Integer
     */
    private int tpUdhi;

    /**
     * ��Ϣ��ʽ��0��ASCII����3������д��������4����������Ϣ��8��UCS2���룻15����GB���֡�
     * 1	Unsigned Integer
     */
    private int msgFmt;

    /**
     * Դ�ն�MSISDN���루״̬����ʱ��ΪCMPP_SUBMIT��Ϣ��Ŀ���ն˺��룩��
     * 32	Octet String
     */
    private String srcTerminalId;

    /**
     * Դ�ն˺������ͣ�0����ʵ���룻1��α�롣
     * 1	Unsigned Integer
     */
    private int srcTerminalType;

    /**
     * �Ƿ�Ϊ״̬���棺0����״̬���棻1��״̬���档
     * 1	Unsigned Integer
     */
    private int registeredDelivery;

    /**
     * ��Ϣ���ȣ�ȡֵ���ڻ����0��
     * 1	Unsigned Integer
     */
    private int msgLength;

    /**
     * ��Ϣ���ݡ�
     * Msg_length	Octet String
     */
    private String msgContent;

    /**
     * �㲥ҵ��ʹ�õ�LinkID���ǵ㲥��ҵ���MT���̲�ʹ�ø��ֶΡ�
     * 20	Octet String
     */
    private String linkId;
    
    private String spId;
    
    
    private int gwId;
    
    private Timestamp regDate;

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public int getGwId() {
		return gwId;
	}

	public void setGwId(int gwId) {
		this.gwId = gwId;
	}

	public byte[] getMsgId() {
        return msgId;
    }

    public void setMsgId(byte[] msgId) {
        this.msgId = msgId;
    }

    public String getDestId() {
        return destId;
    }

    public void setDestId(String destId) {
        this.destId = destId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
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

    public String getSrcTerminalId() {
        return srcTerminalId;
    }

    public void setSrcTerminalId(String srcTerminalId) {
        this.srcTerminalId = srcTerminalId;
    }

    public int getSrcTerminalType() {
        return srcTerminalType;
    }

    public void setSrcTerminalType(int srcTerminalType) {
        this.srcTerminalType = srcTerminalType;
    }

    public int getRegisteredDelivery() {
        return registeredDelivery;
    }

    public void setRegisteredDelivery(int registeredDelivery) {
        this.registeredDelivery = registeredDelivery;
    }

    public int getMsgLength() {
        return msgLength;
    }

    public void setMsgLength(int msgLength) {
        this.msgLength = msgLength;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }    
}
