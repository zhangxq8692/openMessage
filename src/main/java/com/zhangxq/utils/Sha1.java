package com.zhangxq.utils;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2018/07/31 01:10
 * @Description:
 */
public final class Sha1 {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * Takes the raw bytes from the digest and formats them correct.
     *
     * @param bytes the raw bytes from the digest.
     * @return the formatted bytes.
     */
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

   /* public static void main(String[] args) {
        //signature:f9cff0296e8ee3f1395fbe51d494900e0cb466c2,timestamp:1533124574,nonce:1873529636,echostr:32804708874297311
        String timestamp="1533124574";
        String nonce = "1873529636";
        String TOKEN = "zhangxq5104";
        String temp[] = {nonce,timestamp,TOKEN};
        String str = "";
        Arrays.sort(temp);
        for (String t:temp){
            str = str + t;
        }
        System.out.println(str);
        String encode = Sha1.encode(str);
        System.out.println(encode);
    }*/
}
