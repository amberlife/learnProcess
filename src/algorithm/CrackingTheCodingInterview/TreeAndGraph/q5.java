package algorithm.CrackingTheCodingInterview.TreeAndGraph;

/**
 * question5：
 * 给定二叉查找树的一个结点， 写一个算法查找它的“下一个”结点(即中序遍历后它的后继结点)， 其中每个结点都有指向其父亲的链接。
 * 
 * 数据结构课本题目的了。寻找后继节点。对于二叉树的题目，分析清楚各种结构下的问题，题目也就清楚了。比如红黑树的添加后的调整，删除后的调整，只需要
 * 把添加节点在各种位置(左子树，右子树，左子树的孩子，右子树的孩子等)讨论清楚了，问题就可以解决了。
 * 如果该节点存在右子树，则后继为该节点右子树的最左子树节点。
 * 如果该节点 不包含右子树，如果该节点为其父亲的左孩子，则直接返回其父节点。如果该节点为其父亲的右孩子，则不断寻找父节点的父节点，直到找到一个比他大的父节点为止
 */
public class q5 {
	//寻找后继节点
	public static Node successor(Node node){
		if(node==null) return null;
		if(node.right!=null){
			Node n = node.right;
			while(n.left!=null){
				n=n.left;
			}
			return n; 
		}else{
			Node p=node.parent;
			while(p!=null&&p.right==node){
				node=p;
				p=p.parent;
			}
			return p;
		}
	}
	
	public static void main(String[] args) {
		int[]  arr={5,1,3,8,6,10};
		Node root = Node.createBinaryTree(arr);
		Node t = root.right.left;
		Node n= successor(t);
		System.out.println(n.value);
	}

	
}
