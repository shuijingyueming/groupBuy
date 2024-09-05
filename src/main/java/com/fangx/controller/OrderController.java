package com.fangx.controller;

import com.alibaba.fastjson.JSON;
import com.fangx.model.*;
import com.fangx.until.ExcelExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/toOr")
public class OrderController extends BaseController {

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 进入公司管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/tocg")
    public ModelAndView tocg(HttpServletRequest request,HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        int userid = 0;//后台登录用户ID
        if(session.getAttribute("user")==null){
            SystemTZYM(response,"登录失效");
            return null;
        }else{
            userid = Decrypt(session.getAttribute("user").toString());
            cduse user = useService.getByid(Decrypt(session.getAttribute("user").toString()));
            mav.addObject("msg", request.getParameter("msg"));
            if(request.getParameter("zt")!=null && request.getParameter("zt").equals("DC")){
                new ExcelExport().Excelexportyhcg(request, response,yheService,usfService,request.getParameter("date"));
                return null;
            }
            String date=DATE.format(new Date());
            if (request.getParameter("date") != null && !request.getParameter("date").isEmpty()) {
                date=request.getParameter("date");
            }
            List<cdyhe> list=yheService.serachAll(null);
            int index=0;
            for(cdyhe yhe:list){
                yhe.setUsflist(usfService.selectByCG(date,yhe.getYhe001()));
                index+=yhe.getUsflist().size();
                System.out.println("*****"+index);
                yhe.setIndex(index);
            }
//            List<cdusf> cplist=usfService.selectByCG(date);
            delsession(session,request.getParameter("fh"));
            mav.addObject("list", list);
            mav.addObject("date", date);
        }
        mav.setViewName("HTgscg");
        return mav;
    }

