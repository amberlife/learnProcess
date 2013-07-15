package algorithm.CrackingTheCodingInterview.ArrayAndString;

/**
 *Assume you have a method isSubstring which checks if one word is a substring of another. 
 *Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using 
 *only one call to isSubstring ( i.e., “waterbottle” is a rotation of “erbottlewat”).
 *假设你有一个isSubstring函数，可以检测一个字符串是否是另一个字符串的子串。 给出字符串s1和s2，只使用一次isSubstring就能判断s2是否是s1的旋转字符串，
 *请写出代码。旋转字符串："waterbottle"是"erbottlewat"的旋转字符串。
 *
 *思考：对于求解旋转字符串的问题，是一道很有技巧的问题，可以通过将字符串复制成双份，就可以简单的说字符串进行了旋转。
 *例如 对于字符串'abcd'，复制称为'abcdabcd'。就可以说明对'abcd'，基于每个字符进行了旋转。随后，可以通过
 *str1.contains(str2)，通过简单的子串匹配来判断str2是否为复制之前的str1的旋转字符串
 */
public class q8 {
	public static boolean method1(String str1,String str2){
		str1=str1+str1;
		if(str1.contains(str2)){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String str1 = "waterbottle";
		String str2 = "erbottlewat";
		System.out.println(method1(str1,str2));
	}
}
