package baekjoon10799;
/*
 * @problem		쇠막대기(10799) : https://www.acmicpc.net/problem/10799
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		String input = br.readLine();
		int sum_of_seperated_sticks = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(')	stack.push(i);
			if(input.charAt(i) == ')') {
				if(stack.peek() == i - 1){
				stack.pop();
				sum_of_seperated_sticks += stack.size();
				}else {
					stack.pop();
					sum_of_seperated_sticks++;
				}
			}
		}
		
		System.out.println(sum_of_seperated_sticks);
		
		br.close();
	}
}
