package baekjoon1285;
/*
 * @problem		동전 뒤집기(1285)
 * @url			https://www.acmicpc.net/problem/1285
 * @author		pbg0205
 */


import java.io.*;

class Main  {
	
	static boolean [][] coin;
	static int T_count = 0;
	static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int row = 0; row < N; row++) {
			String str = br.readLine();
			for (int col = 0; col < N; col++) {
				if(str.charAt(col) == 'H')	coin[row][col] = true;
				if(str.charAt(col) == 'T') {
					coin[row][col] = false;
					T_count++;
				}
			}
		}
		//모든 애들이 행 또는 열로 뒤집어야 한다.
		//문제의 핵심은 T가 가장 적게 좋인 경우의 수
		// 뒤집기 전에 뒤집을 때 카운팅 확인하기
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				
			}
		}
		
	}
	public static void reverseRow(int row, int col) {
		for (int idx = 0; idx < N; idx++) {
			if(coin[row][idx]) coin[row][idx] = false;
			if(!coin[row][idx]) coin[row][idx] = true;
		}
	}
	
	public static void reverseCol(int row, int col) {
		for (int idx = 0; idx < N; idx++) {
			if(coin[idx][col])	coin[idx][col] = false;
			if(!coin[idx][col])	coin[idx][col] = true;
		}
	}
}
class coinMap{
	boolean[][] coin;
	int T_count = 0;
	
	coinMap(boolean[][] coin, int T_count){
		this.coin = coin;
		this.T_count = T_count;
	}
}