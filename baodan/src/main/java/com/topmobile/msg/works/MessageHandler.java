package com.topmobile.msg.works;

import com.topmobile.msg.Message;
import com.topmobile.msg.MessageListener;
import com.topmobile.msg.tasks.SmsBody;
import com.topmobile.msg.tasks.SmsClient;

public class MessageHandler implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		if(msg.getType()==Message.Type.SMS_NOTICE_QIANGGOU){
			
			sendNoticeSms((SmsBody) msg.getBody());
		}

	}

	private void sendNoticeSms(SmsBody sms) {
		new SmsClient(sms.getMobile(), sms.getBody()).start();
	}

}
