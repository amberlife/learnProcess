package algorithm.CrackingTheCodingInterview.Recursion;

/**
 * Imagine a robot sitting on the upper left hand corner of an NxN grid. 
 * The robot can only move in two directions: right and down. How many possible paths are there for the robot?
 * FOLLOW UP
 * Imagine certain squares are ��off limits��, such that the robot can not step on them. 
 * Design an algorithm to get all possible paths for the robot.
 * 
 * �����Ŀ���ڶ�̬�滮����ϵ�У���һ�����Ƶ���Ŀ
 * algorithm.DP.AvoidRoad.java,����������topcoder��
 * http://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709
 * 
 * ���õݹ���߶�̬�滮�����ԡ����֮�£���̬�滮�����Լ����м���̵��ظ����㡣
 * ��������������ѧ�е�������Ͻ���
 * ��(1,1)�ߵ�(m,n)���൱����������m-1������������n-1����
 * C(m-1+n-1,m-1)=(m-1+n-1)!/((m-1)!*(n-1)!),����follow up�е������������÷�����һ���ʺ�
 * 
 * 
 *
 */
public class q2 {
	public static long recPath(int m ,int n,boolean[][] g){
		
		if(m==0||n==0)
			return 1; 
		else 
			if(g[m-1][n]&&g[m][n-1])
				return recPath(m-1,n,g)+recPath(m,n-1,g);
			else if(g[m-1][n]&&!g[m][n-1])
				return recPath(m-1,n,g);
			else if(!g[m-1][n]&&g[m][n-1])
				return recPath(m,n-1,g);
			else
				return 0 ;
			
	}
	
	public static void main(String[] args) {
		boolean[][] g ={ {true,true,true,true},
						 {true,true,true,true},
						 {true,true,false,true},
						 {true,true,true,true}};
		long count = recPath(3,3,g);
		System.out.println(count);
	}
	

}
