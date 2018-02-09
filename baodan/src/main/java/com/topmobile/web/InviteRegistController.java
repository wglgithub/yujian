package com.topmobile.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.topmobile.bean.JsonViewObject;
import com.topmobile.entry.User;
import com.topmobile.service.BaoDanRegistService;
import com.topmobile.service.UserService;
import com.topmobile.util.ApiResponseCode;
import com.topmobile.util.Constants;
import com.topmobile.util.JsonViewFactory;
import com.topmobile.util.Strings;

/**
 * 
 * @author wgl
 *
 */
@RequestMapping("api/comn/reg/*")
@Controller
public class InviteRegistController {
	@Autowired
	UserService userService ;
	@Autowired
	BaoDanRegistService registService ;

	@RequestMapping("jsp/agent")
	public String jspAgentRegist(){
		
		return "";
		
	}
	/**
	 * 邀请注册api
	 * @param inviter
	 * @return
	 */
	@RequestMapping("invite/{inviter}")
	@ResponseBody
	public Object regist(@PathVariable String inviter,String mobile,String name,String smsCode,String pwd){
		
		//邀请人范围
		List<String> inviteRange = null;
		String error =null;
		//校验参数
		if(Strings.isEmpty(mobile)){
			error = "手机号码不能为空";
		}else if(Strings.isEmpty(name)){
			error = "姓名不能为空";
		}else if(Strings.isEmpty(pwd)){
			error = "密码不能为空";
		}
		if(!Strings.isEmpty(error)){
			return JsonViewFactory.newArgsIllegalInstance( error);
		}
		//查询邀请人信息
		User user = userService.findById(inviter) ;
		//inviteRange = Lists.newArrayList(Constants.Role.SUPPER_ADMIN,Constants.Role.DAI_LI);
		inviteRange = Arrays.asList(Constants.Role.SUPPER_ADMIN,Constants.Role.DAI_LI);
		
		if(user==null){
			//邀请人不存在
			return JsonViewFactory.newErrorNotExistInstance("邀请人不存在");
		}
		if(!inviteRange.contains(user.getRole())){
			
			return JsonViewFactory.newErrorInstance("邀请人没有权限");
		}
		//TODO 注册短信验证
		/*
		 * 验证手机号短信验证码 
		 */
		
		//注册账号
		int res = registService.insertRegistByInviter(user,name,mobile,pwd);
		
		return JsonViewFactory.newSuccessInstance();
	}
}
