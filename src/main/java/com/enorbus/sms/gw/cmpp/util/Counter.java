package com.enorbus.sms.gw.cmpp.util;

/**
 * ����������
 *
 * @author Long Zhi
 * @version $Id: Counter.java 2205 2009-03-03 10:00:41Z zhi.long $
 */
public class Counter {
    private int count = 0;

    public synchronized void increase() {
        count++;
    }

    public synchronized void decrease() {
        count--;
        notifyAll();
    }

    public synchronized int getCount() {
        return count;
    }

    public synchronized String toString() {
        return "[Count = " + count + "]";
    }

    /**
     * �ȴ�����������0
     * @param wait �ȴ�ʱ�䣬��λ����
     * @return {@code true} if the count reached zero and {@code false}
     *         if the waiting time elapsed before the count reached zero
     * @throws InterruptedException if the current thread is interrupted
     *         while waiting
     */
    public synchronized boolean await(long wait) throws InterruptedException {
        boolean timeout = false;
        long remaining = wait;
        long start = System.currentTimeMillis();        

        while (count > 0 && !timeout) {
            wait(remaining);
            long elapsed = System.currentTimeMillis() - start;
            remaining = wait - elapsed;
            timeout = remaining <= 0;
        }

        return !timeout;
    }
}
