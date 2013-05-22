package thinkingInJava.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {
	private static void symmetricScramble(CharBuffer buffer){
		buffer.mark();
		char c1 = buffer.get();
		char c2 = buffer.get();
		buffer.reset();
		buffer.put(c2).put(c1);
	}
	private static void main() {
		char[] dat = "UsingBuffers".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(dat.length*2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(dat);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		
	}
}
