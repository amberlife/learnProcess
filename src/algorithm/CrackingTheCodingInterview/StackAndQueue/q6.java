package algorithm.CrackingTheCodingInterview.StackAndQueue;

import java.util.Stack;

/**
 * Write a program to sort a stack in ascending order. 
 * You should not make any assumptions about how the stack is implemented. 
 * The following are the only functions that should be used to write this program: push | pop | peek | isEmpty.
 * 
 * ��ջ�ڵ�Ԫ�ؽ�����������ֻ��ʹ��push��pop,peek,isEmpty�⼸������
 * 
 * ˼����
 * ��������⣬����ջ�Ĳ���ֻ����ջ�����У�������һ��ֻ��ͨ���Ƚϻ��߹�ϣ���ַ�ʽ��ʵ�֡����ԣ���Ȼ����Ҫ����Ŀռ�ġ�
 * 
 * method1������ʹ�ö����ջ�����С�
 * ��ԭջΪs,�����ջΪt��
 * initial: 
 * s={ջ��...ջ��}={3,2,6,5,4,1} t={...}
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
 * ͨ���������̵���ʾ�����Ժ����׵��ܽ���㷨��
 * ����tջ��Ϊ�գ�����ֱ�ӽ�sջ��Ԫ�ص�����ѹ��tջ����
 * ���sջ��Ԫ��ͬtջ��Ԫ�ؽ��бȽϣ����sջ��Ԫ��k������tջ��Ԫ����ѹ��ջt�У��������ε���tջ��Ԫ�أ�����ջs�У�ֱ��Ԫ��k������tջ��Ԫ��
 * ѭ�����м���
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
