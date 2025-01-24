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
    private CdyhbService yhbService;

    @Autowired
    private ServletContext servletContext;

    protected final static SimpleDateFormat DATE1 = new SimpleDateFormat("yyyy-MM");

    protected final static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected final static SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");

    protected final static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
    protected final static SimpleDateFormat sdf4 = new SimpleDateFormat("MM");
    protected final static SimpleDateFormat sdf5 = new SimpleDateFormat("dd");
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
                        Thread.sleep(1000);
                        Integer list= usbService.serachAll2("A");
                        Integer list1= usbService.serachAll2("B");
                        if(list==0||list1==0){
                            List<cdusf> list2=usfService.serachAll();
                            cdusb item = new cdusb();
                            if(list==0){
                                item.setUsb001(1);
                                item.setUsb002("周一");
                                item.setUsb003(2);
                                item.setUsb005("A");
                                item=usbService.insert(item);
                               setList(item.getUsb001(),null,item.getUsb005(),list2);
                                item = new cdusb();
                                item.setUsb001(2);
                                item.setUsb002("周二");
                                item.setUsb003(3);
                                item.setUsb005("A");
                                item=usbService.insert(item);
                               setList(item.getUsb001(),null,item.getUsb005(),list2);
                                item = new cdusb();
                                item.setUsb001(3);
                                item.setUsb002("周三");
                                item.setUsb003(4);
                                item.setUsb005("A");
                                item=usbService.insert(item);
                               setList(item.getUsb001(),null,item.getUsb005(),list2);
                                item = new cdusb();
                                item.setUsb001(4);
                                item.setUsb002("周四");
                                item.setUsb003(5);
                                item.setUsb005("A");
                                item=usbService.insert(item);
                               setList(item.getUsb001(),null,item.getUsb005(),list2);
                                item = new cdusb();
                                item.setUsb001(5);
                                item.setUsb002("周五");
                                item.setUsb003(6);
                                item.setUsb005("A");
                                item=usbService.insert(item);
                               setList(item.getUsb001(),null,item.getUsb005(),list2);
                                item = new cdusb();
                                item.setUsb001(6);
                                item.setUsb002("周六");
                                item.setUsb003(7);
                                item.setUsb005("A");
                                item=usbService.insert(item);
                               setList(item.getUsb001(),null,item.getUsb005(),list2);
                                item = new cdusb();
                                item.setUsb001(7);
                                item.setUsb002("周日");
                                item.setUsb003(1);
                                item.setUsb005("A");
                                item=usbService.insert(item);
                               setList(item.getUsb001(),null,item.getUsb005(),list2);
                            }

                            if(list1==0){
                                for(int i=1;i<32;i++){
                                    item = new cdusb();
                                    item.setUsb001(7+i);
                                    item.setUsb002(i+"号");
                                    item.setUsb003(i);
                                    item.setUsb005("B");
                                    usbService.insert(item);
                                    setList(7+i,null,"B",list2);
                                }
                            }
                        }
                    } catch (Exception e) { }
                    return;
                }
            }
        }.start();


        /*new Thread(){
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
                            yhcService.updateByqsid(calendar.getTime());//订单结单
                            List<cdusf> list=usfService.serachAll();
                            cdyha yha=new cdyha();
                            calendar.add(Calendar.DAY_OF_MONTH, 7);
                            cdysb ysb=ysbService.selectBycpid(sf1.format(calendar.getTime()),null);
                            if(ysb!=null){
                                item.setUsb008(ysb.getYsb004());
                                ysb.setYsb005("A");
                                ysbService.update(ysb);
                            }
                            if(!item.getUsb008().equals(calendar.getTime())){
                                if(ysb==null){
                                    item.setUsb008(calendar.getTime());
                                }
                                usbService.update(item);
                                yhaService.deleteByqsid(item.getUsb001());
                                for(cdusf usf:list){
                                    cdysc ysc=yscService.selectBycpid(usf.getUsf001(),sf1.format(item.getUsb008()));
                                    yha.setYha002(usf.getUsf001());
                                    yha.setYha003(item.getUsb001());
                                    yha.setYha004(ysc!=null?ysc.getYsc006():usf.getUsf010());
                                    yha.setYha005(usf.getUsf010()==0&ysc==null?"P":"C");
                                    yha.setYha008(ysc!=null?ysc.getYsc006():usf.getUsf010());
                                    yhaService.insert(yha);
                                    if(ysc!=null){
                                        ysc.setYsc005("A");
                                        yscService.update(ysc);
//                                        yscService.delete(ysc.getYsc001());
                                    }
                                }
                            }else{
                                System.out.println("订单已结单");
                            }
                            calendar.add(Calendar.DAY_OF_MONTH, -7);
                        }
                        long tomorrowzero = calendar.getTimeInMillis();
                        long tomorrowzeroSeconds = (tomorrowzero- current);
                        System.out.println("离结单时间："+tomorrowzeroSeconds+"秒");
                        Thread.sleep(tomorrowzeroSeconds);
                    } catch (Exception e) { }
                }
            }
        }.start();*/

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
                        PubMessage.setXxz(xxz);
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
//        new Thread(){
//            public void run(){
//                this.setName("daydj");
//                while (true) {
//                    try {
//                        Thread.sleep(3000);
//                        long current = System.currentTimeMillis();// 当前时间毫秒数
//                        Calendar calendar = Calendar.getInstance();
//                        calendar.setTime(new Date());
//                        calendar.add(Calendar.DAY_OF_MONTH, 1);
//                        calendar.set(Calendar.HOUR_OF_DAY, 0);
//                        calendar.set(Calendar.MINUTE, 0);
//                        calendar.set(Calendar.SECOND, 10);
//                        calendar.set(Calendar.MILLISECOND, 0);
//                        //日对账表
//                        Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
//                        ca.setTime(new Date()); //设置时间为当前时间
//                        ca.add(Calendar.DATE, -1);//前一天
//                        cdyhk yhk=yhkService.selectBycurentday(ca.getTime(),null);
//                        //电站日对账
//                        List<cdusd> usdlist=usdService.serachAll(null);
//                        for(cdusd usd:usdlist){
//                            yhk=yhkService.selectBycurentday(ca.getTime(),usd.getUsd001());
//                            if(yhk==null){
//                                yhk=new cdyhk();
//                                yhk.setYhk001(UUID.randomUUID().toString().replaceAll("-", ""));
//                                yhk.setYhk002(usd.getUsd001());
//                                yhk.setYhk003(sf.parse(sf1.format(ca.getTime())+" 00:00:00"));
//                                yhk.setYhk005(yhcService.selectBygsid(ca.getTime(),usd.getUsd001(),"P",null));
//                                yhk.setYhk006(yhcService.selectBygsid(ca.getTime(),usd.getUsd001(),"W",null));
//                                yhk.setYhk008(getWeekDay(ca));
//                                yhkService.insert(yhk);
//                            }else{
//                                System.out.println(usd.getUsd002()+"日对账");
//                            }
//                        }
//                        long tomorrowzero = calendar.getTimeInMillis();
//                        long tomorrowzeroSeconds = (tomorrowzero- current);
//                        System.out.println("离日对账时间："+tomorrowzeroSeconds+"秒");
//                        Thread.sleep(tomorrowzeroSeconds);
//                    } catch (Exception e) { }
//                }
//            }
//        }.start();


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
                        calendar.set(Calendar.MINUTE, 00);
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);
                        long tomorrowzero1 = calendar.getTimeInMillis();
                        long tomorrowzeroSeconds1 = (tomorrowzero1- current);
                        System.out.println("离12点时间："+tomorrowzeroSeconds1+"秒");
                        if(tomorrowzeroSeconds1>0)Thread.sleep(tomorrowzeroSeconds1);//todo
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                        Date date=calendar.getTime();//明天
                        int i=getWeekDay(calendar);
                        System.out.println("订单结单周期："+i);
                        yhcService.updateByqsid(calendar.getTime());//订单结单
                        List<cdusf> list=usfService.serachAll();

                        //按周
                        calendar.add(Calendar.DAY_OF_MONTH, 7);
                        cdusb item=usbService.selectBytimew(i);
                        List<Integer> gslist=yhbService.seletebyid(item.getUsb001());
                        int sl=ysbService.countBygstime(null,sf1.format(calendar.getTime()),sf1.format(calendar.getTime()),"A",null);
                        cdysb ysb=new cdysb();
                        boolean flag=false;
                        if(sl==0){
                            for(Integer id:gslist){
                                //配送时间之间
                                int s=ysbService.countBygstime1(id,null,sf1.format(calendar.getTime()),"A",null);
                                if(s==0){
                                    //不配送
                                    s=ysbService.countBygstime(id,null,sf1.format(calendar.getTime()),"A","B");
                                    if(s==0){
                                        //原配送时间
                                        s=ysbService.countBygstime(id,sf1.format(calendar.getTime()),null,"A",null);
                                        if(s==0){
                                            ysb=new cdysb();
                                            ysb.setYsb002(id);
                                            ysb.setYsb003(calendar.getTime());
                                            ysb.setYsb004(calendar.getTime());
                                            ysb.setYsb005("A");
                                            ysb.setYsb006(item.getUsb001());
                                            ysb.setYsb008("A");
                                            ysbService.insert(ysb);
                                            if(!flag)flag=true;
                                        }
                                    }
                                }
                            }
                            if(flag){
                                yhaService.deleteByqsid(item.getUsb001());
                                setList(item.getUsb001(),sf1.format(calendar.getTime()),item.getUsb005(),list);
                            }
                        }
                        cdusb usb=usbService.getBytime(sf1.format(calendar.getTime()), "B", "A");
                        if(usb!=null){
                            ysbService.updateByqsid(usb.getUsb001(),item.getUsb001());
                            List<cdyha> qslist=yhaService.serachAll(item.getUsb001());
                            for(cdyha yha:qslist){
                                if(yha.getYha006().equals("C")){
                                    cdyha yha1=yhaService.getByqscp(usb.getUsb001(),yha.getYha002());
                                    if(yha1.getYha006().equals("C")){
                                        yha.setYha004(yha.getYha004()+yha1.getYha004());
                                        yhaService.update(yha);
                                    }
                                }
                            }
                            yhaService.deleteByqsid(usb.getUsb001());
                            usbService.delete(usb.getUsb001());
                        }
                        calendar.setTime(date);
                        int md=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                        calendar.add(Calendar.DAY_OF_MONTH, md);
                        //按月
