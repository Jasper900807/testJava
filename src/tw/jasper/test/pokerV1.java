package tw.jasper.test;

public class pokerV1 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] poker = new int[52];
		
		
		// 洗牌
		for (int i=0; i<poker.length; i++) {
			int rand = (int)(Math.random()*52);
			
			// 檢查是否重複
			boolean isRepeat = false;
			for (int j=0; j<i; j++) {
				if (rand == poker[j]) {
					isRepeat = true;
					break;
				}
			}
			
			if (!isRepeat) {
				poker[i] = rand;
//				System.out.println(poker[i]);
			}
			else {
				i--;
			}
		}
		System.out.println(System.currentTimeMillis() - start);
		
		// 發牌
		for (int i=0; i<52; i++) {
			
		}
		
		
		// 攤牌 + 理牌

	}

}
