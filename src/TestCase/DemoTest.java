/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCase;

import Demo.Demo;
import common.Environment;
import common.HttpRequest;
import common.XML;
import java.io.IOException;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.dom4j.DocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author LEWANgame
 */
public class DemoTest {

    String host = "";

    @Test
    public void activityTest() throws ClientProtocolException, DocumentException, IOException {

        Demo demo = new Demo();

        JSONObject parms = XML.xml2Json(Environment.getConfigPath() + "Demo.xml");

        HttpResponse res = demo.demo(host, parms);

        JSONObject res_json = HttpRequest.paseRespone(res);

        Assert.assertEquals(res_json.get("errno"), 0, res.toString());

    }

    @BeforeTest
    public void beforeTest() throws DocumentException, ClientProtocolException, IOException {
        host = Environment.getHost("activity");

    }

    @AfterTest
    public void afterTest() throws ClientProtocolException, DocumentException, IOException {

    }

}
