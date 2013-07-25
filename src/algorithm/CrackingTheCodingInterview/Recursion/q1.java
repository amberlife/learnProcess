package algorithm.CrackingTheCodingInterview.Recursion;


/**
 * Write a method to generate the nth Fibonacci number.
 * 写一个函数，产生第n个斐波那契数 
 * 
 * 斐波那契数列，经典的递归程序了。
 * 最简单的就是直接写个递归程序，f(n)=f(n-1)+f(n-2),f(1)=f(2)=1;
 * 递归程序思考起来方便，只需要指明终止条件和递归样式基本就结束了，但是中间会存在大量的重复计算。所以，效率会下降。
 * 对于这道题目，通过数学推导，可以有一个更快速的解。
 * *** latex*****
 * \left(f_n \\ f_{n-1}\right)=\left(1 \quad 1 \\ 1 \quad 0\right)\left(f_{n-1} \\ f_{n-2}\right)
 * = ... = \left(1 \quad 1 \\ 1 \quad 0\right)^{n-2}\left(f_2 \\ f_1\right)
 * 利用这个公式，同时利用分治法，将\left(1 \quad 1 \\ 1 \quad 0 \right)^n分成2个 \left( 1 \quad 1 \\ 1 \quad 0)^(n/2)
 * ，然后逐渐分到\left(1 \quad 1 \\ 1 \quad 0 \right)^1 
 * 这样，时间复杂度可以降至log(n)，比起指数时间复杂度，有很大的改善
 * 
 * 
 * 
 */
public class q1 {
	
	//recursive version
	public static long fib(long n){
		if(n<1) return -1;
		if(n==1||n==2) return 1;
		else return fib(n-1)+fib(n-2);
	}
	
	//compute 2 dimension matrix
	public static long[][] mu(long a[][],long b[][]){
		long c[][] = new long[2][2];
		c[0][0] = a[0][0]*b[0][0] +a[0][1]*b[1][0];
		c[0][1] = a[0][0]*b[0][1] +a[0][1]*b[1][1];
		c[1][0] = a[1][0]*b[0][0] +a[1][1]*b[1][0];
		c[1][1] = a[1][0]*b[0][1] +a[1][1]*b[1][1];
		return c;
	}
	
	public static long[][] pow(long a[][] , int n){
		long c[][] = {{1,0},{0,1}};
		while(n>0){
			if((n&1)==1)
				c=mu(c,a);
			a=mu(a,a);
			n>>=1;
		}
		return c;
	}
	
	public  static long fib2(long n){
		if(n<1) return -1;
		if(n==1||n==2) return 1;
		
		long a[][] = new long[][]{{1,1},{1,0}};
		long[][] c = pow(a,(int)n-2);
		
		return c[0][0]+c[0][1];
	}
	
	public static void main(String[] args) {
		System.out.println(fib(10));
		System.out.println(fib2(10));
	}
}
