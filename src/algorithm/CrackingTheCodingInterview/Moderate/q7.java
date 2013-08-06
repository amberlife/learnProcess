package algorithm.CrackingTheCodingInterview.Moderate;

/**
 * question6:
 * You are given an array of integers (both positive and negative). 
 * Find the continuous sequence with the largest sum. Return the sum.
 * 给出一个整数数组(包含正数和负数)，找到和最大的连续子序列，返回和。
 * 
 * 输入：{2,-8,3,-2,4,-10}
 * 输出：5 (3,-2,4)
 * 
 * 遍历输入序列，设置两个变量：当前和(cursum)，最大和(maxsum).遍历过程中，更新当前和和最大和。
 * 当当前和的值为负的时候，刨除掉之前所有的和，取下一个数作为当前和。
 * 当前和和最大和始终比对，一旦当前和大于最大和，更新最大和，遍历结束，即可找到最大和。
 */
public class q7 {
	public static void main(String[] args) {
		int[] arr={2,-8,3,-2,4,10};
		
		int cursum=arr[0];
		int maxsum=arr[0];
		for(int i=1;i<arr.length;i++){
			cursum+=arr[i];
			if(cursum<0){
				cursum=0;
				continue;
			}else{
				if(cursum>maxsum){
					maxsum=cursum;
				}
			}
		}
		
		System.out.println(maxsum);
	}
}
