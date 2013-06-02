package NetWorkProgram.ch10;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	public static void main(String[] args) {
		PrintWriter out = null;
		BufferedReader networkIn = null;
		
		try {
			Socket socket = new Socket("localhost",7);
			networkIn  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(socket.getOutputStream());
			System.out.println("Connected to echo server");
			
			while(true){
				String theLine = userIn.readLine();
				if(theLine.equals(".")) break;
				out.println(theLine);
				out.flush();
				System.out.println(networkIn.readLine());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(networkIn!=null)
				try {
					networkIn.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(out!=null) out.close();
		}
		
		
	}
}
