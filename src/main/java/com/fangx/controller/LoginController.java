package com.fangx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fangx.model.*;
import com.fangx.until.EncrpytUtil;
import com.fangx.until.ExcelExport;
import com.fangx.until.OSSUtil;
import com.fangx.until.RSACoder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

@Controller
public class LoginController extends BaseController {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public LoginController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
    // private HttpServletResponse response;

    /**
     * 访问网站后台，检测用户session是否存在，不存在跳转到登陆页面
     *
     * @return
     */
    @RequestMapping(value = "*")
    public ModelAndView toLoginnew() throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (null == session.getAttribute("user")) {
            mav.addObject("error", request.getParameter("error"));
            session.setAttribute("dnumn", 0);
            mav.setViewName("HTlogin");
            return mav;
        }else{
            cduse use = useService.getByid(Decrypt(session.getAttribute("user").toString()));
            mav.setViewName("redirect:/toHt/toHTindex");
        }
        return mav;
    }


    /**
     * 访问网站后台，检测用户session是否存在，不存在跳转到登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/toLogin")
    public ModelAndView toLogin() throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (null == session.getAttribute("user")) {
            mav.addObject("error", request.getParameter("error"));
            session.setAttribute("dnumn", 0);
            mav.setViewName("HTlogin");
            return mav;
        }else{
            cduse use = useService.getByid(Decrypt(session.getAttribute("user").toString()));
                mav.setViewName("redirect:/toHt/toHTindex");
        }
        return mav;
    }

    @RequestMapping("/code.do")
    public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uname = req.getParameter("uname");
        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(120, 50, BufferedImage.TYPE_INT_RGB);
        Graphics gd = buffImg.getGraphics();
        // 创建一个随机数生成器类
        Random random = new Random();
        // 将图像填充为白色
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, 120, 50);
        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.BOLD, 38);
        // 设置字体。
        gd.setFont(font);
        // 画边框。
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, 120 - 1, 50 - 1);
        // 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
        gd.setColor(Color.BLACK);
        for (int i = 0; i < 40; i++) {
            int x = random.nextInt(120);
            int y = random.nextInt(50);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;
        HttpSession session = req.getSession();
        // 随机产生codeCount数字的验证码。
        String[] sp = null;


        for (int i = 0; i < 4; i++) {
            // 得到随机产生的验证码数字。
            String code = "";
            if (sp != null) code = sp[i];
            else code = String.valueOf(codeSequence[random.nextInt(codeSequence.length - 1)]);
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red, green, blue));
            gd.drawString(code, i == 0 ? 10 : (i + 1) * 20, 40);
            // 将产生的四个随机数组合在一起。
            randomCode.append(code);
        }
        // 将四位数字的验证码保存到Session中。
        PubMessage.dlmap.put(uname + "bcode", randomCode.toString());
        // session.setAttribute("code", randomCode.toString());
        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
    }

    /**
     * 校验登陆
     */
    @RequestMapping(value = "/checkLogin")
    public ModelAndView checkLogin() throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        String name = request.getParameter("username");
        String pwd = request.getParameter("userpwd");
        String ycode = request.getParameter("ycode");
        name = EncrpytUtil.decode(name);
        pwd = EncrpytUtil.decode(pwd);
        // System.out.println(name+"---"+pwd);
        boolean isok = true;
        request.getHeader("");
        //是否锁定账号
        if (PubMessage.dlmap.get(name + "dnumn") != null && Integer.parseInt(PubMessage.dlmap.get(name + "dnumn").toString()) >= 5) {
            if (PubMessage.dlmap.get(name) == null) {
                PubMessage.dlmap.put(name, sf.format(new Date()));
                mav.addObject("error", "您因多次登录失败，已被锁定。");
                isok = false;
                mav.setViewName("HTlogin");
            } else if (PubMessage.dlmap.get(name) != null) {
                //判断是否过期
                String dtaetime = PubMessage.dlmap.get(name).toString();
                Date d1 = new Date();
                Date d2 = sf.parse(dtaetime);
                if ((d2.getTime() + 600000) < d1.getTime()) {
                    isok = true;
                    PubMessage.dlmap.remove(name);
                    PubMessage.dlmap.put(name + "dnumn", 0);
                } else {
                    isok = false;
                    mav.setViewName("HTlogin");
                    session.setAttribute("dnumn", PubMessage.dlmap.get(name + "dnumn").toString());
                    mav.addObject("error", "您因多次登录失败，已被锁定。");
                }

            }
        }
        //  System.out.println(ycode+"----"+isok);
        // System.out.println(PubMessage.dlmap.get(name+"bcode").toString());
        if (isok) {
            if (PubMessage.dlmap.get(name + "bcode") == null) {
                mav.setViewName("HTlogin");
            }/*else if (!ycode.toUpperCase().equals(PubMessage.dlmap.get(name + "bcode").toString())) { //todo
                if (PubMessage.dlmap.get(name + "dnumn") == null) PubMessage.dlmap.put(name + "dnumn", 1);
                else
                    PubMessage.dlmap.put(name + "dnumn", Integer.parseInt(PubMessage.dlmap.get(name + "dnumn").toString()) + 1);

                if (Integer.parseInt(PubMessage.dlmap.get(name + "dnumn").toString()) >= 5) {
                    //保存一个时间
                    PubMessage.dlmap.put(name, sf.format(new Date()));
                }
                mav.addObject("error", "验证码错误");
                session.setAttribute("dnumn", PubMessage.dlmap.get(name + "dnumn").toString());
                mav.setViewName("HTlogin");
                isok = false;
            }else*/ if (null != name && !name.trim().isEmpty() && null != pwd && !pwd.trim().isEmpty()) {
                cduse use = useService.getLogin(name, EncrpytUtil.getSHA256(pwd));
                //System.out.println(EncrpytUtil.getSHA256(pwd)+"-----");
                if (null != use) {
                    // 会话失效
                    session.invalidate();
                    // 会话重建
                    PubMessage.dlmap.remove(name);
                    PubMessage.dlmap.remove(name + "dnumn");
                    PubMessage.dlmap.remove(name + "bcode");
                    session = request.getSession(true);
                    //用户id加密处理并保存
                    String inputStr = use.getUse001() + "";
                    byte[] encodedData = RSACoder.encryptByPublicKey(inputStr, EncrpytUtil.publicKey);
                    session.setAttribute("user", RSACoder.encryptBASE64(encodedData));
                    //用户信息
                    user user = new user();
                    user.setUname(use.getUse002());
                    cdusa usa = usaService.getByid(use.getUse008());
                    user.setJsqx(use.getUse002().equals("admin")?"admin":usa.getUsa004());
                    session.setAttribute("umsg", user);
                    mav.setViewName("redirect:/toHt/toHTindex");
                    addLog(use.getUse002(), "登录管理系统");
                    isok = true;
                } else {
                    if (PubMessage.dlmap.get(name + "dnumn") == null) PubMessage.dlmap.put(name + "dnumn", 1);
                    else
                        PubMessage.dlmap.put(name + "dnumn", Integer.parseInt(PubMessage.dlmap.get(name + "dnumn").toString()) + 1);

                    if (Integer.parseInt(PubMessage.dlmap.get(name + "dnumn").toString()) >= 5) {
                        //保存一个时间
                        PubMessage.dlmap.put(name, TIMEHOUR.format(new Date()));
                    }
                    session.setAttribute("dnumn", PubMessage.dlmap.get(name + "dnumn").toString());
                    session.setAttribute("uname", name);
                    mav.addObject("error", "用户名或密码错误");
                    mav.setViewName("HTlogin");
                    isok = false;
                }
            } else {
                mav.setViewName("HTlogin");
            }
            if (isok) {
                PubMessage.dlmap.remove(name + "bcode");
            }
        }
        return mav;
    }


    /**
     * 退出
     */
    @ResponseBody
    @RequestMapping(value = "/toHTtuichu")
    public ModelAndView toHTtuichu() throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("umsg");
        // 会话失效
        session.invalidate();
        // 会话重建
        session = request.getSession(true);
        mav.addObject("error", "退出成功");
        mav.setViewName("redirect:/toHt/toLogin");
        return mav;
    }

    @RequestMapping("/qhzh")
    public ModelAndView qhzh(String type) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("type", type);
        mav.setViewName("qhzh");
        return mav;
    }

    @RequestMapping("/grxx")
    public ModelAndView grxx() throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        cduse user = useService.getByid(Decrypt(session.getAttribute("user").toString()));
        mav.addObject("user", user);
        mav.setViewName("grxx");
        return mav;
    }

    /**
     * 切换账号登录
     */
    @ResponseBody
    @RequestMapping(value = "/tologin1")
    public ModelAndView tologin1() throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String name = request.getParameter("username");
        String pwd = request.getParameter("userpwd");

        name = EncrpytUtil.decode(name);
        pwd = EncrpytUtil.decode(pwd);
        cduse use = useService.getLogin(name, EncrpytUtil.getSHA256(pwd));

        Map map = new HashMap();
        if(null!=use){
            useService.update(use);
            // 会话失效
            session.invalidate();
            // 会话重建
            session=request.getSession(true);
            String inputStr = use.getUse001() + "";
            byte[] encodedData = RSACoder.encryptByPublicKey(inputStr, EncrpytUtil.publicKey);
            session.setAttribute("user", RSACoder.encryptBASE64(encodedData));
            //用户信息
            user user = new user();
            user.setUname(use.getUse002());
            cdusa usa = usaService.getByid(use.getUse008());
            user.setJsqx(use.getUse002().equals("admin")?"admin":usa.getUsa004());
            session.setAttribute("umsg", user);
                map.put("url", "/toHt/toHTindex");
            map.put("msg", "0");
        }else{
            map.put("msg", "用户名或密码错误");
        }
        response.getWriter().print(new JSONObject(map));
        return null;
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/updatePwd")
    public ModelAndView updatePwd() throws Exception {
        ModelAndView mav = new ModelAndView();
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        Map map = new HashMap();
        Integer userid = Decrypt(session.getAttribute("user").toString());
        cduse useNow =useService.getByid(userid);
        String jiumm = request.getParameter("jiumm");
        String xinmm = request.getParameter("xinmm");
        jiumm =  EncrpytUtil.decode(jiumm);
        xinmm = EncrpytUtil.decode(xinmm);
//        System.out.println(EncrpytUtil.getSHA256(jiumm));
        if(EncrpytUtil.getSHA256(jiumm).equals(useNow.getUse003())){
            try{
                useNow.setUse003(EncrpytUtil.getSHA256(xinmm));
                useService.update(useNow);
                session.setAttribute("user", useNow);
                map.put("msg", "0");

            }catch(Exception e){
                map.put("msg", "1");
                e.printStackTrace();
            }
            response.getWriter().print(new JSONObject(map));
        }else{
            map.put("msg", "4");
            response.getWriter().print(new JSONObject(map));
        }
        return null;
    }

    /**
     * 判断账户名称是否重复
     */
    @ResponseBody
    @RequestMapping(value = "/zhname",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public boolean zskname(HttpServletRequest request,HttpServletResponse response){
        Integer id=request.getParameter("id").isEmpty()?0:Integer.valueOf(request.getParameter("id"));
        cduse use=useService.selectByName(request.getParameter("name"));
        if((id==0 && use!=null)||(id!=0 && use!=null && id!=use.getUse001())){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 判断账户名称是否重复
     */
    @ResponseBody
    @RequestMapping(value = "/gsname",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public boolean gsname(HttpServletRequest request,HttpServletResponse response){
        Integer id=request.getParameter("id").isEmpty()?0:Integer.valueOf(request.getParameter("id"));
        cdusd item=usdService.selectByName(request.getParameter("name"));
        if((id==0 && item!=null)||(id!=0 && item!=null && id!=item.getUsd001())){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 判断账户名称是否重复
     */
    @ResponseBody
    @RequestMapping(value = "/dwname",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public boolean dwname(HttpServletRequest request,HttpServletResponse response){
        Integer id=request.getParameter("id").isEmpty()?0:Integer.valueOf(request.getParameter("id"));
        cdusm item=usmService.selectByName(request.getParameter("name"));
        if((id==0 && item!=null)||(id!=0 && item!=null && id!=item.getUsm001())){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 判断账户名称是否重复
     */
    @ResponseBody
    @RequestMapping(value = "/cpname",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public boolean cpname(HttpServletRequest request,HttpServletResponse response){
        Integer id=request.getParameter("id").isEmpty()?0:Integer.valueOf(request.getParameter("id"));
        cdusf item=usfService.selectByName(request.getParameter("name"));
        if((id==0 && item!=null)||(id!=0 && item!=null && id!=item.getUsf001())){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 判断账户名称是否重复
     */
    @ResponseBody
    @RequestMapping(value = "/cplsname",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public boolean cplsname(HttpServletRequest request,HttpServletResponse response){
        Integer id=request.getParameter("id").isEmpty()?0:Integer.valueOf(request.getParameter("id"));
        cdysc item=yscService.selectBycpid(Integer.valueOf(request.getParameter("cpid")),request.getParameter("name"));
        if((id==0 && item!=null)||(id!=0 && item!=null && id!=item.getYsc001())){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 判断账户名称是否重复
     */
    @ResponseBody
    @RequestMapping(value = "/pslsname",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public boolean pslsname(HttpServletRequest request,HttpServletResponse response){
        Integer id=request.getParameter("id").isEmpty()?0:Integer.valueOf(request.getParameter("id"));
        cdysb item=ysbService.selectBycpid(request.getParameter("name"),request.getParameter("name1"));
        if((id==0 && item!=null)||(id!=0 && item!=null && id!=item.getYsb001())){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 判断账户名称是否重复
     */
    @ResponseBody
    @RequestMapping(value = "/flname",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public boolean flname(HttpServletRequest request,HttpServletResponse response){
        String sjid=request.getParameter("sjid");
        Integer id=request.getParameter("id").isEmpty()?0:Integer.valueOf(request.getParameter("id"));
        if(sjid.isEmpty()){
            cdyhe item=yheService.selectByName(request.getParameter("name"));
            if((id==0 && item!=null)||(id!=0 && item!=null && id!=item.getYhe001())){
                return false;
            }else{
                return true;
            }
        }else{
            cdysa item=ysaService.selectByName(request.getParameter("name"));
            if((id==0 && item!=null)||(id!=0 && item!=null && id!=item.getYsa001())){
                return false;
            }else{
                return true;
            }
        }
    }

    /**
     * 判断账户名称是否重复
     */
    @ResponseBody
    @RequestMapping(value = "/qsname",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public boolean qsname(HttpServletRequest request,HttpServletResponse response){
        Integer id=request.getParameter("id").isEmpty()?0:Integer.valueOf(request.getParameter("id"));
        cdusb item=usbService.selectByName(request.getParameter("name").split("#")[1]);
        if((id==0 && item!=null)||(id!=0 && item!=null && id!=item.getUsb001())){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 判断账户名称是否重复
     */
    @ResponseBody
    @RequestMapping(value = "/tofllist",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String tofllist(HttpServletRequest request,HttpServletResponse response){
        Map<String, Object> result = new HashMap<String, Object>();
        Integer id=request.getParameter("id").isEmpty()?0:Integer.valueOf(request.getParameter("id"));
        List<cdysa> list=ysaService.selectBysjid(id);
        result.put("list", list);
        return JSON.toJSONString(result);
    }


    /**
     * 导入excel
     * 王新苗
     *  2023/04/26
     */
    @ResponseBody
    @RequestMapping(value = "/dryg")
    public String drls(HttpServletRequest request, HttpServletResponse response)throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("file1");
            InputStream in = file.getInputStream();
            Integer gsid=Integer.valueOf(request.getParameter("gsid"));
            String data=ExcelExport.getByExcelyg(in, file.getOriginalFilename(),usdService,uscService,uscService,yhdService,gsid);
            addLog(getUse(request).getUse002(),"导入了员工信息");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "B";
        }
    }

    /**
     * 导入excel
     * 王新苗
     *  2023/04/26
     */
    @ResponseBody
    @RequestMapping(value = "/drcp")
    public String drcp(HttpServletRequest request, HttpServletResponse response)throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("file1");
            InputStream in = file.getInputStream();
            String time=request.getParameter("time");
            String data=ExcelExport.getByExcelcp(in, file.getOriginalFilename(),usfService,yscService,time);
            addLog(getUse(request).getUse002(),"导入了员工信息");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "B";
        }
    }


    /**
     * 图片
     * 20223-04-28
     * 王新苗
     */
    @ResponseBody
    @RequestMapping(value = "/uploadAvatar",headers = "content-type=multipart/form-data")
    public String wx_addpic(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        // 图片
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件
        MultipartFile file = multipartRequest.getFile("file");
//        System.out.println(request.getParameter("openId"));
        String dz=request.getParameter("dz");
        String openId=request.getParameter("openId");
        String img=request.getParameter("img");
        String filename=(openId.isEmpty()?sdf1.format(new Date()):openId)+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        uploadpic(dz+filename, file,img);
        result.put("img", filename);
        result.put("msg", "Y");
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "upload")
    @ResponseBody
    public String upload(@RequestParam("imgFile") MultipartFile[] files, HttpServletRequest request) {
        JSONObject jb=new JSONObject();
        jb.put("error", 0);
        //文件保存目录路径
        String path = request.getSession().getServletContext().getRealPath("/");
        //定义允许上传的文件扩展名
        try {

            if (files!=null&&files.length>0) {
                for (MultipartFile file : files) {
                    String filename=sdf1.format(new Date())+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                    uploadpic("/fimg/"+filename, file, null);
                    jb.put("error", 0);
                    jb.put("message", "上传成功！");
                    jb.put("url", PubMessage.serverUrl+"/upload/fimg/"+filename);

//                    String imagename[] = OSSUtil.uploadObjectOSS(file,"B");
//                    jb.put("message", "上传成功！");
//                    jb.put("url", PubMessage.ossUrl+"/xqimg/"+imagename[1]);

                    return jb.toJSONString();
                }
            }
        } catch (Exception e1) {
            jb.put("error", 1);
            jb.put("message", e1.getMessage());
            return jb.toJSONString();
        }
        return jb.toJSONString();
    }
}
