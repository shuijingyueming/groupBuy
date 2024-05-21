package com.efx.quality.until;

import com.efx.quality.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * Document生成XML
 * @author ouyangjun
 */
public class CreateDocument {

    public static void main(String[] args) {
        // 执行Document生成XML方法
        createDocument(new File("E:\\person.xml"));
    }

    public static void createDocumentxhh(File file, List<String> codes, List<menu> mlist, String size, List<cdyhe> wdlist, List<cdusg> jdlist, List<cdusd> jglist, List<cdusc> wglist, List<cdusb> wwglist) {
        try {
            // 初始化一个XML解析工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // 创建一个DocumentBuilder实例
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 构建一个Document实例
            Document doc = builder.newDocument();
            doc.setXmlStandalone(true);
            // standalone用来表示该文件是否呼叫其它外部的文件。若值是 ”yes” 表示没有呼叫外部文件

            // 创建一个根节点
            // 说明: doc.createElement("元素名")、element.setAttribute("属性名","属性值")、element.setTextContent("标签间内容")

                Element element = doc.createElement("root");
                element.setAttribute("attr", "root");
                if(codes!=null){
                    for(String s:codes){
                        // 创建根节点第一个子节点
                        Element elementChildOne = doc.createElement("s");
                        elementChildOne.setTextContent(s);
                        element.appendChild(elementChildOne);
                    }
                }
                if(mlist!=null&&size!=null){
                    for(menu m:mlist){
                        // 创建根节点第一个子节点
                        Element elementChildTwo = doc.createElement("m");
                        elementChildTwo.setAttribute("date", m.getYf());
                        elementChildTwo.setAttribute("num", String.valueOf(m.getNum()));
                        element.appendChild(elementChildTwo);
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
                        if(m.getJdlist()!=null){
                            for(cdusg usg :m.getJdlist()){
                                if(usg.getNum()>0){
                                    Element elementChildTwo1 = doc.createElement("jd");
                                    elementChildTwo1.setAttribute("id", usg.getUsg001().toString());
                                    elementChildTwo1.setAttribute("num", String.valueOf(usg.getNum()));
                                    elementChildTwo.appendChild(elementChildTwo1);
                                    if(usg.getWdlist()!=null){
                                        for(cdyhe yhe:usg.getWdlist()){
                                            if(yhe.getNum()>0){
                                                Element elementChildTwo2 = doc.createElement("d");
                                                elementChildTwo2.setAttribute("id", yhe.getYhe001().toString());
                                                elementChildTwo2.setAttribute("num", String.valueOf(yhe.getNum()));
                                                elementChildTwo1.appendChild(elementChildTwo2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(m.getJglist()!=null){
                            for(cdusd usd :m.getJglist()){
                                if(usd.getNum()>0){
                                    Element elementChildTwo1 = doc.createElement("jg");
                                    elementChildTwo1.setAttribute("id", usd.getUsd001().toString());
                                    elementChildTwo1.setAttribute("num", String.valueOf(usd.getNum()));
                                    elementChildTwo.appendChild(elementChildTwo1);
                                    if(usd.getWdlist()!=null){
                                        for(cdyhe yhe:usd.getWdlist()){
                                            if(yhe.getNum()>0){
                                                Element elementChildTwo2 = doc.createElement("g");
                                                elementChildTwo2.setAttribute("id", yhe.getYhe001().toString());
                                                elementChildTwo2.setAttribute("num", String.valueOf(yhe.getNum()));
                                                elementChildTwo1.appendChild(elementChildTwo2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(m.getWglist()!=null){
                            for(cdusc usc:m.getWglist()){
                                if(usc.getNum()>0){
                                    Element elementChildTwo1 = doc.createElement("wg");
                                    elementChildTwo1.setAttribute("id", usc.getUsc001().toString());
                                    elementChildTwo1.setAttribute("num", String.valueOf(usc.getNum()));
                                    elementChildTwo.appendChild(elementChildTwo1);
                                    if(usc.getWdlist()!=null){
                                        for(cdyhe yhe:usc.getWdlist()){
                                            if(yhe.getNum()>0){
                                                Element elementChildTwo2 = doc.createElement("w");
                                                elementChildTwo2.setAttribute("id", yhe.getYhe001().toString());
                                                elementChildTwo2.setAttribute("num", String.valueOf(yhe.getNum()));
                                                elementChildTwo1.appendChild(elementChildTwo2);
                                            }
                                        }
                                    }
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
                                    if(usb.getWdlist()!=null){
                                        for(cdyhe yhe:usb.getWdlist()){
                                            if(yhe.getNum()>0){
                                                Element elementChildTwo2 = doc.createElement("ww");
                                                elementChildTwo2.setAttribute("id", yhe.getYhe001().toString());
                                                elementChildTwo2.setAttribute("num", String.valueOf(yhe.getNum()));
                                                elementChildTwo1.appendChild(elementChildTwo2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Element elementChildOne = doc.createElement("size");
                    elementChildOne.setAttribute("num", size);
                    if(wdlist!=null){
                        for(cdyhe yhe:wdlist){
                            if(yhe.getNum()>0) {
                                Element elementChildOne1 = doc.createElement("s");
                                elementChildOne1.setAttribute("id", yhe.getYhe001().toString());
                                elementChildOne1.setAttribute("num", String.valueOf(yhe.getNum()));
                                elementChildOne.appendChild(elementChildOne1);
                            }
                        }
                    }
                    if(jdlist!=null){
                        for(cdusg usg :jdlist){
                            if(usg.getNum()>0){
                                Element elementChildOne1 = doc.createElement("jd");
                                elementChildOne1.setAttribute("id", usg.getUsg001().toString());
                                elementChildOne1.setAttribute("num", String.valueOf(usg.getNum()));
                                elementChildOne.appendChild(elementChildOne1);
                                if(usg.getWdlist()!=null){
                                    for(cdyhe yhe:usg.getWdlist()){
                                        if(yhe.getNum()>0){
                                            Element elementChildTwo2 = doc.createElement("d");
                                            elementChildTwo2.setAttribute("id", yhe.getYhe001().toString());
                                            elementChildTwo2.setAttribute("num", String.valueOf(yhe.getNum()));
                                            elementChildOne1.appendChild(elementChildTwo2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(jglist!=null){
                        for(cdusd usd :jglist){
                            if(usd.getNum()>0){
                                Element elementChildOne1 = doc.createElement("jg");
                                elementChildOne1.setAttribute("id", usd.getUsd001().toString());
                                elementChildOne1.setAttribute("num", String.valueOf(usd.getNum()));
                                elementChildOne.appendChild(elementChildOne1);
                                if(usd.getWdlist()!=null){
                                    for(cdyhe yhe:usd.getWdlist()){
                                        if(yhe.getNum()>0){
                                            Element elementChildTwo2 = doc.createElement("g");
                                            elementChildTwo2.setAttribute("id", yhe.getYhe001().toString());
                                            elementChildTwo2.setAttribute("num", String.valueOf(yhe.getNum()));
                                            elementChildOne1.appendChild(elementChildTwo2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(wglist!=null){
                        for(cdusc usc:wglist){
                            if(usc.getNum()>0){
                                Element elementChildOne1 = doc.createElement("wg");
                                elementChildOne1.setAttribute("id", usc.getUsc001().toString());
                                elementChildOne1.setAttribute("num", String.valueOf(usc.getNum()));
                                elementChildOne.appendChild(elementChildOne1);
                                if(usc.getWdlist()!=null){
                                    for(cdyhe yhe:usc.getWdlist()){
                                        if(yhe.getNum()>0){
                                            Element elementChildOne2 = doc.createElement("w");
                                            elementChildOne2.setAttribute("id", yhe.getYhe001().toString());
                                            elementChildOne2.setAttribute("num", String.valueOf(yhe.getNum()));
                                            elementChildOne1.appendChild(elementChildOne2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(wwglist!=null){
                        for(cdusb usb:wwglist){
                            if(usb.getNum()>0){
                                Element elementChildOne1 = doc.createElement("wwg");
                                elementChildOne1.setAttribute("id", usb.getUsb001().toString());
                                elementChildOne1.setAttribute("num", String.valueOf(usb.getNum()));
                                elementChildOne.appendChild(elementChildOne1);
                                if(usb.getWdlist()!=null){
                                    for(cdyhe yhe:usb.getWdlist()){
                                        if(yhe.getNum()>0){
                                            Element elementChildTwo2 = doc.createElement("ww");
                                            elementChildTwo2.setAttribute("id", yhe.getYhe001().toString());
                                            elementChildTwo2.setAttribute("num", String.valueOf(yhe.getNum()));
                                            elementChildOne1.appendChild(elementChildTwo2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    element.appendChild(elementChildOne);
                }
            // 添加根节点
                doc.appendChild(element);



            // 把构造的XML结构，写入到具体的文件中
            TransformerFactory formerFactory=TransformerFactory.newInstance();
            Transformer transformer=formerFactory.newTransformer();
            // 换行
            transformer.setOutputProperty(OutputKeys.INDENT, "YES");
            // 文档字符编码
            transformer.setOutputProperty(OutputKeys.ENCODING, "GB2312");

            // 可随意指定文件的后缀,效果一样,但xml比较好解析,比如: E:\\person.txt等
            transformer.transform(new DOMSource(doc), new StreamResult(file.toURI().getPath()));

            System.out.println("XML CreateDocument success!");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void createDocument(File file) {
        try {
            // 初始化一个XML解析工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // 创建一个DocumentBuilder实例
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 构建一个Document实例
            Document doc = builder.newDocument();
            doc.setXmlStandalone(true);
            // standalone用来表示该文件是否呼叫其它外部的文件。若值是 ”yes” 表示没有呼叫外部文件

            // 创建一个根节点
            // 说明: doc.createElement("元素名")、element.setAttribute("属性名","属性值")、element.setTextContent("标签间内容")
            Element element = doc.createElement("root");
            element.setAttribute("attr", "root");

            // 创建根节点第一个子节点
            Element elementChildOne = doc.createElement("person");
            elementChildOne.setAttribute("attr", "personOne");
            element.appendChild(elementChildOne);

            // 第一个子节点的第一个子节点
            Element childOneOne = doc.createElement("people");
            childOneOne.setAttribute("attr", "peopleOne");
            childOneOne.setTextContent("attr peopleOne");
            elementChildOne.appendChild(childOneOne);

            // 第一个子节点的第二个子节点
            Element childOneTwo = doc.createElement("people");
            childOneTwo.setAttribute("attr", "peopleTwo");
            childOneTwo.setTextContent("attr peopleTwo");
            elementChildOne.appendChild(childOneTwo);

            // 创建根节点第二个子节点
            Element elementChildTwo = doc.createElement("person");
            elementChildTwo.setAttribute("attr", "personTwo");
            element.appendChild(elementChildTwo);

            // 第二个子节点的第一个子节点
            Element childTwoOne = doc.createElement("people");
            childTwoOne.setAttribute("attr", "peopleOne");
            childTwoOne.setTextContent("attr peopleOne");
            elementChildTwo.appendChild(childTwoOne);

            // 第二个子节点的第二个子节点
            Element childTwoTwo = doc.createElement("people");
            childTwoTwo.setAttribute("attr", "peopleTwo");
            childTwoTwo.setTextContent("attr peopleTwo");
            elementChildTwo.appendChild(childTwoTwo);

            // 添加根节点
            doc.appendChild(element);

            // 把构造的XML结构，写入到具体的文件中
            TransformerFactory formerFactory=TransformerFactory.newInstance();
            Transformer transformer=formerFactory.newTransformer();
            // 换行
            transformer.setOutputProperty(OutputKeys.INDENT, "YES");
            // 文档字符编码
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

            // 可随意指定文件的后缀,效果一样,但xml比较好解析,比如: E:\\person.txt等
            transformer.transform(new DOMSource(doc),new StreamResult(file));

            System.out.println("XML CreateDocument success!");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
