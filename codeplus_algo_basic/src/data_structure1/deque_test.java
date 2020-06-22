package data_structure1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class deque_test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> deque = new LinkedList<>();
		
		int command_num = Integer.parseInt(sc.nextLine());
		
		for (int i = 1; i <= command_num; i++) {
			String[] command = sc.nextLine().split(" ");
			
			
			if(command[0].equals("push_front")) {
				int add_num = Integer.parseInt(command[1]);
				deque.addFirst(add_num);
			}
			if(command[0].equals("push_back")) {
				int add_num = Integer.parseInt(command[1]);
				deque.addLast(add_num);
			}
			if(command[0].equals("pop_front")) {
				if(!deque.isEmpty())	System.out.println(deque.pollFirst());
				else				System.out.println(-1);
			}
			if(command[0].equals("pop_back")) {
				if(!deque.isEmpty())	System.out.println(deque.pollLast());
				else				System.out.println(-1);
			}
			if(command[0].equals("size")) {
				System.out.println(deque.size());
			}
			if(command[0].equals("empty")) {
				if(deque.isEmpty())	System.out.println(1);
				else					System.out.println(0);
			}
			if(command[0].equals("front")) {
				if(!deque.isEmpty())	System.out.println(deque.peekFirst());
				else					System.out.println(-1);
			}
			if(command[0].equals("back")) {
				if(!deque.isEmpty())	System.out.println(deque.peekLast());
				else					System.out.println(-1);
			}
		}
		
		sc.close();
	}
}
