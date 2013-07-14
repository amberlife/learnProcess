package algorithm.CrackingTheCodingInterview.ArrayAndString;
/**
 * question 2
 * Write code to reverse a C-Style String. 
 * (C-String means that ��abcd�� is represented as five characters,
 * including the null character.)
 * д���뷭תһ��C�����ַ�����(C������˼��"abcd"��Ҫ��5���ַ�����ʾ������ĩβ�� �����ַ�)
 * 
 * ���ǣ�
 * �ַ�������δ洢�ģ�����������洢�����������������洢��
 * ����ַ�����������洢������c���ԣ���Ϊ����java��������洢�˳��ȣ����ԣ���Ҫ���ȱ����������ĩβ(����'\0'�ַ�),�ҵ�ĩβ�ַ���
 * Ȼ�󽻻�ͷβ�ַ���
 * 
 * ����ַ������ú���ͷ��������洢(�����Ի���û�У�����ֻ��Ϊ�˳���ͷ�巨������ת�ַ���)������'\0'�ͽ����ˡ�
 * 
 * method1:������洢
 * method2:������洢
 */
public class q2 {	

	//����ת��
	public static void method1(char[] cc){
		int  p=0,q=0;
		while(cc[q]!='\0')
			q++;
		q--;
		
		while(p<q){
			char t = cc[p];
			cc[p]=cc[q];
			cc[q]=t;
			p++;
			q--;
		}
		int count=0;
		while(cc[count]!='\0'){
			System.out.print(cc[count++]);
		}
	}
	//��ͷ��������
	public static void method2(Node cc){
		Node p = cc.next;
		if(p!=null){
			while(p.next!=null&&p.next.value!='\0'){
				Node q = p.next;
				p.next = q.next;
				Node head = cc.next;
				cc.next=q;
				q.next=head;
				//p=p.next;
			}
		}
		
		p = cc.next;
		while(p.next!=null){
			System.out.print(p.value);
			p=p.next;
		}
	}
	//��ʼ������
	public static Node initNodeList(char[] cc){
		Node c = new Node();
		c.value=0;
		if(cc==null&&cc[0]=='\0'){
			c.next = null;
			return c;
		}
		Node p  = new Node(cc[0],null);
		c.next = p;
		for(int i=1;i<cc.length;i++){
			Node q = new Node(cc[i],null);
			p.next=q;
			p=q;
		}
		return c; 
	}
	
	//test
	public static void main(String[] args) {
		char[] cc = new char[]{'a','b','c','d','e','f','\0'};
		Node  ls = initNodeList(cc);
		method1(cc);
		System.out.println();
		method2(ls);
	}
	
}
class Node {
	char value;
	Node next;
	public Node(){
		
	}
	public Node(char value,Node next){
		this.value=value;
		this.next = next;
	}
}
