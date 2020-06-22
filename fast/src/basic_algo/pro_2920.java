package basic_algo;

import java.util.Scanner;
import java.util.StringTokenizer;

public class pro_2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringTokenizer st = new StringTokenizer(str);
		
		boolean is_ascending = true;
		boolean is_descending = true;
		
		int prev_num = Integer.parseInt(st.nextToken());
		do {
			int after_num = Integer.parseInt(st.nextToken());

			if(prev_num < after_num)	is_descending = false;
			if(prev_num > after_num)	is_ascending = false;
			
			prev_num = after_num;
		}while(st.hasMoreTokens());
		
		if (is_ascending) {
			System.out.println("ascending");
		}else if(is_descending) {
			System.out.println("descending");			
		}else {
			System.out.println("mixed");
		}
		
		
		sc.close();
	}
}
