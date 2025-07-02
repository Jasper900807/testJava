package tw.jasper.test;

public class test42 {

	public static void main(String[] args) {
		int a = 10, b = 0;
		int c;
		int[] d = {1,2,3,4};
		
		
		System.out.println("Start");
		try {
			c = a/b;			
			System.out.println(c);
			System.out.println(d[20]);
		}
//		catch (ArithmeticException e) {
//			System.out.println("Error1");
//		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error2");
		}
		catch (RuntimeException e) {
			System.out.printf("Error3 => %s", e);
		}
		
		System.out.println("DONE");
	}
}
