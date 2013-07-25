package algorithm.CrackingTheCodingInterview.Recursion;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Write a method to compute all permutations of a string
 * 实现一个串的所有排列
 * 
 * 思考：
 * 所有的排列共计n！种
 * 只有1的时候，就一种排列：{1}
 * 当只有1,2两个元素的时候。固定1,2可以插在1的前面和后面，这样的话，共有两种排列:(1,2),(2,1)
 * 当有1,2,3三个元素的时候。相当于排列(1,2),(2,1)的前后中间插入3.所有共有6种排列：(3,1,2),(1,3,2),(1,2,3),(3,2,1),(2,3,1),(2,1,3)
 * 从上述演示，我们可以推导出一般的递归公式
 * 
 */
public class q4 {
	public static LinkedList<LinkedList<Integer>> recPermu(int arr[],int idx,int n){
		LinkedList<LinkedList<Integer>> perms = new LinkedList<LinkedList<Integer>>();
		if(idx==n){
			perms.add(new LinkedList<Integer>());
		}else if(idx<n){
			LinkedList<LinkedList<Integer>> subPerms = recPermu(arr,idx+1,n);
			for(LinkedList<Integer> perm :subPerms){
				for(int i=0;i<perm.size()+1;i++){
					LinkedList<Integer> s = new LinkedList<Integer>();
					for(int j=0;j<perm.size();j++){
						s.add(perm.get(j));
					}
					s.add(i,arr[idx]);
					perms.add(s);
				}
			}
		}
		return perms;
	}
	
	public static void main(String[] args) {
		LinkedList<LinkedList<Integer>> result = recPermu(new int[]{1,2,3},0,3);
		Iterator<LinkedList<Integer>> iterator = result.iterator();
		while(iterator.hasNext()){
			LinkedList<Integer> set = iterator.next();
			System.out.println(set);
			
		}
	}
}