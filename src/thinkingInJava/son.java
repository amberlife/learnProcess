package thinkingInJava;


class Candy {
	static {
		System.out.println("Loading Candy");
	}
}
class Gum{
	static {
		System.out.println("Loading Gum");
	}
}
class Cookie{
	static {
		System.out.println("Loading Cookie");
	}
}

public class son{
	public static void main(String[] args) {
		Candy c= new Candy();
		
		new Candy();
		try {
			Class.forName("Gum");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


