package Pro_Level1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Pro_2016 {
	
	public String solution(int a, int b) throws ParseException {
		String answer = "";
		String inputDate = "2016";
		if(a < 10)	inputDate+= "0";
		inputDate += String.valueOf(a);
		inputDate += String.valueOf(b);
		
		DateFormat sd = new SimpleDateFormat("yyyyMMdd");
		Date date = sd.parse(inputDate);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int date_int = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(date_int) {
			case 1:	answer += "SUN";	break;
			case 2:	answer += "MON";	break;
			case 3:	answer += "TUE";	break;
			case 4:	answer += "WED";	break;
			case 5:	answer += "THU";	break;
			case 6:	answer += "FRI";	break;
			case 7:	answer += "SAT";	break;
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		Pro_2016 pro = new Pro_2016();
		System.out.println(pro.solution(a, b));
		
		sc.close();
	}
	
	//case test에서 실패가 떠서 풀이 못냄
}
