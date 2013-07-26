package algorithm.CrackingTheCodingInterview.Recursion;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) 
 * and pennies (1 cent), write code to calculate the number of ways of representing n cents.
 * ������25�֣�10�֣�5�ֺ�1�ֵ�Ӳ�����޸���дһ�������������n�ֵķ�ʽ�м��֣�
 * 
 * �����Ŀ�������ڶ�̬�滮�ľ�����Ŀ������Ǯ���⡣
 * ��֮ͬ������DP��Ҫ��������ж����֣���һ�����Ż������⡣
 * ���ڶ�������Ŀ��������Ϊ��һ��DP���⣬��ʵ��Ȼ��DP���⣬һ�����Ż����⣬������Ŀû�С�
 * �������Ŀ���оٳ����е������
 * ���������DP�����һ�������ж����ֵ����⣬�¹�һ��.^_^
 * DP�Ķ�Ӧ����ͽ���˼·���Բο���
 *   algorithm.DP.minCoinsNumber.java
 * Ȼ��ʹ�õݹ�ͱ������ַ�ʽ�����������⡣
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
	//�ݹ�Ĺ����У�Ҫ���Ǳ�ֵ�Ĵ�С�������⡣������ܳ���1,5��5,1����������ͬ����ϣ����ǳ������ε������
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
