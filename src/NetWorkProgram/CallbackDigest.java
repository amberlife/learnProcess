package NetWorkProgram;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CallbackDigest implements Runnable {
	private File input; 
	public CallbackDigest(File input){
		this.input = input;
	}
	public void run(){
		try{
			FileInputStream in  =new FileInputStream(input);
			MessageDigest sha = MessageDigest.getInstance("SHA");
			DigestInputStream din = new DigestInputStream(in,sha);
			int b ; 
			while((b=din.read())!=-1);
			din.close();
			byte[] digest = sha.digest();
			CallbackDigestUserInterface.receiveDigest(digest,input.getName());
		}catch(IOException e){
			System.err.println(e);
		}catch(NoSuchAlgorithmException e){
			System.err.println(e);
		}
	}
	
}
