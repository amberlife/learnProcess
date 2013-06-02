package NetWorkProgram.ch10;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketInfo {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("java.sun.com",80);
			InetAddress host = socket.getInetAddress();
			int port = socket.getPort();
			int localPort = socket.getLocalPort();
			InetAddress localHost=socket.getLocalAddress();
			System.out.println("Connected to host "+host);
			System.out.println("Connected to remote port "+port);
			System.out.println("Connected from local port "+localPort);
			System.out.println("Connected from local address "+localHost);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
