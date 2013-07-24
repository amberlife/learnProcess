package algorithm.CrackingTheCodingInterview.BitManipulation;

/**
 * Given an integer, print the next smallest and next largest number that have the same 
 * number of 1 bits in their binary representation.
 * ����һ������x���ҳ��������������������������Ķ����Ʊ�ʾ��1�ĸ�����x��ͬ�� ����һ���Ǳ�x���������С�ģ���һ���Ǳ�xС���������ġ�
 * 
 * ���Ƚ������⡣����ҳ�һ�������Ķ�������1�ĸ�����
 * method1:��2ȥ��
 * method2�����ƣ����Ƴ���λ�Ƿ�Ϊ1
 * method3��λ�����Ĺ鲢�㷨�����ֻʵ�������������������и���ʽ�����ֽ�����hamming-weight
 * �ο����ӵ�ַ��
 *	 http://en.wikipedia.org/wiki/Hamming_weight
 *
 *����һ����������t:1101 0011
 *��һ����t��1�ĸ���һ����ģ����Ǳ�1С������
 *   �Ӹ�λ����λ�ҵ����һ��Ϊ1��λ,���Ҽ�¼1�ĸ���Ϊc����ô��λ����һλ��Ȼ��0������b�������0λ��Ϊ1����b+1��b+c-1λ��Ϊ1�������λΪ0
 *��һ����t��1�ĸ���һ����ģ����Ǳ�1С������
 *	 �ӵ�λ����λ�ҵ���һ��1������¼1�ĸ���Ϊc��������ʼ���ҵ� ��һ��0�������0��Ϊ1�������λ�͵�λȫ����Ϊ0������ڵ�λ�ϲ���c-1��1.
 *   
 * 
 */
public class q3 {
	
	public static int findSmaller(int n){
		int left1Count=0;
		int bit=31;
		int x=1<<31;
		//�ҵ���λ�ĵ�һ��1��λ��
		for(;(n&x)==0&&bit>0;x>>>=1,bit--);
		//�ҵ���λ��һ��1��ĵ�һ��0��λ��
		for(;(n&x)!=0&&bit>0;x>>>=1,left1Count++,bit--);
		n=x|n;
		bit++;
		//��λȫ����Ϊ0
		n&=((1<<bit)-1);
		//��0��ʼ�ĸ�λ���left1Count-1��1
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
		//�ҵ���λ�ĵ�һ��1��λ��
		for(;(n&x)==0&&bit<32;x<<=1,bit++);
		//�ҵ���һ��1��ĵ�һ��0��λ��
		for(;(n&x)!=0&&bit<32;x<<=1,right1Count++,bit++);
		//����λ��0��Ϊ1
		n=x|n;
		//��λȫ����Ϊ0
		n&=~(x-1);
		//��λ��Ϊ1
		int p=1;
		while((--right1Count)>0){
			n|=p;
			p<<=1;
		}
		return n ;
		
	}
	
	//�����Ķ����Ʊ�ʾ��1�ĸ���
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
