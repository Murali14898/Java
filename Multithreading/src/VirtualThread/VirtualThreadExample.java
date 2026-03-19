package VirtualThread;

/*
 * Virtual thread concept is added from java 19
 * The existing Thread in java are called Platform Thread
 * These platform thread are executed by OS Thread
 * But Virtual Thread executed by Platform Thread which is executed by OS THread
 * When a virtual Thread created it is not mounted on Platform Thread
 * When a platform Thread is ready then it mounted Virtual thread and excuted.
 * JVM keep some Platform Thread ready to execute Virtual Thread
 * It is typically keep approximately same no of Platform Thread as your CPU core
 * 
 * In some cases when virtual thread are doing some operation that blocks it for example
 *      1. N/w call using blocking IO
        2. It calls concurrent Data Structure which blocks the thread waiting signal from anoter thread
        
 * In such example Virtual Thread get blocked and unmounted from Platform Thread
 * Then Platform Thread take another VT for execution which is ready.
 * Once the blocked VT get signal from n/w or unlocked by the concurrent DS it will again come to ready queue
 * This means we can use the Platform thread in a better way in logic like where executing lot of code / concurrent DS
 * Instead of blocking entire Platform Thread we are locking VT.
 * Additionally VT require less memory as it is light weight.
 * Where there is hard to run 1million platform thread in a application , it can be possible to run 1mn VT.
 */
public class VirtualThreadExample {
	public static void main(String[] args) {
		
	}
}
