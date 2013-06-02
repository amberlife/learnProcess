package NetWorkProgram.ch10;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeClient {
	public final static int DEFAULT_PORT=37;
	public static void main(String[] args) {
		String hostname="216.171.120.36";
		int port = DEFAULT_PORT;
		
			long differenceBetweenEpochs=2208988800L;
		
		/*TimeZone  gmt = TimeZone.getTimeZone("GMT");
		Calendar epoch1900=Calendar.getInstance(gmt);
		epoch1900.set(1900,01,01,00,00,00);
		long epoch1900ms = epoch1900.getTime().getTime();
		Calendar epoch1970=Calendar.getInstance(gmt);
		epoch1970.set(1970,01,01,00,00,00);
		long epoch1970ms = epoch1970.getTime().getTime();
		
		long differenceInMS = epoch1970ms-epoch1900ms;
		long differenceBetweenEpochs1=differenceInMS/1000;*/
		
		InputStream raw = null;
		try {
			Socket theSocket = new Socket(hostname, port);
			raw = theSocket.getInputStream();
			long secondsSince1900 = 0;
			for (int i = 0; i < 4; i++) {
				secondsSince1900 = (secondsSince1900 << 8) | raw.read();
			}

			long secondsSince1970 = secondsSince1900 - differenceBetweenEpochs;
			long msSince1970 = secondsSince1970 * 1000;
			Date time = new Date(msSince1970);
			System.out.println("It is " + time + " at " + hostname);
		} // end try
		catch (UnknownHostException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				if (raw != null)
					raw.close();
			} catch (IOException e) {
			}
		}

	}
}
