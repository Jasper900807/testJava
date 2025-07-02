package tw.jasper.test;

import java.util.ArrayList;
import java.util.LinkedList;

import tw.jasper.apis.Member;

public class test37 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("111");
		list.add(0, "222");
		list.add(0, "333");
		list.add(0, "444");
		list.add(0, "555");
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(2));
		System.out.println("-----");
		
		
		Member m1 = new Member(1, "Brad");
		Member m2 = new Member(2, "Eric");
		Member m3 = new Member(2, "Tony");
		Member m4 = new Member(1, "Andy");
		LinkedList<Member> ms = new LinkedList<>();
		ms.add(m1);
		ms.add(m2);
		ms.add(m3);
		ms.add(m4);
		System.out.println(ms.size());
		System.out.println(ms);
	}

}
