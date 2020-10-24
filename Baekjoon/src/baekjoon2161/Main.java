package baekjoon2161;

import java.util.*;

/*
 * @Problem     카드1(2161)
 * @url			https://www.acmicpc.net/problem/2161
 * @Author      pbg0205
 */

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		Queue<Integer> queue = new LinkedList<>();
		for (int card = 1; card <= n; card++)
			queue.offer(card);

		while(true){
			System.out.print(queue.poll() + " ");
			if(queue.isEmpty())	break;
			queue.add(queue.poll());
		} 
		
		sc.close();
	}
}