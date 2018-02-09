package com.topmobile.test;

import juan.sms.JUANsms;
import juan.sms.JUANsmsImpl;

public class TestSms {

	public static void main(String[] args) {
		JUANsms juaNsms = new JUANsmsImpl();
		String content = "于总提醒您，最新抢购信息已发布，现在有货，查看群内消息，小米华为资格,发送编号：%s请抓紧查看";
		System.out.println(String.format(content, 8992));
		String phone = "15530276893";
		juaNsms.sendChuFa(phone, String.format(content, 8992));
	}
}
