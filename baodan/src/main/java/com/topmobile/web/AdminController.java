package com.topmobile.web;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import juan.sms.JUANsms;
import juan.sms.JUANsmsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.topmobile.bean.JsonViewObject;
import com.topmobile.bean.MobileBean;
import com.topmobile.bean.SessionUser;
import com.topmobile.entry.AdminUser;
import com.topmobile.entry.Malls;
import com.topmobile.entry.MobileConfig;
import com.topmobile.entry.MobileModel;
import com.topmobile.msg.Message;
import com.topmobile.msg.MessageQueue;
import com.topmobile.msg.SMSMessage;
import com.topmobile.service.AdminService;
import com.topmobile.service.HotMobileService;
import com.topmobile.service.MallsService;
import com.topmobile.util.ApiResponseCode;
import com.topmobile.util.HttpClient;
import com.topmobile.util.JSONUtils;
import com.topmobile.util.RandomStringUtil;
import com.topmobile.util.SessionUserUtil;
import com.topmobile.util.SpringUtil;
import com.topmobile.util.Strings;

/**
 * 管理后台请求
 *
 * @author wgl
 * @date 2017年7月23日 上午9:33:23
 */
@RequestMapping("api/admin/*")
@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService ;
	@Autowired
	HotMobileService hotMobileService ;
	@Autowired
	MallsService mallsService ;

	@RequestMapping("sign/login")
	@ResponseBody
	public Object signIn(HttpSession session ,String account,String pwd){
		if(Strings.isEmpty(account)||Strings.isEmpty(pwd)){
			return new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL, "参数错误");
		}
		AdminUser user = adminService.findByAccountAndPWd(account, pwd);
		if(user==null){
			return new JsonViewObject(401, "账号 或密码错误");
		}
		bindSessionAdminUser(new SessionUser(user.getId(), "100",user.getAccount() ,user.getName()), session);
		return new JsonViewObject(ApiResponseCode.SUCCESS_OK, "登录成功");
	}
	@RequestMapping("mobile/save")
	@ResponseBody
	public Object saveModel(HttpSession session , MobileBean mobile){
		/**
		 * 检查参数
		 */
		if( Strings.isEmpty(mobile.getMallCode()) 
				||Strings.isEmpty(mobile.getMallCode())
				||Strings.isEmpty(mobile.getDescribe())
				||Strings.isEmpty(mobile.getPanicBuyDate())
				||Strings.isEmpty(mobile.getBuyLink())
				){
			return new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL, "请填写完整");
		}
		hotMobileService.saveOne(mobile);
		return new JsonViewObject(ApiResponseCode.SUCCESS_OK, "保存成功");
	}
	/**
	 * 查询手机机型列表
	 * @param size
	 * @param page
	 * @return
	 */
	@RequestMapping("mobile/model/list")
	@ResponseBody
	public JsonViewObject getMobiles(int size ,int page){
		JsonViewObject view = null;
		if(size<1||page<1){
			view = new JsonViewObject(401, "参数错误");
		}else{
			Page<MobileModel> lists = hotMobileService.findPage(size,page);
			view = new JsonViewObject(200, "ok", lists);
		}
	
		return view;
	}
	/**
	 * 添加机型接口
	 * @param name
	 * @return
	 */
	@RequestMapping("mobile/model/add")
	@ResponseBody
	public JsonViewObject addModel(String name){
		JsonViewObject view = null;
		if(Strings.isEmpty(name)){
			view = new JsonViewObject(401, "参数错误");
		}else{
			int addresult = hotMobileService.insertModel(name);
			if(addresult==1){
				view = new JsonViewObject(ApiResponseCode.SUCCESS_OK, "添加成功");
			}else if(addresult==2){
				view = new JsonViewObject(402, "机型已经存在");
			}else{
				view = new JsonViewObject(ApiResponseCode.ERROR_FAILED, "添加失败");
			}
		}
		return view ;
	}
	
	/**
	 * 添加机型配置接口
	 * @param name
	 * @return
	 */
	@RequestMapping("mobile/config/add")
	@ResponseBody
	public JsonViewObject addModel(MobileConfig config){
		JsonViewObject view = null;
		if(Strings.isEmpty(config.getColor())
				||Strings.isEmpty(config.getMemory()) 
				||Strings.isEmpty(config.getModel()) ){
			view = new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL, "参数错误");
		}else{
			int addresult = hotMobileService.insertModelConfig(config);
			if(addresult==1){
				view = new JsonViewObject(ApiResponseCode.SUCCESS_OK, "添加成功");
			}else if(addresult==2){
				view = new JsonViewObject(ApiResponseCode.ERROR_NOT_EXIST, "机型不存在");
			}else{
				view = new JsonViewObject(ApiResponseCode.ERROR_FAILED, "添加失败");
			}
		}
		return view ;
	}
	
	@RequestMapping("mall/add")
	@ResponseBody
	public JsonViewObject addMalls(Malls mall){
		//检查参数
		if(Strings.isEmpty(mall.getName())
				||Strings.isEmpty(mall.getLink())){
			return new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL, "参数错误");
		}
		int errorCode = 0;
		try {
			errorCode = mallsService.insertOne(mall);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonViewObject(ApiResponseCode.ERROR_FAILED, "保存失败");
		}
		
		return errorCode >0  ? new JsonViewObject(403, errorCode==1? "商城名字已存在":"商城代码已存在")
		 : new JsonViewObject(ApiResponseCode.SUCCESS_OK, "保存成功");
	}
	
	@RequestMapping("mall/listall")
	@ResponseBody
	public JsonViewObject addMalls(){
		try {
			List<Malls> malls = mallsService.findAll();
			return new JsonViewObject(ApiResponseCode.SUCCESS_OK,
					"OK", malls);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonViewObject(ApiResponseCode.ERROR_FAILED, "查询失败");
		}
		
	}
	@RequestMapping("sms/sendtip")
	@ResponseBody
	public JsonViewObject setQiangGouSMS(HttpServletRequest request){
		ServletContext context = request.getSession().getServletContext();
		String timesKey = "sms_notice_times";
		Integer times = (Integer) context.getAttribute(timesKey);
		if(times==null){
			times = 0;
		}
		if(times>=5){
			return new JsonViewObject(ApiResponseCode.QUERY_FAIL, "今天统一发送通知次数用完了");
		}
		JUANsms juaNsms = new JUANsmsImpl();
		String content = "于总提醒您，最新抢购信息已发布，验证码%s，现在有货，查看群内消息，小米华为资格";
		String content2 = "各位抢手好，我是小米华为资格群的于总，今后有相关重要抢购信息，我会不定时给大家发送短信，若看到消息，及时查看群内动态，编号%s。";
		String content3 = "于总提醒您，今晚%s有手机抢购，请查看群内通知。小米华为资格";
		String phone = "";
		String geturl = "http://ljf123.cn/index.php/MobleMember/getAllPhone?value=kfdsjfdsjf312321jkfjdks12312321";
		HttpClient client = new HttpClient(geturl, 3000, 3000);
		try {
			int httpcode = client.sendGet("utf-8");
			if(httpcode==200){
				JSONObject json = JSONUtils.parse(client.getResult());
				Integer state = 0;
				JSONArray phones = null;
				if(!json.containsKey("state")){
					return new JsonViewObject(0, "获取手机号码接口错误");
				}
				state = json.getInteger("state");
				phones = json.getJSONArray("data");
				for (Object object : phones) {
					phone = (String) object ;
					//juaNsms.sendChuFa(phone, String.format(content, RandomStringUtil.createStrings()));
					MessageQueue.put(new SMSMessage(phone, String.format(content3, RandomStringUtil.createStrings())));
				}
				
			}
			client.getResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		times++;
		context.setAttribute(timesKey, times);
		return new JsonViewObject(ApiResponseCode.SUCCESS_OK, "发送成功");
	}
	
	public SessionUser getLoginUser(HttpSession session){
		
		return SessionUserUtil.getUserAttr(session);
	}
	
	public void bindSessionAdminUser(SessionUser user,HttpSession session){
		SessionUserUtil.setUserAttr(session, user);
	}
}
