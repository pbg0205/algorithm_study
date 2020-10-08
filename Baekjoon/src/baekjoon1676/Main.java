package baekjoon1676;
/*
 * @problem		팩토리얼 0의 개수(1676) : https://www.acmicpc.net/problem/1676
 * @author		pbg0205
 * @created by	09.23.20
 */
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		int input = 1;
		int five_count = 0;
		
		for(int i = 1; i <= n; i++) {
			input = i;
			
			while(input % 2 == 0 || input % 5 == 0) {
				if(input % 2 == 0)	input /= 2;
				if(input % 5 == 0) {
					input /= 5;
					five_count++;
				}
			}
		}
		
		System.out.println(five_count);
		
		sc.close();
	}
}
