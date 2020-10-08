package baekjoon15651;
/*
 * @probelm		N과 M(3) : https://www.acmicpc.net/problem/15649
 * @author		pbg0205
 */
import java.io.*;
import java.util.*

class Main {
	static int N,M;
	static int[] data;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		data = new int[N+1];
		
		combination(0);
		
		sc.close();
	}

	private static void combination(int num) throws IOException {
		if(num == M) {
			for (int i = 0; i < M; i++) {
				bw.write(data[i] + " ");
			}
			bw.newLine();
			bw.flush();
			return ;
		}
		
		for (int i = 1; i <= N; i++) {
				data[num] = i;
				combination(num+1);
		}
	}
}