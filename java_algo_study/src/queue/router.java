package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class router {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bufferSize = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		while (true) {
			int info = stoi(br.readLine());

			if (info == -1)		break;
			if (info > 0) {
				if (bufferSize <= queue.size())
					continue;
				else					
					queue.add(info);
				}
			if (info == 0)		queue.poll();
		}
		
		if (queue.size() == 0)
			System.out.println("empty");
		 else {
			for (Integer out : queue) {
				System.out.print(out + " ");
			}
		}
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
