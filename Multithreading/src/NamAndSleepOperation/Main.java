package NamAndSleepOperation;

public class Main {
	public static void main(String[] args) {
		
		//naming of thread
	//	System.out.println(Thread.currentThread().getName()); // This is main thread
		Runnable runn = () -> {
			String threadName = Thread.currentThread().getName(); 
			// This is the way to get name of the thread .currentThread method return a Thread reference
			System.out.println("Creating thread by using lambda expression"+threadName);
		};
		Thread t3 = new Thread(runn,"Sub thread");
		//t3.start();
		
		//sleep example of thread
		Runnable runnable = () -> {

			System.out.println("Thread starts");
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Thread end");
		};
		Thread t = new Thread(runnable);
		t.start();
	}
}
