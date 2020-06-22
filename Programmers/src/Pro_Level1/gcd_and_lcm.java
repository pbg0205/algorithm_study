package Pro_Level1;

public class gcd_and_lcm {
	public int[] solution(int n, int m) {
		int[] answer = new int[2];
		
		if(n > m) {
			int tmp = m;
			m = n;
			n = tmp;
		}
		
		//최대 공약수 : answer[0]
		for (int i =n ; i >= 1; i--) {
			if(m % i == 0 && n % i == 0) {
				answer[0] = i;
				break;
			}
		}
		
		//최소공배수 : answer[1]
		answer[1] = (n * m) / answer[0];
		
		return answer;
	}
}
