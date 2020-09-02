package codeplus.basic.data_structure_ref;

import java.util.Scanner;

public class num_of_alphabet {
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
