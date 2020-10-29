package baekjoon1261;

import java.io.*;
import java.util.*;

/*
 * @problem     알고스팟(1261)
 * @url         https://www.acmicpc.net/problem/1261
 * @author      pbg0205
 * @created by  10.29.20
 */

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
        int[][] map = makeMazeMap(point);
        int[][] brokenCount = makeBrokenCountMap(point);

        return bfs(map, brokenCount);
    }

    private static int[][] makeBrokenCountMap(Point point) {
        int row = point.x;
        int col = point.y;

        int[][] minMap = new int[row][col];

        minMap = fillINF(minMap);

        return minMap;
    }

    private static int[][] fillINF(int[][] minMap) {
        final int INF = 100_000_000;

        for (int row = 0; row < minMap.length; row++) {
            for (int col = 0; col < minMap[row].length; col++) {
                minMap[row][col] = INF;
            }
        }

        return minMap;
    }

    //TODO : 기능별 리팩토링
    private static int bfs(int[][] map, int[][] brokenCount) {
        int minValue = Integer.MAX_VALUE;

        final int MAX_DIRECTION_VALUE = 4;
        int[] dx = {1, 0,-1, 0};
        int[] dy = {0, 1, 0,-1};

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, 0));

        brokenCount[0][0] = 0;

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            
            if (now.x == row - 1 && now.y == col - 1) {
                minValue = now.cost;
            }

            for (int index = 0; index < MAX_DIRECTION_VALUE; index++) {
                int nx = now.x + dx[index];
                int ny = now.y + dy[index];

                if (isBoundary(nx, ny)) {
                    if(brokenCount[nx][ny] > brokenCount[now.x][now.y] + map[nx][ny]){
                        brokenCount[nx][ny] = brokenCount[now.x][now.y] + map[nx][ny];
                        pq.offer(new Point(nx, ny, brokenCount[nx][ny]));
                    }
                }
            }
        }

        return minValue;
    }

    private static boolean isBoundary(int x, int y) {
        return ((0 <= x && x < row) && (0 <= y && y < col));
    }

    private static int[][] makeMazeMap(Point point) throws IOException {
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
        int[] arr_tmp = new int[col] ;
        char colStatus;

        for (int index = 0; index < col; index++) {
            colStatus = rowStatus.charAt(index);
            arr_tmp[index] = colStatus - '0';
        }

        return arr_tmp;
    }
}

class Point implements Comparable<Point>{
    int x; //row
    int y; //col
    int cost;

    public Point(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Point other) {
        return this.cost - other.cost;
    }
}
