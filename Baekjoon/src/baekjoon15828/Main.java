package baekjoon15828;

import java.io.*;
import java.util.*;

/*
 * @Problem		Router(15828)
 * @url			https://www.acmicpc.net/problem/15828
 * @Author		pbg0205
 */

class Main {
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
