package com.topmobile.util;

import com.topmobile.bean.JsonViewObject;

public class JsonViewFactory {

	public static JsonViewObject newSuccessInstance(Object data){
		return new JsonViewObject(ApiResponseCode.SUCCESS_OK, "OK", data);
	}
	public static JsonViewObject newSuccessInstance(){
		return new JsonViewObject(ApiResponseCode.SUCCESS_OK, "OK");
	}
	public static JsonViewObject newQueryFailInstance(String errorMsg){
		return new JsonViewObject(ApiResponseCode.QUERY_FAIL, errorMsg);
	}
	public static JsonViewObject newArgsIllegalInstance(String errorMsg){
		return new JsonViewObject(ApiResponseCode.ERROR_ARGS_ILLEGAL,errorMsg);
	}
	public static JsonViewObject newErrorInstance(String errorMsg){
		return new JsonViewObject(ApiResponseCode.ERROR_FAILED,errorMsg);
	}
	public static JsonViewObject newErrorNotExistInstance(String errorMsg){
		return new JsonViewObject(ApiResponseCode.ERROR_NOT_EXIST,errorMsg);
	}
}
