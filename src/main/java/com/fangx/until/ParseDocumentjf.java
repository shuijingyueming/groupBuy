package com.efx.quality.until;

import com.efx.quality.model.poi;
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


public class ParseDocumentjf {
    Document doc = null;// 创建一个Document对象
    SimpleDateFormat TIMEMIAO = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat TIMEMIAO1 = new SimpleDateFormat("yyyy-MM-dd");

    SimpleDateFormat TIMEMIAO2 = new SimpleDateFormat("yyyy-MM");

    SimpleDateFormat year = new SimpleDateFormat("yyyy");
    SimpleDateFormat month = new SimpleDateFormat("MM");
    SimpleDateFormat da = new SimpleDateFormat("dd");
    public static void main(String[] args) throws ParseException {
        String url="D:\\111.xml";
        ParseDocumentjf xml = new ParseDocumentjf();
        xml.getDocument(url);
        poi poi=new poi();
        poi.setId("0");//uuidi
        poi.setPoi("zzz");//学生/党员
        poi.setPro(2);//经验表
        poi.setHdade(new Date());//获取日期
        poi.setType1("3");//一级分类名
        poi.setType2("4");//二级分类名-（三级及以下用-分割）
        poi.setJname("活动名称");//活动名称
        poi.setFz(6);//获得的经验值
        poi.setJdid(7);//活动街道
        poi.setP1("8");//街道
        poi.setJgid(9);//学校/社区
        poi.setP2("10");//学校/社区
        poi.setNjid(11);//年级/网格
        poi.setP3("12");//年级/网格
        poi.setBjid(13);//班级/微网格
        poi.setP4("14");//班级/微网格
        poi.setJd(16);//所属于街道
        poi.setJg(41);//所属于社区
//        poi.setWg(14);//所属于网格
//        poi.setWwg(14);//所属于班级/微网格
        poi.setUid(69);//操作人id
//        xml.creatNode(poi);
        poi.setNote("111");
        poi.setLx("A");
        xml.changeNode(poi);
//        List<poi> list=xml.getpoilist();
//        list=ParseDocumentjl.ListSort(list);
//        xml.changeType("100002","10001");
//        xml.showInfo();
//        xml.deleteNode("100001");
//        System.out.println(xml.getId("0")+"-------");
//        xml.deleteId("0");
//        xml.showInfo();
        xml.saveXml(url);
    }

