package com.topmobile.interceptors;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.topmobile.bean.JsonViewObject;
import com.topmobile.bean.SessionUser;
import com.topmobile.util.JsonViewFactory;
import com.topmobile.util.SessionUserUtil;
import com.topmobile.util.Strings;
/**
 * 报单系统页面拦截器
 *
 * @author wgl
 * @date 2017年12月1日 上午12:54:11
 */
public class BaodanApiInterceptor implements HandlerInterceptor  {

	String  loginPagePath = "/v/baodan/sign";
	@Override
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse rep, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse rep,
			Object arg2) throws Exception {
		/*
		 *  检查用户是否登录
		 */
		if (!isLogin(req.getSession())) {
			writeJson(rep, JsonViewFactory.newNoSignInstance() );
			//writeString(rep, "signOut();");
			return false;
		}
		/*
		 * 检查访问页面权限 ,如果当前登陆角色访问非角色权限页面 阻止访问
		 */
		
		//当前访问的模块权限
		String modelSpace = parseModel(req.getRequestURI());
		String role = getCurrentUserRole(req.getSession());
		if(modelSpace!=null&&!modelSpace.equalsIgnoreCase(role)){
			return false;
		}
		return true;
	}

	public String getToLoginUrl(HttpServletRequest req){
		String param = req.getQueryString();
		String url="";
		try {
			url = URLEncoder.encode(req.getRequestURL().toString(),"utf-8");
			if(!Strings.isEmpty(param)){
				url = URLEncoder.encode(req.getRequestURL().toString()+"?"+param,"utf-8");
				return req.getContextPath()+loginPagePath+"?tourl="+url;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		return req.getContextPath()+loginPagePath+"?tourl="+url;
	}

	public boolean isLogin(HttpSession session) {
		// 如果当前用户是管理员才表示登录
		SessionUser user = SessionUserUtil.getUserAttr(session);
		if(user!=null){
			return true;
		}
		return false;
	}
	/**
	 * 获取当前登陆人的角色
	 * @param session
	 * @return
	 */
	public static String getCurrentUserRole(HttpSession session){
		return SessionUserUtil.getUserAttr(session).getRole();
	}
	/**
	 * 如果匹配出null 表示不需要特殊权限
	 * @param uri
	 * @return
	 */
	String parseModel(String uri){
		String res = null;
		Pattern pattern = Pattern.compile("(?<=v\\/baodan\\/)(.+?)(?=\\/)");
		Matcher matcher = pattern.matcher(uri);
		if(matcher.find()){
			res = matcher.group(); 
		}
		return res;
	}

	public void writeJson(HttpServletResponse response, JsonViewObject jsonview)
			throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//这句话是解决乱码的
		response.getWriter().print(jsonview.toJson());
	}
	public void writeString(HttpServletResponse response, String view)
			throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//这句话是解决乱码的
		response.getWriter().print(view);
	}

}
