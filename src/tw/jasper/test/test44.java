package tw.jasper.test;

public class test44 {

	public static void main(String[] args) {
		test441 obj = new test441();
		try {
			obj.m1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class test441 {
	void m1() throws Exception {
		m2();
	}
	void m2() throws Exception {
		m3();
	}void m3() throws Exception {
		System.out.println("m3()");
		throw new Exception();
	}
}