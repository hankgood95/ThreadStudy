package com.wook.thread;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadCallback implements Runnable{

	private String threadName;
	private ThreadPoolExecutor te;
	private CountDownLatch cdl;
	private TestDto td;
	private CompletionHandler<TestDto,Void> callBack;
	
	public ThreadCallback(String threadName, ExecutorService exs, CountDownLatch cdl,
			CompletionHandler<TestDto, Void> callBack) {
		super();
		this.threadName = threadName;
		this.te = (ThreadPoolExecutor) exs;
		this.cdl = cdl;
		this.callBack = callBack;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(te.getPoolSize());
		System.out.println("API call");
		try {
			Thread.sleep(6000);
			callBack.completed(new TestDto(threadName,te.getPoolSize()), null);
			cdl.countDown();
			System.out.println();
			System.out.println("API call success");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
