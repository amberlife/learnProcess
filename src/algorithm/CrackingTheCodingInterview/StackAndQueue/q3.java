package algorithm.CrackingTheCodingInterview.StackAndQueue;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, 
 * it might topple. Therefore, in real life, 
 * we would likely start a new stack when the previous stack exceeds some threshold. 
 * Implement a data structure SetOfStacks that mimics this. 
 * SetOfStacks should be composed of several stacks, 
 * and should create a new stack once the previous one exceeds capacity. 
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack 
 * (that is, pop() should return the same values as it would if there were just a single stack).
 * 
 * FOLLOW UP
 * 
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 * 
 * ջ��������ӣ������ӵ���̫��ʱ���ͻ���б���¡���ˣ�����ʵ�������У���һ������ (ջ)������һ���ĸ߶�ʱ�����Ǿͻ�����һ�ѣ��ٴ�ͷ����
 * ʵ�����ݽṹSetOfStacks ��ģ�����������SetOfStacks�ɼ���ջ��ɣ���ǰһջ��������ʱ����Ҫ����һ���µ�ջ ��������ݡ�
 * SetOfStacks.push()��SetOfStacks.pop()����ΪӦ����ֻ��һ��ջʱ ���ֵ�һ����
 * 
 * ˼����
 * ����Ŀ������linkedList���������ݽṹ���ܹ��ܺõ�ʵ��
 * ���������Ŀ�����ö���Ŀռ䣬��¼������ջ�ĳ��ȡ�ʵ��linkedlist��Ϊ������ջ�����ݽṹ��Ĭ������£���ջ�ĳ��ȶ���һ���ġ�
 * ������popAt()��������ջ�ĳ��ȼ�С��
 */
public class q3 {
	//test
	public static void main(String[] args) {
		MultiStack  multiStack = new MultiStack();
		multiStack.push(1);
		multiStack.push(2);
		multiStack.push(3);
		multiStack.push(4);
		multiStack.push(5);
		multiStack.push(6);
		multiStack.push(7);
		multiStack.push(8);
		multiStack.push(9);
		multiStack.push(10);
		
		System.out.println(multiStack.pop());
		System.out.println(multiStack.popAt(12));
		
	}
}
class MultiStack{
	private LinkedList<Integer> indexs;
	private LinkedList<LinkedList<Integer>> values;
	private int subStackSize=3;
	MultiStack(){
		this.indexs = new LinkedList<Integer>();
		this.values = new LinkedList<LinkedList<Integer>>();
	}
	public void push(int val){
		if(indexs==null||values==null) return;
		if(indexs.size()==0){
			LinkedList<Integer> newLastSubStack = new LinkedList<Integer>();
			indexs.add(1);
			newLastSubStack.push(val);
			values.add(newLastSubStack);
			return;
		}
		
		LinkedList<Integer> lastSubStack = values.getLast();
		if(lastSubStack.size()<subStackSize){
			lastSubStack.push(val);
			
			indexs.add(indexs.pollLast()+1);
		}else{
			LinkedList<Integer> newLastSubStack = new LinkedList<Integer>();
			indexs.add(1);
			newLastSubStack.push(val);
			values.add(newLastSubStack);
		}
	}
	public Integer pop(){
		if(indexs==null||values==null)
			return null;
		if(indexs.peek()==null){
			return null;
		}
		LinkedList<Integer> lastSubStack = values.getLast();
		Integer res = lastSubStack.pop();
		int lastSubStackLength=indexs.getLast()-1;
		if(lastSubStackLength==0){
			indexs.pollLast();
			values.pollLast();
		}
		return res ;
	}
	
	//��0��ʼ����
	public Integer popAt(int k){
		Iterator<Integer> iterator = indexs.iterator();
		int idx = 0;
		int sum=0;
		
		while(iterator.hasNext()){
			int t=iterator.next();
			sum += t;
			if(sum>k){
				break;
			}
			idx++;
		}
		//�±�Խ��
		if(k<0){
			return null;
		}
		int offset = sum-k-1;
		if(offset<0) return null;
		int subStackLength = indexs.get(idx);
		if(subStackLength<offset){
			return null;
		}
	
		LinkedList<Integer> subStack = values.get(idx);
		Integer res = subStack.get(offset);
		//Integer res = values.get(idx).get(offset);
		
		subStack.remove(offset);
		indexs.set(idx, subStackLength-1);
		if(subStackLength-1<=0){
			indexs.remove(idx);
			values.remove(idx);
		}
		return res;
	}
	
	
	
}
