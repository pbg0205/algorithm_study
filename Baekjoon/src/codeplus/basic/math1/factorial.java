package codeplus.basic.math1;

import java.util.Scanner;

public class factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.nextLine());
		
		System.out.println(factorial1(n));
		
		sc.close();
	}
	
	public static long factorial1(Long n) {
		if(n == 1 || n == 0)	return 1;
		else	return factorial1(n-1) * n;
	}
}
