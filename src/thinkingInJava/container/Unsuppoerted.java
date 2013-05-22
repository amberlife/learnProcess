package thinkingInJava.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Unsuppoerted {
	static void test(String msg,List<String> list){
		System.out.println("--- "+msg+" ---");
		Collection<String> c = list;
		Collection<String> subList = list.subList(1,8);
		
		Collection<String> c2 = new ArrayList<String>(subList);
		try{
			c.retainAll(c2);
		}catch(Exception e){
			System.out.println("retainAll(): "+e);
		}
		
		try{
			c.removeAll(c2);
		}catch(Exception e){
			System.out.println("removeAll(): "+e);
		}
		
		try{
			c.clear();
		}catch(Exception e){
			System.out.println("clear(): "+e);
		}
		
		try{
			c.add("X");
		}catch(Exception e){
			System.out.println("add(): "+e);
		}
		
		try{
			c.addAll(c2);
		}catch(Exception e){
			System.out.println("addAll(): "+e);
		}
	}
}
