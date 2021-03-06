package com.topmobile.service;

import org.springframework.data.domain.Page;

import com.topmobile.bean.AdminReturnedParamVo;
import com.topmobile.bean.BaodanSearchParam;
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

	public Page<BaodanVo> getListByUserId(String userId, int page, int size);
	/**
	 * 修改/添加物流单号
	 * @param id
	 * @param no
	 * @return
	 */
	public int updateWuliuField(String id, String no);

	public Page<BaodanVo> getListByUserId(String userId, String role, BaodanSearchParam p);

	public int updateSureState(String id);

	public int deleteOne(String id);
	/**
	 * 签收
	 * @param id
	 * @return
	 */
	public int updateSignForState(String id);
	/**
	 * 管理员给代理回款
	 * @param param
	 * @return
	 */
	public int updateAdminRetured(AdminReturnedParamVo param);
}
