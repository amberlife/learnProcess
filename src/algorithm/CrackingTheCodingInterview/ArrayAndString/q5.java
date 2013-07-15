package algorithm.CrackingTheCodingInterview.ArrayAndString;

/**
 *question5:
 * Write a method to replace all spaces in a string with ‘%20’.
 * 写一个函数，把字符串中所有的空格替换为%20 
 * 
 * 思考：一个空格替换成%20,相当于一个字符变成了3个字符。所以先确定空格的数量，就可以确定出新的字符串的长度。
 * 假设字符串中包含m个空格，字符串原长n，那么新的长度为：n+2m;
 * 其次考虑源字符串是否包含足够的空间(以c语言中的字符串表示来理解)，如果包含足够的空间，那么可以从字符串的尾部
 * 开始重新填入。
 * 如果没有足够的空间，则需要重新开辟一块内存空间。简单的从首部到尾部复制即可。
 * 
 * method1：包含足够的空间
 * method2:不包含足够的空间
 */
public class q5 {
	//空间足够
	public static void method1(char[] s1){
		if(s1==null)
			return;
		if(s1.length==0||s1[0]=='\0')
			return ;
		int idx=0;
		int count = 0;
		while(s1[idx]!='\0'){//字符串结束
			if(s1[idx]==' '){
				count++;
			}
			++idx;
		}
		
		int  p = idx+2*count+1;
		s1[p--]='\0';
		for(int i=idx;i>=0;i--){
			if(s1[i]==' '){
				s1[p--]='0';
				s1[p--]='2';
				s1[p--]='%';
			}else{
				s1[p--]=s1[i];
			}
		}
		
		for(int i=0;i<s1.length&&s1[i]!='\0';i++){
			System.out.print(s1[i]);
		}
		
		
	}
	//空间不足
	public static void method2(char[] s2){
		if(s2==null) return;
		if(s2.length==0&&s2[0]=='\0') return ;
		
		int idx=0;
		int count = 0;
		while(s2[idx]!='\0'){//字符串结束
			if(s2[idx]==' '){
				count++;
			}
			++idx;
		}
		char[] newS2= new char[idx+2*count+1];
		int p=0;
		for(int i=0;i<idx;i++){
			if(s2[i]==' '){
				newS2[p++]='%';
				newS2[p++]='2';
				newS2[p++]='0';
			}else{
				newS2[p++]=s2[i];
			}
		}
		newS2[p]='\0';
		for(int i=0;i<newS2.length;i++){
			System.out.print(newS2[i]);
		}
	}
	public static void main(String[] args) {
		char[] str=new char[100];
		str[0]='i';
		str[1]=' ';
		str[2]='l';
		str[3]='o';
		str[4]='v';
		str[5]='e';
		str[6]=' ';
		str[7]='u';
		str[8]='\0';
		method1(str);
		System.out.println();
		char[] str2 = new char[]{'i',' ','l','o','v','e',' ','u','\0'};
		method2(str2);
	}
}
