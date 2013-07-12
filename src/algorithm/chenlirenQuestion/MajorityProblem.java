package algorithm.chenlirenQuestion;

/**
 * 
 * @author Administrator
 * Majority定义: 整形数组A[1...n]中的元素a, 其出现次数超过[n/2]
 *  该算法的关键思想源自以下这条定理:
 *  如果元素 x 和 y是不同的元素, 那么移除这两个元素后得到的新数组B[1...n-2], 与A的majority是相等的.
 */
public class MajorityProblem {
	
	public static void main(String[] args) {
		int[] A = new int[]{1,2,2,3,2,2,3};
		System.out.println(majority(A));
	}
	
	public static int majority(int[] A){
		int c = candidate(0,A);
		int count = 0 ;
		for(int j=0;j<A.length;j++){
			if(A[j]==c)
				count++;
		}
		if(count>Math.floor(A.length/2f))
			return c; 
		else return -1;
	}
	
	public static int candidate(int m,int[] A){
		int j=m;
		int c=A[m];
		int count = 1;
		while(j<(A.length-1)&&count>0){
			j++;
			if(A[j]==c)
				count++;
			else 
				count--;
		}
		if(j==(A.length-1)) return c;
		else{
			//这里的递归用的巧妙
			return candidate(j+1,A);
		}
	}
}
