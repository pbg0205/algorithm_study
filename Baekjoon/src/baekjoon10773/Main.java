package baekjoon10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * @Problem		제로(10773)
 * @Author		pbg0205
 * @Create by	08.26.2020
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			if(number == 0) {
				st.pop();
			}else {
				st.push(number);
			}
		}
		
		while(!st.isEmpty()) {
			sum += st.pop();
		}
		
		System.out.println(sum);
	}
}
