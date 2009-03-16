package com.enorbus.sms.gw.cmpp.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enorbus.sms.gw.cmpp.support.Config;

/**
 * ����������Ϣ�������̣߳���δ�յ���Ӧ��Ϣʱ����ʱ���Լ��Σ�
 * ����δ�յ���Ӧ��ر����ӡ�
 * �յ���Ӧ��Ϣʱ����respReceived()���������̡߳�
 * 
 * ����ֻ��ʵ��request()����������ʵ�ʷ�������Ķ������ɡ�
 * 
 * @author shiwang
 * @version $Id: RequestThread.java 2035 2009-02-10 09:09:42Z shishuo.wang $
 */
public abstract class RequestThread extends Thread {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private Boolean stop = false;
	
	protected boolean unlimitedRetry = false;
	
	private int maxRetry = Config.getInstance().getTransportMaxRetry();
	private int timeout = Config.getInstance().getTransportTimeout();

	protected void setMaxRetry(int maxRetry) {
		this.maxRetry = maxRetry;
	}

	protected void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void run() {
		for (int i=0; !Thread.currentThread().isInterrupted() && !this.stop && (unlimitedRetry || i<maxRetry); i++) {
			request();
	        try {
				Thread.sleep(timeout*1000);
			} catch (InterruptedException e) {
				System.out.println("interrupt sleep: " + e.getMessage());
			}
		}
		synchronized (this.stop) {
			if (!stop) {
				this.noResp();
				stop = true;
			}
		}
	}
	
	/**
	 * ֪ͨ�Ѿ����յ���Ӧ��Ϣ���������߳�
	 * @return
	 */
	public boolean respReceived() {
        synchronized (this.stop) {
        	System.out.println("call respReceived");
			if (!stop) {
				this.stop = true;
		        interrupt();
				return true;
			}
	        interrupt();
			return false;
		}
    }

	protected abstract void request();
	
	protected void noResp() {}
}
