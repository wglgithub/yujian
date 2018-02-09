package com.topmobile.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topmobile.dao.AdminUserDao;
import com.topmobile.entry.AdminUser;
import com.topmobile.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminUserDao adminUserDao ;
	@Override
	public boolean existByAccountAndPWd(String accout, String pwd) {
		
		return findByAccountAndPWd(accout, pwd)!=null;
	}

	@Override
	public AdminUser findByAccountAndPWd(String account, String pwd) {
		// TODO Auto-generated method stub
		return adminUserDao.findByAccountAndPwd(account, pwd);
	}

}
