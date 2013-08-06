package algorithm.CrackingTheCodingInterview.Moderate;

/**
 * question4:
 * Write a method which finds the maximum of two numbers. You should not use if-else or any other comparison operator.
 * 实现一个方式，找到两个数中的较大者，你不能够使用if-else语句或者任何比较操作符
 * 输入10 5 
 * 输出 10 
 * 
 * 不能用if-else 和 比较操作符，
 * 我们先看看比较操作符都哪些 ：< , > ,==, >=,<=,&&,||
 * 
 * 那除去这些，我们还能用操作符还有哪些？ 一些位操作符 << ,>>,&,|,=
 * 那么我们看看如何把常用的比较操作，转化成使用这些位操作符
 * 
 * if(a>b) return a ;else  return b ;
 * if(a-b>0) return a  ; else return b;
 * if(a-b>0) k=1; else k=0; return a-k(a-b)
 * z=a-b a>b 则z>0，最高位是0,a<b 则 z<0，最高位是1。根据有符号整数的特点，以此可以得出k值
 * 那么  可以返回为： a-k*z
 */
public class q4 {
	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		int z=a-b;
		int k=(z>>>31);
		System.out.println(a-k*z);
	}
}
