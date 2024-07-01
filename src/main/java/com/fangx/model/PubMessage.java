package com.fangx.model;

import java.util.HashMap;
import java.util.Map;

public class PubMessage {
    public static Map dlmap = new HashMap();
    public static String serverUrl = "https://fx.nbefx.com/";

    public static String ossUrl = "https://fxtgoss.oss-cn-hangzhou.aliyuncs.com/";
//    小程序
    public static String appid = "wx620712f814aaf0e7";
    public static String secret = "4bb5d879a59d72c5db0408370b27d141";



    public static String access_token = "";
    public static String refresh_token = "";


    public static String baidu_token = "";//百度云人脸识别token
    public static String getAccess_token() {
        return access_token;
    }
    public static void setAccess_token(String access_token) {
        PubMessage.access_token = access_token;
    }

    public static String getRefresh_token() {
        return refresh_token;
    }

    public static void setRefresh_token(String refresh_token) {
        PubMessage.refresh_token = refresh_token;
    }

    //    公众号
    public static String appidw="";
    public static String secretw="";

    public static String mch_id = "1677492663"; //商户号id
    public static String mch_key = "Asdfghjkl1234567890qwertyuiopzxc"; //商户号秘钥

    public static String zsdz = "C:\\cert\\apiclient_cert.p12";

    private static cdxxzWithBLOBs xxz;

    public static cdxxzWithBLOBs getXxz() {
        return xxz;
    }

    public static void setXxz(cdxxzWithBLOBs xxz) {
        PubMessage.xxz = xxz;
    }



}
