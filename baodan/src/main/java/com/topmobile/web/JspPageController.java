package com.topmobile.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topmobile.bean.SessionUser;
import com.topmobile.util.SessionUserUtil;

/**
 * jsp路由控制器
 * 
 * @author wgl
 * @date 2017年3月7日 上午9:22:33
 */
@Controller
@RequestMapping("v/*")
public class JspPageController {
	@RequestMapping("uecontroller")
	public String ueController(){
		return "uecontroller";
	}
	
	@RequestMapping("index")
	public String jspRoute(HttpServletRequest request) {
		return "index";
	}
	@RequestMapping("invite")
	public String jspInviteRoute(HttpServletRequest request) {
		return "invite";
	}
	@RequestMapping("invite_success")
	public String jspInviteSuccessRoute(HttpServletRequest request) {
		return "invite_success";
	}
	@RequestMapping("signout")
	public String jspSignOutRoute(HttpSession session) {
		session.invalidate();
		return "redirect:/v/baodan/sign";
	}
	@RequestMapping("baodan/index")
	public String jspdaodanRoute(HttpServletRequest request) {
		SessionUser user = SessionUserUtil.getUserAttr(request.getSession());
		return "baodan/"+user.getRole()+"/index";
	}

	@RequestMapping("{model}/{name}")
	public String jspRoute(HttpServletRequest request,
			@PathVariable String model, @PathVariable String name) {
		return model + "/" + name;
	}
	@RequestMapping("{model}/{child}/{name}")
	public String jspRoute(HttpServletRequest request,
			@PathVariable String model,@PathVariable String child, @PathVariable String name) {
		return model + "/"+child+"/" + name;
	}
}
