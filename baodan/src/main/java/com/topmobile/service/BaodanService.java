package com.topmobile.service;

import com.topmobile.bean.RequestBaodan;

public interface BaodanService {
	/**
	 * 插入报单
	 * @param userId 当前登录用户id
	 * @param bean 客户端提交的数据
	 * @return
	 */
	public int addBaodan(String userId,RequestBaodan bean);
}
