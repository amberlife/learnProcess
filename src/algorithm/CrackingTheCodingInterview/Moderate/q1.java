package algorithm.CrackingTheCodingInterview.Moderate;

/**
 *question1
 *�������м��������������
 *
 *����һ�Ǿ��䷽���ˡ�
 */
public class q1 {
	public static void main(String[] args) {
		int a=10;
		int b=20;
		System.out.printf("a=%d,b=%d\n",a,b);
		//����1
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.printf("a=%d,b=%d\n",a,b);
		//����2
		b=a-b;
		a=a-b;
		b=a+b;
		System.out.printf("a=%d,b=%d\n",a,b);
	}
}
