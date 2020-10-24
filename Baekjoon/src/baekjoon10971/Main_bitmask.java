package baekjoon10971;

import java.io.*;
import java.util.*;

/*
 * @problem      외판원 순회2(10971) : https://www.acmicpc.net/problem/10971
 * @author       pbg0205
 * @created by   09.24.20
 */
class Main_bitmask {

    static int min = Integer.MAX_VALUE;
    static int n;
    static int finished;

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        finished = (1<<n) - 1;

        map = new int[n][n];

        StringTokenizer st;
        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n ; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        for (int start = 0; start < n; start++) {
            int visited = 1 << start;
            go(start, start, visited, 0);
        }

        bw.write(String.valueOf(min));
        br.close();
        bw.flush();
        bw.close();
    }

    private static void go(int start, int now, int visited, int sum) {
        if (visited == finished){
            if(map[now][start] == 0){
                return ;
            }
            sum += map[now][start];
            min = Math.min(sum, min);
            return;
        }

        for(int next = 0; next < n; next++){
            if(((1<<next) & visited) > 0){
                continue;
            }
            if(now == next || map[now][next] == 0){
                continue;
            }

            go(start ,next, visited | (1<<next), sum + map[now][next]);
        }
    }
}
