package tw.jasper.test;

import java.io.FileOutputStream;
import java.io.IOException;

public class test70 {

	public static void main(String[] args) {
		System.out.println("START");
		
		new Thread() {
			public void run() {
				try {
					FileOutputStream fout = new FileOutputStream("dir1/test1.txt");
					fout.write("Hello world".getBytes());
					fout.flush();
					fout.close();
					System.out.println("OK");
					
				} 
				catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}.start();
		
		
		for (int i=0; i<10; i++) {
			System.out.println(i);
		}
		
		System.out.println("main DONE");

	}

}
