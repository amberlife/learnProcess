package algorithm.CrackingTheCodingInterview.StackAndQueue;

import java.util.Date;
import java.util.Random;
import java.util.Stack;

/**
 *question 5:
 *Implement a MyQueue class which implements a queue using two stacks.
 *ʹ������ջʵ��һ������MyQueue��
 *
 *˼����
 *�������Ƚ��ȳ������ݽṹ��ջ���Ƚ���������ݽṹ��
 *������ջ��ʵ�ֶ��е���򵥷�ʽ�ǣ��������������һ��ջѹջ���������򽫵�һ��ջ����������ѹ��ڶ���ջ��Ȼ���ջ��
 *�����ݽ�����е�ʱ�򣬶��Ƚ��ڶ���ջ�е�Ԫ��ѹ���һ��ջ��Ȼ���ٽ�����ѹ���һ��ջ��
 *�����ݳ����е�ʱ�򣬶��Ƚ���һ��ջ��Ԫ��ѹ��ڶ���ջ��Ȼ�����ݴӵڶ���ջ�г�ջ
 *
 *����һ�еĳ���ջ����Ƶ����
 *���Կ���ֱ������һ��ջ��ѹ�����ݣ��ӵڶ���ջ�е������ݣ����ڶ���ջ�е�Ԫ������Ϊ0��ʱ��
 *ֱ�ӽ���һ��ջ�е�Ԫ�����ε���ѹ�뵽�ڶ���ջ�У��������ݵ������ƶ�
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
	//��ջ1
	public void enQueue(int val){
		if (stack1 == null && stack2 == null)
			return;
		while (stack2.size() > 0) {
			int item = stack2.pop();
			stack1.push(item);
		}
		stack1.push(val);
	}
	//��ջ2
	public void enQueue2(int val){
		if(stack3==null&&stack4==null)
			return;
		stack3.push(val);
	}
	
	//��ջ1
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
	
	//��ջ2
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
