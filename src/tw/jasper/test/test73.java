package tw.jasper.test;

public class test73 {

	public static void main(String[] args) {
		test731 b1 = new test731("A", 10);
		test731 b2 = new test731("B", 20);
		b1.start();
		b2.start();
		System.out.println("main start");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		
		try {
			b1.join();
		} catch (InterruptedException e) {
		}
		System.out.println("main finish");
	}

	

}

class test731 extends Thread {
	private String name;
	private int count;
	test731(String name, int count) {
		this.name = name;
		this.count = count;
	}
	public void run() {
		for (int i=0; i<count; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
