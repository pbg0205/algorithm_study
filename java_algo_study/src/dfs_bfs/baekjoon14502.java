package dfs_bfs;
/*
 * @problem     연구소(14502) : https://www.acmicpc.net/problem/14502
 * @author      pbg0205
 * @created by  09.25.20
 */

import java.io.*;
import java.util.*;

public class baekjoon14502 {

    private static int rowSize;
    private static int colSize;

    private static int[][] map;
    private static int[][] copied;
    private static List<Virus> virusList = new ArrayList<Virus>();

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        map = new int[rowSize][colSize];
        copied = new int[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < colSize; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                if(map[row][col] == 2){
                    virusList.add(new Virus(row, col));
                }
            }
        }

        setWall(0, 0);
        System.out.println(max);
        br.close();
    }

    // 백트래킹을 이용하여 3개의 벽 세우기
    static void setWall(int start, int depth) {
        if (depth == 3) {
            // 맵 복사
            copyMap();

            // 바이러스 퍼트리기
            for (Virus dot : virusList) {
                spreadVirus(dot.x, dot.y);
            }

            // 안전영역 크기 구하기
            max = Math.max(max, getSafeArea());
            return;
        }

        for (int i = start; i < rowSize * colSize; i++) {
            int x = i / colSize;
            int y = i % colSize;

            if (map[x][y] == 0) {
                map[x][y] = 1;
                setWall(i + 1, depth + 1);
                map[x][y] = 0;
            }
        }
    }

    // 기존 맵을 유지하기 위해 바이러스 퍼트릴 맵 복사하기
    static void copyMap() {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                copied[row][col] = map[row][col];
            }
        }
    }

    // DFS 로 바이러스 퍼트리기
    static void spreadVirus(int x, int y) {
        for (int idx = 0; idx < 4; idx++) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if (isBoundary(nx, ny)) {
                if (copied[nx][ny] == 0) {
                    copied[nx][ny] = 2;
                    spreadVirus(nx, ny);
                }
            }
        }
    }

    private static boolean isBoundary(int nx, int ny) {
        return 0 <= nx && nx < rowSize && 0 <= ny && ny < colSize;
    }

    static int getSafeArea() {
        int safe = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (copied[row][col] == 0)
                    safe++;
            }
        }
        return safe;
    }
}

class Virus {
    int x;
    int y;
    Virus(int x, int y){
        this.x = x;
        this.y = y;
    }
}
