
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;




public class DaemonFromFactory implements Runnable{
	public void run(){
		try{
			while(true){
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+this);
			}
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}
	}
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		
		for(int i=0;i<10;i++)
			exec.execute(new DaemonFromFactory());
		System.out.println("All Daemons started");
		TimeUnit.MILLISECONDS.sleep(500);
	}
}
class DaemonThreadFactory implements ThreadFactory{
	public Thread newThread(Runnable r){
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}
}
class LiftOff implements Runnable{
	protected int countDown = 10 ;
	private static int taskCount = 0 ;
	private final int id = taskCount++;
	public LiftOff(){}
	public LiftOff(int countDown){
		this.countDown = countDown;
	}
	public String status(){
		return "#"+id+"("+(countDown>0?countDown:"LiftOff!")+"),";
	}
	public void run(){
		while(countDown-->0){
			System.out.print(status());
			Thread.yield();
		}
		
	}
	
}