package baekjoon10809;
/*
 * @problem		알파벳 찾기(10809) : https://www.acmicpc.net/problem/10809
 * @author		pbg0205
 */

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int[] alpha = new int[26];
		for (int i = 0; i < str.length(); i++) {
			int location_of_alpha = str.charAt(i) - 'a';
			alpha[location_of_alpha]++;
		}
		
		for (int i : alpha) {
			System.out.print(i + " ");
		}
		
		sc.close();
	}
}
