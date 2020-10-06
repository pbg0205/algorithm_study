package baekjoon11655;
/*
 * @problem		ROT13(11655) : https://www.acmicpc.net/problem/11655
 * @author		pbg0205
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		char[] charArr = str.toCharArray();
		
		for (int i = 0; i < charArr.length; i++) {
			if('a' <= charArr[i] && charArr[i] <= 'z') {
				char temp = (char) (charArr[i] + 13);
				if(temp > 'z')	temp -= 26;
				charArr[i] = temp;
			}
			
			if('A' <= charArr[i] && charArr[i] <= 'Z') {
				char temp = (char) (charArr[i] + 13);
				if(temp > 'Z')	temp -= 26;
				charArr[i] = temp;
			}
		}
			String answer = String.valueOf(charArr);
			System.out.println(answer);
		
		sc.close();
	}
}
