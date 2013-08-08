package algorithm.CrackingTheCodingInterview.Hard;

import java.util.Arrays;
import java.util.Random;

/**
 * 题目描述见当前目录下 q6.md
 * 
 * 题目要求是10亿个数，找寻最大的100万个数
 * 我们把要求减小(100万个数，找最大的100个)，然后实现q6.md中描述的三种方法
 * 
 */
public class q6 {
	
	//用排序的方式实现
	public static int[] sort(int[] arr){
		Arrays.sort(arr);
		return Arrays.copyOfRange(arr, arr.length-20, arr.length);
	}
	
	//用最小堆的方式实现
	public static int[] minHeap(int[] arr){
		int[] heapValue = new int[20];
		
		for(int i=0;i<20;i++){
			heapValue[i] = arr[i];
		}
		MinHeap minHeap = new MinHeap(heapValue);
		for(int i=20;i<arr.length;i++){
			if(arr[i]>minHeap.values[0]){
				minHeap.values[0] = arr[i];
				minHeap.fixDown(minHeap.values, 0,20);
			}
		}
		Arrays.sort(minHeap.values);
		return minHeap.values;
	}
	
	//线性求K最大
	public static int[] partition(int[] arr,int from ,int to){
		int pivot = arr[from];
		int i=from,j=to-1;
		while(i<j){
			while(i<j&&arr[j]<pivot)
				j--;
			if(i<j){
				arr[i]=arr[j];
				i++;
			}
			while(i<j&&arr[i]>=pivot)
				i++;
			if(i<j){
				arr[j]=arr[i];
				j--;
			}
		}
		arr[i]=pivot;
		if(i==20){
			 return Arrays.copyOfRange(arr,0,20);
		}else if(i<20){
			partition(arr,i+1,to);
		}else{
			partition(arr,0,i);
		}
		
		int[] k = Arrays.copyOfRange(arr,0,20);
		Arrays.sort(k);
	
		return k;
	}
	
	public static void main(String[] args) {
		int[] arr= new int[1000000];
		Random rand = new Random();
		for(int i=0;i<1000000;i++){
			arr[i] = rand.nextInt(1000000);
		}
		//System.out.println(Arrays.toString(sort(arr)));
		System.out.println(Arrays.toString(minHeap(arr)));
		System.out.println(Arrays.toString(partition(arr,0,1000000)));
	}
}
