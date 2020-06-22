package bronze1;

import java.util.Scanner;

public class word_study {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] alpha_count = new int[26];
		String word = sc.nextLine();
		
		for(int i = 0 ; i < word.length(); i++) {
			if(word.charAt(i) - 'a' >= 0 && word.charAt(i) - 'z' <= 0 ) {
				alpha_count[word.charAt(i) - 'a']++;
			}else if(word.charAt(i) - 'A' >= 0  && word.charAt(i) - 'Z' <= 0) {
				alpha_count[word.charAt(i) - 'A']++;
			}
		}
		
		int count_max = 0;
		int max_idx = 0;
		for(int i = 0 ; i < alpha_count.length; i++) {
			if(count_max <= alpha_count[i]) {
				count_max = alpha_count[i];
				max_idx = i;
			}
		}
		
		boolean duplicate_max = false;
		for(int i = 0 ; i < alpha_count.length; i++) {
			if(count_max == alpha_count[i]) {
				if(i == max_idx) {
					continue;
				}
				else if(i != max_idx) {
					duplicate_max = true;
					break;
				}
			}
		}
		
		if(duplicate_max)	System.out.println("?");
		else if(!duplicate_max)	System.out.println((char)(max_idx + 'A'));
		
		
		sc.close();
	}
}
