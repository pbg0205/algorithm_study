package Pro_Level1;
import java.util.*;

public class Reverse_Num {
	  public int[] solution(long n) {
	      String a = "" + n;
	        int[] answer = new int[a.length()];
	        int cnt=0;
	 
	        while(n>0) {
	            answer[cnt]=(int)(n%10);
	            n/=10;
	            cnt++;
	        }
	      return answer;	
	  }
	  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		long n = Long.parseLong(line);
		
		Reverse_Num sol = new Reverse_Num();
		int[] answer = sol.solution(n);
		for(int a : answer) {
			System.out.println(a);
		}
	}
}
