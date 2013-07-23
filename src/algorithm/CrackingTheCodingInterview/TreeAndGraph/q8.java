package algorithm.CrackingTheCodingInterview.TreeAndGraph;

import java.util.Stack;

/**
 *You are given a binary tree in which each node contains a value. 
 *Design an algorithm to print all paths which sum up to that value. 
 *Note that it can be any path in the tree �C it does not have to start at the root.
 *
 *����а���ָ���׽���ָ�룬��ô��ֻ��Ҫȥ������ö������� Ȼ���ÿ����㿪ʼ�����ϵ�ȥ�ۼ��������׽���ֱֵ�����׽��Ϊ��
 *(�������Ψһ�ԣ� ��Ϊÿ����㶼ֻ��һ�����׽�㡣Ҳ����Ϊ���Ψһ�ԣ� ���Բ����⿪����Ŀռ�������·��)��������ڸ�����ֵsum�����ӡ�����
 */
public class q8 {
	public static void findSum(Node head,int sum){
		if(head==null) return ;
		Node no = head;
		int tmp = 0;
		for(int i=1;no!=null;i++){
			tmp +=no.value;
			if(tmp==sum)
				print(head,i);
			no = no.parent;
		}
		findSum(head.left,sum);
		findSum(head.right,sum);
	}
	static void print(Node node ,int level){
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<level;i++){
			s.push(node.value);
			node = node.parent;
		}
		while(s.size()>0){
			System.out.print(s.pop()+" ");
		}
	}
	
	public static void main(String[] args) {
		int[]  arr={5,1,3,8,6,10};
		Node root = Node.createBinaryTree(arr);
		findSum(root,23);
	}
}
