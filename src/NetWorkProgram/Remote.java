package NetWorkProgram;

public class Remote {
	public void executeMessage(String msg,Callback callback){
		 /**模拟远程类正在处理其他事情，可能需要花费许多时间**/    
        for(int i=0;i<1000000000;i++)    
        {    
                float s = (float) ((float)i/0.5);
        }    
        /**处理完其他事情，现在来处理消息**/    
        System.out.println(msg);    
        System.out.println("I hava executed the message by Local");    
        callback.execute(new String[]{"Nice to meet you~!"});
		
	}
}
