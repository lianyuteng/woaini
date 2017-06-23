package site.serviceImpl.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

/**
 * @author eternity
 *
 */
@Service
public class PrivilegeUtil {

	public static Boolean verifyPrivilege(HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if ("root".equals(name)) {
				return true;
			} 
		}

		return false;
	}
	
	
	public Boolean LoginVerifyPrivilege(HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if("root".equals(name)){
				return true;
			}
			
		}
		Cookie cc = new Cookie("root","nothing");
		cc.setMaxAge(60*30);
		response.addCookie(cc);
		return false;
	}
	
	

}
