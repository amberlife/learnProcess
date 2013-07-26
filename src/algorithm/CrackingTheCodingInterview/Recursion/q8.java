package algorithm.CrackingTheCodingInterview.Recursion;

/**
 *Write an algorithm to print all ways of arranging eight queens on a chess board 
 *so that none of them share the same row, column or diagonal.
 *
 *八皇后问题
 *八皇后问题的解法，采用回溯法。从上到下每一行放置一个皇后，进行搜索。若在某一行的任意一列放置皇后均不能满足要求，则不再
 *向下进行搜索，而进行回溯，回溯到其他列可以放置皇后的一行，再向下进行搜索。知道搜索到最后一行，找到可行解，输出。
 *
 */
public class q8 {
	public int[][] m = new int[8][8];//棋盘
	public int num=1;//解的数量
	
	boolean check(int row,int col){
		if(row==0){
			return true;
		}
		// 列检查
		for (int i = 0; i < row; i++) {
			if (m[i][col] == 1)
				return false;
		}
		//右下至左上检查
		int i=row-1;
		int j=col-1;
		while(i>=0&&j>=0){
			if(m[i][j]==1) return false;
			i--;
			j--;
		}
		
		//左下至右上检查
		i=row-1;
		j=col+1;
		while(i>=0&&j<8){
			if(m[i][j]==1) return false;
			i--;
			j++;
		}
		
		return true;
	}
	public void print(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.printf("%2d",m[i][j]);
			}
			System.out.println();
		}
	}
	public void queen8(int row){
		for(int i=0;i<8;i++){
			//在其中一列中放置皇后
			m[row-1][i]=1;
			if(check(row-1,i)){
				if(row==8){
					System.out.println("**** solution "+num+" ****");
					print();
					num++;
				}
				else
					queen8(row+1);
			}
			//已尝试过该列，尝试其他的列
			m[row-1][i]=0;
		}
	}
	public static void main(String[] args) {
		q8 queen8 = new q8();
		queen8.queen8(1);
	}
}
