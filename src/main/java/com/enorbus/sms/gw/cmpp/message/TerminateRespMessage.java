package com.enorbus.sms.gw.cmpp.message;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * CMPP_TERMINATE����Ӧ��Ϣ
 *
 * @author Long Zhi
 * @version $Id: TerminateRespMessage.java 1984 2009-01-22 06:01:35Z zhi.long $
 */
public class TerminateRespMessage extends AbstractMessage {
    // ����Ϣ��

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
