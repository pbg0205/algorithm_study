package baekjoon6588;
/*
 * @problem		골드바흐의 추측(6588) : https://www.acmicpc.net/problem/6588
 * @author		pbg0205
 */
import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	public static boolean[] is_prime;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1.에라토스테네스의 체로 소수 구하기
		is_prime = new boolean[1000001];
		Arrays.fill(is_prime, true);
		for (int input_num = 2; input_num < is_prime.length; input_num++) {
			for (int mul_num = 2; input_num * mul_num < is_prime.length; mul_num++) {
				is_prime[input_num * mul_num] = false;
			}
		}
		//2.합의 대칭성을 이용해서 답을 얻기
		while(true) {
			int test_num = Integer.parseInt(sc.nextLine());
			boolean is_wrong = true;
			if(test_num == 0)	break;
			for (int i = 2; i <= test_num / 2 ; i++) {
				if(is_prime[i] && is_prime[test_num-i]) {
					System.out.printf("%d = %d + %d\n", test_num, i, test_num - i);
					is_wrong = false;
					break;
				}
			}
			if(is_wrong)	System.out.println("Goldbach's conjecture is wrong.");
		}
		
		sc.close();
	}
}