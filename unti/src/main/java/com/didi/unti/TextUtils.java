package com.didi.unti;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangh09 on 2017/4/28.
 */
public class TextUtils {
	
    public static String  getIdByUUID(){
        String id = UUID.randomUUID().toString();
        id=id.replaceAll("-", "");
        return id;
    }

    public static String accountPassEncode(String s) {
        return md5(s);
    }
   
    
    public static String md5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
            //���MD5ժҪ�㷨�� MessageDigest ����
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            //ʹ��ָ�����ֽڸ���ժҪ
            mdInst.update(btInput);
            //�������
            byte[] md = mdInst.digest();
            //������ת����ʮ�����Ƶ��ַ�����ʽ
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String underline2Camel(String line){
        if(line==null||"".equals(line)){
            return "";
        }
        //    StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("((_)[a-z])+?");

        Matcher matcher=pattern.matcher(line);
        while(matcher.find()) {
            String word = matcher.group();
            line = line.replace(word, word.toUpperCase().replace("_",""));
        }
        return line;
    }
	 public static double formatDouble(double d) {
	
	        double   f1   =   new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
	        return f1;
	        
	    }
}
