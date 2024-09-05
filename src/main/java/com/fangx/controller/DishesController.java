package com.fangx.controller;

import com.alibaba.fastjson.JSON;
import com.fangx.model.*;
import com.fangx.until.ExcelExport;
import com.fangx.until.OSSUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/toDi")
public class DishesController extends BaseController {

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 进入分类管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/tofl")
    public ModelAndView tofl(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
                if(request.getParameter("zt").equals("D")){
                    String type=request.getParameter("type");
                    if(type.equals("A")){
                        addLog(getUse(request).getUse002(),"删除了一级分类名字为：【" + request.getParameter("uname") + "】的信息");
                        cdyhe item=yheService.getByid(Integer.parseInt(request.getParameter("id")));
                        uploadpic(null,null,"cpflimg/"+item.getYhe003());
                        yheService.delete(Integer.parseInt(request.getParameter("id")));
                    }else{
                        addLog(getUse(request).getUse002(),"删除了二级分类名字为：【" + request.getParameter("uname") + "】的信息");
                        ysaService.delete(Integer.parseInt(request.getParameter("id")));
                    }
                    mav.addObject("msg","D");
                }
            }
            List<cdyhe> list=yheService.serachAll(request.getParameter("name"));
            delsession(session,request.getParameter("fh"));
            mav.addObject("list", list);
            mav.addObject("name", request.getParameter("name"));
        }
        mav.setViewName("HTcpfl");
        return mav;
    }

    /**
     * 根据id获取分类
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachfl",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachfl(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String type=request.getParameter("type");
        Integer id = Integer.valueOf(request.getParameter("id"));
        HashMap result = new HashMap();
        if(type.equals("A")){
            cdyhe item=yheService.getByid(id);
            result.put("item",item);
        }else{
            cdysa item=ysaService.getByid(id);
            result.put("item",item);
        }
        return JSON.toJSONString(result);
    }

    /**
     * 修改分类
     * 王新苗
     * @param request
     * @param response
     */
    @RequestMapping(value = "/xgfl")
    public ModelAndView xgfl(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        if(request.getParameter("sjid").isEmpty()){
            cdyhe item = new cdyhe();
            item.setYhe002(request.getParameter("t1"));
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
            MultipartFile file = multipartHttpServletRequest.getFile("t2");
            if(null!=file.getOriginalFilename()&&!file.getOriginalFilename().toString().isEmpty()){
                Date date = new Date();
                String filename = sdf.format(date)+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                item.setYhe003(filename);
                uploadpic("cpflimg/"+filename,file,"cpflimg/"+request.getParameter("t3"));
            }
            if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
                String log = "修改了名字为：【" + request.getParameter("t1") + "】的一级分类信息";
                item.setYhe001(Integer.valueOf((request.getParameter("id"))));
                addLog(getUse(request).getUse002(),log);
                yheService.update(item);
                mav.addObject("msg", "U");
            }else{
                String log = "新增了名字为：【" + request.getParameter("t1")+ "】的一级分类信息";
                addLog(getUse(request).getUse002(),log);
                item = yheService.insert(item);
                mav.addObject("msg", "I");
            }
        }else{
            cdysa item = new cdysa();
            item.setYsa002(request.getParameter("t1"));
            item.setYsa003(Integer.valueOf(request.getParameter("sjid")));
            if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
                String log = "修改了名字为：【" + request.getParameter("t1") + "】的二级分类信息";
                item.setYsa001(Integer.valueOf((request.getParameter("id"))));
                addLog(getUse(request).getUse002(),log);
                ysaService.update(item);
                mav.addObject("msg", "U");
            }else{
                String log = "新增了名字为：【" + request.getParameter("t1")+ "】的二级分类信息";
                addLog(getUse(request).getUse002(),log);
                item = ysaService.insert(item);
                mav.addObject("msg", "I");
            }
        }
        mav.addObject("name", request.getParameter("name"));
        mav.setViewName("redirect:/toDi/tofl");
        return mav;
    }

    /**
     * 进入单位管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/todw")
    public ModelAndView todw(HttpServletRequest request, HttpServletResponse response) throws Exception{
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
                if(request.getParameter("zt").equals("D")){
                    addLog(getUse(request).getUse002(),"删除了单位名字为：【" + request.getParameter("uname") + "】的信息");
                    usmService.delete(Integer.parseInt(request.getParameter("id")));
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
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", usmService.selectPageBean(pb));
        }
        mav.setViewName("HTcpdw");
        return mav;
    }

    /**
     * 根据id获取单位
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachdw",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachdw(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        HashMap result = new HashMap();
        cdusm item=usmService.getByid(id);
        result.put("item",item);
        return JSON.toJSONString(result);
    }

    /**
     * 修改单位
     * 王新苗
     * @param request
     * @param response
     */
    @RequestMapping(value = "/xgdw")
    public ModelAndView xgdw(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        cdusm item = new cdusm();
        //修改
        item.setUsm002(request.getParameter("t1"));
        if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
            String log = "修改了名字为：【" + request.getParameter("t1") + "】的单位信息";
            item.setUsm001(Integer.valueOf((request.getParameter("id"))));
            addLog(getUse(request).getUse002(),log);
            usmService.update(item);
            mav.addObject("msg", "U");
        }else{
            String log = "新增了名字为：【" + request.getParameter("t1")+ "】的单位信息";
            addLog(getUse(request).getUse002(),log);
            item = usmService.insert(item);
            mav.addObject("msg", "I");
        }
        mav.addObject("pages", request.getParameter("pages"));
        mav.addObject("name", request.getParameter("name"));
        mav.setViewName("redirect:/toDi/todw");
        return mav;
    }

    /**
     * 进入菜品管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/tocp")
    public ModelAndView tocp(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
                downloadLocal(fpath.substring(1,fpath.length())+"static/upload/cp.xls", "菜品导入模板.xls",response, request);
                return null;
            }
            if(request.getParameter("zt") != null && !request.getParameter("zt").isEmpty()){
                if(request.getParameter("zt").equals("K")){
                    cdusf item =usfService.getByid(Integer.parseInt(request.getParameter("id")));
                    addLog(getUse(request).getUse002(),"修改了菜品名字为：【" + item.getUsf002() + "】的库存");
                    if(request.getParameter("lx").equals("B")){
                        item.setUsf010(Integer.valueOf(request.getParameter("num")));
                    }else{
                        item.setUsf010(null);
                    }
                    usfService.update(item);
//                    if(item.getUsf013().equals("C")){
                        List<cdusb> list=usbService.serachAll(null);
                        for(cdusb usb:list){
                            cdyha yha=yhaService.getByqscp(usb.getUsb001(),item.getUsf001());
                            if(yha==null){
                                yha=new cdyha();
                                yha.setYha002(item.getUsf001());
                                yha.setYha003(usb.getUsb001());
                                yha.setYha004(item.getUsf010()==null?0:item.getUsf010());
                                yha.setYha005(item.getUsf010()==null?"P":"C");
                                yha.setYha006(0);
                                yha.setYha009(item.getUsf013().equals("C")?"B":"A");
                                yhaService.insert(yha);
                            }else{
                                if(yha.getYha009()==null||yha.getYha009().equals("B")){
                                    yha.setYha002(item.getUsf001());
                                    yha.setYha003(usb.getUsb001());
                                    yha.setYha004(item.getUsf010()==null?0:item.getUsf010());
                                    yha.setYha005(item.getUsf010()==null?"P":"C");
                                    yha.setYha006(0);
                                    yha.setYha008(0);
                                    yhaService.update(yha);
                                }
                            }
                        }
//                    }
                    mav.addObject("msg","C");
                }else if(request.getParameter("zt").equals("U")){
                    addLog(getUse(request).getUse002(),"修改了菜品名字为：【" + request.getParameter("uname") + "】的状态");
                    cdusf item =usfService.getByid(Integer.parseInt(request.getParameter("id")));
                    item.setUsf013(request.getParameter("type"));
                    usfService.update(item);
                    if(!item.getUsf013().equals("B")&&request.getParameter("TK") != null &&request.getParameter("TK").equals("TK")){
                        List<cdusb> list=usbService.serachAll(null);
                        for(cdusb usb:list){
                            cdyha yha=yhaService.getByqscp(usb.getUsb001(),item.getUsf001());
                            if(yha==null){
                                yha=new cdyha();
                                yha.setYha002(item.getUsf001());
                                yha.setYha003(usb.getUsb001());
                                yha.setYha004(item.getUsf010()==null?0:item.getUsf010());
                                yha.setYha005(item.getUsf010()==null?"P":"C");
                                yha.setYha006(0);
                                yha.setYha009(item.getUsf013().equals("C")?"B":"A");
                                yhaService.insert(yha);
                            }else{
                                yha.setYha002(item.getUsf001());
                                yha.setYha003(usb.getUsb001());
                                yha.setYha004(item.getUsf010()==null?0:item.getUsf010());
                                yha.setYha005(item.getUsf010()==null?"P":"C");
                                yha.setYha006(0);
                                yha.setYha009(item.getUsf013().equals("C")?"B":"A");
                                yhaService.update(yha);
                            }
                        }
                    }
                    mav.addObject("msg","C");
                }else if(request.getParameter("zt").equals("X")){
                    addLog(getUse(request).getUse002(),"修改了菜品名字为：【" + request.getParameter("uname") + "】的销量状态");
                    cdusf item =usfService.getByid(Integer.parseInt(request.getParameter("id")));
                    item.setUsf016(request.getParameter("type"));
                    usfService.update(item);
                    mav.addObject("msg","C");
                }else if(request.getParameter("zt").equals("D")){
                    addLog(getUse(request).getUse002(),"删除了菜品名字为：【" + request.getParameter("uname") + "】的信息");
                    cduse item =useService.getByid(Integer.parseInt(request.getParameter("id")));
                    useService.update(item);
                    mav.addObject("msg","D");
                }
            }
            PageBean pb = new PageBean();
            if(request.getParameter("fh")!=null && !request.getParameter("fh").isEmpty()){
                if(request.getParameter("fh").indexOf("CP")>=0){
                    pb=(PageBean)session.getAttribute("CPpb");
                    session.removeAttribute("CPpb");
                }
            }else{
                if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                    pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
                else
                    pb.setCurrentPage(1);
                if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                    pb.setOthersql(request.getParameter("name"));
                }
                if (request.getParameter("ztype") != null && !request.getParameter("ztype").isEmpty()) {
                    pb.setOthersql1(request.getParameter("ztype"));
                }
                if (request.getParameter("yjid") != null && !request.getParameter("yjid").isEmpty()) {
                    pb.setOthersql2(request.getParameter("yjid"));
                }
                if (request.getParameter("ejid") != null && !request.getParameter("ejid").isEmpty()) {
                    pb.setOthersql3(request.getParameter("ejid"));
                }
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", usfService.selectPageBean(pb));
            mav.addObject("usmlist", usmService.serachAll());
            mav.addObject("yhelist", yheService.serachAll(null));
            mav.addObject("ysalist", ysaService.serachAll(null));
        }
        mav.setViewName("HTcp");
        return mav;
    }

    /**
     * 根据id获取菜品
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachcp",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachcp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        HashMap result = new HashMap();
        cdusf item=usfService.getByid(id);
        result.put("item",item);
        return JSON.toJSONString(result);
    }

    /**
     * 修改菜品
     * 王新苗
     * @param request
     * @param response
     */
