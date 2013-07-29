package algorithm.CrackingTheCodingInterview.SortAndSearch;

/**
 * You are given two sorted arrays, A and B, and A has a large enough buffer at 
 * the end to hold B. Write a method to merge B into A in sorted order.
 * A , B两个有序数组，A的空间足够大的容纳B。写一个方法，将A，B数组融合成一个有序数组
 * 
 * 题目中说了A的空间足够大到容纳B，因此此题目考虑不适用额外的空间来讲A，B融合。
 * 在数据结构的课本上有这么一道类似的习题，使用了额外的空间C，将A，B的元素依次比较，小的元素放入C中。当A或者B中一方
 * 比较结束后，只需要将另一方的所有元素依次放入C即可。
 * 而这里，不使用额外的空间。所以，不能采用上述的比较方法，当把元素放入A的时候，会把A中还没有比较过的元素覆盖掉。
 * 所以，我们考虑从尾部进行比较，就不存在上述覆盖问题了。
 */
public class q1 {
	public static void merge(int[] a ,int[] b ,int m,int n){
		int idx = m+n-1;
		int i=m-1,j=n-1;
		while(i>=0&&j>=0){
			if(a[i]>b[j]){
				a[idx]=a[i];
				i--;
			}else{
				a[idx]=b[j];
				j--;
			}
			idx--;
		}
		while(i>=0){
			a[idx--]=a[i--];
		}
		while(j>=0){
			a[idx--]=b[j--];
		}
	}
	public static void main(String[] args){
		int[] a =new int[10];
		a[0]=1;
		a[1]=3;
		a[2]=5;
		int[] b = new int[5];
		b[0]=2;
		b[1]=4;
		b[2]=6;
		b[3]=7;
		b[4]=8;
		merge(a,b,3,5);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		
	
	}
}
