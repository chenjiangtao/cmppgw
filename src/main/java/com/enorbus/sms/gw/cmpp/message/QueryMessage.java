package com.enorbus.sms.gw.cmpp.message;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * CMPP_QUERY������Ŀ����SP��ISMG��ѯĳʱ���ҵ��ͳ�������
 * ���԰�������ҵ������ѯ��ISMG��CMPP_QUERY_RESPӦ��
 *
 * @author Long Zhi
 * @version $Id: QueryMessage.java 1984 2009-01-22 06:01:35Z zhi.long $
 */
public class QueryMessage extends AbstractMessage {
    /**
     * ʱ��YYYYMMDD(��ȷ����)��
     * 8	Octet String
     */
    private String time;

    /**
     * ��ѯ���0��������ѯ��1����ҵ�����Ͳ�ѯ��
     * 1	Unsigned Integer
     */
    private byte queryType;

    /**
     * ��ѯ�롣��Query_TypeΪ0ʱ��������Ч����Query_TypeΪ1ʱ��������дҵ������Service_Id.��
     * 10	Octet String
     */
    private String queryCode;

    /**
     * ������
     * 8	Octet String	
     */
    private String reserve;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public byte getQueryType() {
        return queryType;
    }

    public void setQueryType(byte queryType) {
        this.queryType = queryType;
    }

    public String getQueryCode() {
        return queryCode;
    }

    public void setQueryCode(String queryCode) {
        this.queryCode = queryCode;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
