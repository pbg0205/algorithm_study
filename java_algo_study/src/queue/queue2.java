package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class queue2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<String> q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			String[] menu = br.readLine().split(" ");
			switch (menu[0]) {
			case "push":
				q.add(menu[1]);
				break;
			case "pop":
				bw.write(!q.isEmpty() ? q.poll() : "-1");
				break;
			case "size":
				bw.write(String.valueOf(q.size()));
				break;
			case "empty":
				bw.write(q.isEmpty() ? "1" : "0");
				break;
			case "front":
				bw.write(!q.isEmpty() ? String.valueOf(q.getFirst()) : "-1");
				break;
			case "back":
				bw.write(!q.isEmpty() ? String.valueOf(q.getLast()) : "-1");
				break;
			}

			if(menu[0].equals("push")) {
				continue;
			}else {
				bw.write("\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
