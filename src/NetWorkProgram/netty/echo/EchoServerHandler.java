package NetWorkProgram.netty.echo;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;


public class EchoServerHandler extends SimpleChannelUpstreamHandler {
	private static final Logger logger = Logger.getLogger(EchoServerHandler.class.getName());
	private final AtomicLong transferredBytes = new AtomicLong();
	
	public long getTransferredBytes(){
		return transferredBytes.get();
	}
	
	public void messageReceived(ChannelHandlerContext ctx,MessageEvent e){
		transferredBytes.addAndGet(((ChannelBuffer)e.getMessage()).readableBytes());
		e.getChannel().write(e.getMessage());
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx,ExceptionEvent e){
		logger.log(Level.WARNING,"Unexpected exception from downstream"+e.getCause());
		e.getChannel().close();
	}
}
