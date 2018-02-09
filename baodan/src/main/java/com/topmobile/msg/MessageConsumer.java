package com.topmobile.msg;

import org.apache.log4j.Logger;

public class MessageConsumer implements Runnable {

	Logger logger = Logger.getLogger(getClass());
	Thread thread ;
	
	MessageListener listener ;
	
	public void startWork(){
		if(thread==null){
			thread = new Thread(this);
			thread.start();
			logger.info("MessageConsumer start !");
		}
		logger.info("MessageConsumer allReady started !");
	}
	@Override
	public void run() {
		while(true){
			try {
				getListener().onMessage(MessageQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("MessageConsumer 执行任务时被打断", e);
			} catch (Exception e) {
				logger.info("MessageConsumer 执行任务时出异常", e);
			}
		}
		
	}
	
	public void setListener(MessageListener listener) {
		this.listener = listener;
	}
	
	public MessageListener getListener() {
		return listener;
	}

}
