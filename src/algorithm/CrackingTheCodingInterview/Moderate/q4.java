package algorithm.CrackingTheCodingInterview.Moderate;

/**
 * question4:
 * Write a method which finds the maximum of two numbers. You should not use if-else or any other comparison operator.
 * ʵ��һ����ʽ���ҵ��������еĽϴ��ߣ��㲻�ܹ�ʹ��if-else�������καȽϲ�����
 * ����10 5 
 * ��� 10 
 * 
 * ������if-else �� �Ƚϲ�������
 * �����ȿ����Ƚϲ���������Щ ��< , > ,==, >=,<=,&&,||
 * 
 * �ǳ�ȥ��Щ�����ǻ����ò�����������Щ�� һЩλ������ << ,>>,&,|,=
 * ��ô���ǿ�����ΰѳ��õıȽϲ�����ת����ʹ����Щλ������
 * 
 * if(a>b) return a ;else  return b ;
 * if(a-b>0) return a  ; else return b;
 * if(a-b>0) k=1; else k=0; return a-k(a-b)
 * z=a-b a>b ��z>0�����λ��0,a<b �� z<0�����λ��1�������з����������ص㣬�Դ˿��Եó�kֵ
 * ��ô  ���Է���Ϊ�� a-k*z
 */
public class q4 {
	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		int z=a-b;
		int k=(z>>>31);
		System.out.println(a-k*z);
	}
}
