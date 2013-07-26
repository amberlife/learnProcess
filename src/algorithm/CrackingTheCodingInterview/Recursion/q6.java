package algorithm.CrackingTheCodingInterview.Recursion;

/**
 * Implement the ��paint fill�� function that one might see on many image editing programs. 
 * That is, given a screen (represented by a 2-dimensional array of Colors), a point, 
 * and a new color, fill in the surrounding area until you hit a border of that color.
 *
 * ʵ��ͼ��������еġ���䡱����������һ������(���Բ�����)��һ�����ӵ��һ������ɫ�� ����������
 * ֱ�������������ı߽�(�߽�������������ɫ����һ���������)
 *
 *
 * ���������Ŀ�����뵽�˲���ʽ���� ^_^
 * �����ͼ��ѧû��ô�Ӵ�����ֻ֪�����ɵ�����ɵ�ͼ����͹���
 * ����һ���㣬Ȼ���Դ�Ϊ���ģ������������ĸ�������õݹ麯����������ɫ�������߽��ˣ���ֹͣ��ɫ��
 * ���ǰ�����򵥻�����ͼƬ�����ȫΪ0�ľ�����ɫ�ͱ�ʾΪ��ĳһ�����0��Ϊ1
 */

public class q6 {
	public static int[][] picture=new int[9][9];
	public static int[] borderLeftUpCorner = new int[]{1,2};
	public static int[] borderRightDownCorner=new int[]{6,6};
	public static void paint(int x,int y){
		if(x<0||x>picture.length||y<0||y>picture[0].length)
			return;
	
		
		if(x>=borderLeftUpCorner[0]&&x<=borderRightDownCorner[0]
		  &&y>=borderLeftUpCorner[1]&&y<=borderRightDownCorner[1]){
			if(picture[x][y]==0){
				picture[x][y]=1;
				paint(x+1,y);
				paint(x-1,y);
				paint(x,y+1);
				paint(x,y-1);
			}
		
		}
	
	}
	public static void main(String[] args) {
		
		int x=3,y=4;
		
		paint(x,y);
		for(int i=0;i<picture.length;i++){
			for(int j=0;j<picture[0].length;j++){
				System.out.print(picture[i][j]);
			}
			System.out.println();
		}
	}
}
