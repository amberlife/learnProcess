package algorithm.CrackingTheCodingInterview.BitManipulation;

/**
 *Write a program to swap odd and even bits in an integer with as few instructions 
 *as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc)
 *
 *交换一个整数二进制中的奇数位和偶数位
 *
 *题目简单，只需将奇数位和偶数位提取出来，二者取或
 */
public class q6 {
	public static int swapBit(int x){
		return ((x&0x55555555)<<1)|(x>>1)&(0x55555555);
	}
	public static void main(String[] args) {
		System.out.println(swapBit(10));
	}
}
