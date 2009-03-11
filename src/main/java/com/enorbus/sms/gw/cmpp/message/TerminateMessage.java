package com.enorbus.sms.gw.cmpp.message;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * CMPP_TERMINATE������Ŀ����SP��ISMG����ĳЩԭ����������ǰ��Ӧ�ò����Ӷ�����Ĳ�����
 * �˲�����ɺ�SP��ISMG֮���Ӧ�ò����ӱ��ͷţ�
 * �˺�SP����Ҫ��ISMGͨ��ʱӦ����CMPP_CONNECT������
 * ISMG��SP��CMPP_TERMINATE_RESP��Ϣ��Ӧ����
 *
 * @author Long Zhi
 * @version $Id: TerminateMessage.java 1984 2009-01-22 06:01:35Z zhi.long $
 */
public class TerminateMessage extends AbstractMessage {
    // ����Ϣ��
    
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
