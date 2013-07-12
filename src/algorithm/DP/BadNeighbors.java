package algorithm.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Administrator
 * topcoder:http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
 * 
 * question statement:
 * The old song declares "Go ahead and hate your neighbor", and the residents of 
 * Onetinville have taken those words to heart. Every resident hates his next-door 
 * neighbors on both sides. Nobody is willing to live farther away from the town's
 * well than his neighbors, so the town has been arranged in a big circle around 
 * the well. Unfortunately, the town's well is in disrepair and needs to be restored.
 *  You have been hired to collect donations for the Save Our Well fund.
 *  
 *  Each of the town's residents is willing to donate a certain amount, 
 *  as specified in the int[] donations, which is listed in clockwise order around 
 *  the well. However, nobody is willing to contribute to a fund to which his neighbor 
 *  has also contributed. Next-door neighbors are always listed consecutively in donations, 
 *  except that the first and last entries in donations are also for next-door neighbors. 
 *  You must calculate and return the maximum amount of donations that can be collected.
 *  
 *  example:
 *   { 10, 3, 2, 5, 7, 8 }
 *   Returns: 19
 *   The maximum donation is 19, achieved by 10+2+7. It would be better to take 10+5+8 except 
 *   that the 10 and 8 donations are from neighbors.
 *   
 *   { 11, 15 }
 *   Returns: 15
 *   
 *   { 7, 7, 7, 7, 7, 7, 7 }
 *   Returns: 21
 *   
 *  ****½âÎö¹ý³Ì*****
 *   There are two main cases to be considered here.
    1. Include element at index 0.
        - This leads us to not pick the last element since it is cyclic in nature. 
    2. Include element at index 1.
        - In this case, we can pick the last element.
 
    but whether we pick the element at i, depends on the following condition:
        dp[i] = max(dp[i-2] + donations[i], dp[i-1])
    which basically states, is it in our interest to pick the current donation and 
    drop the donation offered by the previous neighbor.
 
    We pick the max of both cases stated earlier.
 */
public class BadNeighbors {
	public static void main(String[] args) {
		int[] S = new int[]{10,3,2,5,7,8};
		int N = S.length;
		int[] dp = new int[S.length];
		dp[0] = S[0];
		for(int i=2;i<N-1;i++){
			dp[i]=dp[i-2]+S[i]>dp[i-1]?dp[i-2]+S[i]:dp[i-1];
		}
		int answer1=dp[N-2];
		dp=new int[S.length];
		dp[1] = S[1];
		for(int i=2;i<N;i++){
			dp[i]=dp[i-2]+S[i]>dp[i-1]?dp[i-2]+S[i]:dp[i-1];
		}
		int answer2=dp[N-1];
		System.out.println(answer1>answer2?answer1:answer2);
	}
}