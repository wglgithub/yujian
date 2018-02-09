package com.topmobile.service;

import org.springframework.data.domain.Page;

import com.topmobile.bean.MobileBean;
import com.topmobile.entry.MobileConfig;
import com.topmobile.entry.MobileModel;

public interface HotMobileService {

	public void saveOne(MobileBean mobile);

	public int insertModel(String name);

	public int insertModelConfig(MobileConfig config);

	public Page<MobileModel> findPage(int size, int page);
}
