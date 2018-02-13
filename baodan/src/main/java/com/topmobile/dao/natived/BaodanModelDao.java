package com.topmobile.dao.natived;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

public class BaodanModelDao extends NativeBaseDao {

	public List<Map<String, String>> getSelectByMallId(String mall){
		String sql = getSelectByMallIdSql();
		Query query = createQuery(sql);
		query.setParameter("mall", mall);
		query.unwrap(SQLQuery.class)
		.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.getResultList();
	}

	private String getSelectByMallIdSql() {
		return new StringBuilder()
		.append("SELECT ")
		.append(" m.c_id id, ")
		.append(" m.name,  ")
		.append(" CONCAT(m.name,' ',m.color,' ',m.ram,'+',m.rom) as sets ")
		.append("from w_mobilemodel m   ")
		.append(" JOIN w_mmmaping map ")
		.append(" on map.model = m.c_id and map.mallCode=:mall ")
		.append(" ORDER BY m.`name` ASC , m.color, m.ram,m.rom  ")
		.toString();
		
	}
}
