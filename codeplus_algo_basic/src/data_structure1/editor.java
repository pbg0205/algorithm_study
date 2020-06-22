package data_structure1;

import java.util.Scanner;

/*
 *	1.문제 핵심 : 커서의 기준을 결정하는 기준이 중요
 * 		-> 문장 완성 시 가장 끝에 커서가 존재하므로 int cursor = str.length();로 설정 
 * 
 *	2. 문제 제출 시, 시간 초과 -> 다른 풀이 방식으로 접근 필요
 */

public class editor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int cursor = str.length();
		int command_num = Integer.parseInt(sc.nextLine());
		
		for (int i = 1; i <= command_num; i++) {
			String command = sc.next();
			System.out.println(command);
			switch (command) {
			case "L":
				if(cursor > 0) cursor--;
				else	cursor = 0;
				break;
				
			case "D":
				if(cursor < str.length()) cursor++;
				else	cursor = str.length();
				break;
				
			case "B":
				if(cursor != 0) {
					String temp_l = str.substring(0, cursor - 1);
					String temp_r = str.substring(cursor, str.length());
					str = temp_l + temp_r;
					cursor--;
				}else {
					continue;
				}
				break;
				
			case "P":
				String add_$ = sc.next();
				if(cursor < str.length()) {
					String temp_l = str.substring(0, cursor);
					String temp_r = str.substring(cursor, str.length());
					str = temp_l + add_$ + temp_r;
					cursor++;
				}else {
					str = str + add_$;
					cursor++;
				}
				break;			
			}
			sc.nextLine();
		}
		System.out.println(str);
		
		sc.close();
	}
}
