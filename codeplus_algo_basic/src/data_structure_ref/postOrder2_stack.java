package data_structure_ref;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.Format;
import java.util.Stack;

public class postOrder2_stack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String cal = br.readLine();
		
		double[] doubleArr = new double[n];
		for (int i = 0; i < n; i++)	doubleArr[i] = Double.parseDouble(br.readLine());
		
		Stack<Double> stack = new Stack<>();
		
		for (int i = 0; i < cal.length(); i++) {//알파벳일 경우
			if('A' <= cal.charAt(i)   && cal.charAt(i) <= 'Z') {
				stack.push(doubleArr[cal.charAt(i)-'A']);
			}else {//연사자일 경우
				if(cal.charAt(i) == '+') {
					double temp1 = stack.pop();
					double temp2 = stack.pop();
					stack.push(temp2 + temp1);
				}
				if(cal.charAt(i) == '-') {
					double temp1 = stack.pop();
					double temp2 = stack.pop();
					stack.push(temp2 - temp1);
				}
				if(cal.charAt(i) == '*') {
					double temp1 = stack.pop();
					double temp2 = stack.pop();
					stack.push(temp2 * temp1);
				}
				if(cal.charAt(i) == '/') {
					double temp1 = stack.pop();
					double temp2 = stack.pop();
					stack.push(temp2 / temp1);
				}
			}
		}
		
		double answer = stack.pop();
		System.out.printf("%.2f", answer);
		
		
		br.close();
	}
}
