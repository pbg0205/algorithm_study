package baekjoon2743;
/*
 * @problem		단어 길이 재기(2743) : https://www.acmicpc.net/problem/2743
 * @author		pbg0205
 */
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int num_of_alpha = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if('a' <= str.charAt(i) && str.charAt(i) <= 'z')	num_of_alpha++;
			if('A' <= str.charAt(i) && str.charAt(i) <= 'Z')	num_of_alpha++;
		}
		
		System.out.println(num_of_alpha);
		
		
		sc.close();
	}
}
