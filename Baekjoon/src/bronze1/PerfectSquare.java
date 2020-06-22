package bronze1;

import java.util.Scanner;

public class PerfectSquare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = Integer.parseInt(sc.nextLine());
		int n = Integer.parseInt(sc.nextLine());
		
		int sum = 0;
		int perfect_min = 9999;
		int perfect_root = 1;
		while(n >= (int)Math.pow(perfect_root,2)) {
			if(m <= (int)Math.pow(perfect_root,2)) {
				sum += (int)Math.pow(perfect_root,2);
			}
			perfect_root++;
		}
		
		sc.close();
	}
}
