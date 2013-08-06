package algorithm.CrackingTheCodingInterview.Moderate;

/**
 * question2 
 * Design an algorithm to figure out if someone has won in a game of tic-tac-toe.
 * ���һ���㷨�����ĳ���Ƿ�Ӯ���˾�����Ϸ
 * 
 * ������Ϸ����һ����3*3�����Ͻ��е�������Ϸ����������Ƚ����ƣ���������һ�㲻���߿򣬸����ųɾ��ֹʵ�����
 * ��Ϸ��Ҫ�Ĺ��߽�Ϊֽ�ͱʣ�Ȼ���ɷֱ����O��X��������Ϸ�������ڸ��������±�ǣ�һ����˵������ΪX��
 * 
 * ������Ϸ�淨�򵥣�һ��9�����ӣ�ÿ�������漰����״̬: ��,O,X������һ����3^9��״̬�������ĿҲ���Ǻܴ�
 * ������Ϸ��Ҫ���ٽ��ģ����Խ����гɹ�����оٳ�����Ȼ��ֱ���жϾͺ��ˡ�
 * ���о���д�����жϵ�ǰ״̬�Ƿ�ΪӮ״̬��
 * 
 * 0��ʾδ�����ӣ�1��ʾ�ҷ��µ����ӣ�2��ʾ�Է��µ����ӡ����Խ������һ��״̬(9������)��ʾ��Ϊһ��3��������Ȼ����ת��
 * ��1���������д洢�����ֱ���жϼ��ɡ�
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
