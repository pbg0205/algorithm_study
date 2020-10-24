package baekjoon1202;
/*
 * @problem		보석 도둑(1202)
 * @url			https://www.acmicpc.net/problem/1202
 * @author		pbg0205
 */

import java.io.*;
import java.util.*;

class Main {
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