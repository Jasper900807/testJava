package tw.jasper.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC02 {
	public static void main(String[] args) {
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", prop)){
			String sql = "INSERT INTO cust (id, cname, tel, birthday) VALUES (2, 'yony', '123', '1957-5-8')";
			Statement stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if (n>0) {
				System.out.println("insert success");
			}
			else {
				System.out.println("insert fail");
			}
			System.out.println("-----");
			sql = "DELETE FROM cust WHERE id = 2";
			stmt.executeUpdate(sql);
//			System.out.println("-----");
//			sql = "UPDATE cust SET tel='456' WHERE id = 3";
//			stmt.executeUpdate(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
