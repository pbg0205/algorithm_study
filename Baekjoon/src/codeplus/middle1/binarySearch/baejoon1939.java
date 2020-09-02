package codeplus.middle1.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * @Problem		중량제한(1939)
 * @Author		pbg0205
 * @Created by	08.26.20
 * @Elapsed		참고해서 품
 * @Explain
 * 
 */

public class baejoon1939 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start, end;
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<BridgeInfo>[] bridges = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			bridges[i] = new ArrayList<>();
		}

		int max = 0;
		for (int idx = 0; idx < m; idx++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			bridges[s].add(new BridgeInfo(e, c));
			bridges[e].add(new BridgeInfo(s, c));
			max = Math.max(max, c);
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int left = 1;
		int right = max;
		int ans = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			boolean[] visited = new boolean[n+1];
			if(go(bridges, mid, start, end, visited)) {
				left = mid + 1;
				ans = mid;
			}else {
				right = mid-1;
			}
		}
		
		System.out.println(ans);
		
	}

	private static boolean go(ArrayList<BridgeInfo>[] bridges, int mid, int start, int end, boolean[] visited) {
		if(visited[start])
			return false;
		
		visited[start] = true;
		
		if(start == end)
			return true;
		
		for (BridgeInfo bi : bridges[start]) {
			if(bi.cost >= mid) {
				if(go(bridges, mid, bi.next, end, visited)) {
					return true;
				}
			}
		}
		return false;
	}
}

class BridgeInfo{
	int next;
	int cost;
	
	public BridgeInfo(int next, int cost) {
		this.next = next;
		this.cost = cost;
	}
}