package algorithm.CrackingTheCodingInterview.TreeAndGraph;

import java.util.HashMap;
import java.util.HashSet;

/**
 *question7��
 *You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. 
 *Create an algorithm to decide if T2 is a subtree of T1
 *�����úܴ�Ķ�������T1���ϰ������㣬T2���ϰٸ���㡣д�����ж�T2�Ƿ�ΪT1��������
 *
 *˼����������ֻ�бȽϺ�hash�����ַ�ʽ��
 *1����������
 *2��T1,T2�е�ÿ���ڵ�����һ��hashֵ��hashֵ�ɵ�ǰ�ڵ������������ͬ����
 *3����֪��һ��������ͨ��ǰ����������ȷ������ô���Ƕ�T1��T2����ǰ�����������������������£�T2�������ַ�������T1�������ַ������Ӵ��������Ψһȷ��
 */
public class q7 {
	//�Զ�����ÿ���ڵ�����һ��hashֵ��
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
	
	//��������ǰ�������������ɵ��ַ����������ַ���ƥ��
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


