package algorithm.CrackingTheCodingInterview.Recursion;

/**
 * Imagine a robot sitting on the upper left hand corner of an NxN grid. 
 * The robot can only move in two directions: right and down. How many possible paths are there for the robot?
 * FOLLOW UP
 * Imagine certain squares are “off limits”, such that the robot can not step on them. 
 * Design an algorithm to get all possible paths for the robot.
 * 
 * 这道题目，在动态规划的联系中，有一道类似的题目
 * algorithm.DP.AvoidRoad.java,此题来自于topcoder：
 * http://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709
 * 
 * 采用递归或者动态规划都可以。相比之下，动态规划，可以减少中间过程的重复计算。
 * 方法三：采用数学中的排列组合进行
 * 从(1,1)走到(m,n)，相当于向下走了m-1步，向右走了n-1步。
 * C(m-1+n-1,m-1)=(m-1+n-1)!/((m-1)!*(n-1)!),对于follow up中的限制条件，该方法不一定适合
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
