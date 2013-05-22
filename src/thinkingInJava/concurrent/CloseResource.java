package thinkingInJava.concurrent;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class IOBlocked implements Runnable{
	private InputStream in ; 
	public IOBlocked(InputStream is){
		in=is;
	}
	public void run(){
		try{
			System.out.println("Waiting for read():");
			in.read();
		}catch(IOException e){
			if(Thread.currentThread().isInterrupted()){
				System.out.println("Interrupted from blocked I/O");
				
			}else{
				throw new RuntimeException(e);
			}
		}
		System.out.println("Exiting IOBlocked.run()");
	}
	
}

public class CloseResource {
	public static void main(String[] args) throws IOException, InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();   
	    ServerSocket server = new ServerSocket(8080);   
	    InputStream socketInput =   
	      new Socket("localhost", 8080).getInputStream();   
	    exec.execute(new IOBlocked(socketInput));   
	    exec.execute(new IOBlocked(System.in));   
	    TimeUnit.MILLISECONDS.sleep(100);   
	    System.out.println("Shutting down all threads");   
	    exec.shutdownNow();   
	    TimeUnit.SECONDS.sleep(1);   
	    System.out.println("Closing " + socketInput.getClass().getName());   
	    socketInput.close(); // Releases blocked thread   
	    TimeUnit.SECONDS.sleep(1);   
	    System.out.println("Closing " + System.in.getClass().getName());   
	    System.in.close(); // Releases blocked thread   
	}
}
