package com.enorbus.sms.gw.cmpp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * CMPP Client���ؿ���̨���ÿ���̨ͨ��JMX�����ؽ��п��ƣ�
 * ���¼��ע������ֹ�ȡ���ǰ��֧����ֹ����
 *
 * @author Long Zhi
 * @version $Id: Console.java 2088 2009-02-17 06:28:16Z shishuo.wang $
 */
public class Console {
    public static void main(String[] args) {
        if (args.length == 0) {
            usage("Incorrect number of parameters.");
        }

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans/applicationContext-console.xml");
        Manageable client = (Manageable) ctx.getBean("proxy");

        if (args[0].equals("stop")) {
            try {
                client.shutdown();
            } catch (Exception e) {
                e.printStackTrace(); 
            }
        }
    }
    
    static void usage(String errMsg) {
        System.err.println(errMsg);
        System.err.println("\nUsage: java com.enorbus.sms.gw.cmpp.Console action\n");
        System.exit(1);
      }
}
