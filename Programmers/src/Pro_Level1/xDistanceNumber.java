package Pro_Level1;

public class xDistanceNumber {
	public long[] solution(int x, int n) {
		long[] answer = new long[n];
		long output = (long)x;
		long gap = (long)x;
		for(int i = 0 ; i < answer.length; i++) {
			answer[i] = output;
			output += gap;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		xDistanceNumber sol = new xDistanceNumber();
		sol.solution(2, 5);
	}
}
