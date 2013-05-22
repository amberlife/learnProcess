package thinkingInJava.generic;

import java.util.Iterator;

public class Fibonacci implements Generator<Integer>,Iterable<Integer>{
	private int count = 0 ;
	private int size;
	public Fibonacci(){}
	public Fibonacci(int size){
		this.size = size;
	}
	
	private int fib(int n){
		if(n<2) return 1;
		return fib(n-2)+fib(n-1);
	}
	
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new FibonacciIterator();
	}

	@Override
	public Integer next(){
		return fib(count++);
	}
	
	class FibonacciIterator implements Iterator<Integer>{
		public boolean hasNext() {
			return Fibonacci.this.size>0;
		}
		public Integer next() {
			Fibonacci.this.size--;
			return  Fibonacci.this.next();
		}
		public void remove() {
			
		}
	}
	
	public static void main(String[] args) {
		for(Integer val:new Fibonacci(18)){
			System.out.print(val+" ");
		}
	}
	
}
