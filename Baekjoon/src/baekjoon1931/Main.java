package baekjoon1931;
/*
 * @problem		회의실 배정(1931)
 * @url			https://www.acmicpc.net/problem/1931
 * @author		pbg0205
 */

import java.io.*;
import java.util.*;

class Main {
	
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = stoi(br.readLine());
		
		arr = new int[n][2];
		
		for (int idx = 0; idx < n; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[idx][0] = stoi(st.nextToken());
			arr[idx][1] = stoi(st.nextToken());
		}
		
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] start, int[] end) {
            	
            	if(start[1]==end[1]){	//종료 시간이 같을 경우, 시작 시간으로 정렬
                    return Integer.compare(start[0], end[0]);
                }
                return Integer.compare(start[1], end[1]);
            }
 
        });
		
        int count = 0;
        int end = -1;
        
        for (int idx = 0; idx < n; idx++) {
			if(arr[idx][0] >= end) {
				end = arr[idx][1];
				count++;
			}
		}
		
        System.out.println(count);
        
		br.close();	
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
