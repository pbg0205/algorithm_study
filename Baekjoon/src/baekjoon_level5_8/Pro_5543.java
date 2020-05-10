package baekjoon_level5_8;
import java.util.*;

public class Pro_5543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ham_Min = 2000;
		int bev_Min = 2000;
		
		//햄버거 최소값 구하기
		for(int i = 0; i < 3; i++) {
			int hamTest = Integer.parseInt(sc.nextLine());
			ham_Min = ham_Min > hamTest ? hamTest : ham_Min ;
		}
		//음료 최소값 구하기
		for(int j = 0; j < 2; j++) {
			int bevTest = Integer.parseInt(sc.nextLine());			
			bev_Min = bev_Min > bevTest ? bevTest : bev_Min ;
		}
		
		System.out.println(ham_Min + bev_Min -50);
		
		
		sc.close();
	}
}
