package NetWorkProgram.ch11;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Redirector {
	private int port;
	private String newSite;
	
	public Redirector(String site,int port){
		this.port = port;
		this.newSite = site;
	}
	
	public void run(){
		try{
			ServerSocket server = new ServerSocket(this.port);
			System.out.println("Redirecting connections on port "+server.getLocalPort()+" to "+newSite);
			
			while(true){
				try{
					Socket s = server.accept();
					Thread t = new RedirectThread(s);
					t.start();
				}catch(IOException e){}
			}
		}catch(BindException e){
			System.err.println("Could not start server. port occupied");
		}catch(IOException e){
			System.err.println(e);
		}
	}
	
	class RedirectThread extends Thread{
		private Socket connection;
		RedirectThread(Socket s){
			this.connection = s;
		}
		public void run(){
			try{
				Writer out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(),"ASCII"));
				Reader in = new InputStreamReader(new BufferedInputStream(connection.getInputStream()));
			
				StringBuffer request = new StringBuffer(80);
				while(true){
					int c = in.read();
					if(c=='\r'||c=='\n'||c==-1) break;
					request.append((char)c);
				}
				
				String get = request.toString();
				int firstSpace = get.indexOf(' ');
				int secondSpace = get.indexOf(' ',firstSpace+1);
				String theFile = get.substring(firstSpace+1,secondSpace);
				if(get.indexOf("HTTP")!=-1){
					out.write("HTTP1.0 302 FOUND\r\n");
					Date now = new Date();
					out.write("Date: "+now+"\r\n");
					out.write("Server: Redirector 1.0\r\n");
					out.write("Location: "+newSite+theFile+"\r\n");
					out.write("Content-type: text/html\r\n\r\n");
					out.flush();
				}
				
				out.write("<HTML><HEAD><TITLE>Document  moved</TITLE></HEAD>\r\n"); 
				out.write("<BODY><H1>Document moved</H1>\r\n"); 
				out.write("The document " + theFile  + " has moved to\r\n<A HREF=\""  + theFile + "\">"  
						  + theFile + "</A>.\r\n Please update your bookmarks<P>"); 
				out.write("</BODY></HTML>\r\n"); 
				out.flush(  ); 
			}catch(IOException e){}
			finally{
				try{
					if(connection!=null) connection.close();
				}catch(IOException e){}
			}
		}
	}
}


