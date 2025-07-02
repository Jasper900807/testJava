package tw.jasper.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class test52 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		File src = new File("dir1/coffee.jpg");
//		byte[] buffer = new byte [(int)src.length()];
		byte[] buffer = new byte [4096];
		
		try (FileInputStream fin = new FileInputStream(src);
				FileOutputStream fout = new FileOutputStream("dir2/coffee.jpg");) {
			int len;
			while ((len = fin.read(buffer)) != -1) {
				fout.write(buffer, 0, len);
			}
			
//			fin.read(buffer);
//			fout.write(buffer);
			fout.flush();
			
			System.out.println("DONE");
			System.out.println(System.currentTimeMillis() - start);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
