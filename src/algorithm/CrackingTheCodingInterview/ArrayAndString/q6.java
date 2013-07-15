package algorithm.CrackingTheCodingInterview.ArrayAndString;

/**
 *Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
 *write a method to rotate the image by 90 degrees.
 *Can you do this in place?
 *һ��ͼ���ʾ��NxN�ľ���ͼ����ÿ��������4���ֽڣ�дһ��������ͼ����ת90�ȡ�
 *
 * ��������ʱ����ת90��
 *  1  2  3  4          4 8 12 16   
 *  5  6  7  8    --->  3 7 11 15
 *  9  10 11 12         2 6 10 14
 *  13 14 15 16         1 5 9  13   
 *
 *���Խ���ת���̲��Ϊ��������
 *  1  2  3  4        1 5 9  13			  4 8 12 16   
 *  5  6  7  8    --->2 6 10 14  ---->	  3 7 11 15
 *  9  10 11 12       3 7 11 15  		  2 6 10 14
 *  13 14 15 16       4 8 12 16			  1 5 9  13 
 *  �൱���Ƚ��������ת�ã�Ȼ���ڽ�����ĵ�i�к͵� N-i+1�л���λ�� 
 */
public class q6 {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{1,2,3,4},{5,6,7,8},
				{9,10,11,12},{13,14,15,16}};
		int N=4;
		
		//ת��
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				int tmp = matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=tmp;
			}
		}
		
		//����ĵ�i�к͵� N-i-1�л���λ�� 
		for(int i=0;i<N/2;i++){
			int[] tmp = matrix[i];
			matrix[i]=matrix[N-i-1];
			matrix[N-i-1]=tmp;
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.printf("%3d",matrix[i][j]);
			}
			System.out.println();
		}
		
	}
}
