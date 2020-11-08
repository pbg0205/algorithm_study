package baekjoon1018;

import java.io.*;
import java.util.*;

/*
 * @problem     체스판 다시 칠하기(1018)
 * @url         https://www.acmicpc.net/problem/1018
 * @author      pbg0205
 * @created by  11.08.20
 */
class Main {

    static boolean[][] map;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        map = new boolean[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            String line = br.readLine();
            for (int col = 0; col < colSize; col++) {
                if(line.charAt(col) == 'B'){
                    map[row][col] = true;
                }else{
                    map[row][col] = false;
                }
            }
        }

        int rowRange = rowSize - 7;
        int colRange = colSize - 7;

        for (int row = 0; row < rowRange; row++) {
            for (int col = 0; col < colRange; col++) {
                search(row, col);
            }
        }

        System.out.println(min);
    }

    private static void search(int x, int y) {
        int row_end = x + 8;
        int col_end = y + 8;
        int count = 0;

        boolean now_color = map[x][y];

        for (int row = x; row < row_end; row++) {
            for (int col = y; col < col_end; col++) {
                if(map[row][col] != now_color){
                    count++;
                }
                now_color = (!now_color);
            }
            now_color = (!now_color);
        }

        count = Math.min(count, 64- count);

        min = Math.min(min, count);
    }
}
