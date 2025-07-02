package tw.jasper.apis;

public class Scooter extends Bike {

	private int gear;
	private String color;
	
	public Scooter() {
		System.out.println("scooter()");
		color = "red";
	}
	
	public Scooter upSpeed() {
		if (gear > 0) {
			speed = speed < 1 ? 1 : speed*1.8*gear;			
		}
		return this;
	}
	
	public String getColor() {
		return color;
	}
	
	public int changeGear(int gear) {
		if (gear >= 0 && gear <= 4) {
			this.gear = gear;			
		}
		
		return this.gear;
	}

}
