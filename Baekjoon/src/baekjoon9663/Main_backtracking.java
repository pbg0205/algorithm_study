package baekjoon9663;

import java.io.*;
/*
 * @Problem     N-Queen(9663) :https://www.acmicpc.net/problem/9663
 * @Author      pbg0205
 * @Created by   09.18.20
 *
 */


class Main_backtracking {

    static int answer = 0;
    static int N;
    /*
     * @index
     * - 열(col)의 위치
     * @value
     * - 행(row)의 위치
     */
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            map = new int[N+1];
            map[1] = i;//행 위치 추가 후, 탐색

            dfs(map, 1);
        }

        System.out.println(answer);

        br.close();
    }

    private static void dfs(int[] map, int col) {
        if (col == N){
            answer++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            map[col + 1] = i;
            if(isPossible(map, col+1)){
                dfs(map, col+1);
            }
        }
    }

    private static boolean isPossible(int[] map, int col) {
        for (int i = 1; i < col; i++) {
            if(isSameRowLocation(map, i, col)){//같은 행 관계 확인
                return false;
            }

            if(isDiagonalLocation(map, i, col)){//대각선 관계 확인
                return false;
            }
        }

        return true;
    }

    private static boolean isDiagonalLocation(int[] map, int i, int col) {
        return Math.abs(i - col) == Math.abs(map[i] - map[col]);
    }

    private static boolean isSameRowLocation(int[] map, int i, int col) {
        return map[i] == map[col];
    }
}
