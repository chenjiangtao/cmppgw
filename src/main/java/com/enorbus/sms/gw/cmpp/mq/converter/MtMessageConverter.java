package com.enorbus.sms.gw.cmpp.mq.converter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * MT��Ϣת������ʵ��POJO��JMS Message֮����໥ת��
 * @author Long Zhi
 */
public class MtMessageConverter implements MessageConverter {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * �Խ��յ���Map��Ϣ����ת��
	 */
	@Override
	public Object fromMessage(Message msg) throws JMSException,
			MessageConversionException {
		// TODO 
		logger.error("Not implement yet!");
		return null;
	}

	/**
	 * �Է��͵���Ϣ����ת��
	 */
	@Override
	public Message toMessage(Object obj, Session session) throws JMSException,
			MessageConversionException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implements yet!");
	}

}
