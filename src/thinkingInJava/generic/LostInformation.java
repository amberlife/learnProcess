package thinkingInJava.generic;

import java.util.Arrays;




class Quark<Q extends Coffee>{}

public class LostInformation {
	public static void main(String[] args) {
		
		Quark<Latte> quark = new Quark<Latte>();
		
		System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
	}
}
