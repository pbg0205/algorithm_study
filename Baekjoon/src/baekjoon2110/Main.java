package baekjoon2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *@Problem		공유기설치(2110)
 *@Author		pbg0205
 *@Create by	08.26.20
 *@Elapsed		1hr
 *@Explain		
 *	- 이분 탐색을 통한 거리 가늠 문제.
 *	- 거리를 이분 탐색하여 거리를 만족하는 집의 수를 집계하는 방식
 *  - 거리를 만족하면 다음 집을 이전 집(previous)로 선정해서 나아가는 방식
 *  - 조건
 *    if(거리가 길다) -> 짧은 거리 범위로  좁힌다.(pr = pc - 1);
 *    if(거리가 짧다) -> 긴 거리 범위로  좁힌다.(pl = pc + 1);
 */

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		int pl = 1, pr = arr[n-1];
		
		while(pl <= pr) {
			int pc = (pl + pr) / 2;
			int count = 1;
			int previous = arr[0];
			
			for (int house : arr) {
				if(house - previous >= pc) {
					/*
					 * 조건 만족 시,
					 *-만족하는 집의 수 count증가.
					 *-거리를 만족하면 집을 이전 집으로 변경 후, 조건 만족하는  다음 집 탐색 
					 */
					count++;
					previous = house;
				}
			}
			if(count < c) {
				pr = pc - 1;
			}
			if(count >= c) {
				pl = pc + 1;
			}
		}
		System.out.println(pr);
	}
}
