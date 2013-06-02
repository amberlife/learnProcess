package NetWorkProgram.ch6;

import java.io.IOException;
import java.util.List;

public class LookupThread extends Thread {
	private List<Line> entries ;
	PooledWeblog log;
	
	public LookupThread(List<Line> entries,PooledWeblog log){
		this.entries = entries;
		this.log = log;
	}
	
	public void run(){
		Line entry ; 
		while(true){
			synchronized(entries){
				while(entries.size()==0){
					if(log.isFinished())
						return ;
					try{
						entries.wait();
					}catch(InterruptedException e){}
				}
				entry = entries.remove(entries.size()-1);
			}
			
			//处理过程

			
			//顺序写入
			try{
				synchronized(log.writeBuffer){
					//待写入的line不是缓冲区所需要的,等待
					while(entry.getLineNum()<log.writedIndex||entry.getLineNum()>=(log.writedIndex+log.writeBufferLength)){
						try{
							log.writeBuffer.wait();
						}catch(InterruptedException e){}
					}
					log.writeSyncLog(entry);
				}
			}catch(IOException e){}
			
	
		}
	}
	
}
