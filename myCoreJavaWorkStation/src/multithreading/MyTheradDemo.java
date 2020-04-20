package multithreading;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import myInterview.GFG;;

public class MyTheradDemo {
	public static void main(String[] arg) throws InterruptedException {
		
		int coreCount = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(coreCount);
		
		Thread mt1 = new Thread(new MyThread());
		Thread mt2 = new Thread(new MyThread());
		Thread mt3 = new Thread(new MyThread());
		
//		Future<MyThread> fmt1 = (Future<MyThread>) executor.submit(mt1);
		mt3.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("m1" + Thread.currentThread().getId());
		System.out.println("m2" + Thread.currentThread().getId());
		System.out.println("m3" + Thread.currentThread().getId());
		executor.submit(mt1);
		executor.submit(mt2);
		executor.submit(mt3);
		/*
		 * List<Runnable> mr = executor.shutdownNow(); System.out.println(mr);
		 */
		GFG.getBooleanMatrix();
		
	}

}

class MyThread implements Runnable {
	@Override
	public void run() {
        for (int i = 1; i < 10; i++)
            try {
            System.out.println(i + " ThreadID: " + Thread.currentThread().getId());
            Thread.sleep(1000);
            if (Thread.interrupted()) 
                    throw new InterruptedException();
            } catch (InterruptedException e) {
                return;
        }   
	}
}