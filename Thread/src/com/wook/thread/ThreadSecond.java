package com.wook.thread;

public class ThreadSecond implements Runnable{

	private String threadName;
	
	public ThreadSecond(String name) {
		super();
		this.threadName = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i<10;i++) {
			System.out.println(threadName+" : " + i);
		}
		System.out.println();
		
	}	
	
}
