package NetWorkProgram;

import java.io.File;

public class CallbackDigestUserInterface {
	public static void receiveDigest(byte[] digest, String name){
		StringBuffer result = new StringBuffer(name);
		result.append(": ");
		for(int j=0;j<digest.length;j++){
			result.append(digest[j]+" ");
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		for(int i=0;i<args.length;i++){
			File f = new File(args[i]);
			CallbackDigest cb = new CallbackDigest(f);
			Thread t = new Thread(cb);
			t.start();
		}
	}
	
	
}
