package com.topmobile.msg;
/**
 * 
 *消息接口
 * @author wgl
 * @date 2017年9月11日 下午5:20:25
 */
public interface Message {
	/**
	 * 获取消息类型
	 * @return
	 */
	public int getType();
	/**
	 * 消息体
	 * @return
	 */
	public Object getBody();
	
	/**
	 * 消息类型常量值
	 * @author wgl
	 * @date 2016年6月23日 下午7:02:56
	 */
	public static interface Type{
		//抢购短信提醒
		public int SMS_NOTICE_QIANGGOU = 301;
		
	}
	/**
	 * 序列化成JSON
	 * @return
	 */
	public String toJson();
}
