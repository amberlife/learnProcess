package algorithm.CrackingTheCodingInterview.ArrayAndString;

/**
 *question3:
 *Design an algorithm and write code to remove the duplicate characters in a string 
 *without using any additional buffer. NOTE: One or two additional variables are fine. 
 *An extra copy of the array is not.
 *����㷨��д�������Ƴ��ַ������ظ����ַ�������ʹ�ö���Ļ���ռ䡣
 *ע�⣺ ����ʹ�ö����һ��������������������������ٿ�һ�����鿽����
 *
 *˼����������һ������Ŀռ䡣
 *˳������ַ��������ʵ�һ���ַ��󣬾ͽ����ַ����ַ�����β��Ԫ������ͬ��Ԫ��ȥ����
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
