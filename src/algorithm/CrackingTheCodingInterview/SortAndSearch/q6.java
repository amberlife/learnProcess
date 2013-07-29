package algorithm.CrackingTheCodingInterview.SortAndSearch;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Given a matrix in which each row and each column is sorted, 
 * write a method to find an element in it.
 * 
 * 给出一个矩阵，其中每一行和每一列都是有序的，写一个函数在矩阵中找出一个指定的数。
 * 
 * 在二分查找中，我们面对的是一个数组，然后是根据最小元素和最大元素来查找指定元素的。
 * 这里，我们面对的是一个数组，那么我们利用矩阵四个角的原来，来查找元素
 * 
 * 以一个实例来进行分析：
 *  1 2 3 4 
 *  2 3 4 5 
 *  3 4 5 6 
 *  4 5 6 7
 *  上面这个矩阵满足每行每列都是有序递增的
 *  观察发现：左上角的元素是整个矩阵最小的，右下角的元素是整个矩阵最大的。
 *  当元素小于左上角的元素或者大于右下角的元素时，则无法找到指定的元素
 *  当元素大于左上角元素，同时小于左下角元素，则元素不可能在第一行和最后一列。
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
