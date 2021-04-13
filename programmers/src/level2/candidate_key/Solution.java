package programmers.src.level2.candidate_key;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;

        for (int col = 0; col < relation[0].length; col++) {
            Set<String> candidateSet = new HashSet<>();
            boolean isCandidateKey = true;

            for (int row = 0; row < relation.length; row++) {
                if (!candidateSet.contains(relation[row][col])) {
                    candidateSet.add(relation[row][col]);
                } else {
                    isCandidateKey = false;
                    break;
                }
            }

            if (isCandidateKey) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };

        Solution solution = new Solution();
        System.out.println(solution.solution(relation));
    }
}