//    @RequestMapping(value = "/xgcp")
//    public ModelAndView xgcp(HttpServletRequest request,HttpServletResponse response) throws Exception {
    @ResponseBody
    @RequestMapping(value = "/xgcp",method= RequestMethod.POST)
    public String xgcp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap result = new HashMap();
//        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        cdusf item = new cdusf();
        //修改
        item.setUsf002(request.getParameter("t1"));
        item.setUsf003(request.getParameter("t8"));
        item.setUsf004(Integer.valueOf(request.getParameter("t4")));
        item.setUsf005(Float.valueOf(request.getParameter("t5")));
        if(!request.getParameter("t6").isEmpty())item.setUsf006(Float.valueOf(request.getParameter("t6")));
        item.setUsf007(request.getParameter("t7"));
        if(!request.getParameter("t10").isEmpty())item.setUsf010(Integer.valueOf(request.getParameter("t10")));
        if(!request.getParameter("t11").isEmpty())item.setUsf011(Integer.valueOf(request.getParameter("t11")));
        if(!request.getParameter("t12").isEmpty())item.setUsf012(Integer.valueOf(request.getParameter("t12")));
        if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
            String log = "修改了名字为：【" + request.getParameter("t1") + "】的菜品信息";
            item.setUsf001(Integer.valueOf((request.getParameter("id"))));
            addLog(getUse(request).getUse002(),log);
            usfService.update(item);
