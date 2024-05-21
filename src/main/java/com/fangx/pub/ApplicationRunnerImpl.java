package com.efx.quality.pub;


import com.efx.quality.model.PubMessage;
import com.efx.quality.until.BaiduService;
import com.efx.quality.wx.HttpGetUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.*;


@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    private final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    
    @Autowired
    private ServletContext servletContext;

    protected final static SimpleDateFormat DATE1 = new SimpleDateFormat("yyyy-MM");
    // protected final static SimpleDateFormat DATE2 = new SimpleDateFormat("yyyy-MM");
    @Autowired
    properConfig config;

    //tomcat启动执行此方法
    @Override
    public void run(ApplicationArguments args) throws Exception {
    
		
        //数据备份

 /*       new Thread(){
            public void run(){
                this.setName("beifen");
                while (true) {
                    try {
                        long current = System.currentTimeMillis();// 当前时间毫秒数
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                        calendar.set(Calendar.HOUR_OF_DAY, 0);
                        calendar.set(Calendar.MINUTE, 0);
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);
                        long tomorrowzero = calendar.getTimeInMillis();
                        long tomorrowzeroSeconds = (tomorrowzero- current);
                        //按天算+早上2：00,睡眠毫秒数
                        Thread.sleep(((xxz.getXxz014()-1)*86400000)+tomorrowzeroSeconds);
                        if (Datamsg.exportDatabaseTool(config.getJdbcurl(), config.getJdbcdk(),
                                config.getUsername(),config.getPassword(),
                                "c:\\backup\\","clzps("+sdf1.format(new Date())+").sql",config.getDataname(),
                                this.getClass().getResource("/").getPath()+"\\")) {
                            System.out.println("数据库成功备份！！！");
                        } else {
                            System.out.println("数据库备份失败！！！");
                        }
                    } catch (InterruptedException e) { }
                }
            }
        }.start();
*/

        //线程获取微信的token
 /*      new Thread(){
            public void run(){
                while (true){
                    try {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("secret", PubMessage.secret);
                        params.put("appid", PubMessage.appid);
                        params.put("grant_type", "client_credential");
                        String requestUrl = HttpGetUtil.httpRequestToString("https://api.weixin.qq.com/cgi-bin/token", params);
                        JSONObject result= JSONObject.fromObject(requestUrl);
                        PubMessage.access_token = result.getString("access_token");
                        System.out.println(new Date()+"----微信token获取："+PubMessage.access_token);
                        params.put("secret", PubMessage.secretxx);
                        params.put("appid", PubMessage.appidxx);
                        params.put("grant_type", "client_credential");
                        requestUrl = HttpGetUtil.httpRequestToString("https://api.weixin.qq.com/cgi-bin/token", params);
                        result= JSONObject.fromObject(requestUrl);
                        PubMessage.access_tokenxx = result.getString("access_token");
                        System.out.println(new Date()+"----xx微信token获取："+ PubMessage.access_tokenxx);
                        params.put("secret", PubMessage.secretds);
                        params.put("appid", PubMessage.appidds);
                        params.put("grant_type", "client_credential");
                        requestUrl = HttpGetUtil.httpRequestToString("https://api.weixin.qq.com/cgi-bin/token", params);
                        result= JSONObject.fromObject(requestUrl);
                        PubMessage.access_tokends = result.getString("access_token");
                        System.out.println(new Date()+"----ds微信token获取："+ PubMessage.access_tokends);
                        params.put("secret", PubMessage.secretrj);
                        params.put("appid", PubMessage.appidrj);
                        params.put("grant_type", "client_credential");
                        requestUrl = HttpGetUtil.httpRequestToString("https://api.weixin.qq.com/cgi-bin/token", params);
                        result= JSONObject.fromObject(requestUrl);
                        PubMessage.access_tokends = result.getString("access_token");
                        System.out.println(new Date()+"----rj微信token获取："+ PubMessage.access_tokenrj);
                        Thread.sleep(7100000);//7200秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
*/
     
    }

}
