package intermediate;

import java.util.*;

public class String1_palindrome {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String1_palindrome sol = new String1_palindrome();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			char[][] test_charArr = new char[8][8];
			int palindrome_len = Integer.parseInt(sc.nextLine());
			
			for(int column = 0; column < test_charArr.length; column++) {
				char[] inputLine_charArr = sc.nextLine().toCharArray();
				for(int row = 0; row< inputLine_charArr.length; row++) {
					test_charArr[column][row] = inputLine_charArr[row];
				}
			}
			int row_count = sol.countRowSearch(test_charArr,palindrome_len);
//			System.out.println("row_count: " + row_count);
			
			int col_count = sol.countColSearch(test_charArr, palindrome_len);
//			System.out.println("col_count: " + col_count);
			
			int match_count = row_count + col_count;
			
			System.out.println("#" + test_case + " " + match_count);
			
		}
	}

	public int countRowSearch(char[][] test_charArr, int palindrome_len) {
		int match_count = 0;
		
		for (int col = 0; col < test_charArr.length; col++) {
//			System.out.println("col: " + col);
			for (int row = 0; row < test_charArr[0].length - palindrome_len + 1; row++) {
				boolean palin_flag = true;
//				System.out.println("\trow: " + row);
				for(int index = row; index < index + palindrome_len/2 - (index-row); index++) {
//					System.out.println("\t\tindex: " + index + "\t compare: " + (row + palindrome_len - (index - row) -1));
					if(test_charArr[col][index] != test_charArr[col][(row + palindrome_len - (index - row) -1)]) {
						palin_flag = false;
						break;
					}
				}
				if(palin_flag == true)	match_count++;
			}	
		}
		
		return match_count;
	}
	
	public int countColSearch(char[][] test_charArr, int palindrome_len) {
		int match_count = 0;
		
		for (int row = 0; row < test_charArr.length; row++) {
//			System.out.println("row: " + row);
			for (int col = 0; col < test_charArr[0].length - palindrome_len + 1; col++) {
				boolean palin_flag = true;
//				System.out.println("\tcol: " + col);
				for(int index = col; index < index + palindrome_len/2 - (index-col); index++) {
//					System.out.println("\t\tindex: " + index + "\t compare: " + (col + palindrome_len - (index - col) -1));
					if(test_charArr[index][row] != test_charArr[(col + palindrome_len - (index - col) -1)][row]) {
						palin_flag = false;
						break;
					}
				}
				if(palin_flag == true)	match_count++;
			}	
		}
		
		return match_count;
	}
	
}
