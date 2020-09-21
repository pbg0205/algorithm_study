package bruteforce.baekjoon;

/*
 * @Problem    스타트와 링크(14889)       https://www.acmicpc.net/problem/14889
 * @Author      pbg0205
 * @Created by  09.19.20
 *
 */

import java.io.*;
import java.util.*;

public class baekjoon14889_bitmask1 {

    static int n;

    static int[][] map;
    static boolean[] isStartTeam;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = toInt(br.readLine());
        //1. 데이터 입력
        map = new int[n][n];
        isStartTeam = new boolean[n];
        /*
         * isStartTeam 배열 설명
         *  - isStartTeam[i] = true; // startTeam
         *  - isStartTeam[i] = false;// LinkTeam
         */

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                map[row][col] = toInt(st.nextToken());
            }
        }

        int set = (1 << n) - 1;//집합 1111(2)

        for (int subSet = set; subSet > 0; subSet = ((subSet - 1) & set)) { /* 전체 집합 중, 부분 집합 순회 */
            if (Integer.bitCount(subSet) == n / 2) {/*팀원을 결정 결정된 경우*/

                for (int idx = 0; idx < n; idx++) { /*전체 인덱스(0<= idx < n)에서 */
                    if (((1 << idx) & subSet) > 0) {/*부분 집합에 원소가 포함된다면 */
                        isStartTeam[idx] = true;   /*startTeam으로 분류*/
                    }
                }
                min = getMinValue();
                Arrays.fill(isStartTeam, false);
            }
        }
        System.out.println(min);

        br.close();
    }

    private static int getMinValue() {
        int sumOfStart = 0;
        int sumOfLink = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isStartTeam[i] != isStartTeam[j]) {/* 서로 다른 팀일 경우*/
                    continue;
                }

                if (isStartTeam[i]) {
                    sumOfStart += map[i][j];
                    sumOfStart += map[j][i];
                }

                if (!isStartTeam[i]) {
                    sumOfLink += map[i][j];
                    sumOfLink += map[j][i];

                }
            }
        }
        int diffrence = Math.abs(sumOfStart - sumOfLink);

        return Math.min(min, diffrence);
    }

    private static int toInt(String number) {
        return Integer.parseInt(number);
    }
}
