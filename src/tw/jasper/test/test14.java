package tw.jasper.test;

public class test14 {

	public static void main(String[] args) {
		int[][] a;
		a = new int[3][4];
		
		// 2-step declaim
		int[][] b = new int[3][];
		b[0] = new int[3];
		b[1] = new int[4];
		b[2] = new int[2];	// 可以不同大小
		
		System.out.println(b.length);
		System.out.println(b[0].length);
		System.out.println(b[1].length);
		System.out.println(b[2].length);
		
		System.out.println("------------");
		
		for (int[] i:b) {
			for (int j:i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}