//            mav.addObject("msg", "U");
        }else{
            String log = "新增了名字为：【" + request.getParameter("t1")+ "】的菜品信息";
            addLog(getUse(request).getUse002(),log);
            item.setUsf008(0);
            item.setUsf009(0.0F);
            item.setUsf013("C");
            item.setUsf016("A");
            item = usfService.insert(item);
            cdyha yha=new cdyha();
            yha.setYha002(item.getUsf001());
            yha.setYha004(0);
            yha.setYha006(0);
            yha.setYha008(0);
            yha.setYha005("A");
            yha.setYha009("B");
            for(int i=1;i<8;i++){
                yha.setYha003(i);
                yhaService.insert(yha);
            }
//            mav.addObject("msg", "I");
        }
        String path = request.getSession().getServletContext().getRealPath("/");
        cdusn usn = new cdusn();
        usn.setUsn002(item.getUsf001());
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> t1 = multipartRequest.getFiles("t2");
        if(t1!=null&&t1.size()>0&&!t1.get(0).getOriginalFilename().isEmpty()){
            for(int i=0;i<t1.size();i++){
                if (t1.get(i).getOriginalFilename()!=null && !t1.get(i).getOriginalFilename().isEmpty()) {
//                    String filename =sdf.format(new Date())+i+(t1.get(i).getOriginalFilename().substring(t1.get(i).getOriginalFilename().lastIndexOf("."))).toLowerCase();
//                    usn.setUsn003(filename);
//                    uploadpic("shopimg/"+filename,t1.get(i),null);
                    String imagename[] = OSSUtil.uploadObjectOSS(t1.get(i),"A");
                    usn.setUsn003(imagename[1]);
                    usnService.insert(usn);
                }
            }
        }
        String delimg=request.getParameter("delimg");
