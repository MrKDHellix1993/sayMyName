package multithreading;

public class ThreadConcepts {

	public static boolean flag = true; // If we don't add volatile Thread t1 will be in infinite loop

	/*
	 * Java Thread Volatile Concept : We use volatile to make shared varibles
	 * visible amongets each Thread
	 */

	public static void createRunnables() {
		Runnable r1 = () -> {
			runnableTask1();
		};

		Runnable r2 = () -> {
			runnableTask2();
		};
		generateThread(r1, r2);
	}

	public static void runnableTask1() {
			while (flag) {
				System.out.println("Hey Hi I am excuter My Thread ID is > " + Thread.currentThread().getId() + " "
						+ Thread.currentThread().getName() + "Keep executing");
			}
	}

	public static void runnableTask2() {
			System.out.println("Current Thread " + Thread.currentThread().getId() + "  "
					+ Thread.currentThread().getName() + " flag value before " + flag);
			flag = flag ? false : true;
			System.out.println("My Thread ID is > " + Thread.currentThread().getId() + " flag value after " + flag);
	}

	public static void generateThread(Runnable r1, Runnable r2) {
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		createRunnables();
	}
}
