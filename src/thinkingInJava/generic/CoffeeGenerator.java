package thinkingInJava.generic;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee> ,Iterable<Coffee> {
	private Class[] types ={Latte.class,Mocha.class,Cappuccino.class,Americano.class,Breve.class};
	private static Random  rand = new Random(47);
	public CoffeeGenerator(){}
	
	private int size=0;
	public CoffeeGenerator(int sz){
		size=sz;
	}
	
	public CoffeeGenerator test(){
		try {
			return this.getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Coffee next() {
		try{
			return (Coffee)types[rand.nextInt(types.length)].newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}
	
	class CoffeeIterator implements Iterator<Coffee>{
		int count = size; 
		public boolean hasNext(){return count>0;}
		public Coffee next(){
			count--;
			return CoffeeGenerator.this.next();
		}
		public void remove(){
			
		}
	}
	
	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();
		for(int i=0;i<5;i++){
			System.out.println(gen.next());
		}
		for(Coffee c:new CoffeeGenerator(5)){
			System.out.println(c);
		}
	}

}
