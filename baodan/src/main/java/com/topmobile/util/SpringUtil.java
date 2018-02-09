package com.topmobile.util;

import javax.persistence.EntityManager;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;


public class SpringUtil  implements ApplicationContextAware{
	private static  ApplicationContext context;


	public static Object getBean(String beanId){
		
		return context.getBean(beanId);
	}
	
	public static void rejectContext(ApplicationContext context){
		System.out.println("测试注册 Context");
		if(SpringUtil.context==null){
			SpringUtil.context = context;
		}
	}
	/**
	 * 判断字符串是否为空 
	 * </br>
	 * 当字符串对象为null或者空字符串时返回true,否则返回false
	 * @param str 
	 * @return
	 */
	public static boolean isEmpty(String str){
		return StringUtils.isEmpty(str);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		rejectContext(arg0);
	}
	
	public static EntityManager getEntityManager(){
		return context.getBean(EntityManager.class);
	}
	
	public static ApplicationContext getApplicationContext(){
		return context;
	}
	
	
}
