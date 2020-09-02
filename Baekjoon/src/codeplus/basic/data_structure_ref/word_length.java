package codeplus.basic.data_structure_ref;

import java.util.Scanner;

public class word_length {
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
