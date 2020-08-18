package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class dokydoky {
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
