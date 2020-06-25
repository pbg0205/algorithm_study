package math1;

import java.util.Arrays;
import java.util.Scanner;

public class Goldbach_conjecture {
	
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

//시도1. 이중 for문
//시도2. arraylist -> 생각해보니 어차피 시간복잡도가(O(n^2)이었다.
//시도3. stack 사용하기
//시도4. deque로 문제 풀기 -> deque : 
/*
 * 1.양쪽을 poll해서 합 확인
 * 2.만약 test_num >= 합
 * 	2-1. 앞쪽 poll해서 값비교
 *  2-2. 뒤쪽 poll해서 값비교
 *3. 일치하면 출력(아니면, 둘다 poll) -> 계속 진행
 */