package algorithm.CrackingTheCodingInterview.BitManipulation;

import java.util.Scanner;

/**
 * Explain what the following code does: ((n & (n-1)) == 0).
 * 解释下代码((n&(n-1))==0)的作用
 * 
 * 这道题目就是个坑啊，首先呢，要知道n&(n-1)==0表示判断一个数是不是2的整数幂，
 * 其次，考察这个条件是否充分。当n=0的时候，这个条件成立，但n=0不是二的整数幂
 * 因此，判断条件要改为：
 * （((n&(n-1))==0)&&n>0)
 */

public class q4 {
	public static void main(String[] args) {
		System.out.println("please input an integer:");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		if(a>0&&(a&(a-1))==0){
			System.out.println("the integer is powers of 2");
		}
	}
}
