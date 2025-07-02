package tw.jasper.test;

public class test11 {

	public static void main(String[] args) {
		// 不用陣列
//		int d0, d1, d2, d3, d4, d5, d6;
//		d0 = d1 = d2 = d3 = d4 = d5 = d6 = 0;
//		for (int i=0; i<100; i++) {
//			int num = (int)(Math.random()*6) + 1;
//			switch (num) {
//			case 1: d1++; break;
//			case 2: d2++; break;
//			case 3: d3++; break;
//			case 4: d4++; break;
//			case 5: d5++; break;
//			case 6: d6++; break;
//			default: d0++;	// 檢查用
//			}
//		}
//		if (d0 == 0) {
//			System.out.printf("(%d, %d, %d, %d, %d, %d)\n", d1, d2, d3, d4, d5, d6);			
//		}
//		else System.out.println("Error");
//		
//		System.out.println("-----------------------");
	
		//使用陣列
		int[] arr;
		arr = new int[7];
		for (int i=0; i<100000; i++) {
			int num = (int)(Math.random()*9) + 1;
			if (num>= 1 && num<=9) {
				arr[num<=6?num:num-3]++;				
			}
			else {
				arr[0]++;
			}
		}
		if (arr[0] == 0) {
			for (int i=1; i<arr.length; i++) {
				System.out.printf("%d: %f%% \n", i, (float)arr[i]/1000);			
			}
		}
		else {
			System.out.println("Error");
		}
	}
}
