package algorithm.CrackingTheCodingInterview.LinkedList;

/**
 * question5：
 * Given a circular linked list, 
 * implement an algorithm which returns node at the beginning of the loop.
 * 给定一个循环链表，实现一个算法返回这个环的开始结点。
 * 定义：
 * 循环链表：链表中一个结点的指针指向先前已经出现的结点，导致链表中出现环。
 * 例子：
 * 输入：A –> B –> C –> D –> E –> C [结点C在之前已经出现过]
 * 输出：结点C
 * 
 * 
 * 思路：这道题目是典型的floyd判圈算法(龟兔赛跑算法)
 * 该算法可以检测一个链表是否有环，如果有，如何确定环的起点
 * 龟兔解法的思想：我们用跑步的思想来解释，如果跑道上有环，那么快的一方总是能够追上慢的一方。
 * 进一步想，追上时，快的一方一定比慢的一方多跑了几圈，即多跑的几圈即为跑道的长度的倍数
 * 基于上述思想，floyd用两个指针，一个慢指针(龟)每次前进一步，一个快指针(兔)每次前进两步(两步或者多步
 * 是等价的)。如果两个指针在链表头以外的一个节点相遇，那么说明链表有环。否则，没环。
 * 接下来，讨论如何确定环的起点，这也是floyd解法的第二部分。方法是将慢指针移动到链表起点，快指针原地不动。
 * 随后，二者同时移动，一次移动一步，两者相遇的地方，即为环的起点。
 * 下面给出确定环的起点的证明：
 * 
 * 假设链表的起点到环的起点距离为m，已经确定有环存在，环的周长是n。第一次快慢指针相遇距离环的起点的距离是k。那么当
 * 二者再次相遇的时候，慢指针移动的距离为i，
 * i=m+a*n+k,
 * 因为快指针移动速度是慢指针的两倍，那么快指针移动距离是2i，
 * 2i=m+b*n+k。
 * 其中a，b表示快慢指针在环内第一次相遇后，转过的圈数。
 * 二者相减
 * 2i-i=(b-a)*n
 * 所以i为圈长度的(b-a)倍。利用这个结论，我们可以确定为什么floyd算法能够确定环的起点。
 * 将一个指针移动到链表起点，另外一个指针不变，即距离链表起点为i处，二者同时移动，每次移动一步。
 * 当第一个指针移动了m步，另一个指针距离链表起点为i+m步。i为圈长度的倍数，可以理解为指针从链表起点出发
 * 然后绕环几圈。所以第二个指针必然在环的起点处。所以二者相遇的地方，就是环的起点。
 * 
 *
 */
public class q5 {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7};
		Node head=null,p=null,cycleStartPoint = null;
		
		//制作一个带环的链表
		for(int i=0;i<arr.length;i++){
			Node t = new Node(arr[i],null);
			if(i==0){
				head=p=t;
				continue;
			}
			p.next = t;
			p=p.next;
			if(i==2){
				cycleStartPoint=t;
			}
			if(i==(arr.length-1)){
				p.next = cycleStartPoint;
			}
		}
		
		//检测环路
		boolean isCycle = false;
		Node tortoise=head,hare=head;
		while(true){
			tortoise=advance(tortoise,1);
			hare = advance(hare,2);
			if(tortoise==hare){
				isCycle=true;
				break;
			}
			if(hare==null||tortoise==null){
				isCycle=false;
				break;
			}
		}
		
		if(isCycle){
			System.out.println("exist cycle linked list");
			//计算环路长度
			int len = 0 ;
			hare = hare.next;
			len = 1; 
			while(hare!=tortoise){
				hare = hare.next;
				len++;
			}
			System.out.println("cycle linked list length :"+len);
			
			//计算环路起点
			tortoise = head;
			while(hare!=tortoise){
				tortoise=tortoise.next;
				hare = hare.next;
			}
			System.out.println("cycle linked list start point :"+hare.value);
			
		}
		
	}
	
	
		
	//前进的步数
	public static Node advance(Node current, int step){
		if(current == null) return null;
		Node p = current;
		for(int i=0;i<step;i++){
			if(p.next==null){
				return null;
			}
			p=p.next;
		}
		return p;
	}
}
