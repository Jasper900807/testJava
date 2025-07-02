package tw.jasper.test;

public class test99 {
	
	public static void main(String[] args) {
		final int ROWS = 2;
		final int COLS = 4;
		final int START = 2;
		
		
		for (int k=0; k<ROWS; k++) {			
			for (int j=1; j<=9; j++) {
				for (int i=START; i<START+COLS; i++) {
					System.out.printf("%d x %d = %d\t", i+COLS*k, j, (i+COLS*k)*j);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
