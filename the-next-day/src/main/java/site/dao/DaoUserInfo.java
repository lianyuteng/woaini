package site.dao;

import java.util.List;

import site.entity.UserInfo;

public interface DaoUserInfo {

	
	
	List<UserInfo> getTotalUserInfo();

	int  check(String name, String pasd);
}
