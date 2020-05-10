package intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class List1_password {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			List<Integer> password = new ArrayList<Integer>();
			int password_len = Integer.parseInt(sc.nextLine());
			
			for(int i = 1 ; i <= password_len; i++) {
				password.add(sc.nextInt());
			}
			sc.nextLine();
			
			int command_num = Integer.parseInt(sc.nextLine());
			for(int i = 1; i <= command_num; i++) {
				String st = sc.next();
				int where = sc.nextInt();
				int many = sc.nextInt();
				for(int k = 0 ; k < many; k++) {
					password.add(where, sc.nextInt());
					where++;
				}
			}
			
			System.out.print("#" + testcase + " ");
			for(int j = 0 ; j < 10; j++) {
				System.out.print(password.get(j) + " ");
			}
			System.out.println();
			sc.nextLine();
		}
		
		
		sc.close();
	}	
}
