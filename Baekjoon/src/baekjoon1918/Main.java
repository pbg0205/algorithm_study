package baekjoon1918;
/*
 * @problem		후기 표기식(1918) : https://www.acmicpc.net/problem/1918
 * @author		pbg0205
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inorder = br.readLine();
		String postorder = "";
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < inorder.length(); i++) {
			int prioriry = setPriority(inorder.charAt(i));
			char ch = inorder.charAt(i);
			
			switch(ch) {
			case '+':
			case '-':
			case '*':
			case '/':
				while(!stack.isEmpty() && setPriority(stack.peek()) >= prioriry) {
					postorder += stack.pop();
				}
				stack.push(ch);
				break;
			case '(':
				stack.push(ch);
				break;
			case ')':
				while(!stack.isEmpty() && stack.peek() != '(') {
					postorder += stack.pop();
				}
				stack.pop();
				break;
			default :
				postorder += ch;
			}
		}
		
		while(!stack.isEmpty()) {
			postorder += stack.pop();
		}
		
		System.out.println(postorder);
		
		br.close();
	}
	
	public static int setPriority(char ch) {
		switch(ch) {
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		
		case '(':
		case ')':
			return 0;
		}
		return -1;
	}
}
