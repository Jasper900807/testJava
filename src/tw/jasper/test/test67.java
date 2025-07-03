package tw.jasper.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class test67 {

	public static void main(String[] args) {
		try {
			URL url = new URL("");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			conn.connect();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("dir2/yahoo.jpg"));
			
			byte[] buf = new byte[4*1024];
			int len; int i = 0;
			
			while ( (len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			bout.flush();
			bout.close();
			bin.close();
			
			System.out.println("DONE");
		} 
		catch (Exception e) {
			e.printStackTrace();		
		}
	}

}
