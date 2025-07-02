package tw.jasper.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test46 {

	public static void main(String[] args) {
		String msg = "Hello world\nabcde\n123456789";
		byte[] buffer = msg.getBytes();
		
		try {
			FileOutputStream fout = new FileOutputStream("dir1/file1.txt");
			fout.write(buffer);
			
			fout.flush();
			fout.close();
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
