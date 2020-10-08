package baekjoon10824;
/*
 * @problem		네 수(10824) : https://www.acmicpc.net/problem/10824
 * @author		pbg0205
 */

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String AB = "";
		String CD = "";
		
		AB += sc.next() + sc.next();
		CD += sc.next() + sc.next();
		
		long total_sum = Long.parseLong(AB) + Long.parseLong(CD);
		System.out.println(total_sum);
		
		sc.close();
	}
}
