package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * Problem		{후위 표기식2(1935)}
 * Author		{pbg0205}
 * Create by	{08.25.20}
 * 
 */
public class baekjoon1935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double [] arr = new double[n];
		String line = br.readLine();
		
		Stack<Double> stack = new Stack<>();
		
		for (int i = 0; i < line.length(); i++) {
			if('A' <= line.charAt(i)
					&& line.charAt(i) <= 'Z') {
				if(arr[line.charAt(i)-'A'] == 0) {
					double data = Double.parseDouble(br.readLine());
					arr[line.charAt(i)-'A'] = data;
				}
				stack.push(arr[line.charAt(i) - 'A']);
			}
			
			if(line.charAt(i) == '+' 
					|| line.charAt(i) == '-'
					|| line.charAt(i) == '*'
					|| line.charAt(i) == '/') {
				
				double a = stack.pop();
				double b = stack.pop();
				
				if(line.charAt(i) == '+') {
					stack.push(a+b);
				}
				if(line.charAt(i) == '-') {
					stack.push(b-a);
				}
				if(line.charAt(i) == '*') {
					stack.push(a*b);
				}
				if(line.charAt(i) == '/') {
					stack.push(b/a);
				}
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}
