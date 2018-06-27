package common;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.sf.json.JSONObject;

import org.apache.http.message.BasicNameValuePair;

public class Data {
	
	public static List<BasicNameValuePair> pase2List(String key,String value){
		
		ArrayList<BasicNameValuePair> parameter= new ArrayList<BasicNameValuePair>(); 
		parameter.add(new BasicNameValuePair(key,value));
			
		return parameter;		
	}
	
	public static List<BasicNameValuePair> map2List(HashMap map){
		
		ArrayList<BasicNameValuePair> parameter= new ArrayList<BasicNameValuePair>(); 
		Iterator<?> iterator = map.keySet().iterator();
		
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            String value = (String) map.get(key);
            parameter.add(new BasicNameValuePair(key,value));
        }
			
		return parameter;		
	}
	
//	      private static void printAllProperty(Properties props)  
//	      {  
//	          @SuppressWarnings("rawtypes")  
//	          Enumeration en = props.propertyNames();  
//	          while (en.hasMoreElements())  
//	          {  
//	              String key = (String) en.nextElement();  
//	             String value = props.getProperty(key);  
//	              System.out.println(key + " : " + value);  
//	          }  
//	      }
//	   

}
