package greedy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class jewelry_thief {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		
		Jewelry [] arr = new Jewelry[n];
		int[] bag = new int[m];
		
		for (int idx = 0; idx < n; idx++) {
			st = new StringTokenizer(br.readLine());
			arr[idx] = new Jewelry(stoi(st.nextToken()), stoi(st.nextToken()));
		}
		
		for (int idx = 0; idx < m; idx++)
			bag[idx] = stoi(br.readLine());
		
		Arrays.sort(arr);
		Arrays.sort(bag);
		
		Queue<Integer> pq = new PriorityQueue<>();
		long ans = 0;
		int j = 0;
		for (int idx = 0; idx < m; idx++) {
			while( j < n && arr[j].weight <= bag[idx]) {
				pq.add(-arr[j].cost);
				j++;
			}
			if(!pq.isEmpty()) {
				ans += Math.abs(pq.poll());
			}
		}
		
		System.out.println(ans);
	}
	
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

class Jewelry implements Comparable<Jewelry>{
	int weight;
	int cost;
	
	Jewelry(int weight, int cost){
		this.weight = weight;
		this.cost = cost;
	}

	@Override
	public int compareTo(Jewelry o) {
		return this.weight - o.weight;
	}
}