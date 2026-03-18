package UseOfDemonThread;

/*
 * If a thread is running then Java virtual Machine will keep alive even after main thread end.
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		Runnable runnable = ()->{
			while(true) {
				sleep(1000);
				System.out.println("Running");
			}
		};
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);//This line ensure once main thread stops then even if this thread ru
		thread.start();
		sleep(3100);
		System.out.println("main thread end");
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
