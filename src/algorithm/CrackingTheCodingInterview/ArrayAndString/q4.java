package algorithm.CrackingTheCodingInterview.ArrayAndString;

import java.util.Arrays;
import java.util.HashMap;

/**
 *question4:
 *Write a method to decide if two strings are anagrams or not.
 *дһ�������ж������ַ����Ƿ��Ǳ�λ�ʡ�
 *��λ�ʣ���λ��(anagrams)ָ��������������ʵ��ַ���ͬ����λ�ò�ͬ�ĵ��ʡ�����˵�� abbcd��abcdb����һ�Ա�λ��
 *
 *˼·��
 *1 �������ַ�����������Ȼ����һ�Ƚ�
 *2 �������ַ����е��ַ�,������hash��������������ַ����еõ���hash������ȫ��ȣ��������ַ�����Ϊ��λ�ʡ�
 */
public class q4 {
	
	//1 �������ַ�����������Ȼ����һ�Ƚ�
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
	
	//2 �������ַ����е��ַ�,������hash������
	//��������ַ����еõ���hash������ȫ��ȣ��������ַ�����Ϊ��λ�ʡ�
	//�����ַ�����ΪASCII��
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