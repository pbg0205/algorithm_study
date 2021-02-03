package kakao.cross_bridge;

import java.util.Arrays;

/*
 * @Problem     : 징검다리 건너기
 * @Url         : https://programmers.co.kr/learn/courses/30/lessons/64062?language=java
 * @Author      : pbg0205
 * @Created by : 2021.01.31
 *
 */
class Solution {
    public int solution(int[] stones, int k) {
        int minOfStoneNumber = Arrays.stream(stones).min().getAsInt();
        int maxOfStoneNumber = Arrays.stream(stones).max().getAsInt();

        return binarySearch(stones, k, minOfStoneNumber, maxOfStoneNumber);
    }

    private int binarySearch(int[] stones, int k, int low, int high) {
        if(low == high) {
            return low;
        }

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(canJump(stones, k, mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low - 1;
    }

    private boolean canJump(int[] stones, int k, int mid) {
        int jumpCount = 0;

        for (int stone : stones) {
            if(stone - mid < 0) {
                jumpCount++;
            } else {
                jumpCount = 0;
            }

            if(jumpCount >= k) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(solution.solution(stones, 3));
    }
}
