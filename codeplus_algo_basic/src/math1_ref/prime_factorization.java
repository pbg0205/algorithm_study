package math1_ref;

import java.util.Arrays;
import java.util.Scanner;
//문제 : 소인수분해(11653)
public class prime_factorization {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] is_prime = get_isPrime(n);
		
		int idx = 2;
		while(n >= idx) {
			if(is_prime[idx] = true)	
				while(n % idx == 0) {
					if(n == 0)	break;
					n /= idx;
					System.out.println(idx);
				}	
			idx++;
		}
		
		sc.close();
	}
	
	public static boolean[] get_isPrime(int n) {
		boolean[] tempArr = new boolean[n + 1];
		Arrays.fill(tempArr, true);
		
		for (int i = 2; i <= n; i++) {
			for (int j = 2; i * j <= n; j++) {
				if(n % i == 0)	tempArr[i * j] = false;
			}
		}
		return tempArr;
	}
}
