package algorithm.CrackingTheCodingInterview.Hard;

import java.util.Arrays;
import java.util.Random;

/**
 * Write a method to shuffle a deck of cards. 
 * It must be a perfect shuffle – in other words, each 52! permutations of the 
 * deck has to be equally likely. 
 * Assume that you are given a random number generator which is perfect.
 * 
 * 实现一个随机洗牌的程序，要求洗出52!中组合的概率是相等的。也就是说每一种组合的概率均为1/(52!)。假设你
 * 已经有一个完美的随机数发生器
 * 
 * 非常著名的一道面试题，以及非常著名的算法--随机洗牌算法
 * 随机洗牌算法：
 *  http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
 * 先假设一个5维数组：1，2，3，4，5。如果第1次随机取到的数是4， 那么我们希望参与第2次随机选取的只有1，2，3，5。
 * 既然4已经不用， 我们可以把它和1交换，第2次就只需要从后面4位(2,3,1,5)中随机选取即可。
 * 同理， 第2次随机选取的元素和数组中第2个元素交换，然后再从后面3个元素中随机选取元素， 依次类推。
 */
public class q2 {
	static int[] randomShuffle(int a[]){
		Random rand = new Random();
		int i = a.length-1;
		while(i>0){
			int j = rand.nextInt(i);
			int t = a[i];
			a[i]  = a[j];
			a[j]  =t;
			i--;
		}
		return a;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		for(int i=0;i<5;i++){
			System.out.println(Arrays.toString(randomShuffle(a)));
		}
	}
}
