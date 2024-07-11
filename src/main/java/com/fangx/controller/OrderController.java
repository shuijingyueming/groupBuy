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
                new ExcelExport().Excelexportyhcg(request, response,usfService,request.getParameter("date"));
                return null;
            }
            String date=DATE.format(new Date());
            if (request.getParameter("date") != null && !request.getParameter("date").isEmpty()) {
                date=request.getParameter("date");
            }
            List<cdusf> cplist=usfService.selectByCG(date);
            delsession(session,request.getParameter("fh"));
            mav.addObject("cplist", cplist);
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
                            cdyha yha=yhaService.getByqscp(Integer.valueOf(usbService.selectByzq(i).getUsb001()),ush.getUsh003());
                            if(yha.getYha005().equals("C")){
                                yha.setYha004(yha.getYha004()+ush.getUsh004());
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
                                cdyha yha=yhaService.getByqscp(Integer.valueOf(usbService.selectByzq(i).getUsb001()),ush.getUsh003());
                                if(yha.getYha005().equals("C")){
                                    yha.setYha004(yha.getYha004()+ush.getUsh004());
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
                                    cdyha yha=yhaService.getByqscp(Integer.valueOf(usbService.selectByzq(i).getUsb001()),ush.getUsh003());
                                    if(yha.getYha005().equals("C")){
                                        yha.setYha004(yha.getYha004()+ush.getUsh004());
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
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", yhcService.selectPageBean(pb));
            mav.addObject("usdlist", usdService.serachAll());
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
            if(request.getParameter("zt") != null && !request.getParameter("zt").isEmpty()){
                if(request.getParameter("zt").equals("U")){
                    addLog(getUse(request).getUse002(),"修改了公司员工名字为：【" + request.getParameter("uname") + "】的状态");
                    cdusc item =uscService.getByid(Integer.parseInt(request.getParameter("id")));
                    item.setUsc003(request.getParameter("type"));
                    uscService.update(item);
                    mav.addObject("msg","C");
                }else if(request.getParameter("zt").equals("CZ")){
                    addLog(getUse(request).getUse002(),"公司员工名字为：【" + request.getParameter("uname") + "】充值了"+request.getParameter("num"));
                    float num=Float.valueOf(request.getParameter("num"));
                    cdusc item =uscService.getByid(Integer.parseInt(request.getParameter("id")));
                    item.setUsc008(item.getUsc008()+num);
                    cdyhd yhd=new cdyhd();
                    yhd.setYhd001(UUID.randomUUID().toString().replace("-",""));
                    yhd.setYhd002(item.getUsc001());
                    yhd.setYhd003(item.getUsc005());
                    yhd.setYhd004(num);
                    yhd.setYhd005(new Date());
                    yhdService.insert(yhd);
                    uscService.update(item);
                    mav.addObject("msg","C");
                }
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
                mav.addObject("fhlx", request.getParameter("fhlx"));
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", yhkService.selectPageBean(pb));
            mav.addObject("usdlist", usdService.serachAll());
        }
        mav.setViewName("HTdz");
        return mav;
    }

}
