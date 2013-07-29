package algorithm.CrackingTheCodingInterview.SortAndSearch;

/**
 * Given a sorted array of strings which is interspersed with empty strings, 
 * write a method to find the location of a given string.
 * 
 * Example: 
 * 	find ��ball�� in [��at��, ����, ����, ����, ��ball��, ����, ����, ��car��, ����,����, ��dad��, ����, ����] will return 4
 * Example: 
 *  find ��ballcar�� in [��at��, ����, ����, ����, ����, ��ball��, ��car��, ����, ����, ��dad��, ����, ����] will return -1
 * ����һ���ź���Ĳ��Ҵ����п��ַ������ַ������飬дһ�������ҵ������ַ�����λ�á�
 * 
 * ˼����
 * ����Ŀ���Զ��ֲ�����һЩ�޸ļ��ɡ�
 * lowָ��ָ����С��Ԫ�أ������ǿ�ֵ
 * highָ��ָ������Ԫ�أ�Ҳ�����ǿ�ֵ��
 * ���mid=(low+high)>>1 ����midָ���м�ֵ������м�ֵ�ǿ�ֵ���͹涨���ҽ����ƶ�ֱ��һ���ǿ�ֵ���ж���ҪѰ�ҵ�Ԫ��
 * �����mid��ָ��ֵ��˵������Ѱ�ҵ�ֵ���Ұ�Σ�����������Ρ��ظ�����������low>highΪֹ
 * 
 */
public class q5 {
	public static int search(char[] arr,int low ,int high,char k){
		while(low<=high){
			int mid=(low+high)>>1;
			int t= mid;
			while(t<arr.length&&arr[t]==0){
				t++;
			}
			
			if(t>high)
				high = mid-1;
			else{
				if(arr[t]==k)
					return t;
				else if(arr[t]<k) low =t+1;
				else high =mid-1;
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		char[] arr= new char[]{'a',0,'b',0,0,'c','e',0,0};
		
		int idx=search(arr,0,arr.length-1,'e');
		System.out.println(idx);
	}
	
}
