package site.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import site.dao.DaoUserInfo;
import site.entity.UserInfo;

@Service
public class UserServiceImpl {

	@Resource(name = "daoUserInfo")
	private DaoUserInfo dao;

	public int Login(String name, String pasd) {
		return dao.check(name,pasd);

	}

	public String getTotalUserInfo() {

		List<UserInfo> totalUserInfo = dao.getTotalUserInfo();
		String jsonString = JSONObject.toJSONString(totalUserInfo);

		return jsonString;

	}

}
