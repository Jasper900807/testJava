package tw.jasper.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class test54 {

	public static void main(String[] args) {

		File src = new File("dir1/ns1hosp.csv");
		
		
		try (	FileReader reader = new FileReader(src);
//				FileInputStream fin = new FileInputStream(src);
//				InputStreamReader isr = new InputStreamReader(fin);
				BufferedReader br = new BufferedReader(reader);){
			String line;
			while ((line = br.readLine()) != null) {
				String[] row = line.split(","); 
				System.out.printf("%s:\t%s\n", row[2], row[7]);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
