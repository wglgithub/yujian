package com.topmobile.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.topmobile.entry.MallsMobileMapping;

public interface MallsMobileMappingDao extends BaseDao<MallsMobileMapping, String>{

	@Modifying
	@Query("delete from MallsMobileMapping m where m.model=?")
	int deleteByModelCode(String model);

}
