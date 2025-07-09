package tw.jasper.jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC13 {
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
			InputStream in = rs.getBinaryStream("icon");
			byte[] icon = in.readAllBytes();
			fout.write(icon);
			fout.flush();

			System.out.println("OK");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
