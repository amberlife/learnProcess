package algorithm.CrackingTheCodingInterview.ArrayAndString;

import java.util.HashSet;

/**
 *question1.1 
 *implement an algorithm to determine if a string has all unique characters.
 *What if you can not use additional data structures?
 *
 * ���ǣ�
 * �ַ��Ƿ�ΪASCII����
 * 
 * method1��
 * ʹ�� hash��������˳������ַ����е�ÿһ��Ԫ�أ�����ÿһ���ַ�ǰ���жϸ��ַ��Ƿ������hash���ڣ�
 * ��������ڣ������hash���У�������ڣ��������ظ��ַ�������false��
 * 
 * method2��
 * �����ASCII����Ļ�����ôһ��ֻ��256���������Կ���ʹ��λͼ��ʵ�֣�java��һ��intռ4���ֽڣ�32λ����ôֻ��Ҫһ������Ϊ8��int����
 * ���ɱ�ʾ���е��ַ������˳������ַ����е��ַ���������ڽ���Ӧ�ַ���ASCII���ŵ�λ����Ϊ1���ɡ�
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
