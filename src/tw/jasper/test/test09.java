package tw.jasper.test;

public class test09 {
	public static void main(String[] args) {
		int i=0;
		for (; i<10;) {
			System.out.println(i++);;
		}
		System.out.println("-------");
		System.out.println(i);
		printBrad();
	}
	
	static void printBrad() {
		System.out.println("Brad");
	}
	
	static void sysout() {
		System.out.println("--------");
	}

}
