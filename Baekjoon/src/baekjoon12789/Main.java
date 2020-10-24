package baekjoon12789;

import java.io.*;
import java.util.*;

/*
 * @Problem		도키도키 간식드리미(12789)
 * @url			https://www.acmicpc.net/problem/12789
 * @Author		pbg0205
 */

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int order_num = 1;
		int n = stoi(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>(); 
		Stack<Integer> stack = new Stack<>(); 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreElements())	
			queue.add(stoi(st.nextToken()));
		
		while(!queue.isEmpty()) {
			if(queue.peek() == order_num) {
				queue.poll();
				order_num++;
			}else {
				if(!stack.isEmpty() && stack.peek() == order_num) {
					stack.pop();
					order_num++;
				}else {
					stack.push(queue.poll());
				}
			}
		}
		
		while(!stack.isEmpty()) {
			if(stack.pop() != order_num) {
				System.out.println("Sad");
				return ;
			}
			order_num++;
		}
	
		
		System.out.println("Nice");
	}
	
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
