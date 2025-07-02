package tw.jasper.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.jasper.apis.Student;

public class test55 {

	public static void main(String[] args) {
		Student s1 = new Student("test", 76, 87, 32);
		System.out.println(s1.sum());
		System.out.println(s1.avg());
		System.out.println(s1.getBike().upSpeed().upSpeed().upSpeed().upSpeed().getSpeed());
		
		
		
		try {
			FileOutputStream fout = new FileOutputStream("dir1/test.score");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(s1);
			
			// fout和oout串在一起 只需close()其中一個
			fout.flush();
			fout.close();

			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
