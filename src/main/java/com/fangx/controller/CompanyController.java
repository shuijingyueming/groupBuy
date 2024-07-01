package com.fangx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fangx.model.*;
import com.fangx.pub.Datamsg;
import com.fangx.until.EncrpytUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
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
            mav.addObject("usblist", usbService.serachAll());
        }
        mav.setViewName("HTgs");
        return mav;
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
        String[] ids=request.getParameter("t8").split("#");
        yhbService.deletebyid(item.getUsd001());
        cdyhb yhb = new cdyhb();
        for(String id:ids){
            if(!id.isEmpty()){
                yhb.setYhb001(UUID.randomUUID().toString().replace("-",""));
                yhb.setYhb002(Integer.valueOf(id));
                yhb.setYhb003(item.getUsd001());
                yhbService.insert(yhb);
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
                    yhdService.insert(yhd);
                    uscService.update(item);
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
            mav.addObject("usdlist", usdService.serachAll());
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
                mav.addObject("fhlx", request.getParameter("fhlx"));
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", yhdService.selectPageBean(pb));
            mav.addObject("usdlist", usdService.serachAll());
            mav.addObject("usclist", uscService.serachAll(null));
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
                if(request.getParameter("zt").equals("D")){
                    addLog(getUse(request).getUse002(),"删除了配送日期为：【" + request.getParameter("uname") + "】的信息");
                    ysbService.delete(Integer.valueOf(request.getParameter("id")));
                    mav.addObject("msg","D");
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
