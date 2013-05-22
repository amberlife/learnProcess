package thinkingInJava.concurrent;


public class EvenGenerator extends IntGenerator {
	private int currentEvenValue = 0 ;
	public synchronized  int next(){
			currentEvenValue++;
			Thread.yield();
			currentEvenValue++;
			return currentEvenValue;
	}
	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator(),100);
	}
}
