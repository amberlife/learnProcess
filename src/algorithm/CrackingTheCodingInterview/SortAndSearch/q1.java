package algorithm.CrackingTheCodingInterview.SortAndSearch;

/**
 * You are given two sorted arrays, A and B, and A has a large enough buffer at 
 * the end to hold B. Write a method to merge B into A in sorted order.
 * A , B�����������飬A�Ŀռ��㹻�������B��дһ����������A��B�����ںϳ�һ����������
 * 
 * ��Ŀ��˵��A�Ŀռ��㹻������B����˴���Ŀ���ǲ����ö���Ŀռ�����A��B�ںϡ�
 * �����ݽṹ�Ŀα�������ôһ�����Ƶ�ϰ�⣬ʹ���˶���Ŀռ�C����A��B��Ԫ�����αȽϣ�С��Ԫ�ط���C�С���A����B��һ��
 * �ȽϽ�����ֻ��Ҫ����һ��������Ԫ�����η���C���ɡ�
 * �������ʹ�ö���Ŀռ䡣���ԣ����ܲ��������ıȽϷ���������Ԫ�ط���A��ʱ�򣬻��A�л�û�бȽϹ���Ԫ�ظ��ǵ���
 * ���ԣ����ǿ��Ǵ�β�����бȽϣ��Ͳ������������������ˡ�
 */
public class q1 {
	public static void merge(int[] a ,int[] b ,int m,int n){
		int idx = m+n-1;
		int i=m-1,j=n-1;
		while(i>=0&&j>=0){
			if(a[i]>b[j]){
				a[idx]=a[i];
				i--;
			}else{
				a[idx]=b[j];
				j--;
			}
			idx--;
		}
		while(i>=0){
			a[idx--]=a[i--];
		}
		while(j>=0){
			a[idx--]=b[j--];
		}
	}
	public static void main(String[] args){
		int[] a =new int[10];
		a[0]=1;
		a[1]=3;
		a[2]=5;
		int[] b = new int[5];
		b[0]=2;
		b[1]=4;
		b[2]=6;
		b[3]=7;
		b[4]=8;
		merge(a,b,3,5);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		
	
	}
}
