package thinkingInJava;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
	Toy(){}
	Toy(int i){}
}
class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
	FancyToy(){
		super(1);
	}
}

public class ToyTest {
	
	static void printInfo(Class cc){
		System.out.println("Class name: "+cc.getName()+"is interface? "+cc.isInterface());
		System.out.println("simple name: "+cc.getSimpleName());
		System.out.println("Canionial name: "+cc.getCanonicalName());
	}
	
	public static void main(String[] args) {
		Class c= null; 
		try{
			c=Class.forName("thinkingInJava.FancyToy");
		}catch(ClassNotFoundException e){
			System.out.println("Can't find fancyToy");
			System.exit(1);
		}
		printInfo(c);
		
		for(Class face:c.getInterfaces()){
			printInfo(face);
		}
		
		Class up = c.getSuperclass();
		Object obj = null;
			try {
				obj=up.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
		printInfo(obj.getClass());
			
		
	}
	
	
}
