package tw.jasper.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class testUtils {
	private static final String URL = "jdbc:mysql://localhost/test";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() throws Exception {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		return DriverManager.getConnection(URL, prop);
	}
}
