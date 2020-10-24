package baekjoon11399;
/*
 * @problem		ATM(11399)
 * @url			https://www.acmicpc.net/problem/11399
 * @author		pbg0205
 */
import java.io.*;
import java.util.*;

class Main {
	
	static int[] time;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int min = 0;
		time = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < n; idx++)
			time[idx] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(time);// Arrays.sort : quickSort로 진행

		int sum = 0;
		for (int idx = 0; idx < n; idx++) {
			min += time[idx];
			sum += min;
		}
		
		System.out.println(sum);
	}
}