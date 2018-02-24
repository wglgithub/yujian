package com.topmobile.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topmobile.dao.BaodanUserDao;
import com.topmobile.entry.User;
import com.topmobile.service.BaoDanRegistService;
import com.topmobile.util.AccountUtil;
import com.topmobile.util.Constants;
import com.topmobile.util.Strings;
@Service
public class BaodanRegistServiceImpl implements BaoDanRegistService {

	@Autowired
	BaodanUserDao baodanUserDao ;
	@Override
	public int insertRegistByInviter(User user, String name, String mobile,
			String pwd) {
		
		User regUser = new User();
		regUser.autoGenerateTime();
		regUser.setMobile(mobile);
		regUser.setAccount(AccountUtil.createAccount());
		regUser.setParent(user.getId());
		regUser.setName(name);
		regUser.setPwd(Strings.MD5(pwd));
		if(Constants.Role.SUPPER_ADMIN.equals(user.getRole())){
			regUser.setRole( Constants.Role.DAI_LI);
		}else{
			regUser.setRole( Constants.Role.QIANG_SHOU);
		}
		
		baodanUserDao.save(regUser);
		return 1;
	}
	@Override
	public boolean existsByMobile(String mobile) {
		int result = baodanUserDao.existsByMobile(mobile);
		return result>0 ? true:false;
	}

}
