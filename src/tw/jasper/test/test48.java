package tw.jasper.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class test48 {

	public static void main(String[] args) {
		File f1 = new File("dir1/file1.txt");
		
		try {
			FileInputStream fin = new FileInputStream(f1);
			
			int temp;
			do {
				temp = fin.read();
				System.out.print((char)temp);
			} while (temp != -1);
			
			
			fin.close();
			System.out.println("\n---------\nOK");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
