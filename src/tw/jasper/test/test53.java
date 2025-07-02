package tw.jasper.test;

import java.io.FileReader;

public class test53 {

	public static void main(String[] args) {
		FileReader reader;
		try {
			reader = new FileReader("dir1/file1.txt");
			int tmp;
			while ((tmp = reader.read()) != -1) {
				System.out.print((char)tmp);
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
