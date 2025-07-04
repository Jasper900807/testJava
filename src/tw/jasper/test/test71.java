package tw.jasper.test;

public class test71 {
	
	public static void main(String[] args) {
		test711 obj1 = new test711();
		test712 obj2 = new test712();
		obj1.start();
		Thread t1 = new Thread(obj2);
		t1.start();
		
		
	}
}

class test711 extends Thread {
	@Override
	public void run() {
		System.out.println("711 : RUN thread");
	}
}

class test712 implements Runnable {
	@Override
	public void run() {
		System.out.println("712 : RUN");
	}
}
