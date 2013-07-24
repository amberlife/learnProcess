package algorithm.CrackingTheCodingInterview.BitManipulation;

/**
 *Write a function to determine the number of bits required to convert integer A to integer B.
 * 计算从整数A变为整数B所需要修改的二进制位数
 * 
 * 输入：31 14
 * 输出：2
 * 
 *思考：
 *简单题，对整数A，B做异或操作，然后计算结果中1的个数
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
