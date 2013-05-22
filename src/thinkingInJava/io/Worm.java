package thinkingInJava.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

class Data implements Serializable{
	private int n; 
	public Data(int n){
		this.n  = n ;
	}
	public String toString(){
		return Integer.toString(n);
	}
}

public class Worm implements Serializable {
	private static Random rand = new Random(47);
	private Data[] d = {
			new Data(rand.nextInt(80)),
			new Data(rand.nextInt(80)),
			new Data(rand.nextInt(80))
	};
	private Worm next;
	private char c;
	
	public Worm(int i,char x){
		System.out.println("Worm constructor: "+i);
		c=x;
		if(--i>0)
			next = new Worm(i,(char)(x+1));
	}
	public Worm(){
		System.out.println("Default constructor");
	}
	public String toString(){
		StringBuilder result = new StringBuilder(":");
		result.append(c);
		result.append("(");
		for(Data dat:d)
			result.append(dat);
		result.append(")");
		if(next!=null)
			result.append(next);
		return result.toString();
	}
	public static void main(String[] args)throws ClassNotFoundException,IOException{
		Worm w = new Worm(6,'a');
		System.out.println("w = "+w);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
		out.writeObject("Worm Storage\n");
		out.writeObject(w);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
		String s = (String)in.readObject();
		Worm w2 = (Worm)in.readObject();
		System.out.println(s+"w2 = "+w2);
		in.close();
		
	}
	
}