//        System.out.println("delimg:"+delimg);
        if(!delimg.isEmpty()){
            String[] ids=delimg.split("#");
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>)(List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            if(list!=null&&list.size()>0){
                for(String n:list){
//                    if(n!="")uploadpic(null,null,"shopimg/"+n);
                  if(n!="")OSSUtil.deleteFile(n,"A");
                }
                usnService.deleteById(list);
            }
        }
//        mav.addObject("pages", request.getParameter("pages"));
//        mav.addObject("phone", request.getParameter("phone"));
//        mav.addObject("name", request.getParameter("name"));
//        mav.setViewName("redirect:/toDi/tocp");
//        return mav;
        result.put("msg","1");
        return JSON.toJSONString(result);
    }


    /**
     * 进入期数管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/toqs")
    public ModelAndView toqs(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
                new ExcelExport().Excelexportyhdd(request, response,usbService,usfService,usdService,uscService,yhcService,ushService,Integer.valueOf(request.getParameter("id")), request.getParameter("date"));
                return null;
            }
            mav.addObject("list",usbService.serachAll(null));
        }
        mav.setViewName("HTqs");
        return mav;
    }

    /**
     * 根据id获取期数
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachqs",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachqs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        HashMap result = new HashMap();
        cdusb item=usbService.getByid(id);
        result.put("item",item);
        return JSON.toJSONString(result);
    }


    /**
     * 修改期数
     * 王新苗
     * @param request
     * @param response
     */
    @RequestMapping(value = "/xgqs")
    public ModelAndView xgqs(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        cdusb item = new cdusb();
        item.setUsb002(request.getParameter("t1").split("#")[1]);
        item.setUsb003(Integer.valueOf(request.getParameter("t1").split("#")[0]));
        if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
            String log = "修改了名字为：【" + request.getParameter("t1") + "】的期数信息";
            item.setUsb001(Integer.valueOf((request.getParameter("id"))));
            addLog(getUse(request).getUse002(),log);
            usbService.update(item);
            mav.addObject("msg", "U");
        }else{
            String log = "新增了名字为：【" + request.getParameter("t1")+ "】的期数信息";
            addLog(getUse(request).getUse002(),log);
            item = usbService.insert(item);
            mav.addObject("msg", "I");
            List<cdusf> list=usfService.serachAll();
            cdyha yha=new cdyha();
            for(cdusf usf:list){
                yha.setYha002(usf.getUsf001());
                yha.setYha003(item.getUsb001());
                yha.setYha004(usf.getUsf010());
                yha.setYha005(usf.getUsf010()==0?"P":"C");
                yha.setYha006(0);
                yhaService.insert(yha);
            }
        }
