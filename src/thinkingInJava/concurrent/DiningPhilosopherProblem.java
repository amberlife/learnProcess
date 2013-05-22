package thinkingInJava.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Chopstick{
	private boolean taken = false;
	public synchronized void take() throws InterruptedException {
		while(taken)
			wait();
		taken = true;
	}
	public synchronized void drop(){
		taken = false; 
		notifyAll();
	}
}

class Philosopher implements Runnable{
	private Chopstick left;
	private Chopstick right;
	private final int id; 
	private final int ponderFactor;
	private Random rand = new Random(47);
	private void pause() throws InterruptedException{
		if(ponderFactor==0) return ;
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor*250));
	}
	public Philosopher(Chopstick left,Chopstick right,int id,int ponder){
		this.left = left;
		this.right = right;
		this.id = id;
		this.ponderFactor= ponder;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				System.out.println(this+" "+" thinking");
				pause();
				System.out.println(this+" grab the right ");
				right.take();
				System.out.println(this+" grab the left");
				left.take();
				System.out.println("eating");
				pause();
				right.drop();
				left.drop();
			}
		}catch(InterruptedException e){
			System.out.println(this+"  exiting via interrupt");
		}
	}
	public String toString(){
		return "Philosopher "+id;
	}
}

public class DiningPhilosopherProblem {
	public static void main(String[] args) throws InterruptedException {
		int ponder = 1; 
		int size=5;
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[size];
		for(int i=0;i<size;i++)
			sticks[i]= new Chopstick();
		for(int i=0;i<size;i++){
			/* 破坏死锁的必要条件
			 * if(i<(size-1))
				exec.execute(new Philosopher(sticks[i],sticks[i+1],i,ponder));
			else
				exec.execute(new Philosopher(sticks[0],sticks[1],i,ponder));*/
			exec.execute(new Philosopher(sticks[i],sticks[(i+1)%size],i,ponder));
		}
		//TimeUnit.SECONDS.sleep(5);
		//exec.shutdownNow();
	}
}
