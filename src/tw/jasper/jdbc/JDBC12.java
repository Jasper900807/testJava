package tw.jasper.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JDBC12 {
	private static final String URL = "jdbc:mysql://localhost/test";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String UpdateSQL = "UPDATE member SET icon = ? WHERE id = ?";
	
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try (FileInputStream fin = new FileInputStream("dir3/ball.png");
				Connection conn = DriverManager.getConnection(URL, prop);) {
			
			
			PreparedStatement pstmt = conn.prepareStatement(UpdateSQL);
			pstmt.setBinaryStream(1, fin);
			pstmt.setInt(2, 1);
			
			pstmt.executeUpdate();
			System.out.println("OK");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
