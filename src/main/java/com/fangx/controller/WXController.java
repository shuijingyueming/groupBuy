package com.fangx.controller;

import com.alibaba.fastjson.JSON;
import com.fangx.model.*;
import com.fangx.until.SendSms;
import com.fangx.wx.PayUtils;
import com.fangx.wx.RandomStringGenerator;
import com.fangx.wx.WeiCatJK;
import net.sf.json.JSONObject;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
public class WXController extends BaseController {
    /**
     * 获取用户openid
     * 王新苗
     * @param code
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/MingPianfirstIN", method = RequestMethod.POST)
    public String MingPianfirstIN(String code,String type,String zt) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
//        System.out.println(code);
        JSONObject json = WeiCatJK.queryOpenid(code, PubMessage.appid,PubMessage.secret);
//        System.out.println(json);
        // 查找原客户
        if (json != null && !json.get("openid").equals("")) {
//            System.out.println(TIMEMIAO.format(new Date())+"-----"+json.getString("openid"));
            cdusc usc=uscService.selectByOpenid((String) json.get("openid"));
            result.put("item", usc);
            result.put("openid", json.get("openid"));
            result.put("pk", json.get("session_key"));
        }
        return JSON.toJSONString(result);
    }

    /**
     * 判断手机号
     */
    @ResponseBody
    @RequestMapping(value = "/panduanphone")
    public String panduanphone(HttpServletRequest request, String code) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String phone = request.getParameter("phone");
        String openid = request.getParameter("openid");
        String gsid = request.getParameter("gsid");
//        System.out.println(phone+"------phone2");
        //按电话号码查找老师
        cdusc usc=uscService.selectByPhone(phone);
        if(usc!=null){
            if(usc.getUsc003().equals("B")){
                addLog(getIpAdrress(request),"手机号："+phone+"，登录时账户已封号");
                result.put("msg", "C");
//				}else if(xtm.getXtm004()!=null&&!xtm.getXtm004().toString().isEmpty()&&!openid.equals(xtm.getXtm004())){
//					dlyc(getIpAdrress(request),"手机号："+phone+"，登录时账户已在别处登录");
//					jsob.put("msg", "D");
            }else if(!usc.getUsc005().toString().equals(gsid)){
                result.put("msg", "E");
            }else{
                result.put("item", usc);
                result.put("msg", "A");
            }
        }else{
            addLog(getIpAdrress(request),"手机号："+phone+"，登录时账户不存在");
            result.put("msg", "B");
        }
        return JSON.toJSONString(result);
    }

    /**
     * 发送验证码
     * 王新苗
     * @return 验证码
     */
    @ResponseBody
    @RequestMapping(value="/SendSms")
    public Map<String,Object> SendSms(HttpServletRequest request,HttpServletResponse response)throws Exception{
        Map<String,Object> map=new HashMap<>();
        Properties pro = PropertiesLoaderUtils.loadAllProperties("DX.properties");
        String phone = request.getParameter("phone").toString().trim();
        if(phone!=null&&!phone.toString().isEmpty()){
            int sjs = (int)((Math.random()*9+1)*100000);
            JSONObject json= SendSms.fasongdx(PubMessage.getXxz().getXxz020(), PubMessage.getXxz().getXxz021(), phone, pro.getProperty("SignName"), sjs+"", pro.getProperty("Domain"), pro.getProperty("TemplateCode"));
//            System.out.println(json);
            if("OK".equals(json.get("Code"))){
                map.put("yzm", sjs);
            }
            map.put("code", json.get("Code"));

        }
        return map;
    }

    /**
     * 用户手机号授权并保存用户信息
     * 王新苗
     * @param
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/deciphering")
    public String deciphering(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String openid = request.getParameter("openid");
        String avatarUrl = request.getParameter("avatarUrl");
        String nickName = request.getParameter("nickName");
//        String code = request.getParameter("pk");
//        String iv = request.getParameter("ivdata");
//        String encryptedData =  request.getParameter("encrypdata");
        String gsid = request.getParameter("gsid");
        String phone=request.getParameter("phone");
//        if(encryptedData!=null&&code!=null&&phone!=null) phone =  WeiCatJK.decrypt_new(encryptedData,code,iv);
//        System.out.println(TIMEMIAO.format(new Date())+"phone----"+phone);
//        if(phone!=null){
        cdusc usc=uscService.selectByPhone(phone);
        if(usc.getUsc005()==Integer.valueOf(gsid)){
            usc.setUsc004(openid);
            usc.setUsc006(nickName);
            usc.setUsc007(avatarUrl);
            uscService.update(usc);
            result.put("item", usc);
            result.put("msg", "1");
        }else if(usc!=null){
            result.put("msg", "2");
        }else{
            result.put("msg", "0");
        }
        return JSON.toJSONString(result);
    }

    /**
     * 公司
     * 王新苗
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/wxgs", method = RequestMethod.POST)
    public String wxgs(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        List<cdusd> list=usdService.serachAll();
        result.put("list", list);
        return JSON.toJSONString(result);
    }


    /**
     * 期数
     * 王新苗
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/wxqs1", method = RequestMethod.POST)
    public String wxqs1(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String gsid=request.getParameter("gsid");
        if(gsid!=null){
            List<Integer> list=usbService.serachAllweek(Integer.valueOf(gsid));
            Date d=new Date();
            Calendar ca = Calendar.getInstance();
            ca.setTime(d);
            //在临时日期之间
            ca.add(Calendar.DAY_OF_MONTH,1);
            cdysb ysb=ysbService.selectBygs(DATE.format(ca.getTime()),list);
            if(ysb!=null){
                ca.setTime(ysb.getYsb003());
                cdusb item=usbService.selectByzq(getWeekDay(ca));
                result.put("item", item);
            }else{
                ca.add(Calendar.DAY_OF_MONTH,-1);
                Integer i=getWeekDay(ca);
                cdusb item=usbService.selectByweek(Integer.valueOf(gsid),i==7?0:i);
                if(item==null)item=usbService.selectByweek1(Integer.valueOf(gsid),i==1?8:i);
//            ca.add(Calendar.DAY_OF_MONTH,7+item.getUsb003()-i);
//            result.put("date", ca.getTime());
                result.put("item", item);
            }

        }/*else{
            Date d=new Date();
            Calendar ca = Calendar.getInstance();
            ca.setTime(d);
//            ca.add(Calendar.DAY_OF_MONTH,-3);
            Integer i=getWeekDay(ca);
            cdusb item=usbService.selectByweek(i==7?0:i);
            if(item==null)item=usbService.selectByweek1(i==1?8:i);
            ca.add(Calendar.DAY_OF_MONTH,7+item.getUsb003()-i);
            result.put("date", ca.getTime());
            result.put("item", item);
            List<cdusb> list=usbService.serachAll();
//            for(cdusb usb:list){
//                usb.setUsb007(getWeek(usb.getUsb003()));
//            }
            result.put("list", list);
        }*/
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping(value = "/wxqs", method = RequestMethod.POST)
    public String wxqs(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String gsid=request.getParameter("gsid");
        if(gsid!=null){
            List<Integer> list=usbService.serachAllweek(Integer.valueOf(gsid));
            Date d=new Date();
            Calendar ca = Calendar.getInstance();
            ca.setTime(d);
            ca.set(Calendar.HOUR_OF_DAY, 12);
            long current = System.currentTimeMillis();
            long tomorrowzero1 = ca.getTimeInMillis();
            long tomorrowzeroSeconds1 = (tomorrowzero1- current);
//            System.out.println("离12点时间："+tomorrowzeroSeconds1+"秒");
            if(tomorrowzeroSeconds1>0){
                //全部 在临时日期之间
                cdysb ysb=ysbService.selectBygs1(DATE.format(ca.getTime()),list);
                if(ysb!=null&&ysb.getYsb004()!=null){
                    ca.setTime(ysb.getYsb003());
                    cdusb item=usbService.selectByzq(getWeekDay(ca));
                    result.put("item", item);
                }else{
                    //个别 在临时日期之间
                    ysb=ysbService.selectBygs2(DATE.format(ca.getTime()),list, Integer.valueOf(gsid));
                    if(ysb!=null&&ysb.getYsb004()!=null){
                        ca.setTime(ysb.getYsb003());
                        cdusb item=usbService.selectByzq(getWeekDay(ca));
                        result.put("item", item);
                    }else{
                        Integer i=getWeekDay(ca);
                        cdusb item=usbService.selectByweek5(Integer.valueOf(gsid),i==7?0:i, null);
                        if(item==null)item=usbService.selectByweek6(Integer.valueOf(gsid),i==1?8:i, null);
                        cdysb ysb1=ysbService.selectBygs3(DATE.format(ca.getTime()),Integer.valueOf(gsid));
                        if(ysb1!=null){
                            if(list.size()==1){
                                Calendar ca1 = Calendar.getInstance();
                                ca1.setTime(ysb1.getYsb003());
                                ca1.add(Calendar.DAY_OF_MONTH, 7);
                                item=usbService.getBytime(DATE.format(ca1.getTime()));
                            }else{
                                Integer i1=item.getUsb001();
                                item=usbService.selectByweek5(Integer.valueOf(gsid),i==7?0:i,i1);
                                if(item==null)item=usbService.selectByweek6(Integer.valueOf(gsid),i==1?8:i,i1);
                            }
                        }
                        result.put("item", item);
                    }
                }
            }else{
                //全部 在临时日期之间
                ca.add(Calendar.DAY_OF_MONTH,1);
                cdysb ysb=ysbService.selectBygs1(DATE.format(ca.getTime()),list);
                if(ysb!=null&&ysb.getYsb004()!=null){
                    ca.setTime(ysb.getYsb003());
                    cdusb item=usbService.selectByzq(getWeekDay(ca));
                    result.put("item", item);
                }else{
                    //个别 在临时日期之间
                    ysb=ysbService.selectBygs2(DATE.format(ca.getTime()),list, Integer.valueOf(gsid));
                    if(ysb!=null&&ysb.getYsb004()!=null){
                        ca.setTime(ysb.getYsb003());
                        cdusb item=usbService.selectByzq(getWeekDay(ca));
                        result.put("item", item);
                    }else{
                        ca.add(Calendar.DAY_OF_MONTH,-1);
                        Integer i=getWeekDay(ca);
                        cdusb item=usbService.selectByweek3(Integer.valueOf(gsid),i==7?0:i, null);
                        if(item==null)item=usbService.selectByweek4(Integer.valueOf(gsid),i==1?8:i, null);
                        ca.add(Calendar.DAY_OF_MONTH,7+item.getUsb003()-i);
                        cdysb ysb1=ysbService.selectBygs3(DATE.format(ca.getTime()),Integer.valueOf(gsid));
                        if(ysb1!=null){
                            if(list.size()==1){
                                Calendar ca1 = Calendar.getInstance();
                                ca1.setTime(ysb1.getYsb003());
                                ca1.add(Calendar.DAY_OF_MONTH, 7);
                                item=usbService.getBytime(DATE.format(ca1.getTime()));
                            }else{
                                Integer i1=item.getUsb001();
                                item=usbService.selectByweek3(Integer.valueOf(gsid),i==7?0:i,i1);
                                if(item==null)item=usbService.selectByweek4(Integer.valueOf(gsid),i==1?8:i,i1);
                            }
                        }
                        result.put("item", item);
                    }
                }
            }


        }
        return JSON.toJSONString(result);
    }

    /**
     * 类型
     * 王新苗
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/wxlx", method = RequestMethod.POST)
    public String wxlx(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        List<cdyhe> list=yheService.serachAll(null);
        result.put("list", list);
        return JSON.toJSONString(result);
    }

    /**
     * 购物车
     * 王新苗
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/wxgwc", method = RequestMethod.POST)
    public String wxgwc(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String yhid=request.getParameter("yhid");
        if(yhid!=null&&!yhid.isEmpty()){
            List<cdush> list=ushService.selectByyhid(Integer.valueOf(yhid));
            if(request.getParameter("qsid")!=null){
                for(cdush ush:list){
                    ush.setYha(yhaService.getByqscp(Integer.valueOf(request.getParameter("qsid")),ush.getUsh003()));
                }
            }
            result.put("list", list);
        }else{
            result.put("msg", "0");
        }
        return JSON.toJSONString(result);
    }

    /**
     * 删除商品
     * 王新苗
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/wxgwcdel", method = RequestMethod.POST)
    public String wxgwcdel(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        ushService.deleteById(request.getParameter("id"));
        result.put("msg", "A");
        return JSON.toJSONString(result);
    }

    /**
     * 购物车
     * 王新苗
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/wxjs", method = RequestMethod.POST)
    public String wxjs(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String yhid=request.getParameter("yhid");
        String id=request.getParameter("id");
        if(yhid!=null&&!yhid.isEmpty()){
            List<cdush> list=ushService.selectByyhidjs(Integer.valueOf(yhid),id);
            if(request.getParameter("qsid")!=null){
                for(cdush ush:list){
                    ush.setYha(yhaService.getByqscp(Integer.valueOf(request.getParameter("qsid")),ush.getUsh003()));
                }
            }
            result.put("list", list);
        }else{
            result.put("msg", "0");
        }
        return JSON.toJSONString(result);
    }

    /**
     *
     * 王新苗
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/wxgwcsl", method = RequestMethod.POST)
    public String wxgwcsl(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String id=request.getParameter("id");
        Integer sl=Integer.valueOf(request.getParameter("sl"));
        if(id!=null&&!id.isEmpty()){
            cdush item=ushService.getByid(request.getParameter("id"));
            item.setUsh004(sl);
            item.setUsh005(item.getUsf().getUsf006()!=null&&item.getUsf().getUsf006()>0?item.getUsf().getUsf006():item.getUsf().getUsf005());
            item.setUsh006(item.getUsh005()*item.getUsh004());
            ushService.update(item);
            result.put("id", item.getUsh001());
        }else{
            cdush item=new cdush();
            cdusf usf=usfService.getByid(Integer.valueOf(request.getParameter("cpid")));
            item.setUsh001(UUID.randomUUID().toString().replace("-",""));
            item.setUsh003(usf.getUsf001());
            item.setUsh004(sl);
            item.setUsh005(usf.getUsf006()!=null&&usf.getUsf006()>0?usf.getUsf006():usf.getUsf005());
            item.setUsh006(item.getUsh005()*item.getUsh004());
            item.setUsh007(Integer.valueOf(request.getParameter("yhid")));
            ushService.insert(item);
            result.put("id", item.getUsh001());
        }
        result.put("msg", "A");
        return JSON.toJSONString(result);
    }

    /**
     * 订单
     * 王新苗
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/wxzf", method = RequestMethod.POST)
    public String wxzf(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String yhid=request.getParameter("yhid");
        String id=request.getParameter("id");
        String bz=request.getParameter("bz");
        String zffs=request.getParameter("zffs");
        String zojia=request.getParameter("zojia");
        String date=request.getParameter("date");
        String qsid=request.getParameter("qsid");
        cdusc usc=uscService.getByid(Integer.valueOf(yhid));
        cdyhc yhc=new cdyhc();
        yhc.setYhc001(UUID.randomUUID().toString().replace("-",""));
        yhc.setYhc002(usc.getUsc001());
        yhc.setYhc003(usc.getUsc005());
        yhc.setYhc004(new Date());
        yhc.setYhc005("Y");
        yhc.setYhc006(zffs);
        yhc.setYhc007(Float.valueOf(zojia));
        yhc.setYhc008(TIMEMIAO.parse(DATE.format(new Date(date))+" 00:00:00"));
        yhc.setYhc009(bz);
        yhc.setYhc012("D"+TIME_ORDER.format(yhc.getYhc004()));
        usc.setUsc008(usc.getUsc008()-yhc.getYhc007());
        usc.setUsc011(usc.getUsc011()+yhc.getYhc007());
        yhcService.insert(yhc);
        uscService.update(usc);
        List<cdush> list=ushService.selectByyhidjs(Integer.valueOf(yhid),id);
        for(cdush ush:list){
            ush.setUsh002(yhc.getYhc001());
            cdyha yha=yhaService.getByqscp(Integer.valueOf(qsid),ush.getUsh003());
            if(yha.getYha005().equals("C")){
//                if(yha.getYha004()>ush.getUsh004()){
                    yha.setYha004(yha.getYha004()-ush.getUsh004());
//                }else{
//                    yha.setYha004(0);
//                    yha.setYha006((yha.getYha006()+yha.getYha004())-ush.getUsh004());
//                }
                yhaService.update(yha);
            }
            ushService.update(ush);
        }
        result.put("msg", "1");
        return JSON.toJSONString(result);
    }

    /**
     * 订单
     * 王新苗
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/paypal", method = RequestMethod.POST)
    public String paypal(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        Map sign = null;
        String yhid=request.getParameter("yhid");
        String id=request.getParameter("id");
        String bz=request.getParameter("bz");
        String zffs=request.getParameter("zffs");
        String zojia=request.getParameter("zojia");
        String date=request.getParameter("date");
        String qsid=request.getParameter("qsid");
        String nonce_str = RandomStringGenerator.getRandomStringByLength(32);
        cdusc usc=uscService.getByid(Integer.valueOf(yhid));
        cdyhc yhc=new cdyhc();
        yhc.setYhc001(UUID.randomUUID().toString().replace("-",""));
        yhc.setYhc002(usc.getUsc001());
        yhc.setYhc003(usc.getUsc005());
        yhc.setYhc004(new Date());
        yhc.setYhc005("A");
        yhc.setYhc006(zffs);
        yhc.setYhc007(Float.valueOf(zojia));
        yhc.setYhc008(TIMEMIAO.parse(DATE.format(new Date(date))+" 00:00:00"));
        yhc.setYhc009(bz);
        yhc.setYhc011(nonce_str);
        yhc.setYhc012("D"+TIME_ORDER.format(yhc.getYhc004()));
        yhcService.insert(yhc);
        List<cdush> list=ushService.selectByyhidjs(Integer.valueOf(yhid),id);
        for(cdush ush:list){
            ush.setUsh002(yhc.getYhc001());
            cdyha yha=yhaService.getByqscp(Integer.valueOf(qsid),ush.getUsh003());
            if(yha.getYha005().equals("C")){
//                if(yha.getYha004()>ush.getUsh004()){
                    yha.setYha004(yha.getYha004()-ush.getUsh004());
//                }else{
//                    yha.setYha004(0);
//                    yha.setYha006((yha.getYha006()+yha.getYha004())-ush.getUsh004());
//                }
                yhaService.update(yha);
            }
            ushService.update(ush);
        }
        Map<String, String> packageParams = new HashMap<String, String>();
        packageParams.put("nonce_str", nonce_str);//随机数
        packageParams.put("appid",PubMessage.appid);
        packageParams.put("mch_id",PubMessage.mch_id);
        packageParams.put("mch_Key",PubMessage.mch_key);
        packageParams.put("body", "支付");  //打款消息
        packageParams.put("total_fee", yhc.getYhc007().toString());//支付金额
//        packageParams.put("total_fee", "0.01");//支付金额
        packageParams.put("notify_url",PubMessage.serverUrl+ "/ddzfcghd");//支付成功后的回调地址
        packageParams.put("openid", usc.getUsc004());
        packageParams.put("spbill_create_ip", request.getLocalAddr());
        sign = WeiCatJK.wxPay(packageParams);
        result.put("param", sign);
        result.put("msg", "1");
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping(value = "/paypal1", method = RequestMethod.POST)
    public String paypal1(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        Map sign = null;
        String ddid=request.getParameter("ddid");
        cdyhc yhc=yhcService.getByid(ddid);
        cdusc usc=uscService.getByid(yhc.getYhc002());
        String nonce_str = RandomStringGenerator.getRandomStringByLength(32);
        yhc.setYhc011(nonce_str);
        yhcService.update(yhc);
        Map<String, String> packageParams = new HashMap<String, String>();
        packageParams.put("nonce_str", nonce_str);//随机数
        packageParams.put("appid",PubMessage.appid);
        packageParams.put("mch_id",PubMessage.mch_id);
        packageParams.put("mch_Key",PubMessage.mch_key);
        packageParams.put("body", "支付");  //打款消息
        packageParams.put("total_fee", yhc.getYhc007().toString());//支付金额
//        packageParams.put("total_fee", "0.01");//支付金额
        packageParams.put("notify_url",PubMessage.serverUrl+ "/ddzfcghd");//支付成功后的回调地址
        packageParams.put("openid", usc.getUsc004());
        packageParams.put("spbill_create_ip", request.getLocalAddr());
        sign = WeiCatJK.wxPay(packageParams);
        result.put("param", sign);
        result.put("msg", "1");
        return JSON.toJSONString(result);
    }

    /**
     * 支付成功回调函数
     */
    @ResponseBody
    @RequestMapping(value="/ddzfcghd")
    public void ddzfcghd(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String inputLine;
        String notityXml = "";
        try {
            while ((inputLine = request.getReader().readLine()) != null) {
                notityXml += inputLine;
            }
            if(!notityXml.toString().trim().isEmpty()){
                Map map = PayUtils.doXMLParse(notityXml);
                String return_code = map.get("return_code").toString();
                if("SUCCESS".equals(return_code)){
                    String nonce_str = map.get("nonce_str").toString();
                    if(null!=nonce_str&&!nonce_str.toString().isEmpty()){
                        cdyhc yhc=yhcService.selectByStr(nonce_str);
                        cdusc usc=uscService.getByid(yhc.getYhc002());
                        usc.setUsc010(usc.getUsc010()+yhc.getYhc007());
                        usc.setUsc011(usc.getUsc011()+yhc.getYhc007());
                        uscService.update(usc);
                        yhc.setYhc005("Y");
                        yhc.setYhc010(map.get("out_trade_no").toString());
                        yhcService.update(yhc);
                    }

                }else{
                    //FAIL：订单错误
                    System.out.println("----支付失败----");
                }
                String resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
                out.write(resXml.getBytes());
                out.flush();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 我的
     * 王新苗
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/wxmy", method = RequestMethod.POST)
    public String wxmy(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String yhid=request.getParameter("yhid");
        if(yhid!=null&&!yhid.isEmpty()){
            result.put("item",uscService.getByid(Integer.valueOf(yhid)));
            result.put("ddnum", yhcService.selectByyhid(Integer.valueOf(yhid), null));
            result.put("msg", "1");
        }else{
            result.put("msg", "0");
        }
        return JSON.toJSONString(result);
    }


    /**
     * 查询更多菜品
     */
    @ResponseBody
    @RequestMapping(value = "wxfl")
    public String wxfl(HttpServletRequest request,HttpServletResponse response) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        PageBean pagebean = new PageBean();
        if(request.getParameter("pages")!=null&&!request.getParameter("pages").isEmpty()) pagebean.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
        else pagebean.setCurrentPage(1);
        if(request.getParameter("size")!=null&&!request.getParameter("size").isEmpty()) pagebean.setPageSize(Integer.valueOf(request.getParameter("size")));
        if(request.getParameter("type")!=null&&!request.getParameter("type").isEmpty())pagebean.setOthersql7(request.getParameter("type"));
        if(request.getParameter("yjfl")!=null&&!request.getParameter("yjfl").isEmpty())pagebean.setOthersql1(request.getParameter("yjfl"));
        if(request.getParameter("ejfl")!=null&&!request.getParameter("ejfl").isEmpty()&&!request.getParameter("ejfl").equals("null"))pagebean.setOthersql2(request.getParameter("ejfl"));
        if(request.getParameter("name")!=null&&!request.getParameter("name").isEmpty())pagebean.setOthersql(request.getParameter("name"));
        PageBean pb=usfService.selectPageBean2(pagebean);
        List<cdusf> list=pb.getResultList();
        String yhid=request.getParameter("yhid");
        if(yhid!=null&&!yhid.isEmpty()){
            for(cdusf usf:list){
                usf.setUsh(ushService.selectByyhcp(Integer.valueOf(yhid),usf.getUsf001()));
            }
        }

        result.put("pb", pb);
        return JSON.toJSONString(result);
    }

    /**
     * 详情
     * 王新苗
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/wxxq", method = RequestMethod.POST)
    public String wxxq(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String yhid=request.getParameter("yhid");
        String id=request.getParameter("cpid");
        cdusf item=usfService.getByid(Integer.valueOf(id));
        if(yhid!=null&&!yhid.isEmpty()){
            item.setUsh(ushService.selectByyhcp(Integer.valueOf(yhid),item.getUsf001()));
            item.setYha(yhaService.getByqscp(Integer.valueOf(request.getParameter("qsid")),item.getUsf001()));
        }
        result.put("item", item);
        return JSON.toJSONString(result);
    }


    /**
     * 查询更多订单
     */
    @ResponseBody
    @RequestMapping(value = "wxdd")
    public String wxdd(HttpServletRequest request,HttpServletResponse response) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        PageBean pagebean = new PageBean();
        if(request.getParameter("pages")!=null&&!request.getParameter("pages").isEmpty()) pagebean.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
        else pagebean.setCurrentPage(1);
        if(request.getParameter("size")!=null&&!request.getParameter("size").isEmpty()) pagebean.setPageSize(Integer.valueOf(request.getParameter("size")));
        if(request.getParameter("type")!=null&&!request.getParameter("type").isEmpty())pagebean.setOthersql2(request.getParameter("type"));
        if(request.getParameter("yhid")!=null&&!request.getParameter("yhid").isEmpty())pagebean.setOthersql(request.getParameter("yhid"));
        result.put("pb", yhcService.selectPageBean1(pagebean));
        return JSON.toJSONString(result);
    }

    /**
     * 退款
     * 王新苗
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/wxtk", method = RequestMethod.POST)
    public String wxtk(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        cdyhc item =yhcService.getByid(request.getParameter("id"));
        String qsid=request.getParameter("qsid");
        if(item.getYhc006().equals("P")){
            item.setYhc005("N");
            cdusc usc =uscService.getByid(item.getYhc002());
            usc.setUsc008(usc.getUsc008()+item.getYhc007());
            usc.setUsc011(usc.getUsc011()-item.getYhc007());
            uscService.update(usc);
            yhcService.update(item);
            List<cdush> list=ushService.selectByyhidtk(item.getYhc001());
            for(cdush ush:list){
                cdyha yha=yhaService.getByqscp(Integer.valueOf(qsid),ush.getUsh003());
                if(yha.getYha005().equals("C")){
                    yha.setYha004(yha.getYha004()+ush.getUsh004());
                    yhaService.update(yha);
                }
            }
            result.put("msg","1");
        }else{
            if(item.getYhc005().equals("A")){
                item.setYhc005("N");
                List<cdush> list=ushService.selectByyhidtk(item.getYhc001());
                for(cdush ush:list){
                    cdyha yha=yhaService.getByqscp(Integer.valueOf(qsid),ush.getUsh003());
                    if(yha.getYha005().equals("C")){
                        yha.setYha004(yha.getYha004()+ush.getUsh004());
                        yhaService.update(yha);
                    }
                }
                yhcService.update(item);
                result.put("msg","1");
            }else{
                Map<String,Object> result1 = new HashMap<String, Object>();
                result1=gettk(item.getYhc010(),item.getYhc007());
//                System.out.println("---***--"+result1);
                if(result1.get("return_code").equals("SUCCESS")){
                    item.setYhc005("N");
                    cdusc usc =uscService.getByid(item.getYhc002());
                    usc.setUsc010(usc.getUsc010()-item.getYhc007());
                    usc.setUsc011(usc.getUsc011()-item.getYhc007());
                    uscService.update(usc);
                    List<cdush> list=ushService.selectByyhidtk(item.getYhc001());
                    for(cdush ush:list){
                        cdyha yha=yhaService.getByqscp(Integer.valueOf(qsid),ush.getUsh003());
                        if(yha.getYha005().equals("C")){
                            yha.setYha004(yha.getYha004()+ush.getUsh004());
                            yhaService.update(yha);
                        }
                    }
                    yhcService.update(item);
                    result.put("msg","1");
                }else{
                    result.put("msg","0");
                }
            }

        }
        result.put("item", item);
        return JSON.toJSONString(result);
    }




}
