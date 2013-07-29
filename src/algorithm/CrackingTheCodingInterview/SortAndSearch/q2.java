package algorithm.CrackingTheCodingInterview.SortAndSearch;

import java.util.Arrays;

/*
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 * 实现一个方法对字符串数组排序，使得所有的变位词都相邻。
 * 变位词是指：组成的字符串的字符相同，但顺序不一样的单词。
 * 
 * 简单题目，先将所有的字符串排序，然后在按照字典顺序排序，即可。
 */

public class q2 {
	public static void main(String[] args) {
		String[] s= new String[]{
				"axyz","abc","yzax","bac","zyxa","fg","gf"
		};
		for(int i=0;i<s.length;i++){
			char[] c = s[i].toCharArray();
			Arrays.sort(c);
			s[i]=new String(c);
		}
		Arrays.sort(s);
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
	}
}
