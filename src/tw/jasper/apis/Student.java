package tw.jasper.apis;

import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private int ch, eng, math;
	private Bike bike;
	
	public Student(String name, int ch, int eng, int math) {
		this.name = name;
		this.ch = ch;
		this.eng = eng;
		this.math = math;
		bike = new Bike();
	}
	
	public Bike getBike() {
		return bike;
	}

	public int sum() {return ch + eng + math; }
	public double avg() {return sum()/3; }

}
