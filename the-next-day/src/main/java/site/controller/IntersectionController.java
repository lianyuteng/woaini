package site.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import site.serviceImpl.IntersectionServiceImpl;
import site.serviceImpl.SessionUtils;

@Controller
public class IntersectionController {

	@Resource(name = "intersectionServiceImpl")
	private IntersectionServiceImpl service;

	@Resource(name = "sessionUtils")
	private SessionUtils session;

	@RequestMapping({ "/getIntersectionInfo" })
	public String getIntersectionInfo(HttpServletRequest request) {
		if (session.veritySession(request)) {

			String totalIntersectionInformation = service.getTotalIntersectionInformation();
			if ("".equals(totalIntersectionInformation) || null == totalIntersectionInformation) {
				Map map = new HashMap();
				map.put("result", "Null");
				request.setAttribute("info", map);

			} else {
				request.setAttribute("info", totalIntersectionInformation);
			}

		} else {
			Map<String, String> map = new HashMap<>();
			map.put("result", "no permission");
			request.setAttribute("info", JSON.toJSONString(map));

		}

		return "info";
	}
}
