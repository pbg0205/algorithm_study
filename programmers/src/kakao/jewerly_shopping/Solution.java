package kakao.jewerly_shopping;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private static final Set<String> set = new HashSet<>();
    private static final Map<String, Integer> map = new HashMap<>();

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        for (String gem : gems) {
            if (!set.contains(gem)) {
                set.add(gem);
            }
        }

        int start = 0;
        int end = 0;

        int nowLength;
        int minLength = gems.length;
        int minStartIndex = gems.length;

        if (set.size() == 1) {
            return new int[]{1, 1};
        }

        while (start < gems.length) {
            nowLength = end - start + 1;
            if (nowLength > minLength || end == gems.length) {
                if (map.get(gems[start]) == 1) {//막혔던 부분
                    map.remove(gems[start]);
                } else {
                    map.put(gems[start], map.get(gems[start]) - 1);
                }
                start++;
            } else {
                if (!map.containsKey(gems[end])) {
                    map.put(gems[end], 1);
                } else {
                    map.put(gems[end], map.get(gems[end]) + 1);
                }
                end++;
            }

            if (map.size() == set.size()) {
                if(end - start < minLength) {
                    minLength = end - start; // 막혔던 부분
                    minStartIndex = start;
                }
                if(nowLength == minLength) {
                    if(minStartIndex > start) {
                        minStartIndex = start;
                    }
                }
            }
        }

        answer[0] = minStartIndex + 1;
        answer[1] = answer[0] + minLength - 1;

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] result = solution.solution(gems);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
