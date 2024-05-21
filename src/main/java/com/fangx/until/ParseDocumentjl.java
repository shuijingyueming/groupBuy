package com.efx.quality.until;

import com.efx.quality.model.per;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ParseDocumentjl {
    Document doc = null;// 创建一个Document对象
    SimpleDateFormat TIMEMIAO = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat TIMEMIAO1 = new SimpleDateFormat("yyyy-MM-dd");

    SimpleDateFormat TIMEMIAO2 = new SimpleDateFormat("yyyy-MM");

    SimpleDateFormat year = new SimpleDateFormat("yyyy");
    SimpleDateFormat month = new SimpleDateFormat("MM");
    SimpleDateFormat da = new SimpleDateFormat("dd");
    public static void main(String[] args) throws ParseException {
        String url="D:\\111.xml";
        ParseDocumentjl xml = new ParseDocumentjl();
        xml.getDocument(url);
        per per=new per();
        per.setPer("13");//学生/党员
        per.setPro(2);//经验表
        per.setHdade(new Date());//获取日期
        per.setType1("3");//一级分类名
        per.setType2("4");//二级分类名-（三级及以下用-分割）
        per.setJname("经验名称");//经验名称
        per.setFz(6);//获得的经验值
        per.setJdid(7);//街道
        per.setP1("8");//街道
        per.setJgid(9);//学校/社区
        per.setP2("10");//学校/社区
        per.setNjid(11);//年级/网格
        per.setP3("12");//年级/网格
        per.setBjid(13);//班级/微网格
        per.setP4("14");//班级/微网格
        per.setWwg(14);//所属于班级/微网格
        per.setTid("15");//老师评价id
        per.setTname(16);//老师名称id
        per.setPcon("17");//老师评语
        per.setPar("18");//家长申请表
        per.setStime(new Date());//申请日期
        per.setScon("19");//申请理由
        per.setSname(20);//审核老师id
        per.setSdate(new Date());//审核日期
        per.setType("21");//家长自评/同学互评/学校周评
        per.setPname("22");//评论学生名称

        xml.creatNode(per);
//        List<per> list=xml.getPerlist();
//        list=ParseDocumentjl.ListSort(list);
//        xml.changeType("100002","10001");
//        xml.showInfo();
//        xml.deleteNode("100001");
        System.out.println(xml.getFz()+"-------");
        xml.showInfo();
        xml.saveXml(url);
    }

    /**
     * 显示xml文档信息 ！
     */
    public List<per> getPerlist() throws ParseException {
        List<per> list=new ArrayList();
        per per=new per();
        String name="";
        String day="";
        String text="";
        String id="";
        // 获取DOM树s节点
        NodeList peritem = doc.getElementsByTagName("per");
        for (int i = 0; i < peritem.getLength(); i++) {
            per=new per();
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            Element element = (Element) peritem.item(i);
            // 获取第i个per元素的id属性
            id= element.getAttribute("id");
            per.setPer(id);

            // 获得所有的子节点
            NodeList pers = element.getChildNodes();
            for (int j = 0; j < pers.getLength(); j++) {
                Node proNode = pers.item(j);
                // 判断是否是元素节点(使用getChildNodes()就要判断)
                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pro = (Element) proNode;
                    name=pro.getTagName();
                    if(name.equals("pro")){
                        id= pro.getAttribute("id");
                        day= pro.getAttribute("date");
                        per.setPro(Integer.valueOf(id));
                        per.setHdade(TIMEMIAO.parse(day));
                        NodeList pros = pro.getChildNodes();
                        for (int k = 0; k < pros.getLength(); k++) {
                            Node type = pros.item(k);
                            // 判断是否是元素节点(使用getChildNodes()就要判断)
                            if (type.getNodeType() == Node.ELEMENT_NODE) {
                                Element jyitem = (Element) type;
                                name=jyitem.getTagName();
                                if(name.equals("type1")){
                                    text= jyitem.getTextContent();
                                    per.setType1(text);
                                }else if(name.equals("type2")){
                                    text= jyitem.getTextContent();
                                    per.setType2(text);
                                }else if(name.equals("jname")){
                                    text= jyitem.getTextContent();
                                    per.setJname(text);
                                }else if(name.equals("fz")){
                                    text= jyitem.getTextContent();
                                    per.setFz(Integer.valueOf(text));
                                }else if(name.equals("p1")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setJdid(Integer.valueOf(id));
                                    per.setP1(text);
                                }else if(name.equals("p2")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setJgid(Integer.valueOf(id));
                                    per.setP2(text);
                                }else if(name.equals("p3")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setNjid(Integer.valueOf(id));
                                    per.setP3(text);
                                }else if(name.equals("p4")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setBjid(Integer.valueOf(id));
                                    per.setP4(text);
                                }else if(name.equals("jg")){
                                    text= jyitem.getTextContent();
                                    per.setJg(Integer.valueOf(text));
                                }else if(name.equals("wwg")){
                                    text= jyitem.getTextContent();
                                    per.setWwg(Integer.valueOf(text));
                                }else if(name.equals("tid")){
                                    text= jyitem.getTextContent();
                                    per.setTid(text);
                                }else if(name.equals("tname")){
                                    text= jyitem.getTextContent();
                                    per.setTname(Integer.valueOf(text));
                                }else if(name.equals("pcon")){
                                    text= jyitem.getTextContent();
                                    per.setPcon(text);
                                }else if(name.equals("par")){
                                    id= jyitem.getAttribute("id");
                                    per.setPar(id);
                                    NodeList pars = jyitem.getChildNodes();
                                    for (int l = 0; l < pars.getLength(); l++) {
                                        Node par = pars.item(l);
                                        // 判断是否是元素节点(使用getChildNodes()就要判断)
                                        if (par.getNodeType() == Node.ELEMENT_NODE) {
                                            Element jzitem = (Element) par;
                                            name=jzitem.getTagName();
                                            if (jzitem.getNodeType() == Node.ELEMENT_NODE) {
                                                if (name.equals("stime")) {
                                                    day = jzitem.getTextContent();
                                                    per.setStime(TIMEMIAO.parse(day));
                                                } else if (name.equals("scon")) {
                                                    text = jzitem.getTextContent();
                                                    per.setScon(text);
                                                } else if (name.equals("sname")) {
                                                    text = jzitem.getTextContent();
                                                    per.setSname(Integer.valueOf(text));
                                                } else if (name.equals("sdate")) {
                                                    day = jzitem.getTextContent();
                                                    per.setSdate(TIMEMIAO.parse(day));
                                                } else if (name.equals("type")) {
                                                    text = jzitem.getTextContent();
                                                    per.setType(text);
                                                } else if (name.equals("pname")) {
                                                    text = jzitem.getTextContent();
                                                    per.setPname(text);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            list.add(per);
        }
        return list;
    }

    /**
     * 显示xml文档信息 ！
     */
    public List<per> getPerlist1(String cselect1, String cselect2, Integer jgid) throws ParseException {
        List<per> list=new ArrayList();
        per per=new per();
        String name="";
        String day="";
        String text="";
        String id="";
        boolean flag=true;
        // 获取DOM树s节点
        NodeList peritem = doc.getElementsByTagName("per");
        for (int i = 0; i < peritem.getLength(); i++) {
            per=new per();
            flag=true;
                Element element = (Element) peritem.item(i);
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            // 获取第i个per元素的id属性
            id= element.getAttribute("id");
            per.setPer(id);
            // 获得所有的子节点
            NodeList pers = element.getChildNodes();
            for (int j = 0; j < pers.getLength(); j++) {
                Node proNode = pers.item(j);
                // 判断是否是元素节点(使用getChildNodes()就要判断)
                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pro = (Element) proNode;
                    name=pro.getTagName();
                    if(name.equals("pro")){
                        id= pro.getAttribute("id");
                        day= pro.getAttribute("date");
                        per.setPro(Integer.valueOf(id));
                        per.setHdade(TIMEMIAO.parse(day));
                        NodeList pros = pro.getChildNodes();
                        for (int k = 0; k < pros.getLength(); k++) {
                            Node type = pros.item(k);
                            // 判断是否是元素节点(使用getChildNodes()就要判断)
                            if (type.getNodeType() == Node.ELEMENT_NODE) {
                                Element jyitem = (Element) type;
                                name=jyitem.getTagName();
                                if(name.equals("type1")){
                                    text= jyitem.getTextContent();
                                    per.setType1(text);
                                }else if(name.equals("type2")){
                                    text= jyitem.getTextContent();
                                    per.setType2(text);
                                }else if(name.equals("jname")){
                                    text= jyitem.getTextContent();
                                    per.setJname(text);
                                }else if(name.equals("fz")){
                                    text= jyitem.getTextContent();
                                    per.setFz(Integer.valueOf(text));
                                }else if(name.equals("p1")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setJdid(Integer.valueOf(id));
                                    per.setP1(text);
                                }else if(name.equals("p2")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setJgid(Integer.valueOf(id));
                                    per.setP2(text);
                                }else if(name.equals("p3")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setNjid(Integer.valueOf(id));
                                    per.setP3(text);
                                }else if(name.equals("p4")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setBjid(Integer.valueOf(id));
                                    per.setP4(text);
                                }else if(name.equals("jg")){
                                    text= jyitem.getTextContent();
                                    per.setJg(Integer.valueOf(text));
                                }else if(name.equals("wwg")){
                                    text= jyitem.getTextContent();
                                    per.setWwg(Integer.valueOf(text));
                                }else if(name.equals("tid")){
                                    text= jyitem.getTextContent();
                                    per.setTid(text);
                                }else if(name.equals("tname")){
                                    text= jyitem.getTextContent();
                                    per.setTname(Integer.valueOf(text));
                                }else if(name.equals("pcon")){
                                    text= jyitem.getTextContent();
                                    per.setPcon(text);
                                }else if(name.equals("par")){
                                    id= jyitem.getAttribute("id");
                                    per.setPar(id);
                                    NodeList pars = jyitem.getChildNodes();
                                    for (int l = 0; l < pars.getLength(); l++) {
                                        Node par = pars.item(l);
                                        // 判断是否是元素节点(使用getChildNodes()就要判断)
                                        if (par.getNodeType() == Node.ELEMENT_NODE) {
                                            Element jzitem = (Element) par;
                                            name=jzitem.getTagName();
                                            if (jzitem.getNodeType() == Node.ELEMENT_NODE) {
                                                if (name.equals("stime")) {
                                                    day = jzitem.getTextContent();
                                                    per.setStime(TIMEMIAO.parse(day));
                                                } else if (name.equals("scon")) {
                                                    text = jzitem.getTextContent();
                                                    per.setScon(text);
                                                } else if (name.equals("sname")) {
                                                    text = jzitem.getTextContent();
                                                    per.setSname(Integer.valueOf(text));
                                                } else if (name.equals("sdate")) {
                                                    day = jzitem.getTextContent();
                                                    per.setSdate(TIMEMIAO.parse(day));
                                                } else if (name.equals("type")) {
                                                    text = jzitem.getTextContent();
                                                    per.setType(text);
                                                } else if (name.equals("pname")) {
                                                    text = jzitem.getTextContent();
                                                    per.setPname(text);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("-*-*"+per.getType());
//            System.out.println("cselect2"+cselect2);
            if(!cselect2.equals("0")&&per.getPro()!=Integer.valueOf(cselect2)){
                continue;
            }
//            System.out.println("cselect1"+cselect1);
            if(jgid!=null&&!cselect1.equals("0")){
                if(cselect1.equals("1")&&per.getJgid()!=Integer.valueOf(jgid)){
                    continue;
                }
                if(cselect1.equals("2")&&per.getJgid()==Integer.valueOf(jgid)){
                    continue;
                }
                System.out.println("tid"+per.getTid());
                if(cselect1.equals("3")&&per.getTid()==null){
                    continue;
                }
                if(cselect1.equals("4")&&(per.getType()==null||!per.getType().equals("A"))){
                    continue;
                }
                if(cselect1.equals("5")&&(per.getType()==null||!per.getType().equals("B"))){
                    continue;
                }
            }
//            System.out.println("flag"+flag);
            if(flag){
                list.add(per);
            }

        }
        return list;
    }

    public List<per> getPerlist2(List<String> ids, String yf, String sdid, String start, String end, String jdid, String jgid, String wgid, String wwgid) throws ParseException {
        List<per> list=new ArrayList();
        per per=new per();
        String name="";
        String day="";
        String text="";
        String id="";
        Date s=start!=null?TIMEMIAO.parse(start+" 00:00:00"):null;
        Date e=end!=null?TIMEMIAO.parse(end+" 23:59:59"):null;
        boolean flag=true;
        // 获取DOM树s节点
        NodeList peritem = doc.getElementsByTagName("per");
        for (int i = 0; i < peritem.getLength(); i++) {
            per=new per();
            flag=true;
            Element element = (Element) peritem.item(i);
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            // 获取第i个per元素的id属性
            id= element.getAttribute("id");
            per.setPer(id);
            // 获得所有的子节点
            NodeList pers = element.getChildNodes();
            for (int j = 0; j < pers.getLength(); j++) {
                Node proNode = pers.item(j);
                // 判断是否是元素节点(使用getChildNodes()就要判断)
                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pro = (Element) proNode;
                    name=pro.getTagName();
                    if(name.equals("pro")){
                        id= pro.getAttribute("id");
                        day= pro.getAttribute("date");
                        per.setPro(Integer.valueOf(id));
                        per.setHdade(TIMEMIAO.parse(day));
                        NodeList pros = pro.getChildNodes();
                        for (int k = 0; k < pros.getLength(); k++) {
                            Node type = pros.item(k);
                            // 判断是否是元素节点(使用getChildNodes()就要判断)
                            if (type.getNodeType() == Node.ELEMENT_NODE) {
                                Element jyitem = (Element) type;
                                name=jyitem.getTagName();
                                if(name.equals("type1")){
                                    text= jyitem.getTextContent();
                                    per.setType1(text);
                                }else if(name.equals("type2")){
                                    text= jyitem.getTextContent();
                                    per.setType2(text);
                                }else if(name.equals("jname")){
                                    text= jyitem.getTextContent();
                                    per.setJname(text);
                                }else if(name.equals("fz")){
                                    text= jyitem.getTextContent();
                                    per.setFz(Integer.valueOf(text));
                                }else if(name.equals("p1")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setJdid(Integer.valueOf(id));
                                    per.setP1(text);
                                }else if(name.equals("p2")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setJgid(Integer.valueOf(id));
                                    per.setP2(text);
                                }else if(name.equals("p3")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setNjid(Integer.valueOf(id));
                                    per.setP3(text);
                                }else if(name.equals("p4")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setBjid(Integer.valueOf(id));
                                    per.setP4(text);
                                }else if(name.equals("jg")){
                                    text= jyitem.getTextContent();
                                    per.setJg(Integer.valueOf(text));
                                }else if(name.equals("wwg")){
                                    text= jyitem.getTextContent();
                                    per.setWwg(Integer.valueOf(text));
                                }else if(name.equals("tid")){
                                    text= jyitem.getTextContent();
                                    per.setTid(text);
                                }else if(name.equals("tname")){
                                    text= jyitem.getTextContent();
                                    per.setTname(Integer.valueOf(text));
                                }else if(name.equals("pcon")){
                                    text= jyitem.getTextContent();
                                    per.setPcon(text);
                                }else if(name.equals("par")){
                                    id= jyitem.getAttribute("id");
                                    per.setPar(id);
                                    NodeList pars = jyitem.getChildNodes();
                                    for (int l = 0; l < pars.getLength(); l++) {
                                        Node par = pars.item(l);
                                        // 判断是否是元素节点(使用getChildNodes()就要判断)
                                        if (par.getNodeType() == Node.ELEMENT_NODE) {
                                            Element jzitem = (Element) par;
                                            name=jzitem.getTagName();
                                            if (jzitem.getNodeType() == Node.ELEMENT_NODE) {
                                                if (name.equals("stime")) {
                                                    day = jzitem.getTextContent();
                                                    per.setStime(TIMEMIAO.parse(day));
                                                } else if (name.equals("scon")) {
                                                    text = jzitem.getTextContent();
                                                    per.setScon(text);
                                                } else if (name.equals("sname")) {
                                                    text = jzitem.getTextContent();
                                                    per.setSname(Integer.valueOf(text));
                                                } else if (name.equals("sdate")) {
                                                    day = jzitem.getTextContent();
                                                    per.setSdate(TIMEMIAO.parse(day));
                                                } else if (name.equals("type")) {
                                                    text = jzitem.getTextContent();
                                                    per.setType(text);
                                                } else if (name.equals("pname")) {
                                                    text = jzitem.getTextContent();
                                                    per.setPname(text);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("-*-*"+per.getType());
            if(ids!=null&&!ids.contains(per.getPer())){
                continue;
            }
            if(sdid!=null&&per.getPro()!=Integer.valueOf(sdid)){
                continue;
            }
            if(jdid!=null&&per.getJdid()!=Integer.valueOf(jdid)){
                continue;
            }
            if(jgid!=null&&per.getJgid()!=Integer.valueOf(jgid)){
                continue;
            }
            if(wgid!=null&&per.getNjid()!=Integer.valueOf(wgid)){
                continue;
            }
            if(wwgid!=null&&per.getBjid()!=Integer.valueOf(wwgid)){
                continue;
            }
            if(s!=null&&per.getHdade().before(s)){
                continue;
            }
            if(e!=null&&per.getHdade().after(e)){
                continue;
            }
            if(yf!=null&&!TIMEMIAO2.format(per.getHdade()).equals(yf)){
                continue;
            }
//            System.out.println("flag"+flag);
            if(flag){
                list.add(per);
            }
        }
        return list;
    }

    public List<per> getPerlist4(List<String> ids, String yf, String sdid, List<Integer> wdlist, String start, String end, String jdid, String jgid, List<Integer> wwgids, String wwgid) throws ParseException {
        List<per> list=new ArrayList();
        per per=new per();
        String name="";
        String day="";
        String text="";
        String id="";
        Date s=start!=null?TIMEMIAO.parse(start+" 00:00:00"):null;
        Date e=end!=null?TIMEMIAO.parse(end+" 23:59:59"):null;
        boolean flag=true;
        // 获取DOM树s节点
        NodeList peritem = doc.getElementsByTagName("per");
        for (int i = 0; i < peritem.getLength(); i++) {
            per=new per();
            flag=true;
            Element element = (Element) peritem.item(i);
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            // 获取第i个per元素的id属性
            id= element.getAttribute("id");
            per.setPer(id);
            // 获得所有的子节点
            NodeList pers = element.getChildNodes();
            for (int j = 0; j < pers.getLength(); j++) {
                Node proNode = pers.item(j);
                // 判断是否是元素节点(使用getChildNodes()就要判断)
                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pro = (Element) proNode;
                    name=pro.getTagName();
                    if(name.equals("pro")){
                        id= pro.getAttribute("id");
                        day= pro.getAttribute("date");
                        per.setPro(Integer.valueOf(id));
                        per.setHdade(TIMEMIAO.parse(day));
                        NodeList pros = pro.getChildNodes();
                        for (int k = 0; k < pros.getLength(); k++) {
                            Node type = pros.item(k);
                            // 判断是否是元素节点(使用getChildNodes()就要判断)
                            if (type.getNodeType() == Node.ELEMENT_NODE) {
                                Element jyitem = (Element) type;
                                name=jyitem.getTagName();
                                if(name.equals("type1")){
                                    text= jyitem.getTextContent();
                                    per.setType1(text);
                                }else if(name.equals("type2")){
                                    text= jyitem.getTextContent();
                                    per.setType2(text);
                                }else if(name.equals("jname")){
                                    text= jyitem.getTextContent();
                                    per.setJname(text);
                                }else if(name.equals("fz")){
                                    text= jyitem.getTextContent();
                                    per.setFz(Integer.valueOf(text));
                                }else if(name.equals("p1")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setJdid(Integer.valueOf(id));
                                    per.setP1(text);
                                }else if(name.equals("p2")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setJgid(Integer.valueOf(id));
                                    per.setP2(text);
                                }else if(name.equals("p3")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setNjid(Integer.valueOf(id));
                                    per.setP3(text);
                                }else if(name.equals("p4")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setBjid(Integer.valueOf(id));
                                    per.setP4(text);
                                }else if(name.equals("jg")){
                                    text= jyitem.getTextContent();
                                    per.setJg(Integer.valueOf(text));
                                }else if(name.equals("wwg")){
                                    text= jyitem.getTextContent();
                                    per.setWwg(Integer.valueOf(text));
                                }else if(name.equals("tid")){
                                    text= jyitem.getTextContent();
                                    per.setTid(text);
                                }else if(name.equals("tname")){
                                    text= jyitem.getTextContent();
                                    per.setTname(Integer.valueOf(text));
                                }else if(name.equals("pcon")){
                                    text= jyitem.getTextContent();
                                    per.setPcon(text);
                                }else if(name.equals("par")){
                                    id= jyitem.getAttribute("id");
                                    per.setPar(id);
                                    NodeList pars = jyitem.getChildNodes();
                                    for (int l = 0; l < pars.getLength(); l++) {
                                        Node par = pars.item(l);
                                        // 判断是否是元素节点(使用getChildNodes()就要判断)
                                        if (par.getNodeType() == Node.ELEMENT_NODE) {
                                            Element jzitem = (Element) par;
                                            name=jzitem.getTagName();
                                            if (jzitem.getNodeType() == Node.ELEMENT_NODE) {
                                                if (name.equals("stime")) {
                                                    day = jzitem.getTextContent();
                                                    per.setStime(TIMEMIAO.parse(day));
                                                } else if (name.equals("scon")) {
                                                    text = jzitem.getTextContent();
                                                    per.setScon(text);
                                                } else if (name.equals("sname")) {
                                                    text = jzitem.getTextContent();
                                                    per.setSname(Integer.valueOf(text));
                                                } else if (name.equals("sdate")) {
                                                    day = jzitem.getTextContent();
                                                    per.setSdate(TIMEMIAO.parse(day));
                                                } else if (name.equals("type")) {
                                                    text = jzitem.getTextContent();
                                                    per.setType(text);
                                                } else if (name.equals("pname")) {
                                                    text = jzitem.getTextContent();
                                                    per.setPname(text);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("-*-*"+per.getType());
            if(ids!=null&&!ids.contains(per.getPer())){
                continue;
            }
            if(sdid!=null&&per.getPro()!=Integer.valueOf(sdid)){
                continue;
            }
            if(wdlist!=null&&!wdlist.contains(Integer.valueOf(per.getPro()))){
                continue;
            }
            /*if(jdid!=null&&per.getJdid()!=Integer.valueOf(jdid)){
                continue;
            }
            if(jgid!=null&&per.getJgid()!=Integer.valueOf(jgid)){
                continue;
            }
            if(wgid!=null&&per.getNjid()!=Integer.valueOf(wgid)){
                continue;
            }
            if(wwgid!=null&&per.getBjid()!=Integer.valueOf(wwgid)){
                continue;
            }*/
            if(jgid!=null&&per.getJgid()!=Integer.valueOf(jgid)){
                continue;
            }

            if(wwgid!=null&&per.getWwg()!=Integer.valueOf(wwgid)){
                continue;
            }else if(wwgids!=null&&!wwgids.contains(per.getWwg())){
                continue;
            }

            if(s!=null&&per.getHdade().before(s)){
                continue;
            }
            if(e!=null&&per.getHdade().after(e)){
                continue;
            }
            if(yf!=null&&!TIMEMIAO2.format(per.getHdade()).equals(yf)){
                continue;
            }
//            System.out.println("flag"+flag);
            if(flag){
                list.add(per);
            }
        }
        return list;
    }
    public List<per> getPerlist3(List<String> ids, String yf, String sdid, String start, String end, String jdid, String jgid, String wgid, String wwgid) throws ParseException {
        List<per> list=new ArrayList();
        per per=new per();
        String name="";
        String day="";
        String text="";
        String id="";
        Date s=start!=null?TIMEMIAO.parse(start+" 00:00:00"):null;
        Date e=end!=null?TIMEMIAO.parse(end+" 23:59:59"):null;
        boolean flag=true;
        // 获取DOM树s节点
        NodeList peritem = doc.getElementsByTagName("per");
        for (int i = 0; i < peritem.getLength(); i++) {
            per=new per();
            flag=true;
            Element element = (Element) peritem.item(i);
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            // 获取第i个per元素的id属性
            id= element.getAttribute("id");
            per.setPer(id);
            // 获得所有的子节点
            NodeList pers = element.getChildNodes();
            for (int j = 0; j < pers.getLength(); j++) {
                Node proNode = pers.item(j);
                // 判断是否是元素节点(使用getChildNodes()就要判断)
                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pro = (Element) proNode;
                    name=pro.getTagName();
                    if(name.equals("pro")){
                        id= pro.getAttribute("id");
                        day= pro.getAttribute("date");
                        per.setPro(Integer.valueOf(id));
                        per.setHdade(TIMEMIAO.parse(day));
                        NodeList pros = pro.getChildNodes();
                        for (int k = 0; k < pros.getLength(); k++) {
                            Node type = pros.item(k);
                            // 判断是否是元素节点(使用getChildNodes()就要判断)
                            if (type.getNodeType() == Node.ELEMENT_NODE) {
                                Element jyitem = (Element) type;
                                name=jyitem.getTagName();
                                if(name.equals("type1")){
                                    text= jyitem.getTextContent();
                                    per.setType1(text);
                                }else if(name.equals("type2")){
                                    text= jyitem.getTextContent();
                                    per.setType2(text);
                                }else if(name.equals("jname")){
                                    text= jyitem.getTextContent();
                                    per.setJname(text);
                                }else if(name.equals("fz")){
                                    text= jyitem.getTextContent();
                                    per.setFz(Integer.valueOf(text));
                                }else if(name.equals("p1")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setJdid(Integer.valueOf(id));
                                    per.setP1(text);
                                }else if(name.equals("p2")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setJgid(Integer.valueOf(id));
                                    per.setP2(text);
                                }else if(name.equals("p3")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setNjid(Integer.valueOf(id));
                                    per.setP3(text);
                                }else if(name.equals("p4")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    per.setBjid(Integer.valueOf(id));
                                    per.setP4(text);
                                }else if(name.equals("jg")){
                                    text= jyitem.getTextContent();
                                    per.setJg(Integer.valueOf(text));
                                }else if(name.equals("wwg")){
                                    text= jyitem.getTextContent();
                                    per.setWwg(Integer.valueOf(text));
                                }else if(name.equals("tid")){
                                    text= jyitem.getTextContent();
                                    per.setTid(text);
                                }else if(name.equals("tname")){
                                    text= jyitem.getTextContent();
                                    per.setTname(Integer.valueOf(text));
                                }else if(name.equals("pcon")){
                                    text= jyitem.getTextContent();
                                    per.setPcon(text);
                                }else if(name.equals("par")){
                                    id= jyitem.getAttribute("id");
                                    per.setPar(id);
                                    NodeList pars = jyitem.getChildNodes();
                                    for (int l = 0; l < pars.getLength(); l++) {
                                        Node par = pars.item(l);
                                        // 判断是否是元素节点(使用getChildNodes()就要判断)
                                        if (par.getNodeType() == Node.ELEMENT_NODE) {
                                            Element jzitem = (Element) par;
                                            name=jzitem.getTagName();
                                            if (jzitem.getNodeType() == Node.ELEMENT_NODE) {
                                                if (name.equals("stime")) {
                                                    day = jzitem.getTextContent();
                                                    per.setStime(TIMEMIAO.parse(day));
                                                } else if (name.equals("scon")) {
                                                    text = jzitem.getTextContent();
                                                    per.setScon(text);
                                                } else if (name.equals("sname")) {
                                                    text = jzitem.getTextContent();
                                                    per.setSname(Integer.valueOf(text));
                                                } else if (name.equals("sdate")) {
                                                    day = jzitem.getTextContent();
                                                    per.setSdate(TIMEMIAO.parse(day));
                                                } else if (name.equals("type")) {
                                                    text = jzitem.getTextContent();
                                                    per.setType(text);
                                                } else if (name.equals("pname")) {
                                                    text = jzitem.getTextContent();
                                                    per.setPname(text);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("-*-*"+per.getType());
            if(ids!=null&&!ids.contains(per.getPer())){
                continue;
            }
            if(sdid!=null&&per.getPro()!=Integer.valueOf(sdid)){
                continue;
            }

            if(wwgid!=null&&per.getBjid()!=Integer.valueOf(wwgid)){
                continue;
            }else if(wgid!=null&&per.getNjid()!=Integer.valueOf(wgid)){
                continue;
            }else if(jgid!=null&&per.getJgid()!=Integer.valueOf(jgid)){
                continue;
            }else if(jdid!=null&&per.getJdid()!=Integer.valueOf(jdid)){
                continue;
            }

            if(s!=null&&per.getHdade().before(s)){
                continue;
            }
            if(e!=null&&per.getHdade().after(e)){
                continue;
            }
            if(yf!=null&&!TIMEMIAO2.format(per.getHdade()).equals(yf)){
                continue;
            }
//            System.out.println("flag"+flag);
            if(flag){
                list.add(per);
            }
        }
        return list;
    }

    /**
     * 更改Brand属性
     *
     */
    public boolean getText(String name,String value){
        //获得节点信息
        NodeList brandElements = doc.getElementsByTagName(name);
        //遍历节点
        for (int i = 0; i < brandElements.getLength(); i++) {
            Node brands = brandElements.item(i);
            Element brand=(Element) brands;
            String text = brand.getTextContent();
            if(text.equals(value)){
                return true;
            }
        }
        return false;
    }

    /**
     * 获得DOM树
     *
     */
    public void getDocument(String url) {
        // 1、得到DOM工厂解析器工厂实例
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            // 2、从DOM工厂中获得Dom解析器
            DocumentBuilder db = factory.newDocumentBuilder();
            // 3、解析XML文件获得Document对象，即DOM树
            doc = db.parse(url);
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * 显示xml文档信息 ！
     */
    public void showInfo() {
        // 获取DOM树s节点
        NodeList sName = doc.getElementsByTagName("root");
        for (int i = 0; i < sName.getLength(); i++) {
            // 获取第i个s元素的信息（返回i元素）
            Node s = sName.item(i);
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            Element element = (Element) s;
            // 获取第i个s元素的name属性
            String sText= element.getTextContent();
            System.out.println("code：" + sText);
        }
    }

    /**
     * 新增节点
     *
     */
    public void creatNode(per per) {
        if(per.getPer()!=null){
            // 创建per节点
            Element element = doc.createElement("per");
            element.setAttribute("id",per.getPer());//学生/党员id
            if(per.getPro()!=null) {

                Element element1 = doc.createElement("pro");
                element1.setAttribute("id", per.getPro().toString());//经验表id
                element1.setAttribute("date", TIMEMIAO.format(per.getHdade()));//获取日期
                element.appendChild(element1);

                if(per.getType1()!=null) {
                    Element element2 = doc.createElement("type1");
                    element2.setTextContent(per.getType1());//一级分类名
                    element1.appendChild(element2);
                }
                if(per.getType2()!=null) {
                    Element element3 = doc.createElement("type2");
                    element3.setTextContent(per.getType2());//二级分类名-（三级及以下用-分割）
                    element1.appendChild(element3);
                }
                if(per.getJname()!=null) {
                    Element element4 = doc.createElement("jname");
                    element4.setTextContent(per.getJname());//经验名称
                    element1.appendChild(element4);
                }
                if(per.getFz()!=null) {
                    Element element5 = doc.createElement("fz");
                    element5.setTextContent(per.getFz().toString());//获得的经验值
                    element1.appendChild(element5);
                }
                if(per.getP1()!=null) {
                    Element element6 = doc.createElement("p1");
                    element6.setAttribute("id", per.getJdid().toString());
                    element6.setTextContent(per.getP1());//街道
                    element1.appendChild(element6);
                }
                if(per.getP2()!=null) {
                    Element element7 = doc.createElement("p2");
                    element7.setAttribute("id", per.getJgid().toString());
                    element7.setTextContent(per.getP2());//学校/社区
                    element1.appendChild(element7);
                }
                if(per.getP3()!=null) {
                    Element element8 = doc.createElement("p3");
                    element8.setAttribute("id", per.getNjid().toString());
                    element8.setTextContent(per.getP3());//年级/网格
                    element1.appendChild(element8);
                }
                if(per.getP4()!=null) {
                    Element element9 = doc.createElement("p4");
                    element9.setAttribute("id", per.getBjid().toString());
                    element9.setTextContent(per.getP4());//班级/微网格
                    element1.appendChild(element9);
                }
                if(per.getJg()!=null) {
                    Element element20 = doc.createElement("jg");
                    element20.setTextContent(per.getJg().toString());//班级/微网格
                    element1.appendChild(element20);
                }
                if(per.getWwg()!=null) {
                    Element element20 = doc.createElement("wwg");
                    element20.setTextContent(per.getWwg().toString());//班级/微网格
                    element1.appendChild(element20);
                }
                if(per.getTid()!=null) {
                    Element element10 = doc.createElement("tid");
                    element10.setTextContent(per.getTid());//老师评价id
                    element1.appendChild(element10);
                }
                if(per.getTname()!=null) {
                    Element element11 = doc.createElement("tname");
                    element11.setTextContent(per.getTname().toString());//老师名称id
                    element1.appendChild(element11);
                }

                if(per.getPcon()!=null){
                    Element element12 = doc.createElement("pcon");
                    element12.setTextContent(per.getPcon());//老师评语
                    element1.appendChild(element12);
                }

                if(per.getPar()!=null) {
                    Element element13 = doc.createElement("par");
                    element13.setAttribute("id", per.getPar());//家长申请表ID
                    element1.appendChild(element13);

                    if (per.getPname() != null) {
                        Element element14 = doc.createElement("stime");
                        element14.setTextContent(TIMEMIAO.format(per.getStime()));//申请日期
                        element13.appendChild(element14);
                    }

                    if (per.getScon() != null) {
                        Element element15 = doc.createElement("scon");
                        element15.setTextContent(per.getScon());//申请理由
                        element13.appendChild(element15);
                    }

                    if (per.getSname() != null) {
                        Element element16 = doc.createElement("sname");
                        element16.setTextContent(per.getSname().toString());//审核老师id
                        element13.appendChild(element16);
                    }

                    if (per.getSdate() != null) {
                        Element element17 = doc.createElement("sdate");
                        element17.setTextContent(TIMEMIAO.format(per.getSdate()));//审核日期
                        element13.appendChild(element17);
                    }

                    if (per.getType() != null) {
                        Element element18 = doc.createElement("type");
                        element18.setTextContent(per.getType());//家长自评/同学互评/学校周评
                        element13.appendChild(element18);
                    }

                    if (per.getPname() != null) {
                        Element element19 = doc.createElement("pname");
                        element19.setTextContent(per.getPname());//评论学生名称
                        element13.appendChild(element19);
                    }
                }
            }

            NodeList roots = doc.getElementsByTagName("root");
            for (int i = 0; i < roots.getLength(); i++) {
                Node root = roots.item(i);
                if (root.getNodeType() == Node.ELEMENT_NODE) {
                    // 把节点挂到root上
                    root.insertBefore(element,root.getFirstChild());
                }

            }
        }
    }

    /**
     * 保存xml文档
     *
     * @param path 保存的路径
     */
    public void saveXml(String path) {
        // 1、创建转换工厂
        TransformerFactory factory = TransformerFactory.newInstance();

        try {
            // 2、从工厂中获得转换器
//            Transformer Transformer = factory.newTransformer();
//            // 3、进行转换，如果直接转换可能出现乱码，需要进行格式设置
//            // 输出文件编码格式设置
//            Transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
//            // 需要DOM转换的源文件
//            DOMSource xmlSource = new DOMSource(doc);
//            // 指定目标路径
//            StreamResult outputTarget = new StreamResult(new FileOutputStream(
//                    path));
//            // 使用transform()进行保存xml文件
//            Transformer.transform(xmlSource, outputTarget);

            // 把构造的XML结构，写入到具体的文件中
            TransformerFactory formerFactory=TransformerFactory.newInstance();
            Transformer transformer=formerFactory.newTransformer();
            // 换行
            transformer.setOutputProperty(OutputKeys.INDENT, "YES");
            // 文档字符编码
            transformer.setOutputProperty(OutputKeys.ENCODING, "GB2312");//中文乱码

            // 可随意指定文件的后缀,效果一样,但xml比较好解析,比如: E:\\person.txt等
            transformer.transform(new DOMSource(doc), new StreamResult(path));
        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } /*catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

    }
    /**
     * 更改Brand属性
     *
     */
    public void changeType(String name,String value){
        //获得节点信息
        NodeList brandElements = doc.getElementsByTagName("s");
        //遍历节点
        for (int i = 0; i < brandElements.getLength(); i++) {
            Node brands = brandElements.item(i);
            Element brand=(Element) brands;
            String text = brand.getTextContent();
            if(text.equals(name)){
                doc.setTextContent(value);
            }
        }
    }
    /**
     * 删除指定节点
     * @param name 删除的Brand属性名
     */
    public void deleteNode(String name){
        NodeList brandsEle = doc.getElementsByTagName("per");
        for (int i = 0; i < brandsEle.getLength(); i++) {
            Element brand = (Element) brandsEle.item(i);
            String text = brand.getTextContent();
            if(text.equals(name)){
                doc.getElementsByTagName("root").item(0).removeChild(brand);
            }

        }
    }

    public Integer getFz() {
        Integer jf=0;
        NodeList peritem = doc.getElementsByTagName("fz");
        for (int i = 0; i < peritem.getLength(); i++) {
            Node fzs = peritem.item(i);
            Element fz = (Element) fzs;
            jf+= Integer.valueOf(fz.getTextContent());
        }
        return jf;
    }

    public Integer getWeek(List<String> list) throws ParseException {
        Integer jf=0;
        NodeList peritem = doc.getElementsByTagName("fz");
        for (int i = 0; i < peritem.getLength(); i++) {
            Node fzs = peritem.item(i);
            Element fz = (Element) fzs;
            if(list.contains(TIMEMIAO1.format(TIMEMIAO1.parse(((Element)fzs.getParentNode()).getAttribute("date"))))){
                jf+= Integer.valueOf(fz.getTextContent());
            }
        }
        return jf;
    }

    public Integer getDay(String d) {
        Integer jf=0;
        NodeList peritem = doc.getElementsByTagName("fz");
        for (int i = 0; i < peritem.getLength(); i++) {
            Node fzs = peritem.item(i);
            Element fz = (Element) fzs;
            if(((Element)fzs.getParentNode()).getAttribute("date").indexOf(d)>=0){
                jf+= Integer.valueOf(fz.getTextContent());
            }
        }
        return jf;
    }

    public Integer getWeeksd(List<String> list, Integer sdid) throws ParseException {
        Integer jf=0;
        NodeList peritem = doc.getElementsByTagName("fz");
        for (int i = 0; i < peritem.getLength(); i++) {
            Node fzs = peritem.item(i);
            Element fz = (Element) fzs;
            if(((Element)fzs.getParentNode()).getAttribute("id").equals(sdid.toString())&&
                    list.contains(TIMEMIAO1.format(TIMEMIAO1.parse(((Element)fzs.getParentNode()).getAttribute("date"))))){
                jf+= Integer.valueOf(fz.getTextContent());
            }
        }
        return jf;
    }

    public Integer getsd(Integer sdid) throws ParseException {
        Integer jf=0;
        NodeList peritem = doc.getElementsByTagName("fz");
        for (int i = 0; i < peritem.getLength(); i++) {
            Node fzs = peritem.item(i);
            Element fz = (Element) fzs;
            if(((Element)fzs.getParentNode()).getAttribute("id").equals(sdid.toString())){
                jf+= Integer.valueOf(fz.getTextContent());
            }
        }
        return jf;
    }

    public Integer getNum() {
        NodeList brandsEle = doc.getElementsByTagName("per");
        return brandsEle.getLength();
    }
}
