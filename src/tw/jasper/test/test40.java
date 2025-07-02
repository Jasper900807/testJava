package tw.jasper.test;

import java.io.File;

public class test40 {
	public static void main(String[] args) {
		File f1 = new File("d:/dir1");
		if (f1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
			f1.mkdir();
		}
		
	}
}
