package com.topmobile.bean;

import java.io.Serializable;

import com.topmobile.util.JSONUtils;

/**
 * json视图父类,
 * <br>
 * 如果有特殊返回字段，可继承这个类
 * @author wgl
 *
 */
public class JsonViewObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 518691607332491843L;
	/**
	 * 处理结果 1=成功,其他情况可自定义
	 */
	private int status ;
	/**
	 * 处理结果的文字描述
	 */
	private String msg ;
	/**
	 * 返回的数据
	 */
	private Object data ;
	
	
	
	public JsonViewObject() {
	}
	public JsonViewObject(int status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public JsonViewObject(int status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public String toJson(){
		return JSONUtils.toJSON(this);
	}

}
