package thinkingInJava.concurrent;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<Integer> {
	private int count;
	public TaskWithResult(int id){
		this.count = id;
	}
	
	public int f(int i){
		if(i<2) return 1;
		return f(i-1)+f(i-2);
	}
	
	public Integer call(){
		return f(count);
	}
}
