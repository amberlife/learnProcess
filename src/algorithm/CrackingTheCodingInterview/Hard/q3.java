package algorithm.CrackingTheCodingInterview.Hard;

import java.util.Random;


/**
 * дһ������������شӴ�СΪn��������ѡȡm��������Ҫ��ÿ��Ԫ�ر�ѡ�еĸ������
 * 
 *���������ϴ�Ƴ������ƣ�ֻ��Ҫ�����ѡȡһ��Ԫ�أ�Ȼ����ʣ�µ�Ԫ�������ѡȡ��һ��Ԫ�أ����������������ɡ�
 *
 *ѡȡ��һ��Ԫ�أ�n����ѡȡ1��������1/n
 *ѡȡ�ڶ���Ԫ��:ʣ�µ�n-1����ѡȡ1����((n-1)/n)*(1/(n-1))=1/n
 *��������
 *
 *�����ϴ�Ƴ����޸�һ�£�ֻѡȡ�����ǰm�����ͺ��ˡ�
 */
public class q3 {
	public static void pickRandomly(int a[],int m){
		Random rand = new Random();
		for(int i=0;i<m;i++){
			int j = rand.nextInt(a.length-i)+i;
			int tmp = a[i];
			a[i]  = a[j];
			a[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		int m=5;
		pickRandomly(a,m);
		for(int i=0;i<m;i++){
			System.out.print(a[i]+" ");
		}
	}
}
