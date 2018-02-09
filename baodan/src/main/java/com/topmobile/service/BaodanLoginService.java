package com.topmobile.service;

import javax.servlet.http.HttpSession;

import com.topmobile.bean.JsonViewObject;

/**
 * 报单系统登录业务接口
 *
 * @author wgl
 * @date 2017年11月30日 上午12:20:31
 */
public interface BaodanLoginService {
	/**
	 * 登录接口
	 * @param account
	 * @param pwd
	 * @param session
	 * @return
	 */
	public JsonViewObject signIn(String account,String pwd,HttpSession session);
}
