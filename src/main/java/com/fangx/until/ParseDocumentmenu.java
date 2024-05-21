package com.efx.quality.until;

import com.efx.quality.model.*;
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
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ParseDocumentmenu {
    Document doc = null;// 创建一个Document对象
    SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat TIMEMIAO2 = new SimpleDateFormat("yyyy-MM");

    public static void main(String[] args) {
        File file = new File("D:\\IdeaProjects\\quality\\target\\classes\\static\\upload\\jylist\\menu\\0f109a050bd24c3d828d7d9a91ce2f53.xml");
        String url="D:\\IdeaProjects\\quality\\target\\classes\\static\\upload\\jylist\\menu\\0f109a050bd24c3d828d7d9a91ce2f53.xml";
        url="D:\\IdeaProjects\\quality\\target\\classes\\static\\upload\\jylist\\jd\\15\\menu\\menu.xml";

        ParseDocumentmenu xml = new ParseDocumentmenu();
        xml.getDocument(url);
//        xml.creatNode("s","100001");
//        xml.creatNode("s","101001");
//        xml.changeType("100002","10001");
//        xml.showInfo();
//        xml.deleteNode("100001");
//        xml.showInfo();
//        xml.saveXml(url);
//        System.out.println(xml.getNum("2",null,null));
//        System.out.println(xml.getNum(null,"2",null));
//        System.out.println(xml.getNum(null,null,"1"));
        /*xml.showInfo();
        System.out.println(xml.getText("m","2023-03-17"));
        menu m=new menu();
        m.setYf("2023-09-20");
        m.setNum(10);
        xml.creatNode(m);
        xml.saveXml(url);*/
        List<menu> mlist=new ArrayList();
        menu m=new menu();
        m.setYf("2023-09-28");
        m.setNum(1);
        List<cdyhe> wdlist = new ArrayList<>();
        cdyhe wd=new cdyhe();
        wd.setYhe001(3);
        wd.setNum(1);
        wdlist.add(wd);
        List<cdusb> wwglist =new ArrayList<>();
        List<cdusc> wglist =new ArrayList<>();
        List<cdusd> jglist =new ArrayList<>();
        List<cdusg> jdlist =new ArrayList<>();
        cdusg jd=null;
        cdusd jg=null;
        cdusc wg=null;
        cdusb wwg=null;
            /*jd.setUsg001(1);
            jd.setNum(1);
            jdlist.add(jd);
            m.setJdlist(jdlist);*/
        /*jg=new cdusd();
            jg.setUsd001(2);
            jg.setNum(1);*/
//            jglist.add(jg);
//            m.setJglist(jglist);
        wg=new cdusc();
            wg.setUsc001(3);
            wg.setNum(1);
            /*wglist.add(wg);
            m.setWglist(wglist);*/
            /*wwg.setUsb001(4);
            wwg.setNum(1);
            wwglist.add(wwg);
            m.setWwglist(wwglist);*/
        mlist.add(m);
        xml.changemenu(m,wd, jd, jg, wg, wwg);
        xml.saveXml(url);
    }
    public void changemenu(menu m, cdyhe wd, cdusg jd, cdusd jg,cdusc wg, cdusb wwg){
        //size
        NodeList size = doc.getElementsByTagName("size");
        //遍历节点
        for (int i = 0; i < size.getLength(); i++) {
            Node brands = size.item(i);
            Element brand=(Element) brands;
            String num = brand.getAttribute("num");
            brand.setAttribute("num", String.valueOf((Integer.valueOf(num)+1)));
            NodeList item = brand.getElementsByTagName("s");
            boolean flag=true;
            if(wd!=null){
                for (int j = 0; j < item.getLength();j++) {
                    Node item1 = item.item(j);
                    Element item2=(Element) item1;
                    if(item2.getAttribute("id").equals(wd.getYhe001().toString())) {
                        String num1 = item2.getAttribute("num");
                        item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) + 1)));
                        flag=false;
                        break;
                    }
                }
                if(flag) {
                    Element elementChildTwo1 = doc.createElement("s");
                    elementChildTwo1.setAttribute("id", wd.getYhe001().toString());
                    elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                    brands.appendChild(elementChildTwo1);
                }
            }
            if(jd!=null){
                flag=true;
                item =brand.getElementsByTagName("jd");
                for (int j = 0; j < item.getLength();j++) {
                    Node item1 = item.item(j);
                    Element item2=(Element) item1;
                    if(item2.getAttribute("id").equals(jd.getUsg001().toString())) {
                        String num1 = item2.getAttribute("num");
                        item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) + 1)));
                        flag=false;
                        NodeList item3 = item2.getElementsByTagName("d");
                        boolean flag1=true;
                        for (int k = 0; k < item3.getLength();k++) {
                            Node item4 = item3.item(k);
                            Element item5=(Element) item4;
                            if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                String num2 = item5.getAttribute("num");
                                item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) + 1)));
                                flag1=false;
                                break;
                            }
                        }
                        if(flag1) {
                            Element elementChildTwo1 = doc.createElement("d");
                            elementChildTwo1.setAttribute("id", wd.getYhe001().toString());
                            elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                            item2.appendChild(elementChildTwo1);
                        }
                        break;
                    }
                }
                if(flag) {
                    Element elementChildTwo1 = doc.createElement("jd");
                    elementChildTwo1.setAttribute("id",jd.getUsg001().toString());
                    elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                    brands.appendChild(elementChildTwo1);
                    Element elementChildTwo2 = doc.createElement("d");
                    elementChildTwo2.setAttribute("id", wd.getYhe001().toString());
                    elementChildTwo2.setAttribute("num", String.valueOf(wd.getNum()));
                    elementChildTwo1.appendChild(elementChildTwo2);
                }
            }
            if(jg!=null){
                flag=true;
                item =brand.getElementsByTagName("jg");
                for (int j = 0; j < item.getLength();j++) {
                    Node item1 = item.item(j);
                    Element item2=(Element) item1;
                    if(item2.getAttribute("id").equals(jg.getUsd001().toString())) {
                        String num1 = item2.getAttribute("num");
                        item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) + 1)));
                        flag=false;
                        NodeList item3 = item2.getElementsByTagName("g");
                        boolean flag1=true;
                        for (int k = 0; k < item3.getLength();k++) {
                            Node item4 = item3.item(k);
                            Element item5=(Element) item4;
                            if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                String num2 = item5.getAttribute("num");
                                item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) + 1)));
                                flag1=false;
                                break;
                            }
                        }
                        if(flag1) {
                            Element elementChildTwo1 = doc.createElement("g");
                            elementChildTwo1.setAttribute("id", wd.getYhe001().toString());
                            elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                            item2.appendChild(elementChildTwo1);
                        }
                        break;
                    }
                }
                if(flag) {
                    Element elementChildTwo1 = doc.createElement("jg");
                    elementChildTwo1.setAttribute("id", jg.getUsd001().toString());
                    elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                    brands.appendChild(elementChildTwo1);
                    Element elementChildTwo2 = doc.createElement("g");
                    elementChildTwo2.setAttribute("id", wd.getYhe001().toString());
                    elementChildTwo2.setAttribute("num", String.valueOf(wd.getNum()));
                    elementChildTwo1.appendChild(elementChildTwo2);
                }
            }
            if(wg!=null){
                flag=true;
                item =brand.getElementsByTagName("wg");
                for (int j = 0; j < item.getLength();j++) {
                    Node item1 = item.item(j);
                    Element item2=(Element) item1;
                    if(item2.getAttribute("id").equals(wg.getUsc001().toString())) {
                        String num1 = item2.getAttribute("num");
                        item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) + 1)));
                        flag=false;
                        NodeList item3 = item2.getElementsByTagName("w");
                        boolean flag1=true;
                        for (int k = 0; k < item3.getLength();k++) {
                            Node item4 = item3.item(k);
                            Element item5=(Element) item4;
                            if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                String num2 = item5.getAttribute("num");
                                item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) + 1)));
                                flag1=false;
                                break;
                            }
                        }
                        if(flag1) {
                            Element elementChildTwo1 = doc.createElement("w");
                            elementChildTwo1.setAttribute("id", wd.getYhe001().toString());
                            elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                            item2.appendChild(elementChildTwo1);
                        }
                        break;
                    }
                }
                if(flag) {
                    Element elementChildTwo1 = doc.createElement("wg");
                    elementChildTwo1.setAttribute("id", wg.getUsc001().toString());
                    elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                    brands.appendChild(elementChildTwo1);
                    Element elementChildTwo2 = doc.createElement("w");
                    elementChildTwo2.setAttribute("id", wd.getYhe001().toString());
                    elementChildTwo2.setAttribute("num", String.valueOf(wd.getNum()));
                    elementChildTwo1.appendChild(elementChildTwo2);
                }
            }
            if(wwg!=null){
                flag=true;
                item =brand.getElementsByTagName("wwg");
                for (int j = 0; j < item.getLength();j++) {
                    Node item1 = item.item(j);
                    Element item2=(Element) item1;
                    if(item2.getAttribute("id").equals(wwg.getUsb001().toString())) {
                        String num1 = item2.getAttribute("num");
                        item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) + 1)));
                        flag=false;
                        NodeList item3 = item2.getElementsByTagName("ww");
                        boolean flag1=true;
                        for (int k = 0; k < item3.getLength();k++) {
                            Node item4 = item3.item(k);
                            Element item5=(Element) item4;
                            if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                String num2 = item5.getAttribute("num");
                                item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) + 1)));
                                flag1=false;
                                break;
                            }
                        }
                        if(flag1) {
                            Element elementChildTwo1 = doc.createElement("ww");
                            elementChildTwo1.setAttribute("id", wd.getYhe001().toString());
                            elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                            item1.appendChild(elementChildTwo1);
                        }
                        break;
                    }
                }
                if(flag) {
                    Element elementChildTwo1 = doc.createElement("wwg");
                    elementChildTwo1.setAttribute("id", wwg.getUsb001().toString());
                    elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                    brands.appendChild(elementChildTwo1);
                    Element elementChildTwo2 = doc.createElement("ww");
                    elementChildTwo2.setAttribute("id", wd.getYhe001().toString());
                    elementChildTwo2.setAttribute("num", String.valueOf(wd.getNum()));
                    elementChildTwo1.appendChild(elementChildTwo2);
                }
            }
        }

        if(getText("m",m.getYf())){
            //获得节点信息
            NodeList items = doc.getElementsByTagName("m");
            //遍历节点
            for (int i = 0; i < items.getLength(); i++) {
                Node brands = items.item(i);
                Element brand=(Element) brands;
                if(brand.getAttribute("date").equals(m.getYf())){
                    String num = brand.getAttribute("num");
                    brand.setAttribute("num", String.valueOf((Integer.valueOf(num)+1)));
                    NodeList item = brand.getElementsByTagName("s");
                    boolean flag=true;
                    if(wd!=null){
                        for (int j = 0; j < item.getLength();j++) {
                            Node item1 = item.item(j);
                            Element item2=(Element) item1;
                            if(item2.getAttribute("id").equals(wd.getYhe001().toString())) {
                                String num1 = item2.getAttribute("num");
                                item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) + 1)));
                                flag=false;
                                break;
                            }
                        }
                        if(flag) {
                            Element elementChildTwo1 = doc.createElement("s");
                            elementChildTwo1.setAttribute("id", wd.getYhe001().toString());
                            elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                            brands.appendChild(elementChildTwo1);
                        }
                    }
                    if(jd!=null){
                        flag=true;
                        item =brand.getElementsByTagName("jd");
                        for (int j = 0; j < item.getLength();j++) {
                            Node item1 = item.item(j);
                            Element item2=(Element) item1;
                            if(item2.getAttribute("id").equals(jd.getUsg001().toString())) {
                                String num1 = item2.getAttribute("num");
                                item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) + 1)));
                                flag=false;
                                NodeList item3 = item2.getElementsByTagName("d");
                                boolean flag1=true;
                                for (int k = 0; k < item3.getLength();k++) {
                                    Node item4 = item3.item(k);
                                    Element item5=(Element) item4;
                                    if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                        String num2 = item5.getAttribute("num");
                                        item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) + 1)));
                                        flag1=false;
                                        break;
                                    }
                                }
                                if(flag1) {
                                    Element elementChildTwo1 = doc.createElement("d");
                                    elementChildTwo1.setAttribute("id", wd.getYhe001().toString());
                                    elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                                    item2.appendChild(elementChildTwo1);
                                }
                                break;
                            }
                        }
                        if(flag) {
                            Element elementChildTwo1 = doc.createElement("jd");
                            elementChildTwo1.setAttribute("id",jd.getUsg001().toString());
                            elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                            brands.appendChild(elementChildTwo1);
                            Element elementChildTwo2 = doc.createElement("d");
                            elementChildTwo2.setAttribute("id", wd.getYhe001().toString());
                            elementChildTwo2.setAttribute("num", String.valueOf(wd.getNum()));
                            elementChildTwo1.appendChild(elementChildTwo2);
                        }
                    }
                    if(jg!=null){
                        flag=true;
                        item =brand.getElementsByTagName("jg");
                        for (int j = 0; j < item.getLength();j++) {
                            Node item1 = item.item(j);
                            Element item2=(Element) item1;
                            if(item2.getAttribute("id").equals(jg.getUsd001().toString())) {
                                String num1 = item2.getAttribute("num");
                                item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) + 1)));
                                flag=false;
                                NodeList item3 = item2.getElementsByTagName("g");
                                boolean flag1=true;
                                for (int k = 0; k < item3.getLength();k++) {
                                    Node item4 = item3.item(k);
                                    Element item5=(Element) item4;
                                    if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                        String num2 = item5.getAttribute("num");
                                        item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) + 1)));
                                        flag1=false;
                                        break;
                                    }
                                }
                                if(flag1) {
                                    Element elementChildTwo1 = doc.createElement("g");
                                    elementChildTwo1.setAttribute("id", wd.getYhe001().toString());
                                    elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                                    item2.appendChild(elementChildTwo1);
                                }
                                break;
                            }
                        }
                        if(flag) {
                            Element elementChildTwo1 = doc.createElement("jg");
                            elementChildTwo1.setAttribute("id", jg.getUsd001().toString());
                            elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                            brands.appendChild(elementChildTwo1);
                            Element elementChildTwo2 = doc.createElement("g");
                            elementChildTwo2.setAttribute("id", wd.getYhe001().toString());
                            elementChildTwo2.setAttribute("num", String.valueOf(wd.getNum()));
                            elementChildTwo1.appendChild(elementChildTwo2);
                        }
                    }
                    if(wg!=null){
                        flag=true;
                        item =brand.getElementsByTagName("wg");
                        for (int j = 0; j < item.getLength();j++) {
                            Node item1 = item.item(j);
                            Element item2=(Element) item1;
                            if(item2.getAttribute("id").equals(wg.getUsc001().toString())) {
                                String num1 = item2.getAttribute("num");
                                item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) + 1)));
                                flag=false;
                                NodeList item3 = item2.getElementsByTagName("w");
                                boolean flag1=true;
                                for (int k = 0; k < item3.getLength();k++) {
                                    Node item4 = item3.item(k);
                                    Element item5=(Element) item4;
                                    if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                        String num2 = item5.getAttribute("num");
                                        item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) + 1)));
                                        flag1=false;
                                        break;
                                    }
                                }
                                if(flag1) {
                                    Element elementChildTwo1 = doc.createElement("w");
                                    elementChildTwo1.setAttribute("id", wd.getYhe001().toString());
                                    elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                                    item2.appendChild(elementChildTwo1);
                                }
                                break;
                            }
                        }
                        if(flag) {
                            Element elementChildTwo1 = doc.createElement("wg");
                            elementChildTwo1.setAttribute("id", wg.getUsc001().toString());
                            elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                            brands.appendChild(elementChildTwo1);
                            Element elementChildTwo2 = doc.createElement("w");
                            elementChildTwo2.setAttribute("id", wd.getYhe001().toString());
                            elementChildTwo2.setAttribute("num", String.valueOf(wd.getNum()));
                            elementChildTwo1.appendChild(elementChildTwo2);
                        }
                    }
                    if(wwg!=null){
                        flag=true;
                        item =brand.getElementsByTagName("wwg");
                        for (int j = 0; j < item.getLength();j++) {
                            Node item1 = item.item(j);
                            Element item2=(Element) item1;
                            if(item2.getAttribute("id").equals(wwg.getUsb001().toString())) {
                                String num1 = item2.getAttribute("num");
                                item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) + 1)));
                                flag=false;
                                NodeList item3 = item2.getElementsByTagName("ww");
                                boolean flag1=true;
                                for (int k = 0; k < item3.getLength();k++) {
                                    Node item4 = item3.item(k);
                                    Element item5=(Element) item4;
                                    if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                        String num2 = item5.getAttribute("num");
                                        item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) + 1)));
                                        flag1=false;
                                        break;
                                    }
                                }
                                if(flag1) {
                                    Element elementChildTwo1 = doc.createElement("ww");
                                    elementChildTwo1.setAttribute("id", wd.getYhe001().toString());
                                    elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                                    item1.appendChild(elementChildTwo1);
                                }
                                break;
                            }
                        }
                        if(flag) {
                            Element elementChildTwo1 = doc.createElement("wwg");
                            elementChildTwo1.setAttribute("id", wwg.getUsb001().toString());
                            elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                            brands.appendChild(elementChildTwo1);
                            Element elementChildTwo2 = doc.createElement("ww");
                            elementChildTwo2.setAttribute("id", wd.getYhe001().toString());
                            elementChildTwo2.setAttribute("num", String.valueOf(wd.getNum()));
                            elementChildTwo1.appendChild(elementChildTwo2);
                        }
                    }
                    break;
                }
            }
        }
        else{
            Element elementChildTwo = doc.createElement("m");
            elementChildTwo.setAttribute("date", m.getYf());
            elementChildTwo.setAttribute("num", String.valueOf(m.getNum()));
            if(wd!=null&&wd.getNum()>0){
                Element elementChildTwo1 = doc.createElement("s");
                elementChildTwo1.setAttribute("id", wd.getYhe001().toString());
                elementChildTwo1.setAttribute("num", String.valueOf(wd.getNum()));
                elementChildTwo.appendChild(elementChildTwo1);
            }
            if(jd!=null&&jd.getNum()>0){
                Element elementChildTwo1 = doc.createElement("jd");
                elementChildTwo1.setAttribute("id", jd.getUsg001().toString());
                elementChildTwo1.setAttribute("num", String.valueOf(jd.getNum()));
                elementChildTwo.appendChild(elementChildTwo1);
                if(wd!=null&&wd.getNum()>0){
                    Element elementChildTwo2 = doc.createElement("s");
                    elementChildTwo2.setAttribute("id", wd.getYhe001().toString());
                    elementChildTwo2.setAttribute("num", String.valueOf(wd.getNum()));
                    elementChildTwo1.appendChild(elementChildTwo2);
                }
            }
            if(jg!=null&&jg.getNum()>0){
                Element elementChildTwo1 = doc.createElement("jg");
                elementChildTwo1.setAttribute("id", jg.getUsd001().toString());
                elementChildTwo1.setAttribute("num", String.valueOf(jg.getNum()));
                elementChildTwo.appendChild(elementChildTwo1);
                if(wd!=null&&wd.getNum()>0){
                    Element elementChildTwo2 = doc.createElement("s");
                    elementChildTwo2.setAttribute("id", wd.getYhe001().toString());
                    elementChildTwo2.setAttribute("num", String.valueOf(wd.getNum()));
                    elementChildTwo1.appendChild(elementChildTwo2);
                }
            }
            if(wg!=null&&wg.getNum()>0){
                Element elementChildTwo1 = doc.createElement("wg");
                elementChildTwo1.setAttribute("id", wg.getUsc001().toString());
                elementChildTwo1.setAttribute("num", String.valueOf(wg.getNum()));
                elementChildTwo.appendChild(elementChildTwo1);
                if(wd!=null&&wd.getNum()>0){
                    Element elementChildTwo2 = doc.createElement("s");
                    elementChildTwo2.setAttribute("id", wd.getYhe001().toString());
                    elementChildTwo2.setAttribute("num", String.valueOf(wd.getNum()));
                    elementChildTwo1.appendChild(elementChildTwo2);
                }
            }
            if(wwg!=null&&wwg.getNum()>0){
                Element elementChildTwo1 = doc.createElement("wwg");
                elementChildTwo1.setAttribute("id", wwg.getUsb001().toString());
                elementChildTwo1.setAttribute("num", String.valueOf(wwg.getNum()));
                elementChildTwo.appendChild(elementChildTwo1);
                if(wd!=null&&wd.getNum()>0){
                    Element elementChildTwo2 = doc.createElement("s");
                    elementChildTwo2.setAttribute("id", wd.getYhe001().toString());
                    elementChildTwo2.setAttribute("num", String.valueOf(wd.getNum()));
                    elementChildTwo1.appendChild(elementChildTwo2);
                }
            }
            NodeList roots = doc.getElementsByTagName("root");
            for (int i = 0; i < roots.getLength(); i++) {
                Node root = roots.item(i);
                if (root.getNodeType() == Node.ELEMENT_NODE) {
                    // 把节点挂到root上
                    root.insertBefore(elementChildTwo,root.getFirstChild());
                }

            }
        }
    }

    public void changemenu1(menu m, cdyhe wd, cdusg jd, cdusd jg,cdusc wg, cdusb wwg){
        //size
        NodeList size = doc.getElementsByTagName("size");
        //遍历节点
        for (int i = 0; i < size.getLength(); i++) {
            Node brands = size.item(i);
            Element brand=(Element) brands;
            String num = brand.getAttribute("num");
            brand.setAttribute("num", String.valueOf((Integer.valueOf(num)-1)));
            NodeList item = brand.getElementsByTagName("s");
            boolean flag=true;
            if(wd!=null){
                for (int j = 0; j < item.getLength();j++) {
                    Node item1 = item.item(j);
                    Element item2=(Element) item1;
                    if(item2.getAttribute("id").equals(wd.getYhe001().toString())) {
                        String num1 = item2.getAttribute("num");
                        item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) - 1)));
                        flag=false;
                        break;
                    }
                }
            }
            if(jd!=null){
                flag=true;
                item =brand.getElementsByTagName("jd");
                for (int j = 0; j < item.getLength();j++) {
                    Node item1 = item.item(j);
                    Element item2=(Element) item1;
                    if(item2.getAttribute("id").equals(jd.getUsg001().toString())) {
                        String num1 = item2.getAttribute("num");
                        item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) - 1)));
                        flag=false;
                        NodeList item3 = item2.getElementsByTagName("d");
                        boolean flag1=true;
                        for (int k = 0; k < item3.getLength();k++) {
                            Node item4 = item3.item(k);
                            Element item5=(Element) item4;
                            if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                String num2 = item5.getAttribute("num");
                                item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) - 1)));
                                flag1=false;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            if(jg!=null){
                flag=true;
                item =brand.getElementsByTagName("jg");
                for (int j = 0; j < item.getLength();j++) {
                    Node item1 = item.item(j);
                    Element item2=(Element) item1;
                    if(item2.getAttribute("id").equals(jg.getUsd001().toString())) {
                        String num1 = item2.getAttribute("num");
                        item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) - 1)));
                        flag=false;
                        NodeList item3 = item2.getElementsByTagName("g");
                        boolean flag1=true;
                        for (int k = 0; k < item3.getLength();k++) {
                            Node item4 = item3.item(k);
                            Element item5=(Element) item4;
                            if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                String num2 = item5.getAttribute("num");
                                item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) - 1)));
                                flag1=false;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            if(wg!=null){
                flag=true;
                item =brand.getElementsByTagName("wg");
                for (int j = 0; j < item.getLength();j++) {
                    Node item1 = item.item(j);
                    Element item2=(Element) item1;
                    if(item2.getAttribute("id").equals(wg.getUsc001().toString())) {
                        String num1 = item2.getAttribute("num");
                        item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) - 1)));
                        flag=false;
                        NodeList item3 = item2.getElementsByTagName("w");
                        boolean flag1=true;
                        for (int k = 0; k < item3.getLength();k++) {
                            Node item4 = item3.item(k);
                            Element item5=(Element) item4;
                            if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                String num2 = item5.getAttribute("num");
                                item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) - 1)));
                                flag1=false;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            if(wwg!=null){
                flag=true;
                item =brand.getElementsByTagName("wwg");
                for (int j = 0; j < item.getLength();j++) {
                    Node item1 = item.item(j);
                    Element item2=(Element) item1;
                    if(item2.getAttribute("id").equals(wwg.getUsb001().toString())) {
                        String num1 = item2.getAttribute("num");
                        item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) - 1)));
                        flag=false;
                        NodeList item3 = item2.getElementsByTagName("ww");
                        boolean flag1=true;
                        for (int k = 0; k < item3.getLength();k++) {
                            Node item4 = item3.item(k);
                            Element item5=(Element) item4;
                            if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                String num2 = item5.getAttribute("num");
                                item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) - 1)));
                                flag1=false;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }

        if(getText("m",m.getYf())){
            //获得节点信息
            NodeList items = doc.getElementsByTagName("m");
            //遍历节点
            for (int i = 0; i < items.getLength(); i++) {
                Node brands = items.item(i);
                Element brand=(Element) brands;
                if(brand.getAttribute("date").equals(m.getYf())){
                    String num = brand.getAttribute("num");
                    brand.setAttribute("num", String.valueOf((Integer.valueOf(num)-1)));
                    NodeList item = brand.getElementsByTagName("s");
                    boolean flag=true;
                    if(wd!=null){
                        for (int j = 0; j < item.getLength();j++) {
                            Node item1 = item.item(j);
                            Element item2=(Element) item1;
                            if(item2.getAttribute("id").equals(wd.getYhe001().toString())) {
                                String num1 = item2.getAttribute("num");
                                item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) - 1)));
                                flag=false;
                                break;
                            }
                        }
                    }
                    if(jd!=null){
                        flag=true;
                        item =brand.getElementsByTagName("jd");
                        for (int j = 0; j < item.getLength();j++) {
                            Node item1 = item.item(j);
                            Element item2=(Element) item1;
                            if(item2.getAttribute("id").equals(jd.getUsg001().toString())) {
                                String num1 = item2.getAttribute("num");
                                item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) - 1)));
                                flag=false;
                                NodeList item3 = item2.getElementsByTagName("d");
                                boolean flag1=true;
                                for (int k = 0; k < item3.getLength();k++) {
                                    Node item4 = item3.item(k);
                                    Element item5=(Element) item4;
                                    if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                        String num2 = item5.getAttribute("num");
                                        item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) - 1)));
                                        flag1=false;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    if(jg!=null){
                        flag=true;
                        item =brand.getElementsByTagName("jg");
                        for (int j = 0; j < item.getLength();j++) {
                            Node item1 = item.item(j);
                            Element item2=(Element) item1;
                            if(item2.getAttribute("id").equals(jg.getUsd001().toString())) {
                                String num1 = item2.getAttribute("num");
                                item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) - 1)));
                                flag=false;
                                NodeList item3 = item2.getElementsByTagName("g");
                                boolean flag1=true;
                                for (int k = 0; k < item3.getLength();k++) {
                                    Node item4 = item3.item(k);
                                    Element item5=(Element) item4;
                                    if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                        String num2 = item5.getAttribute("num");
                                        item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) - 1)));
                                        flag1=false;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    if(wg!=null){
                        flag=true;
                        item =brand.getElementsByTagName("wg");
                        for (int j = 0; j < item.getLength();j++) {
                            Node item1 = item.item(j);
                            Element item2=(Element) item1;
                            if(item2.getAttribute("id").equals(wg.getUsc001().toString())) {
                                String num1 = item2.getAttribute("num");
                                item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) - 1)));
                                flag=false;
                                NodeList item3 = item2.getElementsByTagName("w");
                                boolean flag1=true;
                                for (int k = 0; k < item3.getLength();k++) {
                                    Node item4 = item3.item(k);
                                    Element item5=(Element) item4;
                                    if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                        String num2 = item5.getAttribute("num");
                                        item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) - 1)));
                                        flag1=false;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    if(wwg!=null){
                        flag=true;
                        item =brand.getElementsByTagName("wwg");
                        for (int j = 0; j < item.getLength();j++) {
                            Node item1 = item.item(j);
                            Element item2=(Element) item1;
                            if(item2.getAttribute("id").equals(wwg.getUsb001().toString())) {
                                String num1 = item2.getAttribute("num");
                                item2.setAttribute("num", String.valueOf((Integer.valueOf(num1) - 1)));
                                flag=false;
                                NodeList item3 = item2.getElementsByTagName("ww");
                                boolean flag1=true;
                                for (int k = 0; k < item3.getLength();k++) {
                                    Node item4 = item3.item(k);
                                    Element item5=(Element) item4;
                                    if(item5.getAttribute("id").equals(wd.getYhe001().toString())) {
                                        String num2 = item5.getAttribute("num");
                                        item5.setAttribute("num", String.valueOf((Integer.valueOf(num2) - 1)));
                                        flag1=false;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
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
            if(brand.getAttribute("date").equals(value)){
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
            System.out.println(doc);
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
        NodeList sName = doc.getElementsByTagName("m");
        for (int i = 0; i < sName.getLength(); i++) {
            // 获取第i个s元素的信息（返回i元素）
            Node s = sName.item(i);
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            Element element = (Element) s;
            // 获取第i个s元素的name属性
            String date= element.getAttribute("date");
            String num= element.getAttribute("num");
            System.out.println("date:"+date+"-"+ num);
        }
    }
    /**
     * 新增节点
     *
     */
    public void creatNode(menu m) {
        // 创建根节点第一个子节点
        Element elementChildTwo = doc.createElement("m");
        elementChildTwo.setAttribute("date", m.getYf());
        elementChildTwo.setAttribute("num", String.valueOf(m.getNum()));
        if(m.getWdlist()!=null){
            for(cdyhe yhe:m.getWdlist()){
                if(yhe.getNum()>0){
                    Element elementChildTwo1 = doc.createElement("s");
                    elementChildTwo1.setAttribute("id", yhe.getYhe001().toString());
                    elementChildTwo1.setAttribute("num", String.valueOf(yhe.getNum()));
                    elementChildTwo.appendChild(elementChildTwo1);
                }
            }
        }
        if(m.getJglist()!=null){
            for(cdusd usd :m.getJglist()){
                if(usd .getNum()>0){
                    Element elementChildTwo1 = doc.createElement("jg");
                    elementChildTwo1.setAttribute("id", usd.getUsd001().toString());
                    elementChildTwo1.setAttribute("num", String.valueOf(usd .getNum()));
                    elementChildTwo.appendChild(elementChildTwo1);
                }
            }
        }
        if(m.getWwglist()!=null){
            for(cdusb usb:m.getWwglist()){
                if(usb.getNum()>0){
                    Element elementChildTwo1 = doc.createElement("wwg");
                    elementChildTwo1.setAttribute("id", usb.getUsb001().toString());
                    elementChildTwo1.setAttribute("num", String.valueOf(usb.getNum()));
                    elementChildTwo.appendChild(elementChildTwo1);
                }
            }
        }
        // 找到PhoneInfo节点
        NodeList roots = doc.getElementsByTagName("root");
        for (int i = 0; i < roots.getLength(); i++) {
            Node root = roots.item(i);
            if (root.getNodeType() == Node.ELEMENT_NODE) {
                // 把三星节点挂到PhoneInfo上
                root.insertBefore(elementChildTwo,root.getFirstChild());
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
            transformer.setOutputProperty(OutputKeys.ENCODING, "GB2312");

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
    public void changeType(String name,menu m){
        //size
        NodeList size = doc.getElementsByTagName("size");
        //遍历节点
        for (int i = 0; i < size.getLength(); i++) {
            Node brands = size.item(i);
            Element brand=(Element) brands;
            String text = brand.getAttribute("num");
            if(text.equals(name)){
                brand.setAttribute("num", String.valueOf((Integer.valueOf(text)+1)));
            }
        }
        //获得节点信息
        NodeList item = doc.getElementsByTagName("m");
        //遍历节点
        for (int i = 0; i < item.getLength(); i++) {
            Node brands = item.item(i);
            Element brand=(Element) brands;
            if(brand.getAttribute("date").equals(m.getYf())){
                brand.setAttribute("num", String.valueOf(m.getNum()));
                break;
            }
        }
    }
    /**
     * 删除指定节点
     * @param name 删除的Brand属性名
     */
    public void deleteNode(String name){
        NodeList brandsEle = doc.getElementsByTagName("s");
        for (int i = 0; i < brandsEle.getLength(); i++) {
            Element brand = (Element) brandsEle.item(i);
            String text = brand.getTextContent();
            if(text.equals(name)){
                doc.getElementsByTagName("root").item(0).removeChild(brand);
            }

        }
    }
    public List<menu> getMenulist() {
        List<menu> list=new ArrayList();
        List<cdyhe> jylist=new ArrayList();
        List<cdusd> jglist=new ArrayList();
        List<cdusb> wwglist=new ArrayList();
        menu menu=new menu();
        cdyhe yhe=new cdyhe();
        cdusd usd=new cdusd();
        cdusb usb=new cdusb();
        // 获取DOM树s节点
        NodeList peritem = doc.getElementsByTagName("m");
        for (int i = 0; i < peritem.getLength(); i++) {
            menu=new menu();
            jylist=new ArrayList();
            jglist=new ArrayList();
            wwglist=new ArrayList();
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            Element element = (Element) peritem.item(i);
            // 获取第i个per元素的id属性
            menu.setYf(element.getAttribute("date"));
            //System.out.println(menu.getYf());
            menu.setNum(Integer.valueOf(element.getAttribute("num")));
            // 获得所有的子节点
            NodeList pers = element.getChildNodes();
            for (int j = 0; j < pers.getLength(); j++) {
                Node proNode = pers.item(j);
                // 判断是否是元素节点(使用getChildNodes()就要判断)
                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pro = (Element) proNode;
                    if(pro.getTagName().equals("s")){
                        yhe=new cdyhe();
                        yhe.setYhe001(Integer.valueOf(pro.getAttribute("id")));
                        yhe.setNum(Integer.valueOf(pro.getAttribute("num")));
                        jylist.add(yhe);
                    }else if(pro.getTagName().equals("jg")){
                        usd=new cdusd();
                        usd.setUsd001(Integer.valueOf(pro.getAttribute("id")));
                        usd.setNum(Integer.valueOf(pro.getAttribute("num")));
                        jglist.add(usd);
                    }else if(pro.getTagName().equals("wwg")){
                        usb=new cdusb();
                        usb.setUsb001(Integer.valueOf(pro.getAttribute("id")));
                        usb.setNum(Integer.valueOf(pro.getAttribute("num")));
                        wwglist.add(usb);
                    }
                }
            }
            menu.setWdlist(jylist);menu.setJglist(jglist);menu.setWwglist(wwglist);
            list.add(menu);
        }
        return list;
    }


    public Integer getNum(String yf, String jyid, List<Integer> jyids, String start, String end, String jgid, List<Integer> wwgids, String wwgid) throws ParseException {
        // 获取DOM树s节点
        Integer num=0;
        if(yf==null&&start==null&&end==null){
            NodeList sName = doc.getElementsByTagName("size");
            for (int i = 0; i < sName.getLength(); i++) {
                Element size = (Element) sName.item(i);
                if(jyid==null&&jyids==null&&jgid==null&&wwgids==null&&wwgid==null){
                    return Integer.valueOf(size.getAttribute("num"));
                }else{
                    NodeList pers = size.getChildNodes();
                    for (int j = 0; j < pers.getLength(); j++) {
                        Node proNode = pers.item(j);
                        if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element s = (Element) proNode;
                            if(wwgid!=null){
                                if(s.getTagName().equals("wwg")&&s.getAttribute("id").equals(wwgid)){
                                    if(jyid!=null||jyids!=null){
                                        NodeList pros = proNode.getChildNodes();
                                        for (int k = 0; k < pros.getLength(); k++) {
                                            Node sNode = pers.item(j);
                                            if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element s1 = (Element) sNode;
                                                if(s1.getTagName().equals("s")){
                                                    if(jyids!=null&&jyid!=null){
                                                        if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                            return Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyid!=null){
                                                        if(s1.getAttribute("id").equals(jyid)){
                                                            return Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyids!=null){
                                                        if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else{
                                        return Integer.valueOf(s.getAttribute("num"));
                                    }
                                }
                            }else if(wwgids!=null){
                                if(s.getTagName().equals("wwg")&&wwgids.contains(Integer.valueOf(s.getAttribute("id")))){
                                    if(jyid!=null||jyids!=null){
                                        NodeList pros = proNode.getChildNodes();
                                        for (int k = 0; k < pros.getLength(); k++) {
                                            Node sNode = pers.item(j);
                                            if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element s1 = (Element) sNode;
                                                if(s1.getTagName().equals("s")){
                                                    if(jyids!=null&&jyid!=null){
                                                        if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                            return Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyid!=null){
                                                        if(s1.getAttribute("id").equals(jyid)){
                                                            return Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyids!=null){
                                                        if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else{
                                        num+=Integer.valueOf(s.getAttribute("num"));
                                    }
                                }
                            }else if(jgid!=null){
                                if(s.getTagName().equals("jg")&&s.getAttribute("id").equals(jgid)){
                                    if(jyid!=null||jyids!=null){
                                        NodeList pros = proNode.getChildNodes();
                                        for (int k = 0; k < pros.getLength(); k++) {
                                            Node sNode = pros.item(k);
                                            if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element s1 = (Element) sNode;
                                                if(s1.getTagName().equals("s")){

                                                    if(jyids!=null&&jyid!=null){
                                                        if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                            return Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyid!=null){
                                                        if(s1.getAttribute("id").equals(jyid)){
                                                            return Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyids!=null){
                                                        if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else{
                                        return Integer.valueOf(s.getAttribute("num"));
                                    }
                                }
                            }else if(jyid!=null||jyids!=null){
                                if(s.getTagName().equals("s")){
                                    if(jyids!=null&&jyid!=null){
                                        if(jyids.contains(Integer.valueOf(jyid))&&s.getAttribute("id").equals(jyid)){
                                            return Integer.valueOf(s.getAttribute("num"));
                                        }
                                    }else if(jyid!=null){
                                        if(s.getAttribute("id").equals(jyid)){
                                            return Integer.valueOf(s.getAttribute("num"));
                                        }
                                    }else if(jyids!=null){
                                        if(jyids.contains(Integer.valueOf(s.getAttribute("id")))){
                                            num+=Integer.valueOf(s.getAttribute("num"));
                                        }
                                    }
                                }
                            }
                        }
                    }

                    return num;
                }
            }
        }
        else {
            NodeList sName = doc.getElementsByTagName("m");
            for (int i = 0; i < sName.getLength(); i++) {
                Element m = (Element) sName.item(i);
                if(!m.getAttribute("date").isEmpty()){
                    Date d=DATE.parse(m.getAttribute("date"));
                    if((start==null||!d.before(DATE.parse(start)))&&(end==null||!d.after(DATE.parse(end))&&(yf==null||TIMEMIAO2.format(d).equals(yf)))){
                        if(jyid==null&&jyids==null&&jgid==null&&wwgids==null&&wwgid==null){
                            num+=Integer.valueOf(m.getAttribute("num"));
                        }else{
                            NodeList pers = m.getChildNodes();
                            for (int j = 0; j < pers.getLength(); j++) {
                                Node proNode = pers.item(j);
                                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element s = (Element) proNode;
                                    if(wwgid!=null){
                                        if(s.getTagName().equals("wwg")&&s.getAttribute("id").equals(wwgid)){
                                            if(jyid!=null||jyids!=null){
                                                NodeList pros = proNode.getChildNodes();
                                                for (int k = 0; k < pros.getLength(); k++) {
                                                    Node sNode = pros.item(k);
                                                    if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                        Element s1 = (Element) sNode;
                                                        if(s1.getTagName().equals("s")){
                                                            if(jyids!=null&&jyid!=null){
                                                                if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyid!=null){
                                                                if(s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyids!=null){
                                                                if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }else{
                                                num+=Integer.valueOf(s.getAttribute("num"));
                                            }
                                        }

                                    }
                                    else if(wwgids!=null){
                                        if(s.getTagName().equals("wwg")&&wwgids.contains(Integer.valueOf(s.getAttribute("id")))){
                                            if(jyid!=null||jyids!=null){
                                                NodeList pros = proNode.getChildNodes();
                                                for (int k = 0; k < pros.getLength(); k++) {
                                                    Node sNode = pros.item(k);
                                                    if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                        Element s1 = (Element) sNode;
                                                        if(s1.getTagName().equals("s")){
                                                            if(jyids!=null&&jyid!=null){
                                                                if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyid!=null){
                                                                if(s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyids!=null){
                                                                if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }else{
                                                num+=Integer.valueOf(s.getAttribute("num"));
                                            }
                                        }

                                    }
                                    else if(jgid!=null){
                                        if(s.getTagName().equals("jg")&&s.getAttribute("id").equals(jgid)){
                                            if(jyid!=null||jyids!=null){
                                                NodeList pros = proNode.getChildNodes();
                                                for (int k = 0; k < pros.getLength(); k++) {
                                                    Node sNode = pros.item(k);
                                                    if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                        Element s1 = (Element) sNode;
                                                        if(s1.getTagName().equals("s")){
                                                            if(jyids!=null&&jyid!=null){
                                                                if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyid!=null){
                                                                if(s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyids!=null){
                                                                if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }else{
                                                num+=Integer.valueOf(s.getAttribute("num"));
                                            }
                                        }
                                    }else if(jyid!=null||jyids!=null){
                                        if(s.getTagName().equals("s")){
                                            if(jyids!=null&&jyid!=null){
                                                if(jyids.contains(Integer.valueOf(jyid))&&s.getAttribute("id").equals(jyid)){
                                                    num+=Integer.valueOf(s.getAttribute("num"));
                                                }
                                            }else if(jyid!=null){
                                                if(s.getAttribute("id").equals(jyid)){
                                                    num+=Integer.valueOf(s.getAttribute("num"));
                                                }
                                            }else if(jyids!=null){
                                                if(jyids.contains(Integer.valueOf(s.getAttribute("id")))){
                                                    num+=Integer.valueOf(s.getAttribute("num"));
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
            return num;
        }
//        System.out.println("num：" + sName.getLength());
        return num;
    }
    public List<menu> getMenulist1(String yf, String jyid, List<Integer> jyids, String start, String end, List<Integer> jgids, String jgid, List<Integer> wwgids, String wwgid) throws ParseException {
        List<menu> list=new ArrayList();
        menu menu=new menu();
        String d="";
        // 获取DOM树s节点
        NodeList peritem = doc.getElementsByTagName("m");
        for (int i = 0; i < peritem.getLength(); i++) {
            menu=new menu();
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            Element element = (Element) peritem.item(i);
            // 获取第i个per元素的id属性
            if(!element.getAttribute("date").isEmpty())d=element.getAttribute("date");
            if((start!=null&&DATE.parse(d).before(DATE.parse(start)))||(end!=null&&DATE.parse(d).after(DATE.parse(end))||(yf!=null&&!TIMEMIAO2.format(d).equals(yf)))){
                continue;
            }
            menu.setYf(d);
            //System.out.println(menu.getYf());
//            if(jyid==null&&jyids==null&&jgids==null&&jgid==null&&wwgids==null&&wwgid==null){
            if(jyid==null&&jyids==null&&jgids==null&&jgid==null){
                menu.setNum(Integer.valueOf(element.getAttribute("num")));
            }
            else{
                int num=0;
                // 获得所有的子节点
                NodeList pers = element.getChildNodes();
                for (int j = 0; j < pers.getLength(); j++) {
                    Node proNode = pers.item(j);
                    // 判断是否是元素节点(使用getChildNodes()就要判断)
                    if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element pro = (Element) proNode;
                        /*if(wwgids!=null||wwgid!=null){
                            if(pro.getTagName().equals("wwg")){
                                if(jyid!=null||jyids!=null){
                                    if(wwgid!=null&&wwgid.equals(pro.getAttribute("id"))){
                                        NodeList pros = proNode.getChildNodes();
                                        for (int k = 0; k < pros.getLength(); k++) {
                                            Node sNode = pros.item(k);
                                            if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element s1 = (Element) sNode;
                                                if(s1.getTagName().equals("s")){
                                                    if(jyids!=null&&jyid!=null){
                                                        if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyid!=null){
                                                        if(s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyids!=null){
                                                        if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else if(wwgids!=null&&wwgids.contains(Integer.valueOf(pro.getAttribute("id")))){
                                        NodeList pros = proNode.getChildNodes();
                                        for (int k = 0; k < pros.getLength(); k++) {
                                            Node sNode = pros.item(k);
                                            if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element s1 = (Element) sNode;
                                                if(s1.getTagName().equals("s")){
                                                    if(jyids!=null&&jyid!=null){
                                                        if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyid!=null){
                                                        if(s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyids!=null){
                                                        if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                else if(wwgid!=null&&wwgid.equals(pro.getAttribute("id"))){
                                    num+=Integer.valueOf(pro.getAttribute("num"));
                                }else if(wwgids!=null&&wwgids.contains(Integer.valueOf(pro.getAttribute("id")))){
                                    num+=Integer.valueOf(pro.getAttribute("num"));
                                }
                            }
                        }
                        else*/ if((jgid!=null||jgids!=null)){
                            if(pro.getTagName().equals("jg")){
                                if(jyid!=null||jyids!=null){
                                    if(jgid!=null&&jgid.equals(pro.getAttribute("id"))){
                                        NodeList pros = proNode.getChildNodes();
                                        for (int k = 0; k < pros.getLength(); k++) {
                                            Node sNode = pros.item(k);
                                            if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element s1 = (Element) sNode;
                                                if(s1.getTagName().equals("s")){
                                                    if(jyids!=null&&jyid!=null){
                                                        if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyid!=null){
                                                        if(s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyids!=null){
                                                        if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else if(jgids!=null&&jgids.contains(Integer.valueOf(pro.getAttribute("id")))){
                                        NodeList pros = proNode.getChildNodes();
                                        for (int k = 0; k < pros.getLength(); k++) {
                                            Node sNode = pros.item(k);
                                            if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element s1 = (Element) sNode;
                                                if(s1.getTagName().equals("s")){
                                                    if(jyids!=null&&jyid!=null){
                                                        if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyid!=null){
                                                        if(s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyids!=null){
                                                        if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                else if(jgid!=null&&jgid.equals(pro.getAttribute("id"))){
                                    num+=Integer.valueOf(pro.getAttribute("num"));
                                }
                            }
                        }
                        else if(jyid!=null||jyids!=null){
                            if(pro.getTagName().equals("s")){
                                if(jyids!=null&&jyid!=null){
                                    if(jyids.contains(Integer.valueOf(jyid))&&pro.getAttribute("id").equals(jyid)){
                                        num+=Integer.valueOf(pro.getAttribute("num"));
                                    }
                                }else if(jyid!=null){
                                    if(pro.getAttribute("id").equals(jyid)){
                                        num+=Integer.valueOf(pro.getAttribute("num"));
                                    }
                                }else if(jyids!=null){
                                    if(jyids.contains(Integer.valueOf(pro.getAttribute("id")))){
                                        num+=Integer.valueOf(pro.getAttribute("num"));
                                    }
                                }
                            }
                        }
                    }
                }
                menu.setNum(num);
            }
            if(menu.getNum()>0)list.add(menu);
        }
        return list;
    }
    public Integer getNumjd(String yf, String jyid, List<Integer> jyids, String start, String end,String jdid,String jgid,String wgid, String wwgid) throws ParseException {
        // 获取DOM树s节点
        Integer num=0;
        if(yf==null&&start==null&&end==null){
            NodeList sName = doc.getElementsByTagName("size");
            for (int i = 0; i < sName.getLength(); i++) {
                Element size = (Element) sName.item(i);
                if(jyid==null&&jyids==null&&jdid==null&&jgid==null&&wgid==null&&wwgid==null){
                    return Integer.valueOf(size.getAttribute("num"));
                }else{
                    NodeList pers = size.getChildNodes();
                    for (int j = 0; j < pers.getLength(); j++) {
                        Node proNode = pers.item(j);
                        if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element s = (Element) proNode;
                            if(wwgid!=null){
                                if(s.getTagName().equals("wwg")&&s.getAttribute("id").equals(wwgid)){
                                    if(jyid!=null||jyids!=null){
                                        NodeList pros = proNode.getChildNodes();
                                        for (int k = 0; k < pros.getLength(); k++) {
                                            Node sNode = pros.item(k);
                                            if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element s1 = (Element) sNode;
                                                if(s.getTagName().equals("s")){
                                                    if(jyids!=null&&jyid!=null){
                                                        if(jyids.contains(Integer.valueOf(jyid))&&s.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s.getAttribute("num"));
                                                        }
                                                    }else if(jyid!=null){
                                                        if(s.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s.getAttribute("num"));
                                                        }
                                                    }else if(jyids!=null){
                                                        if(jyids.contains(Integer.valueOf(s.getAttribute("id")))){
                                                            num+=Integer.valueOf(s.getAttribute("num"));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else{
                                        return Integer.valueOf(s.getAttribute("num"));
                                    }
                                }
                            }
                            else if(wgid!=null){
                                if(s.getTagName().equals("wg")&&s.getAttribute("id").equals(wgid)){
                                    if(jyid!=null||jyids!=null){
                                        NodeList pros = proNode.getChildNodes();
                                        for (int k = 0; k < pros.getLength(); k++) {
                                            Node sNode = pros.item(k);
                                            if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element s1 = (Element) sNode;
                                                if(s1.getTagName().equals("s")){
                                                    if(jyids!=null&&jyid!=null){
                                                        if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyid!=null){
                                                        if(s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyids!=null){
                                                        if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else{
                                        return Integer.valueOf(s.getAttribute("num"));
                                    }
                                }
                            }
                            else if(jgid!=null){
                                if(s.getTagName().equals("jg")&&s.getAttribute("id").equals(jgid)){
                                    if(jyid!=null||jyids!=null){
                                        NodeList pros = proNode.getChildNodes();
                                        for (int k = 0; k < pros.getLength(); k++) {
                                            Node sNode = pros.item(k);
                                            if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element s1 = (Element) sNode;
                                                if(s1.getTagName().equals("s")){
                                                    if(jyids!=null&&jyid!=null){
                                                        if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyid!=null){
                                                        if(s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyids!=null){
                                                        if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else{
                                        return Integer.valueOf(s.getAttribute("num"));
                                    }
                                }
                            }
                            else if(jdid!=null){
                                if(s.getTagName().equals("jd")&&s.getAttribute("id").equals(jdid)){
                                    if(jyid!=null||jyids!=null){
                                        NodeList pros = proNode.getChildNodes();
                                        for (int k = 0; k < pros.getLength(); k++) {
                                            Node sNode = pros.item(k);
                                            if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element s1 = (Element) sNode;
                                                if(s1.getTagName().equals("s")){
                                                    if(jyids!=null&&jyid!=null){
                                                        if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyid!=null){
                                                        if(s1.getAttribute("id").equals(jyid)){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }else if(jyids!=null){
                                                        if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                            num+=Integer.valueOf(s1.getAttribute("num"));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else{
                                        return Integer.valueOf(s.getAttribute("num"));
                                    }
                                }
                            }else if(jyid!=null||jyids!=null){
                                if(s.getTagName().equals("s")){
                                    if(jyids!=null&&jyid!=null){
                                        if(jyids.contains(Integer.valueOf(jyid))&&s.getAttribute("id").equals(jyid)){
                                            num+=Integer.valueOf(s.getAttribute("num"));
                                        }
                                    }else if(jyid!=null){
                                        if(s.getAttribute("id").equals(jyid)){
                                            num+=Integer.valueOf(s.getAttribute("num"));
                                        }
                                    }else if(jyids!=null){
                                        if(jyids.contains(Integer.valueOf(s.getAttribute("id")))){
                                            num+=Integer.valueOf(s.getAttribute("num"));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return num;
                }
            }
        }
        else {
            NodeList sName = doc.getElementsByTagName("m");
            for (int i = 0; i < sName.getLength(); i++) {
                Element m = (Element) sName.item(i);
                if(!m.getAttribute("date").isEmpty()){
                    Date d=DATE.parse(m.getAttribute("date"));
                    if((start==null||!d.before(DATE.parse(start)))&&(end==null||!d.after(DATE.parse(end))&&(yf==null||TIMEMIAO2.format(d).equals(yf)))){
                        if(jyid==null&&jyids==null&&jdid==null&&jgid==null&&wgid==null&&wwgid==null){
                            num+=Integer.valueOf(m.getAttribute("num"));
                        }else{
                            NodeList pers = m.getChildNodes();
                            for (int j = 0; j < pers.getLength(); j++) {
                                Node proNode = pers.item(j);
                                if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element s = (Element) proNode;
                                    if(wwgid!=null){
                                        if(s.getTagName().equals("wwg")&&s.getAttribute("id").equals(wwgid)){
                                            if(jyid!=null||jyids!=null){
                                                NodeList pros = proNode.getChildNodes();
                                                for (int k = 0; k < pros.getLength(); k++) {
                                                    Node sNode = pros.item(k);
                                                    if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                        Element s1 = (Element) sNode;
                                                        if(s1.getTagName().equals("s")){
                                                            if(jyids!=null&&jyid!=null){
                                                                if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyid!=null){
                                                                if(s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyids!=null){
                                                                if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }else{
                                                num+=Integer.valueOf(s.getAttribute("num"));
                                            }
                                        }
                                    }
                                    else if(wgid!=null){
                                        if(s.getTagName().equals("wg")&&s.getAttribute("id").equals(wgid)){
                                            if(jyid!=null||jyids!=null){
                                                NodeList pros = proNode.getChildNodes();
                                                for (int k = 0; k < pros.getLength(); k++) {
                                                    Node sNode = pros.item(k);
                                                    if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                        Element s1 = (Element) sNode;
                                                        if(s1.getTagName().equals("s")){
                                                            if(jyids!=null&&jyid!=null){
                                                                if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyid!=null){
                                                                if(s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyids!=null){
                                                                if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }else{
                                                num+=Integer.valueOf(s.getAttribute("num"));
                                            }
                                        }
                                    }
                                    else if(jgid!=null){
                                        if(s.getTagName().equals("jg")&&s.getAttribute("id").equals(jgid)){
                                            if(jyid!=null||jyids!=null){
                                                NodeList pros = proNode.getChildNodes();
                                                for (int k = 0; k < pros.getLength(); k++) {
                                                    Node sNode = pros.item(k);
                                                    if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                        Element s1 = (Element) sNode;
                                                        if(s1.getTagName().equals("s")){
                                                            if(jyids!=null&&jyid!=null){
                                                                if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyid!=null){
                                                                if(s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyids!=null){
                                                                if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }else{
                                                num+=Integer.valueOf(s.getAttribute("num"));
                                            }
                                        }
                                    }
                                    else if(jdid!=null){
                                        if(s.getTagName().equals("jd")&&s.getAttribute("id").equals(jdid)){
                                            if(jyid!=null||jyids!=null){
                                                NodeList pros = proNode.getChildNodes();
                                                for (int k = 0; k < pros.getLength(); k++) {
                                                    Node sNode = pros.item(k);
                                                    if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                                        Element s1 = (Element) sNode;
                                                        if(s1.getTagName().equals("s")){
                                                            if(jyids!=null&&jyid!=null){
                                                                if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }else if(jyid!=null){
                                                                if(s1.getAttribute("id").equals(jyid)){
                                                                    num+=Integer.valueOf(s.getAttribute("num"));
                                                                }
                                                            }else if(jyids!=null){
                                                                if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                                    num+=Integer.valueOf(s1.getAttribute("num"));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }else{
                                                num+=Integer.valueOf(s.getAttribute("num"));
                                            }
                                        }
                                    }else if(jyid!=null||jyids!=null){
                                        if(s.getTagName().equals("s")){
                                            if(jyids!=null&&jyid!=null){
                                                if(jyids.contains(Integer.valueOf(jyid))&&s.getAttribute("id").equals(jyid)){
                                                    num+=Integer.valueOf(s.getAttribute("num"));
                                                }
                                            }else if(jyid!=null){
                                                if(s.getAttribute("id").equals(jyid)){
                                                    num+=Integer.valueOf(s.getAttribute("num"));
                                                }
                                            }else if(jyids!=null){
                                                if(jyids.contains(Integer.valueOf(s.getAttribute("id")))){
                                                    num+=Integer.valueOf(s.getAttribute("num"));
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
            return num;
        }
//        System.out.println("num：" + sName.getLength());
        return num;
    }
    public List<menu> getMenulist2(String yf, String jyid, List<Integer> jyids, String start, String end,String jdid,String jgid,String wgid, String wwgid) throws ParseException {
        List<menu> list=new ArrayList();
        menu menu=new menu();
        String d="";
        // 获取DOM树s节点
        NodeList peritem = doc.getElementsByTagName("m");
        for (int i = 0; i < peritem.getLength(); i++) {
            menu=new menu();
            // Element是Node的子类，用Element的getAttribute("属性名")获得元素属性
            Element element = (Element) peritem.item(i);
            // 获取第i个per元素的id属性
            if(!element.getAttribute("date").isEmpty())d=element.getAttribute("date");
            if((start!=null&&DATE.parse(d).before(DATE.parse(start)))||(end!=null&&DATE.parse(d).after(DATE.parse(end))||(yf!=null&&!TIMEMIAO2.format(d).equals(yf)))){
                continue;
            }
            menu.setYf(d);
            //System.out.println(menu.getYf());
            if(jyid==null&&jyids==null&&jdid==null&&jgid==null&&wgid==null&&wwgid==null){
                menu.setNum(Integer.valueOf(element.getAttribute("num")));
            }
            else{
                int num=0;
                // 获得所有的子节点
                NodeList pers = element.getChildNodes();
                for (int j = 0; j < pers.getLength(); j++) {
                    Node proNode = pers.item(j);
                    // 判断是否是元素节点(使用getChildNodes()就要判断)
                    if (proNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element pro = (Element) proNode;
                        if(wwgid!=null){
                            if(pro.getTagName().equals("wwg")&&wwgid.equals(pro.getAttribute("id"))){
                                if(jyid!=null||jyids!=null){
                                    NodeList pros = proNode.getChildNodes();
                                    for (int k = 0; k < pros.getLength(); k++) {
                                        Node sNode = pros.item(k);
                                        if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                            Element s1 = (Element) sNode;
                                            if(s1.getTagName().equals("s")){
                                                if(jyids!=null&&jyid!=null){
                                                    if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                        num+=Integer.valueOf(s1.getAttribute("num"));
                                                    }
                                                }else if(jyid!=null){
                                                    if(s1.getAttribute("id").equals(jyid)){
                                                        num+=Integer.valueOf(s1.getAttribute("num"));
                                                    }
                                                }else if(jyids!=null){
                                                    if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                        num+=Integer.valueOf(s1.getAttribute("num"));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else{
                                    num+=Integer.valueOf(pro.getAttribute("num"));
                                }
                            }

                        }
                        else if(wgid!=null){
                            if(pro.getTagName().equals("wg")&&wgid.equals(pro.getAttribute("id"))){
                                if(jyid!=null||jyids!=null){
                                    NodeList pros = proNode.getChildNodes();
                                    for (int k = 0; k < pros.getLength(); k++) {
                                        Node sNode = pros.item(k);
                                        if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                            Element s1 = (Element) sNode;
                                            if(s1.getTagName().equals("s")){
                                                if(jyids!=null&&jyid!=null){
                                                    if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                        num+=Integer.valueOf(s1.getAttribute("num"));
                                                    }
                                                }else if(jyid!=null){
                                                    if(s1.getAttribute("id").equals(jyid)){
                                                        num+=Integer.valueOf(s1.getAttribute("num"));
                                                    }
                                                }else if(jyids!=null){
                                                    if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                        num+=Integer.valueOf(s1.getAttribute("num"));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else{
                                    num+=Integer.valueOf(pro.getAttribute("num"));
                                }
                            }
                        }
                        else if(jgid!=null){
                            if(pro.getTagName().equals("jg")&&jgid.equals(pro.getAttribute("id"))){
                                if(jyid!=null||jyids!=null){
                                    NodeList pros = proNode.getChildNodes();
                                    for (int k = 0; k < pros.getLength(); k++) {
                                        Node sNode = pros.item(k);
                                        if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                            Element s1 = (Element) sNode;
                                            if(s1.getTagName().equals("s")){
                                                if(jyids!=null&&jyid!=null){
                                                    if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                        num+=Integer.valueOf(s1.getAttribute("num"));
                                                    }
                                                }else if(jyid!=null){
                                                    if(s1.getAttribute("id").equals(jyid)){
                                                        num+=Integer.valueOf(s1.getAttribute("num"));
                                                    }
                                                }else if(jyids!=null){
                                                    if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                        num+=Integer.valueOf(s1.getAttribute("num"));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else{
                                    num+=Integer.valueOf(pro.getAttribute("num"));
                                }
                            }
                        }
                        else if(jdid!=null){
                            if(pro.getTagName().equals("jd")&&jdid.equals(pro.getAttribute("id"))){
                                if(jyid!=null||jyids!=null){
                                    NodeList pros = proNode.getChildNodes();
                                    for (int k = 0; k < pros.getLength(); k++) {
                                        Node sNode = pros.item(k);
                                        if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                            Element s1 = (Element) sNode;
                                            if(s1.getTagName().equals("s")){
                                                if(jyids!=null&&jyid!=null){
                                                    if(jyids.contains(Integer.valueOf(jyid))&&s1.getAttribute("id").equals(jyid)){
                                                        num+=Integer.valueOf(s1.getAttribute("num"));
                                                    }
                                                }else if(jyid!=null){
                                                    if(s1.getAttribute("id").equals(jyid)){
                                                        num+=Integer.valueOf(s1.getAttribute("num"));
                                                    }
                                                }else if(jyids!=null){
                                                    if(jyids.contains(Integer.valueOf(s1.getAttribute("id")))){
                                                        num+=Integer.valueOf(s1.getAttribute("num"));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else{
                                    num+=Integer.valueOf(pro.getAttribute("num"));
                                }
                            }
                        }
                        else if((jyid!=null||jyids!=null)){
                            if(pro.getTagName().equals("s")){
                                if(jyids!=null&&jyid!=null){
                                    if(jyids.contains(Integer.valueOf(jyid))&&pro.getAttribute("id").equals(jyid)){
                                        num+=Integer.valueOf(pro.getAttribute("num"));
                                    }
                                }else if(jyid!=null){
                                    if(pro.getAttribute("id").equals(jyid)){
                                        num+=Integer.valueOf(pro.getAttribute("num"));
                                    }
                                }else if(jyids!=null){
                                    if(jyids.contains(Integer.valueOf(pro.getAttribute("id")))){
                                        num+=Integer.valueOf(pro.getAttribute("num"));
                                    }
                                }
                            }

                        }
                    }
                }
                menu.setNum(num);
            }
            if(menu.getNum()>0)list.add(menu);
        }
        return list;
    }
}
