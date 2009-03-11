package com.enorbus.sms.gw.cmpp.message;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * CMPP_SUBMIT����Ӧ��Ϣ
 *
 * @author Long Zhi
 * @version $Id: SubmitRespMessage.java 1994 2009-02-04 06:19:09Z shishuo.wang $
 */
public class SubmitRespMessage extends AbstractMessage {
    /**
     * ��Ϣ��ʶ�������㷨���£�
     * ����64λ��8�ֽڣ���������
     *  ��1��	ʱ�䣨��ʽΪMMDDHHMMSS��������ʱ���룩��bit64~bit39������
     *   bit64~bit61���·ݵĶ����Ʊ�ʾ��
     *   bit60~bit56���յĶ����Ʊ�ʾ��
     *   bit55~bit51��Сʱ�Ķ����Ʊ�ʾ��
     *   bit50~bit45���ֵĶ����Ʊ�ʾ��
     *   bit44~bit39����Ķ����Ʊ�ʾ��
     *  ��2��	�������ش��룺bit38~bit17���Ѷ������صĴ���ת��Ϊ������д�����ֶ��У�
     *  ��3��	���кţ�bit16~bit1��˳�����ӣ�����Ϊ1��ѭ��ʹ�á�
     *   �������粻�����������㣬�Ҷ��롣
     *  ��SP���������Ӧ����Ϣ��Sequence_Idһ���ԾͿɵõ�CMPP_Submit��Ϣ��Msg_Id��
     * 8	Unsigned Integer
     */
    private byte[] msgId;
    
    private String msgIdStr;

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
     * 8���������ƴ�
     * 9�������ز��������˼ƷѺ��룻
     * 10��Src_Id����
     * 11��Msg_src����
     * 12��Fee_terminal_Id����
     * 13��Dest_terminal_Id����
     * ����
     * 4	Unsigned Integer
     */
    private int result;

    public String getMsgIdStr() {
		return msgIdStr;
	}

	public void setMsgIdStr(String msgIdStr) {
		this.msgIdStr = msgIdStr;
	}

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
