package baekjoon2164;

import java.util.*;

/*
 * @Problem     카드2(2164)
 * @url			https://www.acmicpc.net/problem/2164
 * @Author      pbg0205
 */

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++)	queue.add(i);
		
		while(queue.size() >= 1) {
			if(queue.size() == 1)	break;
			queue.poll();
			queue.add(queue.poll());
		}
		
		System.out.println(queue.poll());
	}
}
