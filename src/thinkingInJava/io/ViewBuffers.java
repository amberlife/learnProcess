package thinkingInJava.io;

import java.nio.*;


public class ViewBuffers {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
		bb.rewind();
		System.out.println("Byte Buffer ");
		while(bb.hasRemaining())
			System.out.print(bb.position()+" -> "+bb.get()+", ");
		System.out.println();
		
		CharBuffer cb = ((ByteBuffer)bb.rewind()).asCharBuffer();
		System.out.println("Char Buffer ");
		while(cb.hasRemaining())
			System.out.print(bb.position()+" -> "+bb.get()+", ");
		System.out.println();
		
		FloatBuffer fb = ((ByteBuffer)bb.rewind()).asFloatBuffer();
		System.out.println("Float Buffer ");
		while(cb.hasRemaining())
			System.out.print(bb.position()+" -> "+bb.get()+", ");
		System.out.println();
	}
}
