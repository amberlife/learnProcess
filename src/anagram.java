import java.util.Arrays;


public class anagram {
	
	public static void main(String[] args){
		String[] words= new String[]{
			"pans","pots","opt","snap","stop","tops"	
		};
		for(String entry: words){
			System.out.println(sign(entry));
		}
		
	}
	
	public static String sign(String x){
		char[] cx = x.toCharArray();
		Arrays.sort(cx);
		return String.valueOf(cx);
		
	}
}
