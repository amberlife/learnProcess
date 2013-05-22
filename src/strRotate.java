
public class strRotate {
	public static char[] str= {'a','b','c','d','e','f','g','h','i','j'};
	public static void main(String[] args){
		int i=5;
		reverse(0,i-1);
		reverse(i,str.length-1);
		reverse(0,str.length-1);
		System.out.println(str);
	}
	public static void reverse(int start,int end ){
		int stepLength = (int)Math.ceil((end-start)/2.0);
		for(int i=0;i<stepLength;i++){
			char temp = str[start];
			str[start]=str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
}
