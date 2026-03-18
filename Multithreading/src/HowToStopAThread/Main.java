package HowToStopAThread;
/*
 * java Thread has stop method to stop(Depricated) the running thread but Problem is
 * 
 * we don't know where the Thread stop 
 * At what state the thread is.
 * For this problem We need to stop a thread gracefully
 */
public class Main {
	public static class StoppableRunnable implements Runnable{
		private boolean stopFlag = false;
		
		public synchronized void requestStop() {
			this.stopFlag = true;
		}
		
		public synchronized boolean isStopRequested() {
			return this.stopFlag;
		}
		
		@Override
		public void run() {
			System.out.println("StoppableRunnable running");
			while(!isStopRequested()) {
				sleep(1000); // ----- will print for 5 times . If 5000 then one time 
				System.out.println("------");
			}
			
		}

		private void sleep(long millis) {
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public static void main(String[] args) {
		StoppableRunnable st = new StoppableRunnable();
		Thread thread = new Thread(st,"MyThread");
		thread.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Request Stopping");
		st.requestStop();
		System.out.println("Thread stop");
	}

}
