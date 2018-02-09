package com.topmobile.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.junit.Test;
import org.springframework.util.StringUtils;
/**
 * String 工具类
 * @author wgl
 *
 */
public class Strings extends StringUtils{
	/**
	 * 按照UUID生成随机字符串,注意：返回的字符串中将“-”替换成了“”
	 * @return
	 */
	public static String UUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	public static  String MD5(String s) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] bytes = md.digest(s.getBytes("utf-8"));
	        return toHex(bytes);
	    }
	    catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

	private static String toHex(byte[] bytes) {

	    final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
	    StringBuilder ret = new StringBuilder(bytes.length * 2);
	    for (int i=0; i<bytes.length; i++) {
	        ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
	        ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
	    }
	    return ret.toString();
	}

	/**
	 * 检查字符串是否是空的
	 */
	@Test
	public void demo1(){
		String a = null;
		String b = "";
		String c = "i'm c";
		System.out.println("a isEmpty:"+isEmpty(a));
		System.out.println("b isEmpty:"+isEmpty(b));
		System.out.println("c isEmpty:"+isEmpty(c));
	}
	/**
	 * 检查字符串是否有空格
	 */
	@Test
	public void demo2(){
		String a = " abc",
				b = "a cb",
				c= "abc",
				d = null;
		System.out.println("a containsWhitespace:"+containsWhitespace(a));
		System.out.println("b containsWhitespace:"+containsWhitespace(b));
		System.out.println("c containsWhitespace:"+containsWhitespace(c));
		System.out.println("d containsWhitespace:"+containsWhitespace(d));
	}
	/**
	 * 检查字符串是否包含文本（空格不算文本）
	 */
	@Test
	public void demo3(){
		String a = null,
				b= "",
				c = " ",
				d = "abc" ;
		System.out.println("a hasText:"+hasText(a));
		System.out.println("b hasText:"+hasText(b));
		System.out.println("c hasText:"+hasText(c));
		System.out.println("d hasText:"+hasText(d));
	}
	/**
	 * 去除空白符
	 */
	@Test
	public void demo4(){
		String a = " abc ";
		String b = "a bc d";
		String c = " a bc d";
		System.out.println("a trimWhitespace: |"+trimWhitespace(a)+"|");
		System.out.println("b trimWhitespace: |"+trimWhitespace(b)+"|");
		System.out.println("c trimWhitespace: |"+trimWhitespace(c)+"|");
		
		System.out.println("a trimAllWhitespace: |"+trimAllWhitespace(a)+"|");
		System.out.println("b trimAllWhitespace: |"+trimAllWhitespace(b)+"|");
		System.out.println("c trimAllWhitespace: |"+trimAllWhitespace(c)+"|");
		
		System.out.println("a trimLeadingWhitespace: |"+trimLeadingWhitespace(a)+"|");
		System.out.println("b trimLeadingWhitespace: |"+trimLeadingWhitespace(b)+"|");
		System.out.println("c trimLeadingWhitespace: |"+trimLeadingWhitespace(c)+"|");
		
		System.out.println("a trimTrailingWhitespace: |"+trimTrailingWhitespace(a)+"|");
		System.out.println("b trimTrailingWhitespace: |"+trimTrailingWhitespace(b)+"|");
		System.out.println("c trimTrailingWhitespace: |"+trimTrailingWhitespace(c)+"|");
		
	}
	/**
	 * 替换字符串
	 */
	@Test
	public void demo5(){
		String a = "你好【图片】nceacae【图片】";
		System.out.println(replace(a, "【图片】", "<img src='a.jpg'/>"));
	}
}
