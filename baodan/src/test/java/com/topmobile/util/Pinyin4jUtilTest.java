package com.topmobile.util;

import org.junit.Test;

public class Pinyin4jUtilTest {

	@Test
	public void converterToFirstSpellTest(){
		String chinese = "3于建";
		System.out.println("姓名:"+chinese);
		String quanpin = Pinyin4jUtil.converterToSpell(chinese);
		System.out.println("全拼:"+quanpin);
		System.out.println("首字母:"+Pinyin4jUtil.converterToFirstSpell(chinese));
		System.out.println("索引字符:"+quanpin.charAt(0));
	}
}
