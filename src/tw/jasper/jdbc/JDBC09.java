package tw.jasper.jdbc;

import tw.jasper.apis.BCrypt;

public class JDBC09 {

	public static void main(String[] args) {
		String passwd = "123456";
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hashPasswd);
		
		String passwd1 = "123457";
		if ()

	}

}
