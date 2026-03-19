package ThreadWaitingForAnotherThreadToComplete;

public class Main {

	public static void main(String[] args) {
		Runnable runnable = ()->{
			for(int i=0;i<5;i++) {
				sleep(2000);
				System.out.println("Running");
			}
		};
		Thread thread = new Thread(runnable,"Test thread");
		thread.setDaemon(true);
		thread.start(); //till this even if main thread ends jvm still run test thread because it is not demon
		
		//Since test thred sleeping time 2s and it is demon so nothing is printing because within 2s main thread end
		
		/*
		 * I want that main thread to wait for test thread to complete
		 * Use join() on test thread
		 */
		try {
			thread.join(); //Main thread will stop here until test thread complete itself
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main Thread end");//You could see this line will print at the last
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
