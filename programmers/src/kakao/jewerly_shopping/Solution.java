package kakao.jewerly_shopping;

import java.util.*;

public class Solution {
    private final Set<String> set = new HashSet<>();
    private final Map<String, Integer> map = new HashMap<>();
    private static int MIN_LENGTH;
    private static int MIN_START_INDEX;


    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        initSet(gems);

        int start = 0;
        int end = 0;

        int nowLength;
        MIN_LENGTH = gems.length;
        MIN_START_INDEX = gems.length;

        if (set.size() == 1) {
            return new int[]{1, 1};
        }

        while (start < gems.length) {
            nowLength = end - start + 1;
            if (nowLength > MIN_LENGTH || end == gems.length) {
                removeElement(gems[start]);
                start++;
            } else {
                addElement(gems[end]);
                end++;
            }

            if (containAlljewerlys()) {
                getMinLength(start, end);
                getMinIndex(start, nowLength);
            }
        }

        answer[0] = MIN_START_INDEX + 1;
        answer[1] = answer[0] + MIN_LENGTH - 1;

        return answer;
    }

    private void initSet(String[] gems) {
        for (String gem : gems) {
            if (!set.contains(gem)) {
                set.add(gem);
            }
        }
    }

    private boolean containAlljewerlys() {
        return map.size() == set.size();
    }

    private void getMinLength(int start, int end) {
        if (end - start < MIN_LENGTH) {
            MIN_LENGTH = end - start; // 막혔던 부분
            MIN_START_INDEX = start;
        }
    }

    private void getMinIndex(int start, int nowLength) {
        if (nowLength == MIN_LENGTH) {
            if (MIN_START_INDEX > start) {
                MIN_START_INDEX = start;
            }
        }
    }

    void removeElement(String element) {
        if (map.get(element) == 1) {//막혔던 부분
            map.remove(element);
        } else {
            map.put(element, map.get(element) - 1);
        }
    }

    void addElement(String element) {
        if (!map.containsKey(element)) {
            map.put(element, 1);
        } else {
            map.put(element, map.get(element) + 1);
        }
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
