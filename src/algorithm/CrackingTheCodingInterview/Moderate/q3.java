package algorithm.CrackingTheCodingInterview.Moderate;

/**
 * question3
 * write a program compute the number of  the trailing zero in n factorial;
 * 写一个程序，计算n！尾部的零的个数。
 * 
 * 计算n!尾部0的个数。我们知道阶乘计算量是巨大的。阶乘函数增长速度是比指数函数增长速度还要快，因此阶乘很快就要超出计算机整数的表示范围，所以，将阶乘计算出来，计算尾部的0的方式是不可取的。
 * 我们观察下0出现的原因。当某个数的因子里面包含10的时候，就可以在尾部得出一个0。所以，一个整数里面包含多少个因子10，就可以计算出包含多少个尾0.
 * 我们知道10包含2,5两个因子，而2作为一个整数因子的次数是远远多于5作为因子的，因此，5作为因子的数量，即为尾数包含0的个数。问题就转换成了计算整数中包含多少个因子5的问题。
 * 我们观察一下：
 * 5!  包含1*5  包含1个因子5
 * 10！  包含1*5 2*5 包含2个因子5
 * 15！ 包含1*5 2*5 3*5 包含3个因子5
 * 20！ 包含1*5 2*5 3*5 4*5 包含4个因子5
 * 25！ 包含1*5 2*5 3*5 4*5 5*5 包含6个5 。这里包含6个5，是因为在25里面，有两个因子5。前面得到了4个因子5，最后一个数中得到了2个因子5，所以，共计6个因子5
 * 通过上面的观察，可以得到下面的公式
 * trailingZero(n!)=(n/5)+(n/25)+r(n/125)+....+(n/(5^i)),
 * 其中   5^i <= n <5^(i+1)
 * 这个公式可以进一步转换成为：
 * 设 q_i=n/(5^i)
 * 所以
 *   q_0=n;
 *   q_(i+1)=math.floor(q_i/5)
 * 结果等于 q_1+q_2+...+q_i ，其中 5^i <=n < 5^(i+1)
 */
public class q3 {
	public static int trailingZero(int n){
		int q=0;
		int k=0;
		while((k=(n/5))!=0){
			n=n/5;
			q+=k;
		}
		return q;
	}
	
	public static void main(String[] args) {
		int q=trailingZero(100);
		System.out.println(q);
	}
}
