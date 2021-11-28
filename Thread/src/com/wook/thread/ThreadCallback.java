package com.wook.thread;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadCallback implements Runnable{

	private String threadName;
	private ThreadPoolExecutor te;
	private CountDownLatch cdl;
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
			TestDto td = new TestDto(threadName,te.getPoolSize()); //여기서 객체를 만드는데 객체가 null임
			System.out.println(td.toString());
			callBack.completed(td, null); //callback 메소드를 호출했을때 클래스 객체를 넘겨줌
			System.out.println("Finished Task : "+te.getCompletedTaskCount());
			System.out.println();
			System.out.println("API call success");
			cdl.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
