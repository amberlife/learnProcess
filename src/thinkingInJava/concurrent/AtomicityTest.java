package thinkingInJava.concurrent;

public class AtomicityTest implements Runnable {
	private int i=0;
	public int getValue(){return i;}
	private synchronized void evenIncrement(){i++;i++;}
	
	public void run(){
		while(true){
			evenIncrement();
		}
	}
}
