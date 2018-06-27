/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import common.Environment;
import common.HttpRequest;
import common.JSON;
import common.XML;
import java.io.IOException;
import net.sf.json.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.dom4j.DocumentException;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author byangs
 */
public class Demo {
    
    public static void main(String[] args) throws DocumentException, IOException{
        
        //获取接口地址
        String host = Environment.getHost("activity");
        
        //获取参数
        JSONObject Demo = XML.xml2Json(Environment.getConfigPath() + "Demo.xml");
        
        //请求接口
        HttpResponse res = HttpRequest.sendPost( host + "/service/login", JSON.json2List(Demo),null);
        
        //获取登录之后的cookies
        //Header[] header =  HttpRequest.getCookies( host + "/agent/login", JSON.json2List(Demo));
        
        //处理返回结果
        JSONObject resjson = HttpRequest.paseRespone(res);
        
        System.out.println(resjson);
        
    }
    
    public HttpResponse demo(String host,JSONObject parms) throws IOException{
        
        HttpResponse res = HttpRequest.sendPost( host + "/service/login", JSON.json2List(parms),null);
        return res;    
    }
    
}
