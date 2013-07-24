package algorithm.CrackingTheCodingInterview.BitManipulation;

/**
 * An array A[1��n] contains all the integers from 0 to n except for one number which 
 * is missing. In this problem, we cannot access an entire integer in A with a single 
 * operation. The elements of A are represented in binary, and the only operation we 
 * can use to access them is ��fetch the jth bit of A[i]��, which takes constant time. 
 * Write code to find the missing integer. Can you do it in O(n) time?
 * 
 * ����A[1��n]����0��n����������������һ��������ʧ�ˡ�����������У� ���ǲ���ֱ��ͨ��A[i]ȡ�������еĵ�i������
 * ����A����ʾ�ɶ����ƣ� Ҳ����һ����0/1�ַ���������Ψһ��ʹ�õĲ���ֻ�С�ȡ��A[i]�еĵ�jλ���� �������ֻ��Ҫ���ѳ���ʱ�䡣
 * д�����ҳ���ʧ������������ʹ�����ʱ�临�Ӷ���O(n)��
 * 
 * ȡ��A[i]�еĵ�jλ����Ӧ����fetch(A,i,j),���ԣ�ȡ����i��ֻ��Ҫ����fetch����32�μ��ɡ�
 * ͬʱ����һ��boolean���飬�������ĳ������i����boolean����ĵ�i��Ԫ����Ϊtrue��
 * �ڱ���һ�飬���ҵ����Ǹ�����������������
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
