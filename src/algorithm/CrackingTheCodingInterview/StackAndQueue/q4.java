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
 *用栈来解决汉诺塔问题，而不是递归
 *将n个圆盘从柱子src移动到柱子dst，可以借助中间柱子bri
 *移动的过程中，不允许大圆盘放在小圆盘的上面
 *
 *先考虑递归版本：
 *递归函数:hanoi(n,src,bri,dst)表示将n个圆盘从src柱子借助bri柱子移动到dst柱子
 *原始状态
 *(src上的圆盘，bri上的圆盘,dst上的圆盘)=(1~n,0,0)
 *中间状态
 *(src上的圆盘，bri上的圆盘，dst上的圆盘)=(n,1~n-1,0)
 *最终状态
 *(src上的圆盘，bir上的圆盘，dst上的圆盘)=(0,0,1~n)
 *
 *创始状态到中间状态使用操作hanoi(n-1,src,dst,bri).
 *接下来将圆盘n从src移动到dst
 *这个操作之后的状态是(0,1~n-1,n)
 *在利用hanoi将n-1个圆盘从bri移动到dst，中间可以借助src柱子:hanoi(n-1,bri,src,dst)
 *最终得到最终状态：（0,0,1~n)
 *递归的终止条件为当n=1的时候，即只有一个圆盘，直接从src移动到dst
 *
 *
 *考虑非递归版本
 *任何递归程序，从本质上而言，都可以转化成为非递归程序，利用栈来模拟系统的栈的操作即可
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
					//入栈顺序和实际操作顺序相反，因为是在出栈的时候才进行处理
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
