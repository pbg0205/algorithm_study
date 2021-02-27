package programmers.src.level2.make_big_number;

/*
 * @Problem     큰 수 만들기
 * @Url         https://programmers.co.kr/learn/courses/30/lessons/42883
 * @Author      pbg0205@naver.com
 * @Created by  2021.02.24
 * @접근방법 : 그리디
 */
public class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int maxIndex = 0;
        char max;

        for (int nowIdx = 0; nowIdx < number.length() - k; nowIdx++) {
            max = '0';
            for (int strIdx = maxIndex; strIdx <= nowIdx + k; strIdx++) {
                if(max < number.charAt(strIdx)) {
                    max = number.charAt(strIdx);
                    maxIndex = strIdx + 1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("1924", 2);
        System.out.println(result);
    }
}
