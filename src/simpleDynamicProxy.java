import java.lang.reflect.*;
import java.util.regex.*;

interface Interface {
	void doSomething();

	void somethingElse(String arg);
}

class RealObject implements Interface {
	public void doSomething() {
		System.out.println("doSomething");
	}

	public void somethingElse(String arg) {
		System.out.println("somethingElse " + arg);
	}
}

class sampleProxy implements Interface {
	private Interface proxied;

	public sampleProxy(Interface proxied) {
		this.proxied = proxied;
	}

	public void doSomething() {
		System.out.println("sampleProxy doSomething");
		proxied.doSomething();
	}

	public void somethingElse(String arg) {
		System.out.println("sampleProxy somethingElse");
		proxied.somethingElse(arg);
	}
}

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
//		System.out.println("**       proxy: " + proxy.getClass() + ", method:"
//				+ method + " , args: " + args);
		if (args != null)
			for (Object arg : args)
				System.out.println(" " + arg);
		return method.invoke(proxied, args);
	}
}

public class simpleDynamicProxy {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bobobo");
	}

	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class
				.getClassLoader(), new Class[] { Interface.class },
				new DynamicProxyHandler(real));
		consumer(proxy);
		proxy.doSomething();
		proxy.doSomething();
	}
}

/*
 * public class sampleProxyDemo{ public static void consumer(Interface iface){
 * iface.doSomething(); iface.somethingElse("bobobo"); } public static void
 * main(String[] args){ consumer(new RealObject()); consumer(new sampleProxy(new
 * RealObject())); } }
 */
