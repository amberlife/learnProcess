package algorithm.CrackingTheCodingInterview.SortAndSearch;

import java.util.Arrays;

/*
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 * ʵ��һ���������ַ�����������ʹ�����еı�λ�ʶ����ڡ�
 * ��λ����ָ����ɵ��ַ������ַ���ͬ����˳��һ���ĵ��ʡ�
 * 
 * ����Ŀ���Ƚ����е��ַ�������Ȼ���ڰ����ֵ�˳�����򣬼��ɡ�
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
