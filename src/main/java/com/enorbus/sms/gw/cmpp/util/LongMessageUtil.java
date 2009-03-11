package com.enorbus.sms.gw.cmpp.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.ArrayUtils;

/**
 * @author shiwang
 * @version $Id: LongMessageUtil.java 2235 2009-03-05 18:31:17Z shishuo.wang $
 *
 */
public class LongMessageUtil {
	
	public static final int ASCII_MAXLENGTH = 159;
	public static final int LONG_MAXLENGTH = 140;
	public static final int NORMAL_MAXLENGTH = 70;
	
	public static final String ENCODING = "GBK";
	
	public static final String UCS2_ENCODING = "UnicodeBigUnmarked";

    /**
     * ���ճ�����Э��ָ����
     * @param msg ���ָ����
     * @param fmt ���Ÿ�ʽ
     * @return �ָ�֮����ֽ������б�
     */
    public static List<byte[]> splitLongMsg(String msg, int fmt) {
		int max_length = LONG_MAXLENGTH;
		if (fmt == MessageConst.MSGFMT_ASCII)
			max_length = ASCII_MAXLENGTH;
		
		List<byte[]> result = new ArrayList<byte[]>();
		
		byte[] gbMsg = null;
		try {
			gbMsg = msg.getBytes(ENCODING);
		} catch (UnsupportedEncodingException e) {
		}
		
		if (gbMsg.length > max_length) {
			byte r = (byte) new Random().nextInt(256);
			byte[] header = new byte[] {0x05, 0x00, 0x03, r, 0x00, 0x00};
			// �ָ�ĳ���
			int splitLen = max_length-header.length;
			
			byte[] ucs2Msg = null;
			try {
				ucs2Msg = msg.getBytes(UCS2_ENCODING);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			int size = ucs2Msg.length/splitLen + (ucs2Msg.length%splitLen == 0 ? 0 : 1);
			for (int i=0; i < size; i++) {
				// ��ȥ��������ֽں�ʣ����ֽ���
				int remainLen = ucs2Msg.length - i*splitLen;
				// ��i+1�εĳ���
				int len = header.length + (remainLen > splitLen ? splitLen : remainLen);
				byte[] b = new byte[len];
				
				header[header.length-2] = (byte) size;
				header[header.length-1] = (byte) (i+1);
				
				System.arraycopy(header, 0, b, 0, header.length);
				System.arraycopy(ucs2Msg, i*splitLen, b, header.length, b.length-header.length);
				result.add(b);
			}
		} else {
			result.add(gbMsg);
		}
		
		return result;
	}

        public static final int HEADER_LEN = 5; // ��ֺ�Ķ���ǰ����(1/5)������������಻�ܳ���9��

    public static void main(String[] args) throws Exception {
        String orig = "GB2312 �Ǻ����ַ����ͱ���Ĵ��ţ�����ȫ��Ϊ����Ϣ�����ú��ֱ����ַ����������л����񹲺͹�" +
                "���ұ�׼�ַܾ�����һ�Ű�һ������һ��ʵʩ��GB �ǡ����ꡱ ���ֵĺ���ƴ����д��GB2312 �ַ��� (character set) ֻ��¼���ֺ��֣��Լ�һ�㳣����ĸ�ͷ��ţ���Ҫͨ�����й���½�������¼��µȵء�";
        List<byte[]> lst = splitSimpleMsg(orig, MessageConst.MSGFMT_GB);

        for (byte[] b : lst) {
            System.out.println((new String(b, "GB2312")) + ", bytes: " + b.length);
        }
    }

    /**
     * ����ָ�����ֽڳ��ȷָ���ţ����ڷָ�Ķ�������ǰ��������(1/5)�ı��
     * @param msg ���ָ����
     * @param fmt ���Ÿ�ʽ
     * @return �ָ�֮����ֽ������б�
     */
    /*public static List<byte[]> splitSimpleMsg(String msg, int fmt) {
        int maxLen = 0;
        switch(fmt) {
            case MessageConst.MSGFMT_ASCII:
                maxLen = ASCII_MAXLENGTH;
                break;
            case MessageConst.MSGFMT_GB:
                maxLen = NORMAL_MAXLENGTH;
                break;
            default: throw new IllegalArgumentException("Unsupported msg format[" + fmt + "]");
        }

        List<byte[]> temp = new ArrayList<byte[]>();

        byte[] src = new byte[0];
        try {
            src = msg.getBytes("GB2312");
        } catch (UnsupportedEncodingException e) {}

        // δ����������ָ�
        if (src.length <= maxLen) {
            temp.add(src);
            return temp;
        }

        int splitLen = maxLen - HEADER_LEN;
        int remainingLen = 0;
        byte[] fragment = null;
        int cur = 0; // ָ��Դ�ַ�����ǰλ�õ�ָ��
        int prev = 0; // ָ��Դ�ַ���֮ǰλ�õ�ָ��

        while (true) {
            remainingLen = src.length - cur;
            cur += (splitLen > remainingLen ? remainingLen : splitLen);
            if ((src[cur - 1] & 0x000000FF) > 127) {
                // ���һ���ֽ������ģ���һ���ж��������ַ��ĸ��ֽڣ���һ�ֽڣ����ǵ��ֽڣ��ڶ��ֽڣ���
                // ����ǵ��ֽ�������������֣�����Ǹ��ֽڣ�����ֽ�Ӧ���ֵ���һ��Ƭ����ȥ
                int count = 0;
                for (int i = cur - 2; i >= prev; i--) {
                    if ((src[i] & 0x000000FF) > 127)
                        count++;
                    else
                        break;
                }

                if (count % 2 == 0) {
                    // ���һ���ֽ��Ǹ��ֽڣ���ʾһ�������ַ�����������������˵�ǰָ��
                    cur--;
                }
            }
            fragment = new byte[cur - prev];
            System.arraycopy(src, prev, fragment, 0, fragment.length);
            
            temp.add(fragment);
            prev = cur;

            if (cur >= src.length) break;
        }

        // ��ÿһ����������ǰ���뵱ǰ���
        List<byte[]> result = new ArrayList<byte[]>();
        String prefix = null;
        for (int i = 0; i < temp.size(); i++) {
            prefix = "(" + (i + 1) + "/" + temp.size() + ")";
            result.add(ArrayUtils.addAll(prefix.getBytes(), temp.get(i)));
        }

        return result;
    }*/
    
    public static List<byte[]> splitSimpleMsg(String msg, int fmt) {
        int maxLen = 0;
        switch(fmt) {
            case MessageConst.MSGFMT_ASCII:
                maxLen = ASCII_MAXLENGTH;
                break;
            case MessageConst.MSGFMT_GB:
                maxLen = NORMAL_MAXLENGTH;
                break;
            default: throw new IllegalArgumentException("Unsupported msg format[" + fmt + "]");
        }

        List<byte[]> temp = new ArrayList<byte[]>();

        // δ����������ָ�
        if (msg.length() <= maxLen) {
            try {
				temp.add(msg.getBytes(ENCODING));
			} catch (UnsupportedEncodingException e) {
			}
            return temp;
        }

        int splitLen = maxLen - HEADER_LEN;

        for (int i=0; true; i++) {
        	if (msg.length() > (i+1)*splitLen) {
        		try {
					temp.add( msg.substring(i*splitLen, (i+1)*splitLen).getBytes(ENCODING) );
				} catch (UnsupportedEncodingException e) {}
        	} else {
        		try {
					temp.add( msg.substring(i*splitLen).getBytes(ENCODING) );
				} catch (UnsupportedEncodingException e) {}
        		break;
        	}
        }

        // ��ÿһ����������ǰ���뵱ǰ���
        List<byte[]> result = new ArrayList<byte[]>();
        String prefix = null;
        for (int i = 0; i < temp.size(); i++) {
            prefix = "(" + (i + 1) + "/" + temp.size() + ")";
            result.add(ArrayUtils.addAll(prefix.getBytes(), temp.get(i)));
        }

        return result;
    }
}
