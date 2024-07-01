package com.fangx.until;

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
