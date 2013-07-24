package algorithm.CrackingTheCodingInterview.BitManipulation;

/**
 *Write a function to determine the number of bits required to convert integer A to integer B.
 * ���������A��Ϊ����B����Ҫ�޸ĵĶ�����λ��
 * 
 * ���룺31 14
 * �����2
 * 
 *˼����
 *���⣬������A��B����������Ȼ���������1�ĸ���
 */
public class q5 {
	public static int bitCount(int n){
		n=(n&0x55555555)+(n>>1)&(0x55555555);
		n=(n&0x33333333)+(n>>2)&(0x33333333);
		n=(n&0x0f0f0f0f)+(n>>4)&(0x0f0f0f0f);
		n=(n&0x00ff00ff)+(n>>8)&(0x00ff00ff);
		n=(n&0x0000ffff)+(n>>16)&(0x0000ffff);
		return n ;
	}
	public static void main(String[] args) {
		int c = 31^14;
		System.out.println(bitCount(c));
	}
}
