package com.spring.rabbitmq.anand.producer;

import java.util.concurrent.CountDownLatch;

public class MessageReceiver {
	private CountDownLatch downLatch=new CountDownLatch(1);
	public void receiveMsg(Product product)
	{
		System.out.println("receive msg :"+product);
		downLatch.countDown();
	}
	public CountDownLatch getCountDownLatch()
	{
		return downLatch;
	}

}
