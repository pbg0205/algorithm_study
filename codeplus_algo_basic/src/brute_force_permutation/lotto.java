package brute_force_permutation;

import java.util.Scanner;

public class lotto {
	
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		boolean is_next_case=false;
		
		while(true) {
			int N = sc.nextInt();
			if(N == 0) return;

			int[] data = new int[N+1];
			for(int idx = 1; idx <= N; idx++)	data[idx] = sc.nextInt();
			
			if(is_next_case)	System.out.println();
			
			int[] lotto = new int[N+1];
			for(int idx = 1; idx <= N; idx++) {
				if(idx <= 6)	lotto[idx] = 0;
				else			lotto[idx] = 1;
			}
			
			do {
				for(int idx = 1; idx <= N; idx++) {
					if(lotto[idx] == 0)
						System.out.print(data[idx]+" ");
				}
				System.out.println();
				is_next_case = true;
			}while(isNextPermutation(lotto));
		}
	}
	
	public static boolean isNextPermutation(int[] data) {
		int prev = data.length - 1;
		while(prev > 1 && data[prev-1] >= data[prev]) {
			prev--;
		}
		
		if(prev <= 1) {
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
	
	public static void swap(int[] data, int prev, int next) {
		int temp = data[prev];
		data[prev] = data[next];
		data[next] = temp;
	}
}
