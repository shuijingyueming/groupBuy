package com.efx.quality.until;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @Author Sunweifeng
 * @Date 2023/4/15 15:08
 */
public class AesUtil {
    /**
     * 默认的字符编码
     */
    private static final String DEFAULT_CHARSET = "utf-8";

    public static final String Key = "MIGfMA0GCSqGSIb3DQEBAQUAWEUJ7812";

    public static final String Key1 = "MIGMqSbDhfUhWE81";



    /**
     * 算法
     */
    private static final String ALGORITHM = "AES";

    /**
     * 算法/模式/填充
     **/
    private static final String CipherMode = "AES/ECB/PKCS5Padding";


    private AesUtil() {}

    /**
     * 解密AES 32位
     *
     * @param sSrc      解密的内容
     * @param secretKey 秘钥
     * @return 解密后的明文 数据
     */
    public static String decrypt(String sSrc, String secretKey) {

        if (secretKey == null) {
            System.out.println("需要加密的秘钥为空");
            return null;
        }
        try {
            byte[] raw = secretKey.getBytes(DEFAULT_CHARSET);
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            // 先用base64解密
            byte[] encryptedArr = Base64.getDecoder().decode(sSrc);
            byte[] original = cipher.doFinal(encryptedArr);
            return new String(original, DEFAULT_CHARSET);
        } catch (Exception ex) {
            System.out.println("AES解密失败");
            return null;
        }
    }


    /**
     * 加密32位
     *
     * @param sSrc 需要加密的内容
     * @param sKey 秘钥
     * @return 加密的内容
     */
    public static String encrypt(String sSrc, String sKey) {
        if (sKey == null) {
            System.out.println("需要加密的秘钥为空");
            return null;
        }
        try {
            byte[] raw = sKey.getBytes(DEFAULT_CHARSET);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, ALGORITHM);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes(DEFAULT_CHARSET));

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            System.out.println("AES加密失败");
            return null;
        }
    }

    /**
     * 数字加密为16进制
     * @param num 需要加密的内容
     * @return 加密的内容
     */
    public static String numberToACE(int num) {
        StringBuilder hexBuilder = new StringBuilder();
        while(num>0){
            int remainder = num%16;
            if (remainder<10) {
                hexBuilder.append((char) ('0' + remainder));
            } else {
                hexBuilder.append((char) ('a' + remainder - 10));
            }
            num /= 16;
        }
        return hexBuilder.reverse().toString();
    }
    /**
     * 16进制解密为数字
     * @param num 需要解密的内容
     * @return 加密的内容
     */
    public static int ACETonumber(String num) {
      return Integer.valueOf(num, 16);
    }

    /**
     * 前端扫码加密
     * @param uuid 主键  num 序号
     * @return 加密的内容
     */
    public static String encryptSM(String uuid,int num) {
      return uuid+numberToACE(num);
    }

    /**
     * 前端扫码解密
     * @param str 需要解密的内容
     * @return 加密的内容
     */
    public static String decryptSM(String str) {
        String p = str.substring(0,32);
//        System.out.println(p);
        String a = str.substring(32);
//        System.out.println(ACETonumber(a));
        return p+"#"+ACETonumber(a);
    }

    public static void main(String[] args) throws Exception {
//           String enString = "Sunwf12#9938efxa";
//           String enstr = encrypt(enString,Key1);
//           System.out.println(enstr);
//          enstr="D7stMO2+SWHilguGuWT3EbREuGgeMB1/Z5u3o//tyzQ=";
//           enstr="Rw++v9SffR/Ue3GhH1/eMhChpgF2smWwvnHkl4meLusjYqktPom0VVkJ6xd5gyAb";
          // enstr="Rw++v9SffR/Ue3GhH1/eMhChPgf2SmwwwvNhkl4meLusjYqKtpom0VVKJ6xd5gYab";
         //enstr="Rw++v9SffR/Ue3GhH1/eMhChPGF2SMWwvNHkl4meLusSfGekfPVncL2sTJvu0s7A";
         //  System.out.println(decrypt(enstr,Key1));
        String num = numberToACE(127);
        System.out.println(num);
        System.out.println(decryptSM("68eb2542bcac495ca0000024b92fd94d1"));
//        System.out.println(decrypt("2KTnY9eJ4q6R+AiwnlYSIUvmeVOjMjZxSp20WCiFIp/kxidAi2YmdWQMoEpIA154",Key1));
    }
}
