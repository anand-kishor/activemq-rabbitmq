package com.spring.rabbitmq.anand.producer;

import java.util.concurrent.CountDownLatch;

public class MessageReceiver {
	private CountDownLatch downLatch=new CountDownLatch(1);
	public void receiveMsg(String message)
	{
		System.out.println("receive msg :"+message);
		downLatch.countDown();
	}
	public CountDownLatch getCountDownLatch()
	{
		return downLatch;
	}

}
