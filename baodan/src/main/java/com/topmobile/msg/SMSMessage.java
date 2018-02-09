package com.topmobile.msg;

import com.topmobile.msg.tasks.SmsBody;
import com.topmobile.util.JSONUtils;

public class SMSMessage implements Message {
	
	public int type = Message.Type.SMS_NOTICE_QIANGGOU;
	
	private SmsBody body ;
	public SMSMessage(String mobile,String content) {
		this.body = new SmsBody(mobile, content);
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public SmsBody getBody() {
		return body;
	}

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return JSONUtils.toJSON(body);
	}

}
