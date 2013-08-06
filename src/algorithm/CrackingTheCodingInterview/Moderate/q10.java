package algorithm.CrackingTheCodingInterview.Moderate;

import java.util.Random;

/**
 * question10：
 * write a method to generate a random number between 1 and 7 ,
 * given a method that generate a random number between 1 and 5
 * (i.e. implement rand7() using rand5())
 * 根据一个能生成1到5的随机数函数，用它写一个函数生成1到7的随机数。
 * 
 * 用rand5生成rand7不容易想，反过来用rand7生成rand5就容易的多。
 * rand7产生1~7的概率均为1/7，通过rand7产生rand5的概率呢？
 * 直接感觉是1/5,1~5都是等可能的。我们用数学推演一下：
 * 计算一下rand5产生1的概率：
 * 可能是第一次通过rand7产生的，也能可能是第二次,第三次,...,第n次。
 * 那么rand5产生1的概率为：
 * 第一次生成1的概率为1/7,第二次生成1说明第一次没有生成1~5之间的数，而是6,7.所以概率为：(2/7)*(1/7),
 * 依次类推：
 * F(x=1)=1/7+(2/7)*(1/7)+(2/7)^2*(1/7)+.....
 *       =1/7(1+2/7+(2/7)^2+(2/7)^3+....)
 *       =(1/7)*1/(1-2/7)
 *       =1/5;
 * 从上可以得出一个一般性结论,如果a>b,那么通过randa()一定可以实现randb()。
 * 
 * 上面的例子，如果我们能够将rand5()映射到一个更大的范围，就可以实现rand7()。
 * 如何映射？
 * rand5()+rand5()-1，上述代码能够产生1~9的数，但是不是等概率生成的。
 * 生成1只能是前两个rand5()都生成1，才可能。
 * 生成2就可能是(1,2)和(2,1)两种可能，所以，不是等概率生成的，所以这个映射不行。
 * 
 * 5*(rand5()-1)+rand5()
 * 这个映射，前半部分5*(rand5()-1)等概率的产生0,5,10,15,20，后半部分等概率的产生1,2,3,4,5
 * 两个组合，则可以等概率的产生1,2,3,4,5,...,25
 * 那么通过这个映射，就可以方便的求解rand7()了。
 * 伪代码为:
 * rand7(){
 *  int x = max int;
 *  while(x>7){
 *    x = 5*(rand5()-1)*rand5();
 *  }
 *  return x;
 *  }
 *  
 *  上述这个函数能够保证正确，但是因为1~25这个区间相对于1~7太大，所以，中间产生的许多数都要被抛弃，那么产生一个1~7之间
 *  的数的时间，可能会很久，如果我们取不大于25的7的倍数：7*k<25，作为while循环的结束条件，然后以x%7作为结果，则
 *  可以更快的结束。
 *
 */
public class q10 {
	
	public static int rand5(){
		Random rand = new Random();
		return rand.nextInt(5)+1;
	}
	
	public static int rand7(){
		int x= ~(1<<31);
		while(x>21){
			x = 5*(rand5()-1)+rand5();
		}
		return x%7+1;
	}
	public static void main(String[] args) {
		for(int i=0;i<70;i++){
			System.out.print(rand7()+" ");
		}
	}
}
