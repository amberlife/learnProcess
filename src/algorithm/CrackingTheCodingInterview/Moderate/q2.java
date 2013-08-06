package algorithm.CrackingTheCodingInterview.Moderate;

/**
 * question2 
 * Design an algorithm to figure out if someone has won in a game of tic-tac-toe.
 * 设计一个算法，检查某人是否赢得了井字游戏
 * 
 * 井字游戏：是一种在3*3格子上进行的连珠游戏，和五子棋比较类似，由于棋盘一般不画边框，格线排成井字故得名。
 * 游戏需要的工具仅为纸和笔，然后由分别代表O和X的两个游戏者轮流在格子里留下标记（一般来说先手者为X）
 * 
 * 井字游戏玩法简单，一共9个格子，每个格子涉及三种状态: 空,O,X。所以一共有3^9个状态。这个数目也不是很大。
 * 对于游戏需要快速解答的，可以将所有成功结果列举出来，然后直接判断就好了。
 * 还有就是写程序判断当前状态是否为赢状态。
 * 
 * 0表示未下棋子，1表示我方下的棋子，2表示对方下的棋子。可以将任意个一个状态(9个数字)表示称为一个3进制数，然后在转换
 * 成1个整数进行存储。随后直接判断即可。
 * 
 * 
 * 
 */
public class q2 {
	int checkRowColumn(int[] board,int n,check c){
		int type=0;
		for(int i=0;i<n;i++){
			boolean found=true;
			for(int j=0;j<n;j++){
				int k=0;
				if(c==check.ROW){
					k=i*n+j;
				}else{
					k=i+n*j;
				}
				if(j==0){
					type=board[k];
				}else if(board[k]!=type){
					found=false;
					break;
				}
			}
			if(found){
				return type;
			}
		}
		return 0;
	}
	int checkDiagonal(int[] board,int n,check c){
		int type=0;
		boolean found=true;
		for(int i=0;i<n;i++){
				int k=0;
				if(c==check.DIAGONAL){
					k=i+i*n;
				}else{
					k=i+(n-i-1)*n;
				}
				
				if(i==0){
					type=board[k];
				}else if(board[k]!=type){
					found=false;
					break;
				}
		}
		if(found)
			return type;
		return 0 ;
	}
	
	int HasWon(int board[], int n){
	    int type = 0;
	    type =checkRowColumn(board, n, check.ROW);
	    if(type != 0) return type;
	    type = checkRowColumn(board, n, check.COLUMN);
	    if(type != 0) return type;
	    type = checkDiagonal(board, n, check.DIAGONAL);
	    if(type != 0) return type;
	    type = checkDiagonal(board, n, check.REDIAGONAL);
	    if(type != 0) return type;
	    return 0;
	}
	
	public static void main(String[] args) {
		int n=3;
		int board[]={
				2,2,1,
				2,1,1,
				1,2,0
		};
		q2 q = new q2();
		int type=q.HasWon(board, n);
		if(type!=0){
			System.out.println(type+" won!");
		}else{
			System.out.println("Nobody won!");
		}
	}
}
enum check{
	ROW,COLUMN,DIAGONAL,REDIAGONAL;
}
