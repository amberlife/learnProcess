package NetWorkProgram;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;



public class PlainNioEchoServer {
	public static void serve(int port)throws IOException{
		System.out.println("Listening for connections on port "+port);
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		ServerSocket ss = serverChannel.socket();
		InetSocketAddress address = new InetSocketAddress(port);
		ss.bind(address);
		serverChannel.configureBlocking(false);
		Selector selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		while(true){
			try{
				selector.select();
			}catch(IOException ex){
				ex.printStackTrace();
				break;
			}
			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = readyKeys.iterator();
			while(iterator.hasNext()){
				SelectionKey key =iterator.next();
				iterator.remove();
				try{
					if(key.isAcceptable()){
						ServerSocketChannel server = (ServerSocketChannel) key
								.channel();
						SocketChannel client = server.accept();
						System.out
								.println("Accepted connection from " + client);
						client.configureBlocking(false);
						client.register(selector, SelectionKey.OP_READ);
					}
					if(key.isReadable()){
						
						SocketChannel client = (SocketChannel)key.channel();
						ByteBuffer readBuffer = ByteBuffer.allocate(20);
						client.read(readBuffer);
						readBuffer.flip();
						client.write(readBuffer);
					}
					
				}catch(IOException e){
					key.cancel();
					try{
						key.channel().close();
					}catch(IOException cex){}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		serve(9000);
	}
}
