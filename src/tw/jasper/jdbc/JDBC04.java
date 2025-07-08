package tw.jasper.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC04 {
	
	

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", prop);) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("ID:");
			String id = scanner.next();
			System.out.print("Name:");
			String name = scanner.next();
			System.out.print("Tel:");
			String tel = scanner.next();
			System.out.print("Birthday");
			String birthday = scanner.next();
			String sql = "INSERT INTO cust (id, cname, tel, birthday) VALUES (?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			pstmt.setString(4, birthday);
			
			int n = pstmt.executeUpdate();
			if (n>0) {
				System.out.println("insert success");
			}
			else {
				System.out.println("insert fail");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
