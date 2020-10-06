package baekjoon1978;
/*
 * @problem		소수 찾기(1978) : https://www.acmicpc.net/problem/1978
 * @author		pbg0205
 * @created by	09.23.20
 */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		boolean[] is_prime = new boolean[n+1];
		
		for (int input_num = m; input_num <= n; input_num++) {
			if(input_num == 1)	continue;
			is_prime[m] = true;
			for (int dividing_num = input_num / 2; dividing_num >= 2; dividing_num--) {
				if(input_num % dividing_num == 0) {
					is_prime[m] = false;
					break;
				}
			}
			if (is_prime[m]) System.out.println(input_num);
		}
		
		sc.close();
	}
}

//이상 : or_more
//이하 : or_below
// -> 시간 초과 다른 풀이 방법이 필요해보인다.