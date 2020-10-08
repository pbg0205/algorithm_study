package baekjoon1874;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
 * @Problem      {스택수열(1874)}
 * @Author       {pbg0205}
 * @Created by   {08.30.20}
 */
class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = 1;// 나중에 입력해야 될 값
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Character> result = new ArrayList<Character>();
		/*
		 * 1. cnt <= data(입력 값): 입력 값까지 채워나간다.
		 * 2. cnt > data(입력 값)
		 *      - if(stack.peek() == data(입력 값)){stack.pop();}
		 *      - else(stack.peek() != data(입력 값)){ NO !}
		 *
		 */

		int test_case = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < test_case; i++) {
			int data = sc.nextInt();
			while (cnt <= data) {
				stack.push(cnt);
				cnt += 1;
				result.add('+');
			}

			if (stack.peek() == data) {
				stack.pop();
				result.add('-');
			}
			else {
				System.out.println("NO");
				return;
			}
		}

		/*성공 시, 결과 출력*/
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}