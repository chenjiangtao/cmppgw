package com.enorbus.sms.gw.cmpp.message;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * CMPP_CONNECT�������Ӧ��Ϣ
 *
 * @author Long Zhi
 * @version $Id: ConnectRespMessage.java 1984 2009-01-22 06:01:35Z zhi.long $
 */
public class ConnectRespMessage extends AbstractMessage {
    /**
     * ״̬��0����ȷ 1����Ϣ�ṹ�� 2���Ƿ�Դ��ַ 3����֤�� 4���汾̫�� 5~ ����������
     * 4	Unsigned Integer
     */
    private int status;

    /**
     * ISMG��֤�룬���ڼ���ISMG��
     * ��ֵͨ������MD5 hash����ó�����ʾ���£�
     * AuthenticatorISMG = MD5��Status+AuthenticatorSource+shared secret����
     * Shared secret ���й��ƶ���Դ��ַʵ�������̶���AuthenticatorSourceΪԴ��ַʵ�巢�͸�ISMG�Ķ�Ӧ��ϢCMPP_Connect�е�ֵ��
     * ��֤����ʱ������Ϊ�ա�
     * 16�ֽ� Octet String
     */
    private byte[] authenticatorIsmg;

    /**
     * ������֧�ֵ���߰汾�ţ�����3.0�İ汾����4bitΪ3����4λΪ0
     * 1�ֽ� Unsigned Integer
     */
    private byte version;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public byte[] getAuthenticatorIsmg() {
        return authenticatorIsmg;
    }

    public void setAuthenticatorIsmg(byte[] authenticatorIsmg) {
        this.authenticatorIsmg = authenticatorIsmg;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
