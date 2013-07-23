package algorithm.CrackingTheCodingInterview.TreeAndGraph;

import java.util.Stack;

/**
 *You are given a binary tree in which each node contains a value. 
 *Design an algorithm to print all paths which sum up to that value. 
 *Note that it can be any path in the tree – it does not have to start at the root.
 *
 *结点中包含指向父亲结点的指针，那么，只需要去遍历这棵二叉树， 然后从每个结点开始，不断地去累加上它父亲结点的值直到父亲结点为空
 *(这个具有唯一性， 因为每个结点都只有一个父亲结点。也正因为这个唯一性， 可以不另外开额外的空间来保存路径)，如果等于给定的值sum，则打印输出。
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
