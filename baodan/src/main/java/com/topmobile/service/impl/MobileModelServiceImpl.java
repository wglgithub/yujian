package com.topmobile.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.topmobile.bean.RequestParamModel;
import com.topmobile.dao.BaodanMallDao;
import com.topmobile.dao.MallsMobileMappingDao;
import com.topmobile.dao.MobileModelDao;
import com.topmobile.dao.natived.BaodanModelDao;
import com.topmobile.entry.BaoDanMall;
import com.topmobile.entry.Malls;
import com.topmobile.entry.MallsMobileMapping;
import com.topmobile.entry.MobileModel;
import com.topmobile.service.MobileModelService;
import com.topmobile.util.Strings;
@Service
public class MobileModelServiceImpl implements MobileModelService {

	@Autowired
	private MobileModelDao modelDao ;
	@Autowired
	private MallsMobileMappingDao mappingDao ;
	@Autowired
	private BaodanMallDao mallDao ;
	@Override
	public int addOne(RequestParamModel params) {
		int result_exist = 2,
				result_ok = 1,
				result_fail = 0 ;
		//查看机型是否已存在
		int count = modelDao.countByNameAndRamAndRomAndColorAndFlag(
				params.getName(),
				params.getRam(),
				params.getRom(),
				params.getColor(),
				0
				);
		if(count>0){
			//机型已存在
			return result_exist;
		}
		try {
			List<BaoDanMall> malls = mallDao.findAll(params.getMalls());
			MobileModel model = modelDao.save(params.toMobileModelBean());
			List<MallsMobileMapping> mappings = new ArrayList<MallsMobileMapping>();
			String[] names = new String[malls.size()];
			for(int i=0;i< malls.size() ;i++){
				names[i]=malls.get(i).getName();
				mappings.add(new MallsMobileMapping(malls.get(i).getId(), model.getId()));
			}
			mappingDao.save(mappings);
			model.setMalls(String.join(",", names));
			modelDao.save(model);
		} catch (Exception e) {
			e.printStackTrace();
			return result_fail ;
		}
		return result_ok;
	}
	@Override
	public Page<MobileModel> getPageList(int page, int rows) {
		PageRequest request = new PageRequest(page-1, rows,new Sort(Sort.Direction.DESC, "ts"));
		return modelDao.findByFlag(0, request);
	}
	@Override
	public int deleteModel(String id) {
		return modelDao.deleteModel(id);
	}
	@Override
	public MobileModel findOne(String id) {
		return modelDao.findOne(id);
	}
	@Override
	public int updateModel(List<String> malls,String model) {
		List<BaoDanMall> infos = null;
		List<MallsMobileMapping> waitInserts = null;
		String modelFeildModels = "";
		//查询商城信息
		infos = mallDao.findAll(malls);
		//封装带插入的关系数据
		waitInserts = new ArrayList<MallsMobileMapping>();
		if(infos==null||infos.isEmpty()){
			return -1;
		}
		for (BaoDanMall mm : infos) {
			if(Strings.isEmpty(modelFeildModels)){
				modelFeildModels = mm.getName();
			}else{
				modelFeildModels +=','+mm.getName() ;
			}
			waitInserts.add( new MallsMobileMapping(mm.getId(), mm.getName(), model) );
		}
		//删除原有关系记录
		int rows = mappingDao.deleteByModelCode(model);
		//插入新的关系记录
		mappingDao.save(waitInserts);
		//更新model 表
		modelDao.updateMallsById(model,modelFeildModels);
		return 1;
	}
	@Override
	public List<Map<String, String>> getModelListByMall(String mall) {
		return new BaodanModelDao().getSelectByMallId(mall);
	}

	
}
