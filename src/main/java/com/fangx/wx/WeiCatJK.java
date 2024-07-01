package com.fangx.wx;

import com.alibaba.fastjson.JSON;
import com.fangx.model.PubMessage;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.AlgorithmParameterSpec;
import java.text.SimpleDateFormat;
import java.util.*;

public class WeiCatJK {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	private static String access_token = null;
	private static HashMap map = new HashMap();
	//------微信小程序
	//public static String appid = "wx0dfec6b2c90e01b2";
	//public static String secret = "2db66b55e8869fdbb4206dc70f367fca";
	
	// 获得​access_token
	// 小程序获取openid
	public static JSONObject queryOpenid(String code, String appid,
			String secret) {
		Map params = new HashMap();
		params.put("appid", appid);
		params.put("secret", secret);
		params.put("grant_type", "authorization_code");
		params.put("js_code", code);
		String result = HttpGetUtil.httpRequestToString(
				"https://api.weixin.qq.com/sns/jscode2session", params);
		JSONObject jsob = JSONObject.fromObject(result);
		return jsob;
	}
	
	// 公众号网页授权获取openid
	public static JSONObject queryGZHOpenid(String code) {
		Map params = new HashMap();
		params.put("appid", PubMessage.appidw);
		params.put("secret", PubMessage.secretw);
		params.put("code", code);
		params.put("grant_type", "authorization_code");
		String result = HttpGetUtil.httpRequestToString("https://api.weixin.qq.com/sns/oauth2/access_token", params);
		JSONObject jsob = JSONObject.fromObject(result);
		return jsob;
	}
	
	/**
	 * 小程序获取access_token
	 * @param appid
	 * @param secret
	 * @return
	 */
	public static String access_token(String appid, String secret) { 
		Map<String, String> params = new HashMap<String, String>();
		params.put("secret", secret);
		params.put("appid", appid);
		params.put("grant_type", "client_credential");
		String requestUrl = HttpGetUtil.httpRequestToString("https://api.weixin.qq.com/cgi-bin/token", params);
		
		JSONObject result = JSONObject.fromObject(requestUrl);
		map.put("access_token", result.getString("access_token"));
		map.put("time", new Date());
		access_token = result.getString("access_token");
		return access_token;
	}
	
	/**
	 * 公众号网页授权获取access_token
	 */
	public static String gzhaccess_token(String code) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
		Map<String, String> params = new HashMap<String, String>();
		String token = "";
		params.put("appid", PubMessage.appidw);
		params.put("secret", PubMessage.secretw);
		params.put("code", code);
		params.put("grant_type", "authorization_code");
		String requestUrl = HttpGetUtil.httpRequestToString("https://api.weixin.qq.com/sns/oauth2/access_token", params);
		JSONObject obj = JSONObject.fromObject(requestUrl);
		System.out.print(obj.toString());
		if(obj.getString("errcode")!=null){
			System.out.print("token返回错误："+obj.getString("errmsg"));
			token = "ERR#"+obj.getString("errmsg");
		}else{
			//PubMessage.setAccess_token(obj.getString("access_token"));
			//PubMessage.setRefresh_token(obj.getString("refresh_token"));
			token = obj.getString("access_token");
		}
		
