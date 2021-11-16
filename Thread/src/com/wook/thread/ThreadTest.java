package com.wook.thread;

public class ThreadTest {
	
	public static void main(String[] args) throws InterruptedException{
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
		
		System.out.println("Main Thread Start");
		
		Thread arr[] = new Thread[3];
		for(int i = 0; i<3;i++) {
			Thread thread = new Thread(new ThreadSecond("Thread"+i));
			arr[i] = thread;
			arr[i].start();
		}
		
		for(int i = 0; i<3;i++)
			arr[i].join();
		
		System.out.println("Main Thread End");
		
		
	}

}
