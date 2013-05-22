package thinkingInJava.io;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class MappedIO {
	private static int numOfInts = 4000000;
	private static int numOfUbuffInts = 200000;
	private abstract static class Tester{
		private String name ;
		public Tester(String name){
			this.name = name ; 
		}
		public void runTest(){
			System.out.println(name+" : ");
			try{
				long start = System.nanoTime();
				test();
				double duration = System.nanoTime()-start;
				System.out.format("%.2f\n",duration/1.0e9);
			}catch(IOException e){
				throw new RuntimeException(e);
			}
		}
		public abstract void test() throws IOException;
	}
	
	private static Tester[] tests = {
		new Tester("Stream Write"){
			public void test() throws IOException{
				DataOutputStream dos = new DataOutputStream(
						new BufferedOutputStream(new FileOutputStream(new File(
								"temp.tmp"))));
				for(int i=0;i<numOfInts;i++){
					dos.writeInt(i);
				}
				dos.close();
			}
		},
		new Tester("Mapped Write"){
			public void test() throws IOException{
				FileChannel fc = new RandomAccessFile("temp.tmp","rw").getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE,0,fc.size()).asIntBuffer();
				for( int i=0 ;i<numOfInts;i++)
					ib.put(i);
				fc.close();
			}
		}
	};
	
	public static void main(String[] args) {
		for(Tester test:tests){
			test.runTest();
		}
	}
	
	
}
