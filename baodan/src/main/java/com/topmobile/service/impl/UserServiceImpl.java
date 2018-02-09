package com.topmobile.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topmobile.dao.BaodanUserDao;
import com.topmobile.entry.User;
import com.topmobile.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	BaodanUserDao baodanUserDao ;
	@Override
	public User findById(String id) {
		
		return baodanUserDao.findOne(id);
	}

}
