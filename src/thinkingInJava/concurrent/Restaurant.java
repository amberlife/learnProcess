package thinkingInJava.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal{
	private final int orderNum;
	public Meal(int orderNum){
		this.orderNum = orderNum;
	}
	public String toString(){
		return "Meal "+orderNum;
	}
}

class Waiter implements Runnable{
	private Restaurant restaurant;
	public Waiter(Restaurant restaurant){
		this.restaurant = restaurant;
	}
	public void serveMeal(){
		try{
		while(!Thread.interrupted()){
			synchronized(this){
				while(restaurant.meal==null){
				//	System.out.println("restaurant waiter is waiting serve a meal");
						wait();
				}
			}
			System.out.println(" restaurant waiter has served the "+restaurant.meal);
		
			synchronized(restaurant.chef){
				restaurant.meal=null;
				restaurant.chef.notifyAll();
			}
		}
		}catch(InterruptedException e){
			System.out.println("waiter interrupted");
		}
	}
	public void run(){
		serveMeal();
	}
}

class Chef implements Runnable  {
	public static int  count = 0 ;
	private Restaurant restaurant ; 
	public Chef(Restaurant restaurant){
		this.restaurant = restaurant;
	}
	public void makeMeal()  {
		try{
			while(!Thread.interrupted()){
				synchronized(this){
					while(restaurant.meal!=null){
						//System.out.println("restaurant chef is waiting for make a meal");
							wait();
					}
				}
				
				if(count==10){
					restaurant.exec.shutdownNow();
				}
				
				synchronized(restaurant.waiter){
					restaurant.meal = new Meal(count++);
					System.out.println("chef has made a meal"+restaurant.meal);
					restaurant.waiter.notifyAll();
				}
			}
		}catch(InterruptedException e){
			System.out.println("chef Interrupted");
		}
	}
	
	public void run(){
			makeMeal();
	}
}

public class Restaurant {
	Meal meal ; 
	Waiter waiter;
	Chef chef;
	ExecutorService exec = Executors.newCachedThreadPool();
	public Restaurant(){
		waiter = new Waiter(this);
		chef = new Chef(this);
		exec.execute(waiter);
		exec.execute(chef);
	}
	
	public static void main(String[] args) throws InterruptedException {
		 new Restaurant();
		//TimeUnit.MILLISECONDS.sleep(5);
		//restaurant.exec.shutdownNow();
	}
}
