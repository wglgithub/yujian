package com.topmobile.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topmobile.bean.JsonViewObject;
import com.topmobile.bean.SessionUser;
import com.topmobile.dao.BaodanUserDao;
import com.topmobile.entry.User;
import com.topmobile.service.BaodanLoginService;
import com.topmobile.util.AccountUtil;
import com.topmobile.util.ApiResponseCode;
import com.topmobile.util.SessionUserUtil;

@Service
public class BaodanLoginServiceImpl implements BaodanLoginService {

	@Autowired
	private BaodanUserDao userDao ;
	@Override
	public JsonViewObject signIn(String account, String pwd, HttpSession session) {
		
		User user = userDao.findByAccountAndPwd(account, AccountUtil.MD5(pwd));
		if(user==null){
			//用户名或者密码错误
			return new JsonViewObject(ApiResponseCode.LOGIN_FAIL,"用户名或者密码错误");
		}
		if(user.getFlag()==1){
			return new JsonViewObject(ApiResponseCode.LOGIN_ACC_DISABLE,"账号被禁用");
		}
		SessionUser sessionUser = new SessionUser(user.getId(), user.getRole()
				, account, user.getName());
		SessionUserUtil.setUserAttr(session, sessionUser);
		return new JsonViewObject(ApiResponseCode.LOGIN_OK,"登录成功",user.toSimpleData());
	}

}
