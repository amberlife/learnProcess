package algorithm.CrackingTheCodingInterview.Recursion;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Write a method to compute all permutations of a string
 * ʵ��һ��������������
 * 
 * ˼����
 * ���е����й���n����
 * ֻ��1��ʱ�򣬾�һ�����У�{1}
 * ��ֻ��1,2����Ԫ�ص�ʱ�򡣹̶�1,2���Բ���1��ǰ��ͺ��棬�����Ļ���������������:(1,2),(2,1)
 * ����1,2,3����Ԫ�ص�ʱ���൱������(1,2),(2,1)��ǰ���м����3.���й���6�����У�(3,1,2),(1,3,2),(1,2,3),(3,2,1),(2,3,1),(2,1,3)
 * ��������ʾ�����ǿ����Ƶ���һ��ĵݹ鹫ʽ
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