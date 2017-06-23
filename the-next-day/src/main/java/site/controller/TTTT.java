package site.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TTTT {

	@RequestMapping(value = "/wocao")
	public String wocao(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session = request.getSession(true);
	long creationTime = session.getCreationTime();
	session.setMaxInactiveInterval(1);
	
	session.getAttribute("wocao");
	long lastAccessedTime = session.getLastAccessedTime();
	System.err.println(new Date(creationTime));
	System.err.println(new Date(lastAccessedTime));

		Enumeration<String> name = request.getHeaderNames();
		while (name.hasMoreElements()) {
			String string = (String) name.nextElement();
			String header = request.getHeader(string);
			System.out.println(header);

		}

		return "info";

	}
}
