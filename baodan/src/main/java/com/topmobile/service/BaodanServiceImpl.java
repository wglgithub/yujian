package com.topmobile.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.topmobile.bean.BaodanVo;
import com.topmobile.bean.RequestBaodan;
import com.topmobile.dao.BaodanDao;
import com.topmobile.dao.BaodanUserDao;
import com.topmobile.entry.BaoDan;

@Service
public class BaodanServiceImpl implements BaodanService {
	Logger log = Logger.getLogger(getClass());
	@Autowired
	private BaodanDao baodanDao ;
	//@Autowired
	//private BaodanSpecificationDao baodanSpecificationDao;
	@Autowired
	private BaodanUserDao userDao ;
	com.topmobile.dao.natived.BaodanDao getBaodanDao(){
    	return new com.topmobile.dao.natived.BaodanDao();
    }
	@Override
	public int addBaodan(String userId, RequestBaodan bean) {
		BaoDan insertBean = null; //带插入数据
		String proxyId = null ; //代理id
		try {
			insertBean = BaoDan.fromRequestBaodan(userId,bean);
			//查询订单编号是否已经存在
			if(baodanDao.existsByOrderNo(bean.getOrderId())>0){
				return -1 ;
			}
			//查询上报人的代理
			proxyId = userDao.getParentIdById(userId);
			//设置代理
			insertBean.setProxyId(proxyId);
			baodanDao.save(insertBean);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("报单失败", e);
			return 0;
		}
		return 1;
	}

	@Override
	public Page<BaodanVo> getListByUserId(final String userId, int page, int size) {
//		PageRequest request = new PageRequest( page-1, size,new Sort(Sort.Direction.DESC, "ts") );
//		return baodanDao.findBySubmitUser(userId,request);
//		return baodanSpecificationDao.findAll(new Specification<BaoDan>() {
//			
//			@Override
//			public Predicate toPredicate(Root<BaoDan> root, CriteriaQuery<?> query,
//					CriteriaBuilder cb) {
//				Join<BaoDan, User> userJoin = root.join("user", JoinType.LEFT);
//				userJoin.alias("u");
//				userJoin.on(cb.equal(userJoin.get("id"), root.get("submitUser")));
//				query.where(cb.equal(root.get("submitUser"), userId));
//				return null;
//			}
//		}, request);
		return getBaodanDao().findMyList(page, size, userId);
	}

}
