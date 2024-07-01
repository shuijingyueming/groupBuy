package com.fangx.wx;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.*;
import java.util.*;
  
public class PayUtils {  
     /**   
     * 签名字符串   
     * @param text需要签名的字符串   
     * @param key 密钥   
     * @param input_charset编码格式   
     * @return 签名结果   
     */     
    public static String sign(String text, String key, String input_charset) {     
        text = text + "&key=" + key;     
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));     
    }     
    /**   
     * 签名字符串   
     *  @param text需要签名的字符串   
     * @param sign 签名结果   
     * @param key密钥   
     * @param input_charset 编码格式   
     * @return 签名结果   
     */     
    public static boolean verify(String text, String sign, String key, String input_charset) {     
        text = text + key;     
        String mysign = DigestUtils.md5Hex(getContentBytes(text, input_charset));     
        if(mysign.equals(sign)) {     
            return true;     
        }else{     
            return false;     
        }     
    }     
    /**   
     * @param content   
     * @param charset   
     * @return   
     * @throws SignatureException   
     * @throws UnsupportedEncodingException   
     */     
    public static byte[] getContentBytes(String content, String charset) {     
        if (charset == null || "".equals(charset)) {     
            return content.getBytes();     
        }     
        try {     
            return content.getBytes(charset);     
        } catch (UnsupportedEncodingException e) {     
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);     
        }     
    }     
      
    private static boolean isValidChar(char ch) {     
        if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))     
            return true;     
        if ((ch >= 0x4e00 && ch <= 0x7fff) || (ch >= 0x8000 && ch <= 0x952f))     
            return true;// 简体中文汉字编码     
        return false;     
    }     
    /**   
     * 除去数组中的空值和签名参数   
     * @param sArray 签名参数组   
     * @return 去掉空值与签名参数后的新签名参数组   
     */     
    public static Map<String, String> paraFilter(Map<String, String> sArray) {     
        Map<String, String> result = new HashMap<String, String>();     
        if (sArray == null || sArray.size() <= 0) {     
            return result;     
        }     
        for (String key : sArray.keySet()) {     
            String value = sArray.get(key);     
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")     
                    || key.equalsIgnoreCase("sign_type")) {     
                continue;     
            }     
            result.put(key, value);     
        }     
        return result;     
    }     
    /**   
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串   
     * @param params 需要排序并参与字符拼接的参数组   
     * @return 拼接后字符串   
     */     
    public static String createLinkString(Map<String, String> params) {     
        List<String> keys = new ArrayList<String>(params.keySet());     
        Collections.sort(keys);     
        String prestr = "";     
        for (int i = 0; i < keys.size(); i++) {     
            String key = keys.get(i);     
            String value = params.get(key);     
            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符     
                prestr = prestr + key + "=" + value;     
            } else {     
                prestr = prestr + key + "=" + value + "&";     
            }     
        }     
        return prestr;     
    }
    
    /**   
     *   
     * @param requestUrl请求地址   
     * @param requestMethod请求方法   
     * @param outputStr参数   
     */     
    public static String httpRequest(String requestUrl,String requestMethod,String outputStr){     
        // 创建SSLContext     
        StringBuffer buffer = null;
        try{     
            URL url = new URL(requestUrl);     
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();     
            conn.setRequestMethod(requestMethod);     
            conn.setDoOutput(true);     
            conn.setDoInput(true);     
            conn.connect();     
            //往服务器端写内容     
            if(null !=outputStr){     
                OutputStream os=conn.getOutputStream();     
                os.write(outputStr.getBytes("utf-8"));     
                os.close();     
            }     
            // 读取服务器端返回的内容     
            InputStream is = conn.getInputStream();     
            InputStreamReader isr = new InputStreamReader(is, "utf-8");     
            BufferedReader br = new BufferedReader(isr);     
            buffer = new StringBuffer();     
            String line = null;     
            while ((line = br.readLine()) != null) {     
                buffer.append(line);     
            }     
            
            br.close();  
        }catch(Exception e){     
            e.printStackTrace();     
        }  
        return buffer.toString();  
    }
    
    /**   
     *   
     * @param requestUrl请求地址   
     * @param requestMethod请求方法   
     * @param outputStr参数   
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     */     
    public static String httpsRequest(String requestUrl,String requestMethod,String outputStr) throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException{     
        // 创建SSLContext     
        StringBuffer buffer = null;
        TrustManager[] tm = { new MyX509TrustManager() };
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		// 从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();
        try{     
            URL url = new URL(requestUrl);     
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();  
            conn.setSSLSocketFactory(ssf);
            conn.setRequestMethod(requestMethod);     
            conn.setDoOutput(true);     
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.connect();     
            //往服务器端写内容     
            if(null !=outputStr){     
                OutputStream os=conn.getOutputStream();     
                os.write(outputStr.getBytes("utf-8"));     
                os.close();     
            }     
            // 读取服务器端返回的内容     
            InputStream is = conn.getInputStream();     
            InputStreamReader isr = new InputStreamReader(is, "utf-8");     
            BufferedReader br = new BufferedReader(isr);     
            buffer = new StringBuffer();     
            String line = null;     
            while ((line = br.readLine()) != null) {     
                buffer.append(line);     
            }     
            
            br.close();  
        }catch(Exception e){     
            e.printStackTrace();     
        }  
        return buffer.toString();  
    }
    
    /**   
     * 通过微信商户号证书发送请求
     * @param requestUrl请求地址   
     * @param outputStr参数   
     * @param SSLCERT_PATH证书地址
     * @param SSLCERT_PASSWORD证书密码 
     * @throws Exception 
     */     
    public static String httpsRequest_AQZS(String requestUrl,String outputStr,String SSLCERT_PATH,String SSLCERT_PASSWORD) throws Exception{     
    	//注意PKCS12证书 是从微信商户平台-》账户设置-》 API安全 中下载的
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		//指向你的证书的绝对路径，带着证书去访问
		FileInputStream instream = new FileInputStream(new File(SSLCERT_PATH));//P12文件目录
		try {
			//下载证书时的密码、默认密码是你的MCHID mch_id
			keyStore.load(instream, SSLCERT_PASSWORD.toCharArray());//这里写密码
		} finally {
			instream.close();
		}
		//下载证书时的密码、默认密码是你的MCHID mch_id
		SSLContext sslcontext = SSLContexts.custom()
				.loadKeyMaterial(keyStore, SSLCERT_PASSWORD.toCharArray())//这里也是写密码的
				.build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslcontext,
				new String[] { "TLSv1" },
				null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		CloseableHttpClient httpclient = HttpClients.custom()
				.setSSLSocketFactory(sslsf)
				.build();
		try {
			HttpPost httpost = new HttpPost(requestUrl); // 设置响应头信息
			httpost.addHeader("Connection", "keep-alive");
			httpost.addHeader("Accept", "*/*");
			httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			httpost.addHeader("Host", "api.mch.weixin.qq.com");
			httpost.addHeader("X-Requested-With", "XMLHttpRequest");
			httpost.addHeader("Cache-Control", "max-age=0");
			httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
			httpost.setEntity(new StringEntity(outputStr, "UTF-8"));
			CloseableHttpResponse response = httpclient.execute(httpost);
			try {
				HttpEntity entity = response.getEntity();
				String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
				EntityUtils.consume(entity);
				return jsonStr;
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
    }
    
    public static String urlEncodeUTF8(String source){     
        String result=source;     
        try {     
            result=java.net.URLEncoder.encode(source, "UTF-8");     
        } catch (UnsupportedEncodingException e) {     
                 
            e.printStackTrace();     
        }     
        return result;     
    }   
    /** 
     * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。 
     * @param strxml 
     * @return
     * @throws IOException 
     */  
    public static Map doXMLParse(String strxml) throws Exception {  
        if(null == strxml || "".equals(strxml)) {  
            return null;  
        }  
          
        Map m = new HashMap();  
        InputStream in = String2Inputstream(strxml);  
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new InputStreamReader(in));
        Element root = doc.getRootElement();
        List list = root.getChildren();  
        Iterator it = list.iterator();  
        while(it.hasNext()) {  
            Element e = (Element) it.next();  
            String k = e.getName();  
            String v = "";  
            List children = e.getChildren();  
            if(children.isEmpty()) {  
                v = e.getTextNormalize();  
            } else {  
                v = getChildrenText(children);  
            }  
              
            m.put(k, v);  
        }  
          
        //关闭流  
        in.close();  
          
        return m;  
    }  
    /** 
     * 获取子结点的xml 
     * @param children 
     * @return String 
     */  
    public static String getChildrenText(List children) {  
        StringBuffer sb = new StringBuffer();  
        if(!children.isEmpty()) {  
            Iterator it = children.iterator();  
            while(it.hasNext()) {  
                Element e = (Element) it.next();  
                String name = e.getName();  
                String value = e.getTextNormalize();  
                List list = e.getChildren();  
                sb.append("<" + name + ">");  
                if(!list.isEmpty()) {  
                    sb.append(getChildrenText(list));  
                }  
                sb.append(value);  
                sb.append("</" + name + ">");  
            }  
        }  
          
        return sb.toString();  
    }  
    public static InputStream String2Inputstream(String str) {  
        return new ByteArrayInputStream(str.getBytes());  
    } 
    
    
    /**
     * 获取时间戳
     * @return
     */
    public static String timestamp(){
        String time = String.valueOf(System.currentTimeMillis()/1000);   //获取一个时间戳 转换为String类型
        return time;
    }
    
    /**
     * Created by hubo on 2017/11/7
     * 随机字符串
     */
    public static String nonce_str(){
    	String string = "0123456789";
    	char[] chars =  string.toCharArray();
        String nonce = new String();
        for(int i=0; i<10; i++){
            int rannum = (int)(Math.random()*1000) % (chars.length);
            nonce += chars[rannum];
        }
        return nonce;
    }
    
    /**
     * 加密参数
     * @return
     */
    public static String signs(String api_ticket,String timestamp,String card_id,String nonce_str){

        String[] str = {api_ticket,timestamp,card_id,nonce_str};
        Arrays.sort(str);
        String string = new String();
        for(int i=0; i<4; i++){
            string += str[i];
        }
        String signature = null;    //加密结果
        signature = PayUtils.getSha1(string);  //Sha1加密
        return signature;
    }
    
    public static String getSha1(String str){
        if(str==null||str.length()==0){
            return null;
        }
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }
}  