package tw.jasper.test;

import java.io.File;
import java.io.IOException;

public class test41 {

	public static void main(String[] args) {
		File f1 = new File("d:/dir1/file123");
		if (!f1.exists()) {
			try {
				if (f1.createNewFile()) {
					System.out.println("OK");
				}
				else {
					System.out.println("XX");
				}
				System.out.println("OK2");
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		else {
			System.out.println("exist");
		}
	}
}
