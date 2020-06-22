package bronze1;

import java.util.Scanner;

public class pow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int or_more = Integer.parseInt(sc.nextLine());
		int or_less = Integer.parseInt(sc.nextLine());
		
		int root_num = 1;
		int sum = 0;
		
		while(or_more > Math.pow(root_num, 2)) {
			++root_num;
		}
		
		int root_min = root_num;
		
		while(or_less >= Math.pow(root_num, 2)) {
			sum += Math.pow(root_num, 2);
			root_num++;
		}
		
		if(sum > 0) {
			System.out.println(sum);
			System.out.println((int)Math.pow(root_min, 2));
		}	
		else System.out.println(-1);

		
		sc.close();
	}
}

//Square : 제곱수
//A의 B제곱 : A power B, A to the B
