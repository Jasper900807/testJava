package tw.jasper.test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.jasper.apis.Student;

public class test56 {

	public static void main(String[] args) {

		try (FileInputStream fin = new FileInputStream("dir1/test.score");
				ObjectInputStream oin = new ObjectInputStream(fin)){
			
			Object obj = oin.readObject();
//			if (obj instanceof Student) {System.out.println("Is Student");}
			
			Student s1 = (Student)obj;
			System.out.println(s1.sum());
			System.out.println(s1.avg());
			System.out.println(s1.getBike().getSpeed());
			
			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
