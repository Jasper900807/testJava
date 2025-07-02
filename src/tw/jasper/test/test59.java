package tw.jasper.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class test59 {

	public static void main(String[] args) {
		String msg = "quit";
		byte[] data = msg.getBytes();
		
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 8888);
			socket.send(packet);
			socket.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
