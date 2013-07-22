package algorithm.CrackingTheCodingInterview.StackAndQueue;

import java.util.Stack;

/**
 *In the classic problem of the Towers of Hanoi, 
 *you have 3 rods and N disks of different sizes which can slide onto any tower. 
 *The puzzle starts with disks sorted in ascending order of size from top to bottom 
 *(e.g., each disk sits on top of an even larger one). You have the following constraints:
 *
 * only one disk can be moved at a time
 * A disk is slid off the top of one rod onto the next rod
 * A disk can only be placed on top of a larger disk
 * 
 *��ջ�������ŵ�����⣬�����ǵݹ�
 *��n��Բ�̴�����src�ƶ�������dst�����Խ����м�����bri
 *�ƶ��Ĺ����У��������Բ�̷���СԲ�̵�����
 *
 *�ȿ��ǵݹ�汾��
 *�ݹ麯��:hanoi(n,src,bri,dst)��ʾ��n��Բ�̴�src���ӽ���bri�����ƶ���dst����
 *ԭʼ״̬
 *(src�ϵ�Բ�̣�bri�ϵ�Բ��,dst�ϵ�Բ��)=(1~n,0,0)
 *�м�״̬
 *(src�ϵ�Բ�̣�bri�ϵ�Բ�̣�dst�ϵ�Բ��)=(n,1~n-1,0)
 *����״̬
 *(src�ϵ�Բ�̣�bir�ϵ�Բ�̣�dst�ϵ�Բ��)=(0,0,1~n)
 *
 *��ʼ״̬���м�״̬ʹ�ò���hanoi(n-1,src,dst,bri).
 *��������Բ��n��src�ƶ���dst
 *�������֮���״̬��(0,1~n-1,n)
 *������hanoi��n-1��Բ�̴�bri�ƶ���dst���м���Խ���src����:hanoi(n-1,bri,src,dst)
 *���յõ�����״̬����0,0,1~n)
 *�ݹ����ֹ����Ϊ��n=1��ʱ�򣬼�ֻ��һ��Բ�̣�ֱ�Ӵ�src�ƶ���dst
 *
 *
 *���Ƿǵݹ�汾
 *�κεݹ���򣬴ӱ����϶��ԣ�������ת����Ϊ�ǵݹ��������ջ��ģ��ϵͳ��ջ�Ĳ�������
 */
public class q4 {
		//recursive version 
		public static void recursiveHanoi(int n , String src,String bri,String dst){
			if(n==1){
				System.out.println("move disk "+n+" from "+src+" to "+dst);
			}else{
				recursiveHanoi(n-1,src,dst,bri);
				System.out.println("move disk "+n+" from "+src+" to "+dst);
				recursiveHanoi(n-1,bri,src,dst);
			}
		}
		
		//non-recursive version  
		//use stack
		public static void nonRecursiveHanoi(int n ,String src,String bri,String dst){
			Stack<op> st = new Stack<op>();
			op tmp ;
			st.push(new op(1,n ,src,bri,dst));
			while(!st.empty()){
				tmp = st.pop();
				if(tmp.begin!=tmp.end){
					//��ջ˳���ʵ�ʲ���˳���෴����Ϊ���ڳ�ջ��ʱ��Ž��д���
					st.push(new op(tmp.begin,tmp.end-1,tmp.bri,tmp.src,tmp.dst));
					st.push(new op(tmp.end,tmp.end,tmp.src,tmp.bri,tmp.dst));
					st.push(new op(tmp.begin,tmp.end-1,tmp.src,tmp.dst,tmp.bri));
				}else{
					System.out.println("move dist "+tmp.begin+" from "+tmp.src+" to "+tmp.dst);
				}
			}
		}
		
		public static void main(String[] args) {
			recursiveHanoi(6,"source","bridge","destination");
			System.out.println();
			nonRecursiveHanoi(6,"source","bridge","destination");
			
		}
}

class op {
	int begin;
	int end;
	String src,bri,dst;
	op(){}
	op(int pbegin,int pend,String psrc,String pbri,String pdst){
		this.begin = pbegin;
		this.end = pend;
		this.src = psrc;
		this.bri = pbri;
		this.dst = pdst;
	}
}
