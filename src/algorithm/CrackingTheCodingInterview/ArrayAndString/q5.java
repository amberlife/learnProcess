package algorithm.CrackingTheCodingInterview.ArrayAndString;

/**
 *question5:
 * Write a method to replace all spaces in a string with ��%20��.
 * дһ�����������ַ��������еĿո��滻Ϊ%20 
 * 
 * ˼����һ���ո��滻��%20,�൱��һ���ַ������3���ַ���������ȷ���ո���������Ϳ���ȷ�����µ��ַ����ĳ��ȡ�
 * �����ַ����а���m���ո��ַ���ԭ��n����ô�µĳ���Ϊ��n+2m;
 * ��ο���Դ�ַ����Ƿ�����㹻�Ŀռ�(��c�����е��ַ�����ʾ�����)����������㹻�Ŀռ䣬��ô���Դ��ַ�����β��
 * ��ʼ�������롣
 * ���û���㹻�Ŀռ䣬����Ҫ���¿���һ���ڴ�ռ䡣�򵥵Ĵ��ײ���β�����Ƽ��ɡ�
 * 
 * method1�������㹻�Ŀռ�
 * method2:�������㹻�Ŀռ�
 */
public class q5 {
	//�ռ��㹻
	public static void method1(char[] s1){
		if(s1==null)
			return;
		if(s1.length==0||s1[0]=='\0')
			return ;
		int idx=0;
		int count = 0;
		while(s1[idx]!='\0'){//�ַ�������
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
	//�ռ䲻��
	public static void method2(char[] s2){
		if(s2==null) return;
		if(s2.length==0&&s2[0]=='\0') return ;
		
		int idx=0;
		int count = 0;
		while(s2[idx]!='\0'){//�ַ�������
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
