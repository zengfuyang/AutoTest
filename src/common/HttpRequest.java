/**
 * 
 */
package common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.dom4j.DocumentException;

/**
 * @author zengfuyang
 *
 */

public class HttpRequest {
	
	public static HttpResponse sendGet(String host,String parameter, Header[] header) throws ClientProtocolException, IOException{
		
		DefaultHttpClient client = new DefaultHttpClient();
		
		String url = host + "?" + parameter;
		System.out.println(url);
		HttpGet request = new HttpGet(url);
	
		boolean setcookies = false;
		if(header != null){
			
			for(int i = 0;i < header.length;i++){
//				System.out.println(header[i].getName());
//				System.out.println(header[i].getName() == "Set-Cookie");
				if(header[i].getName().equalsIgnoreCase("Set-Cookie")){
					setcookies =true;
					request.addHeader("Cookie",header[i].getValue());
					System.out.println("Set Cookies is : " + header[i].getValue());
				}	
			}
			
			if(setcookies == false){
				request.addHeader("Cookie","");
				System.out.println("Set a Cookies is : " + "");
			}
		}
		
		
		
		HttpResponse response = client.execute(request);
		
//		String strResult = EntityUtils.toString(response.getEntity());
//		Object jsonResult =  JSON.formatJson(strResult);	 
//		
//        System.out.println(jsonResult);
        client.close();	
        return response;
	}
	
	public static HttpResponse sendPost(String url,List<? extends NameValuePair> parameter,Header[] header) throws ClientProtocolException, IOException{
		
		DefaultHttpClient client = new DefaultHttpClient();
		System.out.println("The HTTP request URL is : " + url);
		System.out.println("The HTTP request parameter is : " + parameter);
		
		HttpPost request = new HttpPost(url);
		
		request.setEntity(new UrlEncodedFormEntity(parameter,HTTP.UTF_8));
		boolean setcookies = false;
		
		if(header != null){
			
			for(int i = 0;i < header.length;i++){
//				System.out.println(header[i].getName());
//				System.out.println(header[i].getName() == "Set-Cookie");
				if(header[i].getName().equalsIgnoreCase("Set-Cookie")){
					setcookies =true;
					request.addHeader("Cookie",header[i].getValue());
					System.out.println("Set Cookies is : " + header[i].getValue());
				}	
			}
			
			if(setcookies == false){
				request.addHeader("Cookie","");
				System.out.println("Set a Cookies is : " + "");
			}
		}
		
		HttpResponse response = client.execute(request);
		System.out.println("The HTTP response is : " + response);
		client.close();
		return response;
	}
	
	public static Header[] getCookies(String url,List<? extends NameValuePair> parameter) throws ClientProtocolException, IOException{
		
//		System.out.println("The HTTP request URL is : " + url);
//		System.out.println("The HTTP request parameter is : " + parameter);
		
		HttpResponse response = HttpRequest.sendPost(url, parameter, null);
		
		Header[] header = response.getAllHeaders();
	    
		String str = EntityUtils.toString(response.getEntity());
	    System.out.println("The HTTP response String is : " + str);
	    
	    return header;
	    
	}
	
	public static JSONObject paseRespone(HttpResponse response) throws ParseException, IOException{
		
	    String str = EntityUtils.toString(response.getEntity());
	    System.out.println("The HTTP response String is : " + str);
	    
	    JSONObject jsonResult = null; 
	    JSONObject json = new JSONObject();
	    
	    if(str.contains("errno")){
		    	jsonResult =  JSON.formatJson(str);	
		    	return jsonResult;
		}

        return json.put("TestResult", str);	
	}
	
//	public static void closeHttp(){
//		client.close();
//	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String [] args) throws ClientProtocolException, IOException, DocumentException{
		
//		JSONObject rs = (JSONObject) HttpRequest.sendGet("http://106.14.80.121:8099/api/async/login?openid=5&appid=1&player_id=1&access_id=1&sign=6ac96d68d8798c5108d397cf9ac2ea304a75487f");
//		System.out.println(rs);
		
		
//        JSONObject json = new JSONObject();
//
//		json.put("appid", "3011682648");
//		json.put("appuserid", "598012aae7798909b2294f93");
//		json.put("cporderid", "2017080911203442976154");
//		json.put("cpprivate", "");
//		json.put("currency", "RMB");
//		json.put("feetype", 0);
//		json.put("money", 100);
//		json.put("paytype", 403);
//		json.put("result", 0);
//		json.put("transid", "32021708091120349269");
//		json.put("transtime", "2017-08-09 11:20:49");
//		json.put("transtype", 0);
//		json.put("waresid", 1);
//		
//		JSONObject par = new JSONObject();
//		par.put("transdata", json);
//		par.put("sign", "B8v0ID9ytxMzuSVt7lN1vH7RcjgzS5HypB/AHUvqe+Jrx48YV5adckJG/bag6b674b9TeKP+KKwqfz886ybfOzkC71TmfjNenEWRt/3v6beQ/vs/wydFv2cCCLLMuJ43mOxRh9GR3yzKFwQNSSsdp91OE22ZTWQaWiYaowrjesY=");
//		par.put("signtype", "RSA");
//		
////		
////		JSONArray jsonArray = JSONArray.fromObject(par);
////		
////		JSONObject jsonObject = new JSONObject(par);
//        Iterator iterator = par.keys();
//        while(iterator.hasNext()){
//            String key = (String) iterator.next();
//            String value = par.getString(key);
//            System.out.println(key);
//            System.out.println(value);
//        }
//		int i;
//		System.out.println(jsonArray.length());
//		for(i=0;i<jsonArray.length();i++){
//			System.out.println();
//			
//		}
	
		
		
//		ArrayList parameter= new ArrayList(); 
//		
//		//parameter.add(new BasicNameValuePair("transdata",json.toString()));  
//		parameter.add(new BasicNameValuePair("sign","1"));  
//		parameter.add(new BasicNameValuePair("signtype","RSA"));
//		
//		Object res =  HttpRequest.sendPost("http://develop.growth.happyplaygame.net/pay/aibei/callback", parameter);
//		System.out.println(res);
		JSONObject login = XML.xml2Json("./src/TestData/Login.xml");
		//String res =  HttpRequest.sendPostLogin( "http://develop.growth.happyplaygame.net/agent/login" + "/agent/login", JSON.json2List(login));
		
		
	}
	

}
