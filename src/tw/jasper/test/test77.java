package tw.jasper.test;

import java.sql.Connection;
import java.util.List;

import tw.jasper.apis.Member;
import tw.jasper.apis.MemberDAO;
import tw.jasper.apis.MemberDAOImpl;
import tw.jasper.apis.testUtils;

public class test77 {

	public static void main(String[] args) {
		try(Connection conn = testUtils.getConnection()) {
			MemberDAO dao = new MemberDAOImpl(conn);		
			Member member = new Member();
			member.setAccount("john");
			member.setPasswd("123456");
			member.setName("Tony");
			dao.addMember(member);
//			
//			System.out.println("OK");				
//			Member member = dao.findById(3);
//			if (member!= null) {
//				member.setName("I am NO.3");
//				dao.updateMember(member);				
//			}
			
//			dao.delMember(3);
//			System.out.println("----");
//			List<Member> list = dao.findAll();
//			for (Member m: list) {
//				System.out.println(m.getName());
//			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
