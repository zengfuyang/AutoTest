package common;

import org.dom4j.DocumentException;
import org.dom4j.Element;

import Config.Configration;

public class Environment {
	
	public static String ConfigHostForWindows = "./src/Config/" ;
	public static String ConfigHostForLinux = "/var/lib/jenkins/testng/autotest/src/Config/" ;
	
	public static String ConfigPathForWindows = "./src/TestData/" ;
	public static String ConfigPathForLinux = "/var/lib/jenkins/testng/autotest/src/TestData/" ;
	
	//public static String Cookies = "growth_user=T8FiS8HCy%2B5YTe34U2AvxE%2B2LeaNrgauKmYjwcf9TUkVEdWTcTZ5ln9xE7qrVytUc5Y8ZOQ%2B59wf33CQCU3mHN7MhxpJrA%2F3s6H9bXDFIFvbjq5qLYnXGf7QI%2F0URsu2mktuPrSMzIjyXM2hmpp%2Fe6yRNdY%3D; expires=Thu, 07-Sep-2017 10:25:40 GMT; Max-Age=28800; path=/";
	
	
	public static String getHost(String type) throws DocumentException{
		
		System.out.println("Start to get the Host... ");
		
		String host = "";
		
		if(type == "growth"){
			
			host = Configration.growth_HostUrl;
			
		}else if(type == "activity"){
			
			host = Configration.activity_HostUrl;
		}
		
		
		System.out.println("The Host is : " + host);
		
		return host;
	}
	
	public static String getConfigPath(){
		
		String path;
		if(Configration.Runplatform == "windows"){
			path = Environment.ConfigPathForWindows;
		}else{
			path = Environment.ConfigPathForLinux;
		}
		return path;
	}
	
	public static String getConfiHost(){
		
		String path;
		if(Configration.Runplatform == "windows"){
			path = Environment.ConfigHostForWindows;
		}else{
			path = Environment.ConfigHostForLinux;
		}
		return path;
	}
	
	public static void mian(String [] args) throws DocumentException{
		System.out.println(Environment.getHost("growth"));
	}

}
