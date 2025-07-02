package tw.jasper.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class test57 {

	public static void main(String[] args) {
		test573 obj = new test573();
		try {
			ObjectOutputStream oout = new ObjectOutputStream(
					new FileOutputStream("dir1/test571.obj"));
			
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("-----------");
		
		try {
			ObjectInputStream oin = new ObjectInputStream(
					new FileInputStream("dir1/test571.obj"));
			
			Object obj2 = oin.readObject();
			oin.close();
			System.out.println("OK2");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
class test571 implements Serializable {
	test571() {
		System.out.println("571");
	}
}

class test572 extends test571 {
	test572() {
		System.out.println("572");
	}
}

class test573 extends test572 {
	test573() {
		System.out.println("573");
	}
}