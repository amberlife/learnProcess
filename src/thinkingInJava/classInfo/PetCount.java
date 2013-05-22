package thinkingInJava.classInfo;

import java.util.HashMap;

public class PetCount {
	static class PetCounter extends HashMap<String ,Integer>{
		public void count(String type){
			Integer quantity = get(type);
			if(quantity==null){
				put(type,1);
			}else{
				put(type,quantity+1);
			}
		}
	}
	public static void countPets(PetCreator creator){
		PetCounter counter = new PetCounter();
		for(Pet pet:creator.createArray(20)){
			System.out.print(pet.getClass().getSimpleName()+" ");
			if(pet instanceof Pet)
				counter.count("pet");
			if(pet instanceof Dog)
				counter.count("dog");
			if(pet instanceof Mutt)
				counter.count("mutt");
			if(pet instanceof Pug)
				counter.count("Pug");
			if(pet instanceof Cat)
				counter.count("Cat");
			if(pet instanceof EgyptianMau)
				counter.count("EgyptianMau");
			if(pet instanceof Manx)
				counter.count("Manx");
			if(pet instanceof Cymric)
				counter.count("Cymric");
			if(pet instanceof Rodent)
				counter.count("Rodent");
			if(pet instanceof Rat)
				counter.count("Rat");
			if(pet instanceof Mouse)
				counter.count("Mouse");
			if(pet instanceof Hamster)
				counter.count("Hamster");
		}
		System.out.println();
		System.out.println(counter);
	}
	public static void main(String[] args) {
		countPets(new ForNameCreator());
	}
	
	
}
