package codeplus.middle1.greedy_algo;

import java.util.Scanner;

//런타임 에러;
public class matrix {
	static int N;
	static int M;
	static int[][] aArr;
	static int[][] bArr;
	static int count = 0;

	public static boolean reverseArr(int row, int col) {

		if (row + 3 > N || col + 3 > M)
			return false;

		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (aArr[i][j] == 0)
					aArr[i][j] = 1;
				else
					aArr[i][j] = 0;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		aArr = new int[N][M];
		bArr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = scan.next();
			for (int j = 0; j < M; j++)
				aArr[i][j] = str.charAt(j) - '0';
		}
		
		for (int row = 0; row < N; row++) {
			String str = scan.next();
			for (int j = 0; j < M; j++)
				bArr[row][j] = str.charAt(j) - '0';
		}

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (aArr[row][col] != bArr[row][col]) {
					if (reverseArr(row, col)) {
						count++;
					} else {
						System.out.println("-1");
						return;
					}
				}
			}
		}

		System.out.println(count);
		scan.close();
	}
}
