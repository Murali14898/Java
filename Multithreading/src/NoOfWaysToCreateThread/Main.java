package NoOfWaysToCreateThread;

public class Main {
	
	//1: By extending Thread class
	public static class MyThread extends Thread{
		public void run() {
			System.out.println("Creating thread by extending Thread class");
		}
	}
	//2: By implementing Runnable interface
	public static class MyRunnable implements Runnable{

		@Override
		public void run() {
			System.out.println("Creating thread by implementing Runnable interface");
			
		}
		
	}
	
	public static void main(String[] args) {
		Thread t = new MyThread();
		t.start();
		Runnable r = new MyRunnable();
		Thread t1 = new Thread(r);
		t1.start();
		
		//3: Implementing Runnable interface as an Ananymous class
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Creating thread by using Ananymous class");
				
			}
		};
		Thread t2 = new Thread(runnable);
		t2.start();
		
		//4: Implementing Runnable inteface using java lambda expression
		Runnable runn = ()->{
			
			System.out.println("Creating thread by using lambda expression");
		};
		Thread t3 = new Thread(runn);
		t3.start();
	}

}
