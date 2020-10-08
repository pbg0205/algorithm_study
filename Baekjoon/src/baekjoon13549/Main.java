package baekjoon13549;
/*
 * @problem		숨바꼭질 3(13549) : https://www.acmicpc.net/problem/13549
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	static int n, k;
	static int min;
	
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		visited = new boolean[100002];
		min = Integer.MAX_VALUE;
		
		bfs();
		
		System.out.println(min);
		
		br.close();
	}

	private static void bfs() {
		Queue<location_info> queue = new LinkedList<>();
		queue.add(new location_info(n, 0));
		
		while(!queue.isEmpty()) {
			location_info li = queue.poll();

			if(li.location == k) {
				min = Math.min(min,  li.time);
				return ;
			}
			
			if(visited[li.location])	continue;
			visited[li.location] = true;
			
			//x - 1
			if(li.location - 1 >= 0)
				if(!visited[li.location - 1])	queue.add(new location_info(li.location - 1, li.time + 1));
			//x * 2
			if(li.location * 2 <= 100000)
				if(!visited[li.location * 2])	queue.add(new location_info(li.location * 2, li.time));
			//x + 1
			if(li.location + 1 <= 100000)
				if(!visited[li.location + 1])	queue.add(new location_info(li.location + 1, li.time + 1));
			
		}
	}
}

class location_info{
	int location;
	int time;
	
	public location_info(int location, int time) {
		this.location = location;
		this.time = time;
	}
}