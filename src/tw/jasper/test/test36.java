package tw.jasper.test;

import java.util.HashSet;
import tw.jasper.apis.Member;

public class test36 {

	public static void main(String[] args) {
		Member m1 = new Member(1, "1111");
		Member m2 = new Member(2, "2222");
		Member m3 = new Member(1, "1122");
		Member m4 = new Member(1, "1133");
		
		HashSet<Member> members = new HashSet<>();
		members.add(m1);
		members.add(m2);
		members.add(m3);
		members.add(m4);
		
		System.out.println(members.size());
		System.out.println(members);
	}

}
