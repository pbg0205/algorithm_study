package baekjoon17299;
/*
 * @problem		오등큰수(17299) : https://www.acmicpc.net/problem/17299
 * @author		pbg0205
 */

/
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] input_arr = new int[n];
		int[] count_arr = new int[1000001];
		int[] output_arr = new int[n];
		
		String numbers = br.readLine();
		StringTokenizer st = new StringTokenizer(numbers);
		for (int i = 0; i < n; i++) {
			input_arr[i] = Integer.parseInt(st.nextToken());
			count_arr[input_arr[i]]++;
		}
		
//		for (int out : count_arr) {
//			System.out.print(out + " ");
//		}
		
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		
		for (int i = 1; i < n; i++) {
			if(stack.isEmpty())	stack.push(i);
			while(!stack.isEmpty() && count_arr[input_arr[i]] > count_arr[input_arr[stack.peek()]]) {
				output_arr[stack.pop()] = input_arr[i];
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty())	output_arr[stack.pop()] = -1;
		for (int out : output_arr)	bw.write(out + " ");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
