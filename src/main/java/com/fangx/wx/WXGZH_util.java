package com.fangx.wx;

import net.sf.json.JSONObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class WXGZH_util {
	// 网页授权接口
	public final static String GetPageAccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	public final static String ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=TOKEN&type=jsapi";
	
	
	
	/**
	 * 公众号获取openID
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public String GetGZHOpenid(String wx_appsecret, String code, String wx_appID, HttpServletResponse response) throws IOException {
        Map params = new HashMap();
        params.put("secret", wx_appsecret);
        params.put("appid", wx_appID);
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        String result = HttpGetUtil.httpRequestToString(
                "https://api.weixin.qq.com/sns/oauth2/access_token", params);
        JSONObject jsonObject = JSONObject.fromObject(result);
        String openid = jsonObject.get("openid").toString();
        
		return openid;
    }
	
	/**
	 * 根据公众号appID和appSecret获取token
	 * @param appid
	 * @param appsecret
	 * @return
	 */
	public static Map<String, String> getAccessToken(String appid,String appsecret) {
		String requestUrl = GetPageAccessTokenUrl.replace("APPID", appid)
				.replace("APPSECRET", appsecret);
		HttpClient client = null;
		Map<String, String> result = new HashMap<String, String>();
		String accessToken = null;
		try {
			client = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(requestUrl);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String response = client.execute(httpget, responseHandler);
			JSONObject OpenidJSONO = JSONObject.fromObject(response);
			accessToken = String.valueOf(OpenidJSONO.get("access_token"));
			result.put("accessToken", accessToken);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
		return result;
	}
	
	/**
	 * 根据token获取ticket
	 * @param token
	 * @return
	 */
	public static Map<String, String> getTicket(String token) {
        String requestUrl = GetPageAccessTokenUrl.replace("TOKEN", token);
		HttpClient client = null;
		Map<String, String> result = new HashMap<String, String>();
		String ticket = null;
		try {
			client = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(requestUrl);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String response = client.execute(httpget, responseHandler);
			JSONObject OpenidJSONO = JSONObject.fromObject(response);
			ticket = String.valueOf(OpenidJSONO.get("ticket"));
			result.put("ticket", ticket);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
		return result;
	}
		
	/*
	 * 微信公众号签名
	 */
	 public static String getSign(String jsapi_ticket, String noncestr, Long timestamp, String url)
	            throws NoSuchAlgorithmException {
        String shaStr = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url="
                + url;
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(shaStr.getBytes());
        StringBuffer signature = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            signature.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return signature.toString();
    }
}
