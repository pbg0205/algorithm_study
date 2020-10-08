package baekjoon1759;
/*
 * @problem		암호 만들기(1759) : https://www.acmicpc.net/problem/1759
 * @author		pbg0205
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1. 최소 한 개의 모음(a,e,i,o,u)
//2. 최소 두개의 자음
//3. 알파벳이 암호에서 증가하는 순서(사전 순)

class Main {
	
	static char[] data;
	static int L, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		L = Integer.parseInt(temp[0]);
		C = Integer.parseInt(temp[1]);
		
		//1. 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		data = new char[C];
		for (int idx = 0; idx < C; idx++)
			data[idx] = st.nextToken().charAt(0);
		
		//2. 오름차순 정렬
		quickSort(data, 0, C - 1);
		
		//3. 비트마스킹
		int[] password = new int[C];
		for (int i = 0; i < C; i++) {
			for(int idx = 0; idx < C; idx++) {
				if(idx < L)	password[idx] = 0;
				else		password[idx] = 1;
			}
		}
		
		//4. 조건에 맞는 출력
		do {
			if(isPossible(data, password)) {
				for (int idx = 0; idx < C; idx++) {
					if(password[idx] == 0)
						System.out.print(data[idx]);
				}
				System.out.println();
			}
		}while(isNextPermutation(password));
		
		br.close();
	}
	
	private static boolean isNextPermutation(int[] data) {
		int prev = data.length -1;
		while(prev > 0 && data[prev-1] >= data[prev]) {
			prev--;
		}
		
		if(prev < 1) {
			return false;
		}
		
		int after = data.length - 1;
		while(data[prev-1] >= data[after]) {
			after--;
		}
		
		swap(data, prev-1, after);
		
		after = data.length - 1;
		while(prev < after) {
			swap(data, prev, after);
			prev++;
			after--;
		}
		
		return true;
	}

	private static void quickSort(char[] data, int left, int right) {
		int pl = left;
		int pr = right;
		int x = data[(pl + pr) / 2];
		
		do {
			while(data[pl] < x)	pl++;
			while(data[pr] > x) pr--;
			
			if(pl <= pr)
				swap(data, pl++, pr--);
		
		}while(pl <= pr);
		
		if(left < pr) quickSort(data, left, pr);
		if(pl < right) quickSort(data, pl, right);
	}

	private static boolean isPossible(char[] data, int[] password) {
		int Vowel_cnt = 0;
		int Consonant_cnt = 0;
		
		for (int idx = 0; idx < C; idx++) {
			if(password[idx] == 0) {
				if(data[idx] == 'a'|| data[idx] == 'e' || 
						data[idx] == 'i'||data[idx] == 'o'||data[idx] == 'u') {
					Vowel_cnt++;
				}else {
					Consonant_cnt++;
				}
			}
		}
		
		if(Vowel_cnt >= 1 && Consonant_cnt >= 2)
			return true;
		
		return false;
	}
	
	private static void swap(char[] data, int prev, int after) {
		char temp = data[prev];
		data[prev] = data[after];
		data[after] = temp;
	}
	
	private static void swap(int[] data, int prev, int after) {
		int temp = data[prev];
		data[prev] = data[after];
		data[after] = temp;
	}
}
