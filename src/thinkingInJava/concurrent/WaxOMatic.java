package thinkingInJava.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class Car{
	private boolean waxOn = false ;
	public synchronized void waxed(){
		waxOn = true;
		notifyAll();
	}
	public synchronized void buffed(){
		waxOn = false;
		notifyAll();
	}
	public synchronized void waitForWaxing() throws InterruptedException{
		while(waxOn==false)
			wait();
	}
	public synchronized void waitForBuffing() throws InterruptedException{
		while(waxOn==true)
			wait();
	}
}

class WaxOn implements Runnable{
	private Car car; 
	public WaxOn(Car c){car = c;}
	public void run(){
		try{
			while(!Thread.interrupted()){
				System.out.println("Wax on");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		}catch(InterruptedException e){
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax On task");
	}
}

class WaxOff implements Runnable{
	private Car car; 
	public WaxOff(Car c){car = c;}
	public void run(){
		try{
			while(!Thread.interrupted()){
				System.out.println("Wax off");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
				car.waitForWaxing();
			}
		}catch(InterruptedException e){
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending buff on task");
	}
}

public class WaxOMatic {
	public static void main(String[] args) throws InterruptedException {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.MILLISECONDS.sleep(5000);
		exec.shutdownNow();
	}
	
	
}
