package algorithm.CrackingTheCodingInterview.ArrayAndString;

import java.util.Arrays;
import java.util.HashMap;

/**
 *question4:
 *Write a method to decide if two strings are anagrams or not.
 *写一个函数判断两个字符串是否是变位词。
 *变位词：变位词(anagrams)指的是组成两个单词的字符相同，但位置不同的单词。比如说， abbcd和abcdb就是一对变位词
 *
 *思路：
 *1 对两个字符串进行排序，然后逐一比较
 *2 对两个字符串中的字符,，进行hash计数，如果两个字符串中得到的hash计数完全相等，则两个字符串互为变位词。
 */
public class q4 {
	
	//1 对两个字符串进行排序，然后逐一比较
	public static boolean method1(char[] s,char[] t){
		if(s==null||t==null){
			return false;
		}
		if(s.length!=t.length){
			return false;
		}
		int len = s.length;
		for(int i=0;i<len;i++){
			if(s[i++]!=t[i++])
				return false;
		}
		return true;
	}
	
	//2 对两个字符串中的字符,，进行hash计数，
	//如果两个字符串中得到的hash计数完全相等，则两个字符串互为变位词。
	//假设字符编码为ASCII码
	public static boolean method2(char[] s,char[] t){
		if(s==null||t==null)
			return false;
		if(s.length!=t.length)
			return false;
		
		int[] c = new int[256];
		int len = s.length;
		for(int i=0;i<len;i++){
			c[s[i]]++;
			c[t[i]]--;
		}
		
		for(int i=0;i<256;i++){
			if(c[i]!=0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		char[] s = new char[]{'a','p','p','l','e'};
		char[] t = new char[]{'p','a','p','e','l'};
		System.out.println(method1(s,t));
		System.out.println(method2(s,t));
	}
	
}