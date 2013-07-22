package algorithm.CrackingTheCodingInterview.StackAndQueue;

import java.util.Date;
import java.util.Random;
import java.util.Stack;

/**
 *question 5:
 *Implement a MyQueue class which implements a queue using two stacks.
 *使用两个栈实现一个队列MyQueue。
 *
 *思考：
 *队列是先进先出的数据结构，栈是先进后出的数据结构，
 *用两个栈来实现队列的最简单方式是：进入队列则往第一个栈压栈，出队列则将第一个栈的数据依次压入第二个栈，然后出栈。
 *有数据进入队列的时候，都先将第二个栈中的元素压入第一个栈，然后再将数据压入第一个栈。
 *有数据出队列的时候，都先将第一个栈的元素压入第二个栈，然后将数据从第二个栈中出栈
 *
 *方法一中的出入栈过于频繁，
 *可以考虑直接往第一个栈中压入数据，从第二个栈中弹出数据，当第二个栈中的元素数量为0的时候
 *直接将第一个栈中的元素依次弹出压入到第二个栈中，减少数据的来回移动
 *
 */



public class q5 {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	Stack<Integer> stack3;
	Stack<Integer> stack4;
	public q5(){
		this.stack1 = new Stack<Integer>();
		this.stack2 = new Stack<Integer>();
		this.stack3 = new Stack<Integer>();
		this.stack4 = new Stack<Integer>(); 
	}
	public q5(Stack<Integer> stack1,Stack<Integer> stack2,Stack<Integer> stack3,Stack<Integer> stack4){
		this.stack1 = stack1;
		this.stack2 = stack2;
		this.stack3 = stack3;
		this.stack4 = stack4;
	}
	//入栈1
	public void enQueue(int val){
		if (stack1 == null && stack2 == null)
			return;
		while (stack2.size() > 0) {
			int item = stack2.pop();
			stack1.push(item);
		}
		stack1.push(val);
	}
	//入栈2
	public void enQueue2(int val){
		if(stack3==null&&stack4==null)
			return;
		stack3.push(val);
	}
	
	//出栈1
	public Integer deQueue(){
		if(stack1==null&&stack2==null) 
			return null;
		while(stack1.size()>0){
			int item = stack1.pop();
			stack2.push(item);
		}
		if(stack2.size()>0)
			return stack2.pop();
		else
			return null;
	}
	
	//出栈2
	public Integer deQueue2(){
		if(stack3==null&&stack4==null) 
			return null;
		if(stack4.size()>0)
			return stack4.pop();
		else{
			while(stack3.size()>0){
				stack4.push(stack3.pop());
			}
			return stack4.pop();
		}
	}
	
	public static void main(String[] args) {
		q5 queue = new q5();
		Random rand = new Random();
		
		for(int i=0;i<1000000;i++){
			int item = rand.nextInt(1000);
			queue.enQueue(item);
			queue.enQueue2(item);
		}
		Date time1 = new Date();
		for(int i=0;i<1000000;i++){
			queue.deQueue();
			//System.out.println();
		}
		Date time2 = new Date();
		for(int i=0;i<1000;i++){
			queue.deQueue2();
			
		}
		Date time3 = new Date();
		System.out.println(time2.getTime()-time1.getTime());
		System.out.println(time3.getTime()-time2.getTime());
	}
}
