package NetWorkProgram.ch6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PooledWeblog {
	private BufferedReader in;
	private BufferedWriter out;
	private int numberOfThreads ;
	private List<Line> entries = Collections.synchronizedList(new LinkedList<Line>());
	public Line[]  writeBuffer ; 
	public int writedIndex;
	public int writedCount;
	private int readingNum;
	public int writeBufferLength;
	private boolean  finished = false;
	
	public PooledWeblog(InputStream in ,OutputStream out ,int numberOfThreads,int writeBufferCount){
		this.in = new BufferedReader(new InputStreamReader( in ));
		this.out =new BufferedWriter(new OutputStreamWriter( out)); 
		this.numberOfThreads = numberOfThreads;
		this.writeBufferLength = writeBufferCount;
		this.writeBuffer  = new Line[writeBufferCount];
	}
	
	public boolean isFinished(){
		return this.finished;
	}
	
	public int getNumberOfThreads(){
		return this.numberOfThreads;
	}
	
	public void processLogFile(){
		for(int i=0;i<numberOfThreads;i++){
			Thread t= new LookupThread(entries,this);
			t.start();
		}
		
		try{
			String entry = null;
			while((entry=in.readLine())!=null){
				if(entries.size()>numberOfThreads){
					try{
						Thread.sleep((long)(1000.0/numberOfThreads));
					}catch(InterruptedException e){}
					continue;
				}
				synchronized(entries){
					Line  line = new Line(readingNum,entry);
					this.readingNum++;
					entries.add(0,line);
					entries.notifyAll();
				}
				Thread.yield();
			}
		}catch(IOException e){
			System.out.println("Exception: "+e);
		}
		this.finished=true;
		synchronized(entries){
			entries.notifyAll();
		}
	}
	
	public void writeSyncLog(Line entry) throws IOException{
		//写缓冲区 未满，
			synchronized(writeBuffer){
				if(this.writedCount<=this.writeBufferLength){
					int index = entry.getLineNum()-this.writedIndex;
					this.writeBuffer[index] = entry;
					this.writedCount++;
				}
				if(this.writedCount==this.writeBufferLength){
					//写入文件中
					for(int i=0;i<this.writeBufferLength;i++){
						out.write(writeBuffer[i].getLineNum()+":"+writeBuffer[i].getLineValue()+System.getProperty("line.separator","\r\n"));
					}
					out.flush();
					this.writedCount=0;
					this.writedIndex +=this.writeBufferLength;
				}
				writeBuffer.notifyAll();
			}
	}
	
	public void writeLog(Line entry) throws IOException{
		out.write(entry.getLineNum()+":"+entry.getLineValue()+System.getProperty("line.separator","\r\n"));
		out.flush();
	}
	
	public static void main(String[] args) {
		try{
			PooledWeblog tw = new PooledWeblog(new FileInputStream("/var/log/apache2/access.log"),System.out,100,1000);
			tw.processLogFile();
			
		}catch(FileNotFoundException e){
			System.err.println("Usage : java PooledWeblog logfile_name");
		}
	}
}
