package com.topmobile.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主要请求api
 *
 * @author wgl
 * @date 2017年7月16日 下午7:42:14
 */
@Controller
public class MainController {

	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(){
		
		return "redirect:v/baodan/sign";
	}
}
