package algorithm.CrackingTheCodingInterview.ArrayAndString;

/**
 *Assume you have a method isSubstring which checks if one word is a substring of another. 
 *Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using 
 *only one call to isSubstring ( i.e., ��waterbottle�� is a rotation of ��erbottlewat��).
 *��������һ��isSubstring���������Լ��һ���ַ����Ƿ�����һ���ַ������Ӵ��� �����ַ���s1��s2��ֻʹ��һ��isSubstring�����ж�s2�Ƿ���s1����ת�ַ�����
 *��д�����롣��ת�ַ�����"waterbottle"��"erbottlewat"����ת�ַ�����
 *
 *˼�������������ת�ַ��������⣬��һ�����м��ɵ����⣬����ͨ�����ַ������Ƴ�˫�ݣ��Ϳ��Լ򵥵�˵�ַ�����������ת��
 *���� �����ַ���'abcd'�����Ƴ�Ϊ'abcdabcd'���Ϳ���˵����'abcd'������ÿ���ַ���������ת����󣬿���ͨ��
 *str1.contains(str2)��ͨ���򵥵��Ӵ�ƥ�����ж�str2�Ƿ�Ϊ����֮ǰ��str1����ת�ַ���
 */
public class q8 {
	public static boolean method1(String str1,String str2){
		str1=str1+str1;
		if(str1.contains(str2)){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String str1 = "waterbottle";
		String str2 = "erbottlewat";
		System.out.println(method1(str1,str2));
	}
}
