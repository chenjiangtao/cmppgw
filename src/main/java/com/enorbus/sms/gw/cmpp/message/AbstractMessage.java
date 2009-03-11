package com.enorbus.sms.gw.cmpp.message;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * ��Ϣ������࣬������Ϣ��Ӧ�̳д���
 *
 * @author Long Zhi
 * @version $Id: AbstractMessage.java 1984 2009-01-22 06:01:35Z zhi.long $
 */
public abstract class AbstractMessage implements Serializable {
    private MessageHeader header;

    public MessageHeader getHeader() {
        return header;
    }

    public void setHeader(MessageHeader header) {
        this.header = header;
    }

    public abstract String toString();
}
