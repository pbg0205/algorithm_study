package Pro_Level1;

import java.util.Arrays;

public class reverseSort {
	public long solution(long n) {
		long answer = 0;
		long[] numArray = new long[(int) Math.log10((long)n) + 1];
		long digit = 1;
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = n % 10;
			n /= 10;
		}
		Arrays.sort(numArray);
		
		for (int j = 0; j < numArray.length; j++) {
			answer += numArray[j] * digit;
			digit *= 10;
		}
		
		return answer;
	}
	public static void main(String[] args) {
		reverseSort sol = new reverseSort();
		long n = 118372;
		sol.solution(n);
	}
}
