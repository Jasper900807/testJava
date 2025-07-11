package tw.jasper.test;

import java.sql.Connection;
import java.sql.SQLException;

import tw.jasper.apis.Member;
import tw.jasper.apis.MemberDAO;
import tw.jasper.apis.MemberDAOImpl;
import tw.jasper.apis.testUtils;

public class test78 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = testUtils.getConnection();
			conn.setAutoCommit(false);
			MemberDAO dao = new MemberDAOImpl(conn);		
			Member m1 = dao.findById(4);
			Member m2 = dao.findById(1);

			
			m1.setName("4444444");
			dao.updateMember(m1);
			
			System.out.println(10/3);
			
			m2.setName("11111");
			dao.updateMember(m2);
			
			
			System.out.println("OK");
			conn.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
					System.out.println("rollback");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
			}
		}
		finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

	}

}
