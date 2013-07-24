package algorithm.CrackingTheCodingInterview.BitManipulation;

/**
 * Given a (decimal – e.g. 3.72) number that is passed in as a string, 
 * print the binary representation.If the number can not be represented accurately in binary, 
 * print “ERROR”.
 * 
 * 给定一个字符串类型(string)表示的小数，打印出它的二进制表示。 如果这个数无法精确地表示为二进制形式，输出"ERROR"。
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
			//对于乘不进的小数的处理，是个问题！！
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
