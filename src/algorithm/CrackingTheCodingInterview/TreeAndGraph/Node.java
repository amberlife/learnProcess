package algorithm.CrackingTheCodingInterview.TreeAndGraph;

public class Node {
	int value;
	Node left;
	Node right;
	Node parent;
	
	public static  void insert(Node node ,int x,Node p){
		if(node==null){
			node = new Node();
			node.value = x;
			node.left = null;
			node.right = null;
			if(p.value>x)
				p.left=node;
			else
				p.right=node;
			node.parent = p;
			return;
		}
		
		
		if(x<node.value){
			insert(node.left,x,node);
		}else{
			insert(node.right,x,node);
		}
	}
	
	public static Node createBinaryTree(int[] values){
		Node root = new Node();
		root.value = values[0];
		for(int i=1;i<values.length;i++){
			insert(root,values[i],root);
		}
		return root;
	}
	
}
