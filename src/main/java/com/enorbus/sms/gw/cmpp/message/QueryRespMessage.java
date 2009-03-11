package com.enorbus.sms.gw.cmpp.message;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * CMPP_QUERY����Ӧ��Ϣ
 *
 * @author Long Zhi
 * @version $Id: QueryRespMessage.java 1998 2009-02-05 06:00:03Z shishuo.wang $
 */
public class QueryRespMessage extends AbstractMessage {
    /**
     * ʱ��(��ȷ����)��
     * 8	Octet String
     */
    private String time;

    /**
     * ��ѯ���0��������ѯ��1����ҵ�����Ͳ�ѯ��
     * 1	Unsigned Integer	
     */
    private int queryType;

    /**
     * ��ѯ�롣
     * 10	Octet String
     */
    private String queryCode;

    /**
     * ��SP������Ϣ������
     * 4	Unsigned Integer
     */
     private int mtTlMsg;

    /**
     * ��SP�����û�������
     * 4	Unsigned Integer
     */
    private int mtTlUsr;

    /**
     * �ɹ�ת��������
     * 4	Unsigned Integer
     */
    private int mtScs;

    /**
     * ��ת��������
     * 4	Unsigned Integer
     */
    private int mtWt;

    /**
     * ת��ʧ��������
     * 4	Unsigned Integer
     */
    private int mtFl;

    /**
     * ��SP�ɹ��ʹ�������
     * 4	Unsigned Integer
     */
    private int moScs;

    /**
     * ��SP���ʹ�������
     * 4	Unsigned Integer
     */
    private int moWt;

    /**
     * ��SP�ʹ�ʧ��������
     * 4	Unsigned Integer
     */
    private int moFl;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getQueryType() {
        return queryType;
    }

    public void setQueryType(int queryType) {
        this.queryType = queryType;
    }

    public String getQueryCode() {
        return queryCode;
    }

    public void setQueryCode(String queryCode) {
        this.queryCode = queryCode;
    }

    public int getMtTlMsg() {
        return mtTlMsg;
    }

    public void setMtTlMsg(int mtTlMsg) {
        this.mtTlMsg = mtTlMsg;
    }

    public int getMtTlUsr() {
        return mtTlUsr;
    }

    public void setMtTlUsr(int mtTlUsr) {
        this.mtTlUsr = mtTlUsr;
    }

    public int getMtScs() {
        return mtScs;
    }

    public void setMtScs(int mtScs) {
        this.mtScs = mtScs;
    }

    public int getMtWt() {
        return mtWt;
    }

    public void setMtWt(int mtWt) {
        this.mtWt = mtWt;
    }

    public int getMtFl() {
        return mtFl;
    }

    public void setMtFl(int mtFl) {
        this.mtFl = mtFl;
    }

    public int getMoScs() {
        return moScs;
    }

    public void setMoScs(int moScs) {
        this.moScs = moScs;
    }

    public int getMoWt() {
        return moWt;
    }

    public void setMoWt(int moWt) {
        this.moWt = moWt;
    }

    public int getMoFl() {
        return moFl;
    }

    public void setMoFl(int moFl) {
        this.moFl = moFl;
    }

    public String toString() {
    	StringBuffer b = new StringBuffer();
        b.append(this.time).append(",")
         .append(this.queryType).append(",")
         .append(this.queryCode).append(",")
         .append(this.mtTlMsg).append(",")
         .append(this.mtTlUsr).append(",")
         .append(this.mtScs).append(",")
         .append(this.mtWt).append(",")
         .append(this.mtFl).append(",")
         .append(this.moScs).append(",")
         .append(this.moWt).append(",")
         .append(this.moFl);
        return b.toString();
    }    
}
