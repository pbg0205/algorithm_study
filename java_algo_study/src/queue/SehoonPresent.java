package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 세훈이의 선물가게(17225)
 * 1. 가장 앞에 있는 선물부터 가져오는 형태
 * 2. 고객은 파랑색 포장은 상민, 빨간색 포장지는 지수에게 맡긴다.
 * 3. 동시에 선물을 가져올 떄, 상민(상민)이가 먼저
 * 4. 부분 풀이 : 100/140 - 예제 케이스2 문제 풀이 필요
 *  
 */
public class SehoonPresent {
	
	static Queue<client> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int s_time = Integer.parseInt(input[0]);
		int j_time = Integer.parseInt(input[1]);
		
		ArrayList<Integer> s_al = new ArrayList<>();
		ArrayList<Integer> j_al = new ArrayList<>();
		
		worker sangmin = new worker(s_time, "B", 0, s_al, false);
		worker jisu = new worker(j_time, "R", 0, j_al, false);
		
		int n = Integer.parseInt(input[2]);
		
		int present_num = 1;
		for (int i = 1; i <= n; i++) {
			String[] order = br.readLine().split(" ");
			
			int time = Integer.parseInt(order[0]);
			String color = order[1];
			int number = Integer.parseInt(order[2]);
			
			queue.offer(new client(time, color, number));
		}
		
		while(!queue.isEmpty()) {
			client c = queue.poll();
			
			while(c.number > 0) {
				if(c.color.equals("B")) {
					sangmin.isWorking = true;
					sangmin.cnt += 1;
					sangmin.result.add(present_num++);
					
				}else if(c.color.equals("R")) {
					jisu.isWorking = true;
					jisu.cnt += 1;
					jisu.result.add(present_num++);
				}
				c.number--;
			}
		}
		
		System.out.println(sangmin.cnt);
		for (Integer out : sangmin.result)
			System.out.print(out + " ");
		System.out.println();
		System.out.println(jisu.cnt);
		for (Integer out : jisu.result)
			System.out.print(out + " ");

	}
}

class client{
	int time;
	String color;
	int number;
	
public client(int time, String color,int number) {
	this.time = time;
	this.color = color;
	this.number = number;	
	}
}

class worker{
	int time;
	String color;
	int cnt;
	ArrayList<Integer> result;
	boolean isWorking;

	public worker(int time, String color, int cnt,
			ArrayList<Integer> result, boolean isWorking) {
		
		this.time = time;
		this.color = color;
		this.cnt = cnt;
		this.result = result;
		this.isWorking = isWorking;
	}
	
}