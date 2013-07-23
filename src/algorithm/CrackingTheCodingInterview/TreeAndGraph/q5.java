package algorithm.CrackingTheCodingInterview.TreeAndGraph;

/**
 * question5��
 * ���������������һ����㣬 дһ���㷨�������ġ���һ�������(��������������ĺ�̽��)�� ����ÿ����㶼��ָ���丸�׵����ӡ�
 * 
 * ���ݽṹ�α���Ŀ���ˡ�Ѱ�Һ�̽ڵ㡣���ڶ���������Ŀ������������ֽṹ�µ����⣬��ĿҲ������ˡ�������������Ӻ�ĵ�����ɾ����ĵ�����ֻ��Ҫ
 * ����ӽڵ��ڸ���λ��(�����������������������ĺ��ӣ��������ĺ��ӵ�)��������ˣ�����Ϳ��Խ���ˡ�
 * ����ýڵ����������������Ϊ�ýڵ������������������ڵ㡣
 * ����ýڵ� ������������������ýڵ�Ϊ�丸�׵����ӣ���ֱ�ӷ����丸�ڵ㡣����ýڵ�Ϊ�丸�׵��Һ��ӣ��򲻶�Ѱ�Ҹ��ڵ�ĸ��ڵ㣬ֱ���ҵ�һ��������ĸ��ڵ�Ϊֹ
 */
public class q5 {
	//Ѱ�Һ�̽ڵ�
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
