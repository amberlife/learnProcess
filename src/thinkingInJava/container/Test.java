package thinkingInJava.container;

public abstract class Test<C> {
	String name;
	public Test(String name){
		this.name = name;
	}
	abstract int test(C container,TestParam top);
}
