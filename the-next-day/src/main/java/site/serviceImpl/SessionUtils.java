package site.serviceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class SessionUtils {

	public Boolean veritySession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (null == session) {
			return false;
		}

		String username = (String) session.getAttribute("username");
		if ("".equals(username) || null == username) {
			return false;
		}

		if (username.equals("root")) {
			return true;
		}

		return false;

	}

	public Boolean saveSession(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		session.setAttribute("username", "root");
		session.setMaxInactiveInterval(60*30);
		return true;

	}

}
