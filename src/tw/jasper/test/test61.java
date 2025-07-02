package tw.jasper.test;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class test61 {

	public static void main(String[] args) {
		String msg = "hello";
		try {
			Socket socket = new Socket(InetAddress.getByName("192.168.0.190"), 9999);
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.append(msg);
//			pw.println();
			pw.flush();
			pw.close();
			
			socket.close();
			System.out.println("OK");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
