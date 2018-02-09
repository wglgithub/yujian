package com.topmobile.web;

import javax.servlet.http.HttpSession;

import com.topmobile.bean.SessionUser;
import com.topmobile.util.SessionUserUtil;

public class BaodanBaseCon {

	/**
	 * 获取当前登陆用户
	 * @param session
	 * @return
	 */
	SessionUser getCurrentUser(HttpSession session){
		return SessionUserUtil.getUserAttr(session);
	}
}
