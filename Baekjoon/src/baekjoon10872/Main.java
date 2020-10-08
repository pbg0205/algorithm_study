package baekjoon10872;
/*
 * @problem		팩토리얼(10872) : https://www.acmicpc.net/problem/10872
 * @author		pbg0205
 */
import java.util.Scanner;

class Main {
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
