package com.topmobile.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.topmobile.entry.BaoDanMall;

public interface BaodanMallService {

	/**
	 * 添加商城
	 * @param name
	 * @return 1=添加成功 ;0=添加失败;-1=已存在
	 */
	public int saveOne(String name) ;

	public List<BaoDanMall> getList();

	public Page<BaoDanMall> getPageList(int page, int size);

	public List<Map<String, Object>> findAllMallSelectedFlag(String id);
}
