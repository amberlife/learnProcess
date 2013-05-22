package thinkingInJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class test {
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("fdafdsadf");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
