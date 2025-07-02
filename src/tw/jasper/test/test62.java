package tw.jasper.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class test62 {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(9999);
			Socket socket = server.accept();
			
			String urip = socket.getInetAddress().getHostName();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line;
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			System.out.printf("%s : %s\n", urip, sb.toString());
			
			socket.close();
			System.out.println("DONE");
			
		}
		catch (IOException e) {
			e.printStackTrace(); 
		}
		finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
