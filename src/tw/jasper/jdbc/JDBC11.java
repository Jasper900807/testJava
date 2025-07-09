package tw.jasper.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.jasper.apis.BCrypt;
import tw.jasper.apis.Member;

public class JDBC11 {
	private static final String URL = "jdbc:mysql://localhost/test";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String LoginSQL = "SELECT * FROM member WHERE account = ?";
	private static final int LOGIN_ACCOUNT_FIELD = 1;
	private static final String UpdatePasswdSQL = "UPDATE member SET passwd = ? WHERE id = ?";
	private static final int UPDATE_PASSWD_FIELD = 1;
	private static final int UPDATE_ID_FIELD = 2;
	private static final String MEMBER_FIELD_ID = "id";
	private static final String MEMBER_FIELD_ACCOUNT = "account";
	private static final String MEMBER_FIELD_PASSWD = "passwd";
	private static final String MEMBER_FIELD_NAME = "name";
	
	private static Connection conn;

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account: ");
		String account = scanner.next();
		System.out.print("Password: ");
		String passwd = scanner.next();

		System.out.println("------");
		
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);

		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(LoginSQL);
			pstmt.setString(LOGIN_ACCOUNT_FIELD, account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String hashPasswd = rs.getString("passwd");
				if (BCrypt.checkpw(passwd, hashPasswd)) {
					int id = rs.getInt(MEMBER_FIELD_ID);
					String name = rs.getString("name");
					
					Member member = new Member(id, account, hashPasswd, name);
					
					System.out.println("Welcome, " + name);
					System.out.println("------");
					System.out.print("是否要修改密碼(Y/N): ");
					if (scanner.next().equals("Y")) {
						System.out.print("OLD passwd: ");
						String inputOldPasswd = scanner.next();
						if (passwd.equals(inputOldPasswd)) {
							System.out.print("NEW passwd: ");
							String inputNewPasswd = scanner.next();
							PreparedStatement pstmt2 = conn.prepareStatement(UpdatePasswdSQL);
							pstmt2.setInt(UPDATE_ID_FIELD, member.getId());
							pstmt2.setString(UPDATE_PASSWD_FIELD, BCrypt.hashpw(inputNewPasswd, BCrypt.gensalt()));
							if (pstmt2.executeUpdate() > 0) {
								System.out.println("Update Success");								
							}
							else {
								System.out.println("Update Failed");
							}
						}
						else {
							System.out.println("ERROR");
						}
					}
					
				}
				else {
					System.out.println("Login Failed");
				}
			}
			else {
				System.out.println("Login Failed");
			}
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
