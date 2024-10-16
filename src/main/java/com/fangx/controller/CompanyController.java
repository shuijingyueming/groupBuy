package com.fangx.controller;

import com.alibaba.fastjson.JSON;
import com.fangx.model.*;
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
@RequestMapping("/toCo")
public class CompanyController extends BaseController {

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 进入公司管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/togs")
    public ModelAndView togs(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
            //导出模板
            if (request.getParameter("type") != null && request.getParameter("type").equals("E")) {
                String fpath = LoginController.class.getClass().getResource("/").getPath();
                downloadLocal(fpath.substring(1,fpath.length())+"static/upload/staff.xls", "员工导入模板.xls",response, request);
                return null;
            }
            if(request.getParameter("zt") != null && !request.getParameter("zt").isEmpty()){
                if(request.getParameter("zt").equals("D")){
                    addLog(getUse(request).getUse002(),"删除了公司名字为：【" + request.getParameter("uname") + "】的信息");
                    cduse use =useService.getByid(Integer.parseInt(request.getParameter("id")));
                    useService.update(use);
                    mav.addObject("msg","D");
                }
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
            mav.addObject("usblist", usbService.serachAll1());
        }
        mav.setViewName("HTgs");
        return mav;
    }

    /**
     * 进入公司管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/togscp")
    public ModelAndView togscp(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
            //导出模板
            if (request.getParameter("type") != null && request.getParameter("type").equals("E")) {
                String fpath = LoginController.class.getClass().getResource("/").getPath();
                downloadLocal(fpath.substring(1,fpath.length())+"static/upload/staff.xls", "员工导入模板.xls",response, request);
                return null;
            }
            PageBean pb = new PageBean();
            if(request.getParameter("fh")!=null && !request.getParameter("fh").isEmpty()){
                if(request.getParameter("fh").indexOf("GS")>=0){
                    pb=(PageBean)session.getAttribute("GSpb");
                    session.removeAttribute("GSpb");
                }
            }else{
                if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty()){
                    pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                }
                if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                    pb.setOthersql(request.getParameter("name"));
                }
                if (request.getParameter("phone") != null && !request.getParameter("phone").isEmpty()) {
                    pb.setOthersql1(request.getParameter("phone"));
                }
                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                    pb.setOthersql2(request.getParameter("id"));
                }
                if (request.getParameter("cpname") != null && !request.getParameter("cpname").isEmpty()) {
                    pb.setOthersql3(request.getParameter("cpname"));
                }
            }
            delsession(session,request.getParameter("fh"));
            List<cdusf> list=usfService.serachAllgs(pb.getOthersql2(),pb.getOthersql3());
            mav.addObject("pageobj", pb);
            mav.addObject("list", list);
        }
        mav.setViewName("HTgscp");
        return mav;
    }

    /**
     * 根据id获取公司
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/addgscp",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String addgscp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jg = request.getParameter("jg");
        String jgid = request.getParameter("jgid");
        HashMap result = new HashMap();
        if(!jg.isEmpty()){
            Integer cpid = Integer.valueOf(request.getParameter("cpid"));
            Integer gsid = Integer.valueOf(request.getParameter("gsid"));
            cdusg item=new cdusg();
            item.setUsg002(cpid);
            item.setUsg003(gsid);
            item.setUsg005(Float.valueOf(jg));
            item.setUsg007(new Date());
            if(!jgid.isEmpty()){
                item.setUsg001(jgid);
                usgService.update(item);
            }else{
                item.setUsg001(UUID.randomUUID().toString().replace("-",""));
                usgService.insert(item);
            }
            result.put("item",item);
        }else if(!jgid.isEmpty()){
            usgService.delete(jgid);
        }
        return JSON.toJSONString(result);
    }

    /**
     * 根据id获取公司
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachgs",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachyh(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        HashMap result = new HashMap();cdusd item=usdService.getByid(id);
        result.put("item",item);
        return JSON.toJSONString(result);
    }

    /**
     * 修改公司
     * 王新苗
     * @param request
     * @param response
     */
    @RequestMapping(value = "/xggs")
    public ModelAndView xggs(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        cdusd item = new cdusd();
        //修改
        item.setUsd002(request.getParameter("t1"));
        item.setUsd003(request.getParameter("t2"));
        item.setUsd004(request.getParameter("t3"));
        item.setUsd011(request.getParameter("t11"));
//        if(!request.getParameter("t4").isEmpty())item.setUsd008(Integer.valueOf(request.getParameter("t4")));
        if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
            String log = "修改了名字为：【" + request.getParameter("t1") + "】的公司信息";
            item.setUsd001(Integer.valueOf((request.getParameter("id"))));
            addLog(getUse(request).getUse002(),log);
            usdService.update(item);
            mav.addObject("msg", "U");
        }else{
            String log = "新增了名字为：【" + request.getParameter("t1")+ "】的公司信息";
            addLog(getUse(request).getUse002(),log);
            item.setUsd006(0.0F);
            item.setUsd007(0.0F);
            item = usdService.insert(item);
            mav.addObject("msg", "I");
        }

