package com.topmobile.msg.tasks;

import juan.sms.JUANsms;
import juan.sms.JUANsmsImpl;

/**
 * 短信发送client
 *
 * @author wgl
 * @date 2017年9月11日 下午5:42:08
 */
public class SmsClient extends Thread{
	private String phone ;
	
	private String content ;
	
	public SmsClient(String phone,String content) {
		this.phone = phone;
		this.content = content;
	}

	@Override
	public void run() {
		JUANsms juaNsms = new JUANsmsImpl();
		juaNsms.sendChuFa(phone, content);
	}
}
