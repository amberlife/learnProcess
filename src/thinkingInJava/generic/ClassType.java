package thinkingInJava.generic;

class Building{}
class House extends Building{}

public class ClassType<T> {
	Class<T> kind;
	public ClassType(Class<T> kind){
		this.kind = kind;
	}
	public boolean f(Object arg){
		return kind.isInstance(arg);
	}
	
	public static void main(String[] args) {
		ClassType<Building> ctt1 = new ClassType<Building>(Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new House()));
		
		ClassType<House> ctt2 = new ClassType<House>(House.class);
		System.out.println(ctt2.f(new Building()));
		System.out.println(ctt2.f(new House()));
	}
	
}
