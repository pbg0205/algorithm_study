package programmers.src.level2.world_of_124;

/*
 * @Problem     124 나라의 숫자
 * @Url         https://programmers.co.kr/learn/courses/30/lessons/12899
 * @Author      pbg0205@naver.com
 * @Created by  2021.02.19
 */

import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};

        while (n > 0) {
            int remainder = n % 3;
            n /= 3;

            if (remainder == 0) {
                n--;
            }

            answer = numbers[remainder] + answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6));
    }
}
