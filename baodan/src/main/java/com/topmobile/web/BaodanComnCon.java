package com.topmobile.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topmobile.service.BaodanMallService;

@Controller
@RequestMapping("baodan/comn/api/*")
public class BaodanComnCon extends BaodanBaseCon{
	@Autowired
	BaodanMallService mallService ;
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
}
