package tw.jasper.test;

import tw.jasper.apis.Bike;
import tw.jasper.apis.Scooter;


public class test18 {

	public static void main(String[] args) {
		Scooter s1 = new Scooter();
		s1.changeGear(4);
		s1.upSpeed();
		s1.upSpeed();
		s1.upSpeed();
		s1.downSpeed();
		System.out.println(s1.getSpeed());
		System.out.println(s1.getColor());
		
		Bike b1 = new Bike();
		b1.upSpeed();
		b1.upSpeed();
		b1.upSpeed();
		b1.downSpeed();
		System.out.println(b1.getSpeed());
	
	}

}
