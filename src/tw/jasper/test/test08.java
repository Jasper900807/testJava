package tw.jasper.test;

public class test08 {

	public static void main(String[] args) {
		int month = 2;
		int day;
		
		switch (month) {
		case 1,3,5,7,8,10,12: day = 31; break;
		case 4,6,9,11: day = 30; break;
		case 2: day = 28; break;
		default: day = -1;
		}
		
		System.out.printf("%d月有%d天", month, day);

	}

}
