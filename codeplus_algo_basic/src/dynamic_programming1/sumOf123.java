package dynamic_programming1;

import java.util.Scanner;

public class sumOf123 {
	static int[] sum_of_123 = new int[12];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		
		sum_of_123[1] = 1;
		sum_of_123[2] = 2;
		sum_of_123[3] = 4;
		
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(sc.nextLine());

			for (int j = 4; j <= n; j++) {
				sum_of_123[j] = sum_of_123[j-1] + sum_of_123[j-2] + sum_of_123[j-3];
			}
			System.out.println(sum_of_123[n]);
		}
		
		sc.close();
	}
	
}
