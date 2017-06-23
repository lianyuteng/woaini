package site.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import site.serviceImpl.EnvirServiceImpl;
import site.serviceImpl.SessionUtils;

@Controller
public class EnvironmentController {

	@Resource(name = "envirServiceImpl")
	private EnvirServiceImpl service;

	@Resource(name = "sessionUtils")
	private SessionUtils session;

	@RequestMapping({ "/getEnvir" })
	public String getTotalEnvironmentInformation(HttpServletRequest request) {
		if (session.veritySession(request)) {
			String envirInfo = service.getEnvirInfo();

			if ("".equals(envirInfo) || null == envirInfo) {
				Map<String, String> map = new HashMap();
				map.put("result", "Null");
				request.setAttribute("info", map);
			} else {

				request.setAttribute("info", envirInfo);

			}
		} else {
			Map<String, String> map = new HashMap();
			map.put("result", "no permission");
			request.setAttribute("info", JSON.toJSONString(map));

		}

		return "info";
	}
}
