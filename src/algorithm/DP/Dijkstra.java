package algorithm.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ��������·���㷨���Ͻ�˹�����㷨
 * �����˼���ϸ������̰�Ĳ��ԡ�
 * 
 */
public class Dijkstra {
	static int Inf = 10000;
	public static  int[] shortestPath(int[][] graphEdge,int[] graphVertex,int source){
		
		int[] D = new int[graphVertex.length];//��̾����
		boolean[] finals= new boolean[graphVertex.length];// finals[v]=true���ҽ���v����S�����Ѿ���Ĵ�v0��v�����·��
		int[][] p = new int[graphVertex.length][graphVertex.length];//p[v][w]Ϊtrue����w�Ǵ�source��v��ǰ������·���ϵĶ���
		for(int v=0;v<graphVertex.length;v++){
			finals[v]=false;
			D[v] = graphEdge[source][v];
			/*for(int w=0;w<graphVertex.length;w++){
				p[v][w]=-1;//���ÿ�·��
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
			//Ѱ�ҵ���source������Ҳ�����S��finals[w]==false)�Ķ���
			for(int w=0;w<graphVertex.length;++w){
				if(!finals[w])
					if(D[w]<min){
						v=w;
						min = D[w];
					}
			}
			finals[v]=true;//��source���������v����S����
			
			//���µ�ǰ���·��������
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
