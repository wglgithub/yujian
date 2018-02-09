package com.topmobile.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestAuthUtil {
	public static void main(String[] args) {
		String uri = "v/baodan/admin/qc/home";
		System.out.println(parseModel(uri));
	}

	static String  parseModel(String uri){
		String res = null;
		Pattern pattern = Pattern.compile("(?<=v\\/baodan\\/)(.+?)(?=\\/)");
		Matcher matcher = pattern.matcher(uri);
		if(matcher.find()){
			res = matcher.group(); 
		}
		return res;
	}
}