//                        Integer n= Integer.valueOf(sdf2.format(date));
//                        Integer y= Integer.valueOf(sdf4.format(date));
//                        Integer r= Integer.valueOf(sdf5.format(date));
//                        System.out.println("订单结单日期："+r);
//                        String xiayue=((y+1)>12?n+1:n)+"-"+((y+1)>12?y-10:(y+1)>10?(y+1):"0"+(y+1))+"-"+(r>10?r:"0"+r);
                        String xiayue=sf1.format(calendar.getTime());
                        item=usbService.selectByzq(Integer.valueOf(sdf5.format(date)),"B");
                        gslist=yhbService.seletebyid(item.getUsb001());
                        sl=ysbService.countBygstime(null,xiayue,xiayue,"B",null);
                       flag=false;
                        if(sl==0){
                            for(Integer id:gslist){
                                //配送时间之间
                                int s=ysbService.countBygstime1(id,null,xiayue,"B",null);
                                if(s==0){
                                    //不配送
                                    s=ysbService.countBygstime(id,null,xiayue,"B","B");
                                    if(s==0){
                                        //原配送时间
                                        s=ysbService.countBygstime(id,xiayue,null,"A",null);
                                        if(s==0){
                                            ysb=new cdysb();
                                            ysb.setYsb002(id);
                                            ysb.setYsb003(calendar.getTime());
                                            ysb.setYsb004(calendar.getTime());
                                            ysb.setYsb005("A");
                                            ysb.setYsb006(item.getUsb001());
                                            ysb.setYsb008("B");
                                            ysbService.insert(ysb);
                                            if(!flag)flag=true;
                                        }
                                    }
                                }
                            }
                            if(flag){
                                yhaService.deleteByqsid(item.getUsb001());
                                setList(item.getUsb001(),sf1.format(calendar.getTime()),item.getUsb005(),list);
                            }
                        }
                        usb=usbService.getBytime(xiayue, "B", "A");
                        if(usb!=null){
                            ysbService.updateByqsid(usb.getUsb001(),item.getUsb001());
                            List<cdyha> qslist=yhaService.serachAll(item.getUsb001());
                            for(cdyha yha:qslist){
                                if(yha.getYha006().equals("C")){
                                    cdyha yha1=yhaService.getByqscp(usb.getUsb001(),yha.getYha002());
                                    if(yha1.getYha006().equals("C")){
                                        yha.setYha004(yha.getYha004()+yha1.getYha004());
                                        yhaService.update(yha);
                                    }
                                }
                            }
                            yhaService.deleteByqsid(usb.getUsb001());
                            usbService.delete(usb.getUsb001());
                        }
                        calendar.setTime(date);
                        long tomorrowzero = calendar.getTimeInMillis();
                        long tomorrowzeroSeconds = (tomorrowzero- current);
                        System.out.println("离结单时间："+tomorrowzeroSeconds+"秒");
                        Thread.sleep(tomorrowzeroSeconds);
                    } catch (Exception e) { }
                }
            }
        }.start();
    }

    private void setList(Integer id,String date,String lx,List<cdusf> list){
        //生成库存
        cdyha yha=new cdyha();
        for(cdusf usf:list){
            cdysc ysc=date==null?null:yscService.selectBycpid(usf.getUsf001(),date, lx);
            yha.setYha002(usf.getUsf001());
            yha.setYha003(id);
            yha.setYha004(ysc!=null?ysc.getYsc006():(usf.getUsf010()!=null?usf.getUsf010():0));
            yha.setYha005(usf.getUsf010()==null&ysc==null?"P":"C");
            yha.setYha006(0);
            yha.setYha008(ysc!=null?ysc.getYsc006():usf.getUsf010());
            yha.setYha009(ysc!=null?ysc.getYsc007():(usf.getUsf013().equals("C")?"B":"A"));
            yhaService.insert(yha);
            if(ysc!=null){
                ysc.setYsc005("A");
                yscService.update(ysc);
//                                        yscService.delete(ysc.getYsc001());
            }
        }
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

    public static String ToCH(int intInput) {
        String si = String.valueOf(intInput);
        String sd = "";
        if (si.length() == 1) // 個
        {
            sd += GetCH(intInput);
            return sd;
        } else if (si.length() == 2)// 十
        {
            if (si.substring(0, 1).equals("1"))
                sd += "十";
            else
                sd += (GetCH(intInput / 10) + "十");
            sd += ToCH(intInput % 10);
        } else if (si.length() == 3)// 百
        {
            sd += (GetCH(intInput / 100) + "百");
            if (String.valueOf(intInput % 100).length() < 2)
                sd += "零";
            sd += ToCH(intInput % 100);
        } else if (si.length() == 4)// 千
        {
            sd += (GetCH(intInput / 1000) + "千");
            if (String.valueOf(intInput % 1000).length() < 3)
                sd += "零";
            sd += ToCH(intInput % 1000);
        } else if (si.length() == 5)// 萬
        {
            sd += (GetCH(intInput / 10000) + "萬");
            if (String.valueOf(intInput % 10000).length() < 4)
                sd += "零";
            sd += ToCH(intInput % 10000);
        }

        return sd;
    }

    private static String GetCH(int input) {
        String sd = "";
        switch (input) {
            case 1:
                sd = "一";
                break;
            case 2:
                sd = "二";
                break;
            case 3:
                sd = "三";
                break;
            case 4:
                sd = "四";
                break;
            case 5:
                sd = "五";
                break;
            case 6:
                sd = "六";
                break;
            case 7:
                sd = "七";
                break;
            case 8:
                sd = "八";
                break;
            case 9:
                sd = "九";
                break;
            default:
                break;
        }
        return sd;
    }

}
