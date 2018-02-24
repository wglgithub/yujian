package com.topmobile.util;
/**
 * api返回状态码
 *
 * @author wgl
 * @date 2017年8月9日 上午10:30:38
 */
public interface ApiResponseCode {
	public int NO_SIGN = 403 ;
	//参数格式错误
	public int ERROR_ARGS_ILLEGAL = 400;
	//操作出错或失败
	public int ERROR_FAILED = 500;
	//操作对象不存在
	public int ERROR_NOT_EXIST = 404;
	//操作成功
	public int SUCCESS_OK = 200;
	//操作失敗
	public int QUERY_FAIL = 0;
	
	public int LOGIN_FAIL = 0;
	public int LOGIN_OK = 200;
	
	public int LOGIN_ACC_DISABLE=201 ;
}
