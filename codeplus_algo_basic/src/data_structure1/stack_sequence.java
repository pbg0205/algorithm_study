package data_structure1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class stack_sequence {
	//1,문제 제목 : 스택시퀀스
	//2. 문제 난이도 : 하(easy)
	//3. 문제 유형 : 스택, 그리디
	//4.추언 문제 풀이 시간 : 30분 -> 연습때는 x2로 계산해서 물기
	//5. 문제 풀이 여부 : X  -> 문제를 이해 못함 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = 1;
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Character> result = new ArrayList<Character>();
		
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
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
