package NetWorkProgram.ch7;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLStreamTest {
	public static void main(String[] args) throws IOException {
		URL u;
		try {
			u = new URL("http://www.baidu.com");
			InputStream in = u.openStream();
			in = new BufferedInputStream(in);
			Reader r = new InputStreamReader(in);
			int c; 
			while((c=in.read())!=-1) 
				System.out.print((char)c);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	
	}
}
