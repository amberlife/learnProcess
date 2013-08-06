package algorithm.CrackingTheCodingInterview.Hard;

import java.util.Arrays;
import java.util.Random;

/**
 * Write a method to shuffle a deck of cards. 
 * It must be a perfect shuffle �C in other words, each 52! permutations of the 
 * deck has to be equally likely. 
 * Assume that you are given a random number generator which is perfect.
 * 
 * ʵ��һ�����ϴ�Ƶĳ���Ҫ��ϴ��52!����ϵĸ�������ȵġ�Ҳ����˵ÿһ����ϵĸ��ʾ�Ϊ1/(52!)��������
 * �Ѿ���һ�������������������
 * 
 * �ǳ�������һ�������⣬�Լ��ǳ��������㷨--���ϴ���㷨
 * ���ϴ���㷨��
 *  http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
 * �ȼ���һ��5ά���飺1��2��3��4��5�������1�����ȡ��������4�� ��ô����ϣ�������2�����ѡȡ��ֻ��1��2��3��5��
 * ��Ȼ4�Ѿ����ã� ���ǿ��԰�����1��������2�ξ�ֻ��Ҫ�Ӻ���4λ(2,3,1,5)�����ѡȡ���ɡ�
 * ͬ�� ��2�����ѡȡ��Ԫ�غ������е�2��Ԫ�ؽ�����Ȼ���ٴӺ���3��Ԫ�������ѡȡԪ�أ� �������ơ�
 */
public class q2 {
	static int[] randomShuffle(int a[]){
		Random rand = new Random();
		int i = a.length-1;
		while(i>0){
			int j = rand.nextInt(i);
			int t = a[i];
			a[i]  = a[j];
			a[j]  =t;
			i--;
		}
		return a;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		for(int i=0;i<5;i++){
			System.out.println(Arrays.toString(randomShuffle(a)));
		}
	}
}
