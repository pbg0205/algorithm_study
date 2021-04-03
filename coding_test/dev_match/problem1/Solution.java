package coding_test.dev_match.problem1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {
        final int MAX_NUM = 6;

        Set<Integer> lottoSet = new HashSet<>();
        Set<Integer> winSet = new HashSet<>();

        int zeroCount = 0;
        int count = 0;

        for (int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
            }
        }

        for (Integer lottoNum : lottos) {
            lottoSet.add(lottoNum);
        }

        for (Integer winNum : win_nums) {
            winSet.add(winNum);
        }

        for (Integer lottoNum : lottoSet) {
            if(winSet.contains(lottoNum)) {
                count++;
            }
        }

        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i <= zeroCount; i++) {
            int matchCount = i + count - 1 >= 0 ? i + count - 1 : 0;
            answerList.add(MAX_NUM - matchCount);
        }

        int[] answer = new int[2];

        answer[0] = answerList.get(answerList.size() - 1);
        answer[1] = answerList.get(0);

        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] result = new Solution().solution(lottos, win_nums);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
