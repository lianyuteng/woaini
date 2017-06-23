package site;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;
import javax.print.attribute.standard.PrinterLocation;

import org.apache.catalina.tribes.util.Arrays;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import site.dao.DaoUserInfo;
import site.entity.UserInfo;

public class TT {

	@Test
	public void hsee() {
		Logger logger = Logger.getLogger(TT.class);
		logger.setLevel(Level.INFO);
		logger.debug("nimei");
		logger.debug("woco");
		System.out.print("nihao");
		System.out.println("wocao");

		try {
			int i = 10 / 0;
		} catch (Exception e) {
			System.out.println("nimei");

		}

	}

	@Test
	public void hee() {

		JSONArray array = JSON.parseArray("WOCAO");
		for (int i = 0; i < array.size(); i++) {
			JSONObject js = array.getJSONObject(i);
			String username = js.getString("username");

		}

		JSONObject json = new JSONObject();
		json.put("userName", "lzw");
		json.put("passWord", "love");
		String sjson = json.toString();

		HttpClient httpClient = new DefaultHttpClient();
		String url = "http://172.16.0.244:8080/abc/login";
		HttpPost httpPost = new HttpPost(url);
		// 设置httpPost为json、utf-8格式
		httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
		// 封装json
		StringEntity se = new StringEntity(sjson, "UTF-8");
		httpPost.setEntity(se);
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpPost);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int code = httpResponse.getStatusLine().getStatusCode();
		if (code == 200) {

		} else {
			System.out.println(code);
		}

	}
}
