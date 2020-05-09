package intermediate;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue1_crypto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> inputBox_queue = new LinkedList<>();
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			int testNum = Integer.parseInt(sc.nextLine());
			for (int i = 1; i <= 8; i++) {
				int inputNum = sc.nextInt();
				inputBox_queue.add(inputNum);
			}
			
			sc.nextLine();
			
			Queue1_crypto sol = new Queue1_crypto();
			inputBox_queue = sol.encode(inputBox_queue, testNum);
			
			System.out.print("#" + testNum + " ");
			for(int output : inputBox_queue) {
				System.out.print(output + " ");
			}
			System.out.println();
			inputBox_queue.clear();
		}
		
		sc.close();
	}

	private Queue<Integer> encode(Queue<Integer> inputBox_queue, int testNum) {
		int cycleNum = 1;
		boolean upZero = true;
		
		while(upZero) {
			if(cycleNum == 6)	cycleNum = 1;
			int checkNum = inputBox_queue.peek() - cycleNum;
			
			if(checkNum <= 0) {
				inputBox_queue.add(0);
				inputBox_queue.poll();
				upZero = false;
			}else {
				inputBox_queue.add(checkNum);
				inputBox_queue.poll();
			}
			cycleNum++;
		}
		
		return inputBox_queue;
	}
}
