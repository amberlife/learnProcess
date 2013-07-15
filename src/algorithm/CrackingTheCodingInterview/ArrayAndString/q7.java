package algorithm.CrackingTheCodingInterview.ArrayAndString;

/**
 *Write an algorithm such that if an element in an MxN matrix is 0, 
 *its entire row and column is set to 0.
 *写一个函数处理N*M的矩阵，如果矩阵有某个元素为0，那么把它所在的行和列都置为0
 *
 *思路：
 *这道题简单，但是要注意不能遇到一个0元素，就将它的行和列的所有元素都设置为0，如果这样，整个矩阵就全为0了。
 *因此需要两次遍历，第一次遍历记录下值为0的位置，第二次将其所在行和列的值设为0
 */
public class q7 {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{0,2,3,4,5},
				{6,7,0,9,10},
				{11,12,13,14,15}};
		int N=3,M=5;
		boolean[] row = new boolean[N];
		boolean[] column = new boolean[M];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(matrix[i][j]==0){
					row[i]=true;
					column[j]=true;
				}
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(row[i]||column[j]){
					matrix[i][j]=0;
				}
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.printf("%3d",matrix[i][j]);
			}
			System.out.println();
		}
	}
}
