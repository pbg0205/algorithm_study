package programmers.src.level2.file_name_sort;

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            //1. 숫자를 기준으로 split을 한다.
            String prevString = o1.split("[0-9]")[0];
            String nextString = o2.split("[0-9]")[0];

            //2. 대소문자에 관계없이 값을 비교한다.
            int result = prevString.toLowerCase(Locale.ROOT)
                    .compareTo(nextString.toLowerCase(Locale.ROOT));

            //3. 같은 경우 숫자를 비교해서 대소 비교의 결과를 반환한다.
            if(result == 0) {
                result = extractNumber(o1, prevString) - extractNumber(o2, nextString);
            }

            return result;
        });

        return files;
    }

    private int extractNumber(String s, String h ) {
        s = s.replace(h, "");

        StringBuilder sb = new StringBuilder();

        for( char c : s.toCharArray()) {
            if( Character.isDigit(c) && sb.length() < 5 ) {
                sb.append(c);
            }else
                break;
        }
        return Integer.valueOf(sb.toString());
    }
}
