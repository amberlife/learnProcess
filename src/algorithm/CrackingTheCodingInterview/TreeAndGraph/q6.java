package algorithm.CrackingTheCodingInterview.TreeAndGraph;

import java.util.HashSet;

/**
 * question6:
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
 * Avoid storing additional nodes in a data structure.NOTE: This is not necessarily a binary search tree.
 *
 *写程序在一棵二叉树中找到两个结点的第一个共同祖先。不允许存储额外的结点。注意： 这里不特指二叉查找树。
 *method1：
 *看到这个题目，最简单的方式就是对于一个结点向父节点进行遍历，直至根结点。可以考虑存储为hash，然后对另一个结点向父节点进行遍历，同时和第一个结点的父节点
 *所组成的hash集合进行比较，第一个相同的结点即为二者的共同祖先。
 *method2：
 *如果不能使用额外的存储空间，则只能是不断的取一个节点的父节点，然后同另外一个节点的所有父节点进行比较，直到根节点。
 *method3:
 *如果节点没有父指针，那么则需要从根节点开始遍历，依次判断每个节点，是否可以到达问题中的两个节点。找到最后一个这样的节点，即可。
 *
 *
 */
public class q6 {
	public static Node ancestor;
	//使用额外的hashset进行存储
	public static Node method1(Node n1,Node n2){
		if(n1==null||n2==null) return null;
		HashSet<Node> set = new HashSet<Node>();
		while(n1.parent!=null){
			set.add(n1);
			n1=n1.parent;
		}
		while(n2.parent!=null){
			if(set.contains(n2))
				return n2;
			n2=n2.parent;
		}
		return null;
	}
	//不使用额外的空间
	public static Node method2(Node n1,Node n2){
		if(n1==null||n2==null) return null;
		for(Node p=n1;p!=null;p=p.parent){
			Node q = n2;
			while(q.parent!=null){
				if(q==p)
					return q;
				q=q.parent;
			}
		}
	
		return null;
	}
	
	//不存在父指针的节点
	//ancestor会不断更新，直到最后一个共同的祖先
	public static void method3(Node n1,Node n2,Node head){
		if(head==null||n1==null||n2==null) return ;
		if(head!=null&&father(head,n1)&&father(head,n2)){
			ancestor = head;
			method3(n1,n2,head.left);
			method3(n1,n2,head.right);
		}
	}
	private static boolean father(Node head,Node node){
		if(head==null) return false;
		else if(head==node) return true;
		else return father(head.right,node)||father(head.left,node);
	}
	
	public static void main(String[] args) {
		int[]  arr={5,1,3,8,6,10};
		Node root = Node.createBinaryTree(arr);
		Node n1 = root.right.left;
		Node n2 = root.right.right;
		System.out.println(method1(n1,n2).value);
		System.out.println(method2(n1,n2).value);
		
		method3(n1,n2,root);
		System.out.println(ancestor.value);
	}
}
