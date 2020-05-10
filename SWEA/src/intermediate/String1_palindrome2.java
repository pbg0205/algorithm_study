package intermediate;

import java.util.*;

public class String1_palindrome2 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String1_palindrome2 sol = new String1_palindrome2();
		int MaxValue = 0;
		for (int test_case = 1; test_case <= 10; test_case++) {
			char[][] test_charArr = new char[100][100];
			int test_num = Integer.parseInt(sc.nextLine());

			for (int column = 0; column < test_charArr.length; column++) {
				char[] inputLine_charArr = sc.nextLine().toCharArray();
				for (int row = 0; row < inputLine_charArr.length; row++) {
					test_charArr[column][row] = inputLine_charArr[row];
				}
			}

			MaxValue = sol.getpalinMax_row(test_charArr);
			int col_max = sol.getPalinMax_col(test_charArr);

			if (MaxValue < col_max)
				MaxValue = col_max;

			System.out.println("#" + test_case + " " + MaxValue);

		}
	}

	private int getpalinMax_row(char[][] test_charArr) {
		int maxValue_row = 0;
		int palin_len = 100;
		
		loop: while (palin_len >= 1) {

			for (int col = 0; col < test_charArr.length; col++) {
//			System.out.println("col: " + col);
				for (int row = 0; row < test_charArr[0].length - palin_len + 1; row++) {
					boolean palin_flag = true;
//				System.out.println("\trow: " + row);
					for (int index = row; index < index + palin_len / 2 - (index - row); index++) {
//					System.out.println("\t\tindex: " + index + "\t compare: " + (row + palindrome_len - (index - row) -1));
						if (test_charArr[col][index] != test_charArr[col][(row + palin_len - (index - row) - 1)]) {
							palin_flag = false;
							break;
						}
					}
					if (palin_flag == true) {
						maxValue_row = palin_len;
						break loop;
					}
				}
			}
			palin_len--;
		}
		return maxValue_row;
	}

	private int getPalinMax_col(char[][] test_charArr) {
		int maxValue_col = 0;
		int palin_len = 100;

		loop: while (palin_len >= 1) {

			for (int row = 0; row < test_charArr.length; row++) {
//			System.out.println("row: " + row);
				for (int col = 0; col < test_charArr[0].length - palin_len + 1; col++) {
					boolean palin_flag = true;
//				System.out.println("\tcol: " + col);
					for (int index = col; index < index + palin_len / 2 - (index - col); index++) {
//					System.out.println("\t\tindex: " + index + "\t compare: " + (col + palindrome_len - (index - col) -1));
						if (test_charArr[index][row] != test_charArr[(col + palin_len - (index - col) - 1)][row]) {
							palin_flag = false;
							break;
						}
					}
					if (palin_flag == true) {
						maxValue_col = palin_len;
						break loop;
					}
				}
			}
			palin_len--;
		}
		return maxValue_col;
	}
	
}