        yhbService.deletebyid(item.getUsd001());
        cdyhb yhb = new cdyhb();
        Date d=new Date();
        Calendar ca = Calendar.getInstance();
        ca.setTime(d);
        ca.set(Calendar.HOUR_OF_DAY, 12);
        ca.set(Calendar.MINUTE, 00);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);
        long current = System.currentTimeMillis();
        long tomorrowzero1 = ca.getTimeInMillis();
        long tomorrowzeroSeconds1 = (tomorrowzero1- current);
        if(tomorrowzeroSeconds1<0){ca.add(Calendar.DAY_OF_MONTH,1);}
        if(item.getUsd011().equals("B")){
            String[] ids=request.getParameterValues("t9");
            List<Integer> list = new ArrayList<>();
            for(String id:ids){
                if(!id.isEmpty())list.add(Integer.valueOf(id));
            }
            list=ListSort(list);
            Integer r= Integer.valueOf(sdf5.format(ca.getTime()));
            if(ids!=null){
                cdysb ysb=ysbService.selectBygstime2(item.getUsd001(),null,DATE.format(ca.getTime()), item.getUsd011(),"A");
                boolean flag=true;
                boolean flag1=true;
                for(int i=0;i<list.size();i++){
                    cdusb usb =usbService.getByname(list.get(i)+"号");
                    if(flag&&(list.size()==1||r<list.get(i)||i==list.size()-1)){
                        flag=false;
                        if(ysb!=null) {
                            ca.set(Calendar.DAY_OF_MONTH, list.get(i));
                            if(i==list.size()-1&&r>= list.get(i)){
                                ca.set(Calendar.DAY_OF_MONTH, list.get(0));
                                ca.add(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
                            }
                            System.out.println("------");
                            yseService.updateBycurentday1(ysb.getYsb003(),ca.getTime(),item.getUsd001());
                            yhcService.updateBycurentday1(ysb.getYsb003(),ca.getTime(),item.getUsd001());
                            if(!ysb.getYsb004().before(ca.getTime())){
                                flag1=false;
                            }
                            ysb.setYsb003(ca.getTime());
                            ysb.setYsb004(ca.getTime());
                            ysb.setYsb005("A");
                            ysb.setYsb006(usb.getUsb001());
                            ysb.setYsb008("B");
                            ysbService.deleteBytime(ca.getTime(),item.getUsd001());
                            if(flag1){
                                ysbService.update(ysb);
                            }else{
                                ysb.setYsb001(null);
                                ysbService.insert(ysb);
                            }
                        }else{
                            ca.set(Calendar.DAY_OF_MONTH,  list.get(i));
                            ysb=new cdysb();
                            ysb.setYsb002(item.getUsd001());
                            if(i==list.size()-1&&r>= list.get(i)){
                                ca.set(Calendar.DAY_OF_MONTH,  list.get(0));
                                ca.add(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
                            }
                            ysb.setYsb003(ca.getTime());
                            ysb.setYsb004(ca.getTime());
                            ysb.setYsb005("A");
                            ysb.setYsb006(usb.getUsb001());
                            ysb.setYsb008("B");
                            ysbService.deleteBytime(ca.getTime(),item.getUsd001());
                            ysbService.insert(ysb);
                        }
                    }
                    yhb.setYhb001(UUID.randomUUID().toString().replace("-",""));
                    yhb.setYhb002(usb.getUsb001());
                    yhb.setYhb003(item.getUsd001());
                    yhbService.insert(yhb);
                }
            }
        }
        else{
            String[] ids=request.getParameter("t8").split("#");
            List<Integer> list = new ArrayList<>();
            for(String id:ids){
                if(!id.isEmpty())list.add(Integer.valueOf(id));
            }
            list=ListSort(list);
            int r=getWeekDay1(ca);
            if(ids!=null){
                cdysb ysb=ysbService.selectBygstime2(item.getUsd001(),null,DATE.format(ca.getTime()), item.getUsd011(),"A");
                boolean flag=true;
                boolean flag1=true;
                for(int i=0;i<list.size();i++){
                    cdusb usb =usbService.getByid(list.get(i));
                    if(flag&&(list.size()==1||r<list.get(i)||i==list.size()-1)){
                        flag=false;
                        if(ysb!=null) {
                            if(i==list.size()-1&&r>= list.get(i)){
                                ca.add(Calendar.DAY_OF_MONTH,  list.get(0)-r);
                                ca.add(Calendar.DAY_OF_MONTH, 7);
                            }else{
                                ca.add(Calendar.DAY_OF_MONTH,  list.get(i)-r);
                            }
                            yseService.updateBycurentday1(ysb.getYsb003(),ca.getTime(),item.getUsd001());
                            yhcService.updateBycurentday1(ysb.getYsb003(),ca.getTime(),item.getUsd001());
                            if(!ysb.getYsb004().before(ca.getTime())){
                                flag1=false;
                            }
                            ysb.setYsb003(ca.getTime());
                            ysb.setYsb004(ca.getTime());
                            ysb.setYsb005("A");
                            ysb.setYsb006(usb.getUsb001());
                            ysb.setYsb008("A");
                            ysbService.deleteBytime(ca.getTime(),item.getUsd001());
                            if(flag1){
                                ysbService.update(ysb);
                            }else{
                                ysb.setYsb001(null);
                                ysbService.insert(ysb);
                            }
                        }else{
                            ysb=new cdysb();
                            ysb.setYsb002(item.getUsd001());
                            if(i==list.size()-1&&r>= list.get(i)){
                                ca.add(Calendar.DAY_OF_MONTH,  list.get(0)-r);
                                ca.add(Calendar.DAY_OF_MONTH, 7);
                            }else{
                                ca.add(Calendar.DAY_OF_MONTH,  list.get(i)-r);
                            }
                            ysb.setYsb003(ca.getTime());
                            ysb.setYsb004(ca.getTime());
                            ysb.setYsb005("A");
                            ysb.setYsb006(usb.getUsb001());
                            ysb.setYsb008("A");
                            ysbService.deleteBytime(ca.getTime(),item.getUsd001());
                            ysbService.insert(ysb);
                        }
                    }
                    yhb.setYhb001(UUID.randomUUID().toString().replace("-",""));
                    yhb.setYhb002(usb.getUsb001());
                    yhb.setYhb003(item.getUsd001());
                    yhbService.insert(yhb);
                }
            }
        }

        mav.addObject("pages", request.getParameter("pages"));
        mav.addObject("phone", request.getParameter("phone"));
        mav.addObject("name", request.getParameter("name"));
        mav.setViewName("redirect:/toCo/togs");
        return mav;
    }


    /**
     * 进入公司员工管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/togsyg")
    public ModelAndView togsyg(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
                    item.setUsc009(item.getUsc009()+num);
                    cdyhd yhd=new cdyhd();
                    yhd.setYhd001(UUID.randomUUID().toString().replace("-",""));
                    yhd.setYhd002(item.getUsc001());
                    yhd.setYhd003(item.getUsc005());
                    yhd.setYhd004(num);
                    yhd.setYhd005(new Date());
                    yhd.setYhd006("A");
                    yhdService.insert(yhd);
                    uscService.update(item);
                    mav.addObject("msg","C");
                }else if(request.getParameter("zt").equals("Q")){
                    addLog(getUse(request).getUse002(),"公司员工名字为：【" + request.getParameter("uname") + "】的账户清零");
                    cdusc item =uscService.getByid(Integer.parseInt(request.getParameter("id")));
                    cdyhd yhd=new cdyhd();
                    yhd.setYhd001(UUID.randomUUID().toString().replace("-",""));
                    yhd.setYhd002(item.getUsc001());
                    yhd.setYhd003(item.getUsc005());
                    yhd.setYhd004(item.getUsc008());
                    yhd.setYhd005(new Date());
                    yhd.setYhd006("B");
                    yhdService.insert(yhd);
                    item.setUsc008(0.0f);
                    uscService.update(item);
                    mav.addObject("msg","C");
                }else if(request.getParameter("zt").equals("GQ")){
                    addLog(getUse(request).getUse002(),"公司名字为：【" + request.getParameter("uname") + "】的员工账户清零");
                    List<cdusc> list=uscService.serachAll(Integer.parseInt(request.getParameter("id")));
                    for(cdusc item:list){
                        cdyhd yhd=new cdyhd();
                        yhd.setYhd001(UUID.randomUUID().toString().replace("-",""));
                        yhd.setYhd002(item.getUsc001());
                        yhd.setYhd003(item.getUsc005());
                        yhd.setYhd004(item.getUsc008());
                        yhd.setYhd005(new Date());
                        yhd.setYhd006("B");
                        yhdService.insert(yhd);
                        item.setUsc008(0.0f);
                        uscService.update(item);
                    }
                    mav.addObject("msg","C");
                }
            }
            PageBean pb = new PageBean();
            if (request.getParameter("fh") != null && !request.getParameter("fh").isEmpty()) {
                if (request.getParameter("fh").indexOf("YG") >= 0) {
                    pb = (PageBean) session.getAttribute("YGpb");
                    session.removeAttribute("YGpb");
                    mav.addObject("fhlx", request.getParameter("fh").replace("YG", ""));
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
            mav.addObject("pageobj", uscService.selectPageBean(pb));
            mav.addObject("usdlist", usdService.serachAll(null));
        }
        mav.setViewName("HTgsyg");
        return mav;
    }

    /**
     * 根据id获取公司员工
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachgsyg",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachgsyg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        HashMap result = new HashMap();
        cdusc item=uscService.getByid(id);
        result.put("item",item);
        return JSON.toJSONString(result);
    }

    /**
     * 修改公司员工
     * 王新苗
     * @param request
     * @param response
     */
    @RequestMapping(value = "/xggsyg")
    public ModelAndView xggsyg(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        cdusc item = new cdusc();
        //修改
        item.setUsc002(request.getParameter("t1"));
        item.setUsc005(Integer.valueOf(request.getParameter("t2")));
        item.setUsc015(request.getParameter("t3"));
        item.setUsc016(request.getParameter("t6"));
        if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
            String log = "修改了名字为：【" + request.getParameter("t1") + "】的公司员工信息";
            item.setUsc001(Integer.valueOf((request.getParameter("id"))));
            addLog(getUse(request).getUse002(),log);
            uscService.update(item);
            mav.addObject("msg", "U");
        }else{
            String log = "新增了名字为：【" + request.getParameter("t1")+ "】的公司员工信息";
            addLog(getUse(request).getUse002(),log);
            item.setUsc003("A");
            item.setUsc008(0.0F);
            item.setUsc009(0.0F);
            item.setUsc010(0.0F);
            item.setUsc011(0.0F);
            item = uscService.insert(item);
            mav.addObject("msg", "I");
        }
        mav.addObject("pages", request.getParameter("pages"));
        mav.addObject("phone", request.getParameter("phone"));
        mav.addObject("name", request.getParameter("name"));
        mav.addObject("gsid", request.getParameter("gsid"));
        mav.addObject("fhlx", request.getParameter("fhlx"));
        mav.setViewName("redirect:/toCo/togsyg");
        return mav;
    }


    /**
     * 进入公司员工管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/tocz")
    public ModelAndView tocz(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
               if(request.getParameter("zt").equals("TK")){
                   cdyhd yhd=yhdService.getByid(request.getParameter("id"));
                   cdusc item =uscService.getByid(yhd.getYhd002());
                   float num=yhd.getYhd004();
                   item.setUsc008(item.getUsc008()-num);
                   item.setUsc009(item.getUsc009()+num);
                   yhdService.update(yhd);
                   uscService.update(item);
                   addLog(getUse(request).getUse002(),"公司员工名字为：【" + item.getUsc002() + "】退款了"+num);
                   mav.addObject("msg","C");
                }
            }
            PageBean pb = new PageBean();
            if (request.getParameter("fh") != null && !request.getParameter("fh").isEmpty()) {
                if (request.getParameter("fh").indexOf("YG") >= 0) {
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
                    session.setAttribute("YGpb", pb1);
                    pb.setCurrentPage(1);
                    pb.setOthersql1(request.getParameter("id"));
                    pb.setOthersql5(request.getParameter("lx"));
                }else if (request.getParameter("fh").indexOf("GS") >= 0) {
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
                    if (request.getParameter("gsid") != null && !request.getParameter("gsid").toString().isEmpty()) {
                        pb1.setOthersql2(request.getParameter("gsid"));
                    }
                    session.setAttribute("GSpb", pb1);
                    pb.setCurrentPage(1);
                    pb.setOthersql2(request.getParameter("id"));
                    pb.setOthersql5(request.getParameter("lx"));
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
                    pb.setOthersql1(request.getParameter("ygid"));
                }
                if (request.getParameter("gsid") != null && !request.getParameter("gsid").isEmpty()) {
                    pb.setOthersql2(request.getParameter("gsid"));
                }
                if (request.getParameter("ygname") != null && !request.getParameter("ygname").isEmpty()) {
                    pb.setOthersql3(request.getParameter("ygname"));
                }
                if (request.getParameter("lx") != null && !request.getParameter("lx").isEmpty()) {
                    pb.setOthersql5(request.getParameter("lx"));
                }
                mav.addObject("fhlx", request.getParameter("fhlx"));
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", yhdService.selectPageBean(pb));
            mav.addObject("usdlist", usdService.serachAll(null));
//            mav.addObject("usclist", uscService.serachAll(null));
        }
        mav.setViewName("HTgscz");
        return mav;
    }

    /**
     * 进入公司员工管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/topsls")
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
            //导出模板
            if (request.getParameter("type") != null && request.getParameter("type").equals("E")) {
                String fpath = LoginController.class.getClass().getResource("/").getPath();
                downloadLocal(fpath.substring(1,fpath.length())+"static/upload/cpls.xls", "菜品临时库存导入模板.xls",response, request);
                return null;
            }
            if(request.getParameter("zt") != null && !request.getParameter("zt").isEmpty()){
                if(request.getParameter("zt").equals("U")){
                    addLog(getUse(request).getUse002(),"修改了配送日期为：【" + request.getParameter("uname") + "】的信息");
                    cdysb ysb=ysbService.getByid(Integer.valueOf(request.getParameter("id")));
                    ysb.setYsb005(request.getParameter("type"));
                    ysbService.update(ysb);
                    mav.addObject("msg","U");
                }
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, 9);
            mav.addObject("time", calendar.getTime());
            PageBean pb = new PageBean();
            if (request.getParameter("fh") != null && !request.getParameter("fh").isEmpty()) {
                if (request.getParameter("fh").indexOf("CP") >= 0) {
                    PageBean pb1 = new PageBean();
                    if (request.getParameter("pages") != null && !request.getParameter("pages").toString().isEmpty())
                        pb1.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                    else
                        pb1.setCurrentPage(1);
                    if (request.getParameter("name") != null && !request.getParameter("name").toString().isEmpty()) {
                        pb1.setOthersql(request.getParameter("name"));
                    }
                    if (request.getParameter("lx") != null && !request.getParameter("lx").isEmpty()) {
                        pb1.setOthersql1(request.getParameter("lx"));
                    }
                    session.setAttribute("CPpb", pb1);
                    pb.setCurrentPage(1);
                    pb.setOthersql1(request.getParameter("cpid"));
                }
                mav.addObject("fhlx", request.getParameter("fh"));
            } else {
                if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                    pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                else
                    pb.setCurrentPage(1);
                if (request.getParameter("date") != null && !request.getParameter("date").isEmpty()) {
                    pb.setOthersql1(request.getParameter("date"));
                }
                if (request.getParameter("date1") != null && !request.getParameter("date1").isEmpty()) {
                    pb.setOthersql2(request.getParameter("date1"));
                }
                mav.addObject("fhlx", request.getParameter("fhlx"));
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", ysbService.selectPageBean(pb));
        }
        mav.setViewName("HTpsls");
        return mav;
    }

    /**
     * 根据id获取菜品
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachpsls",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachpsls(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        HashMap result = new HashMap();
        cdysb item=ysbService.getByid(id);
        result.put("item",item);
        return JSON.toJSONString(result);
    }

    /**
     * 修改菜品
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/xgpsls")
    public ModelAndView xgpsls(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        cdysb item = new cdysb();
        //修改
        item.setYsb003(DATE.parse(request.getParameter("t3")));
        item.setYsb004(DATE.parse(request.getParameter("t4")));
        if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
            String log = "修改了临时配送日期为：【" + request.getParameter("t1") + "】的信息";
            item.setYsb001(Integer.valueOf((request.getParameter("id"))));
            addLog(getUse(request).getUse002(),log);
            ysbService.update(item);
            mav.addObject("msg", "U");
        }else{
            String log = "新增了临时配送日期为：【" + request.getParameter("t1")+ "】的信息";
            addLog(getUse(request).getUse002(),log);
            item.setYsb005("B");
            item = ysbService.insert(item);
            mav.addObject("msg", "I");
        }
        mav.addObject("pages", request.getParameter("pages"));
        mav.addObject("date", request.getParameter("date"));
        mav.addObject("date1", request.getParameter("date1"));
        mav.addObject("fhlx", request.getParameter("fhlx"));
        mav.setViewName("redirect:/toCo/topsls");
        return mav;
    }

    /**
     * 进入公司员工管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/topsls1")
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
            if(request.getParameter("zt") != null && !request.getParameter("zt").isEmpty()){
                if(request.getParameter("zt").equals("U")){
                    addLog(getUse(request).getUse002(),"修改了配送日期为：【" + request.getParameter("uname") + "】的信息");
                    cdysb ysb=ysbService.getByid(Integer.valueOf(request.getParameter("id")));
                    ysb.setYsb005(request.getParameter("type"));
                    ysbService.update(ysb);
                    mav.addObject("msg","U");
                }else if(request.getParameter("zt").equals("D")){
                        addLog(getUse(request).getUse002(),"删除了配送日期为：【" + request.getParameter("uname") + "】的信息");
                       ysbService.delete(Integer.valueOf(request.getParameter("id")));
                        mav.addObject("msg","D");
                }
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.HOUR_OF_DAY, 12);
            long current = System.currentTimeMillis();
            long tomorrowzero1 = calendar.getTimeInMillis();
            long tomorrowzeroSeconds1 = (tomorrowzero1- current);
//            System.out.println("离12点时间："+tomorrowzeroSeconds1+"秒");
            if(tomorrowzeroSeconds1>0){
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                mav.addObject("time", DATE.format(calendar.getTime()));
//                mav.addObject("ytime", DATE.format(calendar.getTime()));
            }else{
                calendar.add(Calendar.DAY_OF_MONTH, 2);
                mav.addObject("time", DATE.format(calendar.getTime()));
//                mav.addObject("ytime", DATE.format(calendar.getTime()));
            }
            PageBean pb = new PageBean();
            if (request.getParameter("fh") != null && !request.getParameter("fh").isEmpty()) {
                if (request.getParameter("fh").indexOf("CP") >= 0) {
                    PageBean pb1 = new PageBean();
                    if (request.getParameter("pages") != null && !request.getParameter("pages").toString().isEmpty())
                        pb1.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                    else
                        pb1.setCurrentPage(1);
                    if (request.getParameter("name") != null && !request.getParameter("name").toString().isEmpty()) {
                        pb1.setOthersql(request.getParameter("name"));
                    }
                    if (request.getParameter("lx") != null && !request.getParameter("lx").isEmpty()) {
                        pb1.setOthersql1(request.getParameter("lx"));
                    }
                    session.setAttribute("CPpb", pb1);
                    pb.setCurrentPage(1);
                    pb.setOthersql1(request.getParameter("cpid"));
                }
                mav.addObject("fhlx", request.getParameter("fh"));
            } else {
                if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                    pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                else
                    pb.setCurrentPage(1);
                if (request.getParameter("date") != null && !request.getParameter("date").isEmpty()) {
                    pb.setOthersql1(request.getParameter("date"));
                }
                if (request.getParameter("date1") != null && !request.getParameter("date1").isEmpty()) {
                    pb.setOthersql2(request.getParameter("date1"));
                }
                mav.addObject("fhlx", request.getParameter("fhlx"));
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", ysbService.selectPageBean(pb));
            mav.addObject("usdlist", usdService.selectBylx(null));
        }
        mav.setViewName("HTpsls1");
        return mav;
    }

    /**
     * 根据id获取菜品
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachpsls1",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachpsls1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        HashMap result = new HashMap();
        cdysb item=ysbService.getByid1(id);
        result.put("item",item);
        return JSON.toJSONString(result);
    }

    /**
     * 修改菜品
     * 王新苗
     * @param request
     * @param response
     */

    @ResponseBody
    @RequestMapping(value = "/xgpsls1")
    public ModelAndView xgpsls1(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        String[] ids=request.getParameter("t8").split("#");
        for(String id:ids) {
            if (!id.isEmpty()) {
                cdusd usd=usdService.getByid(Integer.valueOf(id));
                System.out.println("*----*"+usd.getUsd011());
                cdysb  item = ysbService.selectBygstime(Integer.valueOf(id),null,request.getParameter("t3"),usd.getUsd011(),null);
                if(item!=null) {//现配送日期
                    System.out.println("---1--");
                    Calendar calendar = Calendar.getInstance();//原配送日期上期
                    calendar.setTime(item.getYsb003());
                    int i = getWeekDay1(calendar);//期数
                    Calendar ca = Calendar.getInstance();//现在
                    ca.setTime(new Date());
                    ca.set(Calendar.HOUR_OF_DAY, 12);
                    ca.set(Calendar.MINUTE, 00);
                    ca.set(Calendar.SECOND, 0);
                    ca.set(Calendar.MILLISECOND, 0);
                    long current = System.currentTimeMillis();
                    long tomorrowzero1 = ca.getTimeInMillis();
                    long tomorrowzeroSeconds1 = (tomorrowzero1- current);
                    if(tomorrowzeroSeconds1<0)ca.add(Calendar.DAY_OF_MONTH, 1);
                    if (item.getYsb008().equals("A")) {
                        ca.add(Calendar.DAY_OF_MONTH, i - getWeekDay1(ca));
                    } else {
                        ca.set(Calendar.DAY_OF_MONTH, Integer.parseInt(sdf5.format(item.getYsb003())));
                    }
                    if(ca.getTime().before(new Date())){//现在<今天
                        if (item.getYsb008().equals("A")) {
                            ca.add(Calendar.DAY_OF_MONTH, 7);
                        } else {
                            int md = ca.getActualMaximum(Calendar.DAY_OF_MONTH);
                            ca.set(Calendar.DAY_OF_MONTH, md);
                        }
                    }
                    if (!request.getParameter("t4").isEmpty())
                        item.setYsb004(TIMEMIAO.parse(request.getParameter("t4") + " 12:00:00"));
                    if (item.getYsb003().before(item.getYsb004())) {//原配送<现配送
                        Calendar calendar1 = Calendar.getInstance();//现配送日期
                        calendar1.setTime(item.getYsb004());
                        if (ca.getTime().after(calendar1.getTime())) {//现在>现配送日期
                            cdysb ysb = ysbService.selectBygstime(Integer.valueOf(id), DATE.format(ca.getTime()), null, usd.getUsd011(), null);
                            if (ysb == null) {
                                cdusb usb=usbService.selectByzq(usd.getUsd011().equals("A")?getWeekDay(ca):Integer.valueOf(sdf5.format(ca.getTime())),usd.getUsd011()); ysb = new cdysb();
                                ysb.setYsb002(item.getYsb002());
                                ysb.setYsb003(ca.getTime());
                                ysb.setYsb004(ca.getTime());
                                ysb.setYsb005("A");
                                ysb.setYsb006(usb.getUsb001());
                                ysb.setYsb008(item.getYsb008());
                                ysbService.insert(ysb);
                            }
                        } else {//现在<=现配送日期
                            ysbService.deleteBygstime(item.getYsb002(), DATE.format(item.getYsb003()), DATE.format(calendar.getTime()), usd.getUsd011(), null);
                        }
                    }
                    else if (item.getYsb003().after(item.getYsb004())) {//原配送<现配送
                        Calendar calendar1 = Calendar.getInstance();//现配送日期
                        calendar1.setTime(item.getYsb004());
                        if(calendar1.getTime().before(ca.getTime())){//现配送<现在
                            yseService.updateBycurentday(ca.getTime(), calendar1.getTime(), Integer.valueOf(id));
                            yhcService.updateBycurentday(ca.getTime(), calendar1.getTime(), Integer.valueOf(id));
                        }else if(calendar1.getTime().after(ca.getTime())){
                            cdysb ysb = ysbService.selectBygstime(Integer.valueOf(id), DATE.format(ca.getTime()), null, usd.getUsd011(), null);
                            if (ysb == null) {
                                cdusb usb=usbService.selectByzq(usd.getUsd011().equals("A")?getWeekDay(ca):Integer.valueOf(sdf5.format(ca.getTime())),usd.getUsd011());
                                ysb = new cdysb();
                                ysb.setYsb002(item.getYsb002());
                                ysb.setYsb003(ca.getTime());
                                ysb.setYsb004(ca.getTime());
                                ysb.setYsb005("A");
                                ysb.setYsb006(usb.getUsb001());
                                ysb.setYsb008(item.getYsb008());
                                ysbService.insert(ysb);
                            }
                            yseService.updateBycurentday(item.getYsb003(), ca.getTime(), Integer.valueOf(id));
                            yhcService.updateBycurentday(item.getYsb003(), ca.getTime(), Integer.valueOf(id));
                        }else{
                            ysbService.deleteBygstime(item.getYsb002(), DATE.format(calendar1.getTime()),DATE.format(calendar1.getTime()), usd.getUsd011(), null);
                            yseService.updateBycurentday(ca.getTime(), calendar1.getTime(), item.getYsb002());
                            yhcService.updateBycurentday(ca.getTime(), calendar1.getTime(), item.getYsb002());
                        }
                    }
                    else{//原配送==现配送
                        yseService.updateBycurentday(item.getYsb003(), item.getYsb004(), Integer.valueOf(id));
                        yhcService.updateBycurentday(item.getYsb003(), item.getYsb004(), Integer.valueOf(id));
                    }
                    //
                    item.setYsb008(usd.getUsd011());
                    item.setYsb005(request.getParameter("t6"));
                    System.out.println("------");
                    if(item.getYsb005().equals("A")){
                        Calendar ca1 = Calendar.getInstance();//现在周期
                        ca1.setTime(new Date());
                        if(item.getYsb008().equals("A")){
                            ca1.add(Calendar.DAY_OF_MONTH, 7);
                        }
                        else{
                            int md=ca1.getActualMaximum(Calendar.DAY_OF_MONTH);
                            ca1.set(Calendar.DAY_OF_MONTH, md);
                        }
                        if(ca1.getTime().after(item.getYsb004())){//现在周期>配送日期
                            ca1.setTime(DATE.parse(request.getParameter("t4")));
                            cdusb usb=usbService.selectByzq(item.getYsb008().equals("A")?getWeekDay(ca1):Integer.valueOf(sdf5.format(ca1.getTime())),usd.getUsd011());
                            item.setYsb006(usb.getUsb001());
                        }else{
                            ca1.setTime(DATE.parse(request.getParameter("t4")));
                            cdusb usb=usbService.getBytime(DATE.format(item.getYsb004()), usd.getUsd011(), "A");
                            if(usb==null){
                                List<cdusf> list=usfService.serachAll();
                                usb=new cdusb();
                                usb.setUsb003(getWeekDay(ca1));
                                usb.setUsb005("A");
                                usb.setUsb008(ca1.getTime());
                                usb=usbService.insert(usb);
                                setList(usb,DATE.format(ca1.getTime()),list);
                            }
                            item.setYsb006(usb.getUsb001());
                        }
                    }
                    ysbService.update(item);
                    mav.addObject("msg", "U");
                }
                else{
                    item=new cdysb();
                    item.setYsb002(Integer.valueOf(id));
                    item.setYsb003(DATE.parse(request.getParameter("t3")));
                    if(!request.getParameter("t4").isEmpty())item.setYsb004(TIMEMIAO.parse(request.getParameter("t4")+" 12:00:00"));
                    item.setYsb008(usd.getUsd011());
                    item.setYsb005(request.getParameter("t6"));
//                    yseService.updateBycurentday(item.getYsb003(),item.getYsb004(),Integer.valueOf(id));
//                    yhcService.updateBycurentday(item.getYsb003(),item.getYsb004(),Integer.valueOf(id));
                    if(item.getYsb005().equals("A")){
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date());
                        if(item.getYsb008().equals("A")){
                            calendar.add(Calendar.DAY_OF_MONTH, 7);
                        }else{
                            int md=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                            calendar.add(Calendar.DAY_OF_MONTH, md);
                        }
                        if(calendar.getTime().after(item.getYsb004())){
                            calendar.setTime(DATE.parse(request.getParameter("t4")));
                            cdusb usb=usbService.selectByzq(item.getYsb008().equals("A")?getWeekDay(calendar):Integer.valueOf(sdf5.format(calendar.getTime())),item.getYsb008());
                            item.setYsb006(usb.getUsb001());
                        }else{
                            calendar.setTime(DATE.parse(request.getParameter("t4")));
                            cdusb usb=usbService.getBytime(DATE.format(item.getYsb004()), "A", "A");
                            if(usb==null){
                                calendar.set(Calendar.HOUR_OF_DAY, 12);
                                calendar.set(Calendar.MINUTE, 00);
                                calendar.set(Calendar.SECOND, 0);
                                calendar.set(Calendar.MILLISECOND, 0);
                                List<cdusf> list=usfService.serachAll();
                                usb=new cdusb();
                                usb.setUsb003(getWeekDay(calendar));
                                usb.setUsb005("A");
                                usb.setUsb008(calendar.getTime());
                                usb=usbService.insert(usb);
                                setList(usb,DATE.format(calendar.getTime()),list);
                            }
                            item.setYsb006(usb.getUsb001());
                        }
                    }
                    item = ysbService.insert(item);
                    mav.addObject("msg", "I");
                }
            }
        }
        mav.addObject("pages", request.getParameter("pages"));
        mav.addObject("date", request.getParameter("date"));
        mav.addObject("date1", request.getParameter("date1"));
        mav.addObject("fhlx", request.getParameter("fhlx"));
        mav.setViewName("redirect:/toCo/topsls1");
        return mav;
    }

