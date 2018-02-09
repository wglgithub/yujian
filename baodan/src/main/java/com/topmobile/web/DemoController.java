package com.topmobile.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("demo/**")
public class DemoController {

	@RequestMapping("demo1")
	@ResponseBody
	public Object demo1(){
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "测试");
		data.put("msg","测试成功");
		return data;
	}
}
