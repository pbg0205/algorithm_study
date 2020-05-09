package baekjoon_fast;

import java.util.Scanner;

public class printQueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test_case = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= test_case; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int result = -1;
			
			sc.nextLine();
			
			int[] priority = new int[n];
			for (int j = 0; j < priority.length; j++)	priority[j] = sc.nextInt();
			
			result = 1; // 출력될 프린트 순서
			int want_priority = priority[m];// 내가 출력받고 싶은 문서의 중요도
			
			for(int k = 0 ; k < priority.length; k++)	if(want_priority < priority[k])	result++;
			for(int k = 0 ; k < priority.length; k++)	if(want_priority == priority[k] && k < m)	result++;
			
			sc.nextLine();
			System.out.println(result);
		}
		
		
		sc.close();
	}
}
