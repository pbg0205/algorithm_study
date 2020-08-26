package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * @Problem		천재 수학자 성필(15815)
 * @Author		pbg0205
 * @Created by	08.26.20
 * 
 */
public class baekjoon15815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		Stack<Integer> stack = new Stack<>();

		for (int idx = 0; idx < input.length(); idx++) {
			if ('0' <= input.charAt(idx) && input.charAt(idx) <= '9') {
				stack.push(input.charAt(idx) - '0');
			}

			if (input.charAt(idx) == '+' 
					|| input.charAt(idx) == '-' 
					|| input.charAt(idx) == '*'
					|| input.charAt(idx) == '/') {
				
				int a = stack.pop();
				int b = stack.pop();

				if (input.charAt(idx) == '+') {
					stack.push(a + b);
				}
				if (input.charAt(idx) == '-') {
					stack.push(b - a);
				}
				if (input.charAt(idx) == '*') {
					stack.push(b * a);
				}
				if (input.charAt(idx) == '/') {
					stack.push(b / a);
				}
			}
		}
		
		System.out.println(stack.peek());
	}
}
