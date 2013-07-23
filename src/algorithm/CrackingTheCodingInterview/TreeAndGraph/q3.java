package algorithm.CrackingTheCodingInterview.TreeAndGraph;

/**
 *question3:
 *Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
 *给定一个有序数组(递增)，写程序构建一棵具有最小高度的二叉树。
 *
 *简单题目，考虑平衡二叉树的概念。
 *选取有序数组的中间元素作为根节点，根节点的左子树上的元素都小于根，右子树的元素都大于根
 *
 */
public class q3 {
	public static void buildMinHeightBTree(Node parent,int[] arr,int start,int end){
		if(start<=end){
			int mid= (start+end)>>1;
			Node t = new Node();
			t.value = arr[mid];
			t.parent = parent;
			if(parent.value>t.value){
				parent.left = t;
			}else{
				parent.right = t;
			}
			buildMinHeightBTree(t,arr,start,mid-1);
			buildMinHeightBTree(t,arr,mid+1,end);
		}
	}
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,4,5,6,7,8};
		Node root = new Node();
		root.value = 5;
		buildMinHeightBTree(root,arr,0,2);
		buildMinHeightBTree(root,arr,4,6);
		System.out.println(Node.printTree(root));
	}
}
