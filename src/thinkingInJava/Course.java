package thinkingInJava;

import thinkingInJava.enumer.Enums;
import thinkingInJava.enumer.Food;

public enum Course {
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.Maincourse.class),
	DESSERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	
	private Food[] values;
	private Course(Class<? extends Food> kind){
		values = kind.getEnumConstants();
	}
	public Food randomSelection(){
		return Enums.random(values);
	}
}
