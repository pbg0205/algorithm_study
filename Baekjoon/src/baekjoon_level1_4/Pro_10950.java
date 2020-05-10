package baekjoon_level1_4;

import java.util.Scanner;

public class Pro_10950 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testNum = Integer.parseInt(sc.nextLine());
		
		for (int i = 1; i <= testNum; i++) {
			String[] sample = sc.nextLine().split(" ");
			int sample1 = Integer.parseInt(sample[0]);
			int sample2 = Integer.parseInt(sample[1]);

			System.out.println(sample1 + sample2);
		}
		
		sc.close();
	}
}
