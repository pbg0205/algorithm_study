package programmers.src.level2.string_compressed;

public class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        StringBuilder compressed = new StringBuilder();

        for (int len = 1; len < s.length(); len++) {
            String target;
            String current;

            int cnt = 1;

            target = s.substring(0, len);

            for (int i = len; i < s.length(); i += len) {
                current = "";

                for (int j = i; j < i + len; ++j) {
                    if (j >= s.length()) {
                        break;
                    }
                    current += s.charAt(j);
                }

                if (current.equals(target)) {
                    cnt++;
                    continue;
                }

                if (cnt > 1) {
                    compressed.append(cnt + current);
                } else {
                    compressed.append(current);
                }

                cnt = 1;
                target = current;
            }

            int length = compressed.length();
            answer = answer > length ? length : answer;
        }

        return answer;
    }
}
