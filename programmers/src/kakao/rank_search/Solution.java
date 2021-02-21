package programmers.src.kakao.rank_search;

import java.util.*;

/*
 * @Problem     순위검색
 * @Url         https://programmers.co.kr/learn/courses/30/lessons/72412
 * @Author      pbg0205@naver.com
 * @Created by  2021.02.22
 * @ 시간초과.....
 */

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        List<Candidate> candidateList = new ArrayList<>();

        for (String s : info) {
            String[] temp = s.split(" ");
            System.out.println(temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[3] + " " + temp[4]);
            candidateList.add(new Candidate(temp[0], temp[1], temp[2], temp[3], temp[4]));
        }

        int index = 0;
        for (String s : query) {
            List<String> query_temp = new ArrayList<>();
            query_temp.addAll(Arrays.asList(s.split(" and ")));

            String soulAndScore = query_temp.remove(query_temp.size() - 1);
            String[] temp = soulAndScore.split(" ");
            query_temp.add(temp[0]);
            query_temp.add(temp[1]);

            String[] queries = new String[5];
            getCount(candidateList, query_temp.toArray(queries), answer, index);
            index++;
        }

        return answer;
    }

    private void getCount(List<Candidate> candidateList, String[] query_temp, int[] answer, int index) {
        String query_language = query_temp[0].equals("-") ? "cpp, java, python" : query_temp[0];
        String query_type = query_temp[1].equals("-") ? "backend frontend" : query_temp[1];
        String query_career = query_temp[2].equals("-") ? "junior senior" : query_temp[2];
        String query_soulFood = query_temp[3].equals("-") ? "pizza, chicken" : query_temp[3];
        int query_score = query_temp[4].equals("-") ? 0 : Integer.parseInt(query_temp[4]);

        answer[index] = (int) candidateList.stream()
                .filter(candidate -> query_language.contains(candidate.language))
                .filter(candidate -> query_type.contains(candidate.type))
                .filter(candidate -> query_career.contains(candidate.career))
                .filter(candidate -> query_soulFood.contains(candidate.soulFood))
                .filter(candidate -> candidate.score >= query_score)
                .count();
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

class Candidate {
    String language;
    String type;
    String career;
    String soulFood;
    int score;

    public Candidate(String language, String type, String career, String soulFood, String score) {
        this.language = language;
        this.type = type;
        this.career = career;
        this.soulFood = soulFood;
        this.score = score.equals("-") ? -1 : Integer.parseInt(score);
    }
}
