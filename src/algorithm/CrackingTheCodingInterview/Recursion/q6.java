package algorithm.CrackingTheCodingInterview.Recursion;

/**
 * Implement the “paint fill” function that one might see on many image editing programs. 
 * That is, given a screen (represented by a 2-dimensional array of Colors), a point, 
 * and a new color, fill in the surrounding area until you hit a border of that color.
 *
 * 实现图像处理软件中的“填充”函数，给定一块区域(可以不规则)，一个种子点和一种新颜色， 填充这块区域，
 * 直到到达这块区域的边界(边界是用这种新颜色画的一条封闭曲线)
 *
 *
 * 看到这道题目，就想到了病毒式传播 ^_^
 * 计算机图形学没怎么接触过，只知道是由点阵组成的图象。这就够了
 * 给予一个点，然后以此为中心，向上下左右四个方向调用递归函数，进行着色。遇到边界了，就停止着色。
 * 我们把问题简单化，把图片想象成全为0的矩阵，着色就表示为将某一区域的0变为1
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
