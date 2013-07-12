package algorithm.chenlirenQuestion;

/**
 *��������������һ������A[1...n],����o(n)ʱ���ڹ���һ���µ�����B[1...n]
 *ʹ��B[i]=A[1]*A[2]*...*A[n]/A[i]������ʹ�ó�������
 *
 *˼·:
 *B[1]=A[2]*A[3]*...*A[n]
 *B[2]=A[1]*A[3]*...*A[n]
 *B[3]=A[1]*A[2]*A[4]*...*A[n]
 *....
 *B[n-1]=A[1]*A[2]*...*A[n-2]*A[n]
 *B[n]=A[1]*A[2]*...*A[n-1]
 *�ֶ�����󣬷��ֶ��ڣ�
 *B[i]={A[0]*...*A[i-1]}*{A[i+1]*...*A[n]}
 *������������ɣ���˷ֱ𿴴������������⣺
 *�C[i]=A[0]*...*A[i-1], (1<=i<=n)
 *   D[i]=A[i+1]*...*A[n], (0<=i<=n-1)
 *��ôB[i]=C[i]*D[i]��
 *����C[i],D[i],ͨ�����α������������
 *�������μ���B[i],�㷨ʱ�临�Ӷ�Ϊo(n)
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
