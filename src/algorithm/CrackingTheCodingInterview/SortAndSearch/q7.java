package algorithm.CrackingTheCodingInterview.SortAndSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * question7:
 * 马戏团设计了这样一个节目：叠罗汉。一群人往上叠，每个人都踩在另一个人的肩膀上。
 * 要求上面的人要比下面的人矮而且比下面的人轻。给出每个人的身高和体重， 写一个函数计算叠罗汉节目中最多可以叠多少人？
 * 
 * 输入(身高 体重)：(65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 * 输出：最多可叠人数：6 （从上到下是：(56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)）
 * 
 * 先按照一个指标排序，然后寻找另一个指标的最长递增子序列(动态规划问题)
 * 
 */

public class q7 {

	public static void main(String[] args) {
		Person[] personArr = new Person[]{new Person(100,65),
										  new Person(150,70),
										  new Person(90,56),
										  new Person(190,75),
										  new Person(95,60),
										  new Person(150,60),
										  new Person(110,68)};
		//按照身高进行排序
		Arrays.sort(personArr);
		//寻找体重的最长递增子序列
		LinkedList<Person> tt=lis(personArr);
		for(Person p:tt){
			System.out.println(p);
		}
	}
	
	//寻找体重的最长递增子序列的长度
	public static LinkedList<Person> lis(Person[] personArr){
		ArrayList<LinkedList<Person>> lis = new ArrayList<LinkedList<Person>>();
		int k=0,idx=0;
		int[] dp = new int[personArr.length];
		dp[0] = 1;
		LinkedList<Person> ls = new LinkedList<Person>();
		ls.add(personArr[0]);
		lis.add(ls);
		for(int i=0;i<personArr.length;i++){
			dp[i] = 1;
			for(int j=0;j<i;j++){
				if(personArr[i].weight>=personArr[j].weight&&(dp[j]+1>dp[i])){
					dp[i] = dp[j]+1;
					LinkedList<Person> t=lis.get(j);
					LinkedList<Person> newt = new LinkedList<Person>();
					for(Person p:t){
						newt.add(p);
					}
					newt.add(personArr[i]);
					lis.add(i,newt);
				}
			}
			if(dp[i]>k){
				k=dp[i];
				idx=i;
			}
		}
		
		LinkedList<Person> tt = lis.get(idx);
		
		return tt;
	}
	
}
class Person implements Comparable<Person>{
	int height;
	int weight;
	
	public Person(int height,int weight){
		this.height = height;
		this.weight = weight;
	}
	
	public int compareTo(Person o) {
		if(this.height>o.height){
			return 1;
		}else{
			return -1;
		}
	}
	public String toString(){
		return "("+this.height+","+this.weight+")";
	}
}
