package com.wook.thread;

import java.nio.channels.CompletionHandler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		// TODO Auto-generated method stub
		
		
		//In thread running order is not prdeictable
		
		//Thread created by extending Thread
		//This method is not mainly used
//		System.out.println("Main Thread Start");
//		for(int i = 0; i<10;i++) {
//			new ThreadFirst("Thread"+i).start();
//		}
//		System.out.println("Main Thread End");
		
		//Thread created by implementing Runnable
		//This method is mainly used to make a thread
		//In order to start() thread created by implementing Runnable class must create a Thread instance and run start()
//		System.out.println("Main Thread Start");
//		for(int i = 0; i<10;i++) {
//			Thread thread = new Thread(new ThreadSecond("Thread"+i));
//			thread.start();
//		}
//		System.out.println("Main Thread End");
		
		//In the code above main thread ends at weird part
		//If you want to fix this issue you can use 'join'
		//'join' can be used to keep a thread waiting at a certain point.
		
		//However , if you use 'join' InterruptedException occurs,
		//So you should throw or try catch that part.
		
//		System.out.println("Main Thread Start");
//		
//		Thread arr[] = new Thread[3];
//		for(int i = 0; i<3;i++) {
//			Thread thread = new Thread(new ThreadSecond("Thread"+i));
//			arr[i] = thread;
//			arr[i].start();
//		}
//		
//		for(int i = 0; i<3;i++)
//			arr[i].join();
//		
//		System.out.println("Main Thread End");
		
//		System.out.println("Main Thread Start");
//		System.out.println(Calendar.getInstance().getTime());
//		
//		//ExecutorService 인터페이스 구현객체 Executors 정적 메소드를 통해 최대 스레드 개수가 3인 스레드 풀을 만듬
//		ExecutorService exs = Executors.newFixedThreadPool(500); 
//		
//		for(int i = 0; i<1667;i++) {
//			exs.submit(new ThreadPool("tpn"+i,exs));
//		}
//		
//		System.out.println("Main Thread End");
		
//		System.out.println("Main Thread Start");
//		System.out.println(Calendar.getInstance().getTime());
//		
//		//ExecutorService 인터페이스 구현객체 Executors 정적 메소드를 통해 최대 스레드 개수가 3인 스레드 풀을 만듬
//		CountDownLatch countDownLatch = new CountDownLatch(1667);
//		ExecutorService exs = Executors.newFixedThreadPool(500); 
//		
//		for(int i = 0; i<1667;i++) {
//			exs.submit(new ThreadPool("tpn"+i,exs,countDownLatch));
//		}
//		exs.shutdown();
//		countDownLatch.await();
//		System.out.println("Main Thread End");
//		System.out.println(Calendar.getInstance().getTime());
		
		
		System.out.println("Main Thread Start");
		System.out.println(Calendar.getInstance().getTime());
		
		//ExecutorService 인터페이스 구현객체 Executors 정적 메소드를 통해 최대 스레드 개수가 3인 스레드 풀을 만듬
		CountDownLatch countDownLatch = new CountDownLatch(1677);
		ExecutorService exs = Executors.newFixedThreadPool(500);
		
		ArrayList<TestDto> tdl = new ArrayList<TestDto>();
		
		CompletionHandler<TestDto,Void> callBack = 
				new CompletionHandler<TestDto,Void>(){

					//성공했을떄
					@Override
					public void completed(TestDto result, Void attachment) {
						// TODO Auto-generated method stub
						tdl.add(result);
					}
					
					//실패했을때
					@Override
					public void failed(Throwable exc, Void attachment) {
						// TODO Auto-generated method stub
						System.out.println("failed");
					}
			
		};
		
		for(int i = 0;i<1677;i++) {
			exs.submit(new ThreadCallback("Thread"+i,exs,countDownLatch,callBack));
		}
		
		exs.shutdown();
		countDownLatch.await();
		System.out.println("Main Thread End");
		if(tdl.isEmpty()) {
			System.out.println("시발 비어 있네");
		}else {
			System.out.println(tdl.size());
		}
		
		System.out.println(Calendar.getInstance().getTime());
		
	}

}
