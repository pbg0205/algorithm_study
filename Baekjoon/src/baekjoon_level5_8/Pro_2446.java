package baekjoon_level5_8;

import java.util.Scanner;

public class Pro_2446 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testNum = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <testNum * 2 ; i++) {
			if(i <= testNum) {
				for(int j = 1; j < i; j++)	System.out.print(" ");
				for(int k = 1; k <= 2 * (testNum-i+1) - 1 ; k++)	System.out.print("*");
				System.out.println();
			}
			if( i > testNum) {
				for(int j = 1; j < testNum * 2- i; j++) System.out.print(" ");
				for(int k = 1; k <= (i-testNum) * 2 + 1; k++) System.out.print("*");
				System.out.println();
			}
		}
		sc.close();
	}
}
