package baekjoon11052;
/*
 * @problem		카드 구매하기(11052) : https://www.acmicpc.net/problem/11052
 * @author		pbg0205
 */
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cards_num = Integer.parseInt(sc.nextLine());
		
		int[] cards = new int[cards_num + 1];
		int[] price_max = new int[cards_num + 1];
		for (int i = 1; i <= cards_num; i++) cards[i] = sc.nextInt();
		
		for (int i = 1; i <= cards_num; i++) {
			for (int j = 1; j <= i; j++) {
				if(price_max[i] == 0 || price_max[i] < price_max[i-j] + cards[j]) {
					price_max[i] = price_max[i-j] + cards[j];
				}
			}
		}
		
		System.out.println(price_max[cards_num]);

		
		
		sc.close();
	}

}
