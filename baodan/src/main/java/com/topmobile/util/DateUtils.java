package com.topmobile.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间操作工具类
 *
 * @author wgl
 * @date 2016年6月30日 下午3:57:30
 */
public class DateUtils {
	
	public static interface Formatter{
		/**
		 * 默认格式 yyyy-MM-dd HH:mm:ss
		 */
		public String DEFAULT = "yyyy-MM-dd HH:mm:ss";
		
	}
	/**
	 * 将时间毫秒数 格式化为{yyyy-MM-dd HH:mm:ss}格式的日期字符串
	 * @param time 时间毫秒数
	 * @return
	 */
	public static String timeFormat(long time){
		return dateFormat(new Date(time), Formatter.DEFAULT);
	}
	/**
	 * 将时间毫秒数 格式化为指定格式的日期字符串
	 * @param time 时间毫秒数
	 * @param format 日期格式
	 * @return
	 */
	public static String timeFormat(long time,String format){
		return dateFormat(new Date(time), format);
	}
	/**
	 * 将时间Date 类型格式化为指定日期字符串
	 * @param date 日期
	 * @param format 日期格式
	 * @return
	 */
	public static String dateFormat(Date date,String format){
		return new SimpleDateFormat(format).format(date);
	}
	/**
	 * 获取今天最后时刻(23:59:59:999)的毫秒值
	 * @return
	 */
	public static long dayEndTime(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		
		return c.getTimeInMillis();
	}
}
