package com.topmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topmobile.dao.MallsDao;
import com.topmobile.entry.Malls;
import com.topmobile.service.MallsService;
@Service
public class MallsServiceImpl implements MallsService {

	@Autowired
	MallsDao mallsDao ;
	
	@Override
	public int insertOne(Malls mall) {
		//查询是否存在重名
		boolean exists = mallsDao.existsByName(mall.getName());
		if(exists){
			return 1;
		}
		exists = mallsDao.existsByCode(mall.getCode());
		if(exists){
			return 2;
		}
		mallsDao.save(mall);
		return 0;
	}

	@Override
	public List<Malls> findAll() {
		return mallsDao.findAll();
	}

}
