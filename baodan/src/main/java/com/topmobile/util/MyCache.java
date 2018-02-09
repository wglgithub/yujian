package com.topmobile.util;

import java.util.UUID;

import com.juan.wgl.cache.Cache;
import com.juan.wgl.cache.FIFOCache;

/**
 * 缓存服务
 * set方法会替换原有的数据, add方法会验证是否存在相同的key，如果存在相同的key，不写入数据
 * 参数 expTime 是过期时间，单位是秒
 * @author wgl
 *
 */
public class MyCache{

	private final static Cache<String, Object> cacheManager = new FIFOCache<String, Object>(4,0);
	
	public static boolean set(String key, Object value) {
		try {
			cacheManager.put(key, value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String set(Object value) {
		String key = uuid();
		try {
			cacheManager.put(key, value);
		} catch (Exception e) {
			return null;
		}
		return key;
	}

	public static String set(Object value, int expTime) {
		// TODO Auto-generated method stub
		String key = uuid();
		try {
			cacheManager.put(key, value,expTime*1000);
		} catch (Exception e) {
			return null;
		}
		return key;
	}

	public static boolean set(String key, Object value, int expTime) {
		// TODO Auto-generated method stub
		try {
			cacheManager.put(key, value,expTime*1000);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static Object get(String key) {
		
		return cacheManager.get(key);
	}

	public static boolean add(String key, Object value) {
		// TODO Auto-generated method stub
		if(get(key)!=null){
			return false;
		}
		return set(key, value);
	}

	public static String add(Object value) {
		// TODO Auto-generated method stub
		String key = uuid();
		return add(key, value) ? key:null;
	}

	public static String add(Object value, int expTime) {
		// TODO Auto-generated method stub
		String key = uuid();
		return add(key, value, expTime*1000) ? key:null;
	}

	public static boolean add(String key, Object value, int expTime) {
		// TODO Auto-generated method stub
		if(get(key)!=null){
			return false;
		}
		try {
			cacheManager.put(key, value, expTime*1000);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean delete(String key) {
		// TODO Auto-generated method stub
		try {
			cacheManager.remove(key);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