		return token;
	}
	
	/**
	 * 公众号网页授权刷新access_token
	 */
	public static JSONObject sxgzhaccess_token(String appid,String refresh_token) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("appid", appid);
		params.put("grant_type", "refresh_token");
		params.put("refresh_token", refresh_token);
		String requestUrl = HttpGetUtil.httpRequestToString("https://api.weixin.qq.com/sns/oauth2/refresh_token", params);
		JSONObject obj = JSONObject.fromObject(requestUrl);
		if(obj.getString("refresh_token")!=null){
			PubMessage.setAccess_token(obj.getString("access_token"));
			PubMessage.setRefresh_token(obj.getString("refresh_token"));
		}
		return obj;
	}
	
	/**
	 * 公众号网页授权获取用户信息
	 */
	public static JSONObject huoquyhxx(String access_token,String openid) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", access_token);
		params.put("openid", openid);
		params.put("lang", "zh_CN");
		String result = HttpGetUtil.httpsRequestToString("https://api.weixin.qq.com/sns/userinfo",params);
		JSONObject obj = JSONObject.fromObject(result);
		return obj;
	}
	
	public static String api_ticket(String access_token) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", access_token);
		params.put("type", "wx_card");
		String requestUrl = HttpGetUtil.httpRequestToString("https://api.weixin.qq.com/cgi-bin/ticket/getticket", params);
		JSONObject result = JSONObject.fromObject(requestUrl);
		String api_ticket = result.getString("ticket");
		return api_ticket;
	}
	
	public static String api_ticket1(String access_token) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", access_token);
		params.put("type", "jsapi");
		String requestUrl = HttpGetUtil.httpRequestToString("https://api.weixin.qq.com/cgi-bin/ticket/getticket", params);
		JSONObject result = JSONObject.fromObject(requestUrl);
		String api_ticket = result.getString("ticket");
		return api_ticket;
	}
	
	// 小程序获取token
	public static String wxxxts(String appid, String secret) {
		
		WeiCatJK jssdk = new WeiCatJK();
		// 原有的系统时间
		Date time = (Date) map.get("time");
		// 获得当先系统时间
		Date date = Calendar.getInstance().getTime();
		if (time == null) {// 没有存 重新获取并存储
			access_token = jssdk.access_token(appid, secret);
		}
		if (time != null && date.getTime() > time.getTime() + 6200 * 500) {// 有数据，但是过期了
			access_token = jssdk.access_token(appid, secret);
		}
		return access_token;
	}
	
	public static String getsphone(String appid, String secret, String js_code) {
		Map<String, String> params = new HashMap<String, String>();
		// https://api.weixin.qq.com/sns/jscode2session?appid=固定的appid&secret=固定的secret&js_code=每次小程序传参&grant_type=authorization_code
		params.put("appid", appid);
		params.put("secret", secret);
		params.put("js_code", js_code);
		params.put("grant_type", "authorization_code");
		String requestUrl = HttpGetUtil.httpRequestToString(
				"https://api.weixin.qq.com/sns/jscode2session", params);
		
		// JSONObject result=JSONObject.fromObject(requestUrl);
		return requestUrl;
	}
	
	
	//新的小程序解密手机号
    public static String decrypt_new(String encryptedData, String session_key, String iv){
    	String phoneNumber = null;
    	 try {
    		//System.out.println(encryptedData);
    		System.out.println(session_key);
    		//System.out.println(iv);
             String result = WxUtils.wxDecrypt(encryptedData, session_key, iv);
//             System.out.println(result);
             JSONObject json = JSONObject.fromObject(result);
             if (json.containsKey("phoneNumber")) {
            	 phoneNumber = json.getString("phoneNumber");
             }
         } catch (Exception e) {
        	 e.printStackTrace();
         }
    	 return phoneNumber;
    }
    
	// 小程序解密手机号
	public static String decrypt(String js_code, String iv, String encData,
			String appid, String secret) throws Exception {
		JSONObject result = JSONObject.fromObject(getsphone(appid, secret,
				js_code));
		// return
		// AES.decodeUserInfo(encData,result.getString("session_key"),iv);
		// System.out.println(encData);
		byte[] encrypData = Base64.decodeBase64(encData);
		byte[] ivData = Base64.decodeBase64(iv);
		byte[] sessionKey = Base64
				.decodeBase64(result.getString("session_key"));
		// 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
		int base = 16;
		if (encrypData.length % base != 0) {
			int groups = encrypData.length / base
					+ (encrypData.length % base != 0 ? 1 : 0);
			byte[] temp = new byte[groups * base];
			Arrays.fill(temp, (byte) 0);
			System.arraycopy(encrypData, 0, temp, 0, encrypData.length);
			encrypData = temp;
		}
		if (ivData.length % base != 0) {
			int groups = ivData.length / base
					+ (ivData.length % base != 0 ? 1 : 0);
			byte[] temp = new byte[groups * base];
			Arrays.fill(temp, (byte) 0);
			System.arraycopy(ivData, 0, temp, 0, ivData.length);
			ivData = temp;
		}
		if (sessionKey.length % base != 0) {
			int groups = sessionKey.length / base
					+ (sessionKey.length % base != 0 ? 1 : 0);
			byte[] temp = new byte[groups * base];
			Arrays.fill(temp, (byte) 0);
			System.arraycopy(sessionKey, 0, temp, 0, sessionKey.length);
			sessionKey = temp;
		}
		
		AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivData);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		SecretKeySpec keySpec = new SecretKeySpec(sessionKey, "AES");
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
		// 解析解密后的字符串
		// System.out.println(encrypData.length+"==="+encrypData);
		// JSONObject map = JSONObject.fromObject(new
		// String(cipher.doFinal(encrypData)));
		com.alibaba.fastjson.JSONObject map = JSON.parseObject(new String(
				cipher.doFinal(encrypData)));
		map.put("openid", result.getString("openid"));
		return map.toString();
	}
	
	/**
	 * 从微信获取带参二维码，并写入，只有一个参数
	 * sceneStr:参数内容，accessToken：微信session,wxpath:小程序进入页地址,
	 * filePathName:要保存的文件地址名称
	 * 
	 * @param sceneStr
	 * @param accessToken
	 * @return
	 */
	public static boolean getminiqrQr(String sceneStr, String accessToken,
			String wxpath, String filePath, String fileName) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("scene", sceneStr); // 参数
		params.put("page", wxpath); // 位置 page
		params.put("width", 400);
		params.put("is_hyaline", true);
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		
		HttpPost httpPost = new HttpPost(
				"https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="
						+ accessToken); // 接口
		httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
		String body = JSON.toJSONString(params); // 必须是json模式的 post
		StringEntity entity;
		try {
			entity = new StringEntity(body);
			entity.setContentType("image/png");
			httpPost.setEntity(entity);
			HttpResponse response;
			response = httpClient.execute(httpPost);
			InputStream inputStream = response.getEntity().getContent();
			
			File file = new File(filePath);// 可以是任何图片格式.jpg,.png等
			if (!file.exists())
				file.mkdirs();
			file = new File(filePath + "\\" + fileName);
			if (!file.exists())
				file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			byte[] b = new byte[1024];
			int nRead = 0;
			while ((nRead = inputStream.read(b)) != -1) {
				fos.write(b, 0, nRead);
			}
			fos.flush();
			fos.close();
			return true;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 小程序付款
	public static Map wxPay(Map<String, String> mp) {
		try {
			int total = 100;
			int amount = (int) Math.round(total * Double.valueOf(mp.get("total_fee")));
			// 生成的随机字符串
//			String nonce_str = RandomStringGenerator.getRandomStringByLength(32);
			// 获取客户端的ip地址
			String spbill_create_ip = mp.get("spbill_create_ip");
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String time = df.format(new Date());
			Random ne = new Random();
			int guid = ne.nextInt(9999 - 1000 + 1) + 1000;
			// 组装参数，用户生成统一下单接口的签名
			Map<String, String> packageParams = new HashMap<String, String>();
			packageParams.put("appid", mp.get("appid"));
			packageParams.put("mch_id", mp.get("mch_id"));
			packageParams.put("nonce_str", mp.get("nonce_str"));
			packageParams.put("body", mp.get("body"));
			packageParams.put("out_trade_no", mp.get("mch_id") + time + guid);// 商户订单号
			packageParams.put("total_fee", String.valueOf(amount));// 支付金额，这边需要转成字符串类型，否则后面的签名会失败
			packageParams.put("spbill_create_ip", spbill_create_ip);
			packageParams.put("notify_url", mp.get("notify_url"));// 支付成功后的回调地址
			packageParams.put("trade_type", "JSAPI");// 支付方式
			packageParams.put("openid", mp.get("openid"));
			String prestr = PayUtils.createLinkString(packageParams); // 把数组所有元素，按照'参数=参数值'的模式用'&'字符拼接成字符串
			System.out.println(mp.get("openid")+"--支付金额--"+String.valueOf(amount));
			// MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
			String mysign = PayUtils.sign(prestr, mp.get("mch_Key"), "utf-8")
					.toUpperCase();

			TreeMap<String, String> tmap1 = new TreeMap<String, String>();
			tmap1.put("appid", mp.get("appid"));
			tmap1.put("body", mp.get("body"));
			tmap1.put("mch_id", mp.get("mch_id"));
			tmap1.put("nonce_str", mp.get("nonce_str"));
			tmap1.put("notify_url", mp.get("notify_url"));// 支付成功后的回调地址
			tmap1.put("openid", mp.get("openid"));
			tmap1.put("out_trade_no", mp.get("mch_id") + time + guid);// 商户订单号
			tmap1.put("spbill_create_ip", spbill_create_ip);
			tmap1.put("total_fee", String.valueOf(amount));// 支付金额，这边需要转成字符串类型，否则后面的签名会失败
			tmap1.put("trade_type", "JSAPI");// 支付方式
			tmap1.put("sign", mysign);// 支付方式
			String xml = XMLUtils.getRequestXml(tmap1);

			// System.out.println("调试模式_统一下单接口 请求XML数据：" + xml);

			// 调用统一下单接口，并接受返回的结果
			String result = PayUtils.httpRequest(
					"https://api.mch.weixin.qq.com/pay/unifiedorder", "POST",
					xml);

			// 将解析结果存储在HashMap中
			Map map = PayUtils.doXMLParse(result);

			String return_code = (String) map.get("return_code");// 返回状态码
			// System.out.println(return_code+"返回状态码 ");
			Map<String, Object> response = new HashMap<String, Object>();// 返回给小程序端需要的参数
			if (return_code == "SUCCESS" || return_code.equals(return_code)) {
				String prepay_id = (String) map.get("prepay_id");// 返回的预付单信息
				response.put("nonceStr", mp.get("nonce_str"));
				response.put("package", "prepay_id=" + prepay_id);
				Long timeStamp = System.currentTimeMillis() / 1000;
				response.put("timeStamp", timeStamp + "");// 这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
				// 拼接签名需要的参数
				String stringSignTemp = "appId=" + mp.get("appid")
						+ "&nonceStr=" + mp.get("nonce_str") + "&package=prepay_id="
						+ prepay_id + "&signType=MD5&timeStamp=" + timeStamp
						+ "";
				// 再次签名，这个签名用于小程序端调用wx.requesetPayment方法
				String paySign = PayUtils.sign(stringSignTemp,
						mp.get("mch_Key"), "utf-8").toUpperCase();

				response.put("paySign", paySign);
			}

			response.put("appid", mp.get("appid"));
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 小程序退款
	public static Map wxRefund(Map<String, String> mp) {
		try {
			int total = 100;
			int amount = (int) Math.round(total * Double.valueOf(mp.get("total_fee")));
			int amount1 = (int) Math.round(total * Double.valueOf(mp.get("refund_fee")));
//			System.out.println(amount1);
			// 生成的随机字符串
			String nonce_str = RandomStringGenerator.getRandomStringByLength(32);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String time = df.format(new Date());
			Random ne = new Random();
			int guid = ne.nextInt(9999 - 1000 + 1) + 1000;
			// 组装参数，用户生成统一下单接口的签名
			Map<String, String> packageParams = new HashMap<String, String>();
			packageParams.put("appid", mp.get("appid"));
			packageParams.put("mch_id", mp.get("mch_id"));
			packageParams.put("nonce_str", nonce_str);
			packageParams.put("out_trade_no", mp.get("out_trade_no"));// 商户订单号
			packageParams.put("out_refund_no", mp.get("mch_id") + time + guid);// 商户订单号
			packageParams.put("total_fee", String.valueOf(amount));// 支付的总金额，这边需要转成字符串类型，否则后面的签名会失败
			packageParams.put("refund_fee", String.valueOf(amount1));// 需退款的金额，这边需要转成字符串类型，否则后面的签名会失败
			String prestr = PayUtils.createLinkString(packageParams); // 把数组所有元素，按照'参数=参数值'的模式用'&'字符拼接成字符串
			//System.out.println(prestr);
			// MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
			String mysign = PayUtils.sign(prestr, mp.get("mch_Key"), "utf-8").toUpperCase();

			TreeMap<String, String> tmap1 = new TreeMap<String, String>();
			tmap1.put("appid", mp.get("appid"));
			tmap1.put("mch_id", mp.get("mch_id"));
			tmap1.put("nonce_str", nonce_str);
			tmap1.put("out_trade_no", mp.get("out_trade_no"));// 商户订单号
			tmap1.put("out_refund_no", mp.get("mch_id") + time + guid);// 商户订单号
			tmap1.put("total_fee", String.valueOf(amount));// 支付的总金额，这边需要转成字符串类型，否则后面的签名会失败
			tmap1.put("refund_fee", String.valueOf(amount1));// 需退款的金额，这边需要转成字符串类型，否则后面的签名会失败
			tmap1.put("sign", mysign);// 支付方式
			String xml = XMLUtils.getRequestXml(tmap1);
			//System.out.println(xml);
			// 调用统一下单接口，并接受返回的结果
			String result = PayUtils.httpsRequest_AQZS("https://api.mch.weixin.qq.com/secapi/pay/refund", xml, mp.get("zsdz"), mp.get("mch_id"));
//			System.out.println(result);
			return PayUtils.doXMLParse(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
