package thinkingInJava;

class VeryImportantException extends Exception{
	public String toString(){
		return "a very import Exception";
	}
}
class HoHumException extends Exception{
	public String toString(){
		return "a trivial exception";
	}
}

public class LostMessage {
	void f() throws VeryImportantException{
		throw new VeryImportantException();
	}
	void dispose() throws HoHumException{
		throw new HoHumException();
	}
	public static void main(String[] args) {
		try{
			LostMessage lm = new LostMessage();
			try{
				lm.f();
			}finally{
				lm.dispose();
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
