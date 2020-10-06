package baekjoon4949;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
 * problem		{균형잡힌 세상 (4949)}
 * author		{pbg0205}
 * Create by	{08.24.20}
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			Stack<Character> stack = new Stack<>();
			String sentence = br.readLine();
			boolean isPossible = true;
			
			if (sentence.equals(".")) {
				br.close();
				bw.flush();
				bw.close();
				return;
			}
			
			char[] words = sentence.toCharArray();

			for (char word : words) {
				if (word == '(')
					stack.push(')');

				if (word == '[') {
					stack.push(']');
				}

				if (word == ')' || word == ']') {
					if (stack.isEmpty()) {
						isPossible = false;
						break;
					}

					if (word == stack.peek()) {
						stack.pop();
					} else {
						isPossible = false;
						break;
					}
				}
			}

			if (isPossible && stack.isEmpty()) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}
		}
	}
}
