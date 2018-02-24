package com.topmobile.service;

import org.springframework.data.domain.Page;

import com.topmobile.bean.BaodanVo;
import com.topmobile.bean.RequestBaodan;

public interface BaodanService {
	/**
	 * 插入报单
	 * @param userId 当前登录用户id
	 * @param bean 客户端提交的数据
	 * @return
	 */
	public int addBaodan(String userId,RequestBaodan bean);

	public Page<BaodanVo> getListByUserId(String userId, int page, int rows);
}
