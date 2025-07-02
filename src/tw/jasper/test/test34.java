package tw.jasper.test;

import java.util.HashSet;

import tw.jasper.apis.Bike;

public class test34 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("test");
		set.add(new Bike());
		set.add(123);
		set.add(12.3);
		System.out.println(set.size());
		set.add(123);
		set.add("test");
		set.add(true);
		System.out.println(set.size());
		System.out.println(set);
	}

}
