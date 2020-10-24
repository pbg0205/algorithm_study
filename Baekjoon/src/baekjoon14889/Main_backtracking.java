package baekjoon14889;

import java.io.*;
import java.util.*;

/*
 * @Problem    스타트와 링크(14889)       https://www.acmicpc.net/problem/14889
 * @Author      pbg0205
 * @Created by  09.19.20
 *
 */

class Main_backtracking {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] isTeam;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        isTeam = new boolean[N+1];

        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0);
        System.out.println(min);

        br.close();
    }

    private static void dfs(int start, int depth) {
        if(depth == N / 2){
            min = Math.min(min, getDifference());
            return ;
        }

        for (int idx = start; idx <= N; idx++) {
            if(!isTeam[idx]){
                isTeam[idx] = true;
                dfs(idx + 1, depth + 1);
                isTeam[idx] = false;
            }
        }
    }

    private static int getDifference() {
        int sumOfStart = 0;
        int sumOfLink = 0;

        for (int p1 = 1; p1 <= N ; p1++) {
            for (int p2 = p1 + 1; p2 <= N; p2++) {
                if(isTeam[p1] != isTeam[p2]){
                    continue;
                }

                if(isTeam[p2]){
                    sumOfStart += map[p1][p2];
                    sumOfStart += map[p2][p1];
                }

                if(!isTeam[p2]){
                    sumOfLink += map[p1][p2];
                    sumOfLink += map[p2][p1];
                }
            }
        }

        return Math.abs(sumOfStart - sumOfLink);
    }
}
