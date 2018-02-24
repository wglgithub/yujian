package com.topmobile.dao.natived;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.topmobile.bean.BaodanVo;

public class BaodanDao extends NativeBaseDao{

	@SuppressWarnings("unchecked")
	public Page<BaodanVo> findMyList(int page ,int size,  String userId){
		List<BaodanVo> content = null;
		int total = 0;
		total = ((BigInteger) createQuery(countMyListSql())
		.setParameter("userId", userId).getSingleResult()).intValue();
		if(total==0){
			content = new ArrayList<BaodanVo>(4);
		}else{
			Query query = createQuery(findMyListSql());
			query.setParameter("userId", userId);
			query.setParameter("size", size);
			query.setParameter("offset", (page-1)*size);
			query.unwrap(SQLQuery.class)
			.addScalar("id", StandardBasicTypes.STRING)
			.addScalar("submitUser", StandardBasicTypes.STRING)
			.addScalar("date", StandardBasicTypes.STRING)
			.addScalar("model", StandardBasicTypes.STRING)
			.addScalar("mall", StandardBasicTypes.STRING)
			.addScalar("color", StandardBasicTypes.STRING)
			.addScalar("amount", StandardBasicTypes.INTEGER)
			.addScalar("orderno", StandardBasicTypes.STRING)
			.addScalar("payway", StandardBasicTypes.STRING)
			.addScalar("state1", StandardBasicTypes.STRING)
			.addScalar("realpay", StandardBasicTypes.STRING)
			.addScalar("returnPay", StandardBasicTypes.STRING)
			.addScalar("applystate", StandardBasicTypes.STRING)
			.addScalar("wuliu", StandardBasicTypes.STRING)
			.addScalar("remark", StandardBasicTypes.STRING)
			.setResultTransformer(Transformers.aliasToBean(BaodanVo.class));
			content = query.getResultList();
		}
		return new PageImpl<BaodanVo>(content, new PageRequest(page-1, size), total);
		
	}
	String countMyListSql(){
		return "SELECT count(*) from baodan WHERE submitUser = :userId or proxyId=:userId";
	}
	String findMyListSql(){
		return new StringBuilder()
		.append("SELECT ")
		.append("b.c_id as id , ")
		.append("b.dateStr as date,")
		.append("u.name as submitUser, ")
		.append("m.name as mall , ")
		.append("CONCAT(mm.name,' ',mm.ram,'+',mm.rom) as model , ")
		.append("mm.color as color , ")
		.append("b.amount as amount, ")
		.append("b.orderNo as orderno, ")
		.append("CASE b.payWay WHEN 0 then '群主付款' WHEN 1 then '货到付款' WHEN 2 then '自己垫付' ELSE '其他' end as payway , ")
		.append("b.orderPay/100 as realpay , ")
	    .append("b.sureState as applystate , ")
		.append("case when u.role ='worker' and b.paymentState2='已回款' then b.payment2 WHEN (u.role ='agent' or u.role ='admin' ) and b.paymentState1='已回款' then b.payment1 else  b.fahuoState end  as state1 , ")
		.append("case u.role when 'worker' then b.payment2/100 else b.payment1/100 end as returnPay, ")
		.append("b.logisticsNo as wuliu , ")
		.append("b.remark as remark  ")
		.append("FROM baodan b  ")
		.append("LEFT JOIN user u  ")
		.append("on u.c_id = b.submitUser  ")
		.append("LEFT JOIN bd_mall m  ")
		.append("on m.c_id = b.mall  ")
		.append("LEFT JOIN w_mobilemodel mm  ")
		.append("on mm.c_id = b.mobileModel  ")
		.append("WHERE  ")
		.append("b.submitUser = :userId or proxyId=:userId ")
		.append("ORDER BY b.ts DESC ")
		.append("LIMIT :offset,:size ")
		.toString();
	}
}
