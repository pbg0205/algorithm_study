package codeplus.basic.brute_force;

import java.util.Scanner;

public class cal_date {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] data = new int[3];
		for (int idx = 0; idx < 3; idx++)	data[idx] = sc.nextInt();
		
		int ans = 1;
		int E = 1;
		int S = 1;
		int M = 1;
		
		while(true) {
			if(E == data[0] && S == data[1] && M == data[2])
				break;
			
			E++;
			S++;
			M++;
			
			if(E > 15)	E = 1;
			if(S > 28)	S = 1;
			if(M > 19)	M = 1;
			
			ans++;
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}
