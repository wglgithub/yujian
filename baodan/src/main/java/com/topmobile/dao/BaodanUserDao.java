package com.topmobile.dao;

import org.springframework.data.jpa.repository.Query;

import com.topmobile.entry.User;

public interface BaodanUserDao extends BaseDao<User, String>{

	@Query("from User where ( account=?1 or mobile=?1 ) and pwd =?2")
	User findByAccountAndPwd(String acc,String pwd);
	@Query("select u.parent from User u where u.id=?1")
	String getParentIdById(String userId);
}
