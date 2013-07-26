package algorithm.CrackingTheCodingInterview.Recursion;

/**
 * Implement an algorithm to print all valid (e.g., properly opened and closed) 
 * combinations of n-pairs of parentheses
 * 实现一个算法打印出n对括号的有效组合。
 * 输入：3
 * 输出：((())), (()()), (())(), ()(()), ()()()
 * 
 * 思考：
 * 有效的组合表现为：左括号的数量在组合的任意子串上大于等于右括号的数量
 * ((())) left=3 right3
 * (      left=1 right=0
 * ((     left=2 right=0
 * (((    left=3 right=0
 * ((()   left=3 right=1
 * ((())  left=3 right=2
 * ((())) left=3 right=3
 * 
 * 从上述过程，可以发现
 *   在没有左右括号时，字符串被构建完成，直接输出
 *   如果有一个左括号可用，那么尝试加入字符串
 *      当有了一个左括号后，需要加入一个右括号，以保持"平衡"
 *   如果有一个右括号可用，那么尝试加入字符串中
 *      此时，少了一个右括号
 *所以，可以通过递归的方式来解决这个问题。
 *
 *这道题目的递归公式应用的很巧妙，当退出一层递归后，代码继续向下运行，就又进入到一层递归中，此时也就可以满足另外一种情况。
 *多熟悉下。
 * 
 * 
 */
public class q5 {
	static void brackets(int openStock, int closeStock, String s) {
        if (openStock == 0 && closeStock == 0) {
            System.out.println(s);
        }
        if (openStock > 0) {
            brackets(openStock-1, closeStock+1, s + "(");
        }
        if (closeStock > 0) {
            brackets(openStock, closeStock-1, s + ")");
        }
    }
	
	public static void main(String[] args) {
	    brackets(3, 0, "");
	}
}
