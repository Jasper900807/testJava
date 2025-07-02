package tw.jasper.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class test51 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		// 自動關閉
		try (	FileInputStream fin = new FileInputStream("dir1/coffee.jpg");
				FileOutputStream fout = new FileOutputStream("dir2/coffee.jpg")){
			int tmp;
			while ((tmp = fin.read()) != -1) {
				fout.write(tmp);
			}
			System.out.println("DONE");
			System.out.println(System.currentTimeMillis() - start);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
