package data_structure_ref;

import java.util.Scanner;

public class ROT13 {
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
