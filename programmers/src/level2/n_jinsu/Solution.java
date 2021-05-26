package programmers.src.level2.n_jinsu;

public class Solution {
    public String solution(int n, int t, int m, int p) { // n진법, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p

        StringBuilder answer = new StringBuilder("");
        StringBuilder binaryStr = new StringBuilder("0"); // 0부터 시작하기 때문에 0을 미리 넣어놓는다.

        String[] alpaForMoreThan10 = {"A", "B", "C", "D", "E", "F"}; // 16진수일 경우에 바꿔줄 알파벳들

        int num = 1;

        while (binaryStr.length() - 1 < t * m) { // 미리 구할 숫자의 갯수 * 인원의 길이까지 답이 나올만큼 반복한다.

            StringBuilder subBinarys = new StringBuilder("");
            int quot = num; // 몫
            int remain; // 나머지

            while (quot > 0) {
                remain = quot % n;
                quot = quot / n;

                if (remain >= 10 && remain <= 15) { // 알파벳으로 바꿔야 하는 경우
                    subBinarys.append(alpaForMoreThan10[remain - 10]);
                } else {
                    subBinarys.append(remain);
                }
            }
            binaryStr.append(subBinarys.reverse());
            num++;
        }

        int tubePlace = p;

        for (int i = 0; i < t; i++) {
            answer.append(binaryStr.charAt(tubePlace - 1));
            tubePlace += m; // 튜브 차례
        }

        return answer.toString();
    }
}
