package baekjoon14500;

/*
 * @Problem     테트로미노(14500) https://www.acmicpc.net/problem/14500
 * @Author      pbg0205
 * @Created by  09.16.20
 *
 */

import java.io.*;
import java.util.*;

class Main {
    static int height, width;
    static int ans = 0;

    static int map[][];
    static boolean visited[][];

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = getBufferedReader();
        StringTokenizer st = getStrTokenizer(br.readLine());

        height = toInt(st.nextToken());
        width = toInt(st.nextToken());

        map = new int[height][width];
        visited = new boolean[height][width];

        for (int row = 0; row <height; row++) {
            st = getStrTokenizer(br.readLine());
            for (int col = 0; col < width; col++) {
                map[row][col] = toInt(st.nextToken());
            }
        }

        for (int row = 0; row <height; row++) {
            for (int col = 0; col < width; col++) {
                getMaxByShape(row, col, 0, 1);
                getMaxByExceptShape(row, col);
            }
        }

        System.out.println(ans);
    }

    private static int toInt(String number) {
        return Integer.parseInt(number);
    }

    private static BufferedReader getBufferedReader(){
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static StringTokenizer getStrTokenizer(String str){
        return new StringTokenizer(str);
    }

    /* ㅗ 제외 모양 탐색 함수(dfs)*/
    private static void getMaxByShape(int row, int col, int sum, int depth){
        if(depth > 4){
            ans = Math.max(ans, sum);
            return ;
        }

        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if(isBoundary(nx, ny) && !visited[nx][ny]){
                getMaxByShape(nx, ny, sum + map[nx][ny], depth + 1);
            }
        }

        visited[row][col] = false;
    }
    /* ㅗ 모양 탐색 함수*/
    private static void getMaxByExceptShape(int row, int col) {

        int sum = map[row][col];
        int min = Integer.MAX_VALUE;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (isBoundary(nx, ny)) {
                sum += map[nx][ny];
                cnt += 1;
                min = Math.min(min, map[nx][ny]);
            }
        }
        if (cnt > 4)
            sum -= min;

        ans = Math.max(ans, sum);

    }
    /*현재 위치가 map범위 내에 있는지 확인하는 함수*/
    private static boolean isBoundary(int row, int col){
        return (0 <= row && row < height) && (0 <= col && col < width);
    }
}
