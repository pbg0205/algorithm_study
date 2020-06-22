package bronze1;

import java.util.Scanner;

public class year_2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int[] month = {-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] date = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int input_month = sc.nextInt();
		int input_date = sc.nextInt();
		
		int sum_of_date = 0;
		for(int i = 0; i < input_month; i++) sum_of_date += date[i];
		sum_of_date += input_date;
		
		int day = sum_of_date % 7;

		switch (day) {
		case 1:	System.out.println("MON");			break;
		case 2:	System.out.println("TUE");			break;
		case 3:	System.out.println("WED");			break;
		case 4:	System.out.println("THU");			break;
		case 5:	System.out.println("FRI");			break;
		case 6:	System.out.println("SAT");			break;
		case 0:	System.out.println("SUN");			break;
		}
	}
}
