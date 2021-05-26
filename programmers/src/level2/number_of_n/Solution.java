package programmers.src.level2.number_of_n;

public class Solution {
    public String solution(int n, int t, int m, int p) {
        String totalNumbersStr = "0";
        int count = 0;

        while (totalNumbersStr.length() < (t * m + p)) {
            String byNum = "";
            int num = count++;

            while(num != 0) {
                int remainder = num % n;

                if(remainder >= 10) {
                    remainder -= 10;
                    byNum = String.valueOf((char) (remainder + 'A'));
                } else {
                    byNum = String.valueOf((char) remainder);
                }

                num /= n;

            }

            totalNumbersStr += new StringBuffer(byNum).reverse().toString();

        }

        String answer = "";

        for (int i = 0; i < t; i++) {
            answer += String.valueOf(totalNumbersStr.charAt(m * i + (p - 1)));
        }

        return answer;
    }
}
