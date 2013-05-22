package thinkingInJava;

import thinkingInJava.enumer.Enums;

enum Activity{
	SITING,
	LYING,
	STANDING,
	HOPPING,
	JUMPING
}

public class RandomTest {
	public static void main(String[] args) {
		for(int i=0;i<20;i++){
			System.out.println(Enums.random(Activity.class));
		}
	}
}
