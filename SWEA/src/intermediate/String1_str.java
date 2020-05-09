package intermediate;

import java.util.Scanner;

public class String1_str {
	public int count_searchStr(String search_str, String input_str) {
		int match_count = 0;
		
		for(int index = 0; index < input_str.length() - search_str.length() + 1; index++) {
			String input_substr = input_str.substring(index, index + search_str.length());
			if(search_str.equals(input_substr)) {
				match_count++;
			}
		}
		
		return match_count;
	}
	
	public static void main(String[] args) {
		String1_str sol = new String1_str();
		Scanner sc = new Scanner(System.in);
		
		for(int testCase = 1; testCase <= 10 ; testCase++) {
			int testNum = Integer.parseInt(sc.nextLine());
			String search_str = sc.nextLine();
			String input_str = sc.nextLine();
			
			System.out.println("#" + testCase+ " " + sol.count_searchStr(search_str, input_str));
		}
		
		
		sc.close();
	}
	
}
