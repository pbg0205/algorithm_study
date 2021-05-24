package programmers.src.level2.top_of_hanoi;

import java.util.*;

class Solution {

    static int count = 1;
    static List<int[]> answer = new ArrayList<>();

    public List<int[]> solution(int n) {
        move(n, 1, 3,2);

        return answer;
    }

    private void move(int n, int from, int to, int other) {
        if (n == 0) {
            return;
        }

        count++;
        move(n - 1, from, other, to);

        answer.add(new int[]{from, to});

        count++;
        move(n - 1, other, to, from);
    }
}
