package algorithm.CrackingTheCodingInterview.SortAndSearch;

/**
 * Given a sorted array of strings which is interspersed with empty strings, 
 * write a method to find the location of a given string.
 * 
 * Example: 
 * 	find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”,“”, “dad”, “”, “”] will return 4
 * Example: 
 *  find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] will return -1
 * 给你一个排好序的并且穿插有空字符串的字符串数组，写一个函数找到给定字符串的位置。
 * 
 * 思考：
 * 简单题目，对二分查找做一些修改即可。
 * low指针指向最小的元素，可以是空值
 * high指针指向最大的元素，也可能是空值。
 * 随后mid=(low+high)>>1 ，将mid指向中间值。如果中间值是空值，就规定向右进行移动直到一个非空值。判断所要寻找的元素
 * 如果比mid所指的值大，说明，所寻找的值在右半段，否则在做半段。重复上述过程至low>high为止
 * 
 */
public class q5 {
	public static int search(char[] arr,int low ,int high,char k){
		while(low<=high){
			int mid=(low+high)>>1;
			int t= mid;
			while(t<arr.length&&arr[t]==0){
				t++;
			}
			
			if(t>high)
				high = mid-1;
			else{
				if(arr[t]==k)
					return t;
				else if(arr[t]<k) low =t+1;
				else high =mid-1;
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		char[] arr= new char[]{'a',0,'b',0,0,'c','e',0,0};
		
		int idx=search(arr,0,arr.length-1,'e');
		System.out.println(idx);
	}
	
}
