package com.topmobile.dao;

import com.topmobile.entry.AdminUser;

public interface AdminUserDao extends BaseDao<AdminUser, String> {

	AdminUser findByAccountAndPwd (String account,String pwd);
}
