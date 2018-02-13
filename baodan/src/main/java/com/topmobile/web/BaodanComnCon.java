package com.topmobile.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topmobile.service.BaodanMallService;
import com.topmobile.service.MobileModelService;

@Controller
@RequestMapping("baodan/comn/api/*")
public class BaodanComnCon extends BaodanBaseCon{
	@Autowired
	BaodanMallService mallService ;
	@Autowired
	MobileModelService modelService ;
	/**
	 * 查询商城基本信息 名称和id
	 * @使用场景 select选择视图数据
	 * @return
	 */
	@RequestMapping(value="malls/get",method=RequestMethod.GET)
	@ResponseBody
	public Object getMallsList(){
		
//		return new JsonViewObject(ApiResponseCode.SUCCESS_OK,
//				"ok",
//				mallService.getList());
		return mallService.getList();
	}
	/**
	 * 查询商城机型列表 名称和id 配置
	 * @使用场景 select选择视图数据
	 * @return
	 */
	@RequestMapping(value="model/list",method=RequestMethod.GET)
	@ResponseBody
	public Object getModelsByMall(String mall){
		List<Map<String,String>> list = modelService.getModelListByMall(mall);
		return list ;
	}
}
