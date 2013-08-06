package algorithm.CrackingTheCodingInterview.Hard;

/**
 * Write a function that adds two numbers. 
 * You should not use + or any arithmetic operators.
 * 
 * ���üӺŻ����κ�����������������������ĺ�
 * �������κ��������������ô�������õľ�ֻ��λ������ˡ�
 * λ��������ڶ������������ԣ����Ƕ�������
 * (5+2)_10 = (101+010)_2=(111)_2 =(7)_10
 * 101 ��  010ֱ�ӽ���λ������㼴��,����û�н�λ������.
 * ��������н�λ�����Ǹ���ô����?
 * (6+2)_10 = (110+010)_2
 * 110+010
 * ��������λ�Ľ����100��
 * ��λ�Ľ����100��
 * ����߼������
 * ��������λ�Ľ����000
 * ��λ�Ľ����1000
 * ���ԣ����Ľ������(1000)_2=8
 * 
 */
public class q1 {
	public static void main(String[] args) {

		System.out.println(add(16,12));
		
	}
	
	public static int add(int a ,int b){
		if(a==0)
			return b;
		if(b==0)
			return a;
		int c = a^b;
		int d = (a&b)<<1;
		return add(c,d);
	}
}
