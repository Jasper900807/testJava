package tw.jasper.test;

import tw.jasper.apis.TWId;

public class test25 {

	public static void main(String[] args) {
		System.out.println(TWId.isRightID("A123456789"));
		System.out.println(Math.PI);
		System.out.println("----");
		TWId id1 = new TWId();
		TWId id2 = new TWId(false);
		TWId id3 = new TWId('B');
		TWId id4 = new TWId(true, 'A');
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
		
//		TWId id5 = TWId.createTWId("A123456787");
//		if (id5 != null) {
//			System.out.println(id5.getId());
//		}else {
//			System.out.println("xxxxx");
//		}
		
		TWId id5;
		try {
			id5 = TWId.createTWId("A123456789");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
