package bronze1;

import java.util.Scanner;

public class vertical_read {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		int line_num = 0;
		char[][] charArr = new char[5][15];
		for (int i = 0; i < charArr[line_num].length; i++) charArr[line_num][i] = line.charAt(i);
		line_num++;
		
		while(line_num < 5) {
			line = sc.nextLine();
			for (int i = 0; i < charArr[line_num].length; i++) {
				if(i < line.length())	charArr[line_num][i] = line.charAt(i);
				else charArr[line_num][i] = '\0';
			}
			line_num++;
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(charArr[j][i] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
