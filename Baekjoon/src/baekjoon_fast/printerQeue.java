package baekjoon_fast;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class printerQeue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		
		for (int test_num = 1; test_num <= test_case; test_num++) {
			int document_num = sc.nextInt();
			int find_num = sc.nextInt();
			sc.nextLine();
			
			Queue<Node> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			int find_num_priority = 0;
			
			for (int index = 0; index < document_num; index++) {
				int priority = sc.nextInt();
				q.add(new Node(priority,index));
				pq.add(-priority);// 내림차순 정렬
			}
			
			while(true) {
				Node node = q.poll();
				if(node.priority == -pq.peek()) {
					find_num_priority++;
					pq.poll();
					
					if(find_num == node.index) {
						System.out.println(find_num_priority);
						break;
					}
				}else {
					q.add(new Node(node.priority, node.index));
				}
			}
		}
		
		
		sc.close();
	}
}

class Node{
	int priority;
	int index;
	
	public Node(int priority, int index) {
		this.priority = priority;
		this.index = index;
	}

	@Override
	public String toString() {
		return "Node [priority=" + priority + ", index=" + index + "]";
	}
}

//return; : void형일 때 값을 리턴하는 형태