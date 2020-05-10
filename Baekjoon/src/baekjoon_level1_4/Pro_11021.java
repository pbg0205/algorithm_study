package baekjoon_level1_4;

import java.util.Scanner;

public class Pro_11021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <= n; i ++) {
			String line = sc.nextLine();
			String[] caseArr = line.split(" ");
			
			int a = Integer.parseInt(caseArr[0]);
			int b = Integer.parseInt(caseArr[1]);
			
			System.out.println("Case #" + i + ":"  + " "  + (a+b));
		}
	}
}
