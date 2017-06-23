package site.controller;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

import site.serviceImpl.EtcInfoServiceIml;
import site.serviceImpl.SessionUtils;

@Controller
public class EtcController {

	@Resource(name = "etcInfoServiceIml")
	private EtcInfoServiceIml eis;

	@Resource(name = "sessionUtils")
	private SessionUtils session;

	@RequestMapping({ "/getTotalEtcInfo" })
	public String getTotalEtcInfo(HttpServletRequest request) {
		Boolean boo = session.veritySession(request);
		if (boo) {

			String etcAllInfo = eis.getEtcAllInfo();

			request.setAttribute("info", etcAllInfo);

		} else {

			Map<String, String> map = new HashMap<>();
			map.put("result", "no permission");
			request.setAttribute("info", JSON.toJSONString(map));

		}

		return "info";
	}

	@RequestMapping({ "/getEtcInfoById" })
	public String getEtcInfoById(@RequestParam("id") int id, HttpServletRequest request) {
		if (session.veritySession(request)) {

			String etcInfoByCarId = eis.getEtcInfoByCarId(id);
			request.setAttribute("info", etcInfoByCarId);
		} else {
			Map<String, String> map = new HashMap();
			map.put("result", "no permission");
			request.setAttribute("info", map);
		}
		return "info";

	}

	@RequestMapping(value = "/verifyHaveOrNo")
	public String verify222(@RequestParam(required = false, value = "id") int id, HttpServletRequest request) {

		Map<String, Object> map = new HashMap<>();
		Boolean se = session.veritySession(request);

		try {
			id = 0;
		} catch (Exception e) {
			request.setAttribute("info", "id non't exists");
			return "info";
		}

		if (se) {

			int result = eis.verify(id);
			if (result == 0) {
				map.put("result", false);
				request.setAttribute("info", JSON.toJSONString(map));
			} else {
				map.put("result", true);
				request.setAttribute("info", JSON.toJSONString(map));
			}
		} else {
			map.put("result", "no permission");
			request.setAttribute("info", JSON.toJSONString(map));

		}
		return "info";

	}
}