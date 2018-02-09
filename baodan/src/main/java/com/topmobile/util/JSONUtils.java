package com.topmobile.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * JSON处理工具
 *
 * @author wgl
 * @date 2016年6月28日 下午1:33:38
 */
public class JSONUtils {

	/***
	 * 将JavaBean 序列化成JSON格式的字符串
	 * <br>该方法采用fastjson处理
	 * @param obj
	 * @return JSON格式的字符串
	 */
	public static String toJSON(Object obj){
		if(obj==null){
			return null ;
		}
		return  JSON.toJSONString(obj);
	}
	@Test
	public void toJSONDemo(){
		Map<String,String > maps = new HashMap<String, String>();
		maps.put("key1", "value1");
		maps.put("key2", "value2");
		maps.put("key3", "value3");
		maps.put("key4", "value4");
		String jsonString = toJSON(maps);
		System.out.println(jsonString);
		Map map2 = parseObject(jsonString, Map.class);
		System.out.println(map2);
	}
	/**
	 * 将json 格式的字符串反序列化成对象
	 * @param jsonString
	 * @param clazz 对象的class
	 * @return T
	 */
	public static <T> T parseObject(String jsonString,Class<T> clazz){
		return JSON.parseObject(jsonString, clazz);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T parseObject(String jsonString,TypeReference<T> type){
		return (T)JSON.parseObject(jsonString, type);
	}
	
	public static JSONObject parse(String text){
		return JSON.parseObject(text);
	}
	@Test
	public void parseObjectDemo(){
		List<Group> gs = new ArrayList<Group>(4);
		gs.add(new Group("测试组", 3));
		gs.add(new Group("设计组", 2));
		gs.add(new Group("开发组", 13));
		String jsonString = toJSON(gs);
		System.out.println(jsonString);
		//反序列化
		gs = parseObject(jsonString, new TypeReference<List<Group>>(){});
		System.out.println(gs);
	}
	
	@SuppressWarnings("rawtypes")
	public static class TypeReference<T> extends com.alibaba.fastjson.TypeReference{

		public TypeReference() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TypeReference(Type... arg0) {
			super(arg0);
			// TODO Auto-generated constructor stub
		}
		
	}
	/**
	 * 判断字符串是否是JSON格式
	 * @param msgSrc
	 * @return
	 */
	public static boolean isJson(String msgSrc) {
		if(Strings.isEmpty(msgSrc)){
			return false;
		}
		try {
			JSON.parse(msgSrc);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}

class Group {
	private String name ;
	private int num ;
	
	public String getName() {
		return name;
	}
	public int getNum() {
		return num;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Group() {}
	public Group(String name,int num) {
		this.name = name ;
		this.num = num ;
	}
}
