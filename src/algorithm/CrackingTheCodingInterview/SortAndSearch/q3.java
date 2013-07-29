package algorithm.CrackingTheCodingInterview.SortAndSearch;

/**
 *Given a sorted array of n integers that has been rotated an unknown number of times, 
 *give an O(log n) algorithm that finds an element in the array. 
 *You may assume that the array was originally sorted in increasing order.
 *EXAMPLE:
 *Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 *Output: 8 (the index of 5 in the array)
 *
 *一个数组有n个整数，它们排好序(假设为升序)但被旋转了未知次， 即每次把最右边的数放到最左边。给出一个O(log n)的算法找到特定的某个元素。
 *输入：在数组(15 16 19 20 25 1 3 4 5 7 10 14)中找出5
 *输出：8（5在数组中的下标）
 *
 *字符串被旋转了未知次,可以发现字符串是分为两段有序，如果是整段有序的话，考虑二分查找法，就可以在O(log n)的时间内完成。
 *所以，对于这里的两段有序，我们还是可以考虑使用调整后的二分查找法。
 *设数组为S，要查找元素为k
 *设置三个指针，头指针head,尾指针tail,中间指针mid。
 *mid=(head+tail)>>1
 *S[head]=15,S[tail]=14,S[mid]=3,k=16;
 *因为S[mid]=3，小于k的值，同时S[mid]小于S[head]，小于S[tail]
 *所以，可以说明从s[mid...tail]这段是递增的。然而k值大于S[tail]，
 *所以，可以说明k位于S[head...mid]这一段内，但是这一段内的值不是递增的。
 *所以，此时我们向左移动mid指针，直到k>S[mid],到达这里，说明此时从head
 *到mid的值是递增的，随后，即可使用传统的二分查找来进行。
 *
 */
public class q3 {
	static int search(int a[],int head,int tail,int x){
		while(head<=tail){
			int mid = (head+tail)>>1;
			if(a[mid]==x) return mid;
			if(a[mid]<x){
				if(a[mid]<a[head]){
					if(a[head]<=x) tail=mid-1;
					else head=mid+1;
				}else{
					head=mid+1;
				}
			}else{
				if(a[mid]<a[head]){
					tail = mid-1;
				}else{
					if(a[head]<=x) tail =mid-1;
					else head=mid+1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] a = {15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(search(a,0,11,5));
	}
}