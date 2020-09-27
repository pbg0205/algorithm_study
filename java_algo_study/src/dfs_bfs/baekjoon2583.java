package dfs_bfs;
/*
 * @problem     영역구하기(2583) : https://www.acmicpc.net/problem/2583
 * @author      pbg0205
 * @created by  09.27.20
 */

import java.io.*;
import java.util.*;

public class baekjoon2583 {

    private static int colSize;
    private static int rowSize;

    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer> areaList = new ArrayList<>();

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        colSize = Integer.parseInt(st.nextToken());//y
        rowSize = Integer.parseInt(st.nextToken());//x
        int numberOfSquare = Integer.parseInt(st.nextToken());

        map = new int[rowSize][colSize];
        visited = new boolean[rowSize][colSize];

        for (int squareNum = 1; squareNum <= numberOfSquare; squareNum++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            divideArea(x1, y1, x2, y2);
        }

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (!visited[row][col] && map[row][col] == 0) {
                    areaList.add(bfs(row, col));
                }
            }
        }

        Collections.sort(areaList);

        sb.append(areaList.size()).append("\n");
        for (int area : areaList) {
            sb.append(area + " ");
        }
        System.out.println(sb.toString());

        br.close();
    }

    private static int bfs(int x, int y) {
        Queue<SquareLocation> queue = new LinkedList<>();
        queue.offer(new SquareLocation(x, y));
        visited[x][y] = true;

        int area = 1;

        while (!queue.isEmpty()) {
            SquareLocation now = queue.poll();

            for (int idx = 0; idx < 4; idx++) {
                int nx = now.x + dx[idx];
                int ny = now.y + dy[idx];

                if (isBoundary(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new SquareLocation(nx, ny));
                    area++;
                }
            }
        }

        return area;
    }

    private static boolean isBoundary(int x, int y) {
        return ((0 <= x && x < rowSize) && (0 <= y && y < colSize));
    }

    private static void divideArea(int x1, int y1, int x2, int y2) {
        for (int row = x1; row < x2; row++) {
            for (int col = y1; col < y2; col++) {
                map[row][col] = 1;
            }
        }
    }
}

class SquareLocation {
    int x;
    int y;

    SquareLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
