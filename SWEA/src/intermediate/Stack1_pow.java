package intermediate;

import java.util.Scanner;

public class Stack1_pow {
	public long power(long base, long exp) {
		if(exp == 0) return 1;
		long answer = base;
		
		for (int i = 2; i <= exp; i++) {
			answer *= base;
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		Stack1_pow sol = new Stack1_pow();
		Scanner sc = new Scanner(System.in);
		
		int testNum = Integer.parseInt(sc.nextLine());
		String[] testline = sc.nextLine().split(" ");
		
		long base = Long.parseLong(testline[0]);
		long exp = Long.parseLong(testline[1]);
		
		System.out.println(sol.power(base, exp));
	}
}
