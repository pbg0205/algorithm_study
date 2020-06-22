package data_structure1_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class word_reverse2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();
		
		String input_str = br.readLine();
		input_str = input_str + '\n';
		
		boolean has_bracket = false;
		for (int i = 0; i < input_str.length(); i++) {
			if(input_str.charAt(i) == '<') {
				while(!stack.isEmpty())	System.out.print(stack.pop());
				has_bracket = true;
			}
			
			if(has_bracket) {
				queue.add(input_str.charAt(i));
				if(input_str.charAt(i) == '>') {
					while(!queue.isEmpty())	System.out.print(queue.poll());
					has_bracket = false;
				}
			}else {
				if(input_str.charAt(i) == ' ' || input_str.charAt(i) == '\n') {
					while(!stack.isEmpty())	System.out.print(stack.pop());
					System.out.print(" ");
				}else {
					stack.add(input_str.charAt(i));
				}
			}
		}
		br.close();
	}
}
