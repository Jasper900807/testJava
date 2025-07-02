package tw.jasper.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class test65 {

	public static void main(String[] args) {
		
		try (ServerSocket server = new ServerSocket(7777);){
			
			while (true) {
				try {
					
					Socket socket = server.accept();
					
					
					BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
					byte[] allData = bin.readAllBytes();
					bin.close();
					
					String urip = socket.getInetAddress().getHostAddress();
					BufferedOutputStream bout = new BufferedOutputStream(
							new FileOutputStream(String.format("upload/%s.jpg", urip)));
					bout.write(allData);
					bout.flush();
					bout.close();
					
					socket.close();
					
					System.out.println("receive OK");
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}

}