/*    @ResponseBody
    @RequestMapping(value = "/xgpsls1")
    public ModelAndView xgpsls1(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        String[] ids=request.getParameter("t8").split("#");
        for(String id:ids) {
            if (!id.isEmpty()) {
                cdysb  item = ysbService.selectBygstime(Integer.valueOf(id),null,request.getParameter("t3"),request.getParameter("t10"),null);
                if(item!=null){//现配送日期
                    System.out.println("---1--");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(item.getYsb003());
                    if(item.getYsb008().equals("A")){
                        calendar.add(Calendar.DAY_OF_MONTH, 7);
                    }
                    else{
                        int md=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                        calendar.add(Calendar.DAY_OF_MONTH, md);
                    }
                    if(!request.getParameter("t4").isEmpty())item.setYsb004(TIMEMIAO.parse(request.getParameter("t4")+" 12:00:00"));
                    if(item.getYsb004().before(calendar.getTime())){
                        //如果现配送日期小于下一期配送
                        Calendar ca = Calendar.getInstance();
                        ca.setTime(new Date());
                        if(item.getYsb008().equals("A")){
                            ca.add(Calendar.DAY_OF_MONTH, 14);
                        }else{
                            int md=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                            ca.add(Calendar.DAY_OF_MONTH, md);
                            md=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                            ca.add(Calendar.DAY_OF_MONTH, md);
                        }
                        if(calendar.getTime().before(ca.getTime())){
                            //如果现配送日期小于下下一期配送
                            cdysb ysb = ysbService.selectBygstime(Integer.valueOf(id),DATE.format(calendar.getTime()),null,request.getParameter("t10"),null);
                            if(ysb==null){
                                cdusb usb=usbService.selectBytimew(getWeekDay(calendar));
                                ysb=new cdysb();
                                ysb.setYsb002(item.getYsb002());
                                ysb.setYsb003(calendar.getTime());
                                ysb.setYsb004(calendar.getTime());
                                ysb.setYsb005("A");
                                ysb.setYsb006(usb.getUsb001());
                                ysb.setYsb008(item.getYsb008());
                                ysbService.insert(ysb);
                            }
                        }
                    }else{
                        ysbService.deleteBygstime(item.getYsb002(),DATE.format(item.getYsb003()),DATE.format(calendar.getTime()),request.getParameter("t10"),null);
                    }
                    //
                    item.setYsb008(request.getParameter("t10"));
                    item.setYsb005(request.getParameter("t6"));
                    System.out.println("------");
                    yseService.updateBycurentday(item.getYsb003(),item.getYsb004(),Integer.valueOf(id));
                    yhcService.updateBycurentday(item.getYsb003(),item.getYsb004(),Integer.valueOf(id));
                    if(item.getYsb005().equals("A")){
                        calendar.setTime(new Date());
                        if(item.getYsb008().equals("A")){
                            calendar.add(Calendar.DAY_OF_MONTH, 7);
                        }else{
                            int md=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                            calendar.add(Calendar.DAY_OF_MONTH, md);
                        }
                        if(calendar.getTime().after(item.getYsb004())){
                            calendar.setTime(DATE.parse(request.getParameter("t4")));
                            calendar.set(Calendar.HOUR_OF_DAY, 12);
                            calendar.set(Calendar.MINUTE, 00);
                            calendar.set(Calendar.SECOND, 0);
                            calendar.set(Calendar.MILLISECOND, 0);
                            cdusb usb=usbService.selectByzq(item.getYsb008().equals("A")?getWeekDay(calendar):Integer.valueOf(sdf5.format(calendar.getTime())),item.getYsb008());
                            item.setYsb006(usb.getUsb001());
                        }else{
                            calendar.setTime(DATE.parse(request.getParameter("t4")));
                            cdusb usb=usbService.getBytime(DATE.format(item.getYsb004()), "A", "A");
                            if(usb==null){
                                calendar.set(Calendar.HOUR_OF_DAY, 12);
                                calendar.set(Calendar.MINUTE, 00);
                                calendar.set(Calendar.SECOND, 0);
                                calendar.set(Calendar.MILLISECOND, 0);
                                List<cdusf> list=usfService.serachAll();
                                usb=new cdusb();
                                usb.setUsb003(getWeekDay(calendar));
                                usb.setUsb005("A");
                                usb.setUsb008(calendar.getTime());
                                usb=usbService.insert(usb);
                                setList(usb,list);
                            }
                            item.setYsb006(usb.getUsb001());
                        }
                    }
                    ysbService.update(item);
                    mav.addObject("msg", "U");
                }
                else{
                    item=new cdysb();
                    item.setYsb002(Integer.valueOf(id));
                    item.setYsb003(DATE.parse(request.getParameter("t3")));
                    if(!request.getParameter("t4").isEmpty())item.setYsb004(TIMEMIAO.parse(request.getParameter("t4")+" 12:00:00"));
                    item.setYsb008(request.getParameter("t10"));
                    item.setYsb005(request.getParameter("t6"));
//                    yseService.updateBycurentday(item.getYsb003(),item.getYsb004(),Integer.valueOf(id));
//                    yhcService.updateBycurentday(item.getYsb003(),item.getYsb004(),Integer.valueOf(id));
                    if(item.getYsb005().equals("A")){
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date());
                        if(item.getYsb008().equals("A")){
                            calendar.add(Calendar.DAY_OF_MONTH, 7);
                        }else{
                            int md=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                            calendar.add(Calendar.DAY_OF_MONTH, md);
                        }
                        if(calendar.getTime().after(item.getYsb004())){
                            calendar.setTime(DATE.parse(request.getParameter("t4")));
                            cdusb usb=usbService.selectByzq(item.getYsb008().equals("A")?getWeekDay(calendar):Integer.valueOf(sdf5.format(calendar.getTime())),item.getYsb008());
                            item.setYsb006(usb.getUsb001());
                        }else{
                            calendar.setTime(DATE.parse(request.getParameter("t4")));
                            cdusb usb=usbService.getBytime(DATE.format(item.getYsb004()), "A", "A");
                            if(usb==null){
                                calendar.set(Calendar.HOUR_OF_DAY, 12);
                                calendar.set(Calendar.MINUTE, 00);
                                calendar.set(Calendar.SECOND, 0);
                                calendar.set(Calendar.MILLISECOND, 0);
                                List<cdusf> list=usfService.serachAll();
                                usb=new cdusb();
                                usb.setUsb003(getWeekDay(calendar));
                                usb.setUsb005("A");
                                usb.setUsb008(calendar.getTime());
                                usb=usbService.insert(usb);
                                setList(usb,list);
                            }
                            item.setYsb006(usb.getUsb001());
                        }
                    }
                    item = ysbService.insert(item);
                    mav.addObject("msg", "I");
                }
            }
        }
        mav.addObject("pages", request.getParameter("pages"));
        mav.addObject("date", request.getParameter("date"));
        mav.addObject("date1", request.getParameter("date1"));
        mav.addObject("fhlx", request.getParameter("fhlx"));
        mav.setViewName("redirect:/toCo/topsls1");
        return mav;
    }*/

    @ResponseBody
    @RequestMapping(value = "/xgpsls2")
    public ModelAndView xgpsls2(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        cdysb item = ysbService.getByid(Integer.valueOf(request.getParameter("id")));
        //修改
//        item.setYsb003(DATE.parse(request.getParameter("t3")));
        if(!request.getParameter("t4").isEmpty())item.setYsb004(DATE.parse(request.getParameter("t4")));
        System.out.println("---1--");
        Calendar calendar = Calendar.getInstance();//原配送日期上期
        calendar.setTime(item.getYsb003());
        int i = getWeekDay1(calendar);//期数
        Calendar ca = Calendar.getInstance();//现在
        ca.setTime(new Date());
        ca.set(Calendar.HOUR_OF_DAY, 12);
        ca.set(Calendar.MINUTE, 00);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);
        long current = System.currentTimeMillis();
        long tomorrowzero1 = ca.getTimeInMillis();
        long tomorrowzeroSeconds1 = (tomorrowzero1- current);
        if(tomorrowzeroSeconds1<0)ca.add(Calendar.DAY_OF_MONTH, 1);
        if (item.getYsb008().equals("A")) {
            ca.add(Calendar.DAY_OF_MONTH, i - getWeekDay1(ca));
        } else {
            ca.set(Calendar.DAY_OF_MONTH, Integer.parseInt(sdf5.format(item.getYsb003())));
        }
        if(ca.getTime().before(new Date())){//现在<今天
            if (item.getYsb008().equals("A")) {
                ca.add(Calendar.DAY_OF_MONTH, 7);
            } else {
                int md = ca.getActualMaximum(Calendar.DAY_OF_MONTH);
                ca.set(Calendar.DAY_OF_MONTH, md);
            }
        }
        if (!request.getParameter("t4").isEmpty())
            item.setYsb004(TIMEMIAO.parse(request.getParameter("t4") + " 12:00:00"));
        if (item.getYsb003().before(item.getYsb004())) {//原配送<现配送
            Calendar calendar1 = Calendar.getInstance();//现配送日期
            calendar1.setTime(item.getYsb004());
            if (ca.getTime().after(calendar1.getTime())) {//现在>现配送日期
                cdysb ysb = ysbService.selectBygstime(item.getYsb002(), DATE.format(ca.getTime()), null, item.getYsb008(), null);
                if (ysb == null) {
                    cdusb usb=usbService.selectByzq(item.getYsb008().equals("A")?getWeekDay(ca):Integer.valueOf(sdf5.format(ca.getTime())),item.getYsb008()); ysb = new cdysb();
                    ysb.setYsb002(item.getYsb002());
                    ysb.setYsb003(ca.getTime());
                    ysb.setYsb004(ca.getTime());
                    ysb.setYsb005("A");
                    ysb.setYsb006(usb.getUsb001());
                    ysb.setYsb008(item.getYsb008());
                    ysbService.insert(ysb);
                }
            } else {//现在<=现配送日期
                ysbService.deleteBygstime(item.getYsb002(), DATE.format(item.getYsb003()), DATE.format(item.getYsb004()), item.getYsb008(), null);
            }
        }
        else if (item.getYsb003().after(item.getYsb004())) {//原配送<现配送
            Calendar calendar1 = Calendar.getInstance();//现配送日期
            calendar1.setTime(item.getYsb004());
            if(calendar1.getTime().before(ca.getTime())){//现配送<现在
                yseService.updateBycurentday(ca.getTime(), calendar1.getTime(), item.getYsb002());
                yhcService.updateBycurentday(ca.getTime(), calendar1.getTime(), item.getYsb002());
            }else if(calendar1.getTime().after(ca.getTime())){
                cdysb ysb = ysbService.selectBygstime(item.getYsb002(), DATE.format(ca.getTime()), null, item.getYsb008(), null);
                if (ysb == null) {
                    cdusb usb=usbService.selectByzq(item.getYsb008().equals("A")?getWeekDay(ca):Integer.valueOf(sdf5.format(ca.getTime())),item.getYsb008());
                    ysb = new cdysb();
                    ysb.setYsb002(item.getYsb002());
                    ysb.setYsb003(ca.getTime());
                    ysb.setYsb004(ca.getTime());
                    ysb.setYsb005("A");
                    ysb.setYsb006(usb.getUsb001());
                    ysb.setYsb008(item.getYsb008());
                    ysbService.insert(ysb);
                }
                yseService.updateBycurentday(item.getYsb003(), ca.getTime(), item.getYsb002());
                yhcService.updateBycurentday(item.getYsb003(), ca.getTime(), item.getYsb002());
            }else{
                ysbService.deleteBygstime(item.getYsb002(), DATE.format(calendar1.getTime()),DATE.format(calendar1.getTime()),item.getYsb008(), null);
                yseService.updateBycurentday(ca.getTime(), calendar1.getTime(), item.getYsb002());
                yhcService.updateBycurentday(ca.getTime(), calendar1.getTime(), item.getYsb002());
            }
        }else{//原配送==现配送
            yseService.updateBycurentday(item.getYsb003(), item.getYsb004(), item.getYsb002());
            yhcService.updateBycurentday(item.getYsb003(), item.getYsb004(), item.getYsb002());
        }
        //
        item.setYsb005(request.getParameter("tt6"));
        System.out.println("------");
        if(item.getYsb005().equals("A")){
            Calendar ca1 = Calendar.getInstance();//现在周期
            ca1.setTime(new Date());
            if(item.getYsb008().equals("A")){
                ca1.add(Calendar.DAY_OF_MONTH, 7);
            }
            else{
                int md=ca1.getActualMaximum(Calendar.DAY_OF_MONTH);
                ca1.set(Calendar.DAY_OF_MONTH, md);
            }
            if(ca1.getTime().after(item.getYsb004())){//现在周期>配送日期
                ca1.setTime(DATE.parse(request.getParameter("t4")));
                cdusb usb=usbService.selectByzq(item.getYsb008().equals("A")?getWeekDay(ca1):Integer.valueOf(sdf5.format(ca1.getTime())),item.getYsb008());
                item.setYsb006(usb.getUsb001());
            }else{
                ca1.setTime(DATE.parse(request.getParameter("t4")));
                cdusb usb=usbService.getBytime(DATE.format(item.getYsb004()), item.getYsb008(), "A");
                if(usb==null){
                    List<cdusf> list=usfService.serachAll();
                    usb=new cdusb();
                    usb.setUsb003(getWeekDay(ca1));
                    usb.setUsb005("A");
                    usb.setUsb008(ca1.getTime());
                    usb=usbService.insert(usb);
                    setList(usb,DATE.format(ca1.getTime()),list);
                }
                item.setYsb006(usb.getUsb001());
            }
        }
        String log = "修改了临时配送日期为：【" + request.getParameter("t3") + "】的信息";
        item.setYsb001(Integer.valueOf((request.getParameter("id"))));
        addLog(getUse(request).getUse002(),log);
        ysbService.update(item);
        mav.addObject("msg", "U");
        mav.addObject("pages", request.getParameter("pages"));
        mav.addObject("date", request.getParameter("date"));
        mav.addObject("date1", request.getParameter("date1"));
        mav.addObject("fhlx", request.getParameter("fhlx"));
        mav.setViewName("redirect:/toCo/topsls1");
        return mav;
    }

    /**
     * 进入公司员工管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
/*    @RequestMapping("/tops")
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

            cdusd usd=usdService.getByid(Integer.valueOf(request.getParameter("gsid")));
            List<Integer> dlist=new ArrayList<>();
            for(cdyhb yhb:usd.getYhblist()){
                dlist.add(yhb.getUsb().getUsb003());
            }

//            List<cdysb> lslist=ysbService.selectBygsid(usd.getUsd001());

            List<Date> list=new ArrayList<>();

            Calendar ca = Calendar.getInstance();
            ca.setTime(new Date());
            int i=getWeekDay(ca);
            dlist.contains(i);
            while(list.size()<20){
                if(list.size()<20){
                    ca.add(Calendar.DAY_OF_MONTH, 1);
                    list.add(ca.getTime());
                    cdysb item=ysbService.selectBygsid(usd.getUsd001(),DATE.format(ca.getTime()));
                }
            }
            mav.addObject("list", list);
            mav.addObject("gsid", request.getParameter("gsid"));
            mav.addObject("pages", request.getParameter("pages"));
            mav.addObject("name", request.getParameter("name"));
            mav.addObject("phone", request.getParameter("phone"));
        }
        mav.setViewName("HTgslsps");
        return mav;
    }*/
}
