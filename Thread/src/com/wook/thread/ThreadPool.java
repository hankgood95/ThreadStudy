package com.wook.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool implements Runnable{
	
	private String threadName;
	private ThreadPoolExecutor te;
	
	public ThreadPool(String name,ExecutorService exs) {
		super();
		this.threadName = name;
		te = (ThreadPoolExecutor) exs;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(te.getPoolSize());
		
		System.out.println("API call");
		try {
			Thread.sleep(6000);
			System.out.println("API call success");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
	} 
	
}
