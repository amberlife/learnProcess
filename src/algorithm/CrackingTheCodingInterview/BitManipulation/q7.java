package algorithm.CrackingTheCodingInterview.BitManipulation;

/**
 * An array A[1…n] contains all the integers from 0 to n except for one number which 
 * is missing. In this problem, we cannot access an entire integer in A with a single 
 * operation. The elements of A are represented in binary, and the only operation we 
 * can use to access them is “fetch the jth bit of A[i]”, which takes constant time. 
 * Write code to find the missing integer. Can you do it in O(n) time?
 * 
 * 数组A[1…n]包含0到n的所有整数，但有一个整数丢失了。在这个问题中， 我们不能直接通过A[i]取得数组中的第i个数。
 * 数组A被表示成二进制， 也就是一串的0/1字符，而我们唯一能使用的操作只有“取得A[i]中的第j位”， 这个操作只需要花费常数时间。
 * 写程序找出丢失的整数，你能使程序的时间复杂度是O(n)吗？
 * 
 * 取得A[i]中的第j位，对应函数fetch(A,i,j),所以，取整数i，只需要调用fetch函数32次即可。
 * 同时建立一个boolean数组，如果包含某个整数i，则将boolean数组的第i个元素设为true，
 * 在遍历一遍，就找到了那个整数不存在于其中
 */
public class q7 {
	public static int fetch(int a[],int i,int j){
		return (a[i]>>j)&1;
	}
	public static int get(int[] a ,int i){
		int result = 0 ;
		for(int j=31;j>=0;--j){
			result = result<<1|fetch(a,i,j);
		}
		return result ;
	}
}
