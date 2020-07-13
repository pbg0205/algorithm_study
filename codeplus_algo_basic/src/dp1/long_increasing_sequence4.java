package dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class long_increasing_sequence4 {
	
	static int[] arr;
	static int[] v;
	
	public static void go(int p, BufferedWriter bw) throws IOException {
		if( p == -1 ) return;
		go(v[p], bw);
		bw.write(String.valueOf(arr[p]) + " ");
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		int[] dp = new int[n]; //가장 긴 증가하는 부분 수열을 구할때 사용하는 배열
		v = new int[n]; //역추적 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)	arr[i] = Integer.parseInt(st.nextToken());	
		
		Arrays.fill(dp, 1);
		Arrays.fill(v, -1);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
					v[i] = j;
				}
			}
		}
		
		int max = 0;
		int last = 0;
		for (int i = 0; i < n; i++)	
			if(max < dp[i]) {
				max = dp[i];
				last = i;
			}
		
		bw.write(max + "\n");	
		go(last, bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
//dp[index] : 0 ~ index까지의 가장 긴 부분 수열
//v[index] : 이전의 값의 위치를 확인할 수 있는 배열
