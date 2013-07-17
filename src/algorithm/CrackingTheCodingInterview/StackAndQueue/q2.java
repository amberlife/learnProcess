package algorithm.CrackingTheCodingInterview.StackAndQueue;

import java.util.LinkedList;

/**
 *question2:
 *How would you design a stack which, 
 *in addition to push and pop, also has a function min which returns the minimum element? 
 *Push, pop and min should all operate in O(1) time.
 *
 *思考：首先想到设置一个变量，对进栈的每一个元素进行比较，从而可以得到最小值。但是如果遇到一个栈顶元素是最小值，但同时栈顶元素出栈了，
 *就无法在O(1)的时间内找到最小值了。所以此法行不通。基于上面的分析，在出栈后，无法找到最小值。所以，考虑每一个元素维护一个指向从当前
 *元素到栈底元素的最小值的指针。但这种方式有个最大的问题是空间利用率增加了。
 *观察下面例子：
 *   当前元素  从当前元素到栈底的最小值
 *  栈顶：1  1
 *  	9  3
 *      8  3
 *      7  3	
 *      6  3
 *      4  3
 *      3  3
 *  栈底：6  6
 *  通过上面的观察，我们可以发现，为每个元素存储从当前元素到栈底元素之间的最小值，存在很大的冗余信息
 *  如何消除这部分冗余？
 *  引入另外一个栈S，当每次入栈或者出栈的时候，都通这个额外栈的栈顶元素比较一下。
 *  入栈的时候，如果入栈元素大于S栈顶元素，S栈顶元素不变。否则，将入栈元素也压入到栈S中，使栈S保持一个局部的最小值
 *  出栈的时候，如果出栈元素大于S栈顶元素，S栈顶元素不变。否则，将S栈的栈顶元素也一同出栈。
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
	LinkedList<Integer> S;//额外栈
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