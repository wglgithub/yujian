package com.topmobile.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface BaseDao <T, ID extends Serializable> extends JpaRepository<T, ID>{

	T findOne(ID id);
}
