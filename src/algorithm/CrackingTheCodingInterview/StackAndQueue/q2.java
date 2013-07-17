package algorithm.CrackingTheCodingInterview.StackAndQueue;

import java.util.LinkedList;

/**
 *question2:
 *How would you design a stack which, 
 *in addition to push and pop, also has a function min which returns the minimum element? 
 *Push, pop and min should all operate in O(1) time.
 *
 *˼���������뵽����һ���������Խ�ջ��ÿһ��Ԫ�ؽ��бȽϣ��Ӷ����Եõ���Сֵ�������������һ��ջ��Ԫ������Сֵ����ͬʱջ��Ԫ�س�ջ�ˣ�
 *���޷���O(1)��ʱ�����ҵ���Сֵ�ˡ����Դ˷��в�ͨ����������ķ������ڳ�ջ���޷��ҵ���Сֵ�����ԣ�����ÿһ��Ԫ��ά��һ��ָ��ӵ�ǰ
 *Ԫ�ص�ջ��Ԫ�ص���Сֵ��ָ�롣�����ַ�ʽ�и����������ǿռ������������ˡ�
 *�۲��������ӣ�
 *   ��ǰԪ��  �ӵ�ǰԪ�ص�ջ�׵���Сֵ
 *  ջ����1  1
 *  	9  3
 *      8  3
 *      7  3	
 *      6  3
 *      4  3
 *      3  3
 *  ջ�ף�6  6
 *  ͨ������Ĺ۲죬���ǿ��Է��֣�Ϊÿ��Ԫ�ش洢�ӵ�ǰԪ�ص�ջ��Ԫ��֮�����Сֵ�����ںܴ��������Ϣ
 *  ��������ⲿ�����ࣿ
 *  ��������һ��ջS����ÿ����ջ���߳�ջ��ʱ�򣬶�ͨ�������ջ��ջ��Ԫ�رȽ�һ�¡�
 *  ��ջ��ʱ�������ջԪ�ش���Sջ��Ԫ�أ�Sջ��Ԫ�ز��䡣���򣬽���ջԪ��Ҳѹ�뵽ջS�У�ʹջS����һ���ֲ�����Сֵ
 *  ��ջ��ʱ�������ջԪ�ش���Sջ��Ԫ�أ�Sջ��Ԫ�ز��䡣���򣬽�Sջ��ջ��Ԫ��Ҳһͬ��ջ��
 */

public class q2 {
	public static void main(String[] args) {
		Stack1 s1 = new Stack1();
		Stack2 s2 = new Stack2();
		int[] arr = new int[]{6,3,4,6,7,8,9,1};
		for(int i=0;i<arr.length;i++){
			s1.push(arr[i]);
			s2.push(arr[i]);
		}
		System.out.println(s1.min());
		System.out.println(s2.min());
		s1.pop();
		s2.pop();
		System.out.println(s1.min());
		System.out.println(s2.min());
	}
}

class Stack1{
	LinkedList<Integer[]> values ;
	public Stack1(){
		values = new LinkedList<Integer[]>();
	}
	
	public int  pop(){
		return values.pop()[0];
	}
	public void push(int val){
		if(values.peek()==null){
			values.push(new Integer[]{val,val});
		}
		int min = values.peek()[1];
		if(min<val){
			values.push(new Integer[]{val,min});
		}else{
			values.push(new Integer[]{val,val});
		}
	}
	public int min(){
		int min = values.pop()[1];
		return min;
	}
	
}
class Stack2{
	LinkedList<Integer> values;
	LinkedList<Integer> S;//����ջ
	public Stack2(){
		values = new LinkedList<Integer>();
		S = new LinkedList<Integer>();
	}
	public void push(int val ){
		Integer sPeek = S.peek();
		values.push(val);
		if(sPeek==null||val<=sPeek){
			S.push(val);
		}
	}
	public int pop(){
		Integer t = values.pop();
		if(t<=S.peek()){
			S.pop();
		}
		return t;
	}
	public int min(){
		return S.peek();
	}
}