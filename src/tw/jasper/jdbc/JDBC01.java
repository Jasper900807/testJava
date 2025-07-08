package tw.jasper.jdbc;

public class JDBC01 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
