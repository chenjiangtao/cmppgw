package com.enorbus.sms.gw.cmpp;

/**
 * ��������
 *
 * @author <a href="mailto:zhi.long@enorbus.com.cn">Long Zhi</a>
 * @version $Id: Constants.java 2217 2009-03-05 07:50:20Z shishuo.wang $
 */
public class Constants {
    // �����ʼ��������
    private Constants() {}

    public static final int TOTAL_LENGTH_LEN = 4;

    public static final int COMMAND_ID_LEN = 4;
    
    public static final int SEQUENCE_ID_LEN = 4;

    public static final int HEADER_LEN = TOTAL_LENGTH_LEN + COMMAND_ID_LEN + SEQUENCE_ID_LEN;
    
    /** �������� */
    public static final int CMD_CMPP_CONNECT = 0x00000001;

    /** ��������Ӧ�� */
    public static final int CMD_CMPP_CONNECT_RESP = 0x80000001;

    /** ��ֹ���� */
    public static final int CMD_CMPP_TERMINATE = 0x00000002;

    /** ��ֹ����Ӧ�� */
    public static final int CMD_CMPP_TERMINATE_RESP = 0x80000002;

    /** �ύ���� */
    public static final int CMD_CMPP_SUBMIT = 0x00000004;

    /** �ύ����Ӧ�� */
    public static final int CMD_CMPP_SUBMIT_RESP = 0x80000004;

    /** �����·� */
    public static final int CMD_CMPP_DELIVER = 0x00000005;

    /** �·�����Ӧ�� */
    public static final int CMD_CMPP_DELIVER_RESP = 0x80000005;

    /** ���Ͷ���״̬��ѯ */
    public static final int CMD_CMPP_QUERY = 0x00000006;

    /** ���Ͷ���״̬��ѯӦ�� */
    public static final int CMD_CMPP_QUERY_RESP = 0x80000006;

    /** ɾ������ */
    public static final int CMD_CMPP_CANCEL = 0x00000007;

    /** ɾ������Ӧ�� */
    public static final int CMD_CMPP_CANCEL_RESP = 0x80000007;

    /** ������� */
    public static final int CMD_CMPP_ACTIVE_TEST = 0x00000008;

    /** �������Ӧ�� */
    public static final int CMD_CMPP_ACTIVE_TEST_RESP = 0x80000008;

    /** Э��汾�� */
    public static final byte PROTOCOL_VERSION = 0x30;

    /** MT-ONLY��¼ģʽ */
    public static final byte MT_ONLY_LOGIN_MODE = 0;

    /** MO-ONLY��¼ģʽ */
    public static final byte MO_ONLY_LOGIN_MODE = 1;

    /** BOTH MT AND MO��¼ģʽ����δʹ�� */
    public static final byte BOTH_LOGIN_MODE = PROTOCOL_VERSION;
    
    /** ͨ����Ӧidȡ������id�İ�λ�� */
    public static final int CMD_AND = 0x0000000F;

    /** ��ģʽ */
    public static final int NONE_CONN_MODE = 2;

    public final static String CONNECT_REQ_ATTR_KEY = "connectReq";

    public static final String TERMINATE_REQ_ATTR_KEY = "terminateReq";

    public static final String AUTHSOURCE_ATTR_KEY = "AuthenticatorSource";
    
    public static final String TERMINAL_ID_SPLITTER = ",";
}
