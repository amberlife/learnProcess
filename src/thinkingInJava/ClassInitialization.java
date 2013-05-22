package thinkingInJava;

import java.util.Random;

class Initable{
	static {
		System.out.println("static field");
	}
	static final int a=10;
	static int b=5;
}

public class ClassInitialization {
	public static void main(String[] args) {
		Class c = Initable.class;
		System.out.println(Initable.a);
		
	}
}
