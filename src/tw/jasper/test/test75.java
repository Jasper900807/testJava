package tw.jasper.test;

import java.nio.file.attribute.AclEntry;

public class test75 {

	public static void main(String[] args) {
		Store2 store = new Store2();
		Producer2 p = new Producer2(store);
		Consumer2 c1 = new Consumer2(store, "A");
		Consumer2 c2 = new Consumer2(store, "B");
		Consumer2 c3 = new Consumer2(store, "C");
		p.start();
		c1.start();
		c2.start();
	}
	
	

}

class Store2 {
	private int qty;
	private int MAX = 10;
	
	synchronized void add(int add) throws InterruptedException {
		System.out.printf("進貨中...%d\n", add);
		while (qty + add > MAX) {
			System.out.println("進貨等候中...");
			wait();
		}
		qty += add;
		System.out.printf("進貨完成(%d)...目前庫存量：%d\n", add, qty);
		notifyAll();
	}
	synchronized void buy(int buy, String name) throws InterruptedException {
		System.out.printf("%s:購買中...%d\n", name, buy);
		while (buy > qty) {
			System.out.println("買貨等候中...");
			wait();
		}
		qty -= buy;
		System.out.printf("%s:購買完成(%d)...目前庫存量：%d\n", name, buy, qty);
		notifyAll();
	}
	
}

class Producer2 extends Thread {
	private Store2 store;
	Producer2(Store2 store) {
		this.store = store;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				store.add(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer2 extends Thread {
	private Store2 store;
	private String name;
	public Consumer2(Store2 store, String name) {
		this.store = store;
		this.name = name;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				store.buy((int)(Math.random()*5+1), name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(300);
			} catch (Exception e) {
			}
		}
	}
	
}
