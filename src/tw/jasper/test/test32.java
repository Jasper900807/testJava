package tw.jasper.test;

public class test32 {

	public static void main(String[] args) {
		Order obj1 = new Order1("D001", 100);
		Order obj2 = new Order2("P001", 123);
		obj1.paid();
		obj1.notifyCust();
		obj1.process();
		System.out.println("----------");
		obj2.paid();
		obj2.notifyCust();
		obj2.process();
	}

}
interface Shipable {
	void ship();
}
abstract class Order {
	private String orderId;
	private int amount;
	Order(String orderId, int amount) {
		this.orderId = orderId;
		this.amount = amount;
	}
	void paid() { System.out.println("Already paid");}
	void notifyCust() {System.out.println("notify customer");}
	abstract void process();
}
class Order1 extends Order {
	Order1(String orderId, int amount) {
		super(orderId, amount);
	}
	void process() {
		System.out.println("數位商品出貨");
	}
}
class Order2 extends Order implements Shipable{
	Order2(String orderId, int amount) {
		super(orderId, amount);
	}
	void process() {
		System.out.println("實體商品準備出貨");
		ship();
	}
	public void ship() {
		System.out.println("已出貨");
	}
}