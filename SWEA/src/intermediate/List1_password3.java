package intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class List1_password3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			List<Integer> password = new ArrayList<>();
			int password_len = Integer.parseInt(sc.nextLine());
			for(int i = 0 ; i < password_len; i++)	password.add(sc.nextInt());
			sc.nextLine();
			int command_num = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < command_num; i++) {
				String st = sc.next();
				
				if(st.equals("I")) {
					int where = sc.nextInt();
					int many = sc.nextInt();					
					for (int k = 0; k < many; k++) {
						password.add(where, sc.nextInt());
						where++;
					}
				}else if(st.equals("D")) {
					int where = sc.nextInt();
					int many = sc.nextInt();
					for (int k = 0; k < many; k++) {
						password.remove(where);
					}					
				}else if(st.equals("A")) {
					int many = sc.nextInt();
					for (int k = 0; k < many; k++) {
						password.add(password.size()-1, sc.nextInt());
					}
				}				
			}
			sc.nextLine();
			
				System.out.print("#" + testcase + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(password.get(i) + " ");
			}
			System.out.println();
		}
		
		
		sc.close();
	}
}
