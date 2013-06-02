package NetWorkProgram;

import java.io.File;
import java.util.Vector;

public class GZipAllFiles {
	public final static int 	THREAD_COUNT=4;
	private static int fileToBeCompressed=-1;
	
	public static void main(String[] args) {
		Vector<File> pool  = new Vector<File>();
		GZipThread[] threads  = new GZipThread[THREAD_COUNT];
		
		
		for(int i=0;i<threads.length;i++){
			threads[i]= new GZipThread(pool);
			//threads[i].setDaemon(true);
			threads[i].start();
		}
		
		int totalFiles =0;
		for(int i=0;i<args.length;i++){
			File f = new File(args[i]);
			if(f.exists()){
				if(f.isDirectory()){
					File[] files = f.listFiles();
					for(int j=0;j<files.length;j++){
						if(!files[j].isDirectory()){
							totalFiles++;
							synchronized(pool){
								pool.add(files[j]);
								pool.notifyAll();
							}
						}
					}
				}else{
					totalFiles++;
					synchronized(pool){
						pool.add(0,f);
						pool.notifyAll();
					}
				}
			}
		}
		fileToBeCompressed = totalFiles;
		for(int i=0;i<threads.length;i++){
			threads[i].interrupt();
		}
	}
	
	public static int getNumberOfFilesToBeCompressed(){
		return fileToBeCompressed;
	}
}
