package algorithm.CrackingTheCodingInterview.Hard;

import java.util.Random;


/**
 * 写一个函数，随机地从大小为n的数组中选取m个整数。要求每个元素被选中的概率相等
 * 
 *这道题和随机洗牌程序类似，只需要随机的选取一个元素，然后在剩下的元素中随机选取下一个元素，不断这样操作即可。
 *
 *选取第一个元素：n个中选取1个，概率1/n
 *选取第二个元素:剩下的n-1个中选取1个，((n-1)/n)*(1/(n-1))=1/n
 *如下类似
 *
 *将随机洗牌程序修改一下，只选取随机的前m个数就好了。
 */
public class q3 {
	public static void pickRandomly(int a[],int m){
		Random rand = new Random();
		for(int i=0;i<m;i++){
			int j = rand.nextInt(a.length-i)+i;
			int tmp = a[i];
			a[i]  = a[j];
			a[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		int m=5;
		pickRandomly(a,m);
		for(int i=0;i<m;i++){
			System.out.print(a[i]+" ");
		}
	}
}
