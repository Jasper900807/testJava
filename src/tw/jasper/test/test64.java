package tw.jasper.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class test64 {

	public static void main(String[] args) {
		File src = new File("dir1/test.jpg");
		byte[] buf = new byte[(int)src.length()];
		
		try {
			BufferedInputStream bin  = new BufferedInputStream(new FileInputStream(src));
			bin.read(buf);
			bin.close();
			
			Socket socket = new Socket(InetAddress.getByName("192.168.0.190"), 7777);
			BufferedOutputStream bout = new BufferedOutputStream(socket.getOutputStream());
			bout.write(buf);
			bout.flush();
			bout.close();
			System.out.println("send OK");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
