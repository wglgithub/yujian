package com.topmobile.dao.natived;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;


public class BaodanMallDao extends NativeBaseDao{

	/**
	 * 查询所有可用商城并返回条件手机机型上架标志
	 * @param modelId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> findAllMallSelected(String modelId){
		String sql = new StringBuffer()
		.append("SELECT mall.name,mall.c_id,IF(mm.model is null,false,TRUE) selected ")
		.append(" from bd_mall mall ")
		.append(" LEFT JOIN w_mmmaping mm ")
		.append(" on mall.c_id = mm.mallCode and mm.model=:modelId ")
		.append(" WHERE mall.flag=0")
		.toString();
		Query query = createQuery(sql);
		query.setParameter("modelId", modelId);
		query.unwrap(SQLQuery.class)
		.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.getResultList();
	}
}
