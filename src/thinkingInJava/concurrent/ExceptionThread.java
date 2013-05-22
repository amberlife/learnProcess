package thinkingInJava.concurrent;

public class ExceptionThread implements Runnable{
	public void run(){
		throw new RuntimeException();
	}
	public static void main(String[] args){
		Thread t = new Thread(new ExceptionThread());
		t.start();
	}
}
