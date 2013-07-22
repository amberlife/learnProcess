package algorithm.CrackingTheCodingInterview.TreeAndGraph;
/**
 *question1:
 *Implement a function to check if a tree is balanced. 
 *For the purposes of this question, a balanced tree is defined to be a tree 
 *such that no two leaf nodes differ in distance from the root by more than one.
 *
 *实现一个函数，能够检查一个树是否为平衡的。这里的平衡是指任意两个叶子节点到root的距离不超过1
 *
 *思考：
 *这里的树，考虑二叉树
 *做先根遍历，计算每个叶子节点到根部的距离。
 *遍历过程中记录下到根节点最近的叶子节点和到达根节点最远的叶子节点。
 *比较二者的差值即可。
 *
 */
public class q1 {
	public static int num =0;
	public static int[] dep = new int[1000];
	
	public  void getDepth(Node head,int d){
		if(head==null) return;
		d++;
		if(head.right==null&&head.right==null)
			dep[num++]= d;
		getDepth(head.right,d);
		getDepth(head.left,d);
		d--;
	}
	public  boolean isBalance(Node head){
		if(head==null) return true;
		getDepth(head,0);
		int max = dep[0],min = dep[0];
		for(int i=0;i<num;i++){
			if(dep[i]>max) max = dep[i];
			if(dep[i]<min) min = dep[i];
		}
		if(max-min>1) return false;
		else return true;
	}
	public static void main(String[] args) {
		//Node tree=Node.createBinaryTree(new int[]{5,3,2,4,1,6});
		Node tree = Node.createBinaryTree(new int[]{3,2,5});
		q1 c = new q1();
	    System.out.println(c.isBalance(tree));
	}
}
