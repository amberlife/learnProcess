package algorithm.CrackingTheCodingInterview.TreeAndGraph;
/**
 *question1:
 *Implement a function to check if a tree is balanced. 
 *For the purposes of this question, a balanced tree is defined to be a tree 
 *such that no two leaf nodes differ in distance from the root by more than one.
 *
 *ʵ��һ���������ܹ����һ�����Ƿ�Ϊƽ��ġ������ƽ����ָ��������Ҷ�ӽڵ㵽root�ľ��벻����1
 *
 *˼����
 *������������Ƕ�����
 *���ȸ�����������ÿ��Ҷ�ӽڵ㵽�����ľ��롣
 *���������м�¼�µ����ڵ������Ҷ�ӽڵ�͵�����ڵ���Զ��Ҷ�ӽڵ㡣
 *�Ƚ϶��ߵĲ�ֵ���ɡ�
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
