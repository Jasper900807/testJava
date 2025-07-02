package tw.jasper.test;

public class test63 {

	public static void main(String[] args) {
		m1();

	}
	
	static void m1() {
		int a=10, b=0;
		int c;
		try {
			c = a/b;
			System.out.println(c);
			return;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("finally");
		}
		System.out.println("OK");
	}

}
