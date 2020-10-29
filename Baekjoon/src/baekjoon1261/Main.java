package baekjoon1261;

import java.io.*;
import java.util.*;

/*
 * @problem     알고스팟(1261)
 * @url         https://www.acmicpc.net/problem/1261
 * @author      pbg0205
 * @created by  10.29.20
 */

//TODO  메모리 초과 : bfs -> 다른 접근법 생각해보기
class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int row;
    static int col;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        Point endPoint = new Point(row, col, 0);
        System.out.println(minValueOfBrokenWall(endPoint));
    }

    private static int minValueOfBrokenWall(Point point) throws IOException {
        int[][] map = makeMap(point);
        int minValue = bfs(map);

        return minValue;
    }

    //TODO : 기능별 리팩토링
    private static int bfs(int[][] map) {
        int minValue = Integer.MAX_VALUE;

        final int MAX_DIRECTION_VALUE = 2;
        int[] dx = {1, 0};
        int[] dy = {0, 1};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            //TOOD : 위치에 대한 기저조건 찾기
            if (now.x == row - 1 && now.y == col - 1) {
                minValue = now.numberOfBrokenWall < minValue ? now.numberOfBrokenWall : minValue;
            }

            for (int index = 0; index < MAX_DIRECTION_VALUE; index++) {
                int nx = now.x + dx[index];
                int ny = now.y + dy[index];

                if (isBoundary(nx, ny)) {
                    if (map[nx][ny] == 1) {
                        queue.offer(new Point(nx, ny, now.numberOfBrokenWall + 1));
                    } else {
                        queue.offer(new Point(nx, ny, now.numberOfBrokenWall));
                    }
                }
            }
        }

        return minValue;
    }

    private static boolean isBoundary(int x, int y) {
        return ((0 <= x && x < row) && (0 <= y && y < col));
    }

    private static int[][] makeMap(Point point) throws IOException {
        int row = point.x;
        int col = point.y;

        return inputMap(row, col);
    }

    private static int[][] inputMap(int row, int col) throws IOException {
        int[][] map_tmp = new int[row][col];
        String rowStatus;

        for (int index = 0; index < row; index++) {
            rowStatus = br.readLine();
            map_tmp[index] = inputColumn(rowStatus, col);
        }

        return map_tmp;
    }

    private static int[] inputColumn(String rowStatus, int col) {
        int[] arr_tmp = new int[col];
        char colStatus;

        for (int index = 0; index < col; index++) {
            colStatus = rowStatus.charAt(index);
            arr_tmp[index] = colStatus - '0';
        }

        return arr_tmp;
    }
}

class Point {
    int x; //row
    int y; //col
    int numberOfBrokenWall;//TODO : 변수 capsulation에 대해서 한번 고민해보기

    public Point(int x, int y, int numberOfBrokenWall) {
        this.x = x;
        this.y = y;
        this.numberOfBrokenWall = numberOfBrokenWall;
    }
}
