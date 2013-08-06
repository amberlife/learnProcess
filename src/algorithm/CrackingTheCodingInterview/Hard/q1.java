package algorithm.CrackingTheCodingInterview.Hard;

/**
 * Write a function that adds two numbers. 
 * You should not use + or any arithmetic operators.
 * 
 * 不用加号或者任何算术运算符，计算两个数的和
 * 不能用任何算术运算符，那么我们能用的就只有位运算符了。
 * 位运算符用于二进制数，所以，考虑二进制数
 * (5+2)_10 = (101+010)_2=(111)_2 =(7)_10
 * 101 和  010直接进行位异或运算即可,这里没有进位的问题.
 * 但是如果有进位，我们该怎么办呢?
 * (6+2)_10 = (110+010)_2
 * 110+010
 * 不包含进位的结果是100，
 * 进位的结果是100，
 * 这二者继续相加
 * 不包含进位的结果是000
 * 进位的结果是1000
 * 所以，最后的结果就是(1000)_2=8
 * 
 */
public class q1 {
	public static void main(String[] args) {

		System.out.println(add(16,12));
		
	}
	
	public static int add(int a ,int b){
		if(a==0)
			return b;
		if(b==0)
			return a;
		int c = a^b;
		int d = (a&b)<<1;
		return add(c,d);
	}
}
