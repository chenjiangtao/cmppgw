package com.enorbus.sms.gw.cmpp.mq;

import java.util.List;

import com.enorbus.sms.gw.cmpp.message.DeliverMessage;
import com.enorbus.sms.gw.cmpp.message.SubmitMessage;

/**
 * ��Ϣ����ִ����������MO��queue��MT��queue�Ȳ���
 *
 * @author Long Zhi
 * @version $Id: MessageQueueExecutor.java 2055 2009-02-12 10:00:49Z jinxue.liu $
 */
public interface MessageQueueExecutor {
    /**
     * MO��Quque
     * @param msg MO��Ϣ
     * @return t_moq_in�ķ���ֵ
     */
    int enqueue(DeliverMessage msg);

    /**
     * MT��Queue
     * @return SubmitMessage �·���Ϣ
     */
    public List<SubmitMessage> dequeue();
    
}
