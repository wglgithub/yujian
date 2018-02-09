package com.topmobile.service;

import com.topmobile.entry.User;

public interface BaoDanRegistService {
	/**
	 * 邀请注册账号
	 * @param user 邀请人
	 * @param name
	 * @param mobile
	 * @return
	 */
	int insertRegistByInviter(User user, String name, String mobile,String pwd);

}
