package algorithm.chenlirenQuestion;

/**
 *问题描述：给你一个数组A[1...n],请在o(n)时间内构造一个新的数组B[1...n]
 *使得B[i]=A[1]*A[2]*...*A[n]/A[i]，不能使用除法运算
 *
 *思路:
 *B[1]=A[2]*A[3]*...*A[n]
 *B[2]=A[1]*A[3]*...*A[n]
 *B[3]=A[1]*A[2]*A[4]*...*A[n]
 *....
 *B[n-1]=A[1]*A[2]*...*A[n-2]*A[n]
 *B[n]=A[1]*A[2]*...*A[n-1]
 *手动推算后，发现对于：
 *B[i]={A[0]*...*A[i-1]}*{A[i+1]*...*A[n]}
 *这样两部分组成，因此分别看待这两部分问题：
 *令：C[i]=A[0]*...*A[i-1], (1<=i<=n)
 *   D[i]=A[i+1]*...*A[n], (0<=i<=n-1)
 *那么B[i]=C[i]*D[i]，
 *对于C[i],D[i],通过两次遍历即可求出，
 *随后可依次计算B[i],算法时间复杂度为o(n)
 */
public class SelflessMultiplication {
	public static void main(String[] args) {
		int[] A= new int[]{1,2,3,4,5,6,7,8,9,10};
		int[] B= new int[A.length];
		int[] C= new int[A.length];
		int[] D= new int[A.length];
		
		C[0]=1;
		for(int i=1;i<A.length;i++){
			C[i] =C[i-1]*A[i-1];
		}
		D[A.length-1]=1;
		for(int i=A.length-2;i>=0;i--){
			D[i]=D[i+1]*A[i+1];
		}
		for(int i=0;i<A.length;i++){
			B[i]=C[i]*D[i];
			System.out.print(B[i]+" ");
		}
		
	}
}
