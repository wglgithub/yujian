package com.topmobile.dao.natived;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.topmobile.util.SpringUtil;


/**
 * native sql dao
 *
 * @author wgl
 * @date 2016年12月6日 下午7:28:28
 */
public class NativeBaseDao {
	static EntityManager entityManagerFactory;
	
	public void init(){
		if(entityManagerFactory==null){
			entityManagerFactory = SpringUtil.getEntityManager();
		}
	}
	public void setEntityManager(EntityManager entityManager){
		if(entityManagerFactory==null){
			entityManagerFactory = SpringUtil.getEntityManager();
		}
	}
	
	protected EntityManager getEntityManager() {
		
		return entityManagerFactory;
	}
	
	public Query createQuery(String sql){
		return entityManagerFactory.createNativeQuery(sql);
	}

}
