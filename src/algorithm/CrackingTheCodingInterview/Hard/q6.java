package algorithm.CrackingTheCodingInterview.Hard;

import java.util.Arrays;

/**
 * ��Ŀ��������ǰĿ¼�� q6.md
 * 
 * ��ĿҪ����10�ڸ�������Ѱ����100�����̨��
 * ���ǰ�Ҫ���С(100�������������100��)��Ȼ��ʵ��q6.md�����������ַ���
 * 
 */
public class q6 {
	
	//������ķ�ʽʵ��
	public static int[] sort(int[] arr){
		Arrays.sort(arr);
		return Arrays.copyOfRange(arr, arr.length-100, arr.length);
	}
	
	//����С�ѵķ�ʽʵ��
	public static int[] minHeap(){
		
		return null;
	}
	
	//������K���
	public static int[] partition(){
		return null;
	}
}
