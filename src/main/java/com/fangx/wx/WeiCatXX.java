package com.fangx.wx;

import net.sf.json.JSONObject;

public class WeiCatXX {
	/**
	 * 统一服务消息
	 * 小程序模板消息,发送服务通知
	 * @param token 小程序ACCESS_TOKEN
	 * @param touser 用户openid，可以是小程序的openid，也可以是公众号的openid
	 * @param template_id 小程序模板消息模板id
	 * @param page 小程序页面路径
	 * @param formid 小程序模板消息formid
	 * @param data 小程序模板消息内容
	 * @param emphasis_keyword 小程序模板放大关键词
	 * @return
	 * @author HGL
	 */
	public static JSONObject sendWeappMessage(String token,String touser,String template_id,
			String page,String formid,JSONObject data){
		JSONObject obj = new JSONObject();
		JSONObject weapp_template_msg = new JSONObject();
		JSONObject result = new JSONObject();
		try {
			String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/uniform_send?access_token="+token;
			obj.put("touser", touser);
			weapp_template_msg.put("template_id", template_id);
			weapp_template_msg.put("page", page);
			weapp_template_msg.put("form_id", formid);
			weapp_template_msg.put("data", data);
//			weapp_template_msg.put("emphasis_keyword", data.getJSONObject("keyword1").getString("value"));
			obj.put("weapp_template_msg", weapp_template_msg);
			result = HttpClientUtil.Post(url, obj);
			System.out.println(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 统一服务消息
	 * 公众号模板消息,发送公众号通知
	 * @param token 小程序ACCESS_TOKEN
	 * @param touser 用户openid，可以是小程序的openid，也可以是公众号的openid
	 * @param appid 公众号appid
	 * @param template_id 公众号模板消息模板id
	 * @param url 公众号模板消息所要跳转的url
	 * @param weappid 公众号模板消息所要跳转的小程序appid，小程序的必须与公众号具有绑定关系
	 * @param pagepath 公众号模板消息所要跳转的小程序页面
	 * @param data 公众号模板消息的数据
	 * @return
	 * @author HGL
	 */
	public static JSONObject sendMpMessage(String token,String touser,String appid,
			String template_id,String url,String weappid,String pagepath,JSONObject data){
		JSONObject result = new JSONObject();
		JSONObject obj = new JSONObject();
		try {
			String path = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token;
			obj.put("touser", touser);
			obj.put("template_id", template_id);
			obj.put("url",url);
			obj.put("data", data);
			result = HttpClientUtil.Post(path, obj);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
