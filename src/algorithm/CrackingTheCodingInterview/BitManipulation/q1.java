package algorithm.CrackingTheCodingInterview.BitManipulation;

/**
 *You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
 *Write a method to set all bits between i and j in N equal to M (e.g., M becomes a substring of N located at i and starting at j).
 *example:
 *Input: N = 100 0000 0000, M = 10101, i = 2, j = 6
 *Output: N = 100  0101 0100
 *
 *思考：将N的第i至j位与M中的相同(即：M变成N的子串且位于N的第i位和第j位之间)
 *首先要将N中的第i位至第j位转换成0，然后将M左移j位，然后二者进行位或|操作
 *将n中的第i至j位转成0，采用一个掩码的方式进行。掩码：低位至第i位为1，第i至第j位为0，第j位至高位为1。
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
