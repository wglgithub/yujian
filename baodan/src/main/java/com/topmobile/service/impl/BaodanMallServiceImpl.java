package com.topmobile.service.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.topmobile.dao.BaodanMallDao;
import com.topmobile.entry.BaoDanMall;
import com.topmobile.service.BaodanMallService;

@Service
public class BaodanMallServiceImpl implements BaodanMallService {

	@Autowired
	private BaodanMallDao mallDao ;
	
	public com.topmobile.dao.natived.BaodanMallDao getMallDao(){
		return new com.topmobile.dao.natived.BaodanMallDao();
	}
	@Override
	public int saveOne(String name) {
		//检查商城名称是否已经占用
		BaoDanMall mall = mallDao.findByName(name);
		if(mall!=null){
			//已存在
			return -1;
		}
		mall = new BaoDanMall(name);
		try {
			mallDao.save(mall);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	@Override
	public List<BaoDanMall> getList() {
		
		return mallDao.findAll();
	}
	@Override
	public Page<BaoDanMall> getPageList(int page, int size) {
		PageRequest request = new PageRequest(page-1, size,new Sort(Sort.Direction.DESC, "ts"));
		new Specification<BaoDanMall>() {

			@Override
			public Predicate toPredicate(Root<BaoDanMall> arg0,
					CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		return mallDao.findAll(request);
	}
	@Override
	public List<Map<String, Object>> findAllMallSelectedFlag(String id) {
		
		return getMallDao().findAllMallSelected(id);
	}

}
