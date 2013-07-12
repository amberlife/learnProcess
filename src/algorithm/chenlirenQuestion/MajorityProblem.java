package algorithm.chenlirenQuestion;

/**
 * 
 * @author Administrator
 * Majority����: ��������A[1...n]�е�Ԫ��a, ����ִ�������[n/2]
 *  ���㷨�Ĺؼ�˼��Դ��������������:
 *  ���Ԫ�� x �� y�ǲ�ͬ��Ԫ��, ��ô�Ƴ�������Ԫ�غ�õ���������B[1...n-2], ��A��majority����ȵ�.
 */
public class MajorityProblem {
	
	public static void main(String[] args) {
		int[] A = new int[]{1,2,2,3,2,2,3};
		System.out.println(majority(A));
	}
	
	public static int majority(int[] A){
		int c = candidate(0,A);
		int count = 0 ;
		for(int j=0;j<A.length;j++){
			if(A[j]==c)
				count++;
		}
		if(count>Math.floor(A.length/2f))
			return c; 
		else return -1;
	}
	
	public static int candidate(int m,int[] A){
		int j=m;
		int c=A[m];
		int count = 1;
		while(j<(A.length-1)&&count>0){
			j++;
			if(A[j]==c)
				count++;
			else 
				count--;
		}
		if(j==(A.length-1)) return c;
		else{
			//����ĵݹ��õ�����
			return candidate(j+1,A);
		}
	}
}
