package baekjoon_level5_8;

import java.util.Scanner;

public class Pro_2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test_num = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <= test_num; i++) {
			int repeatNum = sc.nextInt();
			String str = sc.next();
			
			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < repeatNum; k++) {
					System.out.print(str.charAt(j));					
				}
			}
			sc.nextLine();
			System.out.println();
		}
	}
}
