package com.topmobile.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.topmobile.bean.MobileBean;
import com.topmobile.dao.HotMobileDao;
import com.topmobile.dao.MobileConfigDao;
import com.topmobile.dao.MobileModelDao;
import com.topmobile.entry.HotMobile;
import com.topmobile.entry.MobileConfig;
import com.topmobile.entry.MobileModel;
import com.topmobile.service.HotMobileService;

@Service
public class HotMobileServiceImpl implements HotMobileService {

	@Autowired
	HotMobileDao hotMobileDao ;
	@Autowired
	MobileModelDao mobileModelDao ;
	@Autowired
	MobileConfigDao configDao ;
	@Override
	public void saveOne(MobileBean mobile) {
		HotMobile bean = fromMobileBean(mobile);
		hotMobileDao.save(bean);
	}
	private HotMobile fromMobileBean(MobileBean mobile) {
		HotMobile bean = new HotMobile();
		bean.setMallCode(mobile.getMallCode().trim());
		bean.setHasMore(true);
		bean.setModel(mobile.getModel().trim());
		bean.setDescribeTxt(mobile.getDescribe());
		bean.setStar(5);
		bean.setPanicBuyDate(mobile.getDescribe().trim());
		bean.setPanicBuyDay(mobile.getDescribe().trim().substring(0, mobile.getDescribe().trim().indexOf(" ")));
		bean.setType(0);
		bean.setBuyLink(mobile.getBuyLink().trim());
		return bean;
	}
	@Override
	public int insertModel(String name) {
		//查询机型是否已经存在
//		boolean exists = mobileModelDao.exists(
//				Example.of(
//						new MobileModel(name),
//						ExampleMatcher.matching()
//						.withMatcher("name", GenericPropertyMatchers.storeDefaultMatching())
//						.withIgnoreCase()
//						)
//				);
		int count = mobileModelDao.existsByName(name);
		if(count>0){
			return 2;
		}
		MobileModel model = new MobileModel(name);
		try {
			mobileModelDao.save(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return 0;
		}
		return 1;
	}
	@Override
	public int insertModelConfig(MobileConfig config) {
		// 查看机型是否存在
		int count = mobileModelDao.existsByName(config.getModel());
		if(count<1){
			return 2;
		}
		config.autoGenerateTime();
		try {
			configDao.save(config);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	@Override
	public Page<MobileModel> findPage(int size, int page) {
		PageRequest pageRequest = new PageRequest(page-1, size, new Sort(Direction.ASC, "name"));
		return mobileModelDao.findAll(pageRequest);
	}

}
