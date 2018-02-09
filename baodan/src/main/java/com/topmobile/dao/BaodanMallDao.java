package com.topmobile.dao;

import com.topmobile.entry.BaoDanMall;

public interface BaodanMallDao extends BaseDao<BaoDanMall, String>{

	BaoDanMall findByName(String name);
}
