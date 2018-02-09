package com.topmobile.util;


import javax.servlet.http.HttpSession;

import com.topmobile.bean.SessionUser;

/**
 * 用户信息sesion操作工具类
 * @author wgl
 * @date 2016年9月20日 下午5:00:59
 */
public class SessionUserUtil {
	public static String SESSION_USER_KEY = "baodan_session_u_key";
	public static String SESSION_DEFAULT_PWD_USER_KEY = "baodan_session_u_default_pwd_key_";
	
	/**
	 * 将系统用户对象存储到session中
	 * @param session
	 * @param key
	 * @param user
	 */
	public static void setAttr(HttpSession session,String key,SessionUser user){
		//将系统用户对象转换成json格式字符串并存储到缓存中
		session.setAttribute(key, user); 
	}
	
	/**
	 * 保存时候默认密码登录用户信息
	 * @param session
	 * @param user
	 */
	public static void setDeFaultPwdUserAttr(HttpSession session,SessionUser user){
		setAttr(session,SESSION_DEFAULT_PWD_USER_KEY,user);
	}
	
	/**
	 * 保存登录用户信息
	 * @param session
	 * @param user
	 */
	public static void setUserAttr(HttpSession session,SessionUser user){
		setAttr(session,SESSION_USER_KEY,user);
	}
	/**
	 * 获取使用默认密码登录的用户信息,返回SysUser系统用户对象.
	 * 如果session中没有缓存或缓存已失效或json反序列化出错,则返回null
	 * @param session
	 * @return
	 */
	public static SessionUser getDeFaultPwdUserAttr(HttpSession session){
		return (SessionUser) session.getAttribute(SESSION_DEFAULT_PWD_USER_KEY);
	}
	
	/**
	 * 获取登录用户信息,返回SysUser系统用户对象.
	 * 如果session中没有缓存则返回null
	 * @param session
	 * @return
	 */
	public static SessionUser getUserAttr(HttpSession session){
		return (SessionUser) session.getAttribute(SESSION_USER_KEY);
	}
	
}
