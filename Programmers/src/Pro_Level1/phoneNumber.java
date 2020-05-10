package Pro_Level1;

public class phoneNumber {
	  public String solution(String phone_number) {  
	      String answer = "";
	      int starNum = phone_number.length()-4;
	      phone_number = phone_number.substring(phone_number.length()-4, phone_number.length());
	      
	      for(int i = 0; i < starNum; i++) {
	      phone_number = "*" + phone_number;
	      }
	      
	      answer = phone_number;
	      
	      System.out.println(answer);
	      return answer;
	  }
	  
	  public static void main(String[] args) {
		phoneNumber sol = new phoneNumber();
		sol.solution("01033334444");
	}

}
