package com.jb.factorial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class Factorial {

	private Factorial() {}
	
	public static long calculateFactorial(long n) {
		
		if (n <= 1) {
			return 1;
		}
		
		return calculateFactorial(n - 1) * n;
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Single Thread: ");
		singleThread();
		
		System.out.println("Multi Thread: ");
		multiThread();
	}
	
	public static void singleThread() {
		// Time Now
		long timeNow = System.currentTimeMillis();
		
		// Calculate Factorial
		for (int i = 0; i < 1000000; i++) {
			calculateFactorial(55);
			//System.out.println(calculateFactorial(55));
		}
		
		// Time taken
		System.out.println(System.currentTimeMillis() - timeNow);
	}
	
	public static void multiThread() throws InterruptedException {
		// Time Now
		long timeNow = System.currentTimeMillis();
		
		// Cache the threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 2; i++) {
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					// Calculate Factorial
					for (int i = 0; i < (1000000 / 2); i++) {
						calculateFactorial(55);
						//System.out.println(calculateFactorial(55));
					}
				}
			});
		}
		
		// Shut down service
		executorService.shutdown();
		while(!executorService.awaitTermination(2, TimeUnit.MINUTES));
		
		// Time taken
		System.out.println(System.currentTimeMillis() - timeNow);
	}

}
