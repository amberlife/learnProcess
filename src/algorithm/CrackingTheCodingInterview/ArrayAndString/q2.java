package algorithm.CrackingTheCodingInterview.ArrayAndString;
/**
 * question 2
 * Write code to reverse a C-Style String. 
 * (C-String means that “abcd” is represented as five characters,
 * including the null character.)
 * 写代码翻转一个C风格的字符串。(C风格的意思是"abcd"需要用5个字符来表示，包含末尾的 结束字符)
 * 
 * 考虑：
 * 字符串是如何存储的，是利用数组存储，还是利用链表来存储？
 * 如果字符串是用数组存储，对于c语言，因为不像java，对数组存储了长度，所以，需要首先遍历到数组的末尾(遇到'\0'字符),找到末尾字符后，
 * 然后交换头尾字符。
 * 
 * 如果字符串是用含有头结点的链表存储(可能性基本没有，这里只是为了尝试头插法，来翻转字符串)，遇到'\0'就结束了。
 * 
 * method1:用数组存储
 * method2:用链表存储
 */
public class q2 {	

	//数组转换
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
	//带头结点的链表。
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
	//初始化链表
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
