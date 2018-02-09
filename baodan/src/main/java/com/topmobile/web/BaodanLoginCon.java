package com.topmobile.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topmobile.bean.JsonViewObject;
import com.topmobile.service.BaodanLoginService;
/**
 * 报单系统 登录控制器
 *
 * @author wgl
 * @date 2017年11月30日 上午12:16:47
 */
@Controller
@RequestMapping("baodan/api/login/*")
public class BaodanLoginCon extends BaodanBaseCon{
	
	@Autowired
	private BaodanLoginService loginService ;
	/**
	 * 登录请求
	 * @param account
	 * @param pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping("sign")
	public JsonViewObject sign(String account,String pwd,HttpSession session){
		
		return loginService.signIn(account, pwd, session) ;
	}
	
}
