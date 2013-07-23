package algorithm.CrackingTheCodingInterview.TreeAndGraph;

import java.util.Iterator;
import java.util.LinkedList;


/**
 *Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
 *(i.e., if you have a tree with depth D, you��ll have D linked lists).
 *����һ�ö��������������㷨����ÿһ������н�㹹��Ϊһ������(Ҳ����˵�� �������D�㣬��ô�㽫������D������)
 *
 *�������ǹ���BFS,����һЩ�������������
 */
public class q4 {
	public static LinkedList<LinkedList<Node>> buildLevelList(Node head){
		LinkedList<LinkedList<Node>> result = new LinkedList<LinkedList<Node>>();
		LinkedList<Node> ls = new LinkedList<Node>();
		ls.add(head);
		result.add(ls);
		int level = 0 ;
		while(result.get(level).size()>0){
			LinkedList<Node> l = result.get(level);
			Iterator<Node> iterator= l.iterator();
			LinkedList<Node> ll = new LinkedList<Node>();
			while(iterator.hasNext()){
				Node node = iterator.next();
				if(node.left!=null){
					ll.add(node.left);
				}
				if(node.right!=null){
					ll.add(node.right);
				}
			}
			result.add(ll);
			level++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{6,7,1,2,5,8,9,3,4};
		Node root = Node.createBinaryTree(arr);
		LinkedList<LinkedList<Node>>  t = buildLevelList(root);
		for(LinkedList<Node> outEntry:t){
			for(Node node:outEntry){
				System.out.print(node.value+" ");
			}
			System.out.println();
		}
	}
}
