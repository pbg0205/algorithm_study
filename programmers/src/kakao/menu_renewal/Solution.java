package programmers.src.kakao.menu_renewal;

import java.util.*;

class Solution {
    Map<Integer, Map<String, Integer>> courseMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (int c : course) courseMap.put(c, new HashMap<>());

        for (String o : orders) {
            char[] order = o.toCharArray();

            Arrays.sort(order);
            perm(order, "", 0);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<Integer, Map<String, Integer>> map : courseMap.entrySet()) {
            List<Map.Entry<String, Integer>> courseList = new ArrayList<>(map.getValue().entrySet());
            if (courseList.size() == 0) continue;

            courseList.sort(Comparator.comparingInt(o -> o.getValue()));

            int idx = courseList.size() - 1;
            int max = Math.max(courseList.get(idx).getValue(), 2);

            while (idx >= 0 && courseList.get(idx).getValue() == max)
                list.add(courseList.get(idx--).getKey());
        }

        list.sort(null);
        return list.toArray(new String[0]);
    }

    void perm(char[] order, String course, int idx) {
        if (courseMap.containsKey(course.length())) {
            int len = course.length();
            courseMap.get(len).put(course, courseMap.get(len).getOrDefault(course, 0) + 1);
        }
        for (int i = idx; i < order.length; i++)
            perm(order, course + order[i], i + 1);

    }
}
