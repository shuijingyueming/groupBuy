package com.fangx.pub;

import com.fangx.model.*;
import com.fangx.service.*;
import com.fangx.wx.HttpGetUtil;
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
    private CdxxzService xxzService;

    @Autowired
    private CdyhkService yhkService;
    @Autowired
    private CdusdService usdService;
    @Autowired
    private CdyhcService yhcService;
    @Autowired
    private CdusbService usbService;
    @Autowired
    private CdyhaService yhaService;
    @Autowired
    private CdusfService usfService;
    @Autowired
    private CdyscService yscService;
    @Autowired
    private CdysbService ysbService;

    @Autowired
    private ServletContext servletContext;

    protected final static SimpleDateFormat DATE1 = new SimpleDateFormat("yyyy-MM");
    // protected final static SimpleDateFormat DATE2 = new SimpleDateFormat("yyyy-MM");
    protected final static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected final static SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");

    protected final static SimpleDateFormat sf2 = new SimpleDateFormat("HH");
    @Autowired
    properConfig config;

    //tomcat启动执行此方法


    @Override
    public void run(ApplicationArguments args) throws Exception {
        cdxxzWithBLOBs xxz = xxzService.selGetAll();
        //期数
        new Thread(){
            public void run(){
                this.setName("qishi");
                while (true) {
                    try {
                        Thread.sleep(3000);
                        List<cdusb> list= usbService.serachAll();
                        if(list.size()==0){
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(new Date());
//                            calendar.add(Calendar.DAY_OF_MONTH, 3);

                            int i=getWeekDay(calendar);

                            cdusb item = new cdusb();
                            item.setUsb001(1);
                            item.setUsb002("周一");
                            item.setUsb003(2);
                            if(i==item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 8);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, -8);
                            }else{
                                calendar.add(Calendar.DAY_OF_MONTH, 7+item.getUsb003()-i);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003()-7);
                            }
                            usbService.insert(item);
                            item = new cdusb();
                            item.setUsb001(2);
                            item.setUsb002("周二");
                            item.setUsb003(3);
                            if(i==item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 8);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, -8);
                            }else if(i>item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 7+item.getUsb003()-i);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003()-7);
                            }else if(i<item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, item.getUsb003()-i);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003());
                            }
                            usbService.insert(item);
                            item = new cdusb();
                            item.setUsb001(3);
                            item.setUsb002("周三");
                            item.setUsb003(4);
                            if(i==item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 8);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, -8);
                            }else if(i>item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 7+item.getUsb003()-i);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003()-7);
                            }else if(i<item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, item.getUsb003()-i);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003());
                            }
                            usbService.insert(item);
                            item = new cdusb();
                            item.setUsb001(4);
                            item.setUsb002("周四");
                            item.setUsb003(5);
                            if(i==item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 8);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, -8);
                            }else if(i>item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 7+item.getUsb003()-i);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003()-7);
                            }else if(i<item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, item.getUsb003()-i);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003());
                            }
                            usbService.insert(item);
                            item = new cdusb();
                            item.setUsb001(5);
                            item.setUsb002("周五");
                            item.setUsb003(6);
                            if(i==item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 8);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, -8);
                            }else if(i>item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 7+item.getUsb003()-i);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003()-7);
                            }else if(i<item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, item.getUsb003()-i-7);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003()+7);
                            }
                            usbService.insert(item);
                            item = new cdusb();
                            item.setUsb001(6);
                            item.setUsb002("周六");
                            item.setUsb003(7);
                            if(i==item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 8);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, -8);
                            }else if(i>item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 7+item.getUsb003()-i);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003()-7);
                            }else if(i<item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, item.getUsb003()-i);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003());
                            }
                            usbService.insert(item);
                            item = new cdusb();
                            item.setUsb001(7);
                            item.setUsb002("周日");
                            item.setUsb003(1);
                            if(i==item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 8);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, -8);
                            }else if(i>item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, 7+item.getUsb003()-i);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003()-7);
                            }else if(i<item.getUsb003()-1){
                                calendar.add(Calendar.DAY_OF_MONTH, item.getUsb003()-i);
                                item.setUsb008(calendar.getTime());
                                calendar.add(Calendar.DAY_OF_MONTH, i-item.getUsb003());
                            }
                            usbService.insert(item);
                        }

                    } catch (Exception e) { }
                    return;
                }
            }
        }.start();

        //每天 00:12:00订单结单
        new Thread(){
            public void run(){
                this.setName("dayddjd");
                while (true) {
                    try {
                        Thread.sleep(6000);
                        long current = System.currentTimeMillis();// 当前时间毫秒数
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date());
                        calendar.set(Calendar.HOUR_OF_DAY, 12);
                        calendar.set(Calendar.MINUTE, 0);
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);
                        long tomorrowzero1 = calendar.getTimeInMillis();
                        long tomorrowzeroSeconds1 = (tomorrowzero1- current);
                        System.out.println("离12点时间："+tomorrowzeroSeconds1+"秒");
                        if(tomorrowzeroSeconds1>0)Thread.sleep(tomorrowzeroSeconds1);
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                        int i=getWeekDay(calendar);
                        System.out.println("订单结单："+i);
                        cdusb item=usbService.selectByweek2(i);
                        if(item!=null){
                            yhcService.updateByqsid(calendar.getTime());
                            yhaService.deleteByqsid(item.getUsb001());
                            List<cdusf> list=usfService.serachAll();
                            cdyha yha=new cdyha();
                            calendar.add(Calendar.DAY_OF_MONTH, 7);
                            cdysb ysb=ysbService.selectBycpid(sf1.format(calendar.getTime()),null);
                            if(ysb!=null){
                                item.setUsb008(ysb.getYsb004());
                                ysb.setYsb005("A");
                                ysbService.update(ysb);
                            }
                            if(!item.getUsb008().equals(calendar.getTime())&&sf1.parse(sf1.format(item.getUsb008())).before(sf1.parse(sf1.format(calendar.getTime())))){
                                if(ysb==null)item.setUsb008(calendar.getTime());
                                usbService.update(item);
                                for(cdusf usf:list){
                                    cdysc ysc=yscService.selectBycpid(usf.getUsf001(),sf1.format(item.getUsb008()));
                                    yha.setYha002(usf.getUsf001());
                                    yha.setYha003(item.getUsb001());
                                    yha.setYha004(ysc!=null?ysc.getYsc006():usf.getUsf010());
                                    yha.setYha005(usf.getUsf010()==0&ysc==null?"P":"C");
                                    yha.setYha006(0);
                                    yhaService.insert(yha);
                                    if(ysc!=null)yscService.delete(ysc.getYsc001());
                                }
                            }else{
                                System.out.println("订单已结单");
                            }
                        }
                        long tomorrowzero = calendar.getTimeInMillis();
                        long tomorrowzeroSeconds = (tomorrowzero- current);
                        System.out.println("离结单时间："+tomorrowzeroSeconds+"秒");
                        Thread.sleep(tomorrowzeroSeconds);
                    } catch (Exception e) { }
                }
            }
        }.start();

        //数据备份
        new Thread(){
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

        //每天 00:00:10做日对账,主要对账前一天数据
        new Thread(){
            public void run(){
                this.setName("daydj");
                while (true) {
                    try {
                        Thread.sleep(3000);
                        long current = System.currentTimeMillis();// 当前时间毫秒数
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date());
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                        calendar.set(Calendar.HOUR_OF_DAY, 0);
                        calendar.set(Calendar.MINUTE, 0);
                        calendar.set(Calendar.SECOND, 10);
                        calendar.set(Calendar.MILLISECOND, 0);
                        //日对账表
                        Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
                        ca.setTime(new Date()); //设置时间为当前时间
                        ca.add(Calendar.DATE, -1);//前一天
                        cdyhk yhk=yhkService.selectBycurentday(ca.getTime(),null);
                        //电站日对账
                        List<cdusd> usdlist=usdService.serachAll();
                        for(cdusd usd:usdlist){
                            yhk=yhkService.selectBycurentday(ca.getTime(),usd.getUsd001());
                            if(yhk==null){
                                yhk=new cdyhk();
                                yhk.setYhk001(UUID.randomUUID().toString().replaceAll("-", ""));
                                yhk.setYhk002(usd.getUsd001());
                                yhk.setYhk003(sf.parse(sf1.format(ca.getTime())+" 00:00:00"));
                                yhk.setYhk005(yhcService.selectBygsid(ca.getTime(),usd.getUsd001(),"P",null));
                                yhk.setYhk006(yhcService.selectBygsid(ca.getTime(),usd.getUsd001(),"W",null));
                                yhk.setYhk008(getWeekDay(ca));
                                yhkService.insert(yhk);
                            }else{
                                System.out.println(usd.getUsd002()+"日对账");
                            }
                        }
                        long tomorrowzero = calendar.getTimeInMillis();
                        long tomorrowzeroSeconds = (tomorrowzero- current);
                        System.out.println("离日对账时间："+tomorrowzeroSeconds+"秒");
                        Thread.sleep(tomorrowzeroSeconds);
                    } catch (Exception e) { }
                }
            }
        }.start();


        //线程获取微信的token
    new Thread(){
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
                        Thread.sleep(7100000);//7200秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    private Integer getWeekDay(Calendar c){
        if(c == null){
            return 2;
        }
        if(Calendar.MONDAY == c.get(Calendar.DAY_OF_WEEK)){
            return 2;
        }
        if(Calendar.TUESDAY == c.get(Calendar.DAY_OF_WEEK)){
            return 3;
        }
        if(Calendar.WEDNESDAY == c.get(Calendar.DAY_OF_WEEK)){
            return 4;
        }
        if(Calendar.THURSDAY == c.get(Calendar.DAY_OF_WEEK)){
            return 5;
        }
        if(Calendar.FRIDAY == c.get(Calendar.DAY_OF_WEEK)){
            return 6;
        }
        if(Calendar.SATURDAY == c.get(Calendar.DAY_OF_WEEK)){
            return 7;
        }
        if(Calendar.SUNDAY == c.get(Calendar.DAY_OF_WEEK)){
            return 1;
        }
        return 2;
    }
}
