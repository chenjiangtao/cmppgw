package com.enorbus.sms.gw.cmpp.message;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * CMPP_CONNECT������Ŀ����SP��ISMGע����Ϊһ���Ϸ�SP��ݣ�
 * ��ע��ɹ��󼴽�����Ӧ�ò�����ӣ��˺�SP����ͨ����ISMG���պͷ��Ͷ��š�
 * ISMG��CMPP_CONNECT_RESP��Ϣ��ӦSP������
 *
 * @author Long Zhi
 * @version $Id: ConnectMessage.java 1984 2009-01-22 06:01:35Z zhi.long $
 */
public class ConnectMessage extends AbstractMessage {
    /**
     * Դ��ַ���˴�ΪSP_Id����SP����ҵ���롣
     * 6	Octet String
     */
    private String sourceAddr;

    /**
     * ���ڼ���Դ��ַ����ֵͨ������MD5 hash����ó�����ʾ���£�
     * AuthenticatorSource = MD5��Source_Addr+9 �ֽڵ�0 +shared secret+timestamp��
     * Shared secret ���й��ƶ���Դ��ַʵ�������̶���timestamp��ʽΪ��MMDDHHMMSS��������ʱ���룬10λ��
     * 16	Octet String
     */
    private byte[] authenticatorSource;

    /**
     * ˫��Э�̵İ汾��(��λ4bit��ʾ���汾��,��λ4bit��ʾ�ΰ汾��)������3.0�İ汾����4bitΪ3����4λΪ0
     * 1	Unsigned Integer
     */
    private byte version;

    /**
     * ʱ���������,�ɿͻ��˲���,��ʽΪMMDDHHMMSS��������ʱ���룬10λ���ֵ����ͣ��Ҷ���
     * 4	Unsigned Integer
     */
    private int timeStamp;

    public String getSourceAddr() {
        return sourceAddr;
    }

    public void setSourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr;
    }

    public byte[] getAuthenticatorSource() {
        return authenticatorSource;
    }

    public void setAuthenticatorSource(byte[] authenticatorSource) {
        this.authenticatorSource = authenticatorSource;
    }

    public byte getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
