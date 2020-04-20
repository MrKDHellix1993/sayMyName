package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockBasics {

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	private void execute() {
		new Thread(this::processThis).start();;
		new Thread(this::processThat).start();;
	}

	public void processThis() {
		lock1.lock(); // process resource A
		lock2.lock(); // process resource A, B
//		System.out.println(" Dealock ouccured::processThis");
		
		lock1.unlock(); // release resource A
		lock2.unlock(); // release resource B
		
	}

	public void processThat() {
		lock2.lock(); // process resource A
		lock1.lock(); // process resource B
//		System.out.println(" Dealock ouccured::processThat");

		lock1.unlock(); // process resource A
		lock2.unlock(); // process resource B
		
	}

	public static void main(String[] arg) throws InterruptedException {
		DeadLockBasics dlb = new DeadLockBasics();
		dlb.execute();
	}
}
