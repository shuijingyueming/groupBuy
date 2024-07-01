package com.fangx.until;

import java.security.MessageDigest;
import java.util.Arrays;

public class MsgSignature {

    public String getSignature(String encrypt, String token, String timestamp, String nonce) throws Exception {
        String[] array = new String[]{token, String.valueOf(timestamp), String.valueOf(nonce), encrypt};
        Arrays.sort(array);
        String str = String.join("", array);

        // 指定sha1算法
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(str.getBytes());
        byte[] digest = md.digest();

        StringBuilder hexStr = new StringBuilder();
        // 字节数组转换为十六进制数
        for (byte b : digest) {
            String shaHex = Integer.toHexString(b & 0xFF);
            if (shaHex.length() < 2) {
                hexStr.append(0);
            }
            hexStr.append(shaHex);
        }
        return hexStr.toString();
    }
}
