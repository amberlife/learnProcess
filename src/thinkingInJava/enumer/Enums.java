package thinkingInJava.enumer;

import java.util.Random;

public class Enums {
	;
	private static Random rand = new Random(47);
	public static <Y extends Enum<Y>> Y random(Class<Y> ec){
		return random(ec.getEnumConstants());
	}
	public static <T> T random(T[] values){
		return values[rand.nextInt(values.length)];
	}
	
}
