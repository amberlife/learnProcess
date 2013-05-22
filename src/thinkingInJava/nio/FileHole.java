package thinkingInJava.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileHole {
	public static void main(String[] args) throws IOException {
		File temp = File.createTempFile("holy",null);
		RandomAccessFile file = new RandomAccessFile(temp,"rw");
		FileChannel channel = file.getChannel();
		
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
		putData(0,byteBuffer,channel);
		putData(5000000,byteBuffer,channel);
		putData(50000,byteBuffer,channel);
		
		System.out.println("wrote temp file '"+temp.getPath()+"', size="+channel.size());
		channel.close();
		file.close();
	}
	public static void putData(int position,ByteBuffer buffer,FileChannel channel) throws IOException {
		String string = "*<--- location "+position;
		buffer.clear();
		buffer.put(string.getBytes("US-ASCII"));
		buffer.flip();
		channel.position(position);
		channel.write(buffer);
	}
}
