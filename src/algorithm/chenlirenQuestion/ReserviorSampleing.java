package algorithm.chenlirenQuestion;

import java.util.Arrays;
import java.util.Random;

/**
 * ��ˮ�س�������
 * Reservoir sampling is a family of randomized algorithms for randomly choosing k samples 
 * from a list S containing n items,where n is either a very large or unknown number.Typically
 * n is large enough that the list doesn't fit into main memory. the most common example was 
 * labeled Algorithm  R by Jeffery Vitter[1] n his paper on the subject.
 * [1] http://www.cs.umd.edu/~samir/498/vitter.pdf
 * 
 * **************ԭ��**********************
 * ����򵥵����ӳ�����������ֻ��һ�����ݡ����ǽ������ݣ����������������ˣ�
 * ֱ�ӷ��ظ����ݣ������ݷ��صĸ���Ϊ1�������ܼ򵥣���ô����������һ�����������������������������ݡ�
 * 
 * ���Ƕ����˵�һ�����ݣ�������ǲ���ֱ�ӷ��ظ����ݣ���Ϊ������û�н��������Ǽ�����ȡ�ڶ������ݣ����������������ˡ�
 * �������ֻҪ��֤����ͬ�ĸ��ʷ��ص�һ�����ߵڶ������ݾͿ���������ĿҪ�������������һ��0��1�������R,���RС��0.5���Ǿ�
 * ���ص�һ�����ݣ����R����0.5�����صڶ������ݡ�
 * 
 * �������Ǽ����������������ݵ��������������Ϊ�˷��㣬���ǰ�˳������е���������Ϊ1��2��3��
 * ����½���յ�������1��2��ǰ�������һ��������ֻ�ܱ���һ�����ݣ����Ա�����̭1��2�е�һ����
 * Ӧ�������̭�أ���������������һ�������ǰ��ն���֮һ�ĸ�����̭һ��������������̭��2��
 * ������ȡ���е�����3�����������������ˣ�����֪���ڳ���Ϊ3���������У������������3�ĸ���Ϊ1/3,
 * ��ô���п��ܱ�֤ѡ�����ȷ�ԡ�Ҳ����˵��Ŀǰ����������1,3�������ݣ�����ͨ��һ�����ѡ����1/3�ĸ�����������3����2/3�ĸ�����������1.
 * ��ô����1���������µĸ����Ƕ����أ�
 * 		����1�����£���1/2��*(2/3) = 1/3
 * 		����2�����¸��ʣ���1/2��*(2/3) = 1/3
 * 		����3�����¸��ʣ�1/3
 * 
 * �����������������ĿҪ���������ݱ����·��صĸ���һ����
 * ��ˣ�������һ�����ۣ����赱ǰ��Ҫ��ȡ��n�����ݣ���������1/n�ĸ������¸����ݣ�
 * ��������ǰn-1�������е�һ���������ַ���ѡ�����������������ݱ�ѡ��ĸ���һ����
 * ��̵�֤��������n-1ʱ���������ǰn-1�����ݱ����صĸ��ʶ���1/n-1,��ǰ���ڶ�ȡ��n�����ݣ�
 * ��1/n�ĸ��ʷ���������ôǰn-1�����������ݱ����صĸ���Ϊ��(1/(n-1))*((n-1)/n)= 1/n�����������
 * 
 ************ α���룺***********************
 *   array R[k] //result
 *   integer i,j;
 *   
 *   //fill the reservoir array
 *   for each i in 1 to k do
 *     R[i] := S[i]
 *   done
 *   
 *   for each i in k+1 to length(S) do 
 *    j := random(1,i)
 *    if j<=k then:
 *     R[j] := S[i];
 *    fi
 *   done
 *   
 *   
 */
public class ReserviorSampleing {
	public static void main(String[] args) {
		Random random = new Random(10000);
		int k=10;
		int[] S = new int[10000];
		int n = S.length;
		for(int i=0;i<n;i++){
			S[i] = random.nextInt(10000);
		}
		int[] R = new int[k];
		
		for(int i=0;i<k;i++){
			R[i] = S[i];
		}
		for(int i=k;i<S.length;i++){
			int  j = random.nextInt(i);
			if(j<k){
				R[j] = S[i];
			}
		}
		System.out.println(Arrays.toString(S));
		System.out.println(Arrays.toString(R));
	}
}
