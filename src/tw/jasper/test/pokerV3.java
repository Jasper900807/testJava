package tw.jasper.test;

import java.util.Arrays;

public class pokerV3 {
	
	public static void main(String[] args) {
		int[] poker = new int[52];
		
		// 洗牌
		for (int i=0; i<poker.length; i++) {
			poker[i] = i;
		}
		
		for (int i=poker.length-1; i>0; i--) {
			int rand = (int)(Math.random()*i);
			// swap
			int temp = poker[i];
			poker[i] = poker[rand];
			poker[rand] = temp;
		}
		
//		for (int i=0; i<poker.length; i++) {
//			System.out.print(poker[i] + " ");
//		}
//		System.out.println("\n---");
		
		// 發牌
		int[][] players = new int[4][13];
		for (int i=0; i<52; i++) {
			players[i%4][i/4] = poker[i];
		}
		
		String[] suits = {"黑桃", "愛心", "菱形", "梅花"};
		String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

		
		for (int[] player:players) {
			// 理牌
			Arrays.sort(player);
			for (int card: player) {
				System.out.print(suits[card/13] + values[card%13] + " ");
			}
			System.out.println();
		}
		
		
		
	}
	
}
