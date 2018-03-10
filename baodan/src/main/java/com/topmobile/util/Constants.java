package com.topmobile.util;
/**
 * 常量工具类
 *
 * @author wgl
 * @date 2017年11月24日 下午3:10:32
 */
public class Constants {

	/**
	 * 用户角色
	 *
	 * @author wgl
	 * @date 2017年11月24日 下午3:10:47
	 */
	public static interface Role{
		String DAI_LI ="agent";
		String QIANG_SHOU="worker";
		String SUPPER_ADMIN = "admin";
	}
	public static interface CurrentState{
		String NOT_SURE = "未确认";
		String SURE = "已确认";
		String SEND = "已发货";
		String SIGN = "已签收";
		String HUIKUAN_ADMIN = "群主回款";
		String HUIKUAN_AGENT = "代理回款";
	}
	public static interface WuliuState{
		String WAIT = "未发货";
		String SEND = "已发货";
		String SIGN = "已签收";
	}
	
	public static interface SureState{
		String WAIT = "未确认";
		String SURE = "已确认";
	}
	
	public static interface PaymentState{
		String WAIT = "未回款";
		String RETURNED = "已回款";
	}
}
