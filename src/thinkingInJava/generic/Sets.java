package thinkingInJava.generic;

import java.util.HashSet;
import java.util.Set;

public class Sets {
	public static <w> Set<w> union(Set<w> a, Set<w> b){
		Set<w> result = new HashSet<w>(a);
		result.addAll(b);
		return result;
	}
	public static <T> Set<T> intersection(Set<T> a ,Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	public static <T> Set<T> difference(Set<T> superset,Set<T> subset){
		Set<T> result = new HashSet<T>(superset);
		result.removeAll(subset);
		return result;
	}
	
	public static <T> Set<T> complement(Set<T> a ,Set<T> b ){
		return difference(union(a,b),intersection(a,b));
	}
}
