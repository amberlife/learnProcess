package thinkingInJava.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Random;

public class LockTest {
	private static final int SIZEOF_INT=4;
	private static final int INDEX_START=0;
	private static final int INDEX_COUNT=10;
	private static final int INDEX_SIZE=INDEX_COUNT*SIZEOF_INT;
	private ByteBuffer buffer = ByteBuffer.allocate(INDEX_SIZE);
	private IntBuffer indexBuffer = buffer.asIntBuffer();
	private Random rand = new Random();
	public static void main(String[] args) throws Exception {
		boolean writer = false;
		String filename ;
		if(args.length!=2){
			System.out.println("Usage: [ -r | -w ] filename");
			return ;
		}
		writer = args[0].equals("-w");
		filename = args[1];
		RandomAccessFile raf = new RandomAccessFile(filename,(writer)?"rw":"r");
		FileChannel fc = raf.getChannel();
		LockTest lockTest = new LockTest();
		if(writer)
			lockTest.doUpdates(fc);
		else
			lockTest.doQueries(fc);
	}
	
	void doQueries(FileChannel fc) throws Exception{
		while(true){
			println("trying for shared lock ...");
			FileLock lock = fc.lock(INDEX_START,INDEX_SIZE,true);
			int reps = rand.nextInt(60)+20;
			for(int i=0;i<reps;i++){
				int n = rand.nextInt(INDEX_COUNT);
				int position = INDEX_START+(n*SIZEOF_INT);
				buffer.clear();
				fc.read(buffer,position);
				int value = indexBuffer.get(n);
				println("Index entry "+n+"="+value);
				Thread.sleep(100);
			}
			lock.release();
			println(" sleeping");
			Thread.sleep(rand.nextInt(3000)+500);
		}
	}
	
	void doUpdates(FileChannel fc) throws Exception{
		while(true){
			println("trying for exclusive lock...");
			FileLock lock = fc.lock(INDEX_START,INDEX_SIZE,false);
			updateIndex(fc);
			lock.release();
			println(" sleeping ");
			Thread.sleep(rand.nextInt(2000)+500);
		}
	}
	
	private int idxval = 1; 
	private void updateIndex(FileChannel fc) throws Exception{
		indexBuffer.clear(); 
		for(int i=0;i<INDEX_COUNT;i++){
			idxval++;
			println("Updating index "+i+"="+idxval);
			indexBuffer.put(idxval);
			Thread.sleep(500);
		}
		buffer.clear();
		fc.write(buffer,INDEX_START);
	}
	
	private int lastLineLen=0;
	private void println(String msg){
		System.out.print("\r ");
		System.out.print(msg);
		for(int i=msg.length();i<lastLineLen;i++){
			System.out.print(" ");
		}
		System.out.print("\r");
		System.out.flush();
		lastLineLen =msg.length();
	}
	
	
}
