package codeplus.middle1.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Problem		{랜선 자르기(1654)}
 * @Author		{pbg0205}
 * @Create by	{08.25.2020}
 * @Time		{PM 09:57}
 * 
*/
public class baekjoon1654 {
	
	static int[] LAN;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		LAN = new int[k];
		for (int i = 0; i < k; i++) {
			LAN[i] = Integer.parseInt(br.readLine());
		}
		
		long min = 1;
		long max = Integer.MIN_VALUE;//최대
		
		for (Integer l : LAN) {
			if(max <= l)	max = l;
		}
		
		/*
		 * n == divedCnt에서 최대값을 구하기 때문에
		 * max는 큰 것에서 작아지는, (n < diviedCnt -> n == dividedCnt가 되는 지점)
		 * min은 해당 범위를 딱 벗어나는 지점이기 떄문에 (n >= diviedCnt -> 가능한 범위를 벗어나는 지점)
		 * 
		 * 결국, max값을 얻어내야 원하는 값을 얻을  수 있다.
		 */
		while(min <= max) {
			long dividedCnt = 0;
			long middle = (min + max) / 2;
			for (int i = 0; i < k; i++) {
				dividedCnt += LAN[i] / middle;
			}
			
			if (dividedCnt < n) {
				/* 적게 잘렸으므로 값이 큰 상태*/
				max = middle - 1;
			}else if(dividedCnt >= n) {
				/* 많이 잘렸으므로 값이 작은 상태*/
				min = middle + 1;
			}
		}
		System.out.println(max);
	}
}
