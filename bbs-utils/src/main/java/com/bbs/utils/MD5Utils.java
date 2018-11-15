package com.bbs.utils;

import java.security.MessageDigest;

/**
 * @author liuqiangsheng
 * @version 2018/9/30
 * @modify chenhuayang
 */
public class MD5Utils {
    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    // 转换字节数组为十六进制字符串
    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultsb = new StringBuffer();
        int i;
        for (i = 0; i < b.length; i++) resultsb.append(byteToHexString(b[i]));
        return resultsb.toString();
    }

    // 将字节转化成十六进制的字符串
    public static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n % 16;
        int d2 = n / 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            else resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }
}