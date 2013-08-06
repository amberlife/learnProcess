package algorithm.CrackingTheCodingInterview.Hard;

import java.util.Arrays;

/**
 * 题目描述见当前目录下 q6.md
 * 
 * 题目要求是10亿个数，找寻最大的100万个电台。
 * 我们把要求减小(100万个数，找最大的100个)，然后实现q6.md中描述的三种方法
 * 
 */
public class q6 {
	
	//用排序的方式实现
	public static int[] sort(int[] arr){
		Arrays.sort(arr);
		return Arrays.copyOfRange(arr, arr.length-100, arr.length);
	}
	
	//用最小堆的方式实现
	public static int[] minHeap(){
		
		return null;
	}
	
	//线性求K最大
	public static int[] partition(){
		return null;
	}
}
