:ㅈㅂpackage programmers.src.level2.just_that_song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        music[] musics = new music[musicinfos.length]; // 곡 정보
        m = sheetReplace(m); // # -> 소문자
        ArrayList<music> list = new ArrayList<>();

        for (int i = 0; i < musicinfos.length; i++) {
            int hour = Integer.parseInt(musicinfos[i].substring(6, 8))
                    - Integer.parseInt(musicinfos[i].substring(0, 2));
            int minute = Integer.parseInt(musicinfos[i].substring(9, 11))
                    - Integer.parseInt(musicinfos[i].substring(3, 5));
            int len = hour * 60 + minute; // 음악 길이

            String title = musicinfos[i].split(",")[2];
            String sheet = sheetReplace(musicinfos[i].split(",")[3]);

            String play = "";
            if (sheet.length() < len) {
                int n1 = len / sheet.length(); // 몫
                int n2 = len % sheet.length(); // 나머지
                for (int j = 0; j < n1; j++)
                    play += sheet;
                play += sheet.substring(0, n2);
            } else
                play = sheet.substring(0, len);

            musics[i] = new music(title, play);

            if (play.contains(m))
                list.add(musics[i]);
        }
        // 재생된 시간이 긴 순으로 정렬
        Collections.sort(list, new Comparator<music>() {
            public int compare(music m1, music m2) {
                return m2.play.length() - m1.play.length();
            }
        });

        if (list.size() > 0)
            answer = list.get(0).title;
        else
            answer = "(None)";

        return answer;
    }

    String sheetReplace(String sheet) {
        return sheet.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f")
                .replaceAll("G#", "g").replaceAll("A#", "a");
    }

    static class music {
        String title;
        String play;

        music(String title, String play) {
            this.title = title;
            this.play = play;
        }
    }
}
