package algorithm.CrackingTheCodingInterview.Moderate;

/**
 *question1
 *不借助中间变量交换两个数
 *
 *方法一是经典方法了。
 */
public class q1 {
	public static void main(String[] args) {
		int a=10;
		int b=20;
		System.out.printf("a=%d,b=%d\n",a,b);
		//方法1
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.printf("a=%d,b=%d\n",a,b);
		//方法2
		b=a-b;
		a=a-b;
		b=a+b;
		System.out.printf("a=%d,b=%d\n",a,b);
	}
}
