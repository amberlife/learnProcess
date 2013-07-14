package algorithm.CrackingTheCodingInterview.ArrayAndString;

/**
 *question3:
 *Design an algorithm and write code to remove the duplicate characters in a string 
 *without using any additional buffer. NOTE: One or two additional variables are fine. 
 *An extra copy of the array is not.
 *设计算法并写出代码移除字符串中重复的字符，不能使用额外的缓存空间。
 *注意： 可以使用额外的一个或两个变量，但不允许额外再开一个数组拷贝。
 *
 *思考：不允许开一个额外的空间。
 *顺序访问字符串，访问到一个字符后，就将该字符到字符串结尾的元素中相同的元素去掉。
 */
public class q3 {
	public static void main(String[] args) {
		char[] s = {'a','b','c','a','b','c'};
		removeDuplicate(s);
		
	}
	public static void removeDuplicate(char s[]){
		int len = s.length;
		if(len<1) return;
		int p=0;
		for(int i=0;i<len;++i){
			if(s[i]!='\0'){
				s[p++]=s[i];
				for(int j=i+1;j<len;++j){
					if(s[j]==s[i]){
						s[j]='\0';
					}
				}
			}
		}
		s[p]='\0';
		
		for(int i=0;i<len&&s[i]!='\0';i++){
			System.out.print(s[i]);
		}
	}
}
