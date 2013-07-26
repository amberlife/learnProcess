package algorithm.CrackingTheCodingInterview.Recursion;

/**
 * Implement an algorithm to print all valid (e.g., properly opened and closed) 
 * combinations of n-pairs of parentheses
 * ʵ��һ���㷨��ӡ��n�����ŵ���Ч��ϡ�
 * ���룺3
 * �����((())), (()()), (())(), ()(()), ()()()
 * 
 * ˼����
 * ��Ч����ϱ���Ϊ�������ŵ���������ϵ������Ӵ��ϴ��ڵ��������ŵ�����
 * ((())) left=3 right3
 * (      left=1 right=0
 * ((     left=2 right=0
 * (((    left=3 right=0
 * ((()   left=3 right=1
 * ((())  left=3 right=2
 * ((())) left=3 right=3
 * 
 * ���������̣����Է���
 *   ��û����������ʱ���ַ�����������ɣ�ֱ�����
 *   �����һ�������ſ��ã���ô���Լ����ַ���
 *      ������һ�������ź���Ҫ����һ�������ţ��Ա���"ƽ��"
 *   �����һ�������ſ��ã���ô���Լ����ַ�����
 *      ��ʱ������һ��������
 *���ԣ�����ͨ���ݹ�ķ�ʽ�����������⡣
 *
 *�����Ŀ�ĵݹ鹫ʽӦ�õĺ�������˳�һ��ݹ�󣬴�������������У����ֽ��뵽һ��ݹ��У���ʱҲ�Ϳ�����������һ�������
 *����Ϥ�¡�
 * 
 * 
 */
public class q5 {
	static void brackets(int openStock, int closeStock, String s) {
        if (openStock == 0 && closeStock == 0) {
            System.out.println(s);
        }
        if (openStock > 0) {
            brackets(openStock-1, closeStock+1, s + "(");
        }
        if (closeStock > 0) {
            brackets(openStock, closeStock-1, s + ")");
        }
    }
	
	public static void main(String[] args) {
	    brackets(3, 0, "");
	}
}
