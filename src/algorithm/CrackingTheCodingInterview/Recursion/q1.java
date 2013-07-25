package algorithm.CrackingTheCodingInterview.Recursion;


/**
 * Write a method to generate the nth Fibonacci number.
 * дһ��������������n��쳲������� 
 * 
 * 쳲��������У�����ĵݹ�����ˡ�
 * ��򵥵ľ���ֱ��д���ݹ����f(n)=f(n-1)+f(n-2),f(1)=f(2)=1;
 * �ݹ����˼���������㣬ֻ��Ҫָ����ֹ�����͵ݹ���ʽ�����ͽ����ˣ������м����ڴ������ظ����㡣���ԣ�Ч�ʻ��½���
 * ���������Ŀ��ͨ����ѧ�Ƶ���������һ�������ٵĽ⡣
 * *** latex*****
 * \left(f_n \\ f_{n-1}\right)=\left(1 \quad 1 \\ 1 \quad 0\right)\left(f_{n-1} \\ f_{n-2}\right)
 * = ... = \left(1 \quad 1 \\ 1 \quad 0\right)^{n-2}\left(f_2 \\ f_1\right)
 * ���������ʽ��ͬʱ���÷��η�����\left(1 \quad 1 \\ 1 \quad 0 \right)^n�ֳ�2�� \left( 1 \quad 1 \\ 1 \quad 0)^(n/2)
 * ��Ȼ���𽥷ֵ�\left(1 \quad 1 \\ 1 \quad 0 \right)^1 
 * ������ʱ�临�Ӷȿ��Խ���log(n)������ָ��ʱ�临�Ӷȣ��кܴ�ĸ���
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
