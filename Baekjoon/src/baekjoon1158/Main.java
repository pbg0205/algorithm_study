package baekjoon1158;
/*
 * @problem		요세푸스 문제(1158) : https://www.acmicpc.net/problem/1158
 * @author		pbg0205
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> queue = new LinkedList<>();
		
		String[] testArr = br.readLine().split(" ");
		int people_num = Integer.parseInt(testArr[0]);
		int interval = Integer.parseInt(testArr[1]);
		
		for (int i = 1; i <= people_num ; i++)	queue.add(i);
		
		bw.write("<");
		while(!queue.isEmpty()) {
			for (int i = 1; i < interval; i++) {
				queue.add(queue.poll());
			}
			bw.write(String.valueOf(queue.poll()));
			if(!queue.isEmpty())bw.write(", ");
		}
		
		bw.write(">");
		br.close();
		bw.flush();
		bw.close();
	}
}
