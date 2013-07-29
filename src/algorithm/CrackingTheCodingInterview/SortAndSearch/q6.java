package algorithm.CrackingTheCodingInterview.SortAndSearch;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Given a matrix in which each row and each column is sorted, 
 * write a method to find an element in it.
 * 
 * ����һ����������ÿһ�к�ÿһ�ж�������ģ�дһ�������ھ������ҳ�һ��ָ��������
 * 
 * �ڶ��ֲ����У�������Ե���һ�����飬Ȼ���Ǹ�����СԪ�غ����Ԫ��������ָ��Ԫ�صġ�
 * ���������Ե���һ�����飬��ô�������þ����ĸ��ǵ�ԭ����������Ԫ��
 * 
 * ��һ��ʵ�������з�����
 *  1 2 3 4 
 *  2 3 4 5 
 *  3 4 5 6 
 *  4 5 6 7
 *  ���������������ÿ��ÿ�ж������������
 *  �۲췢�֣����Ͻǵ�Ԫ��������������С�ģ����½ǵ�Ԫ���������������ġ�
 *  ��Ԫ��С�����Ͻǵ�Ԫ�ػ��ߴ������½ǵ�Ԫ��ʱ�����޷��ҵ�ָ����Ԫ��
 *  ��Ԫ�ش������Ͻ�Ԫ�أ�ͬʱС�����½�Ԫ�أ���Ԫ�ز������ڵ�һ�к����һ�С�
 *  
 */

public class q6 {
	public static int[] search(int[][] arr,int x){
		int m = arr.length;
		int n = arr[0].length;
		int a = 0 ;
		int b= n-1;
		while(a<m&&b>=0){
			if(arr[a][b]==x){
				return new int[]{a,b};
				
			}
			else if(arr[a][b]<x){
				++a;
			}
			else {
				--b;
			}
		}
		return new int[]{-1,-1};
		
	}
	
	public static void main(String[] args) {
		int[][] arr= new int[][]{
				{1,2,3,4},
				{2,3,4,5},
				{3,4,5,6},
				{4,5,6,7}
		};
		int[] result= search(arr,3);
		System.out.println(Arrays.toString(result));
		
		
	}
}
