package algorithm.CrackingTheCodingInterview.TreeAndGraph;

import java.util.HashMap;
import java.util.HashSet;

/**
 *question7：
 *You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. 
 *Create an algorithm to decide if T2 is a subtree of T1
 *有两棵很大的二叉树：T1有上百万个结点，T2有上百个结点。写程序判断T2是否为T1的子树。
 *
 *思考，方法上只有比较和hash这两种方式。
 *1暴力法进行
 *2对T1,T2中的每个节点生成一个hash值，hash值由当前节点和左右子树共同决定
 *3我们知道一棵树可以通过前序和中序遍历确定。那么我们对T1，T2进行前序和中序遍历。如果两种情况下，T2遍历的字符串都是T1遍历的字符串的子串，则可以唯一确定
 */
public class q7 {
	//对二叉树每个节点生成一个hash值。
	public static  boolean method2(Node t1,Node t2){
		hash(t1);
		hash(t2);
		HashSet<Integer> set = new HashSet<Integer>();
		preTraverse(t1,set);
		if(set.contains(t2.hashValue))
			return true;
		else
			return false;
	}
	static void preTraverse(Node t1,HashSet<Integer> set){
		if(t1==null) 
			return ;
		set.add(t1.hashValue);
		preTraverse(t1.left, set);
		preTraverse(t1.right,set);
		
		
	}
	private static int hash(Node node){
		if(node==null) return 0;
		if(node.left==null&&node.right==null)
			node.hashValue = node.value;
		else
			node.hashValue = 3*node.value+5*hash(node.left)+7*hash(node.right);
		return node.hashValue;
	}
	
	//利用树的前序和中序遍历生成的字符串，进行字符串匹配
	public static boolean method3(Node t1,Node t2){
		return false;
	}
	public static void main(String[] args) {
		 int[] arr1 = {5,1,3,8,6,10};
		 int[] arr2 = {8,6,10};
		 Node t1 = Node.createBinaryTree(arr1);
		 Node t2 = Node.createBinaryTree(arr2);
		System.out.println(method2(t1,t2));
		 
	}
}


