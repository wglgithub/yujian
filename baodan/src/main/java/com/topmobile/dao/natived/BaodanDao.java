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

import com.google.common.base.Strings;
import com.topmobile.bean.BaodanSearchParam;
import com.topmobile.bean.BaodanVo;
import com.topmobile.util.Constants.Role;

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
	@SuppressWarnings("unchecked")
	public Page<BaodanVo> findMyList(String userId,String role,BaodanSearchParam p){
		List<BaodanVo> content = null;
		int page = p.getPage();
		int size = p.getRows();
		int total = 0;
		total = ((BigInteger)findMyListQuery(userId,role, p,"count").getSingleResult()).intValue();
		if(total==0){
			content = new ArrayList<BaodanVo>(4);
		}else{
			Query query = findMyListQuery(userId,role, p,"query");
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
	Query findMyListQuery(String userId,String role,BaodanSearchParam p,String type){
		StringBuilder sqlBuilder = new StringBuilder();
		if(type.equals("query")){
			sqlBuilder.append("SELECT ")
			.append("b.c_id as id , ")
			.append("b.dateStr as date,")
			.append("u.name as submitUser, ")
			.append("m.name as mall , ")
			.append("mm.model as model , ")
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
			.append("LEFT JOIN bd_mall m  ")
			.append("on m.c_id = b.mall  ");
			sqlBuilder.append("LEFT JOIN (SELECT t.c_id id,CONCAT(t.name,' ',t.ram,'+',t.rom) as model,t.color from w_mobilemodel t ) mm on mm.id = b.mobileModel ");
			sqlBuilder.append("LEFT JOIN user u on u.c_id = b.submitUser  ");
		}else{
			sqlBuilder.append("SELECT count(*) from baodan b ");
			if( !isEmptyString(p.getUser()) ){
				sqlBuilder.append("LEFT JOIN user u on u.c_id = b.submitUser ");
			}
			if(!isEmptyString(p.getModel())){
				sqlBuilder.append("LEFT JOIN (SELECT t.c_id id,CONCAT(t.name,' ',t.ram,'+',t.rom) as model,t.color from w_mobilemodel t ) mm on mm.id = b.mobileModel ");
			}
		}
		sqlBuilder.append(" WHERE 1=1 ");
		if(Role.QIANG_SHOU.equals(role)){
			sqlBuilder.append("and b.submitUser = :userId ");
		}else if(Role.DAI_LI.equals(role)){
			sqlBuilder.append("and (b.submitUser = :userId or b.proxyId=:userId) ");
		}
		if(!isEmptyString(p.getBegin())){
			sqlBuilder.append("and b.dateStr>=:begin ");
		}
		if(!isEmptyString(p.getEnd())){
			sqlBuilder.append("and b.dateStr<=:end ");
		}
		if(!isEmptyString(p.getTheday())){
			sqlBuilder.append("and  TO_DAYS(b.updateDate)=TO_DAYS(:theday)");
		}
		if(!isEmptyString(p.getMall())){
			sqlBuilder.append("and b.mall=:mall ");
		}
		if(!isEmptyString(p.getPayway())){
			sqlBuilder.append("and b.payWay =:payway ");
		}
		if(!isEmptyString(p.getRecieve())){
			sqlBuilder.append("and b.addressee like CONCAT('%',:recieve,'%') ");
		}
		if(!isEmptyString(p.getOrderno())){
			sqlBuilder.append("and b.orderNo =:no ");
		}
		if(!isEmptyString(p.getDealway())){
			sqlBuilder.append("and b.currentState =:currentState ");
		}
		if( !isEmptyString(p.getUser()) ){
			sqlBuilder.append("and u.name LIKE CONCAT('%',:user,'%') ");
		}
		if(!isEmptyString(p.getModel())){
			sqlBuilder.append("and mm.model LIKE CONCAT('%',:model,'%') ");
		}
		if(type.equals("query")){
			sqlBuilder.append(" ORDER BY b.ts DESC ");
			sqlBuilder.append(" LIMIT :offset,:size ");
		}
		Query query = createQuery(sqlBuilder.toString());
		if(!isEmptyString(p.getBegin())){
			query.setParameter("begin", p.getBegin());
		}
		if(!isEmptyString(p.getEnd())){
			query.setParameter("end", p.getEnd());
		}
		if(!isEmptyString(p.getTheday())){
			query.setParameter("theday", p.getTheday());
		}
		if(!isEmptyString(p.getMall())){
			query.setParameter("mall", p.getMall());
		}
		if(!isEmptyString(p.getPayway())){
			query.setParameter("payway", p.getPayway());
		}
		if(!isEmptyString(p.getRecieve())){
			query.setParameter("recieve", p.getRecieve().trim());
		}
		if(!isEmptyString(p.getOrderno())){
			query.setParameter("no", p.getOrderno().trim());
		}
		if(!isEmptyString(p.getDealway())){
			query.setParameter("currentState", p.getDealway());
		}
		
		if( !isEmptyString(p.getUser()) ){
			query.setParameter("user", p.getUser().trim());
		}
		if(!isEmptyString(p.getModel())){
			query.setParameter("model", p.getModel().trim());
		}
		
		return query;
	}
	boolean isEmptyString(String str){
		return Strings.isNullOrEmpty(str);
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
