package algorithm.CrackingTheCodingInterview.BitManipulation;

import java.util.Scanner;

/**
 * Explain what the following code does: ((n & (n-1)) == 0).
 * �����´���((n&(n-1))==0)������
 * 
 * �����Ŀ���Ǹ��Ӱ��������أ�Ҫ֪��n&(n-1)==0��ʾ�ж�һ�����ǲ���2�������ݣ�
 * ��Σ�������������Ƿ��֡���n=0��ʱ�����������������n=0���Ƕ���������
 * ��ˣ��ж�����Ҫ��Ϊ��
 * ��((n&(n-1))==0)&&n>0)
 */

public class q4 {
	public static void main(String[] args) {
		System.out.println("please input an integer:");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		if(a>0&&(a&(a-1))==0){
			System.out.println("the integer is powers of 2");
		}
	}
}
