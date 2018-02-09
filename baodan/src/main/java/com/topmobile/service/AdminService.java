package com.topmobile.service;

import com.topmobile.entry.AdminUser;

public interface AdminService {

	public boolean existByAccountAndPWd(String accout,String pwd);

	public AdminUser findByAccountAndPWd(String account, String pwd);
}
