package com.fangx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fangx.model.*;
import com.fangx.pub.Datamsg;
import com.fangx.until.EncrpytUtil;
import com.fangx.wx.HttpGetUtil;
import com.fangx.wx.PayUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
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
import java.io.*;
import java.util.*;

@Controller
@RequestMapping("/toHt")
public class HTinfoController extends BaseController {

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private TemplateEngine templateEngine;

    @RequestMapping("/xhsgetticket")
    public ModelAndView xhsgetticket(HttpServletRequest request, HttpServletResponse resp) throws Exception {
        //获取商家CODE（ticket）码
        String code = request.getParameter("code");
        System.out.println("商家ticket:"+code);
        String timestamp = new Date().getTime()+"";
        String prm = "oauth.getAccessToken?appId=91d88fd22a0d442ea97a&timestamp="+timestamp+"&version=2.0";
        String sign =  DigestUtils.md5Hex(PayUtils.getContentBytes(prm+"e49ab65b111e00bcd00dccfd5db04f15", "utf-8"));   ;
        //组装
        Map<String, String> params = new HashMap<String, String>();
        params.put("appId","91d88fd22a0d442ea97a");
        params.put("version","2.0");
        params.put("sign",sign);
        params.put("timestamp",timestamp);
        params.put("method","oauth.getAccessToken");
        params.put("code",code);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("https://ark.xiaohongshu.com/ark/open_api/v3/common_controller"); // 接口
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        String body = JSON.toJSONString(params); // 必须是json模式的 post
        StringEntity entity = new StringEntity(body);
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println("小红书返回:"+result);
        net.sf.json.JSONObject obj = net.sf.json.JSONObject.fromObject(result);
        net.sf.json.JSONObject data = obj.getJSONObject("data");
        System.out.println("小红书返回access_token:"+data.getString("accessToken"));

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

    @RequestMapping("/toHTindex")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){
            SystemTZYM(response,"登录失效");
            return null;
        }
        mav.setViewName("index");
        return mav;
    }

    /**
     * 进入管理员管理页面
     * othersql:登录名  othersql1:真实姓名  othersql2:电话 othersql3:职位
     * @return 用户页面
     */
    @RequestMapping("/indexi")
    public ModelAndView indexi(HttpServletRequest request,HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        int userid = 0;//后台登录用户ID
        if(session.getAttribute("user")==null){
            SystemTZYM(response,"登录失效");
            return null;
        }else{
            cduse user = useService.getByid(Decrypt(session.getAttribute("user").toString()));

        }
        mav.setViewName("index_i");
        return mav;
    }

    /**
     * 进入管理员管理页面
     * othersql:登录名  othersql1:机构
     * @return 用户页面
     */
    @RequestMapping("/staff")
    public ModelAndView staff(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
            pb.setOthersql5(user.getUse006());//账户类型
            if(request.getParameter("zt") != null && !request.getParameter("zt").isEmpty()){
                if(request.getParameter("zt").equals("D")){
                    addLog(getUse(request).getUse002(),"删除了账户名字为：【" + request.getParameter("uname") + "】的信息");
                    cduse use =useService.getByid(Integer.parseInt(request.getParameter("id")));
                    useService.update(use);
                    mav.addObject("msg","D");
                }else if(request.getParameter("zt").equals("AD")){
                    addLog(getUse(request).getUse002(),"删除了账户信息");
                    useService.deleteById(request.getParameter("id"),pb);
                    mav.addObject("msg","D");
                }else if(request.getParameter("zt").equals("R")){
                    cduse use = useService.getByid(Integer.valueOf(request.getParameter("id")));
                    use.setUse003(EncrpytUtil.getSHA256("123456"));
                    useService.update(use);
                    addLog(getUse(request).getUse002(),"重置了名字为：【" + use.getUse002()+ "】的密码");
                    mav.addObject("msg","M");
                }
            }
            if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
            else
                pb.setCurrentPage(1);
            if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                pb.setOthersql(request.getParameter("name"));
            }
            if (request.getParameter("phone") != null && !request.getParameter("phone").isEmpty()) {
                pb.setOthersql6(request.getParameter("phone"));
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", useService.selectPageBean(pb));
            mav.addObject("usalist", usaService.serachAll());
        }
        mav.setViewName("staff");
        return mav;
    }

    /**
     * 修改后台用户信息
     * 王新苗
     */
    @ResponseBody
    @RequestMapping("/updateUseXx")
    public JSONObject updateUseXx(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        cduse user = useService.getByid(Decrypt(session.getAttribute("user").toString()));
        Map map = new HashMap();
        String log = "修改管理员信息:";
        if (user == null) {
            map.put("msg", "登录失效");
        }
        if (request.getParameter("truename") != null && StringUtils.isNotEmpty(request.getParameter("truename"))) {
            log += "真实姓名：【" + user.getUse005() + "】修改为【" + request.getParameter("truename") + "】";
            user.setUse005(request.getParameter("truename"));
        }
        if (request.getParameter("phone") != null && StringUtils.isNotEmpty(request.getParameter("phone"))) {
            log += "电话：【" + user.getUse007() + "】修改为【" + request.getParameter("phone") + "】";
            user.setUse007(request.getParameter("phone"));
        }
        boolean rows = useService.update(user);
        if (rows) {
            addLog(user.getUse002(), log);
            map.put("msg", "0");
            response.getWriter().print(new JSONObject(map));
        } else{
            map.put("msg", "1");
            response.getWriter().print(new JSONObject(map));
        }

        return null;
    }


    /**
     * 根据id获取用户
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachyh",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachyh(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        HashMap result = new HashMap();cduse use=useService.getByid(id);
        result.put("item",use);
        return JSON.toJSONString(result);
    }

    /**
     * 修改账户
     * 王新苗
     * @param request
     * @param response
     */
    @RequestMapping(value = "/xgzh")
    public ModelAndView xgzh(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        cduse use = new cduse();
        //修改
        use.setUse002(request.getParameter("t1"));
        use.setUse005(request.getParameter("t2"));
        use.setUse006(request.getParameter("t3"));
        use.setUse007(request.getParameter("t4"));
        if(!request.getParameter("t5").isEmpty())use.setUse008(Integer.valueOf(request.getParameter("t5")));
        if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
            String log = "修改了名字为：【" + request.getParameter("t1") + "】的用户信息";
            use.setUse001(Integer.valueOf((request.getParameter("id"))));
            addLog(getUse(request).getUse002(),log);
            useService.update(use);
            if(Decrypt(session.getAttribute("user").toString())==Integer.valueOf((request.getParameter("id")))){
                //用户信息
                user user = new user();
                user.setUname(use.getUse002());
                cdusa usa = usaService.getByid(use.getUse008());
                user.setJsqx(usa.getUsa004());
                session.setAttribute("umsg", user);
            }
            mav.addObject("msg", "U");
        }else{
            String log = "新增了名字为：【" + request.getParameter("t1")+ "】的用户信息";
            use.setUse003(EncrpytUtil.getSHA256("123456"));
            addLog(getUse(request).getUse002(),log);
            use = useService.insert(use);
            mav.addObject("msg", "I");
        }
        mav.addObject("pages", request.getParameter("pages"));
        mav.addObject("phone", request.getParameter("phone"));
        mav.addObject("name", request.getParameter("name"));
        mav.setViewName("redirect:/toHt/staff");
        return mav;
    }

    /**
     * 进入角色管理页面
     * 王新苗
     * @param request
     * @param response
     */
    @RequestMapping("/role")
    public ModelAndView role(HttpServletRequest request,HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        int userid = 0;//后台登录用户ID
        if(session.getAttribute("user")==null){
            SystemTZYM(response,"登录失效");
            return null;
        }else{
            userid = Decrypt(session.getAttribute("user").toString());
            cduse user = useService.getByid(Decrypt(session.getAttribute("user").toString()));
            mav.addObject("msg",request.getParameter("msg"));
            if(request.getParameter("zt") != null && !request.getParameter("zt").isEmpty()){
                if(request.getParameter("zt").equals("D")){
                    addLog(getUse(request).getUse002(),"删除了角色名字为：【" + request.getParameter("uname") + "】的信息");
                    usaService.deleteById(Integer.parseInt(request.getParameter("id")));
                    mav.addObject("msg","D");
                }else if(request.getParameter("zt").equals("AD")){
                    addLog(getUse(request).getUse002(),"批量删除了角色信息");
                    usaService.deleteById(request.getParameter("id"));
                    mav.addObject("msg","D");
                }
            }
            PageBean pb = new PageBean();
            if (request.getParameter("pages") != null && !request.getParameter("pages").isEmpty())
                pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
            else
                pb.setCurrentPage(1);
            if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                pb.setOthersql(request.getParameter("name"));
            }
            delsession(session,request.getParameter("fh"));
            mav.addObject("pageobj", usaService.selectPageBean(pb));
        }
        mav.setViewName("role");
        return mav;
    }

    /**
     * 根据id获取角色
     * 王新苗
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/serachjs",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String serachjs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        HashMap result = new HashMap();
        cdusa usa=usaService.getByid(id);
        result.put("item",usa);
        return JSON.toJSONString(result);
    }

    /**
     * 修改角色
     * 王新苗
     * @param request
     * @param response
     */
    @RequestMapping(value = "/xgjs")
    public ModelAndView xgjs(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        cdusa usa = new cdusa();
        usa.setUsa002(request.getParameter("t1"));
        String qx="";
        String[] qxs=request.getParameterValues("qx");
        if(qxs!=null){
            for (String f : qxs) {
                if(!f.isEmpty())qx+=f+"#";
            }
        }
        usa.setUsa004(qx);
        if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
            usa.setUsa001(Integer.valueOf(request.getParameter("id")));
            usaService.update(usa);
            addLog(getUse(request).getUse002(), "修改了名字为：【" + request.getParameter("jsname") + "】的角色信息");
            mav.addObject("msg","U");
        } else {
            usa = usaService.insert(usa);
            addLog(getUse(request).getUse002(),"新增了名字为：【" + request.getParameter("jsname") + "】的角色信息");
            mav.addObject("msg","I");
        }
        mav.addObject("pages", request.getParameter("pages"));
        mav.addObject("name", request.getParameter("name"));
        mav.setViewName("redirect:/toHt/role");
        return mav;
    }

    /**
     * 获取数据备份信息
     * 王新苗
     */
    @RequestMapping(value="/selsjbf")
    public ModelAndView selsjbf(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(null==session.getAttribute("user")){
            SystemTZYM(response,"登录失效");
            return null;
        }
        mav.addObject("xxz", xxzService.selGetAll());
        mav.addObject("msg", request.getParameter("msg"));
        delsession(session,request.getParameter("fh"));
        mav.setViewName("sjbf");
        return mav;
    }

    /**
     * 数据库自动备份
     * 王新苗
     */
    @RequestMapping("/xgbf")
    public ModelAndView xgbf(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(null==session.getAttribute("user")){
            SystemTZYM(response,"登录失效");
            return null;
        }
        cdxxzWithBLOBs xxz = new cdxxzWithBLOBs();
		/*xxz.setXxz010(request.getParameter("sjkname"));
		xxz.setXxz011(request.getParameter("dlname"));
		xxz.setXxz012(request.getParameter("dlmima"));
		xxz.setXxz015(request.getParameter("sjkdz"));*/
        if(null!=request.getParameter("bfts")&&!request.getParameter("bfts").isEmpty())
            xxz.setXxz014(Integer.valueOf(request.getParameter("bfts")));
        else
            xxz.setXxz014(1);
        if(null!=request.getParameter("sjbfid")&&!request.getParameter("sjbfid").isEmpty()){
            xxz.setXxz001(Integer.valueOf(request.getParameter("sjbfid")));
            xxzService.update(xxz);
            addLog(getUse(request).getUse002(),"对数据库备份时间进行了修改为"+request.getParameter("bfts"));
        }/*else{
            xxzService.insert(xxz);
            addLog(getUse(request).getUse002(),"对数据库备份进行了添加"+request.getParameter("bfts"));
        }*/
        PubMessage.setXxz(xxzService.selGetAll());
        Thread[] lstThreads = findAllThread();
        for (Thread thread : lstThreads) {
            if(thread.getName().equals("beifen")){
                thread.interrupt();
            }
        }
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
                        //按天算+早上2：00
                        Thread.sleep(((PubMessage.getXxz().getXxz014()-1)*86400000)+7200000+tomorrowzeroSeconds);
                        if (Datamsg.exportDatabaseTool(config.getJdbcurl(), config.getJdbcdk(),
                                config.getUsername(),config.getPassword(),
                                "c:\\backup\\","clz("+TIME_ORDER.format(new Date())+").sql",config.getDataname(),
                                this.getClass().getResource("/").getPath()+"\\")) {
                            System.out.println("数据库成功备份！！！");
                        } else {
                            System.out.println("数据库备份失败！！！");
                        }
                    } catch (InterruptedException e) { }
                }
            }
        }.start();
        mav.addObject("msg", "H");
        mav.setViewName("redirect:/toHt/selsjbf");
        return mav;

    }

    /**
     * 手动备份后并下载
     * 王新苗
     * 注意 mysqldump有没有放在quality/target/classes下
     */
    @RequestMapping("/backupdownload")
    public void backupdownload(HttpServletRequest request,HttpServletResponse response) throws Exception {
        Datamsg.beifenMysql(request, response,config,this.getClass().getResource("/").getPath()+"\\");
        addLog(getUse(request).getUse002(),"进行了数据库下载");
    }

    /**
     * 查询所有日志
     * 王新苗
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/log")
    public ModelAndView  log(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            SystemTZYM(response, "登录失效");
            return null;
        }
        PageBean pb = new PageBean();
        if (request.getParameter("zt") != null && StringUtils.isNotEmpty(request.getParameter("zt"))) {
            if(request.getParameter("zt").equals("AD")){
                logService.deleteById(request.getParameter("id"));
                addLog(getUse(request).getUse002(),"删除了日志信息");
                mav.addObject("msg","D");
            }
        }
        if (request.getParameter("pages") != null && StringUtils.isNotEmpty(request.getParameter("pages")))
            pb.setCurrentPage(Integer.valueOf(request.getParameter("pages")));
        else
            pb.setCurrentPage(1);
        /* 开始时间是否存在 */
        if (request.getParameter("start") != null && StringUtils.isNotEmpty(request.getParameter("start")))
            pb.setOthersql(request.getParameter("start"));
        else
            pb.setOthersql(DATE3.format(new Date())+" - "+DATE3.format(new Date()));
        /* 结束时间是否存在 */
        if (request.getParameter("end") != null && StringUtils.isNotEmpty(request.getParameter("end")))
            pb.setOthersql1(request.getParameter("end"));
		/* 操作类型是否存在
		if (request.getParameter("czleix") != null && StringUtils.isNotEmpty(request.getParameter("czleix")) && !request.getParameter("czleix").equals("all"))
			pb.setOthersql2(request.getParameter("czleix"));*/
        // 查询的用户名是否存在
        if (request.getParameter("name") != null && StringUtils.isNotEmpty(request.getParameter("name")))
            pb.setOthersql3(request.getParameter("name"));
        delsession(session,request.getParameter("fh"));
        mav.addObject("pageobj", logService.selectPageBean(pb));
        mav.setViewName("log");
        return mav;
    }


    /**
     * 网站信息
     * 王新苗
     */
    @RequestMapping(value="/wzxx")
    public ModelAndView towzxx(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(null==session.getAttribute("user")){
            SystemTZYM(response,"登录失效");
            return null;
        }
        mav.addObject("xxz", xxzService.selGetAll());
        mav.setViewName("wzxx");
        return mav;
    }

    /**
     * 网站信息新增/修改
     * 王新苗
     */
	@RequestMapping(value="/xgwz")
	public ModelAndView xgwz(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		if(null==session.getAttribute("user")){
				SystemTZYM(response,"登录失效");
				return null;
		}
		String jtp = null!=request.getParameter("jtp")&&!request.getParameter("jtp").isEmpty()?request.getParameter("jtp"):null;
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		Date date = new Date();
        cdxxzWithBLOBs xxz = new cdxxzWithBLOBs();
		MultipartFile file = multipartHttpServletRequest.getFile("up");
		if(null!=file.getOriginalFilename()&&!file.getOriginalFilename().isEmpty()){
			String filename = sdf.format(date)+"1"+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			xxz.setXxz006(filename);
			uploadpic("wzimg/"+filename,file,"wzimg/"+jtp);
		}
		xxz.setXxz007(request.getParameter("wzname"));
        xxz.setXxz008(request.getParameter("wzzt"));
        xxz.setXxz020(request.getParameter("cqsj"));
        xxz.setXxz021(request.getParameter("cqsl"));
        xxz.setXxz022(request.getParameter("cqtx"));
        if(null!=request.getParameter("sjbfid")&&!request.getParameter("sjbfid").isEmpty()){
			xxz.setXxz001(Integer.valueOf(request.getParameter("sjbfid")));
			xxzService.update(xxz);
			addLog(getUse(request).getUse002(),"对网站管理内容进行了修改");
		}
		PubMessage.setXxz( xxzService.selGetAll());
		ServletContext context = session.getServletContext();
		context.setAttribute("xxz", PubMessage.getXxz());
		mav.addObject("msg", "A");
		mav.setViewName("redirect:/toHt/wzxx");
		return mav;
	}

    /**
     * 网站信息
     * 王新苗
     */
    @RequestMapping(value="/rlsb")
    public ModelAndView torlsb(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(null==session.getAttribute("user")){
            SystemTZYM(response,"登录失效");
            return null;
        }
        mav.addObject("xxz", xxzService.selectByid(2));
        mav.setViewName("rlsb");
        return mav;
    }

    /**
     * 网站信息新增/修改
     * 王新苗
     */
    @RequestMapping(value="/xgrl")
    public ModelAndView xgrl(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(null==session.getAttribute("user")){
            SystemTZYM(response,"登录失效");
            return null;
        }
        cdxxzWithBLOBs xxz = new cdxxzWithBLOBs();
        xxz.setXxz003(request.getParameter("appid"));
        xxz.setXxz004(request.getParameter("sdkkey"));
        xxz.setXxz008(request.getParameter("zt"));
        if(null!=request.getParameter("sjbfid")&&!request.getParameter("sjbfid").isEmpty()){
            xxz.setXxz001(Integer.valueOf(request.getParameter("sjbfid")));
            xxzService.update(xxz);
            //首次需要激活


            addLog(getUse(request).getUse002(),"对人脸识别sdk密钥信息进行了修改");
        }
//        if(xxz.getXxz008().equals("Y")){
//            PubMessage.rlsbappid=request.getParameter("appid");
//            PubMessage.rlsbsdkkey=request.getParameter("sdkkey");
//        }
        ServletContext context = session.getServletContext();
        context.setAttribute("xxz", xxzService.selectByid(2));
        mav.addObject("msg", "A");
        mav.setViewName("redirect:/toHt/rlsb");
        return mav;
    }
}
