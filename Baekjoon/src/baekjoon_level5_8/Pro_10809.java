package baekjoon_level5_8;

import java.util.Arrays;
import java.util.Scanner;

public class Pro_10809 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		
		Pro_10809 sol = new Pro_10809();
		sol.getAlphabetLocation(word);
		
		sc.close();
	}

	private void getAlphabetLocation(String word) {
		char[] word_charArr = word.toCharArray();
		int[] alphabet_arr = new int[26];
		Arrays.fill(alphabet_arr, -1);
		
		for (int index = 0; index < word_charArr.length; index++) {
			int alphabet_index = (int)(word_charArr[index] - 'a');
			if(alphabet_arr[alphabet_index] == -1)	alphabet_arr[alphabet_index] = index;
		}
		
		for(int out : alphabet_arr) {
			System.out.print(out + " ");
		}
	}
}
