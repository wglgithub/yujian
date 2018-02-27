package com.topmobile.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topmobile.bean.BaodanVo;
import com.topmobile.bean.DataGridView;
import com.topmobile.bean.RequestBaodan;
import com.topmobile.bean.UserSelectModel;
import com.topmobile.entry.BaoDan;
import com.topmobile.entry.BaoDanMall;
import com.topmobile.service.BaodanMallService;
import com.topmobile.service.BaodanService;
import com.topmobile.service.MobileModelService;
import com.topmobile.util.JsonViewFactory;

@Controller
@RequestMapping("baodan/comn/api/*")
public class BaodanComnCon extends BaodanBaseCon{
	@Autowired
	BaodanMallService mallService ;
	@Autowired
	MobileModelService modelService ;
	@Autowired
	BaodanService baodanService ;
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
	/**
	 * 查询用户列表 名称和id
	 * @使用场景 select选择视图数据
	 * @return
	 */
	@RequestMapping(value="user/select",method=RequestMethod.GET)
	@ResponseBody
	public Object getUserNamesForSelect(){
		List<UserSelectModel> list = modelService.getUserNamesForSelect();
		return list ;
	}
	/**
	 * 报单接口
	 * @return
	 */
	@RequestMapping(value="model/post",method=RequestMethod.POST)
	@ResponseBody
	public Object postModel(@Valid RequestBaodan param,BindingResult bindingResult,HttpSession session){
		if(bindingResult.hasErrors()){
			return JsonViewFactory.newArgsIllegalInstance(bindingResult.getFieldError().getDefaultMessage());
		}
		String model = param.getModel() ;
		//查询机型是否存在
		if(!modelService.existById(model)){
			return JsonViewFactory.newArgsIllegalInstance("请选择机型");
		}
		int rows = baodanService.addBaodan(getCurrentUser(session).getId(), param);
		if(rows==1){
			return JsonViewFactory.newSuccessInstance();
		}else if(rows==-1){
			return JsonViewFactory.newErrorInstance("订单号已存在，请勿重复报单");
		}
		return JsonViewFactory.newErrorInstance("上报失败");
		
	}
	@RequestMapping(value="zige/list",method=RequestMethod.GET)
	@ResponseBody
	public Object getBaodanList(int rows,int page,HttpSession session){
		if(page==0){
			page=1;
		}
		if(rows==0){
			rows=10;
		}
		String userId = getCurrentUser(session).getId();
		Page<BaodanVo> lists = baodanService.getListByUserId(userId,page,rows);
		
		return DataGridView.fromSpringPage(lists);
	}
	
	@RequestMapping(value="order/fahuo")
	@ResponseBody
	public Object fahuo(String id,String no,HttpSession session){
		
		int updateRows = baodanService.updateWuliuField(id,no);
		
		return JsonViewFactory.newSuccessInstance();
	}
}
