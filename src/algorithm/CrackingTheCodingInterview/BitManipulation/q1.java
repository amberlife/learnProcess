package algorithm.CrackingTheCodingInterview.BitManipulation;

/**
 *You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
 *Write a method to set all bits between i and j in N equal to M (e.g., M becomes a substring of N located at i and starting at j).
 *example:
 *Input: N = 100 0000 0000, M = 10101, i = 2, j = 6
 *Output: N = 100  0101 0100
 *
 *˼������N�ĵ�i��jλ��M�е���ͬ(����M���N���Ӵ���λ��N�ĵ�iλ�͵�jλ֮��)
 *����Ҫ��N�еĵ�iλ����jλת����0��Ȼ��M����jλ��Ȼ����߽���λ��|����
 *��n�еĵ�i��jλת��0������һ������ķ�ʽ���С����룺��λ����iλΪ1����i����jλΪ0����jλ����λΪ1��
 */
public class q1 {
	public static void convert(int n ,int m,int i,int j){
		int max = ~0;
		int left = max-((1<<j+1)-1);
		int right =((1<<i))-1;
		int mask=left|right;
		int converted= (n&mask)|(m<<i);
		System.out.println(converted);
	}
	public static void main(String[] args) {
		convert(1<<10,21,2,6);
	}
}
