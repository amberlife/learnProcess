package NetWorkProgram.ch6;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class OReillyByName {
	public static void main(String[] args) {
		try{
			InetAddress address = InetAddress.getByName("220.181.111.148");
			byte[] ip = address.getAddress();
			for(int i=0;i<ip.length;i++){
				System.out.print((ip[i]&0XFF)+".");
			}
		
			
			
		}catch(UnknownHostException e){
			System.out.println("Could not find www.baidu.com");
		}
	}
	
}
