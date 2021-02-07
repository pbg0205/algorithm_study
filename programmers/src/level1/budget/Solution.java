package programmers.src.level1.budget;

import java.util.Arrays;

public class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int result = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            result += d[i];

            if(result > budget) {
                answer = i;
                break;
            }
        }

        if(result <= budget) {
            return d.length;
        }

        return answer;
    }
}
