package NetWorkProgram;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;


public class GZipThread extends Thread {
	private List pool;
	private static int filesCompressed=0;
	
	public GZipThread(List pool){
		this.pool = pool;
	}
	
	private static synchronized void incrementFilesCompressed(){
		filesCompressed++;
	}
	
	public void run(){
		while(filesCompressed!=GZipAllFiles.getNumberOfFilesToBeCompressed()){
			File input = null;
			synchronized(pool){
				while(pool.isEmpty()){
					if(filesCompressed == GZipAllFiles.getNumberOfFilesToBeCompressed())
						return;
					try{
						pool.wait();
					}catch(InterruptedException e){
						System.out.println("out");
						return;
					}
				}
				input = (File)pool.remove(pool.size()-1);
			}
			
			if(!input.getName().endsWith(".gz")){
				try{
					InputStream in  = new BufferedInputStream(new FileInputStream(input));
					File 	output = new File(input.getParent(),input.getName()+".gz");
					if(!output.exists()){
						OutputStream out = new BufferedOutputStream( new GZIPOutputStream(new FileOutputStream(output)));
						int b;
						while((b=in.read())!=-1)
							out.write(b);
						out.flush();
						out.close();
						incrementFilesCompressed();
						in.close();
					}
				} catch(IOException e){
					System.err.println(e);
				}
			}
			
		}
	}
}
