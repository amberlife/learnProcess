package algorithm.CrackingTheCodingInterview.Hard;

import java.util.Arrays;
import java.util.Random;

/**
 * ��Ŀ��������ǰĿ¼�� q6.md
 * 
 * ��ĿҪ����10�ڸ�������Ѱ����100�����
 * ���ǰ�Ҫ���С(100�������������100��)��Ȼ��ʵ��q6.md�����������ַ���
 * 
 */
public class q6 {
	
	//������ķ�ʽʵ��
	public static int[] sort(int[] arr){
		Arrays.sort(arr);
		return Arrays.copyOfRange(arr, arr.length-20, arr.length);
	}
	
	//����С�ѵķ�ʽʵ��
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
	
	//������K���
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
