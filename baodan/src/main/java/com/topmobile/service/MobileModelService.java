package com.topmobile.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.topmobile.bean.RequestParamModel;
import com.topmobile.bean.UserSelectModel;
import com.topmobile.entry.MobileModel;
import com.topmobile.entry.User;

public interface MobileModelService {

	/**
	 * 添加机型配置
	 * <br>
	 * 添加一条机型数据、机型和商城的关系数据
	 * @param params
	 * @return 1=添加成功 0=添加失败 2=已存在该机型
	 */
	public int addOne(RequestParamModel params);
	/**
	 * 分页查询机型
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<MobileModel> getPageList(int page, int rows);
	public int deleteModel(String id);
	public MobileModel findOne(String id);
	/**
	 * 设置机型上架的商城
	 * @param malls
	 * @return
	 */
	public int updateModel(List<String> malls,String model);
	/**
	 * 查询商城下的机型
	 * @param mall
	 * @return
	 */
	public List<Map<String, String>> getModelListByMall(String mall);
	/**
	 * 查询机型是否存在
	 * @return
	 */
	public boolean existById(String id);
	public List<UserSelectModel> getUserNamesForSelect();
}
