package NetWorkProgram.ch7;

import java.net.MalformedURLException;
import java.net.URL;

public class ProtocolTester {
	
	public static void main(String[] args){
	
		try{
			URL u = new URL("http","www.baidu.com","/index.php?hellowrold=1");
		}catch(MalformedURLException e){
			
		}




	}
	
	private static void testProtocol(String url){
		try {
			URL u = new URL(url);
			System.out.println(u.getProtocol()+" is supported");
		}catch(MalformedURLException e){
			String protocol = url.substring(0,url.indexOf(":"));
			System.out.println(protocol + " is not supported");
		}
	}
}
