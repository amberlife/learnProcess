package thinkingInJava.io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
	private static final int BSIZE=1024;
	public static void main(String[] args){
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		IntBuffer ib = bb.asIntBuffer();
		ib.put(new int[] {1,2,3,4,5,6,7,8,9,10});
		System.out.println(ib.get(3));
		
		ib.put(3,10);
		ib.flip();
		
		System.out.println(ib.limit());
		
		while(ib.hasRemaining()){
			int i=ib.get();
			System.out.println(i);
		}
		
	}
}
