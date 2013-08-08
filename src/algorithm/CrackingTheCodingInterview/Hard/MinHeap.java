package algorithm.CrackingTheCodingInterview.Hard;

import java.util.Arrays;

public class MinHeap {
	public int[] values;
	public MinHeap(int[] values){
		this.values = values;
		int n = this.values.length;
		//堆化数据
		for(int i=n/2-1;i>=0;i--){
			fixDown(values,i,n);
		}
	}
	
	//调整堆
	void minHeapFixup(int a[],int i){
		int j,temp;
		
		temp = a[i];
		j=(i-1)<<1;
		while(j>=0&&i!=0){
			if(a[j]<=temp)
				break;
			a[i] = a[j];
			i=j;
			j=(i-1)/2;
		}
		a[i] = temp;
	}
	
	//最小堆排序
	void sort(){
		for(int i=this.values.length-1;i>=1;i--){
			values[i] = values[i]^values[0];
			values[0] = values[i]^values[0];
			values[i] = values[i]^values[0];
			fixDown(values,0,i);
			
		}
	}
	
	//插入
	void add(int a[],int n ,int number){
		a[n] = number;
		minHeapFixup(a,n);
	}
	
	//向下调整
	void fixDown(int a[],int i ,int n){
		int j,temp;
		temp = a[i];
		j=2*i+1;
		while(j<n){
			if(j+1<n&&a[j+1]<a[j])
				j++;
			if(a[j]>=temp){
				break;
			}
			a[i]=a[j];
			i=j;
			j=2*i+1;
		}
		a[i] = temp ;
	}
	void delete(int a[],int n){
		int tmp = a[0];
		a[0] = a[n-1];
		a[n-1]=tmp;
		fixDown(a,0,n-1);
	}
	
	public static void main(String[] args) {
		int[] a = {3,4,2,6,1,10};
		MinHeap m = new MinHeap(a);
		System.out.println(Arrays.toString(m.values));
		m.sort();
		System.out.println(Arrays.toString(m.values));
	}
	
}
