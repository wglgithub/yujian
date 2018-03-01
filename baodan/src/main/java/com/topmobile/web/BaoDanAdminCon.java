package com.topmobile.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topmobile.bean.DataGridView;
import com.topmobile.bean.JsonViewObject;
import com.topmobile.bean.RequestParamModel;
import com.topmobile.entry.BaoDanMall;
import com.topmobile.entry.MobileModel;
import com.topmobile.service.BaodanMallService;
import com.topmobile.service.BaodanService;
import com.topmobile.service.MobileModelService;
import com.topmobile.util.ApiResponseCode;
import com.topmobile.util.Strings;

@Controller
@RequestMapping("baodan/admin/api/*")
public class BaoDanAdminCon extends BaodanBaseCon {

	@Autowired
	BaodanMallService mallService ;
	@Autowired
	MobileModelService modelService ;
	@Autowired
	BaodanService baodanService ;
	
	@RequestMapping("mall/add")
	@ResponseBody
	public JsonViewObject mallAdd(String name){
		if(Strings.isEmpty(name)){
			return new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL, "名字不能为空");
		}
		int result = mallService.saveOne(name);
		if(result==-1){
			return new JsonViewObject(ApiResponseCode.QUERY_FAIL, "该名称已存在");
		}else if(result==1){
			return new JsonViewObject(ApiResponseCode.SUCCESS_OK, "添加成功");
		}
			
		return  new JsonViewObject(ApiResponseCode.ERROR_FAILED, "保存出错");
	}
	@RequestMapping("mall/list")
	@ResponseBody
	public DataGridView mallList(int rows,int page){
		if(page==0){
			page=1;
		}
		if(rows==0){
			rows=1;
		}
		Page<BaoDanMall> pageMalls= mallService.getPageList(page,rows);
		
		return DataGridView.fromSpringPage(pageMalls);
	}
	@RequestMapping("model/add")
	@ResponseBody
	public JsonViewObject modelAdd(RequestParamModel model){
		String error_msg = model.volidate();
		if(!Strings.isEmpty(error_msg)){
			return new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL, error_msg);
		}
		int result = modelService.addOne(model);
		if(result==2){
			return new JsonViewObject(ApiResponseCode.QUERY_FAIL, "该名称已存在");
		}else if(result==1){
			return new JsonViewObject(ApiResponseCode.SUCCESS_OK, "添加成功");
		}
		return  new JsonViewObject(ApiResponseCode.ERROR_FAILED, "保存出错");
	}
	@RequestMapping("model/list")
	@ResponseBody
	public DataGridView modelList(int rows,int page){
		if(page==0){
			page=1;
		}
		if(rows==0){
			rows=1;
		}
		Page<MobileModel> pageMalls= modelService.getPageList(page,rows);
		
		return DataGridView.fromSpringPage(pageMalls);
	}
	@RequestMapping("model/rm")
	@ResponseBody
	public JsonViewObject modelRemove(String id){
		if(Strings.isEmpty(id)){
			return new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL, "操作失败，请稍后重试");
		}
		int result = modelService.deleteModel(id);
		if(result<=0){
			return new JsonViewObject(ApiResponseCode.ERROR_FAILED, "操作失败，请稍后重试");
		}
		return new JsonViewObject(ApiResponseCode.SUCCESS_OK, "删除成功"); 
	}
	
	@RequestMapping("model/edit_info")
	@ResponseBody
	public JsonViewObject modelEditInfo(String id){
		Map<String,Object> data = null;
		if(Strings.isEmpty(id)){
			return new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL, "操作失败，请稍后重试");
		}
		MobileModel model = modelService.findOne(id);
		List<Map<String,Object>> malls = mallService.findAllMallSelectedFlag(id);
		if(model==null){
			return new JsonViewObject(ApiResponseCode.ERROR_FAILED, "操作失败，请稍后重试");
		}
		data = new HashMap<String, Object>(4);
		data.put("model", model);
		data.put("malls", malls);
		
		return new JsonViewObject(ApiResponseCode.SUCCESS_OK, "查询成功",data); 
	}
	@RequestMapping("model/update")
	@ResponseBody
	public JsonViewObject modelUpdate(String [] malls,String model){
		if(Strings.isEmpty(model)){
			return new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL, "参数错误");
		}
		if(malls==null||malls.length==0){
			return new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL, "至少选择一个商城");
		}
		int res = modelService.updateModel(Arrays.asList(malls),model);
		if(res>0){
			return new JsonViewObject(ApiResponseCode.SUCCESS_OK, "OK");
		}
		return new JsonViewObject(ApiResponseCode.ERROR_FAILED, "操作失败");
	}
	
	@RequestMapping("zige/sure")
	@ResponseBody
	public JsonViewObject zigeSure(String id){
		if(Strings.isEmpty(id)){
			return new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL, "参数错误");
		}
		int res = baodanService.updateSureState(id);
		if(res>0){
			return new JsonViewObject(ApiResponseCode.SUCCESS_OK, "OK");
		}
		return new JsonViewObject(ApiResponseCode.ERROR_FAILED, "操作失败");
	}
	
	@RequestMapping("zige/rm")
	@ResponseBody
	public JsonViewObject zigeRemove(String id){
		if(Strings.isEmpty(id)){
			return new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL, "参数错误");
		}
		int res = baodanService.deleteOne(id);
		if(res>0){
			return new JsonViewObject(ApiResponseCode.SUCCESS_OK, "OK");
		}
		return new JsonViewObject(ApiResponseCode.ERROR_FAILED, "操作失败");
	}
}
