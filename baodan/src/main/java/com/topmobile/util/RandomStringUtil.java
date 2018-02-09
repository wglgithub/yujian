package com.topmobile.util;

import java.util.Random;
//随机生成6位字母与数字组成的字符串
public class RandomStringUtil {
	//随机验证码字符集
	private static final char[] chars = { 
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K','M', 'N', 
		'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'm',
		'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	//生成字符串长度
	private static final int count = 6;
	//生成随机字符串
	public static String createStrings(){
		//定义一个长度为6的数组
		char ch[] = new char[count];
		Random ran = new Random();
		//循环生成随机字符并将其放入指定数组中
		for(int i = 0;i < count;i++){
			Integer n = ran.nextInt(chars.length);
			ch[i] = chars[n];
		}
		//将数据转换成字符串并返回
		return String.valueOf(ch);
	}
	public static void main(String[] args) {
		String s = createStrings();
		System.out.println("s: "+s);
	}
	
}
