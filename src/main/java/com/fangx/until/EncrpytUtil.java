package com.fangx.until;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncrpytUtil {
    public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDXajYcIi2XXwXoKgH0JWxh1rgUdPjgJFAvmNitLQseMIhiF1vO+kNLHGCImQKcHScC4/UL1HJSY0dHsiOn8q5ydWFIt7UwxUddiSP5rjAoASYR6K6WKCkpUsPOk3a2/hm6t0DEyje9bLMuUjaTpylFBzkNfY1rp3iOtwNJkUd2nQIDAQAB";
    public static final String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBANdqNhwiLZdfBegqAfQlbGHWuBR0+OAkUC+Y2K0tCx4wiGIXW876Q0scYIiZApwdJwLj9QvUclJjR0eyI6fyrnJ1YUi3tTDFR12JI/muMCgBJhHorpYoKSlSw86Tdrb+Gbq3QMTKN71ssy5SNpOnKUUHOQ19jWuneI63A0mRR3adAgMBAAECgYAP71txWVXmDLFzKyhZ1yrdUfTsDnsamZUU8EmXBe38nbp5ByFTfk/cDo1VjXwT8FQicpp99Yk/bvim5RaeJeWhjyW9gNzWvWHKUjeWwNSIl6851V1RXgFh1o2uAFU5omXvCZHjP68vRcVj1+8D1BXMMo+mhhBSAKDjkFJrp/AMQQJBAPXThD1UrSOlBcq7MGmwTXS0zXZ1Z1kovUE/YL2hpUAL90tDY0KcctHI9R9WXbGye1W6dCGZPXCgdNtpHaKUa28CQQDgVH4BAyzp2AIy5wuRof8UDlXyRKffwRBm4EfroQFJe4XFf6lDCt8LCdJDn2DiXkVzMTwewsBUQy4SNCcpOSizAkAQZi/oN4HlYtjkEWDFbDF+m6EpSeO/GuylMakufV4cy6+Pocs5Yl52iEVx9b0CYbnAmlOs+iATJ2EkUfrcIbKZAkAuYYnDz9JDbwPVXmvH6oSAsw4WDxfebV5kxs5X62wGs2FPGjv2vpKrB5bPoG45n2AglvdlLMLzKQinftzx6v19AkBNHGRj9NGn/+S2ClUhss31C3ldcWqaX4IafKIvWw+RtcticygWVrSAnp2VQ8WKgW+qrSsYxrNnAkY2j7/4BA9A";

    /**
     * 利用java原生的类实现SHA256加密
     *
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256(String str) {
        MessageDigest messageDigest;
        String encodestr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            encodestr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodestr;
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                // 1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }


    /**
     * 登录解密
     *
     * @return
     */
    public static String decode(String cCode) {
        try {
            byte[] decodedData = RSACoder.decryptByPrivateKey(RSACoder.decryptBASE64(cCode), privateKey);
            return new String(decodedData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) throws Exception {

        //System.out.println(EncrpytUtil.getSHA256("Sunwf!123"));
        System.err.println("公钥加密——私钥解密");
        String inputStr = "dounine";
        byte[] encodedData = RSACoder.encryptByPublicKey(inputStr, publicKey);
        String cd = RSACoder.encryptBASE64(encodedData);
        System.err.println("-----" + cd);
        byte[] decodedData = RSACoder.decryptByPrivateKey(RSACoder.decryptBASE64(cd),
                privateKey);
        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        //assertEquals(inputStr, outputStr);
    }

}
