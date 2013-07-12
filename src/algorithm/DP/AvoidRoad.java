package algorithm.DP;
/**
 * 
 * source:
 * TopCoder:http://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709
 * question:
 * 		AvoidRoad
 * In the city, roads are arranged in a grid pattern.
 *  Each point on the grid represents a corner where 
 *  two blocks meet. The points are connected by line 
 *  segments which represent the various street blocks. 
 *  Using the cartesian coordinate system, we can assign 
 *  a pair of integers to each corner as shown below. 
 *  
 *  You are standing at the corner with coordinates 0,0. 
 *  Your destination is at corner width,height. 
 *  You will return the number of distinct paths that lead 
 *  to your destination. Each path must use exactly width+height blocks. 
 *  In addition, the city has declared certain street blocks untraversable. 
 *  These blocks may not be a part of any path. You will be given a String[] 
 *  bad describing which blocks are bad. If (quotes for clarity) "a b c d" is 
 *  an element of bad, it means the block from corner a,b to corner c,d is untraversable. 
 *  For example, let's say
 *  width  = 6
 *  length = 6
 *  bad = {"0 0 0 1","6 6 5 6"}
 *  
 */
public class AvoidRoad {
	//static int[][] bad = new int[][]{{0,0,0,1},{5,6,6,6}};
	//static int[][] bad = new int[][]{{0,0,1,0},{1,2,2,2},{1,1,2,1}};
	static int[][] bad={};
	public static void main(String[] args) {
		//int width=6;
		//int length=6;
		//int width=2;
		//int length=2;
		//int width=1;
		//int length=1;
		int width=35;
		int length=31;
		long[][] dp = new long[width+1][length+1];
		dp[0][0]=0;
		for(int i=1;i<length+1;i++){
			if(badCheck(0,i,0,i-1)){
				dp[0][i]=0;
				for(int k=i+1;k<length+1;k++){
					dp[0][k]=0;
				}
				break;
			}else{
				dp[0][i]=1;
			}
		}
		for(int i=1;i<width+1;i++){
			if(badCheck(i,0,i-1,0)){
				dp[i][0]=0;
				for(int k=i+1;k<width+1;k++){
					dp[k][0]=0;
				}
				break;
			}else{
				dp[i][0]=1;
			}
			
		}
		
		
		for(int i=1;i<=width;i++){
			for(int j=1;j<=length;j++){
				if(!badCheck(i-1,j,i,j)){
					dp[i][j]+=dp[i-1][j];
				}
				if(!badCheck(i,j-1,i,j)){
					dp[i][j]+=dp[i][j-1];
				}
			}
		}
		//System.out.println(dp[6][6]);
		//System.out.println(dp[2][2]);
		//System.out.println(dp[1][1]);
		System.out.println(dp[35][31]);
	}
	
	static boolean badCheck(int x1,int y1,int x2,int y2){
		int[] arr = new int[4];
		
		for(int i=0;i<bad.length;i++){
			boolean r1 = bad[i][0]==x1&&bad[i][1]==y1&&bad[i][2]==x2&&bad[i][3]==y2;
			boolean r2 = bad[i][0]==x2&&bad[i][1]==y2&&bad[i][2]==x1&&bad[i][3]==y1;
			if(r1||r2)
				return true;
		}
		return false;
	}
}
