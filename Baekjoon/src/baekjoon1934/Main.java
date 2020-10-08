package baekjoon1934;
/*
 * @problem		최소공배수(1934) : https://www.acmicpc.net/problem/1934
 * @author		pbg0205
 */
import java.util.Scanner;

//유클리드 호제법을 이용한 풀이
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test_num = Integer.parseInt(sc.nextLine());
		
		for (int i = 1; i <= test_num; i++) {
			String str = sc.nextLine();
			String[] temp_strArr = str.split(" ");
			
			int prev_num = Integer.parseInt(temp_strArr[0]);
			int after_num = Integer.parseInt(temp_strArr[1]);
			
			int gcd = Euclidean_algo(prev_num, after_num);
			int lcm = 1;
			
			lcm = prev_num * after_num / gcd;
			System.out.println(lcm);
		}
		sc.close();
	}
	
	public static int Euclidean_algo(int prev_num, int after_num) {
		if(prev_num < after_num) {
			int temp = prev_num;
			prev_num = after_num;
			after_num = temp;
		}
		
		while(prev_num % after_num != 0) {		
			int temp = after_num;
			after_num = prev_num % after_num;
			prev_num = temp;
		}
		
		return after_num;
	}
}

//런타임 에러로 고전헀다.
//-> sc.netInt() 입력 값을 받은 후, sc.nextLine()을 사용 시, 빈값을 입력받았기 때문에 런타임 에러 발생.
