package dfs_bfs;
/*
 * @Problem     토마토(7576)   :   https://www.acmicpc.net/problem/7576
 * @Author      pbg0205
 * @Created by  09.20.20
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon7576 {

    static int M; //가로 길이
    static int N; //세로 길이
    static int[][] map;
    static int ans = 0;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. 데이터 탐색
        M = toInt(st.nextToken());
        N = toInt(st.nextToken());

        map = new int[N][M];

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                map[row][col] = toInt(st.nextToken());
            }
        }
        //2. bfs 탐색
        bfs();
        //3. ans 탐색
        ans = !hasZero() ? ans : -1;/*hasZero*/
        System.out.println(ans);

        br.close();
    }
    /*map배열에서 0이 존재하지는 확인하는 함수*/
    private static boolean hasZero() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (map[row][col] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    private static void bfs() {
        Queue<Tomato> queue = new LinkedList<>();

        //1. 토마토의 위치 탐색
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (map[row][col] == 1) {
                    queue.offer(new Tomato(row, col, 0));
                }
            }
        }

        while (!queue.isEmpty()) {

            Tomato tomato = queue.poll();

            for (int idx = 0; idx < 4; idx++) {

                int nx = tomato.x + dx[idx];
                int ny = tomato.y + dy[idx];

                if (isBoundary(nx, ny) && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    queue.offer(new Tomato(nx, ny, tomato.days+1));
                    ans = Math.max(ans, tomato.days) + 1;
                }
            }
        }
    }
    private static boolean isBoundary(int x, int y) {
        return ((0 <= x && x < N) && (0 <= y && y < M));
    }
    private static int toInt(String value){
        return Integer.parseInt(value);
    }
}

class Tomato {
    int x;
    int y;
    int days;

    Tomato(int x, int y, int days) {
        this.x = x;
        this.y = y;
        this.days = days;
    }
}