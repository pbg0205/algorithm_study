package baekjoon14501;
/*
 * @problem		퇴사(14501) : https://www.acmicpc.net/problem/14501
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int[] days, cost;
	static int N, max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		days = new int[N];
		cost = new int[N];
		
		for (int idx = 0; idx < N; idx++) {
			st = new StringTokenizer(br.readLine());
			days[idx] = Integer.parseInt(st.nextToken());
			cost[idx] = Integer.parseInt(st.nextToken());
		}
		
		schedule(0, 0);
		System.out.println(max);

		br.close();
	}

	static void schedule(int day, int money) {
		if(day>=N) {
			max = Math.max(max, money);
			return;
		}
		if(day+days[day]<= N)
				schedule(day+days[day],money+cost[day]);
			
		schedule(day+1,money);
	}
}
