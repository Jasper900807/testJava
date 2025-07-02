package tw.jasper.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class test58 {

	public static void main(String[] args) {
		try {
			InetAddress[] ips = InetAddress.getAllByName("www.hinet.net");
			for (InetAddress ip : ips) {
				System.out.println(ip.getHostAddress());
			}
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
