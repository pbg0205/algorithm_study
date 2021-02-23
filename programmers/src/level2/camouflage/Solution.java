package programmers.src.level2.camouflage;

import java.util.*;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.putIfAbsent(clothe[1], 1);
            map.computeIfPresent(clothe[1], (k,v) -> v + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue();
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int result = solution.solution(clothes);
        System.out.println(result);
    }
}
