package tw.jasper.test;

import java.io.File;

public class test45 {

	public static void main(String[] args) {
		File root = new File(".");
		System.out.println(root.getAbsolutePath());
		File dir1 = new File("dir4/dir5/dir6");
		System.out.println(dir1.exists());
		System.out.println(dir1.mkdirs());
	}
}
