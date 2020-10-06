package baekjoon2098;

/*
 * @Problem     외판원 순회(2098) : https://www.acmicpc.net/problem/7568
 * @Author      pbg0205
 * @Created by  09.16.20
 *
 */

import java.io.*;
import java.util.*;

public class Main {

    static int[][] map = new int[16][16];
    static int[][] dp = new int[16][1<<16];
    static final int INF = Integer.MAX_VALUE - 1000000;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = toInt(br.readLine());

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = toInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1));

        br.close();
    }

    private static int tsp(int current, int visited) {
        //모든 지점을 방문한 경우
        if(visited == (1<<N) - 1){
            if(map[current][0] == 0){
                return INF;
            }
            return map[current][0];
        }

        //이미 계산했던 경우
        if(dp[current][visited] != 0){
            return dp[current][visited];
        }

        dp[current][visited] = INF;

        for (int i = 0; i < N; i++) {
            int next = (1<<i);
            //길이 없거나 방문한 경우
            if(map[current][i] == 0 || (visited & next) > 0){
                continue;
            }

            dp[current][visited] = Math.min(dp[current][visited], tsp(i, visited | next) + map[current][i]);
        }

        return dp[current][visited];
    }

    private static int toInt(String number){
        return Integer.parseInt(number);
    }
}
