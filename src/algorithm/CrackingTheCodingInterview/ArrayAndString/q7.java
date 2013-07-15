package algorithm.CrackingTheCodingInterview.ArrayAndString;

/**
 *Write an algorithm such that if an element in an MxN matrix is 0, 
 *its entire row and column is set to 0.
 *дһ����������N*M�ľ������������ĳ��Ԫ��Ϊ0����ô�������ڵ��к��ж���Ϊ0
 *
 *˼·��
 *�����򵥣�����Ҫע�ⲻ������һ��0Ԫ�أ��ͽ������к��е�����Ԫ�ض�����Ϊ0��������������������ȫΪ0�ˡ�
 *�����Ҫ���α�������һ�α�����¼��ֵΪ0��λ�ã��ڶ��ν��������к��е�ֵ��Ϊ0
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
