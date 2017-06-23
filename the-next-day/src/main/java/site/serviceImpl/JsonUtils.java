package site.serviceImpl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

@Service
public class JsonUtils {

	/**
	 * @param reader
	 * @return map
	 * @throws IOException
	 */
	public Map<String, Object> JsonStringToMap(BufferedReader reader) throws IOException {
		StringBuilder builder = new StringBuilder();
		String temp = reader.readLine();
		while (null != temp) {

			builder.append(temp);
			temp = reader.readLine();
		}
		reader.close();

		if ("".equals(builder)) {

			throw new NullPointerException("参数为空");

		}

		String string = new String(builder);
		JSONObject json2 = new JSONObject();
		JSONObject json = json2.parseObject(string);

		String username = json.getString("username");
		String password = json.getString("password");
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		System.out.println(map.toString());
		return map;

	}

	@Test
	public void hee() {

		int x = 20, y = 10;
		System.out.println(false & false);

	}

	public String StreamToJsonString(HttpServletRequest request) {

		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = request.getReader();
			String read = null;

			while (!"".equals(read = reader.readLine()) && null != read) {
				sb.append(read);

			}
			JSONObject jsonObject = new JSONObject();
			JSONObject po = JSON.parseObject(new String(sb));
			String string = po.getString("name");
			String ps = po.getString("password");

			

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Test
	public void tst() {
		InputStream resourceAsStream = JsonUtils.class.getClassLoader().getResourceAsStream("test.txt");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(resourceAsStream, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonUtils jsonUtils = new JsonUtils();

		try {
			jsonUtils.JsonStringToMap(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