//        mav.addObject("name", request.getParameter("name"));
        mav.setViewName("redirect:/toDi/toqs");
        return mav;
    }

    /**
     * 进入菜品管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/toqscp")
    public ModelAndView toqscp(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
            if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
            else
                pb.setCurrentPage(1);
            if (request.getParameter("qsid") != null && !request.getParameter("qsid").isEmpty()) {
                pb.setOthersql1(request.getParameter("qsid"));
            }
            if(request.getParameter("zt") != null && !request.getParameter("zt").isEmpty()){
                if(request.getParameter("zt").equals("U")){
                    addLog(getUse(request).getUse002(),"修改了菜品名字为：【" + request.getParameter("uname") + "】的团购类型");
                    if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
                        cdyha yha =yhaService.getByid(Integer.parseInt(request.getParameter("id")));
                        yha.setYha005(request.getParameter("type"));
                        yhaService.update(yha);
                    }else{
                        cdusf item =usfService.getByid(Integer.parseInt(request.getParameter("cpid")));
                        cdyha yha=new cdyha();
                        yha.setYha002(item.getUsf001());
                        yha.setYha003(Integer.valueOf(pb.getOthersql1()));
                        yha.setYha004(item.getUsf010());
                        yha.setYha005(request.getParameter("type"));
                        yha.setYha006(0);
                        yhaService.insert(yha);
                    }
                    mav.addObject("msg","C");
                }else if(request.getParameter("zt").equals("A")){
                    addLog(getUse(request).getUse002(),"修改了菜品名字为：【" + request.getParameter("uname") + "】的库存数");
                    if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
                        cdyha yha =yhaService.getByid(Integer.parseInt(request.getParameter("id")));
                        yha.setYha006(yha.getYha006()+Integer.valueOf(request.getParameter("num")));
                        yhaService.update(yha);
                    }else{
                        cdusf item =usfService.getByid(Integer.parseInt(request.getParameter("cpid")));
                        cdyha yha=new cdyha();
                        yha.setYha002(item.getUsf001());
                        yha.setYha003(Integer.valueOf(pb.getOthersql1()));
                        yha.setYha004(item.getUsf010());
                        yha.setYha005("C");
                        yha.setYha006(Integer.valueOf(request.getParameter("num")));
                        yhaService.insert(yha);
                    }
                    mav.addObject("msg","C");
                }
            }
            if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                pb.setOthersql(request.getParameter("name"));
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", usfService.selectPageBean1(pb));
        }
        mav.setViewName("HTqscp");
        return mav;
    }

    /**
     * 根据id获取菜品
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachqscp",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachqscp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        HashMap result = new HashMap();
        cdusf item=usfService.getByid(id);
        item.setYha(yhaService.getByqscp(Integer.valueOf(request.getParameter("qsid")),id));
        result.put("item",item);
        return JSON.toJSONString(result);
    }


    /**
     * 进入公司员工管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/tocpls")
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
                    yscService.delete(Integer.valueOf(request.getParameter("id")));
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
                    if (request.getParameter("yjid") != null && !request.getParameter("yjid").isEmpty()) {
                        pb1.setOthersql2(request.getParameter("yjid"));
                    }
                    if (request.getParameter("ejid") != null && !request.getParameter("ejid").isEmpty()) {
                        pb1.setOthersql3(request.getParameter("ejid"));
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
                if (request.getParameter("cpid") != null && !request.getParameter("cpid").isEmpty()) {
                    pb.setOthersql1(request.getParameter("cpid"));
                }
                if (request.getParameter("date") != null && !request.getParameter("date").isEmpty()) {
                    pb.setOthersql2(request.getParameter("date"));
                }
                mav.addObject("fhlx", request.getParameter("fhlx"));
            }
            delsession(session,request.getParameter("fh"));

//            cdusf item=usfService.getByid(Integer.valueOf(request.getParameter("cpid")));
//            List<cdysc> list=yscService.selectBycp(Integer.valueOf(request.getParameter("cpid")),request.getParameter("date"));
//            mav.addObject("cp", item);
            mav.addObject("pageobj", yscService.selectPageBean(pb));
            mav.addObject("cplist",usfService.serachAll());
        }
        mav.setViewName("HTcpls");
        return mav;
    }

    /**
     * 根据id获取菜品
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachcpls",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachcpls(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        HashMap result = new HashMap();
        cdysc item=yscService.getByid(id);
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
    @RequestMapping(value = "/xgcpls")
    public ModelAndView xgcpls(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        cdysc item = new cdysc();
        //修改
        item.setYsc002(Integer.valueOf(request.getParameter("t2")));
        item.setYsc003(DATE.parse(request.getParameter("t1")));
        item.setYsc006(Integer.valueOf(request.getParameter("t6")));
        if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
            String log = "修改了配送日期为：【" + request.getParameter("t1") + "】的菜品临时库存信息";
            item.setYsc001(Integer.valueOf((request.getParameter("id"))));
            addLog(getUse(request).getUse002(),log);
            yscService.update(item);
            mav.addObject("msg", "U");
        }else{
            item.setYsc005("B");
            String log = "新增了配送日期为：【" + request.getParameter("t1")+ "】的菜品临时库存信息";
            addLog(getUse(request).getUse002(),log);
            item = yscService.insert(item);
            mav.addObject("msg", "I");
        }
        mav.addObject("cpid", request.getParameter("cpid"));
        mav.addObject("pages", request.getParameter("pages"));
        mav.addObject("date", request.getParameter("date"));
        mav.addObject("fhlx", request.getParameter("fhlx"));
        mav.setViewName("redirect:/toDi/tocpls");
        return mav;
    }

    /**
     * 进入公司员工管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/tocpls1")
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
            if (request.getParameter("t") != null && !request.getParameter("t").isEmpty()) {
                mav.addObject("t", request.getParameter("t"));
            }
            if (request.getParameter("l") != null && !request.getParameter("l").isEmpty()) {
                mav.addObject("l", request.getParameter("l"));
            }
            if (request.getParameter("m1") != null && !request.getParameter("m1").isEmpty()) {
                mav.addObject("m1", request.getParameter("m1"));
            }
           /* Integer ts=new Date(Integer.valueOf(sdf2.format(d)),d.getMonth()+1,0).getDate();
            List<time> list=new ArrayList<>();
            time t=new time();
            Calendar calendar = Calendar.getInstance();
            for(int i=0;i<ts;i++){
                t=new time();
                t.setD(new Date(Integer.valueOf(sdf2.format(d)),d.getMonth()+1,i+1));
                cdysb ysb=ysbService.selectBycpid1(DATE.format(t.getD()),null);;
                t.setZt(ysb==null);
                if(t.isZt()){
                    calendar.setTime(t.getD());
                    t.setUsdlist(usdService.serachBytime(getWeekDay1(calendar)));
                }
                list.add(t);
            }
            mav.addObject("list", list);*/
        }
        mav.setViewName("HTcpls1");
        return mav;
    }

    /**
     * 根据id获取菜品
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachcpls1",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachcpls1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Date d = DATE.parse(request.getParameter("date"));
        HashMap result = new HashMap();
        time t=new time();
        t.setD(d);
        cdysb ysb=ysbService.selectBycpid1(DATE.format(t.getD()),null);
        t.setZt(ysb==null);
        if(t.isZt()){
            ysb=ysbService.selectBycpid1(null,DATE.format(t.getD()));
            if(ysb==null){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(t.getD());
                List<cdusd> usdlist=usdService.serachBytime(getWeekDay1(calendar));
                List<cdusd> list=new ArrayList<>();
                for(cdusd usd:usdlist){
                    cdysb ysb1=ysbService.selectBygs4(DATE.format(t.getD()),usd.getUsd001());;
                    if(ysb1==null){
                        ysb1=ysbService.selectBygs5(DATE.format(t.getD()),"A",usd.getUsd001());;
                        if(ysb1==null)list.add(usd);
                    }
                }
                t.setTz(yscService.selectBytime(DATE.format(t.getD())));
                List<cdusd> list1=new ArrayList<>();
                list.stream().forEach(p -> {if (!list1.contains(p)) {list1.add(p);}}
                );
                t.setUsdlist(list1);
                t.setUsdlist(list1);
            }else{
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(ysb.getYsb003());
                List<cdusd> usdlist=usdService.serachBytime(getWeekDay1(calendar));
                List<cdusd> list=new ArrayList<>();
                for(cdusd usd:usdlist){
                    list.add(usd);
//                    cdysb ysb1=ysbService.selectBygs4(DATE.format(t.getD()),usd.getUsd001());;
//                    if(ysb1==null){
//                        ysb1=ysbService.selectBygs5(DATE.format(t.getD()),"A",usd.getUsd001());;
//                        if(ysb1==null)list.add(usd);
//                    }
                }
                calendar.setTime(t.getD());
                List<cdusd> usdlist1=usdService.serachBytime(getWeekDay1(calendar));
                for(cdusd usd:usdlist1){
                    cdysb ysb1=ysbService.selectBygs4(DATE.format(t.getD()),usd.getUsd001());;
                    if(ysb1==null){
                        ysb1=ysbService.selectBygs5(DATE.format(t.getD()),"A",usd.getUsd001());;
                        if(ysb1==null)list.add(usd);
                    }
                }
                List<cdusd> list1=new ArrayList<>();
                list.stream().forEach(p -> {if (!list1.contains(p)) {list1.add(p);}}
                );
                t.setUsdlist(list1);
            }

        }
        result.put("item",t);
        return JSON.toJSONString(result);
    }


    /**
     * 进入菜品管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/tocpls1cp")
    public ModelAndView tocpls1cp(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
//                String fpath = LoginController.class.getClass().getResource("/").getPath();
//                downloadLocal(fpath.substring(1,fpath.length())+"static/upload/cpls.xls", "菜品临时库存导入模板.xls",response, request);
                ExcelExport.ExcelexportXYQewm(request,response,usfService);
                return null;
            }
            PageBean pb = new PageBean();
            if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
            else
                pb.setCurrentPage(1);
            if (request.getParameter("date") != null && !request.getParameter("date").isEmpty()) {
                pb.setOthersql5(request.getParameter("date"));
            }
            if(request.getParameter("zt") != null && !request.getParameter("zt").isEmpty()){
                if(request.getParameter("zt").equals("U")){
                    addLog(getUse(request).getUse002(),"修改了菜品名字为：【" + request.getParameter("uname") + "】的团购类型");
                    if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
                        cdysc ysc =yscService.getByid(Integer.parseInt(request.getParameter("id")));
                        ysc.setYsc007(request.getParameter("type"));
                        yscService.update(ysc);
                    }else{
                        cdusf item =usfService.getByid(Integer.parseInt(request.getParameter("cpid")));
                        cdysc ysc=new cdysc();
                        ysc.setYsc002(item.getUsf001());
                        ysc.setYsc003(DATE.parse(pb.getOthersql5()));
//                        ysc.setYsc004(item.getUsf010());
                        ysc.setYsc006(0);
                        ysc.setYsc007(request.getParameter("type"));
                        yscService.insert(ysc);
                    }
                    mav.addObject("msg","C");
                }else if(request.getParameter("zt").equals("U1")){
                    addLog(getUse(request).getUse002(),"修改了菜品名字为：【" + request.getParameter("uname") + "】的团购类型");
                    if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
                        cdyha yha =yhaService.getByid(Integer.parseInt(request.getParameter("id")));
                        yha.setYha009(request.getParameter("type"));
                        yhaService.update(yha);
                    }else{
                        cdusf item =usfService.getByid(Integer.parseInt(request.getParameter("cpid")));
                        cdyha yha=new cdyha();
                        yha.setYha002(item.getUsf001());
                        yha.setYha003(Integer.valueOf(pb.getOthersql1()));
                        yha.setYha004(item.getUsf010()==null?0:item.getUsf010());
                        yha.setYha006(0);
                        yha.setYha009(request.getParameter("type"));
                        yhaService.insert(yha);
                    }
                    mav.addObject("msg","C");
                }else if(request.getParameter("zt").equals("A")){
                    addLog(getUse(request).getUse002(),"修改了菜品名字为：【" + request.getParameter("uname") + "】的库存数");
                    if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
                        cdysc ysc =yscService.getByid(Integer.parseInt(request.getParameter("id")));
                        ysc.setYsc006(Integer.valueOf(request.getParameter("num")));
                        yscService.update(ysc);
                    }else{
                        cdusf item =usfService.getByid(Integer.parseInt(request.getParameter("cpid")));
                        cdysc ysc=new cdysc();
                        ysc.setYsc002(item.getUsf001());
                        ysc.setYsc003(DATE.parse(pb.getOthersql5()));
                        ysc.setYsc005("B");
                        ysc.setYsc006(Integer.valueOf(request.getParameter("num")));
                        ysc.setYsc007(item.getUsf013().equals("C")?"B":"A");
                        yscService.insert(ysc);
                    }
                    mav.addObject("msg","C");
                }else if(request.getParameter("zt").equals("A1")){
                    addLog(getUse(request).getUse002(),"修改了菜品名字为：【" + request.getParameter("uname") + "】的库存数");
                    if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
                        cdyha yha =yhaService.getByid(Integer.parseInt(request.getParameter("id")));
                        yha.setYha004(Integer.valueOf(request.getParameter("num")));
                        yha.setYha005("C");
                        yhaService.update(yha);
                    }else{
                        cdusf item =usfService.getByid(Integer.parseInt(request.getParameter("cpid")));
                        cdyha yha=new cdyha();
                        yha.setYha002(item.getUsf001());
                        yha.setYha003(Integer.valueOf(pb.getOthersql1()));
                        yha.setYha004(Integer.valueOf(request.getParameter("num")));
                        yha.setYha005("C");
                        yha.setYha009(item.getUsf013().equals("C")?"B":"A");
                        yhaService.insert(yha);
                    }
                    mav.addObject("msg","C");
                }else  if(request.getParameter("zt").equals("D")){
                    addLog(getUse(request).getUse002(),"删除了配送日期为：【" + request.getParameter("uname") + "】的信息");
                    yscService.delete(Integer.valueOf(request.getParameter("id")));
                    mav.addObject("msg","D");
                }
            }
            if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                pb.setOthersql(request.getParameter("name"));
            }
            if (request.getParameter("lx") != null && !request.getParameter("lx").isEmpty()) {
                pb.setOthersql4(request.getParameter("lx"));
            }
            delsession(session,request.getParameter("fh"));
            pb.setOthersql10("C");
            pb=usfService.selectPageBean(pb);
            List<cdusf> list = pb.getResultList();
            if(pb.getOthersql4().equals("A")){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(DATE.parse(pb.getOthersql5()));
                for(cdusf usf:list){
                    usf.setYha(yhaService.selectByqscp(getWeekDay1(calendar),usf.getUsf001()));
                }
            }else{
                for(cdusf usf:list){
                    usf.setYsc(yscService.selectBycpid(usf.getUsf001(),pb.getOthersql5()));
                }
            }
            mav.addObject("pageobj", pb);
            mav.addObject("t", request.getParameter("t"));
            mav.addObject("l", request.getParameter("l"));
            mav.addObject("m1", request.getParameter("m1"));
        }
        mav.setViewName("HTcpls1cp");
        return mav;
    }
}
