package codeplus.middle1.divide_and_conquer_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class numberOfPaper {

	static StringTokenizer st;

	static int[][] map;
	static int[] count = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		for (int row = 0; row < n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < n; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		//분할해서 결과값 출력
		divide(0, 0, n);
		
		//결과값 출력
		for (int ans : count)
			System.out.println(ans);
		
		br.close();
	}

	//해당 위치 값의 일치여부 확인
	private static boolean check(int row, int col, int n) {
		int map_num = map[row][col];
		for (int i = row; i < row + n; i++) {
			for (int j = col; j < col + n; j++) {
				if(map_num != map[i][j])
					return false;
			}
		}
		return true;
	}
	
	//분할 메소드
	private static void divide(int row, int col, int n) {
		if(check(row, col, n)) {
			count[map[row][col]+ 1]++;
		}else {
			int s = n / 3;
			for (int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					divide(row + s * i, col + s * j, s);
				}
			}
		}
	}
}
