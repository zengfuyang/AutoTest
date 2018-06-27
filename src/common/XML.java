package common;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XML {
	
	public static Element readXML(String file) throws DocumentException{
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(file));
		Element root = document.getRootElement();
		
		return root;
		
	}
	
	public static JSONObject xml2Json(String file) throws DocumentException{
		Element root = XML.readXML(file);
		JSONObject json = new JSONObject();
		List<Element> list = root.elements();
	
		if(list.size()<=0){
			return json;
		}
		for(Element e:list){
			
			JSONObject jsonResult = XML.findSubElement(file,e.getName());
			if(jsonResult.length() != 0){
				json.put(e.getName(), jsonResult);
				continue;
			}
			json.put(e.getName(), e.getData());
		}
		return json;
	}
	
	/*
	 * �η���Ŀǰֻ֧��2�����ṹ��Ŀǰ��������Ҫ��֮�������Ż�
	 * */
	public static  JSONObject findSubElement(String file, String element) throws DocumentException{
		Element root = XML.readXML(file);
		Element contactElem = root.element(element);
		List<Element> contactList = contactElem.elements();
		JSONObject json = new JSONObject();
		
		if(contactList.size()<=0){
			return json;
			
		}
		JSONObject json2 = new JSONObject();
		for (Element e:contactList){
			json.put(e.getName(), e.getData());
		 }
		return json;
		
	}

}
