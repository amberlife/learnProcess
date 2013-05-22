package thinkingInJava.enumer;

import java.util.EnumMap;
import java.util.Map;


interface Command{
	void action();
}

public class EnumMaps {
	public static void main(String[] args) {
		EnumMap<AlarmPoints,Command> em = new EnumMap<AlarmPoints,Command>(AlarmPoints.class);
		em.put(AlarmPoints.KITCHEN, new Command(){ public void action(){System.out.println("Kitchen Fire");}});
		em.put(AlarmPoints.BATHROOM,new Command(){ public void action(){System.out.println("Bathroom Fire");}});
		
		for(Map.Entry<AlarmPoints, Command> e : em.entrySet()){
			System.out.print(e.getKey()+": ");
			e.getValue().action();
		}
		try{
			em.get(AlarmPoints.UTILITY).action();
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
}
