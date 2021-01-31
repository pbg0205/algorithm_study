package kakao.cross_bridge;

import java.util.Arrays;

/*
 * @Problem     : 징검다리 건너기
 * @Url         : https://programmers.co.kr/learn/courses/30/lessons/64062?language=java
 * @Author      : pbg0205
 * @Created by : 2021.01.31
 * //TODO O(n^2) 접근 실패 -> 다른 접근법 사용해서 풀기
 */
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int minOfStoneNumber = Arrays.stream(stones).min().getAsInt();
        stones = Arrays.stream(stones).map(stone -> stone - minOfStoneNumber).toArray();

        answer += minOfStoneNumber;

        // 2, 4, 5, 3, 2, 1, 4, 2, 5, 1
        //   +2,+1,-2,-1,-1, 3,-2,+3,-4
        while (true) {
            int jumpCount = 1;

            for (int index = 0; index < stones.length; index++) {
                if (stones[index] == 0) {
                    jumpCount++;
                    continue;
                }

                if (jumpCount > k) {
                    return answer;
                }

                stones[index] -= 1;
                jumpCount = 1;
            }

            answer++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(solution.solution(stones, 3));
    }
}
