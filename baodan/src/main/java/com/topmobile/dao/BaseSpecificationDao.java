package com.topmobile.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface BaseSpecificationDao <T, ID extends Serializable> extends JpaSpecificationExecutor<T>{

	T findOne(ID id);
	
}
