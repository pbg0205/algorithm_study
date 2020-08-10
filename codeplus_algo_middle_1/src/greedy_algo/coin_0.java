package greedy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coin_0 {
	
	static int n, k;
	static int[] coin;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = stoi(st.nextToken());
		k = stoi(st.nextToken());
		
		coin = new int[n];
		int coin_cnt = 0;
		
		for (int idx = 0; idx < n; idx++)
			coin[idx] = stoi(br.readLine());
		
		for (int idx = n - 1; idx >= 0; idx--) {
			if(k == 0)			break;
			if(coin[idx] > k)	continue;
			
			while(coin[idx] <= k) {
				k -= coin[idx];
				coin_cnt++;
			}
		}
		
		System.out.println(coin_cnt);
	}
	
	public static int stoi(String line) {
		return Integer.parseInt(line);
	}
}
