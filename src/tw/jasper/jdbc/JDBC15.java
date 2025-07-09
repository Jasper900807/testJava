package tw.jasper.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.jasper.apis.Bike;

public class JDBC15 {
	private static final String URL = "jdbc:mysql://localhost/test";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String QuerySQL = "SELECT * FROM member WHERE id = ?";
	
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try (FileOutputStream fout = new FileOutputStream("dir3/test.png");
				Connection conn = DriverManager.getConnection(URL, prop);) {
			
			PreparedStatement pstmt = conn.prepareStatement(QuerySQL);
			pstmt.setInt(1, 1);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			// False, but why?
//			Object obj2 = rs.getObject("bike");
//			if (obj2 instanceof Bike) {
//				System.out.println("Y");
//			}
//			else {
//				System.out.println("N");
//			}
			
			// Correct
			InputStream in = rs.getBinaryStream("bike");
			ObjectInputStream oin = new ObjectInputStream(in);
			Object obj = oin.readObject();
			Bike bike = (Bike)obj;
			System.out.println(bike.getSpeed());
			
			oin.close();

			System.out.println("OK");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
