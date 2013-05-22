package thinkingInJava.classInfo;

interface Interface {
	void doSomething();
	void somethingElse(String args);
}

class RealObject implements Interface{
	public void doSomething(){
		System.out.println("doSomething");
	}
	public void somethingElse(String arg){
		System.out.println("somethingElse "+arg);
	}
}

class SimpleProxy implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxied){
		this.proxied = proxied;
	}
	public void doSomething(){
		System.out.println("SimpleProxy doSomething");
		proxied.doSomething();
	}
	public void somethingElse(String arg){
		System.out.println("SimpleProxy somethingElse "+arg);
		proxied.somethingElse(arg);
	}
}

public class SimpleProxyDemo {
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	
}
