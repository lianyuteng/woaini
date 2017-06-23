package site.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.Comment;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import site.serviceImpl.JsonUtils;
import site.serviceImpl.SessionUtils;
import site.serviceImpl.UserServiceImpl;

@Controller
public class UserController {

	@Resource(name = "userServiceImpl")
	private UserServiceImpl service;

	@Resource(name = "jsonUtils")
	private JsonUtils util;

	@Resource(name = "sessionUtils")
	private SessionUtils session;

	@RequestMapping(value = "/hehe")
	public String heh(HttpServletRequest request, HttpServletResponse response) {
//		String string = util.StreamToJsonString(request);
//		JSONObject ob = JSON.parseObject(string);
//		System.out.println(ob.getString("name"));
//		System.out.println(ob.getString("password"));
		response.setStatus(202);
		
		

		return "info";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login(@RequestParam(required = false, value = "username") String username,
			@RequestParam(required = false, value = "password") String password, HttpServletRequest request,
			HttpServletResponse response) {
		try {

			StringBuilder jsonString = new StringBuilder();

			BufferedReader reader = request.getReader();

			InputStream stream = UserController.class.getClassLoader().getResourceAsStream("test.txt");
			BufferedReader bf = new BufferedReader(new InputStreamReader(stream, "utf-8"));

			Map<String, Object> map = util.JsonStringToMap(bf);
			String name = (String) map.get("username");
			String pasd = (String) map.get("password");
			int result = service.Login(name, pasd);
			if (result == 1) {
				Map<String, String> map2 = new HashMap<>();
				map2.put("result", "success");
				request.setAttribute("info", JSON.toJSONString(map2));
				session.saveSession(request, response);

			}

			/**
			 * 
			 * InputStream str = request.getInputStream(); BufferedReader bd =
			 * new BufferedReader(new InputStreamReader(str, "UTF-8")); byte []
			 * by = new byte[1024]; String readLine = bd.readLine();
			 * while("".equals(readLine)){ System.out.println(readLine);
			 * readLine = bd.readLine(); }
			 */

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// StringBuffer requestURL = request.getRequestURL();
		// Map<String, String[]> map = request.getParameterMap();
		// for (String str : map.keySet()) {
		//
		// String[] strings = map.get(str);
		//
		// for (int i = 0; i < strings.length; i++) {
		// System.err.println(strings[i]);
		// }
		// }
		// if( null != requestURL){
		// }
		//
		// response.setStatus(200);

		return "info";

	}

	@RequestMapping(value = "/fuck")
	public String fuck(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(200);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/vnd.mx-excel;charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.println("\t一季度\t二季度\t三季度\t四季度");
			writer.println("苹果\t22\t22\tii");
			writer.println("香蕉\t22\t22\tii");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.close();

		}

		return "info";

	}

	@RequestMapping(value = "/getTotalUserInfo")
	public String getTotalUserInfo(HttpServletRequest request) {

		/*
		 * Cookie[] cookies = request.getCookies(); for (Cookie cookie :
		 * cookies) { String name = cookie.getName(); if (name.equals("hehe")) {
		 * request.setAttribute("result", "success"); break; } else {
		 * request.setAttribute("result", "Have no legal power"); }
		 * 
		 * }
		 */

		Boolean boo = session.veritySession(request);
		if (boo) {
			String info = service.getTotalUserInfo();
			request.setAttribute("info", info);
		} else {

			Map<String, String> map2 = new HashMap<>();
			map2.put("result", "no permission");
			request.setAttribute("info", JSON.toJSONString(map2));

		}

		return "info";

	}

}
