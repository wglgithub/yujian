package com.topmobile.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topmobile.dao.BaodanUserDao;
import com.topmobile.entry.User;
import com.topmobile.util.AccountUtil;
import com.topmobile.util.Constants;
import com.topmobile.util.DateUtils;

/**
 * 报单系统设置初始化
 *
 * @author wgl
 * @date 2017年12月1日 上午12:35:01
 */
@Service
public class BaodanSysInitSetting {
	
	@Autowired
	private BaodanUserDao userDao ;
	
	@PostConstruct
	void init(){
		//导入管理员账号
		User admin = new User();
		admin.setId("id-0001");
		admin.setAccount("yujian");
		admin.setPwd(AccountUtil.MD5("yujian5285"));
		admin.setRole(Constants.Role.SUPPER_ADMIN);
		admin.setDateStr(DateUtils.timeFormat(System.currentTimeMillis()));
		admin.setName("管理员");
		admin.setMobile("13513213071");
		//检查账号是否已导入
		System.out.println("=====检查管理员账号是否导入=====");
		if(!userDao.exists(admin.getId())){
			System.out.println("----检查管理员账号没有导入");
			System.out.println("----检查管理员账号开始导入");
			userDao.save(admin);
			System.out.println("----检查管理员账号导入完成");
		}else{
			System.out.println("----检查管理员账号已存在");
		}
		System.out.println("=====管理员账号检查导入完成=====");
		
	}
}
