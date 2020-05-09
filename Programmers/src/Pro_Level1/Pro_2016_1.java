package Pro_Level1;

import java.util.Scanner;

public class Pro_2016_1 {

	public String solution(int a, int b) {
		String answer = "";
		String[] date = {"SUN", "MON", "THE", "WED","THU","FRI", "SAT"};
		int [] LastDay = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int start_date = 4;
		int days = start_date;
		
		//월 추가
		for(int i = 0; i < a-1; i++) {
			days += LastDay[i];
		}
		
		//일 추가
		days += b;
		
		//날짜 출력
		answer = date[days%7];
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] sample_arr = line.split(" ");
		
		int a = Integer.parseInt(sample_arr[0]);
		int b = Integer.parseInt(sample_arr[1]);
		
		Pro_2016_1 pro = new Pro_2016_1();
		System.out.println(pro.solution(a, b));
		
		
		sc.close();
	}
}
