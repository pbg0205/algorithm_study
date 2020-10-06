package baekjoon16194;
/*
 * @problem		카드 구매하기2(16194) : https://www.acmicpc.net/problem/16194
 * @author		pbg0205
 */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cards_num = Integer.parseInt(sc.nextLine());
		
		int[] cards = new int[cards_num + 1];
		int[] price_min = new int[cards_num + 1];
		for (int i = 1; i <= cards_num; i++)	cards[i] = sc.nextInt();
		
		for (int i = 1; i <= cards_num; i++) {
			for (int j = 1; j <= i; j++) {
				if(price_min[i] == 0 || price_min[i] > price_min[i-j] + cards[j]){
					price_min[i] = price_min[i-j] + cards[j];
				}
			}
		}
		
		System.out.println(price_min[cards_num]);
		
		sc.close();
	}
}
