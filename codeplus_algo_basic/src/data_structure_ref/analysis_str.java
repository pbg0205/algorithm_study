package data_structure_ref;

import java.util.Scanner;

public class analysis_str {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			int[] analysis_alpha = new int[4];
			
			for (int i = 0; i < str.length(); i++) {
				if('a' <= str.charAt(i) && str.charAt(i) <= 'z') analysis_alpha[0]++;
				if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') analysis_alpha[1]++;
				if('0' <= str.charAt(i) && str.charAt(i) <= '9') analysis_alpha[2]++;
				if(str.charAt(i) == ' ') analysis_alpha[3]++;
			}
			
			for (int out : analysis_alpha) {
				System.out.print(out + " ");
			}
			System.out.println();
		}
		
		
		sc.close();
	}
}
