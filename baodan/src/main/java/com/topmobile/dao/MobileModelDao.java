package com.topmobile.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.topmobile.entry.MobileModel;

public interface MobileModelDao extends BaseDao<MobileModel, String> {

	@Query("select count(m.id) from MobileModel m where m.name=? ")
	int existsByName(String name);
	@Query("select count(m.id) from MobileModel m where m.name=? and m.ram=? and m.rom=? and m.color=? and m.flag=?")
	int countByNameAndRamAndRomAndColorAndFlag(String name, int ram, int rom,
			String color, int i);
	Page<MobileModel> findByFlag( int i,Pageable request);
	@Modifying
	@Query("update MobileModel m set m.flag=1 where m.id=? ")
	int deleteModel(String id);
	@Modifying
	@Query("update MobileModel m set m.malls=?2 where m.id=?1 ")
	int updateMallsById(String model,String malls);

}
