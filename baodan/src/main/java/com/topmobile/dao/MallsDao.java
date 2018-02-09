package com.topmobile.dao;

import org.springframework.data.jpa.repository.Query;

import com.topmobile.entry.Malls;

public interface MallsDao extends BaseDao<Malls, String> {

	@Query("select case when count(m.id)>0 then 'true' else 'false' end from Malls m where m.name=? ")
	boolean existsByName(String name);
	@Query("select case when count(m.id)>0 then 'true' else 'false' end from Malls m where m.code=? ")
	boolean existsByCode(String code);

}
