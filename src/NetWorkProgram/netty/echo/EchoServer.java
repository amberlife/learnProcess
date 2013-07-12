package NetWorkProgram.netty.echo;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class EchoServer {
	private final int port;
	public EchoServer(int port){
		this.port = port;
	}
	public void run() throws Exception{
		ServerBootstrap bootstrap = new ServerBootstrap(
				new NioServerSocketChannelFactory(
						Executors.newCachedThreadPool(),
						Executors.newCachedThreadPool()));
		bootstrap.setPipelineFactory(new ChannelPipelineFactory(){
					public ChannelPipeline getPipeline() throws Exception{
						return Channels.pipeline(new EchoServerHandler());
					}
		});
		bootstrap.bind(new InetSocketAddress(port));
	}
	public static void main(String[] args) throws Exception {
		int port = 8080;
		new EchoServer(port).run();
	}
}
