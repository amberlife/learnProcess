package NetWorkProgram.ch10;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class DaytimeClient {
	public static void main(String[] args) throws IOException {
		String hostname="216.171.120.36";
		try{
			Socket theSocket = new Socket(hostname,13);
			InputStream timeStream = theSocket.getInputStream();
			StringBuffer time = new StringBuffer();
			int c ; 
			while((c=timeStream.read())!=-1)
				time.append((char)c);
			String timeString = time.toString();
			System.out.println("It is "+timeString+" at "+hostname);
		}catch(UnknownHostException e){
			System.err.println(e);
		}
	}
}
