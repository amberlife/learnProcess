package NetWorkProgram;

public class Local implements Callback,Runnable {
	private Remote remote;
	
	private String message;
	
	public Local(Remote remote, String message){
		super();
		this.remote = remote;
		this.message = message;
	}
	
	//send message...
	public void sendMessage(){
		System.out.println(Thread.currentThread().getName());
		Thread t= new Thread(this);
		t.start();
		System.out.println("message has been sent by local");
	}
	
	 /* 发送消息后的回调函数   */    
    public void execute(Object... objects ) {    
        /**打印返回的消息**/    
        System.out.println(objects[0]);    
        /**打印发送消息的线程名称**/    
        System.out.println(Thread.currentThread().getName());    
        /**中断发送消息的线程**/    
        Thread.interrupted();    
    }    
    
   public static void main(String[] args)    
   {    
       Local local = new Local(new Remote(),"Hello");    
       local.sendMessage();    
   }    
    
    public void run() {    
        remote.executeMessage(message, this); 
        //这相当于给同学打电话，打完电话之后，
        //这个线程就可以去做其他事情了，只不过等到你的同学打回电话给你的时候你要做出响应  
    }   
	
}
