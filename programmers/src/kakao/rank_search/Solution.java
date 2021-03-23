package programmers.src.kakao.rank_search;

import java.util.*;

/*
 * @Problem     순위검색
 * @Url         https://programmers.co.kr/learn/courses/30/lessons/72412
 * @Author      pbg0205@naver.com
 * @Created by  2021.02.22
 */

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> infos = new HashMap<>();

        init(infos, info);
        sortListInMap(infos);

        return parseData(infos, query);
    }

    private int[] parseData(Map<String, List<Integer>> infos, String[] queries) {
        int[] answer = new int[queries.length];
        List<Integer> empty = new ArrayList<>();

        int index = 0;
        for (String query : queries) {
            String[] split = query.replaceAll("-", "").split(" and | ");
            String key = String.join("", split[0], split[1], split[2], split[3]);
            int score = Integer.parseInt(split[4]);

            List<Integer> list = infos.getOrDefault(key, empty);
            answer[index++] = binarySearch(list, score);
        }

        return answer;
    }

    private int binarySearch(List<Integer> list, int score) {
        int start = 0, end = list.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (list.get(mid) < score) start = mid + 1;
            else end = mid;
        }

        return list.size() - start;
    }

    private void init(Map<String, List<Integer>> infos, String[] info) {
        for (String in : info) {
            String[] split = in.split(" ");
            int score = Integer.parseInt(split[4]);

            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder key = new StringBuilder();

                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) key.append(split[j]);
                }
                infos.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
            }
        }
    }

    private void sortListInMap(Map<String, List<Integer>> infos) {
        for (Map.Entry<String, List<Integer>> entry : infos.entrySet())
            entry.getValue().sort(null);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        int[] results = solution.solution(info, query);

        for (int result : results) {
            System.out.println(result);
        }
    }
}
