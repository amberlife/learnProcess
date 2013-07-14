package algorithm.CrackingTheCodingInterview.ArrayAndString;

import java.util.HashSet;

/**
 *question1.1 
 *implement an algorithm to determine if a string has all unique characters.
 *What if you can not use additional data structures?
 *
 * 考虑：
 * 字符是否为ASCII编码
 * 
 * method1：
 * 使用 hash来操作：顺序访问字符串中的每一个元素，访问每一个字符前，判断该字符是否存在于hash表内，
 * 如果不存在，则加入hash表中，如果存在，表明有重复字符，返回false。
 * 
 * method2：
 * 如果是ASCII编码的话，那么一共只有256个数，可以考虑使用位图来实现，java中一个int占4个字节，32位。那么只需要一个长度为8的int数组
 * 即可表示所有的字符，随后顺序访问字符串中的字符，如果存在将对应字符的ASCII码编号的位设置为1即可。
 */

public class q1 {
	
	public static boolean method1(String str){
		char[] cc = str.toCharArray();
		HashSet<Character> set = new HashSet<Character>();
		for(char c:cc){
			if(set.contains(c)){
				return false;
			}
			set.add(c);
		}
		return true;
	}
	
	public static  boolean method2(String str){
		char[] cc= str.toCharArray();
		int[] bitmap = new int[8];
		for(char c:cc){
			int i = (int)c;
			int idx=i/32;
			int offset=i%32;
			if(((bitmap[idx])&(1<<offset))!=0){
				return false;
			}
			bitmap[idx]=bitmap[idx]|(1<<offset);
		}
		return true;
	}
	
	//test
	public static void main(String[] args) {
		String s = "abcdaefg";
		System.out.println(method1(s));
		System.out.println(method2(s));
	}
}
