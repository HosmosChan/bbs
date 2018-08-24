/*
 * copywrite 2013-2018 百思灵信息有限公司
 * 不能修改和删除上面的版权声明
 * 此代码属于软件部互动室编写，在未经允许的情况下不得传播复制
 */
package com.bbs.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * @comment 加解密工具类
 * @date 2010-8-24
 * @author Guguuihe
 * @since 1.0
 */
public class CodingUtil {

    private final static Logger logger = LoggerFactory.getLogger(CodingUtil.class);

    /**
     * 十位数字对应的字符
     */
    private static final char[] chars = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

    /**
     * 十六进制字符
     */
    private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f' };

    /**
     * Base64安全字符
     */
    private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_"
            .toCharArray();

    /**
     * 3DES向量
     */
    private final static String iv = "01234567";

    /**
     * 所有的字母
     */
    private final static String allCharectors = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    private static String[] charsArr = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmssSSS");
        }
    };

    /**
     * MD5加密
     *
     * @param source
     *            源字符串
     * @return 加密结果
     */
    public static String md5(String source) {
        try {
            byte[] buffer = source.getBytes("UTF-8");
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(buffer);
            byte[] encodeBytes = md5.digest();
            int j = encodeBytes.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = encodeBytes[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }

            return new String(str);
        }
        catch (UnsupportedEncodingException e) {
            logger.error("源字符串不支持md5编码！", e);
        }
        catch (NoSuchAlgorithmException e) {
            logger.error("系统不支持md5编码！", e);
        }
        return "";
    }

    /**
     * Base64编码
     *
     * @param source
     *            需要编码的字符串
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String base64Encode(String source) throws UnsupportedEncodingException {
        return base64Encode(source.getBytes("UTF-8"));
    }

    /**
     * Base64编码
     *
     * @param data
     *            需要编码的字节
     * @return
     */
    public static String base64Encode(byte[] data) {
        int start = 0;
        int len = data.length;
        StringBuffer buf = new StringBuffer(data.length * 3 / 2);

        int end = len - 3;
        int i = start;
        int n = 0;

        while (i <= end) {
            int d = ((((int) data[i]) & 0x0ff) << 16) | ((((int) data[i + 1]) & 0x0ff) << 8)
                    | (((int) data[i + 2]) & 0x0ff);

            buf.append(legalChars[(d >> 18) & 63]);
            buf.append(legalChars[(d >> 12) & 63]);
            buf.append(legalChars[(d >> 6) & 63]);
            buf.append(legalChars[d & 63]);

            i += 3;

            if (n++ >= 14) {
                n = 0;
                buf.append(" ");
            }
        }

        if (i == start + len - 2) {
            int d = ((((int) data[i]) & 0x0ff) << 16) | ((((int) data[i + 1]) & 255) << 8);

            buf.append(legalChars[(d >> 18) & 63]);
            buf.append(legalChars[(d >> 12) & 63]);
            buf.append(legalChars[(d >> 6) & 63]);
            buf.append("=");
        }
        else if (i == start + len - 1) {
            int d = (((int) data[i]) & 0x0ff) << 16;

            buf.append(legalChars[(d >> 18) & 63]);
            buf.append(legalChars[(d >> 12) & 63]);
            buf.append("==");
        }

        return buf.toString();
    }

    /**
     * @param c
     * @return
     */
    private static int decode(char c) {
        if (c >= 'A' && c <= 'Z')
            return ((int) c) - 65;
        else if (c >= 'a' && c <= 'z')
            return ((int) c) - 97 + 26;
        else if (c >= '0' && c <= '9')
            return ((int) c) - 48 + 26 + 26;
        else
            switch (c) {
                case '+':
                    return 62;
                case '/':
                    return 63;
                case '=':
                    return 0;
                default:
                    throw new RuntimeException("unexpected code: " + c);
            }
    }

    /**
     * Base64解码
     *
     * @param s
     *            需要解码的字符串
     * @return
     */
    public static byte[] base64Decode(String s) {
        s = s.replace("-", "+").replace("_", "/");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            decode(s, bos);
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
        byte[] decodedBytes = bos.toByteArray();
        try {
            bos.close();
            bos = null;
        }
        catch (IOException ex) {
            logger.error("Error while decoding BASE64: " + ex.toString());
        }
        return decodedBytes;
    }

    /**
     * @param s
     * @param os
     * @throws IOException
     */
    private static void decode(String s, OutputStream os) throws IOException {
        int i = 0;
        int len = s.length();
        while (true) {
            while (i < len && s.charAt(i) <= ' ')
                i++;
            if (i == len)
                break;
            int tri = (decode(s.charAt(i)) << 18) + (decode(s.charAt(i + 1)) << 12) + (decode(s.charAt(i + 2)) << 6)
                    + (decode(s.charAt(i + 3)));
            os.write((tri >> 16) & 255);
            if (s.charAt(i + 2) == '=')
                break;
            os.write((tri >> 8) & 255);
            if (s.charAt(i + 3) == '=')
                break;
            os.write(tri & 255);
            i += 4;
        }
    }

    /**
     * 3DES加密
     *
     * @param plainText
     *            普通文本
     * @return
     * @throws Exception
     */
    public static String des3Encode(String plainText, String secretKey) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] encryptData = cipher.doFinal(plainText.getBytes("UTF-8"));
        return base64Encode(encryptData);
    }

    /**
     * 3DES解密
     *
     * @param encryptText
     *            加密文本
     * @return
     * @throws Exception
     */
    public static String des3Decode(String encryptText, String secretKey) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

        byte[] decryptData = cipher.doFinal(base64Decode(encryptText));

        return new String(decryptData, "UTF-8");
    }

    /**
     * TODO: 创建一个UUID
     *
     * @return UUID
     */
    public static String createUUID() {
        UUID uuid = UUID.randomUUID();
        return StringUtils.replace(uuid.toString(), "-", StringUtils.EMPTY);
    }


    /**
     * 创建第三方支付订单号规则
     * @return
     */
    public static String createThirdPayOrderNo() {
        String date = formatter.get().format(new Date());
        return date+generateValidationCode(3);
    }


    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(charsArr[x % 0x3E]);
        }
        return shortBuffer.toString();
    }
    /**
     * 生成6位数字验证码
     * @return
     */
    public static String generateValidationCode() {
    	Random random=new Random();
    	String result="";
    	for(int i=0;i<6;i++){
    		result+=random.nextInt(10);
    	}
    	return result;
    }

    /**
     * 生成指定位数字验证码
     * @return
     */
    public static String generateValidationCode(int length) {
        Random random=new Random();
        String result="";
        for(int i=0;i<length;i++){
            result+=random.nextInt(10);
        }
        return result;
    }
}
