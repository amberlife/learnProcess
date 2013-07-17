package algorithm.CrackingTheCodingInterview.LinkedList;

/**
 * question5��
 * Given a circular linked list, 
 * implement an algorithm which returns node at the beginning of the loop.
 * ����һ��ѭ������ʵ��һ���㷨����������Ŀ�ʼ��㡣
 * ���壺
 * ѭ������������һ������ָ��ָ����ǰ�Ѿ����ֵĽ�㣬���������г��ֻ���
 * ���ӣ�
 * ���룺A �C> B �C> C �C> D �C> E �C> C [���C��֮ǰ�Ѿ����ֹ�]
 * ��������C
 * 
 * 
 * ˼·�������Ŀ�ǵ��͵�floyd��Ȧ�㷨(���������㷨)
 * ���㷨���Լ��һ�������Ƿ��л�������У����ȷ���������
 * ���ýⷨ��˼�룺�������ܲ���˼�������ͣ�����ܵ����л�����ô���һ�������ܹ�׷������һ����
 * ��һ���룬׷��ʱ�����һ��һ��������һ�������˼�Ȧ�������ܵļ�Ȧ��Ϊ�ܵ��ĳ��ȵı���
 * ��������˼�룬floyd������ָ�룬һ����ָ��(��)ÿ��ǰ��һ����һ����ָ��(��)ÿ��ǰ������(�������߶ಽ
 * �ǵȼ۵�)���������ָ��������ͷ�����һ���ڵ���������ô˵�������л�������û����
 * ���������������ȷ��������㣬��Ҳ��floyd�ⷨ�ĵڶ����֡������ǽ���ָ���ƶ���������㣬��ָ��ԭ�ز�����
 * ��󣬶���ͬʱ�ƶ���һ���ƶ�һ�������������ĵط�����Ϊ������㡣
 * �������ȷ����������֤����
 * 
 * �����������㵽����������Ϊm���Ѿ�ȷ���л����ڣ������ܳ���n����һ�ο���ָ���������뻷�����ľ�����k����ô��
 * �����ٴ�������ʱ����ָ���ƶ��ľ���Ϊi��
 * i=m+a*n+k,
 * ��Ϊ��ָ���ƶ��ٶ�����ָ�����������ô��ָ���ƶ�������2i��
 * 2i=m+b*n+k��
 * ����a��b��ʾ����ָ���ڻ��ڵ�һ��������ת����Ȧ����
 * �������
 * 2i-i=(b-a)*n
 * ����iΪȦ���ȵ�(b-a)��������������ۣ����ǿ���ȷ��Ϊʲôfloyd�㷨�ܹ�ȷ��������㡣
 * ��һ��ָ���ƶ���������㣬����һ��ָ�벻�䣬�������������Ϊi��������ͬʱ�ƶ���ÿ���ƶ�һ����
 * ����һ��ָ���ƶ���m������һ��ָ������������Ϊi+m����iΪȦ���ȵı������������Ϊָ�������������
 * Ȼ���ƻ���Ȧ�����Եڶ���ָ���Ȼ�ڻ�����㴦�����Զ��������ĵط������ǻ�����㡣
 * 
 *
 */
public class q5 {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7};
		Node head=null,p=null,cycleStartPoint = null;
		
		//����һ������������
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
		
		//��⻷·
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
			//���㻷·����
			int len = 0 ;
			hare = hare.next;
			len = 1; 
			while(hare!=tortoise){
				hare = hare.next;
				len++;
			}
			System.out.println("cycle linked list length :"+len);
			
			//���㻷·���
			tortoise = head;
			while(hare!=tortoise){
				tortoise=tortoise.next;
				hare = hare.next;
			}
			System.out.println("cycle linked list start point :"+hare.value);
			
		}
		
	}
	
	
		
	//ǰ���Ĳ���
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
