package tw.jasper.test;

import tw.jasper.apis.Bike;

public class test17 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		

		System.out.println(b1.getSpeed());
		System.out.println(b2.getSpeed());
		System.out.println("----");
		
		while(b1.getSpeed() <20 ) {
			b1.upSpeed();
		}
		
		System.out.println(b1.getSpeed());

	}

}
