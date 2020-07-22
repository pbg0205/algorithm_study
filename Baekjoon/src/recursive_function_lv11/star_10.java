package recursive_function_lv11;

import java.util.Arrays;
import java.util.Scanner;

public class star_10 {
	static char arr[][];
	public static void recur_star(int a, int b, int n) {
		int div= 0;
		if(n==1) {
			arr[a][b] = '*';
			return;
		}
		
		div = n/3;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == 1 && j == 1)	continue;
				recur_star(a + (div * i), b + (div * j), div);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		arr = new char[n][n];
		
		for (int row = 0; row < n; row++) {
			Arrays.fill(arr[row], ' ');
		}
		
		recur_star(0,0,n);
		for (int row = 0; row < n; row++) {
			System.out.println(arr[row]);
		}
		
		sc.close();
	}
}
