package com.fangx.until;

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


public class ParseDocument {
    Document doc = null;// 创建一个Document对象

    public static void main(String[] args) {
        File file = new File("D:\\IdeaProjects\\quality\\target\\classes\\static\\upload\\ewm\\874d34107e4a433dbefb00302b602058.xml");
        String url="D:\\IdeaProjects\\quality\\target\\classes\\static\\upload\\ewm\\874d34107e4a433dbefb00302b602058.xml";
        ParseDocument xml = new ParseDocument();
        xml.getDocument(url);
//        xml.creatNode("s","100001");
//        xml.creatNode("s","101001");
//        xml.changeType("100002","10001");
//        xml.showInfo();
//        xml.deleteNode("100001");
//        xml.showInfo();
//        xml.saveXml(url);
//        System.out.println(xml.getNum());
    }
    public Integer getNum() {
        // 获取DOM树s节点
        NodeList sName = doc.getElementsByTagName("s");
//        System.out.println("num：" + sName.getLength());
        return sName.getLength();
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
            System.out.println(doc);
        } catch (ParserConfigurationException e) {
            
            e.printStackTrace();
        } catch (SAXException | IOException e) {
            
            e.printStackTrace();
        }

    }


    /**
     * 显示xml文档信息 ！
     */
    public void showInfo() {
        // 获取DOM树s节点
        NodeList sName = doc.getElementsByTagName("s");
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
    public void creatNode(String attr,String value) {
        // 创建s节点
        Element sEle = doc.createElement(attr);
        sEle.setTextContent(value);
        // 找到PhoneInfo节点
        NodeList PhoneInfosNode = doc.getElementsByTagName("root");
        for (int i = 0; i < PhoneInfosNode.getLength(); i++) {
            Node PhoneInfos = PhoneInfosNode.item(i);
            if (PhoneInfos.getNodeType() == Node.ELEMENT_NODE) {
                // 把三星节点挂到PhoneInfo上
                PhoneInfos.appendChild(sEle);
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
            
            e.printStackTrace();
        } catch (TransformerException e) {
            
            e.printStackTrace();
        } /*catch (FileNotFoundException e) {
            
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
        NodeList brandsEle = doc.getElementsByTagName("s");
        for (int i = 0; i < brandsEle.getLength(); i++) {
            Element brand = (Element) brandsEle.item(i);
            String text = brand.getTextContent();
            if(text.equals(name)){
                doc.getElementsByTagName("root").item(0).removeChild(brand);
            }

        }
    }
}
