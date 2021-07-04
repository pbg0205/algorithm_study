package programmers.src.level2.best_album;

import java.util.*;

public class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> genreSumMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreSumMap.put(genres[i], genreSumMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> sortedGenreList = new ArrayList<>(genreSumMap.keySet());
        sortedGenreList.sort((o1, o2) -> (genreSumMap.get(o2).compareTo(genreSumMap.get(o1))));

        for (String genre : sortedGenreList) {
            int firstIndex = 0;
            int secondIndex = 0;
            int max = 0;

            for (int j = 0; j < genres.length; j++) {
                if (genre.equals(genres[j]) && plays[j] > max) {
                    max = plays[j];
                    firstIndex = j;
                }
            }

            max = -1;
            for (int j = 0; j < genres.length; j++) {
                if (genre.equals(genres[j]) && max < plays[j] && j != firstIndex) {
                    max = plays[j];
                    secondIndex = j;
                }
            }

            answer.add(firstIndex);

            if (max != -1) {
                answer.add(secondIndex);
            }
        }

        return answer;
    }
}
