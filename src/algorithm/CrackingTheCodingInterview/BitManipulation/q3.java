package algorithm.CrackingTheCodingInterview.BitManipulation;

/**
 * Given an integer, print the next smallest and next largest number that have the same 
 * number of 1 bits in their binary representation.
 * 给定一个整数x，找出另外两个整数，这两个整数的二进制表示中1的个数和x相同， 其中一个是比x大的数中最小的，另一个是比x小的数中最大的。
 * 
 * 首先将问题拆解。如何找出一个整数的二进制中1的个数。
 * method1:用2去除
 * method2：右移，看移除的位是否为1
 * method3：位操作的归并算法，这里，只实现这个方法，这个方法有个正式的名字叫做：hamming-weight
 * 参考链接地址：
 *	 http://en.wikipedia.org/wiki/Hamming_weight
 *
 *任意一个二进制数t:1101 0011
 *找一个和t中1的个数一样多的，但是比1小的数：
 *   从高位到低位找到最后一个为1的位,并且记录1的个数为c，那么该位的下一位必然是0，记作b，将这个0位置为1，将b+1至b+c-1位置为1，其余高位为0
 *找一个和t中1的个数一样多的，但是比1小的数：
 *	 从低位到高位找到第一个1，并记录1的个数为c，从它开始，找到 第一个0，将这个0变为1，比这个位低的位全都置为0，随后在低位上不上c-1个1.
 *   
 * 
 */
public class q3 {
	
	public static int findSmaller(int n){
		int left1Count=0;
		int bit=31;
		int x=1<<31;
		//找到高位的第一个1的位置
		for(;(n&x)==0&&bit>0;x>>>=1,bit--);
		//找到高位第一个1后的第一个0的位置
		for(;(n&x)!=0&&bit>0;x>>>=1,left1Count++,bit--);
		n=x|n;
		bit++;
		//高位全部置为0
		n&=((1<<bit)-1);
		//从0开始的高位添加left1Count-1个1
		while((--left1Count)>0){
			n|=1<<bit;
			bit<<=1;
		}
		return n ;
	}
	
	public static int findBigger(int n){
		int right1Count=0;
		int bit = 0 ;
		int x=1;
		//找到低位的第一个1的位置
		for(;(n&x)==0&&bit<32;x<<=1,bit++);
		//找到第一个1后的第一个0的位置
		for(;(n&x)!=0&&bit<32;x<<=1,right1Count++,bit++);
		//将该位的0置为1
		n=x|n;
		//低位全部置为0
		n&=~(x-1);
		//低位变为1
		int p=1;
		while((--right1Count)>0){
			n|=p;
			p<<=1;
		}
		return n ;
		
	}
	
	//整数的二进制表示中1的个数
	public static int bitNumber(int n){
		n=(n&(0x55555555))+((n>>1)&(0x55555555));
		n=(n&(0x33333333))+((n>>2)&(0x33333333));
		n=(n&(0x0f0f0f0f))+((n>>4)&(0x0f0f0f0f));
		n=(n&(0x00ff00ff))+((n>>8)&(0x00ff00ff));
		n=(n&(0x0000ffff))+((n>>16)&(0x0000ffff));
		return n;
	}
	public static void main(String[] args) {
		int number = 1111;
		System.out.println(Integer.toBinaryString(number));
		int smaller = findSmaller(number);
		int bigger = findBigger(number);
		System.out.println(Integer.toBinaryString(smaller));
		System.out.println(Integer.toBinaryString(bigger));
	}
}
