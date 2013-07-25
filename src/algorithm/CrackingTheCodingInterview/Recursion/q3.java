package algorithm.CrackingTheCodingInterview.Recursion;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Write a method that returns all subsets of a set.
 * 返回一个集合的所有子集
 * 
 * 思考：
 * S(6)=(1,2,3,4,5,6)
 * 子集共计2^n个，
 * S(6)的子集=6和S(5)的组合+S(5)的子集合
 */
public class q3 {
	public static LinkedList<LinkedList<Integer>> recSubSet(int[] set,int n,int index){
		LinkedList<LinkedList<Integer>>  subsets = new LinkedList<LinkedList<Integer>>();
		if(index==n){//终止条件，最后加入一个空集
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
