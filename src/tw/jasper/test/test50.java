package tw.jasper.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class test50 {

	public static void main(String[] args) {
		File f1 = new File("dir1/file1.txt");
		byte[] buf = new byte[3];
		try {
			FileInputStream fin = new FileInputStream(f1);
			
			int len;
			System.out.print(new String(buf));
			
			fin.close();
			System.out.println("\n---------\nOK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
