package tw.jasper.test;

public class test04 {

	public static void main(String[] args) {
		// float: 2^32 double: 2^64
		float var1 = 123;
		float var2 = 123.1f;
		double var3 = 123.9;
		float var4 = var1/var2;
		System.out.println(var4);
		
		double var5 = 10;
		double var6 = 3;
		double var7 = var5/var6;
		System.out.println(var7);
	}

}
