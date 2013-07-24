package algorithm.CrackingTheCodingInterview.BitManipulation;

/**
 * Given a (decimal �C e.g. 3.72) number that is passed in as a string, 
 * print the binary representation.If the number can not be represented accurately in binary, 
 * print ��ERROR��.
 * 
 * ����һ���ַ�������(string)��ʾ��С������ӡ�����Ķ����Ʊ�ʾ�� ���������޷���ȷ�ر�ʾΪ��������ʽ�����"ERROR"��
 *
 */
public class q2 {
	public static void  binaryFormat(String number){
		String intStr = new String();
		String decimalStr = new String();
		String[] vals = number.split("\\.");
		int intPart  = Integer.parseInt(vals[0]);
		float decimalPart = Float.parseFloat("."+vals[1]);
		while(intPart>0){
			if((intPart&1)==1){
				intStr="1"+intStr;
			}else{
				intStr="0"+intStr;
			}
			intPart>>=1;
		}
		while(decimalPart>0){
			//���ڳ˲�����С���Ĵ����Ǹ����⣡��
			if(decimalStr.length()>32){
				System.err.println("ERROR"); 
				
			}
			decimalPart*=2;
			if(decimalPart>=1){
				decimalStr="1"+decimalStr;
				decimalPart-=1;
			}else{
				decimalStr="0"+decimalStr;
			}
		}
		System.out.println( intStr+"."+decimalStr);
	}
	public static void main(String[] args) {
		binaryFormat("1024.5");
	}
}
