package com.efx.quality.wx;

import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;
/**
 * 
 * */
public class XMLUtils {
	/**
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static String getRequestXml(TreeMap<String, String> parameters)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if ("mch_id".equalsIgnoreCase(k) || "nonce_str".equalsIgnoreCase(k)
					|| "sign".equalsIgnoreCase(k)) {
				sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
			} else {
				sb.append("<" + k + ">" + v + "</" + k + ">");
			}
		}
		sb.append("</xml>");
		return sb.toString();
	}

	@SuppressWarnings("unchecked")
	public static String Progress_resultParseXml(String xml) {
		String publicKey = null;
		try {
			StringReader read = new StringReader(xml);
		
			InputSource source = new InputSource(read);
		
			SAXBuilder sb = new SAXBuilder();
		
			org.jdom2.Document doc;
			doc = (org.jdom2.Document) sb.build(source);

			org.jdom2.Element root = doc.getRootElement();
			List<org.jdom2.Element> list = root.getChildren();
			
			if (list != null && list.size() > 0) {
				for (org.jdom2.Element element : list) {
					if("pub_key".equals(element.getName())){
						publicKey=element.getText();
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return publicKey;
	}
}