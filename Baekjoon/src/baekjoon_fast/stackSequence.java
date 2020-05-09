package baekjoon_fast;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class stackSequence {
	//1,문제 제목 : 스택시퀀스
	//2. 문제 난이도 : 하(easy)
	//3. 문제 유형 : 스택, 그리디
	//4.추언 문제 풀이 시간 : 30분 -> 연습때는 x2로 계산해서 물기
	//5. 문제 풀이 여부 : X  -> 문제를 이해 못함 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = Integer.parseInt(sc.nextLine());
		Stack<Integer> stack = new Stack<>();
		ArrayList<Character> result = new ArrayList<>();
		
		int count = 1;
		for(int i = 1; i <= testcase; i++) {
			int data = Integer.parseInt(sc.nextLine());
			
			while(count <= data) {
				stack.push(count);
				count++;
				result.add('+');
			}
			
			if(stack.peek() == data) {
				stack.pop();
				result.add('-');
			}else {
				System.out.println("NO");
				return;
			}
		}
		
		for(Character out : result) {
			System.out.println(out);
		}
		
		
		sc.close();
	}
}
