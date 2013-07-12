package algorithm.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * minCoinsNumber这道题目的变种。
 * minCoinsNumber:有 1元，3元，5元三种硬币，问凑够11元硬币最少需要多少个硬币？
 * coinCombinationsNum:有1元，3元，5元三种硬币，问凑够11元硬币有多少种凑法？
 * 状态D[i]：凑够i元硬币有D[i]种凑法
 * 
 * 手动推演：
 * D[0]=0
 * D[1]=count{1枚1元硬币}=1;
 * D[2]=count{2枚1元硬币}=1;
 * D[3]=count{1枚3元硬币，3枚一元硬币}=2；
 * D[4]=count{1枚3元硬币和1枚一元硬币,4枚1元硬币}=2；
 * D[5]=count{1枚5元硬币，1枚3元硬币和2枚一元硬币，5枚一元硬币}=3;
 * D[6]=count{1枚5元硬币和1枚1元硬币，2枚3元硬币，1枚3元硬币和3枚1元硬币，6枚一元硬币}=4
 *
 *
 */
public class coinCombinationsNum {
	public static void main(String[] args){
		Map<Integer, HashMap<Integer, Integer>> R = new HashMap<Integer ,HashMap<Integer,Integer>>();
		int[] T = {1,3,5};
		R.put(0, null);
		for(int i=1;i<=11;i++){
			for(int j=0;j<T.length;j++){
				if(i>=T[j]){
					
				}
			}
		}
		
	}
}
