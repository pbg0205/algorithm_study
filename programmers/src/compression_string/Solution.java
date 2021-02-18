package programmers.src.compression_string;

/*
 * @problem     문자열 압축
 * @url         https://programmers.co.kr/learn/courses/30/lessons/60057
 * @author      pbg0205@naver.com
 * @created by  2021.02.18
 */
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for(int len = 1 ; len < s.length() ; ++len){
            StringBuilder compressed = new StringBuilder();
            String current;
            String target;

            int cnt = 1;

            // 첫 번쨰 단위 지정
            target = s.substring(0, len);

            // 단위만큼 잘랐을 때 각 부분의 시작 인덱스
            for(int i = len ; i < s.length() ; i += len){
                current = "";

                for(int j = i ; j < i + len ; ++j){
                    if(j >= s.length()) break;
                    current += s.charAt(j);
                }

                if(target.equals(current)){
                    cnt++;
                } else {
                    if(cnt > 1){
                        compressed.append(cnt + target);
                    } else {
                        compressed.append(target);
                    }
                    cnt = 1;
                    target = current;
                }
            }

            if(cnt > 1){
                compressed.append(cnt).append(target);
            } else {
                compressed.append(target);
            }

            int length = compressed.length();
            answer = answer > length ? length : answer;
        }

        if(answer == Integer.MAX_VALUE) answer = 1;

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aabbaccc";
        System.out.println(solution.solution(s));
    }
}
