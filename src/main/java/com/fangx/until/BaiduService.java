package com.fangx.until;

import com.fangx.model.PubMessage;
import com.fangx.model.cdusn;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class BaiduService {

    /**
     * 获取权限token
     * @return 返回示例：
     * {
     * "access_token": "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567",
     * "expires_in": 2592000
     * }
     */
    public static String getAuth() {
        // 官网获取的 API Key
        String clientId = "qxwmrqR6jkdHmI7Y6Dg6NaT1";
        // 官网获取的 Secret Key
        String clientSecret = "6L5iquOEv55C6KNw43pYcv1KVcHyGo5D";
        return getAuth(clientId, clientSecret);
    }

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     */
    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.err.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
           // System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }

    /**
     * 人脸注册
     * user:用户Bean
     * groupName:人员组名(“sm_”+学校机构ID) 学生组 （"qm_"+街道id）
     * imgPath:上传的照片地址（包括照片名称）
     * result返回: face_token 注册成功  N 注册失败
     * type:操作类型："A" add新注册  "D" update更新注册
     */
    public static String add(cdusn user,String groupName,String imgPath,String type) {
        // 请求url
        String url = "";
        if("D".equals(type)) url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/update";
        else url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try{
            //照片转BASE64编码
            File f = new File(imgPath);
            if(f.exists()){
                // 将图片文件转化为字节数组
                FileInputStream fis = new FileInputStream(f);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                byte[] data = baos.toByteArray();
                fis.close();
                baos.close();
                //提交注册
                Map<String, Object> map = new HashMap<>();
                map.put("image", Base64.getEncoder().encodeToString(data));//头像字段
                map.put("group_id", groupName);//人员组名
                map.put("user_id", user.getUsn001());//用户id
                map.put("user_info", user.getUsn002());//用户名称
                map.put("liveness_control", "NORMAL");
                map.put("image_type", "BASE64");
                map.put("quality_control", "LOW");
                String param = GsonUtils.toJson(map);
                String result = HttpUtil.post(url, PubMessage.baidu_token, "application/json", param);
                System.out.println(result);
                //字符串转json数据
                JSONObject jsonObject = new JSONObject(result);
                return jsonObject.getString("face_token");
            }else{
                System.out.println("注册失败");
                return "N";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "N";
    }

    /**
     * 删除人脸注册
     * user:用户Bean
     * groupName:(“sm_”+学校机构ID) 学生组 （"qm_"+街道id）街道
     * result返回:Y 成功 N 失败
     */
    public static String del(cdusn user, String groupName) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/delete";
        try{
            //删除注册
            Map<String, Object> map = new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
            String timestamp = sdf.format(new Date());
            map.put("log_id",timestamp);//请求标识码，随机数，唯一
            map.put("group_id", groupName);//人员组名
            map.put("user_id", user.getUsn001());//用户id
//            map.put("face_token", user.getUsn017());//需要删除的人脸图片token

            String param = GsonUtils.toJson(map);
            String result = HttpUtil.post(url, PubMessage.baidu_token, "application/json", param);
            System.out.println(result);
            return "Y";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "N";
    }

    /**
     * 人脸搜索
     * groupName:(“sm_”+学校机构ID) 学生组 （"qm_"+街道id）街道组
     * imgPath:上传的照片地址（包括照片名称）
     * result返回: face_token 注册成功  N 注册失败
     */
    public static String faceSearch(String groupName,String imgPath) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            //照片转BASE64编码
            File f = new File(imgPath);
            if(f.exists()){
                // 将图片文件转化为字节数组
                FileInputStream fis = new FileInputStream(f);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                byte[] data = baos.toByteArray();
                fis.close();
                baos.close();
                Map<String, Object> map = new HashMap<>();
                map.put("image", Base64.getEncoder().encodeToString(data));
                map.put("liveness_control", "NORMAL");
                map.put("group_id_list", groupName);
                map.put("image_type", "BASE64");
                map.put("quality_control", "LOW");
                String param = GsonUtils.toJson(map);
                String result = HttpUtil.post(url, PubMessage.baidu_token, "application/json", param);
                //字符串转json数据
                JSONObject jsonObject = new JSONObject(result);
                if(jsonObject.getInt("error_code")==0){
                    String str = jsonObject.getJSONObject("result").toString();
                    jsonObject = new JSONObject(str);
                    String str1 = jsonObject.getJSONArray("user_list").get(0).toString();
                    jsonObject = new JSONObject(str1);
                    System.out.println("用户id:"+jsonObject.getString("user_id"));
                    System.out.println("用户姓名:"+jsonObject.getString("user_info"));
                    System.out.println("相似度:"+jsonObject.getDouble("score"));
                    return jsonObject.getString("user_id")+"#"+jsonObject.getString("user_info");
                }else{
                  return "M";//搜索库不存在此人
                }
            }else return "N";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "N";
    }

    public static void main(String[] args) {
//        cdusn usn = new cdusn();
//        usn.setUsn001("fb675ec29dea4fcc9e0f6ef6a1844006");
//        BaiduService.faceSearch("qm_14","c:\\sun.png");
    }
}
