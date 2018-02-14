package com.topmobile.dao;

import org.springframework.data.jpa.repository.Query;

import com.topmobile.entry.BaoDan;

public interface BaodanDao extends BaseDao<BaoDan, String> {

	@Query("SELECT count(id) from BaoDan WHERE orderNo = ?1")
	int existsByOrderNo(String orderId);


}
