package com.topmobile.msg.tasks;

public class SmsBody {

	private String mobile ;
	
	private String body ;
	
	
	public SmsBody(String mobile,String body) {
		this.mobile = mobile ;
		this.body = body ;
	}
	
	
	public String getBody() {
		return body;
	}
	
	public String getMobile() {
		return mobile;
	}
}
