package tw.jasper.test;

public class test33 {

	public static void main(String[] args) {
		String test = "123422";
		if (test.matches("[0-9]{6}")) {
			long count = test.chars().filter(c -> c=='2').count();
			System.out.println(count);
			System.out.println(test.chars());
			System.out.println("--------");
			test.chars().forEach(ch -> System.out.println((char)ch));
		}
		else {
			System.out.println("xx");
		}
	}

}
