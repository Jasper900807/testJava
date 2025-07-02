package tw.jasper.test;

public class test07 {

	public static void main(String[] args) {
		int year = 2024;
		
		// Sol.1	較小
		if ((year%4 == 0 && year%100 != 0) || year%400 == 0) System.out.printf("%d年是閏年", year);
		else System.out.printf("%d年是平年", year);
		
		// Sol.2	較快
		boolean isLeap;
		if (year%4 == 0) {
			if (year%100 == 0) {
				if (year%400 == 0) isLeap = true;
				else isLeap = false;
			}
			else isLeap = true;
		}
		else isLeap = false;
		
		System.out.printf("\n%d年為%s年", year, isLeap?"潤":"平");
	}
}
