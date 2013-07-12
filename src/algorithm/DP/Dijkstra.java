package algorithm.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 经典的最短路径算法：迪杰斯特拉算法
 * 这道题思想上更多的是贪心策略。
 * 
 */
public class Dijkstra {
	static int Inf = 10000;
	public static  int[] shortestPath(int[][] graphEdge,int[] graphVertex,int source){
		
		int[] D = new int[graphVertex.length];//最短距离表
		boolean[] finals= new boolean[graphVertex.length];// finals[v]=true当且仅当v属于S，即已经求的从v0到v的最短路径
		int[][] p = new int[graphVertex.length][graphVertex.length];//p[v][w]为true，则w是从source到v当前求得最短路径上的顶点
		for(int v=0;v<graphVertex.length;v++){
			finals[v]=false;
			D[v] = graphEdge[source][v];
			/*for(int w=0;w<graphVertex.length;w++){
				p[v][w]=-1;//设置空路径
			}*/
			if(D[v]<Inf){
				p[v][source]=1;
				p[v][v]=1;
			}
		}
		
		D[source] = 0 ;
		finals[source]= true;
		int min =Inf;
		int v=0;
		
		for(int i=0;i<graphVertex.length;++i){
			min = Inf;
			//寻找到离source最近的且不属于S（finals[w]==false)的顶点
			for(int w=0;w<graphVertex.length;++w){
				if(!finals[w])
					if(D[w]<min){
						v=w;
						min = D[w];
					}
			}
			finals[v]=true;//离source顶点最近的v加入S集合
			
			//更新当前最短路径及距离
			for(int w=0;w<graphVertex.length;w++){
				if(!finals[w]&&(min+graphEdge[v][w])<D[w]){
					D[w]=min+graphEdge[v][w];
					p[w]=p[v];
					p[w][w]=1;
				}
			}
		}
		
		return D;
	}
	public static void main(String[] args) {
		int[][] graphEdge = new int[][]{
				{Inf,Inf,10 ,Inf,30 ,100},
				{Inf,Inf,5  ,Inf,Inf,Inf},
				{Inf,Inf,Inf,50 ,Inf,Inf},
				{Inf,Inf,Inf,Inf,Inf,10},
				{Inf,Inf,Inf,20 ,Inf,60},
				{Inf,Inf,Inf,Inf,Inf,Inf}
		};
		int[] graphVertex = new int[]{0,1,2,3,4,5};
		int[] D = shortestPath(graphEdge,graphVertex,0);
		System.out.println(Arrays.toString(D));
	}
}
