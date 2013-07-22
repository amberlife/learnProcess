package algorithm.CrackingTheCodingInterview.StackAndQueue;

import java.util.Stack;

/**
 * Write a program to sort a stack in ascending order. 
 * You should not make any assumptions about how the stack is implemented. 
 * The following are the only functions that should be used to write this program: push | pop | peek | isEmpty.
 * 
 * 将栈内的元素进行升序排序，只能使用push，pop,peek,isEmpty这几个函数
 * 
 * 思考：
 * 看到这道题，由于栈的操作只能在栈顶进行，而排序一般只能通过比较或者哈希两种方式来实现。所以，必然是需要额外的空间的。
 * 
 * method1：考虑使用额外的栈来进行。
 * 设原栈为s,额外的栈为t。
 * initial: 
 * s={栈底...栈顶}={3,2,6,5,4,1} t={...}
 * s={3,2,6,5,4} t={1}
 * s={3,2,6,5} t={1,4}
 * s={3,2,6} t={1,4,5}
 * s={3,2} t={1,4,5,6}
 * s={3,6,5,4},t={1,2}
 * s={3,6,5} t={1,2,4}
 * s={3,6} t={1,2,4,5}
 * s={3} t={1,2,4,5,6}
 * s={6,5,4} t={1,2,3}
 * s={6,5} t={1,2,3,4}
 * s={6} t={1,2,3,4,5}
 * s={} t={1,2,3,4,6,6}
 * 通过上述过程的演示，可以很容易的总结出算法。
 * 首先t栈内为空，所以直接将s栈顶元素弹出并压入t栈即可
 * 随后将s栈顶元素同t栈顶元素进行比较，如果s栈顶元素k，大于t栈顶元素则压入栈t中，否则依次弹出t栈顶元素，加入栈s中，直到元素k不大于t栈顶元素
 * 循环进行即可
 */
public class q6 {
	Stack<Integer> s ;
	public q6(){
		this.s = new Stack<Integer>();
	}
	public Stack<Integer> ascendStack(){
		Stack<Integer> t = new Stack<Integer>();
		while(s.size()>0){
			int item = s.pop();
			if(!t.isEmpty()&&t.peek()>item){
				s.push(t.pop());
			}
			t.push(item);
		}
		return t;
	}
	public void push(int v){
		this.s.push(v);
	}
	public static void main(String[] args) {
		q6 stack = new q6();
		stack.push(3);
		stack.push(2);
		stack.push(6);
		stack.push(5);
		stack.push(4);
		stack.push(1);
		Stack<Integer> t = stack.ascendStack();
		while(t.size()>0){
			System.out.println(t.pop());
		}
	}
}
