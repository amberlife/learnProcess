package algorithm.CrackingTheCodingInterview.Moderate;

/**
 * question6:
 * You are given an array of integers (both positive and negative). 
 * Find the continuous sequence with the largest sum. Return the sum.
 * ����һ����������(���������͸���)���ҵ����������������У����غ͡�
 * 
 * ���룺{2,-8,3,-2,4,-10}
 * �����5 (3,-2,4)
 * 
 * �����������У�����������������ǰ��(cursum)������(maxsum).���������У����µ�ǰ�ͺ����͡�
 * ����ǰ�͵�ֵΪ����ʱ���ٳ���֮ǰ���еĺͣ�ȡ��һ������Ϊ��ǰ�͡�
 * ��ǰ�ͺ�����ʼ�ձȶԣ�һ����ǰ�ʹ������ͣ��������ͣ����������������ҵ����͡�
 */
public class q7 {
	public static void main(String[] args) {
		int[] arr={2,-8,3,-2,4,10};
		
		int cursum=arr[0];
		int maxsum=arr[0];
		for(int i=1;i<arr.length;i++){
			cursum+=arr[i];
			if(cursum<0){
				cursum=0;
				continue;
			}else{
				if(cursum>maxsum){
					maxsum=cursum;
				}
			}
		}
		
		System.out.println(maxsum);
	}
}
