package algorithm.CrackingTheCodingInterview.Recursion;

/**
 *Write an algorithm to print all ways of arranging eight queens on a chess board 
 *so that none of them share the same row, column or diagonal.
 *
 *�˻ʺ�����
 *�˻ʺ�����Ľⷨ�����û��ݷ������ϵ���ÿһ�з���һ���ʺ󣬽�������������ĳһ�е�����һ�з��ûʺ����������Ҫ������
 *���½��������������л��ݣ����ݵ������п��Է��ûʺ��һ�У������½���������֪�����������һ�У��ҵ����н⣬�����
 *
 */
public class q8 {
	public int[][] m = new int[8][8];//����
	public int num=1;//�������
	
	boolean check(int row,int col){
		if(row==0){
			return true;
		}
		// �м��
		for (int i = 0; i < row; i++) {
			if (m[i][col] == 1)
				return false;
		}
		//���������ϼ��
		int i=row-1;
		int j=col-1;
		while(i>=0&&j>=0){
			if(m[i][j]==1) return false;
			i--;
			j--;
		}
		
		//���������ϼ��
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
			//������һ���з��ûʺ�
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
			//�ѳ��Թ����У�������������
			m[row-1][i]=0;
		}
	}
	public static void main(String[] args) {
		q8 queen8 = new q8();
		queen8.queen8(1);
	}
}
