package algorithm.CrackingTheCodingInterview.Recursion;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) 
 * and pennies (1 cent), write code to calculate the number of ways of representing n cents.
 * 我们有25分，10分，5分和1分的硬币无限个。写一个函数计算组成n分的方式有几种？
 * 
 * 这道题目是类似于动态规划的经典题目，找零钱问题。
 * 不同之处在于DP是要求解最少有多少种，是一个最优化的问题。
 * 我在读到此题目初，就以为是一个DP问题，其实不然，DP问题，一般是优化问题，而该题目没有。
 * 而这道题目是列举出所有的情况。
 * 这里，我们用DP来解决一下最少有多少种的问题，温故一下.^_^
 * DP的对应问题和解题思路可以参看：
 *   algorithm.DP.minCoinsNumber.java
 * 然后使用递归和遍历两种方式来解决这个问题。
 *
 * 
 */

public class q7 {

	//make small number change use dynamic programming
	public static int DPMakeChange(int[] coinsType,int n){
		int[] dp = new int[n+1];
		dp[0]=0;
		for(int i=1;i<=n;i++){
			dp[i]=Integer.MAX_VALUE;
			for(int j=0;j<coinsType.length;j++){
				if(i>=coinsType[j]&&dp[i]>dp[i-coinsType[j]]+1)
					dp[i]=dp[i-coinsType[j]]+1;
			}
		}
		return dp[n];
	}
	//make change use recursion
	//递归的过程中，要考虑币值的大小排序问题。否则可能出现1,5和5,1这样两个相同的组合，但是出现两次的情况。
	public static int RecMakeChange(int[] coinsType,int n,int sum,int c){
		int count=0;
		if(sum<=n){
			if(sum==n) return 1;
			for(int i=0;i<coinsType.length;i++){
				if(c>=coinsType[i]){
					count+=RecMakeChange(coinsType,n,sum+coinsType[i],coinsType[i]);
				}
			}
		}
		return count;
	}
	//make change use traverse
	public static int TraMakeChange(int n){
		int count=0;
		
		for(int i=0;i<=n/25;i++){
			for(int j=0;j<=n/10;j++){
				for(int p=0;p<=n/5;p++){
					for(int q=0;q<=n;q++){
						int v=i*25+j*10+p*5+q;
						if(v==n)
							count++;
						else if(v>n)
							break;
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int n=100;
		System.out.println(DPMakeChange(new int[]{1,5,10,25},n));
		System.out.println(RecMakeChange(new int[]{25,10,5,1},n,0,25));
		System.out.println(TraMakeChange(n));
	}
}