    /**
     * 进入公司管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/tops")
    public ModelAndView tops(HttpServletRequest request,HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        int userid = 0;//后台登录用户ID
        if(session.getAttribute("user")==null){
            SystemTZYM(response,"登录失效");
            return null;
        }else{
            userid = Decrypt(session.getAttribute("user").toString());
            cduse user = useService.getByid(Decrypt(session.getAttribute("user").toString()));
            mav.addObject("msg", request.getParameter("msg"));
            if(request.getParameter("zt")!=null && request.getParameter("zt").equals("DC")){
                new ExcelExport().Excelexportyhdd(request, response,usbService,usfService,usdService,uscService,yhcService,ushService,Integer.valueOf(request.getParameter("id")),request.getParameter("date"));
                return null;
            }
            PageBean pb = new PageBean();
            if(request.getParameter("fh")!=null && !request.getParameter("fh").isEmpty()){
                if(request.getParameter("fh").indexOf("GS")>=0){
                    pb=(PageBean)session.getAttribute("GSpb");
                    session.removeAttribute("GSpb");
                }
            }else{
                if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                    pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                else
                    pb.setCurrentPage(1);
                if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                    pb.setOthersql(request.getParameter("name"));
                }
                if (request.getParameter("phone") != null && !request.getParameter("phone").isEmpty()) {
                    pb.setOthersql1(request.getParameter("phone"));
                }
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", usdService.selectPageBean(pb));
        }
        mav.setViewName("HTgsps");
        return mav;
    }

    @RequestMapping("/tops1")
    public ModelAndView tops1(HttpServletRequest request,HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        int userid = 0;//后台登录用户ID
        if(session.getAttribute("user")==null){
            SystemTZYM(response,"登录失效");
            return null;
        }else{
            userid = Decrypt(session.getAttribute("user").toString());
            cduse user = useService.getByid(Decrypt(session.getAttribute("user").toString()));
            mav.addObject("msg", request.getParameter("msg"));
            if(request.getParameter("zt")!=null && request.getParameter("zt").equals("DC")){
                new ExcelExport().Excelexportyhdd(request, response,usbService,usfService,usdService,uscService,yhcService,ushService,Integer.valueOf(request.getParameter("id")),request.getParameter("date"));
                return null;
            }
            PageBean pb = new PageBean();
            if(request.getParameter("fh")!=null && !request.getParameter("fh").isEmpty()){
                if(request.getParameter("fh").indexOf("GS")>=0){
                    pb=(PageBean)session.getAttribute("GSpb");
                    session.removeAttribute("GSpb");
                }
            }else{
                if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                    pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                else
                    pb.setCurrentPage(1);
                if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                    pb.setOthersql(request.getParameter("name"));
                }
                if (request.getParameter("phone") != null && !request.getParameter("phone").isEmpty()) {
                    pb.setOthersql1(request.getParameter("phone"));
                }
                if (request.getParameter("ptime") != null && !request.getParameter("ptime").isEmpty()) {
                    pb.setOthersql2(request.getParameter("ptime"));
                }
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", yseService.selectPageBean(pb));
        }
        mav.setViewName("HTgsps1");
        return mav;
    }


    /**
     * 进入公司管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/topsyg")
    public ModelAndView topsyg(HttpServletRequest request,HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        int userid = 0;//后台登录用户ID
        if(session.getAttribute("user")==null){
            SystemTZYM(response,"登录失效");
            return null;
        }else{
            userid = Decrypt(session.getAttribute("user").toString());
            cduse user = useService.getByid(Decrypt(session.getAttribute("user").toString()));
            mav.addObject("msg", request.getParameter("msg"));
            if(request.getParameter("zt")!=null && request.getParameter("zt").equals("DC")){
                new ExcelExport().Excelexportyhdd(request, response,usbService,usfService,usdService,uscService,yhcService,ushService,Integer.valueOf(request.getParameter("gsid")),request.getParameter("date"));
                return null;
            }
            String date=DATE.format(new Date());
            if (request.getParameter("date") != null && !request.getParameter("date").isEmpty()) {
                date=request.getParameter("date");
            }
            List<cdusc> yglist1=uscService.serachAll(Integer.valueOf(request.getParameter("gsid")));
            List<cdusc> yglist=new ArrayList<>();
            for (cdusc usc:yglist1) {
                List<cdyhc> ddlist=yhcService.selectByyhid1(usc.getUsc001(),date);
                if (ddlist.size()>0){
                    List<cdusf> cplist=usfService.selectByDD(usc.getUsc001(),date);
                    String nr="";
                    String bz="";
                    for (int k = 0; k<cplist.size(); k++) {
                        nr+=cplist.get(k).getUsf002()+"("+cplist.get(k).getSl().toString()+")";
                        if(k<cplist.size()-1)nr+="+";
                    }
                    for (int k = 0; k<ddlist.size(); k++) {
                        if(ddlist.get(k).getYhc009()!=null&&!ddlist.get(k).getYhc009().isEmpty())bz+=ddlist.get(k).getYhc009()+"#";
                    }
                    usc.setDdlist(ddlist);
                    usc.setCplist(cplist);
                    usc.setNr(nr);
                    usc.setBz(bz);
                    yglist.add(usc);
                }

            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("yglist", yglist);
            mav.addObject("date", date);
            mav.addObject("gsid", request.getParameter("gsid"));
            mav.addObject("pages", request.getParameter("pages"));
            mav.addObject("name", request.getParameter("name"));
            mav.addObject("phone", request.getParameter("phone"));
            mav.addObject("ptime", request.getParameter("ptime"));

        }
        mav.setViewName("HTgspsyg");
        return mav;
    }
    /**
     * 进入订单管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/todd")
    public ModelAndView staff(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        int userid = 0;//后台登录用户ID
        if(session.getAttribute("user")==null){
            SystemTZYM(response,"登录失效");
            return null;
        }else{
            userid = Decrypt(session.getAttribute("user").toString());
            cduse user = useService.getByid(Decrypt(session.getAttribute("user").toString()));
            mav.addObject("msg", request.getParameter("msg"));
            PageBean pb = new PageBean();
            if(request.getParameter("zt") != null && !request.getParameter("zt").isEmpty()){
                if(request.getParameter("zt").equals("T")){
                    addLog(getUse(request).getUse002(),"退回了用户名字为：【" + request.getParameter("uname") + "】的订单");
                    cdyhc yhc =yhcService.getByid(request.getParameter("id"));
                    if(yhc.getYhc006().equals("P")){
                        yhc.setYhc005("N");
                        cdusc usc =uscService.getByid(yhc.getYhc002());
                        usc.setUsc008(usc.getUsc008()+yhc.getYhc007());
                        usc.setUsc011(usc.getUsc011()-yhc.getYhc007());
                        uscService.update(usc);
                        List<cdush> list=ushService.selectByyhidtk(yhc.getYhc001());
                        for(cdush ush:list){
                            ush.setUsh002(yhc.getYhc001());
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(yhc.getYhc008());
                            int i=getWeekDay(calendar);
                            cdusf usf=usfService.getByid(ush.getUsh003());
                            cdyha yha=yhaService.getByqscp(Integer.valueOf(usbService.selectByzq(i).getUsb001()),ush.getUsh003());
                            if(yha.getYha005().equals("C")){
                                yha.setYha004(yha.getYha004()+ush.getUsh004());
                                usf.setUsf008(usf.getUsf008()-ush.getUsh004());
                                usf.setUsf009(usf.getUsf009()-ush.getUsh006());
                                usfService.update(usf);
                                yhaService.update(yha);
                            }
                            ushService.update(ush);
                        }
                        yhcService.update(yhc);
                        mav.addObject("msg","C");
                    }else{
                        if(yhc.getYhc005().equals("A")){
                            yhc.setYhc005("N");
                            List<cdush> list=ushService.selectByyhidtk(yhc.getYhc001());
                            for(cdush ush:list){
                                ush.setUsh002(yhc.getYhc001());
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(yhc.getYhc008());
                                int i=getWeekDay(calendar);
                                cdusf usf=usfService.getByid(ush.getUsh003());
                                cdyha yha=yhaService.getByqscp(Integer.valueOf(usbService.selectByzq(i).getUsb001()),ush.getUsh003());
                                if(yha.getYha005().equals("C")){
                                    yha.setYha004(yha.getYha004()+ush.getUsh004());
                                    usf.setUsf008(usf.getUsf008()-ush.getUsh004());
                                    usf.setUsf009(usf.getUsf009()-ush.getUsh006());
                                    usfService.update(usf);
                                    yhaService.update(yha);
                                }
                                ushService.update(ush);
                            }
                        }else{
                            Map<String,Object> result = new HashMap<String, Object>();
                            result=gettk(yhc.getYhc010(),yhc.getYhc007());
//                            System.out.println("---***--"+result);
                            if(result.get("return_code").equals("SUCCESS")){
                                yhc.setYhc005("N");
                                cdusc usc =uscService.getByid(yhc.getYhc002());
                                usc.setUsc010(usc.getUsc010()-yhc.getYhc007());
                                usc.setUsc011(usc.getUsc011()-yhc.getYhc007());
                                uscService.update(usc);
                                List<cdush> list=ushService.selectByyhidtk(yhc.getYhc001());
                                for(cdush ush:list){
                                    ush.setUsh002(yhc.getYhc001());
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.setTime(yhc.getYhc008());
                                    int i=getWeekDay(calendar);
                                    cdusf usf=usfService.getByid(ush.getUsh003());
                                    cdyha yha=yhaService.getByqscp(Integer.valueOf(usbService.selectByzq(i).getUsb001()),ush.getUsh003());
                                    if(yha.getYha005().equals("C")){
                                        yha.setYha004(yha.getYha004()+ush.getUsh004());
                                        usf.setUsf008(usf.getUsf008()-ush.getUsh004());
                                        usf.setUsf009(usf.getUsf009()-ush.getUsh006());
                                        usfService.update(usf);
                                        yhaService.update(yha);
                                    }
                                    ushService.update(ush);
                                }
                                yhcService.update(yhc);
                                mav.addObject("msg","C");
                            }else{
                                mav.addObject("msg","H");
                            }
                        }
                    }
                }else if(request.getParameter("zt").equals("D")){
                    addLog(getUse(request).getUse002(),"删除了账户名字为：【" + request.getParameter("uname") + "】的信息");
                    cduse use =useService.getByid(Integer.parseInt(request.getParameter("id")));
                    useService.update(use);
                    mav.addObject("msg","D");
                }
            }
            if (request.getParameter("fh") != null && !request.getParameter("fh").isEmpty()) {
                if (request.getParameter("fh").indexOf("YDZ") >= 0) {
                    PageBean pb1 = new PageBean();
                    if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                        pb1.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                    else
                        pb1.setCurrentPage(1);
                    if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                        pb1.setOthersql(request.getParameter("name"));
                    }
                    if (request.getParameter("phone") != null && !request.getParameter("phone").isEmpty()) {
                        pb1.setOthersql1(request.getParameter("phone"));
                    }
                    if (request.getParameter("gsid") != null && !request.getParameter("gsid").isEmpty()) {
                        pb1.setOthersql2(request.getParameter("gsid"));
                    }
                /*if (request.getParameter("start") != null && !request.getParameter("start").isEmpty()) {
                    pb1.setOthersql5(request.getParameter("start"));
                }
                    if (request.getParameter("end") != null && !request.getParameter("end").isEmpty()) {
                        pb1.setOthersql6(request.getParameter("end"));
                    }*/
                    session.setAttribute("YDZpb", pb1);
                    pb.setCurrentPage(1);
                    pb.setOthersql8(request.getParameter("name"));
                    mav.addObject("fhlx", request.getParameter("fh"));
                } else
                if (request.getParameter("fh").indexOf("DZ") >= 0) {
                    PageBean pb1 = new PageBean();
                    if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                        pb1.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                    else
                        pb1.setCurrentPage(1);
                    if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                        pb1.setOthersql(request.getParameter("name"));
                    }
                    if (request.getParameter("phone") != null && !request.getParameter("phone").isEmpty()) {
                        pb1.setOthersql1(request.getParameter("phone"));
                    }
                    if (request.getParameter("gsid") != null && !request.getParameter("gsid").isEmpty()) {
                        pb1.setOthersql2(request.getParameter("gsid"));
                    }
                    if (request.getParameter("start") != null && !request.getParameter("start").isEmpty()) {
                        pb1.setOthersql5(request.getParameter("start"));
                    }
                    /*if (request.getParameter("end") != null && !request.getParameter("end").isEmpty()) {
                        pb1.setOthersql6(request.getParameter("end"));
                    }*/
                    session.setAttribute("DZpb", pb1);
                    pb.setCurrentPage(1);
                    pb.setOthersql7(request.getParameter("date"));
                }
                mav.addObject("fhlx", request.getParameter("fh"));
            } else {

                if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                    pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                else
                    pb.setCurrentPage(1);
                if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                    pb.setOthersql(request.getParameter("name"));
                }
                if (request.getParameter("ygid") != null && !request.getParameter("ygid").isEmpty()) {
                    pb.setOthersql6(request.getParameter("ygid"));
                }
                if (request.getParameter("gsid") != null && !request.getParameter("gsid").isEmpty()) {
                    pb.setOthersql1(request.getParameter("gsid"));
                }
                if (request.getParameter("type") != null && !request.getParameter("type").isEmpty()) {
                    pb.setOthersql2(request.getParameter("type"));
                }
                if (request.getParameter("zffs") != null && !request.getParameter("zffs").isEmpty()) {
                    pb.setOthersql3(request.getParameter("zffs"));
                }
                if (request.getParameter("start") != null && !request.getParameter("start").isEmpty()) {
                    pb.setOthersql4(request.getParameter("start"));
                }
                if (request.getParameter("end") != null && !request.getParameter("end").isEmpty()) {
                    pb.setOthersql5(request.getParameter("end"));
                }
                if (request.getParameter("date") != null && !request.getParameter("date").isEmpty()) {
                    pb.setOthersql7(request.getParameter("date"));
                }
                if (request.getParameter("mo") != null && !request.getParameter("mo").isEmpty()) {
                    pb.setOthersql8(request.getParameter("mo"));
                }
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", yhcService.selectPageBean(pb));
            mav.addObject("usdlist", usdService.serachAll(null));
            mav.addObject("usclist", uscService.serachAll(null));
        }
        mav.setViewName("HTdd");
        return mav;
    }

    /**
     * 根据id获取订单
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachdd",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachyh(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        HashMap result = new HashMap();
        cdyhc item=yhcService.getByid(id);
        result.put("item",item);
        return JSON.toJSONString(result);
    }

    /**
     * 进入对账管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/todz")
    public ModelAndView todz(HttpServletRequest request,HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        int userid = 0;//后台登录用户ID
        if(session.getAttribute("user")==null){
            SystemTZYM(response,"登录失效");
            return null;
        }else{
            userid = Decrypt(session.getAttribute("user").toString());
            cduse user = useService.getByid(Decrypt(session.getAttribute("user").toString()));
            mav.addObject("msg", request.getParameter("msg"));
            if(request.getParameter("zt")!=null && request.getParameter("zt").equals("DC")){
                new ExcelExport().Excelexportdz(request, response,yhcService,usdService,Integer.valueOf(request.getParameter("id")),request.getParameter("start"));
                return null;
            }
            PageBean pb = new PageBean();
            if (request.getParameter("fh") != null && !request.getParameter("fh").isEmpty()) {
                if (request.getParameter("fh").indexOf("DZ") >= 0) {
                    pb = (PageBean) session.getAttribute("DZpb");
                    session.removeAttribute("DZpb");
                    mav.addObject("fhlx", request.getParameter("fh").replace("DZ", ""));
                }else {
                    if (request.getParameter("fh").indexOf("GS") >= 0) {
                        PageBean pb1 = new PageBean();
                        if (request.getParameter("pages") != null && !request.getParameter("pages").toString().isEmpty())
                            pb1.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                        else
                            pb1.setCurrentPage(1);
                        if (request.getParameter("name") != null && !request.getParameter("name").toString().isEmpty()) {
                            pb1.setOthersql(request.getParameter("name"));
                        }
                        if (request.getParameter("phone") != null && !request.getParameter("phone").toString().isEmpty()) {
                            pb1.setOthersql1(request.getParameter("phone"));
                        }
                        session.setAttribute("GSpb", pb1);
                        pb.setCurrentPage(1);
                        pb.setOthersql2(request.getParameter("id"));
                        pb.setOthersql5(DATE.format(new Date()));
                    }
                    mav.addObject("fhlx", request.getParameter("fh"));
                }
            } else {
                if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                    pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                else
                    pb.setCurrentPage(1);
                if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                    pb.setOthersql(request.getParameter("name"));
                }
                if (request.getParameter("phone") != null && !request.getParameter("phone").isEmpty()) {
                    pb.setOthersql1(request.getParameter("phone"));
                }
                if (request.getParameter("gsid") != null && !request.getParameter("gsid").isEmpty()) {
                    pb.setOthersql2(request.getParameter("gsid"));
                }
                if (request.getParameter("start") != null && !request.getParameter("start").isEmpty()) {
                    pb.setOthersql5(request.getParameter("start"));
                }else{
                    pb.setOthersql5(DATE.format(new Date()));
                }
                /*if (request.getParameter("end") != null && !request.getParameter("end").isEmpty()) {
                    pb.setOthersql6(request.getParameter("end"));
                }*/
                mav.addObject("fhlx", request.getParameter("fhlx"));
            }
            delsession(session,request.getParameter("fh"));
            List<cdusd> list=usdService.serachAll(pb.getOthersql2());
            for(cdusd usd:list){
                usd.setYze(yhcService.selectBygsid(DATE.parse(pb.getOthersql5()),usd.getUsd001(),"P",null));
                usd.setWze(yhcService.selectBygsid(DATE.parse(pb.getOthersql5()),usd.getUsd001(),"W",null));
            }
            mav.addObject("pageobj", pb);
            mav.addObject("usdlist", list);
        }
        mav.setViewName("HTdz");
        return mav;
    }

    /**
     * 进入对账管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/toydz")
    public ModelAndView toydz(HttpServletRequest request,HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        int userid = 0;//后台登录用户ID
        if(session.getAttribute("user")==null){
            SystemTZYM(response,"登录失效");
            return null;
        }else{
            userid = Decrypt(session.getAttribute("user").toString());
            cduse user = useService.getByid(Decrypt(session.getAttribute("user").toString()));
            mav.addObject("msg", request.getParameter("msg"));
            if(request.getParameter("zt")!=null && request.getParameter("zt").equals("DC")){
                new ExcelExport().Excelexportydz(request, response,yhcService,usdService,Integer.valueOf(request.getParameter("id")),request.getParameter("name"));
                return null;
            }
            PageBean pb = new PageBean();
            if (request.getParameter("fh") != null && !request.getParameter("fh").isEmpty()) {
                if (request.getParameter("fh").indexOf("YDZ") >= 0) {
                    pb = (PageBean) session.getAttribute("YDZpb");
                    session.removeAttribute("YDZpb");
                    mav.addObject("fhlx", request.getParameter("fh").replace("YDZ", ""));
                }else {
                    if (request.getParameter("fh").indexOf("GS") >= 0) {
                        PageBean pb1 = new PageBean();
                        if (request.getParameter("pages") != null && !request.getParameter("pages").toString().isEmpty())
                            pb1.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                        else
                            pb1.setCurrentPage(1);
                        if (request.getParameter("name") != null && !request.getParameter("name").toString().isEmpty()) {
                            pb1.setOthersql(request.getParameter("name"));
                        }
                        if (request.getParameter("phone") != null && !request.getParameter("phone").toString().isEmpty()) {
                            pb1.setOthersql1(request.getParameter("phone"));
                        }
                        session.setAttribute("GSpb", pb1);
                        pb.setCurrentPage(1);
                        pb.setOthersql2(request.getParameter("id"));
                        pb.setOthersql5(DATE.format(new Date()));
                    }
                    mav.addObject("fhlx", request.getParameter("fh"));
                }
            } else {
                if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                    pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                else
                    pb.setCurrentPage(1);
                if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                    pb.setOthersql(request.getParameter("name"));
                }else{
                    pb.setOthersql(sdf3.format(new Date()));
                }
                if (request.getParameter("phone") != null && !request.getParameter("phone").isEmpty()) {
                    pb.setOthersql1(request.getParameter("phone"));
                }
                if (request.getParameter("gsid") != null && !request.getParameter("gsid").isEmpty()) {
                    pb.setOthersql2(request.getParameter("gsid"));
                }
                /*if (request.getParameter("start") != null && !request.getParameter("start").isEmpty()) {
                    pb.setOthersql5(request.getParameter("start"));
                }
                if (request.getParameter("end") != null && !request.getParameter("end").isEmpty()) {
                    pb.setOthersql6(request.getParameter("end"));
                }*/
                mav.addObject("fhlx", request.getParameter("fhlx"));
            }
            delsession(session,request.getParameter("fh"));
            List<cdusd> list=usdService.serachAll(pb.getOthersql2());
            for(cdusd usd:list){
                usd.setYze(yhcService.selectBygsidY(pb.getOthersql(),usd.getUsd001(),"P",null));
                usd.setWze(yhcService.selectBygsidY(pb.getOthersql(),usd.getUsd001(),"W",null));
            }
            mav.addObject("pageobj", pb);
            mav.addObject("usdlist", list);
        }
        mav.setViewName("HTdzy");
        return mav;
    }

}
