package com.topmobile.interceptors;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.topmobile.bean.JsonViewObject;
import com.topmobile.bean.SessionUser;
import com.topmobile.util.SessionUserUtil;
import com.topmobile.util.Strings;

public class JspAdminInterceptor implements HandlerInterceptor {

	private String loginPagePath = "/jsp/admin/login";
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req,
			HttpServletResponse response, Object arg2) throws Exception {
		// 检查用户是否登录
		if (!isLogin(req.getSession())) {
			response.sendRedirect(getToLoginUrl(req));
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return req.getContextPath()+loginPagePath+"?tourl="+url;
	}

	public boolean isLogin(HttpSession session) {
		// 如果当前用户是管理员才表示登录
		SessionUser user = SessionUserUtil.getUserAttr(session);
		if(user!=null&&SessionUser.ROLE_ADMIN.equals(user.getRole()) ){
			return true;
		}
		return false;
	}

	public void writeJson(HttpServletResponse response, JsonViewObject jsonview)
			throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//这句话是解决乱码的
		response.getWriter().print(jsonview.toJson());
	}
}
