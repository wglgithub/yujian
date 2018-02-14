package com.topmobile.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.topmobile.base.SpringTestCase;

public class BaodanUserDaoTest extends SpringTestCase{

	@Autowired
	BaodanUserDao userDao ;
	@Test
	public void getParentIdByIdTest(){
		String userId = "";
		String parent = userDao.getParentIdById(userId);
		System.out.println(parent);
	}
}
