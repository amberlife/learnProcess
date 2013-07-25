package algorithm.CrackingTheCodingInterview.Recursion;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Write a method that returns all subsets of a set.
 * ����һ�����ϵ������Ӽ�
 * 
 * ˼����
 * S(6)=(1,2,3,4,5,6)
 * �Ӽ�����2^n����
 * S(6)���Ӽ�=6��S(5)�����+S(5)���Ӽ���
 */
public class q3 {
	public static LinkedList<LinkedList<Integer>> recSubSet(int[] set,int n,int index){
		LinkedList<LinkedList<Integer>>  subsets = new LinkedList<LinkedList<Integer>>();
		if(index==n){//��ֹ������������һ���ռ�
			LinkedList<Integer> subset = new LinkedList<Integer>();
			subsets.add(subset);
		}
		else{
			LinkedList<LinkedList<Integer>> part = recSubSet(set,n,index+1);
			int v=set[index];
			for(int i=0;i<part.size();i++){
				LinkedList<Integer> subset = part.get(i);
				subsets.add(subset);
				LinkedList<Integer> newsubset = new LinkedList<Integer>();
				for(Integer entry:subset){
					newsubset.add(entry);
				}
				newsubset.add(v);
				subsets.add(newsubset);
			}
		}
		return subsets;
	}
	public static void main(String[] args) {
		LinkedList<LinkedList<Integer>> result=recSubSet(new int[]{1,2,3,4,5,6},4,0);
		Iterator<LinkedList<Integer>> iterator = result.iterator();
		while(iterator.hasNext()){
			LinkedList<Integer> set = iterator.next();
			System.out.println(set);
			
		}
		
	}
}
