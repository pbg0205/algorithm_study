package data_structure_ref;

import java.util.Scanner;

public class surffix_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		String[] strArr = new String[str.length()];
		for (int i = 0 ; i < str.length(); i++) strArr[i] = str.substring(i, str.length());
		
		for (int i = 0; i < strArr.length - 1; i++) {
			String min_str = strArr[i];
			int min_idx = i;
			for (int j = i + 1; j < strArr.length; j++) {
				String comp_str = strArr[j];
				if(min_str.compareTo(comp_str) > 0) {
					min_str = strArr[j];
					min_idx = j;
				}
			}
			if(min_str != strArr[i])	swap(strArr, i, min_idx);
		}
		
		for (String string : strArr) {
			System.out.println(string);
		}
		
		sc.close();
	}
	
	public static void swap(String[] strArr, int left_idx, int right_idx) {
		String temp = strArr[left_idx];
		strArr[left_idx] = strArr[right_idx];
		strArr[right_idx] = temp;
	}
}
