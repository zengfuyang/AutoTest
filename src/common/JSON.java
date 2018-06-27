package common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.dom4j.DocumentException;

import net.sf.json.JSONObject;

public class JSON {
	
	public static JSONObject formatJson(String string){
		
		JSONObject jsonResult = null;
		JSONObject json = new JSONObject();
		
		try{
			jsonResult = JSONObject.fromObject(string);
		}catch(Exception e){
			return json.put("TestResult",string);
		}
		
		return jsonResult;
	}
	
	public static List<BasicNameValuePair> json2List(JSONObject json){
		
		ArrayList<BasicNameValuePair> parameter= new ArrayList<BasicNameValuePair>(); 
		Iterator<?> iterator = json.keys();
		
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            String value = json.getString(key);
            parameter.add(new BasicNameValuePair(key,value));
        }
			
		return parameter;		
	}
	
	public static String JSON2ParameterString(JSONObject json){
		
		String parameter = "";
		Iterator<?> iterator = json.keys();
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            String value = json.getString(key);
            parameter = parameter + key + "=" + value + "&";
        }
		
		return parameter;
		
	}
	
	public static void main(String args[]) throws DocumentException{
		
		JSONObject deleteagent = XML.xml2Json(Environment.getConfigPath() + "Deleteagent.xml");
		String s = JSON.JSON2ParameterString(deleteagent);
		System.out.println(s);
	}

}
