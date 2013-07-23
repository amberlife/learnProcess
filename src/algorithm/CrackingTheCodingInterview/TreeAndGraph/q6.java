package algorithm.CrackingTheCodingInterview.TreeAndGraph;

import java.util.HashSet;

/**
 * question6:
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
 * Avoid storing additional nodes in a data structure.NOTE: This is not necessarily a binary search tree.
 *
 *д������һ�ö��������ҵ��������ĵ�һ����ͬ���ȡ�������洢����Ľ�㡣ע�⣺ ���ﲻ��ָ�����������
 *method1��
 *���������Ŀ����򵥵ķ�ʽ���Ƕ���һ������򸸽ڵ���б�����ֱ������㡣���Կ��Ǵ洢Ϊhash��Ȼ�����һ������򸸽ڵ���б�����ͬʱ�͵�һ�����ĸ��ڵ�
 *����ɵ�hash���Ͻ��бȽϣ���һ����ͬ�Ľ�㼴Ϊ���ߵĹ�ͬ���ȡ�
 *method2��
 *�������ʹ�ö���Ĵ洢�ռ䣬��ֻ���ǲ��ϵ�ȡһ���ڵ�ĸ��ڵ㣬Ȼ��ͬ����һ���ڵ�����и��ڵ���бȽϣ�ֱ�����ڵ㡣
 *method3:
 *����ڵ�û�и�ָ�룬��ô����Ҫ�Ӹ��ڵ㿪ʼ�����������ж�ÿ���ڵ㣬�Ƿ���Ե��������е������ڵ㡣�ҵ����һ�������Ľڵ㣬���ɡ�
 *
 *
 */
public class q6 {
	public static Node ancestor;
	//ʹ�ö����hashset���д洢
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
	//��ʹ�ö���Ŀռ�
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
	
	//�����ڸ�ָ��Ľڵ�
	//ancestor�᲻�ϸ��£�ֱ�����һ����ͬ������
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
