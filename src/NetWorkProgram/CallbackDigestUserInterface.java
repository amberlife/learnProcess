package NetWorkProgram;

public class CallbackDigestUserInterface {
	public static void receiveDigest(byte[] digest, String name){
		StringBuffer result = new StringBuffer(name);
		result.append(": ");
		for(int j=0;j<digest.length;j++){
			result.append(digest[j]+" ");
		}
		System.out.println(result);
	}
}
