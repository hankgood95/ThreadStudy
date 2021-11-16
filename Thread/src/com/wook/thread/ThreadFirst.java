package com.wook.thread;

public class ThreadFirst extends Thread{
	
	public ThreadFirst(String threadName) {
		super(threadName);
	}
	
	public void run() {
		for(int i = 0; i<10;i++) {
			System.out.println(this.getName()+ " : "+ i);
		}
		System.out.println();
	}
	
}
