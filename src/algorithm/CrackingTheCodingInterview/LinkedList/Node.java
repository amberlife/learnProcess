package algorithm.CrackingTheCodingInterview.LinkedList;

public class Node {
	int value;
	Node next;
	public Node(){
		
	}
	public Node(int value ,Node next){
		this.value = value;
		this.next = next;
	}
	
	public String toString(){
		return Integer.toString(this.value);
	}
	
	public static Node initList(int[] arr){
		Node head=null,p=null;
		for(int i=0;i<arr.length;i++){
			Node nd = new Node(arr[i],null);
			if(i==0){
				head=p=nd;
				continue;
			}
			p.next = nd;
			p=p.next;
		}
		return head;
	}
	public static void outputList(Node head){
		if(head==null) return;
		Node p =head;
		while(p!=null){
			if(p.next!=null){
				System.out.printf("%d->",p.value);
			}else{
				System.out.printf("%d",p.value);
			}
		}
	}
}
