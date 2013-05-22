package thinkingInJava.container;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Groundhog{
	protected int number;
	public Groundhog(int n){
		number = n ;
	}
	public String toString(){
		return "Groundhog #"+number;
	}
}

class Prediction{
	private static Random rand = new Random(47);
	private boolean shadow =  rand.nextDouble()>0.5;
	public String toString(){
		if(shadow)
			return "Six more weeks of Winter";
		else
			return "Early Spring";
	}
}

public class SpringDetector {
	public static <T extends Groundhog> void detectSpring(Class<T> type ) throws Exception{
		Constructor<T> ghog = type.getConstructor(int.class);
		Map<Groundhog,Prediction> map = new HashMap<Groundhog,Prediction>();
		for(int i=0;i<10;i++){
			map.put(ghog.newInstance(i),new Prediction());
		}
		System.out.println("map = "+map);
		Groundhog gh = ghog.newInstance(3);
		if(map.containsKey(gh))
			System.out.println(map.get(gh));
		else
			System.out.println("Key not found:"+gh);
	}
	
	public static void main(String[] args) throws Exception {
		detectSpring(Groundhog.class);
	}
}
