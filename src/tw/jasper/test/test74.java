package tw.jasper.test;

import java.nio.file.attribute.AclEntry;

public class test74 {

	public static void main(String[] args) {
		Store store = new Store();
		Producer p = new Producer(store);
		Consumer c1 = new Consumer(store);
		Consumer c2 = new Consumer(store);
		Consumer c3 = new Consumer(store);
		p.start();
		c1.start();
	}
	
	

}

class Store {
	private int qty;
	private int MAX = 10;
	void add(int add) {
		System.out.printf("進貨中...%d\n", add);
		while (qty + add > MAX) {
//			System.out.println("wait(1)");
		}
		qty += add;
		System.out.printf("進貨完成(%d)...目前庫存量：%d\n", add, qty);
	}
	void buy(int buy) {
		System.out.printf("購買中...%d\n", buy);
		while (buy > qty) {
//			System.out.println("wait(2)");
		}
		qty -= buy;
		System.out.printf("購買完成(%d)...目前庫存量：%d\n", buy, qty);
	}
	
}

class Producer extends Thread {
	private Store store;
	Producer(Store store) {
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
			store.add(5);
		}
	}
}

class Consumer extends Thread {
	private Store store;
	public Consumer(Store store) {
		this.store = store;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				Thread.sleep(300);
			} catch (Exception e) {
			}
			store.buy((int)(Math.random()*5+1));
		}
	}
	
}