    /**
     * 显示xml文档信息 ！
     */
    public List<poi> getpoilist() throws ParseException {
        List<poi> list=new ArrayList();
        poi poi=new poi();
        String name="";
        String day="";
        String text="";
        String id="";
        String uid="";
        // 获取DOM树s节点
        NodeList poiitem = doc.getElementsByTagName("poi");
        for (int i = 0; i < poiitem.getLength(); i++) {
            poi=new poi();
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            Element element = (Element) poiitem.item(i);
            // 获取第i个poi元素的id属性
            id= element.getAttribute("id");
            uid= element.getAttribute("uid");
            poi.setPoi(id);
            poi.setId(uid);

            // 获得所有的子节点
            NodeList pois = element.getChildNodes();
            for (int j = 0; j < pois.getLength(); j++) {
                Node proNode = pois.item(j);
                // 判断是否是元素节点(使用getChildNodes()就要判断)
                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pro = (Element) proNode;
                    name=pro.getTagName();
                    if(name.equals("pro")){
                        id= pro.getAttribute("id");
                        day= pro.getAttribute("date");
                        poi.setPro(Integer.valueOf(id));
                        poi.setHdade(TIMEMIAO.parse(day));
                        NodeList pros = pro.getChildNodes();
                        for (int k = 0; k < pros.getLength(); k++) {
                            Node type = pros.item(k);
                            // 判断是否是元素节点(使用getChildNodes()就要判断)
                            if (type.getNodeType() == Node.ELEMENT_NODE) {
                                Element jyitem = (Element) type;
                                name=jyitem.getTagName();
                                if(name.equals("type1")){
                                    text= jyitem.getTextContent();
                                    poi.setType1(text);
                                }else if(name.equals("type2")){
                                    text= jyitem.getTextContent();
                                    poi.setType2(text);
                                }else if(name.equals("jname")){
                                    text= jyitem.getTextContent();
                                    poi.setJname(text);
                                }else if(name.equals("fz")){
                                    text= jyitem.getTextContent();
                                    poi.setFz(Integer.valueOf(text));
                                }else if(name.equals("p1")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setJdid(Integer.valueOf(id));
                                    poi.setP1(text);
                                }else if(name.equals("p2")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setJgid(Integer.valueOf(id));
                                    poi.setP2(text);
                                }else if(name.equals("p3")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setNjid(Integer.valueOf(id));
                                    poi.setP3(text);
                                }else if(name.equals("p4")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setBjid(Integer.valueOf(id));
                                    poi.setP4(text);
                                }else if(name.equals("jd")){
                                    text= jyitem.getTextContent();
                                    poi.setJd(Integer.valueOf(text));
                                }else if(name.equals("jg")){
                                    text= jyitem.getTextContent();
                                    poi.setJg(Integer.valueOf(text));
                                }else if(name.equals("wg")){
                                    text= jyitem.getTextContent();
                                    poi.setWg(Integer.valueOf(text));
                                }else if(name.equals("wwg")){
                                    text= jyitem.getTextContent();
                                    poi.setWwg(Integer.valueOf(text));
                                }else if(name.equals("uid")){
                                    text= jyitem.getTextContent();
                                    poi.setUid(Integer.valueOf(text));
                                }else if(name.equals("note")){
                                    text= jyitem.getTextContent();
                                    poi.setNote(text);
                                }else if(name.equals("lx")){
                                    text= jyitem.getTextContent();
                                    poi.setLx(text);
                                }
                            }
                        }
                    }
                }
            }
            list.add(poi);
        }
        return list;
    }

    /**
     * 显示xml文档信息 ！
     */
    public List<poi> getpoilist1(String cselect1, String cselect2, Integer jgid) throws ParseException {
        List<poi> list=new ArrayList();
        poi poi=new poi();
        String name="";
        String day="";
        String text="";
        String id="";
        String uid="";
        boolean flag=true;
        // 获取DOM树s节点
        NodeList poiitem = doc.getElementsByTagName("poi");
        for (int i = 0; i < poiitem.getLength(); i++) {
            poi=new poi();
            flag=true;
                Element element = (Element) poiitem.item(i);
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            // 获取第i个poi元素的id属性
            id= element.getAttribute("id");
            uid= element.getAttribute("uid");
            poi.setPoi(id);
            poi.setId(uid);
            // 获得所有的子节点
            NodeList pois = element.getChildNodes();
            for (int j = 0; j < pois.getLength(); j++) {
                Node proNode = pois.item(j);
                // 判断是否是元素节点(使用getChildNodes()就要判断)
                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pro = (Element) proNode;
                    name=pro.getTagName();
                    if(name.equals("pro")){
                        id= pro.getAttribute("id");
                        day= pro.getAttribute("date");
                        poi.setPro(Integer.valueOf(id));
                        poi.setHdade(TIMEMIAO.parse(day));
                        NodeList pros = pro.getChildNodes();
                        for (int k = 0; k < pros.getLength(); k++) {
                            Node type = pros.item(k);
                            // 判断是否是元素节点(使用getChildNodes()就要判断)
                            if (type.getNodeType() == Node.ELEMENT_NODE) {
                                Element jyitem = (Element) type;
                                name=jyitem.getTagName();
                                if(name.equals("type1")){
                                    text= jyitem.getTextContent();
                                    poi.setType1(text);
                                }else if(name.equals("type2")){
                                    text= jyitem.getTextContent();
                                    poi.setType2(text);
                                }else if(name.equals("jname")){
                                    text= jyitem.getTextContent();
                                    poi.setJname(text);
                                }else if(name.equals("fz")){
                                    text= jyitem.getTextContent();
                                    poi.setFz(Integer.valueOf(text));
                                }else if(name.equals("p1")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setJdid(Integer.valueOf(id));
                                    poi.setP1(text);
                                }else if(name.equals("p2")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setJgid(Integer.valueOf(id));
                                    poi.setP2(text);
                                }else if(name.equals("p3")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setNjid(Integer.valueOf(id));
                                    poi.setP3(text);
                                }else if(name.equals("p4")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setBjid(Integer.valueOf(id));
                                    poi.setP4(text);
                                }else if(name.equals("jd")){
                                    text= jyitem.getTextContent();
                                    poi.setJd(Integer.valueOf(text));
                                }else if(name.equals("jg")){
                                    text= jyitem.getTextContent();
                                    poi.setJg(Integer.valueOf(text));
                                }else if(name.equals("wg")){
                                    text= jyitem.getTextContent();
                                    poi.setWg(Integer.valueOf(text));
                                }else if(name.equals("wwg")){
                                    text= jyitem.getTextContent();
                                    poi.setWwg(Integer.valueOf(text));
                                }else if(name.equals("uid")){
                                    text= jyitem.getTextContent();
                                    poi.setUid(Integer.valueOf(text));
                                }else if(name.equals("note")){
                                    text= jyitem.getTextContent();
                                    poi.setNote(text);
                                }else if(name.equals("lx")){
                                    text= jyitem.getTextContent();
                                    poi.setLx(text);
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("-*-*"+poi.getType());
//            System.out.println("cselect2"+cselect2);
            if(!cselect2.equals("0")&&poi.getPro()!=Integer.valueOf(cselect2)){
                continue;
            }
//            System.out.println("cselect1"+cselect1);
            if(jgid!=null&&!cselect1.equals("0")){
                if(cselect1.equals("1")&&poi.getJgid()!=Integer.valueOf(jgid)){
                    continue;
                }
                if(cselect1.equals("2")&&poi.getJgid()==Integer.valueOf(jgid)){
                    continue;
                }
            }
//            System.out.println("flag"+flag);
            if(flag){
                list.add(poi);
            }

        }
        return list;
    }

    public List<poi> getpoilist2(List<String> ids, String yf, String sdid, String start, String end, String jdid, String jgid, String wgid, String wwgid) throws ParseException {
        List<poi> list=new ArrayList();
        poi poi=new poi();
        String name="";
        String day="";
        String text="";
        String id="";
        String uid="";
        Date s=start!=null?TIMEMIAO.parse(start+" 00:00:00"):null;
        Date e=end!=null?TIMEMIAO.parse(end+" 23:59:59"):null;
        boolean flag=true;
        // 获取DOM树s节点
        NodeList poiitem = doc.getElementsByTagName("poi");
        for (int i = 0; i < poiitem.getLength(); i++) {
            poi=new poi();
            flag=true;
            Element element = (Element) poiitem.item(i);
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            // 获取第i个poi元素的id属性
            id= element.getAttribute("id");
            uid= element.getAttribute("uid");
            poi.setPoi(id);
            poi.setId(uid);
            // 获得所有的子节点
            NodeList pois = element.getChildNodes();
            for (int j = 0; j < pois.getLength(); j++) {
                Node proNode = pois.item(j);
                // 判断是否是元素节点(使用getChildNodes()就要判断)
                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pro = (Element) proNode;
                    name=pro.getTagName();
                    if(name.equals("pro")){
                        id= pro.getAttribute("id");
                        day= pro.getAttribute("date");
                        poi.setPro(Integer.valueOf(id));
                        poi.setHdade(TIMEMIAO.parse(day));
                        NodeList pros = pro.getChildNodes();
                        for (int k = 0; k < pros.getLength(); k++) {
                            Node type = pros.item(k);
                            // 判断是否是元素节点(使用getChildNodes()就要判断)
                            if (type.getNodeType() == Node.ELEMENT_NODE) {
                                Element jyitem = (Element) type;
                                name=jyitem.getTagName();
                                if(name.equals("type1")){
                                    text= jyitem.getTextContent();
                                    poi.setType1(text);
                                }else if(name.equals("type2")){
                                    text= jyitem.getTextContent();
                                    poi.setType2(text);
                                }else if(name.equals("jname")){
                                    text= jyitem.getTextContent();
                                    poi.setJname(text);
                                }else if(name.equals("fz")){
                                    text= jyitem.getTextContent();
                                    poi.setFz(Integer.valueOf(text));
                                }else if(name.equals("p1")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setJdid(Integer.valueOf(id));
                                    poi.setP1(text);
                                }else if(name.equals("p2")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setJgid(Integer.valueOf(id));
                                    poi.setP2(text);
                                }else if(name.equals("p3")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setNjid(Integer.valueOf(id));
                                    poi.setP3(text);
                                }else if(name.equals("p4")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setBjid(Integer.valueOf(id));
                                    poi.setP4(text);
                                }else if(name.equals("jd")){
                                    text= jyitem.getTextContent();
                                    poi.setJd(Integer.valueOf(text));
                                }else if(name.equals("jg")){
                                    text= jyitem.getTextContent();
                                    poi.setJg(Integer.valueOf(text));
                                }else if(name.equals("wg")){
                                    text= jyitem.getTextContent();
                                    poi.setWg(Integer.valueOf(text));
                                }else if(name.equals("wwg")){
                                    text= jyitem.getTextContent();
                                    poi.setWwg(Integer.valueOf(text));
                                }else if(name.equals("uid")){
                                    text= jyitem.getTextContent();
                                    poi.setUid(Integer.valueOf(text));
                                }else if(name.equals("note")){
                                    text= jyitem.getTextContent();
                                    poi.setNote(text);
                                }else if(name.equals("lx")){
                                    text= jyitem.getTextContent();
                                    poi.setLx(text);
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("-*-*"+poi.getType());
            if(ids!=null&&!ids.contains(poi.getPoi())){
                continue;
            }
            if(sdid!=null&&poi.getPro()!=Integer.valueOf(sdid)){
                continue;
            }
            if(jdid!=null&&poi.getJdid()!=Integer.valueOf(jdid)){
                continue;
            }
            if(jgid!=null&&poi.getJgid()!=Integer.valueOf(jgid)){
                continue;
            }
            if(wgid!=null&&poi.getNjid()!=Integer.valueOf(wgid)){
                continue;
            }
            if(wwgid!=null&&poi.getBjid()!=Integer.valueOf(wwgid)){
                continue;
            }
            if(s!=null&&poi.getHdade().before(s)){
                continue;
            }
            if(e!=null&&poi.getHdade().after(e)){
                continue;
            }
            if(yf!=null&&!TIMEMIAO2.format(poi.getHdade()).equals(yf)){
                continue;
            }
//            System.out.println("flag"+flag);
            if(flag){
                list.add(poi);
            }
        }
        return list;
    }

    public List<poi> getpoilist4(List<String> ids, String yf, String sdid, List<Integer> wdlist, String start, String end, String jdid, String jgid, List<Integer> wwgids, String wwgid) throws ParseException {
        List<poi> list=new ArrayList();
        poi poi=new poi();
        String name="";
        String day="";
        String text="";
        String id="";
        String uid="";
        Date s=start!=null?TIMEMIAO.parse(start+" 00:00:00"):null;
        Date e=end!=null?TIMEMIAO.parse(end+" 23:59:59"):null;
        boolean flag=true;
        // 获取DOM树s节点
        NodeList poiitem = doc.getElementsByTagName("poi");
        for (int i = 0; i < poiitem.getLength(); i++) {
            poi=new poi();
            flag=true;
            Element element = (Element) poiitem.item(i);
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            // 获取第i个poi元素的id属性
            id= element.getAttribute("id");
            uid= element.getAttribute("uid");
            poi.setPoi(id);
            poi.setId(uid);
            // 获得所有的子节点
            NodeList pois = element.getChildNodes();
            for (int j = 0; j < pois.getLength(); j++) {
                Node proNode = pois.item(j);
                // 判断是否是元素节点(使用getChildNodes()就要判断)
                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pro = (Element) proNode;
                    name=pro.getTagName();
                    if(name.equals("pro")){
                        id= pro.getAttribute("id");
                        day= pro.getAttribute("date");
                        poi.setPro(Integer.valueOf(id));
                        poi.setHdade(TIMEMIAO.parse(day));
                        NodeList pros = pro.getChildNodes();
                        for (int k = 0; k < pros.getLength(); k++) {
                            Node type = pros.item(k);
                            // 判断是否是元素节点(使用getChildNodes()就要判断)
                            if (type.getNodeType() == Node.ELEMENT_NODE) {
                                Element jyitem = (Element) type;
                                name=jyitem.getTagName();
                                if(name.equals("type1")){
                                    text= jyitem.getTextContent();
                                    poi.setType1(text);
                                }else if(name.equals("type2")){
                                    text= jyitem.getTextContent();
                                    poi.setType2(text);
                                }else if(name.equals("jname")){
                                    text= jyitem.getTextContent();
                                    poi.setJname(text);
                                }else if(name.equals("fz")){
                                    text= jyitem.getTextContent();
                                    poi.setFz(Integer.valueOf(text));
                                }else if(name.equals("p1")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setJdid(Integer.valueOf(id));
                                    poi.setP1(text);
                                }else if(name.equals("p2")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setJgid(Integer.valueOf(id));
                                    poi.setP2(text);
                                }else if(name.equals("p3")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setNjid(Integer.valueOf(id));
                                    poi.setP3(text);
                                }else if(name.equals("p4")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setBjid(Integer.valueOf(id));
                                    poi.setP4(text);
                                }else if(name.equals("jd")){
                                    text= jyitem.getTextContent();
                                    poi.setJd(Integer.valueOf(text));
                                }else if(name.equals("jg")){
                                    text= jyitem.getTextContent();
                                    poi.setJg(Integer.valueOf(text));
                                }else if(name.equals("wg")){
                                    text= jyitem.getTextContent();
                                    poi.setWg(Integer.valueOf(text));
                                }else if(name.equals("wwg")){
                                    text= jyitem.getTextContent();
                                    poi.setWwg(Integer.valueOf(text));
                                }else if(name.equals("uid")){
                                    text= jyitem.getTextContent();
                                    poi.setUid(Integer.valueOf(text));
                                }else if(name.equals("note")){
                                    text= jyitem.getTextContent();
                                    poi.setNote(text);
                                }else if(name.equals("lx")){
                                    text= jyitem.getTextContent();
                                    poi.setLx(text);
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("-*-*"+poi.getType());
            if(ids!=null&&!ids.contains(poi.getPoi())){
                continue;
            }
            if(sdid!=null&&poi.getPro()!=Integer.valueOf(sdid)){
                continue;
            }
            if(wdlist!=null&&!wdlist.contains(Integer.valueOf(poi.getPro()))){
                continue;
            }
            /*if(jdid!=null&&poi.getJdid()!=Integer.valueOf(jdid)){
                continue;
            }
            if(jgid!=null&&poi.getJgid()!=Integer.valueOf(jgid)){
                continue;
            }
            if(wgid!=null&&poi.getNjid()!=Integer.valueOf(wgid)){
                continue;
            }
            if(wwgid!=null&&poi.getBjid()!=Integer.valueOf(wwgid)){
                continue;
            }*/
            if(jgid!=null&&poi.getJgid()!=Integer.valueOf(jgid)){
                continue;
            }

            if(wwgid!=null&&poi.getWwg()!=Integer.valueOf(wwgid)){
                continue;
            }else if(wwgids!=null&&!wwgids.contains(poi.getWwg())){
                continue;
            }

            if(s!=null&&poi.getHdade().before(s)){
                continue;
            }
            if(e!=null&&poi.getHdade().after(e)){
                continue;
            }
            if(yf!=null&&!TIMEMIAO2.format(poi.getHdade()).equals(yf)){
                continue;
            }
//            System.out.println("flag"+flag);
            if(flag){
                list.add(poi);
            }
        }
        return list;
    }
    public List<poi> getpoilist3(List<String> ids, String yf, String sdid, String start, String end, String jdid, String jgid, String wgid, String wwgid) throws ParseException {
        List<poi> list=new ArrayList();
        poi poi=new poi();
        String name="";
        String day="";
        String text="";
        String id="";
        String uid="";
        Date s=start!=null?TIMEMIAO.parse(start+" 00:00:00"):null;
        Date e=end!=null?TIMEMIAO.parse(end+" 23:59:59"):null;
        boolean flag=true;
        // 获取DOM树s节点
        NodeList poiitem = doc.getElementsByTagName("poi");
        for (int i = 0; i < poiitem.getLength(); i++) {
            poi=new poi();
            flag=true;
            Element element = (Element) poiitem.item(i);
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            // 获取第i个poi元素的id属性
            id= element.getAttribute("id");
            uid= element.getAttribute("uid");
            poi.setPoi(id);
            poi.setId(uid);
            // 获得所有的子节点
            NodeList pois = element.getChildNodes();
            for (int j = 0; j < pois.getLength(); j++) {
                Node proNode = pois.item(j);
                // 判断是否是元素节点(使用getChildNodes()就要判断)
                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pro = (Element) proNode;
                    name=pro.getTagName();
                    if(name.equals("pro")){
                        id= pro.getAttribute("id");
                        day= pro.getAttribute("date");
                        poi.setPro(Integer.valueOf(id));
                        poi.setHdade(TIMEMIAO.parse(day));
                        NodeList pros = pro.getChildNodes();
                        for (int k = 0; k < pros.getLength(); k++) {
                            Node type = pros.item(k);
                            // 判断是否是元素节点(使用getChildNodes()就要判断)
                            if (type.getNodeType() == Node.ELEMENT_NODE) {
                                Element jyitem = (Element) type;
                                name=jyitem.getTagName();
                                if(name.equals("type1")){
                                    text= jyitem.getTextContent();
                                    poi.setType1(text);
                                }else if(name.equals("type2")){
                                    text= jyitem.getTextContent();
                                    poi.setType2(text);
                                }else if(name.equals("jname")){
                                    text= jyitem.getTextContent();
                                    poi.setJname(text);
                                }else if(name.equals("fz")){
                                    text= jyitem.getTextContent();
                                    poi.setFz(Integer.valueOf(text));
                                }else if(name.equals("p1")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setJdid(Integer.valueOf(id));
                                    poi.setP1(text);
                                }else if(name.equals("p2")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setJgid(Integer.valueOf(id));
                                    poi.setP2(text);
                                }else if(name.equals("p3")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setNjid(Integer.valueOf(id));
                                    poi.setP3(text);
                                }else if(name.equals("p4")){
                                    id= jyitem.getAttribute("id");
                                    text= jyitem.getTextContent();
                                    poi.setBjid(Integer.valueOf(id));
                                    poi.setP4(text);
                                }else if(name.equals("jd")){
                                    text= jyitem.getTextContent();
                                    poi.setJd(Integer.valueOf(text));
                                }else if(name.equals("jg")){
                                    text= jyitem.getTextContent();
                                    poi.setJg(Integer.valueOf(text));
                                }else if(name.equals("wg")){
                                    text= jyitem.getTextContent();
                                    poi.setWg(Integer.valueOf(text));
                                }else if(name.equals("wwg")){
                                    text= jyitem.getTextContent();
                                    poi.setWwg(Integer.valueOf(text));
                                }else if(name.equals("uid")){
                                    text= jyitem.getTextContent();
                                    poi.setUid(Integer.valueOf(text));
                                }else if(name.equals("note")){
                                    text= jyitem.getTextContent();
                                    poi.setNote(text);
                                }else if(name.equals("lx")){
                                    text= jyitem.getTextContent();
                                    poi.setLx(text);
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("-*-*"+poi.getType());
            if(ids!=null&&!ids.contains(poi.getPoi())){
                continue;
            }
            if(sdid!=null&&poi.getPro()!=Integer.valueOf(sdid)){
                continue;
            }

            if(wwgid!=null&&poi.getBjid()!=Integer.valueOf(wwgid)){
                continue;
            }else if(wgid!=null&&poi.getNjid()!=Integer.valueOf(wgid)){
                continue;
            }else if(jgid!=null&&poi.getJgid()!=Integer.valueOf(jgid)){
                continue;
            }else if(jdid!=null&&poi.getJdid()!=Integer.valueOf(jdid)){
                continue;
            }

            if(s!=null&&poi.getHdade().before(s)){
                continue;
            }
            if(e!=null&&poi.getHdade().after(e)){
                continue;
            }
            if(yf!=null&&!TIMEMIAO2.format(poi.getHdade()).equals(yf)){
                continue;
            }
//            System.out.println("flag"+flag);
            if(flag){
                list.add(poi);
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
    public void creatNode(poi poi) {
        if(poi.getPoi()!=null){
            // 创建poi节点
            Element element = doc.createElement("poi");
            element.setAttribute("id",poi.getPoi());//学生/党员id
            element.setAttribute("uid", poi.getId());
            if(poi.getPro()!=null) {

                Element element1 = doc.createElement("pro");
                element1.setAttribute("id", poi.getPro().toString());//经验表id

                element1.setAttribute("date", TIMEMIAO.format(poi.getHdade()));//获取日期
                element.appendChild(element1);

                if(poi.getType1()!=null) {
                    Element element2 = doc.createElement("type1");
                    element2.setTextContent(poi.getType1());//一级分类名
                    element1.appendChild(element2);
                }
                if(poi.getType2()!=null) {
                    Element element3 = doc.createElement("type2");
                    element3.setTextContent(poi.getType2());//二级分类名-（三级及以下用-分割）
                    element1.appendChild(element3);
                }
                if(poi.getJname()!=null) {
                    Element element4 = doc.createElement("jname");
                    element4.setTextContent(poi.getJname());//经验名称
                    element1.appendChild(element4);
                }
                if(poi.getFz()!=null) {
                    Element element5 = doc.createElement("fz");
                    element5.setTextContent(poi.getFz().toString());//获得的经验值
                    element1.appendChild(element5);
                }
                if(poi.getP1()!=null) {
                    Element element6 = doc.createElement("p1");
                    element6.setAttribute("id", poi.getJdid().toString());
                    element6.setTextContent(poi.getP1());//街道
                    element1.appendChild(element6);
                }
                if(poi.getP2()!=null) {
                    Element element7 = doc.createElement("p2");
                    element7.setAttribute("id", poi.getJgid().toString());
                    element7.setTextContent(poi.getP2());//学校/社区
                    element1.appendChild(element7);
                }
                if(poi.getP3()!=null) {
                    Element element8 = doc.createElement("p3");
                    element8.setAttribute("id", poi.getNjid().toString());
                    element8.setTextContent(poi.getP3());//年级/网格
                    element1.appendChild(element8);
                }
                if(poi.getP4()!=null) {
                    Element element9 = doc.createElement("p4");
                    element9.setAttribute("id", poi.getBjid().toString());
                    element9.setTextContent(poi.getP4());//班级/微网格
                    element1.appendChild(element9);
                }
                if(poi.getJd()!=null) {
                    Element element10 = doc.createElement("jd");
                    element10.setTextContent(poi.getJd().toString());
                    element1.appendChild(element10);
                }
                if(poi.getJg()!=null) {
                    Element element11 = doc.createElement("jg");
                    element11.setTextContent(poi.getJg().toString());
                    element1.appendChild(element11);
                }
                if(poi.getWg()!=null) {
                    Element element12 = doc.createElement("wg");
                    element12.setTextContent(poi.getWg().toString());
                    element1.appendChild(element12);
                }
                if(poi.getWwg()!=null) {
                    Element element13 = doc.createElement("wwg");
                    element13.setTextContent(poi.getWwg().toString());//班级/微网格
                    element1.appendChild(element13);
                }
                if(poi.getUid()!=null) {
                    Element element14 = doc.createElement("uid");
                    element14.setTextContent(poi.getUid().toString());
                    element1.appendChild(element14);
                }
                if(poi.getNote()!=null) {
                    Element element15 = doc.createElement("note");
                    element15.setTextContent(poi.getNote());
                    element1.appendChild(element15);
                }
                if(poi.getLx()!=null) {
                    Element element15 = doc.createElement("lx");
                    element15.setTextContent(poi.getLx());
                    element1.appendChild(element15);
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
     * 更改Brand属性
     *
     */
    public boolean changeNode(poi poi){
        if(poi.getId()!=null) {
            NodeList poiitem = doc.getElementsByTagName("poi");
            for (int i = 0; i < poiitem.getLength(); i++) {
                // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
                Element element = (Element) poiitem.item(i);
                // 获取第i个poi元素的id属性
                if(poi.getId().equals(element.getAttribute("uid"))){
                    element.setAttribute("id",poi.getPoi());//学生/党员id
                    element.setAttribute("uid", poi.getId());
                    if(poi.getPro()!=null) {
                        NodeList perlist=element.getElementsByTagName("pro");
                        for (int j = 0; j < perlist.getLength(); j++) {
                            Element element1 = (Element) perlist.item(j);
                            element1.setAttribute("id", poi.getPro().toString());//经验表id
                            element1.setAttribute("date", TIMEMIAO.format(poi.getHdade()));//获取日期
                            NodeList prolist=element1.getElementsByTagName("type1");
                            if (poi.getType1() != null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element2 = (Element) prolist.item(k);
                                        element2.setTextContent(poi.getType1());//一级分类名
                                    }
                                }else{
                                    Element element2 = doc.createElement("type1");
                                    element2.setTextContent(poi.getType1());//一级分类名
                                    element1.appendChild(element2);
                                }
                            }
                            prolist=element1.getElementsByTagName("type2");
                            if(poi.getType2()!=null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element3 = (Element) prolist.item(k);
                                        element3.setTextContent(poi.getType2());//二级分类名-（三级及以下用-分割）
                                    }
                                }else{
                                    Element element3 = doc.createElement("type2");
                                    element3.setTextContent(poi.getType2());//二级分类名-（三级及以下用-分割）
                                    element1.appendChild(element3);
                                }
                            }
                            prolist=element1.getElementsByTagName("jname");
                            if(poi.getJname()!=null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element4 = (Element) prolist.item(k);
                                        element4.setTextContent(poi.getJname());//经验名称
                                    }
                                }else{
                                    Element element4 = doc.createElement("jname");
                                    element4.setTextContent(poi.getJname());//经验名称
                                    element1.appendChild(element4);
                                }
                            }
                            prolist=element1.getElementsByTagName("fz");
                            if(poi.getFz()!=null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element5 = (Element) prolist.item(k);
                                        element5.setTextContent(poi.getFz().toString());//获得的经验值
                                    }
                                }else{
                                    Element element5 = doc.createElement("fz");
                                    element5.setTextContent(poi.getFz().toString());//获得的经验值
                                    element1.appendChild(element5);
                                }
                            }
                            prolist=element1.getElementsByTagName("p1");
                            if(poi.getP1()!=null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element6 =(Element) prolist.item(k);
                                        element6.setAttribute("id", poi.getJdid().toString());
                                        element6.setTextContent(poi.getP1());//街道
                                    }
                                }else{
                                    Element element6 = doc.createElement("p1");
                                    element6.setAttribute("id", poi.getJdid().toString());
                                    element6.setTextContent(poi.getP1());//街道
                                    element1.appendChild(element6);
                                }
                            }
                            prolist=element1.getElementsByTagName("p2");
                            if(poi.getP2()!=null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element7 = (Element) prolist.item(k);
                                        element7.setAttribute("id", poi.getJgid().toString());
                                        element7.setTextContent(poi.getP2());//学校/社区
                                    }
                                }else{
                                    Element element7 = doc.createElement("p2");
                                    element7.setAttribute("id", poi.getJgid().toString());
                                    element7.setTextContent(poi.getP2());//学校/社区
                                    element1.appendChild(element7);
                                }
                            }
                            prolist=element1.getElementsByTagName("p3");
                            if(poi.getP3()!=null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element8 = (Element) prolist.item(k);
                                        element8.setAttribute("id", poi.getNjid().toString());
                                        element8.setTextContent(poi.getP3());//年级/网格
                                    }
                                }else{
                                    Element element8 = doc.createElement("p3");
                                    element8.setAttribute("id", poi.getNjid().toString());
                                    element8.setTextContent(poi.getP3());//年级/网格
                                    element1.appendChild(element8);
                                }
                            }
                            prolist=element1.getElementsByTagName("p4");
                            if(poi.getP4()!=null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element9 = (Element) prolist.item(k);
                                        element9.setAttribute("id", poi.getBjid().toString());
                                        element9.setTextContent(poi.getP4());//班级/微网格
                                    }
                                }else{
                                    Element element9 = doc.createElement("p4");
                                    element9.setAttribute("id", poi.getBjid().toString());
                                    element9.setTextContent(poi.getP4());//班级/微网格
                                    element1.appendChild(element9);
                                }
                            }
                            prolist=element1.getElementsByTagName("jd");
                            if(poi.getJd()!=null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element10 = (Element) prolist.item(k);
                                        element10.setTextContent(poi.getJd().toString());
                                    }
                                }else{
                                    Element element10 = doc.createElement("jd");
                                    element10.setTextContent(poi.getJd().toString());
                                    element1.appendChild(element10);
                                }
                            }
                            prolist=element1.getElementsByTagName("jg");
                            if(poi.getJg()!=null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element11 = (Element) prolist.item(k);
                                        element11.setTextContent(poi.getJg().toString());
                                    }
                                }else{
                                    Element element11 = doc.createElement("jg");
                                    element11.setTextContent(poi.getJg().toString());
                                    element1.appendChild(element11);
                                }
                            }
                            prolist=element1.getElementsByTagName("wg");
                            if(poi.getWg()!=null) {
                                if(prolist.getLength()>0){

                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element12 = (Element) prolist.item(k);
                                        element12.setTextContent(poi.getWg().toString());
                                    }
                                }else{
                                    Element element12 = doc.createElement("wg");
                                    element12.setTextContent(poi.getWg().toString());
                                    element1.appendChild(element12);
                                }
                            }
                            prolist=element1.getElementsByTagName("wwg");
                            if(poi.getWwg()!=null) {
                                if(prolist.getLength()>0){

                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element13 = (Element) prolist.item(k);
                                        element13.setTextContent(poi.getWwg().toString());//班级/微网格
                                    }
                                }else{
                                    Element element13 = doc.createElement("wwg");
                                    element13.setTextContent(poi.getWwg().toString());//班级/微网格
                                    element1.appendChild(element13);
                                }
                            }
                            prolist=element1.getElementsByTagName("uid");
                            if(poi.getUid()!=null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element14 = (Element) prolist.item(k);
                                        element14.setTextContent(poi.getUid().toString());
                                    }
                                }else{
                                    Element element14 = doc.createElement("uid");
                                    element14.setTextContent(poi.getUid().toString());
                                    element1.appendChild(element14);
                                }
                            }
                            prolist=element1.getElementsByTagName("note");
                            if(poi.getNote()!=null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element15 = (Element) prolist.item(k);
                                        element15.setTextContent(poi.getNote());
                                    }
                                }else{
                                    Element element15 = doc.createElement("note");
                                    element15.setTextContent(poi.getNote());
                                    element1.appendChild(element15);
                                }
                            }

                            prolist=element1.getElementsByTagName("lx");
                            if(poi.getLx()!=null) {
                                if(prolist.getLength()>0){
                                    for (int k = 0; k < prolist.getLength(); k++) {
                                        Element element15 = (Element) prolist.item(k);
                                        element15.setTextContent(poi.getLx());
                                    }
                                }else{
                                    Element element15 = doc.createElement("lx");
                                    element15.setTextContent(poi.getLx());
                                    element1.appendChild(element15);
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    /**
     * 删除指定节点
     * @param name 删除的Brand属性名
     */
    public void deleteNode(String name){
        NodeList brandsEle = doc.getElementsByTagName("poi");
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
        NodeList poiitem = doc.getElementsByTagName("fz");
        for (int i = 0; i < poiitem.getLength(); i++) {
            Node fzs = poiitem.item(i);
            Element fz = (Element) fzs;
            jf+= Integer.valueOf(fz.getTextContent());
        }
        return jf;
    }

    public Integer getWeek(List<String> list) throws ParseException {
        Integer jf=0;
        NodeList poiitem = doc.getElementsByTagName("fz");
        for (int i = 0; i < poiitem.getLength(); i++) {
            Node fzs = poiitem.item(i);
            Element fz = (Element) fzs;
            if(list.contains(TIMEMIAO1.format(TIMEMIAO1.parse(((Element)fzs.getParentNode()).getAttribute("date"))))){
                jf+= Integer.valueOf(fz.getTextContent());
            }
        }
        return jf;
    }

    public Integer getDay(String d) {
        Integer jf=0;
        NodeList poiitem = doc.getElementsByTagName("fz");
        for (int i = 0; i < poiitem.getLength(); i++) {
            Node fzs = poiitem.item(i);
            Element fz = (Element) fzs;
            if(((Element)fzs.getParentNode()).getAttribute("date").indexOf(d)>=0){
                jf+= Integer.valueOf(fz.getTextContent());
            }
        }
        return jf;
    }

    public Integer getWeeksd(List<String> list, Integer sdid) throws ParseException {
        Integer jf=0;
        NodeList poiitem = doc.getElementsByTagName("fz");
        for (int i = 0; i < poiitem.getLength(); i++) {
            Node fzs = poiitem.item(i);
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
        NodeList poiitem = doc.getElementsByTagName("fz");
        for (int i = 0; i < poiitem.getLength(); i++) {
            Node fzs = poiitem.item(i);
            Element fz = (Element) fzs;
            if(((Element)fzs.getParentNode()).getAttribute("id").equals(sdid.toString())){
                jf+= Integer.valueOf(fz.getTextContent());
            }
        }
        return jf;
    }

    public Integer getNum(String nf) {
        if(nf==null){
            NodeList brandsEle = doc.getElementsByTagName("poi");
            return brandsEle.getLength();
        }else{
            NodeList brandsEle = doc.getElementsByTagName("pro");
            Integer n=0;
            for (int i = 0; i < brandsEle.getLength(); i++) {
                Node proNode = brandsEle.item(i);
                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pro = (Element) proNode;
                    if(pro.getAttribute("date").substring(0,4).equals(nf))n++;
                }
            }
            return n;
        }

    }

    public Integer getSum(String nf) {
        NodeList brandsEle = doc.getElementsByTagName("pro");
        Integer n=0;
        for (int i = 0; i < brandsEle.getLength(); i++) {
            Node proNode = brandsEle.item(i);
            if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                Element pro = (Element) proNode;
                if(pro.getAttribute("date").substring(0,4).equals(nf)){
                    NodeList pros = pro.getChildNodes();
                    for (int k = 0; k < pros.getLength(); k++) {
                        Node type = pros.item(k);
                        // 判断是否是元素节点(使用getChildNodes()就要判断)
                        if (type.getNodeType() == Node.ELEMENT_NODE) {
                            Element jyitem = (Element) type;
                            if (jyitem.getTagName().equals("fz")) {
                                n = n + Integer.valueOf(jyitem.getTextContent());
                            }
                        }
                    }
                }
            }
        }
        return n;
    }

    /**
     * 显示xml文档信息 ！
     */
    public poi getId(String uid) throws ParseException {
        List<poi> list=new ArrayList();
        poi poi=new poi();
        String name="";
        String day="";
        String text="";
        String id="";
        // 获取DOM树s节点
        NodeList poiitem = doc.getElementsByTagName("poi");
        for (int i = 0; i < poiitem.getLength(); i++) {
            poi=new poi();
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            Element element = (Element) poiitem.item(i);
            // 获取第i个poi元素的id属性
            id= element.getAttribute("id");
            if(uid.equals(element.getAttribute("uid"))){
                poi.setPoi(id);
                poi.setId(uid);

                // 获得所有的子节点
                NodeList pois = element.getChildNodes();
                for (int j = 0; j < pois.getLength(); j++) {
                    Node proNode = pois.item(j);
                    // 判断是否是元素节点(使用getChildNodes()就要判断)
                    if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element pro = (Element) proNode;
                        name=pro.getTagName();
                        if(name.equals("pro")){
                            id= pro.getAttribute("id");
                            day= pro.getAttribute("date");
                            poi.setPro(Integer.valueOf(id));
                            poi.setHdade(TIMEMIAO.parse(day));
                            NodeList pros = pro.getChildNodes();
                            for (int k = 0; k < pros.getLength(); k++) {
                                Node type = pros.item(k);
                                // 判断是否是元素节点(使用getChildNodes()就要判断)
                                if (type.getNodeType() == Node.ELEMENT_NODE) {
                                    Element jyitem = (Element) type;
                                    name=jyitem.getTagName();
                                    if(name.equals("type1")){
                                        text= jyitem.getTextContent();
                                        poi.setType1(text);
                                    }else if(name.equals("type2")){
                                        text= jyitem.getTextContent();
                                        poi.setType2(text);
                                    }else if(name.equals("jname")){
                                        text= jyitem.getTextContent();
                                        poi.setJname(text);
                                    }else if(name.equals("fz")){
                                        text= jyitem.getTextContent();
                                        poi.setFz(Integer.valueOf(text));
                                    }else if(name.equals("p1")){
                                        id= jyitem.getAttribute("id");
                                        text= jyitem.getTextContent();
                                        poi.setJdid(Integer.valueOf(id));
                                        poi.setP1(text);
                                    }else if(name.equals("p2")){
                                        id= jyitem.getAttribute("id");
                                        text= jyitem.getTextContent();
                                        poi.setJgid(Integer.valueOf(id));
                                        poi.setP2(text);
                                    }else if(name.equals("p3")){
                                        id= jyitem.getAttribute("id");
                                        text= jyitem.getTextContent();
                                        poi.setNjid(Integer.valueOf(id));
                                        poi.setP3(text);
                                    }else if(name.equals("p4")){
                                        id= jyitem.getAttribute("id");
                                        text= jyitem.getTextContent();
                                        poi.setBjid(Integer.valueOf(id));
                                        poi.setP4(text);
                                    }else if(name.equals("jd")){
                                        text= jyitem.getTextContent();
                                        poi.setJd(Integer.valueOf(text));
                                    }else if(name.equals("jg")){
                                        text= jyitem.getTextContent();
                                        poi.setJg(Integer.valueOf(text));
                                    }else if(name.equals("wg")){
                                        text= jyitem.getTextContent();
                                        poi.setWg(Integer.valueOf(text));
                                    }else if(name.equals("wwg")){
                                        text= jyitem.getTextContent();
                                        poi.setWwg(Integer.valueOf(text));
                                    }else if(name.equals("uid")){
                                        text= jyitem.getTextContent();
                                        poi.setUid(Integer.valueOf(text));
                                    }else if(name.equals("note")){
                                        text= jyitem.getTextContent();
                                        poi.setNote(text);
                                    }else if(name.equals("lx")){
                                        text= jyitem.getTextContent();
                                        poi.setLx(text);
                                    }
                                }
                            }
                        }
                    }
                }
                return poi;
            }
        }
        return  null;
    }
    public void deleteId(String uid){
        NodeList brandsEle = doc.getElementsByTagName("poi");
        for (int i = 0; i < brandsEle.getLength(); i++) {
            Element brand = (Element) brandsEle.item(i);
            String text = brand.getAttribute("uid");
            if(text.equals(uid)){
                doc.getElementsByTagName("root").item(0).removeChild(brand);
            }
        }
    }
}
