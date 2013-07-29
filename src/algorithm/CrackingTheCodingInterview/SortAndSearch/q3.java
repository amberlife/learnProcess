package algorithm.CrackingTheCodingInterview.SortAndSearch;

/**
 *Given a sorted array of n integers that has been rotated an unknown number of times, 
 *give an O(log n) algorithm that finds an element in the array. 
 *You may assume that the array was originally sorted in increasing order.
 *EXAMPLE:
 *Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 *Output: 8 (the index of 5 in the array)
 *
 *һ��������n�������������ź���(����Ϊ����)������ת��δ֪�Σ� ��ÿ�ΰ����ұߵ����ŵ�����ߡ�����һ��O(log n)���㷨�ҵ��ض���ĳ��Ԫ�ء�
 *���룺������(15 16 19 20 25 1 3 4 5 7 10 14)���ҳ�5
 *�����8��5�������е��±꣩
 *
 *�ַ�������ת��δ֪��,���Է����ַ����Ƿ�Ϊ���������������������Ļ������Ƕ��ֲ��ҷ����Ϳ�����O(log n)��ʱ������ɡ�
 *���ԣ���������������������ǻ��ǿ��Կ���ʹ�õ�����Ķ��ֲ��ҷ���
 *������ΪS��Ҫ����Ԫ��Ϊk
 *��������ָ�룬ͷָ��head,βָ��tail,�м�ָ��mid��
 *mid=(head+tail)>>1
 *S[head]=15,S[tail]=14,S[mid]=3,k=16;
 *��ΪS[mid]=3��С��k��ֵ��ͬʱS[mid]С��S[head]��С��S[tail]
 *���ԣ�����˵����s[mid...tail]����ǵ����ġ�Ȼ��kֵ����S[tail]��
 *���ԣ�����˵��kλ��S[head...mid]��һ���ڣ�������һ���ڵ�ֵ���ǵ����ġ�
 *���ԣ���ʱ���������ƶ�midָ�룬ֱ��k>S[mid],�������˵����ʱ��head
 *��mid��ֵ�ǵ����ģ���󣬼���ʹ�ô�ͳ�Ķ��ֲ��������С�
 *
 */
public class q3 {
	static int search(int a[],int head,int tail,int x){
		while(head<=tail){
			int mid = (head+tail)>>1;
			if(a[mid]==x) return mid;
			if(a[mid]<x){
				if(a[mid]<a[head]){
					if(a[head]<=x) tail=mid-1;
					else head=mid+1;
				}else{
					head=mid+1;
				}
			}else{
				if(a[mid]<a[head]){
					tail = mid-1;
				}else{
					if(a[head]<=x) tail =mid-1;
					else head=mid+1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] a = {15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(search(a,0,11,5));
	}
}