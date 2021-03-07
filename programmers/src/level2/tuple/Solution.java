package programmers.src.level2.tuple;

import java.util.*;

public class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        System.out.println(s);

        String[] tempArr = s.split("-");
        Arrays.sort(tempArr, (a, b) -> Integer.compare(a.length(), b.length()));

        List<Integer> list = new ArrayList<>();
        for (String temp : tempArr) {
            String[] values = temp.split(",");

            for (String value : values) {
                int number = Integer.valueOf(value);

                if (!list.contains(number)) {
                    list.add(number);
                }
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        for (int result : solution.solution(s)) {
            System.out.println(result);
        }
    }
}
