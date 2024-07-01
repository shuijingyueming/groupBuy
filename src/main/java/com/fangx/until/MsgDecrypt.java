package com.fangx.until;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author nyel
 * @date 10/13/21
 */
public class MsgDecrypt {

    /**
     * 对密文进行解密
     *
     * @param text           密文
     * @param encodingAesKey 配置在小红书平台的encodingAesKey
     * @return 解密后的明文
     */
    public static String decrypt(String text, String encodingAesKey) throws Exception {
        byte[] aesKey = Base64.decodeBase64(encodingAesKey + "=");
        SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
        IvParameterSpec iv = new IvParameterSpec(aesKey, 0, 16);
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
        byte[] decrypted = cipher.doFinal(Base64.decodeBase64(text));
        byte[] bytes = PKCS7Decoder.decode(decrypted);
        // 获取内容长度
        byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);
        int length = recoverNetworkBytesOrder(networkOrder);

        // byte数组截去真实消息后，末尾剩下的字符就是appid
        String appId = new String(
                Arrays.copyOfRange(bytes, 20 + length, bytes.length),
                StandardCharsets.UTF_8);
        // 根据解析出来的消息体长度值，截取真实的消息体
        return new String(
                Arrays.copyOfRange(bytes, 20, 20 + length),
                StandardCharsets.UTF_8);
    }

    /**
     * 还原4个字节的网络字节序
     *
     * @param networkOrder 网络字节码
     * @return sourceNumber
     */
    private static int recoverNetworkBytesOrder(byte[] networkOrder) {
        int sourceNumber = 0;
        int length = 4;
        int number = 8;
        for (int i = 0; i < length; i++) {
            sourceNumber <<= number;
            sourceNumber |= networkOrder[i] & 0xff;
        }
        return sourceNumber;
    }
}
